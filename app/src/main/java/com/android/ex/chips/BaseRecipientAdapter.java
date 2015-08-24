package com.android.ex.chips;

import android.accounts.Account;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Handler;
import android.os.Message;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.text.util.Rfc822Token;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import android.widget.Filterable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class BaseRecipientAdapter extends BaseAdapter
  implements Filterable, PhotoManager.PhotoManagerCallback
{
  private Account mAccount;
  private final ContentResolver mContentResolver;
  private final Context mContext;
  protected CharSequence mCurrentConstraint;
  private final DelayedMessageHandler mDelayedMessageHandler = new DelayedMessageHandler(null);
  private DropdownChipLayouter mDropdownChipLayouter;
  private List<RecipientEntry> mEntries;
  private EntriesUpdatedObserver mEntriesUpdatedObserver;
  private LinkedHashMap<Long, List<RecipientEntry>> mEntryMap;
  private Set<String> mExistingDestinations;
  private List<RecipientEntry> mNonAggregatedEntries;
  private PhotoManager mPhotoManager;
  protected final int mPreferredMaxResultCount;
  private final Queries.Query mQueryMode;
  private final int mQueryType;
  private int mRemainingDirectoryCount;
  private List<RecipientEntry> mTempEntries;

  public BaseRecipientAdapter(Context paramContext)
  {
    this(paramContext, 10, 0);
  }

  public BaseRecipientAdapter(Context paramContext, int paramInt1, int paramInt2)
  {
    mContext = paramContext;
    mContentResolver = paramContext.getContentResolver();
    mPreferredMaxResultCount = paramInt1;
    mPhotoManager = new DefaultPhotoManager(mContentResolver);
    mQueryType = paramInt2;
    if (paramInt2 == 0)
    {
      mQueryMode = Queries.EMAIL;
      return;
    }
    if (paramInt2 == 1)
    {
      mQueryMode = Queries.PHONE;
      return;
    }
    mQueryMode = Queries.EMAIL;
    Log.e("BaseRecipientAdapter", "Unsupported query type: " + paramInt2);
  }

  private List<RecipientEntry> constructEntryList(LinkedHashMap<Long, List<RecipientEntry>> paramLinkedHashMap, List<RecipientEntry> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    paramLinkedHashMap = paramLinkedHashMap.entrySet().iterator();
    int j;
    do
    {
      j = i;
      if (!paramLinkedHashMap.hasNext())
        break;
      List localList = (List)((Map.Entry)paramLinkedHashMap.next()).getValue();
      int m = localList.size();
      int k = 0;
      j = i;
      i = k;
      while (i < m)
      {
        RecipientEntry localRecipientEntry = (RecipientEntry)localList.get(i);
        localArrayList.add(localRecipientEntry);
        mPhotoManager.populatePhotoBytesAsync(localRecipientEntry, this);
        j += 1;
        i += 1;
      }
      i = j;
    }
    while (j <= mPreferredMaxResultCount);
    if (j <= mPreferredMaxResultCount)
      paramLinkedHashMap = paramList.iterator();
    while (true)
    {
      if (paramLinkedHashMap.hasNext())
      {
        paramList = (RecipientEntry)paramLinkedHashMap.next();
        if (j <= mPreferredMaxResultCount);
      }
      else
      {
        return localArrayList;
      }
      localArrayList.add(paramList);
      mPhotoManager.populatePhotoBytesAsync(paramList, this);
      j += 1;
    }
  }

  private Cursor doQuery(CharSequence paramCharSequence, int paramInt, Long paramLong)
  {
    paramCharSequence = mQueryMode.getContentFilterUri().buildUpon().appendPath(paramCharSequence.toString()).appendQueryParameter("limit", String.valueOf(paramInt + 5));
    if (paramLong != null)
      paramCharSequence.appendQueryParameter("directory", String.valueOf(paramLong));
    if (mAccount != null)
    {
      paramCharSequence.appendQueryParameter("name_for_primary_account", mAccount.name);
      paramCharSequence.appendQueryParameter("type_for_primary_account", mAccount.type);
    }
    System.currentTimeMillis();
    paramCharSequence = mContentResolver.query(paramCharSequence.build(), mQueryMode.getProjection(), null, null, null);
    System.currentTimeMillis();
    return paramCharSequence;
  }

  private static void putOneEntry(TemporaryEntry paramTemporaryEntry, boolean paramBoolean, LinkedHashMap<Long, List<RecipientEntry>> paramLinkedHashMap, List<RecipientEntry> paramList, Set<String> paramSet)
  {
    if (paramSet.contains(destination))
      return;
    paramSet.add(destination);
    if (!paramBoolean)
    {
      paramList.add(RecipientEntry.constructTopLevelEntry(displayName, displayNameSource, destination, destinationType, destinationLabel, contactId, directoryId, dataId, thumbnailUriString, true, lookupKey));
      return;
    }
    if (paramLinkedHashMap.containsKey(Long.valueOf(contactId)))
    {
      ((List)paramLinkedHashMap.get(Long.valueOf(contactId))).add(RecipientEntry.constructSecondLevelEntry(displayName, displayNameSource, destination, destinationType, destinationLabel, contactId, directoryId, dataId, thumbnailUriString, true, lookupKey));
      return;
    }
    paramList = new ArrayList();
    paramList.add(RecipientEntry.constructTopLevelEntry(displayName, displayNameSource, destination, destinationType, destinationLabel, contactId, directoryId, dataId, thumbnailUriString, true, lookupKey));
    paramLinkedHashMap.put(Long.valueOf(contactId), paramList);
  }

  public static List<DirectorySearchParams> setupOtherDirectories(Context paramContext, Cursor paramCursor, Account paramAccount)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    ArrayList localArrayList = new ArrayList();
    paramContext = null;
    while (paramCursor.moveToNext())
    {
      long l = paramCursor.getLong(0);
      if (l != 1L)
      {
        DirectorySearchParams localDirectorySearchParams = new DirectorySearchParams();
        String str = paramCursor.getString(4);
        int i = paramCursor.getInt(5);
        localDirectorySearchParams.directoryId = l;
        localDirectorySearchParams.displayName = paramCursor.getString(3);
        localDirectorySearchParams.accountName = paramCursor.getString(1);
        localDirectorySearchParams.accountType = paramCursor.getString(2);
        if ((str != null) && (i != 0));
        try
        {
          localDirectorySearchParams.directoryType = localPackageManager.getResourcesForApplication(str).getString(i);
          if (localDirectorySearchParams.directoryType == null)
            Log.e("BaseRecipientAdapter", "Cannot resolve directory name: " + i + "@" + str);
          if ((paramAccount != null) && (paramAccount.name.equals(localDirectorySearchParams.accountName)) && (paramAccount.type.equals(localDirectorySearchParams.accountType)))
            paramContext = localDirectorySearchParams;
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException)
        {
          while (true)
            Log.e("BaseRecipientAdapter", "Cannot resolve directory name: " + i + "@" + str, localNameNotFoundException);
          localArrayList.add(localDirectorySearchParams);
        }
      }
    }
    if (paramContext != null)
      localArrayList.add(1, paramContext);
    return localArrayList;
  }

  protected void cacheCurrentEntries()
  {
    mTempEntries = mEntries;
  }

  protected void clearTempEntries()
  {
    mTempEntries = null;
  }

  protected List<RecipientEntry> constructEntryList()
  {
    return constructEntryList(mEntryMap, mNonAggregatedEntries);
  }

  protected void fetchPhoto(RecipientEntry paramRecipientEntry, PhotoManager.PhotoManagerCallback paramPhotoManagerCallback)
  {
    mPhotoManager.populatePhotoBytesAsync(paramRecipientEntry, paramPhotoManagerCallback);
  }

  public boolean forceShowAddress()
  {
    return false;
  }

  public Account getAccount()
  {
    return mAccount;
  }

  public Context getContext()
  {
    return mContext;
  }

  public int getCount()
  {
    List localList = getEntries();
    if (localList != null)
      return localList.size();
    return 0;
  }

  protected List<RecipientEntry> getEntries()
  {
    if (mTempEntries != null)
      return mTempEntries;
    return mEntries;
  }

  public Filter getFilter()
  {
    return new DefaultFilter(null);
  }

  public RecipientEntry getItem(int paramInt)
  {
    return (RecipientEntry)getEntries().get(paramInt);
  }

  public long getItemId(int paramInt)
  {
    return paramInt;
  }

  public int getItemViewType(int paramInt)
  {
    return ((RecipientEntry)getEntries().get(paramInt)).getEntryType();
  }

  public Map<String, RecipientEntry> getMatchingRecipients(Set<String> paramSet)
  {
    return null;
  }

  public void getMatchingRecipients(ArrayList<String> paramArrayList, RecipientAlternatesAdapter.RecipientMatchCallback paramRecipientMatchCallback)
  {
    RecipientAlternatesAdapter.getMatchingRecipients(getContext(), this, paramArrayList, getAccount(), paramRecipientMatchCallback);
  }

  public int getQueryType()
  {
    return mQueryType;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    RecipientEntry localRecipientEntry = (RecipientEntry)getEntries().get(paramInt);
    if (mCurrentConstraint == null);
    for (String str = null; ; str = mCurrentConstraint.toString())
      return mDropdownChipLayouter.bindView(paramView, paramViewGroup, localRecipientEntry, paramInt, DropdownChipLayouter.AdapterType.BASE_RECIPIENT, str);
  }

  public int getViewTypeCount()
  {
    return 1;
  }

  public boolean isEnabled(int paramInt)
  {
    return ((RecipientEntry)getEntries().get(paramInt)).isSelectable();
  }

  public void onPhotoBytesAsyncLoadFailed()
  {
  }

  public void onPhotoBytesAsynchronouslyPopulated()
  {
    notifyDataSetChanged();
  }

  public void onPhotoBytesPopulated()
  {
  }

  protected void putOneEntry(TemporaryEntry paramTemporaryEntry, boolean paramBoolean)
  {
    putOneEntry(paramTemporaryEntry, paramBoolean, mEntryMap, mNonAggregatedEntries, mExistingDestinations);
  }

  public void registerUpdateObserver(EntriesUpdatedObserver paramEntriesUpdatedObserver)
  {
    mEntriesUpdatedObserver = paramEntriesUpdatedObserver;
  }

  protected List<DirectorySearchParams> searchOtherDirectories(Set<String> paramSet)
  {
    List localList = null;
    if (mPreferredMaxResultCount - paramSet.size() > 0)
    {
      paramSet = mContentResolver.query(DirectoryListQuery.URI, DirectoryListQuery.PROJECTION, null, null, null);
      localList = setupOtherDirectories(mContext, paramSet, mAccount);
    }
    return localList;
  }

  public void setAccount(Account paramAccount)
  {
    mAccount = paramAccount;
  }

  public void setDropdownChipLayouter(DropdownChipLayouter paramDropdownChipLayouter)
  {
    mDropdownChipLayouter = paramDropdownChipLayouter;
    mDropdownChipLayouter.setQuery(mQueryMode);
  }

  protected void startSearchOtherDirectories(CharSequence paramCharSequence, List<DirectorySearchParams> paramList, int paramInt)
  {
    int j = paramList.size();
    int i = 1;
    while (i < j)
    {
      DirectorySearchParams localDirectorySearchParams = (DirectorySearchParams)paramList.get(i);
      localDirectorySearchParams.constraint = paramCharSequence;
      if (localDirectorySearchParams.filter == null)
        localDirectorySearchParams.filter = new DirectoryFilter(localDirectorySearchParams);
      localDirectorySearchParams.filter.setLimit(paramInt);
      localDirectorySearchParams.filter.filter(paramCharSequence);
      i += 1;
    }
    mRemainingDirectoryCount = (j - 1);
    mDelayedMessageHandler.sendDelayedLoadMessage();
  }

  protected void updateEntries(List<RecipientEntry> paramList)
  {
    mEntries = paramList;
    mEntriesUpdatedObserver.onChanged(paramList);
    notifyDataSetChanged();
  }

  private final class DefaultFilter extends Filter
  {
    private DefaultFilter()
    {
    }

    public CharSequence convertResultToString(Object paramObject)
    {
      Object localObject = (RecipientEntry)paramObject;
      paramObject = ((RecipientEntry)localObject).getDisplayName();
      localObject = ((RecipientEntry)localObject).getDestination();
      if ((TextUtils.isEmpty(paramObject)) || (TextUtils.equals(paramObject, (CharSequence)localObject)))
        return localObject;
      return new Rfc822Token(paramObject, (String)localObject, null).toString();
    }

    protected Filter.FilterResults performFiltering(CharSequence paramCharSequence)
    {
      Filter.FilterResults localFilterResults = new Filter.FilterResults();
      CharSequence localCharSequence = null;
      if (TextUtils.isEmpty(paramCharSequence))
      {
        clearTempEntries();
        return localFilterResults;
      }
      while (true)
      {
        LinkedHashMap localLinkedHashMap;
        ArrayList localArrayList;
        HashSet localHashSet;
        try
        {
          paramCharSequence = BaseRecipientAdapter.this.doQuery(paramCharSequence, mPreferredMaxResultCount, null);
          if (paramCharSequence == null)
          {
            if (paramCharSequence != null)
              paramCharSequence.close();
            if (0 == 0)
              break;
            throw new NullPointerException();
          }
          localCharSequence = paramCharSequence;
          localLinkedHashMap = new LinkedHashMap();
          localCharSequence = paramCharSequence;
          localArrayList = new ArrayList();
          localCharSequence = paramCharSequence;
          localHashSet = new HashSet();
          localCharSequence = paramCharSequence;
          if (paramCharSequence.moveToNext())
          {
            localCharSequence = paramCharSequence;
            BaseRecipientAdapter.putOneEntry(new BaseRecipientAdapter.TemporaryEntry(paramCharSequence, null), true, localLinkedHashMap, localArrayList, localHashSet);
            continue;
          }
        }
        finally
        {
          if (localCharSequence != null)
            localCharSequence.close();
          if (0 != 0)
            throw new NullPointerException();
        }
        localCharSequence = paramCharSequence;
        List localList = BaseRecipientAdapter.this.constructEntryList(localLinkedHashMap, localArrayList);
        localCharSequence = paramCharSequence;
        localFilterResults.values = new BaseRecipientAdapter.DefaultFilterResult(localList, localLinkedHashMap, localArrayList, localHashSet, searchOtherDirectories(localHashSet));
        localCharSequence = paramCharSequence;
        localFilterResults.count = localList.size();
      }
    }

    protected void publishResults(CharSequence paramCharSequence, Filter.FilterResults paramFilterResults)
    {
      mCurrentConstraint = paramCharSequence;
      clearTempEntries();
      if (paramFilterResults.values != null)
      {
        paramFilterResults = (BaseRecipientAdapter.DefaultFilterResult)paramFilterResults.values;
        BaseRecipientAdapter.access$302(BaseRecipientAdapter.this, paramFilterResults.entryMap);
        BaseRecipientAdapter.access$402(BaseRecipientAdapter.this, paramFilterResults.nonAggregatedEntries);
        BaseRecipientAdapter.access$502(BaseRecipientAdapter.this, paramFilterResults.existingDestinations);
        if ((paramFilterResults.entries.size() == 0) && (paramFilterResults.paramsList != null))
          cacheCurrentEntries();
        updateEntries(paramFilterResults.entries);
        if (paramFilterResults.paramsList != null)
        {
          int i = mPreferredMaxResultCount;
          int j = paramFilterResults.existingDestinations.size();
          startSearchOtherDirectories(paramCharSequence, paramFilterResults.paramsList, i - j);
        }
        return;
      }
      updateEntries(Collections.emptyList());
    }
  }

  private static class DefaultFilterResult
  {
    public final List<RecipientEntry> entries;
    public final LinkedHashMap<Long, List<RecipientEntry>> entryMap;
    public final Set<String> existingDestinations;
    public final List<RecipientEntry> nonAggregatedEntries;
    public final List<BaseRecipientAdapter.DirectorySearchParams> paramsList;

    public DefaultFilterResult(List<RecipientEntry> paramList1, LinkedHashMap<Long, List<RecipientEntry>> paramLinkedHashMap, List<RecipientEntry> paramList2, Set<String> paramSet, List<BaseRecipientAdapter.DirectorySearchParams> paramList)
    {
      entries = paramList1;
      entryMap = paramLinkedHashMap;
      nonAggregatedEntries = paramList2;
      existingDestinations = paramSet;
      paramsList = paramList;
    }
  }

  private final class DelayedMessageHandler extends Handler
  {
    private DelayedMessageHandler()
    {
    }

    public void handleMessage(Message paramMessage)
    {
      if (mRemainingDirectoryCount > 0)
        updateEntries(constructEntryList());
    }

    public void removeDelayedLoadMessage()
    {
      removeMessages(1);
    }

    public void sendDelayedLoadMessage()
    {
      sendMessageDelayed(obtainMessage(1, 0, 0, null), 1000L);
    }
  }

  protected class DirectoryFilter extends Filter
  {
    private int mLimit;
    private final BaseRecipientAdapter.DirectorySearchParams mParams;

    public DirectoryFilter(BaseRecipientAdapter.DirectorySearchParams arg2)
    {
      Object localObject;
      mParams = localObject;
    }

    public int getLimit()
    {
      try
      {
        int i = mLimit;
        return i;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }

    protected Filter.FilterResults performFiltering(CharSequence paramCharSequence)
    {
      Filter.FilterResults localFilterResults = new Filter.FilterResults();
      localFilterResults.values = null;
      localFilterResults.count = 0;
      if (!TextUtils.isEmpty(paramCharSequence))
      {
        ArrayList localArrayList = new ArrayList();
        CharSequence localCharSequence = null;
        try
        {
          paramCharSequence = BaseRecipientAdapter.this.doQuery(paramCharSequence, getLimit(), Long.valueOf(mParams.directoryId));
          if (paramCharSequence != null)
            while (true)
            {
              localCharSequence = paramCharSequence;
              if (!paramCharSequence.moveToNext())
                break;
              localCharSequence = paramCharSequence;
              localArrayList.add(new BaseRecipientAdapter.TemporaryEntry(paramCharSequence, Long.valueOf(mParams.directoryId)));
            }
        }
        finally
        {
          if (localCharSequence != null)
            localCharSequence.close();
        }
        if (paramCharSequence != null)
          paramCharSequence.close();
        if (!localArrayList.isEmpty())
        {
          localFilterResults.values = localArrayList;
          localFilterResults.count = localArrayList.size();
        }
      }
      return localFilterResults;
    }

    protected void publishResults(CharSequence paramCharSequence, Filter.FilterResults paramFilterResults)
    {
      mDelayedMessageHandler.removeDelayedLoadMessage();
      if (TextUtils.equals(paramCharSequence, mCurrentConstraint))
      {
        if (paramFilterResults.count > 0)
        {
          paramCharSequence = ((ArrayList)paramFilterResults.values).iterator();
          if (paramCharSequence.hasNext())
          {
            BaseRecipientAdapter.TemporaryEntry localTemporaryEntry = (BaseRecipientAdapter.TemporaryEntry)paramCharSequence.next();
            BaseRecipientAdapter localBaseRecipientAdapter = BaseRecipientAdapter.this;
            if (mParams.directoryId == 0L);
            for (boolean bool = true; ; bool = false)
            {
              localBaseRecipientAdapter.putOneEntry(localTemporaryEntry, bool);
              break;
            }
          }
        }
        BaseRecipientAdapter.access$710(BaseRecipientAdapter.this);
        if (mRemainingDirectoryCount > 0)
          mDelayedMessageHandler.sendDelayedLoadMessage();
        if ((paramFilterResults.count > 0) || (mRemainingDirectoryCount == 0))
          clearTempEntries();
      }
      updateEntries(constructEntryList());
    }

    public void setLimit(int paramInt)
    {
      try
      {
        mLimit = paramInt;
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
  }

  protected static class DirectoryListQuery
  {
    public static final String[] PROJECTION = { "_id", "accountName", "accountType", "displayName", "packageName", "typeResourceId" };
    public static final Uri URI = Uri.withAppendedPath(ContactsContract.AUTHORITY_URI, "directories");
  }

  public static final class DirectorySearchParams
  {
    public String accountName;
    public String accountType;
    public CharSequence constraint;
    public long directoryId;
    public String directoryType;
    public String displayName;
    public BaseRecipientAdapter.DirectoryFilter filter;
  }

  public static abstract interface EntriesUpdatedObserver
  {
    public abstract void onChanged(List<RecipientEntry> paramList);
  }

  protected static class TemporaryEntry
  {
    public final long contactId;
    public final long dataId;
    public final String destination;
    public final String destinationLabel;
    public final int destinationType;
    public final Long directoryId;
    public final String displayName;
    public final int displayNameSource;
    public final String lookupKey;
    public final String thumbnailUriString;

    public TemporaryEntry(Cursor paramCursor, Long paramLong)
    {
      displayName = paramCursor.getString(0);
      destination = paramCursor.getString(1);
      destinationType = paramCursor.getInt(2);
      destinationLabel = paramCursor.getString(3);
      contactId = paramCursor.getLong(4);
      directoryId = paramLong;
      dataId = paramCursor.getLong(5);
      thumbnailUriString = paramCursor.getString(6);
      displayNameSource = paramCursor.getInt(7);
      lookupKey = paramCursor.getString(8);
    }
  }
}
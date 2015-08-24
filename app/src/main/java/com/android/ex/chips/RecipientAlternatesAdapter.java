package com.android.ex.chips;

import android.accounts.Account;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.provider.ContactsContract.Contacts;
import android.text.TextUtils;
import android.text.util.Rfc822Token;
import android.text.util.Rfc822Tokenizer;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import java.util.ArrayList;
import java.util.ArrayList<Ljava.lang.String;>;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RecipientAlternatesAdapter extends CursorAdapter
{
  private static final Map<String, String> sCorrectedPhotoUris = new HashMap();
  private OnCheckedItemChangedListener mCheckedItemChangedListener;
  private int mCheckedItemPosition = -1;
  private final long mCurrentId;
  private final Long mDirectoryId;
  private DropdownChipLayouter mDropdownChipLayouter;

  public RecipientAlternatesAdapter(Context paramContext, long paramLong1, Long paramLong, String paramString, long paramLong2, int paramInt, OnCheckedItemChangedListener paramOnCheckedItemChangedListener, DropdownChipLayouter paramDropdownChipLayouter)
  {
    super(paramContext, getCursorForConstruction(paramContext, paramLong1, paramLong, paramString, paramInt), 0);
    mCurrentId = paramLong2;
    mDirectoryId = paramLong;
    mCheckedItemChangedListener = paramOnCheckedItemChangedListener;
    mDropdownChipLayouter = paramDropdownChipLayouter;
  }

  private static Cursor doQuery(CharSequence paramCharSequence, int paramInt, Long paramLong, Account paramAccount, ContentResolver paramContentResolver, Queries.Query paramQuery)
  {
    paramCharSequence = paramQuery.getContentFilterUri().buildUpon().appendPath(paramCharSequence.toString()).appendQueryParameter("limit", String.valueOf(paramInt + 5));
    if (paramLong != null)
      paramCharSequence.appendQueryParameter("directory", String.valueOf(paramLong));
    if (paramAccount != null)
    {
      paramCharSequence.appendQueryParameter("name_for_primary_account", paramAccount.name);
      paramCharSequence.appendQueryParameter("type_for_primary_account", paramAccount.type);
    }
    return paramContentResolver.query(paramCharSequence.build(), paramQuery.getProjection(), null, null, null);
  }

  static RecipientEntry getBetterRecipient(RecipientEntry paramRecipientEntry1, RecipientEntry paramRecipientEntry2)
  {
    RecipientEntry localRecipientEntry;
    if (paramRecipientEntry2 == null)
      localRecipientEntry = paramRecipientEntry1;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return localRecipientEntry;
                localRecipientEntry = paramRecipientEntry2;
              }
              while (paramRecipientEntry1 == null);
              if ((!TextUtils.isEmpty(paramRecipientEntry1.getDisplayName())) && (TextUtils.isEmpty(paramRecipientEntry2.getDisplayName())))
                return paramRecipientEntry1;
              if (TextUtils.isEmpty(paramRecipientEntry2.getDisplayName()))
                break;
              localRecipientEntry = paramRecipientEntry2;
            }
            while (TextUtils.isEmpty(paramRecipientEntry1.getDisplayName()));
            if ((!TextUtils.equals(paramRecipientEntry1.getDisplayName(), paramRecipientEntry1.getDestination())) && (TextUtils.equals(paramRecipientEntry2.getDisplayName(), paramRecipientEntry2.getDestination())))
              return paramRecipientEntry1;
            if (TextUtils.equals(paramRecipientEntry2.getDisplayName(), paramRecipientEntry2.getDestination()))
              break;
            localRecipientEntry = paramRecipientEntry2;
          }
          while (TextUtils.equals(paramRecipientEntry1.getDisplayName(), paramRecipientEntry1.getDestination()));
          if (((paramRecipientEntry1.getPhotoThumbnailUri() != null) || (paramRecipientEntry1.getPhotoBytes() != null)) && (paramRecipientEntry2.getPhotoThumbnailUri() == null) && (paramRecipientEntry2.getPhotoBytes() == null))
            return paramRecipientEntry1;
          if (paramRecipientEntry2.getPhotoThumbnailUri() != null)
            break;
          localRecipientEntry = paramRecipientEntry2;
        }
        while (paramRecipientEntry2.getPhotoBytes() == null);
        localRecipientEntry = paramRecipientEntry2;
      }
      while (paramRecipientEntry1.getPhotoThumbnailUri() != null);
      localRecipientEntry = paramRecipientEntry2;
    }
    while (paramRecipientEntry1.getPhotoBytes() != null);
    return paramRecipientEntry2;
  }

  private static Cursor getCursorForConstruction(Context paramContext, long paramLong, Long paramLong1, String paramString, int paramInt)
  {
    Object localObject;
    if (paramInt == 0)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(Queries.EMAIL.getProjection()[4]);
      localStringBuilder.append(" = ?");
      if ((paramLong1 == null) || (paramString == null))
        localObject = Queries.EMAIL.getContentUri();
      for (paramLong1 = null; ; paramLong1 = "vnd.android.cursor.item/email_v2")
      {
        paramContext = paramContext.getContentResolver().query((Uri)localObject, Queries.EMAIL.getProjection(), localStringBuilder.toString(), new String[] { String.valueOf(paramLong) }, null);
        paramLong1 = removeUndesiredDestinations(paramContext, paramLong1, paramString);
        paramContext.close();
        return paramLong1;
        localObject = ContactsContract.Contacts.getLookupUri(paramLong, paramString).buildUpon();
        ((Uri.Builder)localObject).appendPath("entities").appendQueryParameter("directory", String.valueOf(paramLong1));
        localObject = ((Uri.Builder)localObject).build();
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Queries.PHONE.getProjection()[4]);
    localStringBuilder.append(" = ?");
    if (paramString == null)
      localObject = Queries.PHONE.getContentUri();
    for (paramLong1 = null; ; paramLong1 = "vnd.android.cursor.item/phone_v2")
    {
      paramContext = paramContext.getContentResolver().query((Uri)localObject, Queries.PHONE.getProjection(), localStringBuilder.toString(), new String[] { String.valueOf(paramLong) }, null);
      break;
      localObject = ContactsContract.Contacts.getLookupUri(paramLong, paramString).buildUpon();
      ((Uri.Builder)localObject).appendPath("entities").appendQueryParameter("directory", String.valueOf(paramLong1));
      localObject = ((Uri.Builder)localObject).build();
    }
  }

  public static void getMatchingRecipients(Context paramContext, BaseRecipientAdapter paramBaseRecipientAdapter, ArrayList<String> paramArrayList, int paramInt, Account paramAccount, RecipientMatchCallback paramRecipientMatchCallback)
  {
    Queries.Query localQuery;
    int i;
    HashSet localHashSet;
    Object localObject2;
    if (paramInt == 0)
    {
      localQuery = Queries.EMAIL;
      i = Math.min(50, paramArrayList.size());
      localHashSet = new HashSet();
      localObject2 = new StringBuilder();
      paramInt = 0;
      label40: if (paramInt >= i)
        break label137;
      localObject1 = Rfc822Tokenizer.tokenize(((String)paramArrayList.get(paramInt)).toLowerCase());
      if (localObject1.length <= 0)
        break label124;
    }
    label124: for (Object localObject1 = localObject1[0].getAddress(); ; localObject1 = (String)paramArrayList.get(paramInt))
    {
      localHashSet.add(localObject1);
      ((StringBuilder)localObject2).append("?");
      if (paramInt < i - 1)
        ((StringBuilder)localObject2).append(",");
      paramInt += 1;
      break label40;
      localQuery = Queries.PHONE;
      break;
    }
    label137: if (Log.isLoggable("RecipAlternates", 3))
      Log.d("RecipAlternates", "Doing reverse lookup for " + localHashSet.toString());
    localObject1 = new String[localHashSet.size()];
    localHashSet.toArray((Object[])localObject1);
    paramArrayList = null;
    try
    {
      localObject1 = paramContext.getContentResolver().query(localQuery.getContentUri(), localQuery.getProjection(), localQuery.getProjection()[1] + " IN (" + ((StringBuilder)localObject2).toString() + ")", (String[])localObject1, null);
      paramArrayList = (ArrayList<String>)localObject1;
      localObject2 = processContactEntries((Cursor)localObject1, null);
      paramArrayList = (ArrayList<String>)localObject1;
      paramRecipientMatchCallback.matchesFound((Map)localObject2);
      if (localObject1 != null)
        ((Cursor)localObject1).close();
      paramArrayList = new HashSet();
      getMatchingRecipientsFromDirectoryQueries(paramContext, (Map)localObject2, localHashSet, paramAccount, paramArrayList, localQuery, paramRecipientMatchCallback);
      getMatchingRecipientsFromExtensionMatcher(paramBaseRecipientAdapter, paramArrayList, paramRecipientMatchCallback);
      return;
    }
    finally
    {
      if (paramArrayList != null)
        paramArrayList.close();
    }
    throw paramContext;
  }

  public static void getMatchingRecipients(Context paramContext, BaseRecipientAdapter paramBaseRecipientAdapter, ArrayList<String> paramArrayList, Account paramAccount, RecipientMatchCallback paramRecipientMatchCallback)
  {
    getMatchingRecipients(paramContext, paramBaseRecipientAdapter, paramArrayList, 0, paramAccount, paramRecipientMatchCallback);
  }

  private static void getMatchingRecipientsFromDirectoryQueries(Context paramContext, Map<String, RecipientEntry> paramMap, Set<String> paramSet1, Account paramAccount, Set<String> paramSet2, Queries.Query paramQuery, RecipientMatchCallback paramRecipientMatchCallback)
  {
    if (paramMap.size() < paramSet1.size())
    {
      Object localObject2 = null;
      Object localObject1;
      Object localObject3;
      try
      {
        localObject1 = paramContext.getContentResolver().query(BaseRecipientAdapter.DirectoryListQuery.URI, BaseRecipientAdapter.DirectoryListQuery.PROJECTION, null, null, null);
        if (localObject1 == null);
        for (localObject2 = null; ; localObject2 = localObject3)
        {
          if (localObject1 != null)
            ((Cursor)localObject1).close();
          localObject1 = new HashSet();
          paramSet1 = paramSet1.iterator();
          while (paramSet1.hasNext())
          {
            localObject3 = (String)paramSet1.next();
            if (!paramMap.containsKey(localObject3))
              ((HashSet)localObject1).add(localObject3);
          }
          localObject2 = localObject1;
          localObject3 = BaseRecipientAdapter.setupOtherDirectories(paramContext, (Cursor)localObject1, paramAccount);
        }
      }
      finally
      {
        if (localObject2 != null)
          localObject2.close();
      }
      paramSet2.addAll((Collection)localObject1);
      if (localObject2 != null)
      {
        paramSet1 = null;
        Iterator localIterator = ((HashSet)localObject1).iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          localObject3 = null;
          int i = 0;
          label201: paramMap = paramSet1;
          localObject1 = localObject3;
          if (i < localObject2.size());
          try
          {
            paramMap = doQuery(str, 1, Long.valueOf(((BaseRecipientAdapter.DirectorySearchParams)localObject2.get(i)).directoryId), paramAccount, paramContext.getContentResolver(), paramQuery);
            if ((paramMap != null) && (paramMap.getCount() == 0))
            {
              paramMap.close();
              paramSet1 = null;
              i += 1;
              break label201;
            }
            localObject1 = Long.valueOf(((BaseRecipientAdapter.DirectorySearchParams)localObject2.get(i)).directoryId);
            paramSet1 = paramMap;
            if (paramMap != null)
              try
              {
                paramSet1 = processContactEntries(paramMap, (Long)localObject1);
                localObject1 = paramSet1.keySet().iterator();
                while (((Iterator)localObject1).hasNext())
                  paramSet2.remove((String)((Iterator)localObject1).next());
              }
              finally
              {
                paramMap.close();
              }
          }
          finally
          {
            while (true)
            {
              if ((paramSet1 != null) && (paramSet1.getCount() == 0))
              {
                paramSet1.close();
                throw paramMap;
              }
              localObject1 = Long.valueOf(((BaseRecipientAdapter.DirectorySearchParams)localObject2.get(i)).directoryId);
              paramMap = paramSet1;
            }
            paramRecipientMatchCallback.matchesFound(paramSet1);
            paramMap.close();
          }
        }
      }
    }
  }

  public static void getMatchingRecipientsFromExtensionMatcher(BaseRecipientAdapter paramBaseRecipientAdapter, Set<String> paramSet, RecipientMatchCallback paramRecipientMatchCallback)
  {
    if (paramBaseRecipientAdapter != null)
    {
      paramBaseRecipientAdapter = paramBaseRecipientAdapter.getMatchingRecipients(paramSet);
      if ((paramBaseRecipientAdapter != null) && (paramBaseRecipientAdapter.size() > 0))
      {
        paramRecipientMatchCallback.matchesFound(paramBaseRecipientAdapter);
        paramBaseRecipientAdapter = paramBaseRecipientAdapter.keySet().iterator();
        while (paramBaseRecipientAdapter.hasNext())
          paramSet.remove((String)paramBaseRecipientAdapter.next());
      }
    }
    paramRecipientMatchCallback.matchesNotFound(paramSet);
  }

  private static HashMap<String, RecipientEntry> processContactEntries(Cursor paramCursor, Long paramLong)
  {
    HashMap localHashMap = new HashMap();
    if ((paramCursor != null) && (paramCursor.moveToFirst()))
      do
      {
        String str = paramCursor.getString(1);
        RecipientEntry localRecipientEntry = RecipientEntry.constructTopLevelEntry(paramCursor.getString(0), paramCursor.getInt(7), paramCursor.getString(1), paramCursor.getInt(2), paramCursor.getString(3), paramCursor.getLong(4), paramLong, paramCursor.getLong(5), paramCursor.getString(6), true, paramCursor.getString(8));
        localHashMap.put(str, getBetterRecipient((RecipientEntry)localHashMap.get(str), localRecipientEntry));
        if (Log.isLoggable("RecipAlternates", 3))
          Log.d("RecipAlternates", "Received reverse look up information for " + str + " RESULTS: " + " NAME : " + paramCursor.getString(0) + " CONTACT ID : " + paramCursor.getLong(4) + " ADDRESS :" + paramCursor.getString(1));
      }
      while (paramCursor.moveToNext());
    return localHashMap;
  }

  static Cursor removeUndesiredDestinations(Cursor paramCursor, String paramString1, String paramString2)
  {
    MatrixCursor localMatrixCursor = new MatrixCursor(paramCursor.getColumnNames(), paramCursor.getCount());
    HashSet localHashSet = new HashSet();
    Object localObject2 = null;
    String str2 = null;
    int j = 0;
    paramCursor.moveToPosition(-1);
    do
    {
      localObject1 = localObject2;
      i = j;
      str1 = str2;
      if (!paramCursor.moveToNext())
        break;
    }
    while (!"vnd.android.cursor.item/name".equals(paramCursor.getString(9)));
    Object localObject1 = paramCursor.getString(0);
    String str1 = paramCursor.getString(6);
    int i = paramCursor.getInt(7);
    paramCursor.moveToPosition(-1);
    while (paramCursor.moveToNext())
      if ((paramString1 == null) || (paramString1.equals(paramCursor.getString(9))))
      {
        localObject2 = paramCursor.getString(1);
        if (!localHashSet.contains(localObject2))
        {
          localHashSet.add(localObject2);
          localObject2 = new Object[10];
          localObject2[0] = paramCursor.getString(0);
          localObject2[1] = paramCursor.getString(1);
          localObject2[2] = Integer.valueOf(paramCursor.getInt(2));
          localObject2[3] = paramCursor.getString(3);
          localObject2[4] = Long.valueOf(paramCursor.getLong(4));
          localObject2[5] = Long.valueOf(paramCursor.getLong(5));
          localObject2[6] = paramCursor.getString(6);
          localObject2[7] = Integer.valueOf(paramCursor.getInt(7));
          localObject2[8] = paramCursor.getString(8);
          localObject2[9] = paramCursor.getString(9);
          if (localObject2[0] == null)
            localObject2[0] = localObject1;
          if (localObject2[6] == null)
            localObject2[6] = str1;
          if (((Integer)localObject2[7]).intValue() == 0)
            localObject2[7] = Integer.valueOf(i);
          if (localObject2[8] == null)
            localObject2[8] = paramString2;
          str2 = (String)localObject2[6];
          if (str2 != null)
          {
            if (!sCorrectedPhotoUris.containsKey(str2))
              break label430;
            localObject2[6] = sCorrectedPhotoUris.get(str2);
          }
          while (true)
          {
            localMatrixCursor.addRow((Object[])localObject2);
            break;
            label430: if (str2.indexOf('?') != str2.lastIndexOf('?'))
            {
              Object localObject3 = str2.split("\\?");
              StringBuilder localStringBuilder = new StringBuilder();
              j = 0;
              if (j < localObject3.length)
              {
                if (j == 1)
                  localStringBuilder.append("?");
                while (true)
                {
                  localStringBuilder.append(localObject3[j]);
                  j += 1;
                  break;
                  if (j > 1)
                    localStringBuilder.append("&");
                }
              }
              localObject3 = localStringBuilder.toString();
              sCorrectedPhotoUris.put(str2, localObject3);
              localObject2[6] = localObject3;
            }
          }
        }
      }
    return localMatrixCursor;
  }

  public void bindView(View paramView, Context paramContext, Cursor paramCursor)
  {
    int i = paramCursor.getPosition();
    paramContext = getRecipientEntry(i);
    mDropdownChipLayouter.bindView(paramView, null, paramContext, i, DropdownChipLayouter.AdapterType.RECIPIENT_ALTERNATES, null);
  }

  public long getItemId(int paramInt)
  {
    Cursor localCursor = getCursor();
    if (localCursor.moveToPosition(paramInt))
      localCursor.getLong(5);
    return -1L;
  }

  public RecipientEntry getRecipientEntry(int paramInt)
  {
    Cursor localCursor = getCursor();
    localCursor.moveToPosition(paramInt);
    return RecipientEntry.constructTopLevelEntry(localCursor.getString(0), localCursor.getInt(7), localCursor.getString(1), localCursor.getInt(2), localCursor.getString(3), localCursor.getLong(4), mDirectoryId, localCursor.getLong(5), localCursor.getString(6), true, localCursor.getString(8));
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Cursor localCursor = getCursor();
    localCursor.moveToPosition(paramInt);
    paramViewGroup = paramView;
    if (paramView == null)
      paramViewGroup = mDropdownChipLayouter.newView();
    if (localCursor.getLong(5) == mCurrentId)
    {
      mCheckedItemPosition = paramInt;
      if (mCheckedItemChangedListener != null)
        mCheckedItemChangedListener.onCheckedItemChanged(mCheckedItemPosition);
    }
    bindView(paramViewGroup, paramViewGroup.getContext(), localCursor);
    return paramViewGroup;
  }

  public View newView(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup)
  {
    return mDropdownChipLayouter.newView();
  }

  static abstract interface OnCheckedItemChangedListener
  {
    public abstract void onCheckedItemChanged(int paramInt);
  }

  public static abstract interface RecipientMatchCallback
  {
    public abstract void matchesFound(Map<String, RecipientEntry> paramMap);

    public abstract void matchesNotFound(Set<String> paramSet);
  }
}
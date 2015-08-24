package com.google.android.keep.syncadapter;

import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.net.Uri;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.common.base.Preconditions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveFirstPartyApi;
import com.google.android.keep.c;
import com.google.android.keep.d;
import com.google.android.keep.model.ImageBlob;
import com.google.android.keep.model.Sharee.Role;
import com.google.android.keep.model.TreeEntitySettings;
import com.google.android.keep.provider.i.a;
import com.google.android.keep.provider.i.e;
import com.google.android.keep.provider.i.g;
import com.google.android.keep.provider.i.j;
import com.google.android.keep.provider.i.k;
import com.google.android.keep.provider.i.m;
import com.google.android.keep.provider.i.n;
import com.google.android.keep.provider.i.o;
import com.google.android.keep.provider.i.p;
import com.google.android.keep.provider.i.t;
import com.google.android.keep.provider.i.v;
import com.google.android.keep.provider.i.y;
import com.google.android.keep.util.A;
import com.google.android.keep.util.C;
import com.google.android.keep.util.Config;
import com.google.android.keep.util.Config.UpgradeType;
import com.google.android.keep.util.h;
import com.google.api.client.util.DateTime;
import com.google.api.services.notes.model.Blob;
import com.google.api.services.notes.model.DownSync;
import com.google.api.services.notes.model.DownSync.ResponseHeader;
import com.google.api.services.notes.model.DownSync.ResponseHeader.LatestClientVersion;
import com.google.api.services.notes.model.Node;
import com.google.api.services.notes.model.Node.ErrorStatus;
import com.google.api.services.notes.model.Node.LabelIds;
import com.google.api.services.notes.model.Node.MergeConflict;
import com.google.api.services.notes.model.Node.RoleInfo;
import com.google.api.services.notes.model.Node.ShareRequests;
import com.google.api.services.notes.model.Node.Timestamps;
import com.google.api.services.notes.model.UserInfo;
import com.google.api.services.notes.model.UserInfo.Labels;
import com.google.api.services.notes.model.UserInfo.Labels.Timestamps;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class DownSyncResponseProcessor
{
  private final DownSync FB;
  private final String FC;
  private final Map<String, Integer> FD;
  private final List<Node> FE;
  private final UserInfo FF;
  final Map<String, a> FG = Maps.newHashMap();
  final Map<String, Long> FH = Maps.newHashMap();
  final Map<String, Integer> FI = Maps.newHashMap();
  final ArrayList<ContentProviderOperation> FJ = new ArrayList();
  private final List<Long> FK = Lists.newArrayList();
  private final List<Long> FL = Lists.newArrayList();
  private final List<Long> FM = Lists.newArrayList();
  private final List<String> FN = Lists.newArrayList();
  private final List<String> FO = Lists.newArrayList();
  private final List<Long> FP = Lists.newArrayList();
  private final List<Long> FQ = Lists.newArrayList();
  private List<Long> FR = new ArrayList();
  private List<Long> FS = new ArrayList();
  private Map<String, String> FT;
  private final c dI;
  private final com.google.android.keep.model.j fr;
  private final GoogleApiClient gh;
  private final Context mContext;

  public DownSyncResponseProcessor(Context paramContext, GoogleApiClient paramGoogleApiClient, DownSync paramDownSync, com.google.android.keep.model.j paramj, String paramString, List<Node> paramList, UserInfo paramUserInfo, Map<String, Integer> paramMap)
  {
    mContext = paramContext;
    dI = d.e(paramContext);
    FB = paramDownSync;
    fr = paramj;
    FC = paramString;
    FE = paramList;
    FF = paramUserInfo;
    FD = paramMap;
    gh = paramGoogleApiClient;
  }

  private void A(List<Node> paramList)
  {
    com.google.android.keep.util.r.a("KeepSync", "\n******* Look up local IDs from UUIDs *******", new Object[0]);
    ArrayList localArrayList1 = Lists.newArrayList();
    ArrayList localArrayList2 = Lists.newArrayList();
    ArrayList localArrayList3 = Lists.newArrayList();
    ArrayList localArrayList4 = Lists.newArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Node localNode = (Node)paramList.next();
      if (d(localNode))
      {
        b(localArrayList1, localNode.getId());
        b(localArrayList2, localNode.getId());
        b(localArrayList3, localNode.getId());
      }
      else
      {
        SyncType localSyncType = SyncType.ba(localNode.getType());
        switch (1.FU[localSyncType.ordinal()])
        {
        default:
          break;
        case 1:
        case 2:
        case 5:
          b(localArrayList1, localNode.getId());
          b(localArrayList1, localNode.getParentId());
          break;
        case 3:
          b(localArrayList2, localNode.getId());
          b(localArrayList1, localNode.getParentId());
          break;
        case 4:
          b(localArrayList3, localNode.getId());
          b(localArrayList4, localNode.getServerId());
          b(localArrayList1, localNode.getParentId());
        }
      }
    }
    a(i.v.BX, "tree_entity", localArrayList1);
    a(i.e.BX, "blob_node", localArrayList2);
    a(i.m.BX, "list_item", localArrayList3);
    B(localArrayList4);
  }

  private void B(List<String> paramList)
  {
    if (paramList.size() > 0)
    {
      Object localObject1 = i.n.BX;
      if (com.google.android.keep.util.r.isLoggable("KeepSync", 2))
      {
        Log.v("KeepSync", "Looking up following ids from list_item_conflict table");
        localObject3 = paramList.iterator();
        while (((Iterator)localObject3).hasNext())
          Log.v("KeepSync", (String)((Iterator)localObject3).next());
      }
      Object localObject3 = mContext.getContentResolver();
      paramList = "server_id IN (" + TextUtils.join(",", paramList) + ")";
      paramList = ((ContentResolver)localObject3).query((Uri)localObject1, new String[] { "_id", "server_id" }, paramList, null, null);
      try
      {
        paramList.moveToPosition(-1);
        while (paramList.moveToNext())
        {
          localObject1 = h.l(paramList, 0);
          if (localObject1 != null)
            FH.put(paramList.getString(1), localObject1);
        }
      }
      finally
      {
        paramList.close();
      }
      paramList.close();
    }
  }

  private ContentProviderOperation.Builder a(Long paramLong, Uri paramUri, Integer paramInteger)
  {
    if (paramLong == null)
      return ContentProviderOperation.newInsert(paramUri);
    paramUri = ContentProviderOperation.newUpdate(paramUri);
    String[] arrayOfString = new String[1];
    arrayOfString[0] = String.valueOf(paramLong);
    if (paramInteger != null)
    {
      paramUri.withSelection(h.p("_id = ? ", "version= ?"), com.google.android.keep.util.e.a(arrayOfString, new String[] { String.valueOf(paramInteger) }));
      return paramUri;
    }
    paramUri.withSelection(h.p("_id = ? ", "is_dirty= ?"), com.google.android.keep.util.e.a(arrayOfString, new String[] { String.valueOf(0) }));
    return paramUri;
  }

  private Integer a(Node paramNode, ContentValues paramContentValues, String paramString)
    throws DownSyncResponseProcessor.UnknownParentIdException
  {
    Object localObject = null;
    com.google.android.keep.util.r.a("KeepSync", "Parent from node is: " + paramNode.getParentId(), new Object[0]);
    if (paramNode.getParentId().equals("root"))
      throw new UnknownParentIdException(paramNode.getParentId() + " Parent id can not be root for type " + paramNode.getType());
    Long localLong = aV(paramNode.getParentId());
    com.google.android.keep.util.r.a("KeepSync", "Local database Id of parent: " + localLong, new Object[0]);
    if (localLong == null)
    {
      paramString = (Integer)FI.get(paramNode.getParentId());
      com.google.android.keep.util.r.a("KeepSync", "Parent doesn't exist yet, so use back reference " + paramString, new Object[0]);
      paramContentValues = paramString;
      if (paramString == null)
        throw new UnknownParentIdException(paramNode.getParentId());
    }
    else
    {
      paramContentValues.put(paramString, localLong);
      paramContentValues = localObject;
    }
    return paramContentValues;
  }

  private List<UserInfo.Labels> a(UserInfo paramUserInfo)
  {
    if (paramUserInfo == null)
      paramUserInfo = null;
    List localList;
    do
    {
      return paramUserInfo;
      localList = paramUserInfo.getLabels();
      paramUserInfo = localList;
    }
    while (localList != null);
    return new ArrayList();
  }

  private void a(ContentValues paramContentValues, Long paramLong, String paramString)
  {
    if (paramLong == null)
      paramContentValues.put(paramString, Long.valueOf(fr.getId()));
  }

  private void a(Uri paramUri, String paramString, List<String> paramList)
  {
    if (paramList.size() > 0)
    {
      if (com.google.android.keep.util.r.isLoggable("KeepSync", 2))
      {
        Log.v("KeepSync", "Looking up following ids from " + paramString + " table");
        localObject = paramList.iterator();
        while (((Iterator)localObject).hasNext())
          Log.v("KeepSync", (String)((Iterator)localObject).next());
      }
      Object localObject = mContext.getContentResolver();
      paramList = "account_id=? AND uuid IN (" + TextUtils.join(",", paramList) + ")";
      long l = fr.getId();
      paramUri = ((ContentResolver)localObject).query(paramUri, new String[] { "_id", "uuid", "account_id", "server_id" }, paramList, new String[] { String.valueOf(l) }, null);
      try
      {
        paramUri.moveToPosition(-1);
        while (paramUri.moveToNext())
        {
          paramList = Long.valueOf(paramUri.getLong(0));
          localObject = paramUri.getString(1);
          l = paramUri.getLong(2);
          String str = paramUri.getString(3);
          com.google.android.keep.util.r.a("KeepSync", "Found _id " + String.valueOf(paramList) + ", uid " + (String)localObject + ", account ID " + Long.valueOf(l), new Object[0]);
          FG.put(localObject, new a(paramList, paramString, str));
        }
      }
      finally
      {
        paramUri.close();
      }
      paramUri.close();
    }
  }

  private void a(Blob paramBlob, ContentValues paramContentValues)
  {
    Integer localInteger = paramBlob.getByteSize();
    paramBlob = localInteger;
    if (localInteger == null)
      paramBlob = Integer.valueOf(0);
    paramContentValues.put("blob_size", paramBlob);
  }

  private void a(Node paramNode)
  {
    Long localLong = aV(paramNode.getId());
    paramNode = paramNode.getErrorStatus();
    if ((paramNode == null) || (paramNode.size() == 0));
    while (true)
    {
      return;
      paramNode = paramNode.iterator();
      while (paramNode.hasNext())
      {
        Object localObject = (Node.ErrorStatus)paramNode.next();
        localObject = ContentProviderOperation.newInsert(i.o.BX).withValue("tree_entity_id", localLong).withValue("code", ((Node.ErrorStatus)localObject).getCode()).withValue("account_id", Long.valueOf(fr.getId())).withValue("time_created", Long.valueOf(System.currentTimeMillis())).withValue("data", com.google.android.keep.model.r.l(((Node.ErrorStatus)localObject).getEmails()));
        FJ.add(((ContentProviderOperation.Builder)localObject).build());
      }
    }
  }

  private void a(Node paramNode, int paramInt)
    throws DownSyncResponseProcessor.VersionNumberNotFoundException
  {
    String str = paramNode.getId();
    Long localLong = aV(str);
    Object localObject = aW(str);
    Integer localInteger = (Integer)FD.get(str);
    com.google.android.keep.util.r.a("KeepSync", "Type:" + paramNode.getType() + "\nLocal database ID: " + localLong, new Object[0]);
    com.google.android.keep.util.r.a("KeepSync", "Id:" + paramNode.getId(), new Object[0]);
    com.google.android.keep.util.r.a("KeepSync", "ParentId:" + paramNode.getParentId(), new Object[0]);
    if (d(paramNode))
      break label156;
    label156: 
    while (!"root".equals(paramNode.getParentId()))
      return;
    a(localLong, localInteger, str);
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("type", Integer.valueOf(paramInt));
    localContentValues.put("uuid", str);
    localContentValues.put("is_deleted", Integer.valueOf(0));
    localContentValues.put("parent_id", Long.valueOf(0L));
    c(paramNode, localContentValues, "order_in_parent");
    d(paramNode, localContentValues, "color_name");
    b(paramNode, localContentValues);
    f(paramNode, localContentValues, "is_archived");
    g(paramNode, localContentValues, "time_created");
    h(paramNode, localContentValues, "time_last_updated");
    k(paramNode, localContentValues, "server_id");
    a(localContentValues, localLong, "account_id");
    j(paramNode, localContentValues, "title");
    c(paramNode, localContentValues);
    d(paramNode, localContentValues);
    e(paramNode, localContentValues);
    label359: Node.Timestamps localTimestamps;
    if ((localLong == null) || (!TextUtils.isEmpty((CharSequence)localObject)))
    {
      paramInt = 1;
      if (paramInt != 0)
        f(paramNode, localContentValues);
      if ((paramInt != 0) || (!l(localLong)))
        break label636;
      localContentValues.put("is_dirty", Integer.valueOf(1));
      label395: localTimestamps = paramNode.getTimestamps();
      if (localTimestamps != null)
      {
        localObject = localTimestamps.getTrashed();
        com.google.android.keep.util.r.a("KeepSync", "Time trashed: " + localObject, new Object[0]);
        if ((localObject == null) || (((DateTime)localObject).getValue() <= 0L))
          break label651;
      }
    }
    label651: for (int i = 1; ; i = 0)
    {
      localContentValues.put("is_trashed", Integer.valueOf(i));
      if (localTimestamps != null)
      {
        DateTime localDateTime = localTimestamps.getUserEdited();
        localObject = localDateTime;
        if (localDateTime == null)
          localObject = localTimestamps.getUpdated();
        if (localObject != null)
          localContentValues.put("user_edited_timestamp", Long.valueOf(((DateTime)localObject).getValue()));
        localObject = localTimestamps.getShareRequestProcessed();
        if (localObject != null)
          localContentValues.put("shared_timestamp", Long.valueOf(((DateTime)localObject).getValue()));
      }
      localObject = a(localLong, i.v.BX, localInteger);
      if (localLong == null)
        aX(str);
      i = FJ.size();
      FJ.add(((ContentProviderOperation.Builder)localObject).withValues(localContentValues).build());
      if (paramInt != 0)
        b(paramNode, localLong, i);
      a(paramNode, localLong, i);
      if (localLong == null)
        break;
      a(paramNode);
      return;
      paramInt = 0;
      break label359;
      label636: localContentValues.put("is_dirty", Integer.valueOf(0));
      break label395;
    }
  }

  private void a(Node paramNode, ContentValues paramContentValues)
  {
    Long localLong1 = aV(paramNode.getId());
    Blob localBlob = paramNode.getBlob();
    DateTime localDateTime = paramNode.getTimestamps().getUpdated();
    Object localObject = ContentUris.withAppendedId(i.e.BX, localLong1.longValue());
    localObject = mContext.getContentResolver().query((Uri)localObject, new String[] { "media_id", "time_last_updated" }, null, null, null);
    try
    {
      ((Cursor)localObject).moveToPosition(-1);
      Long localLong2;
      if (((Cursor)localObject).moveToNext())
      {
        String str = ((Cursor)localObject).getString(0);
        localLong2 = Long.valueOf(((Cursor)localObject).getLong(1));
        if (!TextUtils.equals(str, localBlob.getMediaId()))
          break label139;
        d(localBlob, paramContentValues);
      }
      while (true)
      {
        return;
        label139: if ((localLong2 == null) || ((localDateTime != null) && (localDateTime.getValue() > localLong2.longValue())))
        {
          ab(localLong1.longValue());
          c(localBlob, paramContentValues);
          h(paramNode, paramContentValues, "time_last_updated");
        }
      }
    }
    finally
    {
      ((Cursor)localObject).close();
    }
    throw paramNode;
  }

  private void a(Node paramNode, Long paramLong, int paramInt)
  {
    paramNode = paramNode.getLabelIds();
    Map localMap = k(paramLong);
    if (paramNode != null)
    {
      Iterator localIterator = paramNode.iterator();
      while (localIterator.hasNext())
      {
        paramNode = ((Node.LabelIds)localIterator.next()).getLabelId();
        if (FT.containsKey(paramNode))
          paramNode = (String)FT.get(paramNode);
        while (true)
        {
          if (!localMap.containsKey(paramNode))
            break label119;
          FS.add(localMap.get(paramNode));
          localMap.remove(paramNode);
          break;
        }
        label119: a(paramNode, paramLong, paramInt);
      }
    }
    paramNode = localMap.keySet().iterator();
    while (paramNode.hasNext())
    {
      paramLong = (String)paramNode.next();
      FR.add(localMap.get(paramLong));
    }
  }

  private void a(Long paramLong, Integer paramInteger, String paramString)
    throws DownSyncResponseProcessor.VersionNumberNotFoundException
  {
    if ((paramLong == null) && (paramInteger != null))
      throw new VersionNumberNotFoundException(paramString, paramInteger);
  }

  private void a(String paramString, Long paramLong, int paramInt)
  {
    paramString = ContentProviderOperation.newInsert(i.p.BX).withValue("label_id", paramString).withValue("account_id", Long.valueOf(fr.getId()));
    if (paramLong != null)
      paramString.withValue("tree_entity_id", paramLong);
    while (true)
    {
      FJ.add(paramString.build());
      return;
      paramString.withValueBackReference("tree_entity_id", paramInt);
    }
  }

  private void a(ArrayList<ContentProviderOperation> paramArrayList, Map<String, Long> paramMap)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
      localArrayList.add((Long)paramMap.get((String)localIterator.next()));
    if (localArrayList.size() > 0)
    {
      com.google.android.keep.util.r.a("KeepSync", "# of Labels to delete: " + localArrayList.size(), new Object[0]);
      paramMap = TextUtils.join(",", localArrayList);
      paramMap = "(_id IN (" + paramMap + "))";
      paramArrayList.add(ContentProviderOperation.newDelete(i.k.BX).withSelection(paramMap, null).build());
    }
  }

  private void a(List<Node> paramList, Map<String, Integer> paramMap)
  {
    if (paramList == null)
      return;
    ArrayList localArrayList = Lists.newArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Node)localIterator.next();
      paramList = SyncType.ba(((Node)localObject).getType());
      switch (1.FU[paramList.ordinal()])
      {
      default:
        break;
      case 1:
      case 2:
        paramList = i.v.BX;
      case 3:
      case 4:
        while (true)
        {
          localObject = ((Node)localObject).getId();
          paramList = ContentProviderOperation.newUpdate(paramList);
          paramList.withSelection("uuid=? AND version=? AND is_dirty=? AND account_id=?", new String[] { localObject, String.valueOf(paramMap.get(localObject)), String.valueOf(1), String.valueOf(fr.getId()) });
          paramList.withValue("is_dirty", Integer.valueOf(0));
          localArrayList.add(paramList.build());
          break;
          paramList = i.e.BX;
          continue;
          paramList = i.m.BX;
        }
      }
    }
    try
    {
      mContext.getContentResolver().applyBatch("com.google.android.keep", localArrayList);
      return;
    }
    catch (OperationApplicationException paramList)
    {
      com.google.android.keep.util.r.e("KeepSync", "OperationApplicationException error while cleaning dirty bits", new Object[] { paramList });
      return;
    }
    catch (RemoteException paramList)
    {
      com.google.android.keep.util.r.e("KeepSync", "RemoteException error while cleaning dirty bits", new Object[] { paramList });
    }
  }

  private boolean a(ArrayList<ContentProviderOperation> paramArrayList, UserInfo.Labels paramLabels, Long paramLong)
  {
    ContentValues localContentValues = new ContentValues();
    Object localObject2 = paramLabels.getName();
    String str = paramLabels.getMainId();
    if (localObject2 == null)
    {
      com.google.android.keep.util.r.e("KeepSync", "Missing name in label downsync.", new Object[0]);
      return false;
    }
    Object localObject1 = paramLabels.getTimestamps();
    if (localObject1 == null)
    {
      com.google.android.keep.util.r.e("KeepSync", "Missing UserInfo.Labels.Timestamps in label downsync.", new Object[0]);
      return false;
    }
    localContentValues.put("name", (String)localObject2);
    localContentValues.put("uuid", str);
    localContentValues.put("server_version_number", paramLabels.getRevision());
    localContentValues.put("account_id", Long.valueOf(fr.getId()));
    localContentValues.put("is_deleted", Integer.valueOf(0));
    localContentValues.put("is_dirty", Integer.valueOf(0));
    localContentValues.put("merged_uuids", i.k.a(paramLabels.getMergedIds()));
    localObject2 = ((UserInfo.Labels.Timestamps)localObject1).getUpdated();
    long l;
    if (localObject2 == null)
    {
      l = 0L;
      localContentValues.put("last_used_timestamp", Long.valueOf(l));
      localObject2 = ((UserInfo.Labels.Timestamps)localObject1).getCreated();
      if (localObject2 != null)
        break label301;
      l = 0L;
      label199: localContentValues.put("time_created", Long.valueOf(l));
      localObject1 = ((UserInfo.Labels.Timestamps)localObject1).getUserEdited();
      if (localObject1 != null)
        break label311;
      l = 0L;
      label227: localContentValues.put("user_edited_timestamp", Long.valueOf(l));
      paramLabels = paramLabels.getLastMerged();
      if (paramLabels != null)
        localContentValues.put("time_merged", Long.valueOf(paramLabels.getValue()));
      if (paramLong != null)
        break label321;
      paramLabels = ContentProviderOperation.newInsert(i.k.BX).withValues(localContentValues);
    }
    while (true)
    {
      paramArrayList.add(paramLabels.build());
      return true;
      l = ((DateTime)localObject2).getValue();
      break;
      label301: l = ((DateTime)localObject2).getValue();
      break label199;
      label311: l = ((DateTime)localObject1).getValue();
      break label227;
      label321: paramLabels = ContentProviderOperation.newUpdate(i.k.BX).withValues(localContentValues);
      if (aU(str))
      {
        l = ((Integer)FD.get(str)).intValue();
        paramLabels.withSelection("_id = ? AND version = ?", new String[] { String.valueOf(paramLong), String.valueOf(l) });
      }
      else
      {
        paramLabels.withSelection("_id = ? AND is_dirty = 0", new String[] { String.valueOf(paramLong) });
      }
    }
  }

  private boolean aU(String paramString)
  {
    if ((FF == null) || (FF.getLabels() == null));
    Iterator localIterator;
    do
      while (!localIterator.hasNext())
      {
        return false;
        localIterator = FF.getLabels().iterator();
      }
    while (!paramString.equals(((UserInfo.Labels)localIterator.next()).getMainId()));
    return true;
  }

  private Long aV(String paramString)
  {
    paramString = (a)FG.get(paramString);
    if (paramString != null)
      return paramString.Gd;
    return null;
  }

  private String aW(String paramString)
  {
    paramString = (a)FG.get(paramString);
    if (paramString != null)
      return paramString.serverId;
    return null;
  }

  private void aX(String paramString)
  {
    if (!FI.containsKey(paramString))
      FI.put(paramString, Integer.valueOf(FJ.size()));
  }

  private boolean aY(String paramString)
  {
    paramString = aZ(paramString);
    if ((paramString == null) || (paramString.getShareRequests() == null));
    do
      while (!paramString.hasNext())
      {
        return false;
        paramString = paramString.getShareRequests().iterator();
      }
    while (!TextUtils.equals(((Node.ShareRequests)paramString.next()).getType(), "WR"));
    return true;
  }

  private Node aZ(String paramString)
  {
    Iterator localIterator = FE.iterator();
    while (localIterator.hasNext())
    {
      Node localNode = (Node)localIterator.next();
      if (TextUtils.equals(paramString, localNode.getId()))
        return localNode;
    }
    return null;
  }

  private void ab(long paramLong)
  {
    Uri localUri = ContentUris.withAppendedId(i.e.BX, paramLong);
    Object localObject2 = mContext.getContentResolver().query(localUri, new String[] { "account_id", "file_name", "blob_type" }, null, null, null);
    try
    {
      ((Cursor)localObject2).moveToPosition(-1);
      if (((Cursor)localObject2).moveToNext())
      {
        long l = ((Cursor)localObject2).getLong(0);
        String str = ((Cursor)localObject2).getString(1);
        int i = ((Cursor)localObject2).getInt(2);
        com.google.android.keep.provider.e.l(com.google.android.keep.provider.e.a(mContext, Long.valueOf(l).longValue(), Integer.valueOf(i).intValue(), str));
      }
      ((Cursor)localObject2).close();
      localObject2 = new ContentValues();
      ((ContentValues)localObject2).put("file_name", (String)null);
      if (mContext.getContentResolver().update(localUri, (ContentValues)localObject2, null, null) != 1)
        com.google.android.keep.util.r.e("KeepSync", "Error deleting file name from blob with blobId: " + paramLong, new Object[0]);
      return;
    }
    finally
    {
      ((Cursor)localObject2).close();
    }
  }

  private int b(ArrayList<ContentProviderOperation> paramArrayList)
  {
    try
    {
      mContext.getContentResolver().applyBatch("com.google.android.keep", paramArrayList);
      return 0;
    }
    catch (OperationApplicationException paramArrayList)
    {
      com.google.android.keep.util.r.e("KeepSync", "OperationApplicationException error while applying sync results", new Object[] { paramArrayList });
      if (TextUtils.equals("insert failed", paramArrayList.getMessage()))
      {
        com.google.android.keep.util.r.e("KeepSync", "Failed to insert the note into database", new Object[0]);
        dI.a(2131230867, 2131231007, 2131231030, null);
      }
      return 3;
    }
    catch (RemoteException paramArrayList)
    {
      com.google.android.keep.util.r.e("KeepSync", "RemoteException error while applying sync results", new Object[] { paramArrayList });
    }
    return 2;
  }

  private void b(Blob paramBlob, ContentValues paramContentValues)
  {
    if ((paramBlob != null) && ("AUDIO".equals(paramBlob.getType())));
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool);
      paramContentValues.put("type", Integer.valueOf(1));
      paramContentValues.put("mime_type", paramBlob.getMimetype());
      a(paramBlob, paramContentValues);
      paramContentValues.put("media_id", paramBlob.getMediaId());
      paramContentValues.put("data1", paramBlob.getLength());
      return;
    }
  }

  private void b(Node paramNode)
    throws DownSyncResponseProcessor.VersionNumberNotFoundException, DownSyncResponseProcessor.UnknownParentIdException
  {
    Object localObject1 = paramNode.getId();
    Long localLong = aV((String)localObject1);
    Object localObject3 = (Long)FH.get(paramNode.getServerId());
    Integer localInteger = (Integer)FD.get(localObject1);
    com.google.android.keep.util.r.a("KeepSync", "Type:" + paramNode.getType() + "\nLocal database ID: " + localLong, new Object[0]);
    com.google.android.keep.util.r.a("KeepSync", "Id:" + paramNode.getId(), new Object[0]);
    com.google.android.keep.util.r.a("KeepSync", "ParentId:" + paramNode.getParentId(), new Object[0]);
    if (d(paramNode))
      return;
    a(localLong, localInteger, (String)localObject1);
    ContentValues localContentValues = new ContentValues();
    c(paramNode, localContentValues);
    d(paramNode, localContentValues);
    Object localObject2 = paramNode.getMergeConflict();
    if ((localObject2 != null) || (localObject3 != null))
    {
      localContentValues.put("is_dirty", Integer.valueOf(0));
      localContentValues.put("merge_token", "");
      localObject1 = a(localLong, i.m.BX, localInteger);
      localObject3 = new ContentValues();
      k(paramNode, (ContentValues)localObject3, "server_id");
      b(paramNode, (ContentValues)localObject3, "list_parent_id");
      h(paramNode, (ContentValues)localObject3, "time_last_updated");
      i(paramNode, (ContentValues)localObject3, "text");
      e(paramNode, (ContentValues)localObject3, "is_checked");
      if (localObject2 != null)
        ((ContentValues)localObject3).put("merge_token", ((Node.MergeConflict)localObject2).getToken());
      localObject2 = ContentProviderOperation.newInsert(i.n.Cu);
      FJ.add(((ContentProviderOperation.Builder)localObject2).withValues((ContentValues)localObject3).build());
    }
    while (true)
    {
      FJ.add(((ContentProviderOperation.Builder)localObject1).withValues(localContentValues).build());
      if ((localLong == null) || (localInteger == null))
        break;
      localObject1 = ContentUris.withAppendedId(i.m.BX, localLong.longValue());
      FJ.add(ContentProviderOperation.newUpdate((Uri)localObject1).withValue("base_version", paramNode.getBaseVersion()).build());
      return;
      localContentValues.put("uuid", (String)localObject1);
      localContentValues.put("is_dirty", Integer.valueOf(0));
      localContentValues.put("is_deleted", Integer.valueOf(0));
      localContentValues.put("merge_token", "");
      localObject3 = a(paramNode, localContentValues, "list_parent_id");
      c(paramNode, localContentValues, "order_in_parent");
      g(paramNode, localContentValues, "time_created");
      h(paramNode, localContentValues, "time_last_updated");
      i(paramNode, localContentValues, "text");
      e(paramNode, localContentValues, "is_checked");
      k(paramNode, localContentValues, "server_id");
      a(localContentValues, localLong, "account_id");
      localObject2 = a(localLong, i.m.BX, localInteger);
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        ((ContentProviderOperation.Builder)localObject2).withValueBackReference("list_parent_id", ((Integer)localObject3).intValue());
        localObject1 = localObject2;
      }
    }
  }

  private void b(Node paramNode, ContentValues paramContentValues)
  {
    paramNode = paramNode.getNodeSettings();
    if (paramNode != null)
    {
      com.google.android.keep.util.r.a("KeepSync", "Node settings: " + paramNode, new Object[0]);
      paramContentValues.putAll(TreeEntitySettings.a(paramNode).jh());
    }
  }

  private void b(Node paramNode, ContentValues paramContentValues, String paramString)
    throws DownSyncResponseProcessor.UnknownParentIdException
  {
    String str = paramNode.getParentId();
    com.google.android.keep.util.r.a("KeepSync", "Parent from node is: " + str, new Object[0]);
    if (str == null)
      throw new UnknownParentIdException("Node's parent id cannot be null for a conflicting item");
    if (str.equals("root"))
      throw new UnknownParentIdException(str + " Parent id cannot be root for type" + paramNode.getType());
    paramNode = aV(str);
    com.google.android.keep.util.r.a("KeepSync", "Local database Id of parent: " + paramNode, new Object[0]);
    if (paramNode == null)
      throw new UnknownParentIdException("Node's parent id cannot be found");
    paramContentValues.put(paramString, paramNode);
  }

  private void b(Node paramNode, Long paramLong, int paramInt)
  {
    Object localObject1 = i(paramLong);
    Object localObject2 = paramNode.getRoleInfo();
    int k = 0;
    int i = 0;
    Object localObject3;
    if (aY(paramNode.getId()))
    {
      localObject3 = j(paramLong);
      if ((localObject3 != null) && (((List)localObject3).size() > 0))
      {
        localObject3 = TextUtils.join(",", (Iterable)localObject3);
        localObject3 = ContentProviderOperation.newDelete(i.o.BX).withSelection("_id IN (" + (String)localObject3 + ")", null);
        FJ.add(((ContentProviderOperation.Builder)localObject3).build());
      }
    }
    int j = k;
    if (localObject2 != null)
    {
      j = k;
      if (((List)localObject2).size() > 0)
      {
        localObject2 = ((List)localObject2).iterator();
        while (true)
        {
          j = i;
          if (!((Iterator)localObject2).hasNext())
            break;
          Object localObject4 = (Node.RoleInfo)((Iterator)localObject2).next();
          localObject3 = ((Node.RoleInfo)localObject4).getEmail();
          if (!TextUtils.isEmpty((CharSequence)localObject3))
          {
            localObject3 = ((String)localObject3).toLowerCase();
            localObject4 = Sharee.Role.aq(((Node.RoleInfo)localObject4).getRole());
            if ((!fr.getName().equalsIgnoreCase((String)localObject3)) || (!Sharee.Role.zy.equals(localObject4)))
            {
              j = 1;
              i = 1;
              if (localObject1 != null)
              {
                if (!((Map)localObject1).containsKey(localObject3))
                  i = 1;
              }
              else
              {
                label256: if (i == 0)
                  break label436;
                if (!gh.isConnected())
                  gh.blockingConnect();
                String str1 = com.google.android.keep.util.j.a(gh, (String)localObject3, fr.getName());
                String str2 = com.google.android.keep.util.j.e(gh, (String)localObject3);
                localObject3 = ContentProviderOperation.newInsert(i.t.BX).withValue("email", localObject3).withValue("name", str1).withValue("gaia_id", str2).withValue("role", Integer.valueOf(((Sharee.Role)localObject4).getValue())).withValue("account_id", Long.valueOf(fr.getId())).withValue("avatar_uri", "");
                if (paramLong == null)
                  break label423;
                ((ContentProviderOperation.Builder)localObject3).withValue("tree_entity_id", paramLong);
              }
              while (true)
              {
                FJ.add(((ContentProviderOperation.Builder)localObject3).build());
                i = j;
                break;
                i = 0;
                break label256;
                label423: ((ContentProviderOperation.Builder)localObject3).withValueBackReference("tree_entity_id", paramInt);
              }
              label436: FQ.add(((Map)localObject1).get(localObject3));
              ((Map)localObject1).remove(localObject3);
              i = j;
            }
          }
        }
      }
    }
    if ((localObject1 != null) && (((Map)localObject1).size() > 0))
    {
      paramLong = ((Map)localObject1).entrySet().iterator();
      while (paramLong.hasNext())
      {
        localObject2 = (Map.Entry)paramLong.next();
        localObject1 = (Long)((Map.Entry)localObject2).getValue();
        localObject2 = (String)((Map.Entry)localObject2).getKey();
        if (k(paramNode.getId(), (String)localObject2))
          FQ.add(localObject1);
        FP.add(localObject1);
      }
    }
    if (j != 0)
      FN.add(paramNode.getServerId());
  }

  private void b(List<String> paramList, String paramString)
  {
    if ((paramList != null) && (paramString != null) && (!paramString.equals("root")))
    {
      String str = DatabaseUtils.sqlEscapeString(paramString);
      if (!paramList.contains(str))
      {
        com.google.android.keep.util.r.a("KeepSync", "Adding node UID %s to list of ids to look up", new Object[] { paramString });
        paramList.add(str);
      }
    }
  }

  private void c(Blob paramBlob, ContentValues paramContentValues)
  {
    if ((paramBlob != null) && ("IMAGE".equals(paramBlob.getType())) && (i.j.isSupported(paramBlob.getMimetype())));
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool);
      paramContentValues.put("type", Integer.valueOf(0));
      paramContentValues.put("mime_type", paramBlob.getMimetype());
      a(paramBlob, paramContentValues);
      paramContentValues.put("media_id", paramBlob.getMediaId());
      paramContentValues.put("data1", paramBlob.getWidth());
      paramContentValues.put("data2", paramBlob.getHeight());
      d(paramBlob, paramContentValues);
      return;
    }
  }

  private void c(Node paramNode)
    throws DownSyncResponseProcessor.VersionNumberNotFoundException, DownSyncResponseProcessor.UnknownParentIdException
  {
    Object localObject3 = paramNode.getId();
    Object localObject2 = aV((String)localObject3);
    Object localObject1 = (Integer)FD.get(localObject3);
    if (d(paramNode))
      return;
    a((Long)localObject2, (Integer)localObject1, (String)localObject3);
    localObject1 = a((Long)localObject2, i.e.BX, (Integer)localObject1);
    if (localObject2 == null)
    {
      localContentValues = new ContentValues();
      localContentValues.put("uuid", (String)localObject3);
      localContentValues.put("is_dirty", Integer.valueOf(0));
      localContentValues.put("is_deleted", Integer.valueOf(0));
      while (true)
      {
        try
        {
          localObject3 = a(paramNode, localContentValues, "tree_entity_id");
          if (localObject3 != null)
            ((ContentProviderOperation.Builder)localObject1).withValueBackReference("tree_entity_id", ((Integer)localObject3).intValue());
          g(paramNode, localContentValues, "time_created");
          h(paramNode, localContentValues, "time_last_updated");
          k(paramNode, localContentValues, "server_id");
          a(localContentValues, (Long)localObject2, "account_id");
          c(paramNode, localContentValues);
          paramNode = paramNode.getBlob();
          if (paramNode == null)
            break label526;
          localObject2 = paramNode.getType();
          localObject3 = paramNode.getMimetype();
          com.google.android.keep.util.r.a("KeepSync", "Blob's TYPE " + (String)localObject2, new Object[0]);
          com.google.android.keep.util.r.a("KeepSync", "Blob's MIME_TYPE " + (String)localObject3, new Object[0]);
          if (!"IMAGE".equals(localObject2))
            break label390;
          if (i.j.isSupported((String)localObject3))
          {
            com.google.android.keep.util.r.a("KeepSync", "Image blob with media ID " + paramNode.getMediaId() + " and mime type " + (String)localObject3, new Object[0]);
            c(paramNode, localContentValues);
            FJ.add(((ContentProviderOperation.Builder)localObject1).withValues(localContentValues).build());
            return;
          }
        }
        catch (IllegalStateException paramNode)
        {
          com.google.android.keep.util.r.e("KeepSync", "Blob's parent is not in the root stack.", new Object[0]);
          return;
        }
        com.google.android.keep.util.r.e("KeepSync", "Unknown mimeType for image: " + (String)localObject3, new Object[0]);
        return;
        label390: if (!"AUDIO".equals(localObject2))
          break label494;
        if (!i.y.isSupported((String)localObject3))
          break;
        com.google.android.keep.util.r.a("KeepSync", "Audio blob with media ID " + paramNode.getMediaId() + " and mime type " + (String)localObject3, new Object[0]);
        b(paramNode, localContentValues);
      }
      com.google.android.keep.util.r.e("KeepSync", "Unknown mimeType for audio: " + (String)localObject3, new Object[0]);
      return;
      label494: com.google.android.keep.util.r.e("KeepSync", "Unknown type: " + (String)localObject2, new Object[0]);
      return;
      label526: com.google.android.keep.util.r.e("KeepSync", "Blob with missing media", new Object[0]);
      return;
    }
    ContentValues localContentValues = new ContentValues();
    k(paramNode, localContentValues, "server_id");
    c(paramNode, localContentValues);
    localContentValues.put("is_dirty", Integer.valueOf(0));
    localContentValues.put("is_deleted", Integer.valueOf(0));
    localObject3 = paramNode.getBlob();
    if (localObject3 != null)
    {
      localObject2 = ((Blob)localObject3).getType();
      localObject3 = ((Blob)localObject3).getMimetype();
      if (("IMAGE".equals(localObject2)) && (i.j.isSupported((String)localObject3)))
        a(paramNode, localContentValues);
    }
    FJ.add(((ContentProviderOperation.Builder)localObject1).withValues(localContentValues).build());
  }

  private void c(Node paramNode, ContentValues paramContentValues)
  {
    String str = paramNode.getBaseVersion();
    if (str == null)
    {
      com.google.android.keep.util.r.e("KeepSync", "Missing base version in sync request from server " + fr.getName() + " " + paramNode.getId(), new Object[0]);
      return;
    }
    paramContentValues.put("base_version", str);
  }

  private void c(Node paramNode, ContentValues paramContentValues, String paramString)
  {
    if (paramNode.getSortValue() != null)
    {
      com.google.android.keep.util.r.a("KeepSync", "Sort value is: " + paramNode.getSortValue(), new Object[0]);
      paramContentValues.put(paramString, paramNode.getSortValue());
    }
  }

  private void d(Blob paramBlob, ContentValues paramContentValues)
  {
    if ((paramBlob != null) && ("IMAGE".equals(paramBlob.getType())) && (i.j.isSupported(paramBlob.getMimetype())));
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool);
      paramContentValues.put("extraction_status", Integer.valueOf(ImageBlob.N(paramBlob.getExtractionStatus())));
      paramContentValues.put("extracted_text", paramBlob.getExtractedText());
      return;
    }
  }

  private void d(Node paramNode, ContentValues paramContentValues)
  {
    paramContentValues.put("realtime_data_server_version", paramNode.getRealtimeDataServerVersion());
  }

  private void d(Node paramNode, ContentValues paramContentValues, String paramString)
  {
    paramNode = paramNode.getColor();
    com.google.android.keep.util.r.a("KeepSync", "Color key: " + paramNode, new Object[0]);
    if ((TextUtils.isEmpty(paramNode)) || ("DEFAULT".equals(paramNode)))
    {
      paramContentValues.put(paramString, i.g.Co);
      return;
    }
    paramContentValues.put(paramString, paramNode);
  }

  private boolean d(Node paramNode)
  {
    paramNode = paramNode.getTimestamps().getDeleted();
    return (paramNode != null) && (paramNode.getValue() > 0L);
  }

  private void e(Node paramNode)
  {
    Object localObject1 = paramNode.getId();
    Object localObject2 = (a)FG.get(localObject1);
    if (localObject2 != null)
    {
      localObject1 = ((a)localObject2).Gd;
      localObject2 = ((a)localObject2).Ge;
      com.google.android.keep.util.r.a("KeepSync", "Deleting node %s from table", new Object[] { localObject1, localObject2 });
      if ("tree_entity".equals(localObject2))
      {
        FK.add(localObject1);
        FO.add(paramNode.getServerId());
      }
      do
      {
        return;
        if ("blob_node".equals(localObject2))
        {
          FL.add(localObject1);
          return;
        }
      }
      while (!"list_item".equals(localObject2));
      FM.add(localObject1);
      return;
    }
    com.google.android.keep.util.r.a("KeepSync", "Couldn't find the item. Skipped deletion.", new Object[0]);
  }

  private void e(Node paramNode, ContentValues paramContentValues)
  {
    paramNode = paramNode.getRoleInfo();
    if (paramNode != null)
    {
      paramNode = paramNode.iterator();
      while (paramNode.hasNext())
      {
        Node.RoleInfo localRoleInfo = (Node.RoleInfo)paramNode.next();
        if (fr.getName().equalsIgnoreCase(localRoleInfo.getEmail()))
        {
          paramNode = Sharee.Role.aq(localRoleInfo.getRole());
          if (!Sharee.Role.zy.equals(paramNode))
            break label87;
        }
      }
    }
    label87: for (int i = 1; ; i = 0)
    {
      paramContentValues.put("is_owner", Integer.valueOf(i));
      return;
    }
  }

  private void e(Node paramNode, ContentValues paramContentValues, String paramString)
  {
    int i = 0;
    if (paramNode.getChecked() != null)
    {
      com.google.android.keep.util.r.a("KeepSync", "Is checked: " + paramNode.getChecked(), new Object[0]);
      if (paramNode.getChecked().booleanValue())
        i = 1;
      paramContentValues.put(paramString, Integer.valueOf(i));
      return;
    }
    paramContentValues.put(paramString, Integer.valueOf(0));
  }

  private void f(Node paramNode, ContentValues paramContentValues)
  {
    String str = paramNode.getShareState();
    int i;
    if (!TextUtils.isEmpty(str))
    {
      if ("NEW".equals(str))
      {
        i = 0;
        paramContentValues.put("has_read", Integer.valueOf(i));
      }
    }
    else
    {
      paramContentValues.put("sharer_email", paramNode.getSharerEmail());
      paramContentValues.put("last_modifier_email", paramNode.getLastModifierEmail());
      paramNode = paramNode.getTimestamps().getRecentSharedChangesSeen();
      if (paramNode != null)
        break label88;
    }
    label88: for (paramNode = null; ; paramNode = Long.valueOf(paramNode.getValue()))
    {
      paramContentValues.put("last_changes_seen_timestamp", paramNode);
      return;
      i = 1;
      break;
    }
  }

  private void f(Node paramNode, ContentValues paramContentValues, String paramString)
  {
    int i = 0;
    if (paramNode.getIsArchived() != null)
    {
      com.google.android.keep.util.r.a("KeepSync", "Is archived: " + paramNode.getIsArchived(), new Object[0]);
      if (paramNode.getIsArchived().booleanValue())
        i = 1;
      paramContentValues.put(paramString, Integer.valueOf(i));
    }
  }

  private void g(Node paramNode, ContentValues paramContentValues, String paramString)
  {
    if (paramNode.getTimestamps() != null)
    {
      com.google.android.keep.util.r.a("KeepSync", "Time created: " + paramNode.getTimestamps().getCreated(), new Object[0]);
      DateTime localDateTime = paramNode.getTimestamps().getCreated();
      if (localDateTime != null)
        paramContentValues.put(paramString, Long.valueOf(localDateTime.getValue()));
    }
    else
    {
      return;
    }
    com.google.android.keep.util.r.d("KeepSync", "Missing timeCreated for node %s, using current time", new Object[] { paramNode.getServerId() });
    paramContentValues.put(paramString, Long.valueOf(System.currentTimeMillis()));
  }

  private void h(Node paramNode, ContentValues paramContentValues, String paramString)
  {
    if (paramNode.getTimestamps() != null)
    {
      com.google.android.keep.util.r.a("KeepSync", "Time last updated: " + paramNode.getTimestamps().getUpdated(), new Object[0]);
      DateTime localDateTime = paramNode.getTimestamps().getUpdated();
      if (localDateTime != null)
        paramContentValues.put(paramString, Long.valueOf(localDateTime.getValue()));
    }
    else
    {
      return;
    }
    com.google.android.keep.util.r.d("KeepSync", "Missing timeUpdated for node %s, using current time", new Object[] { paramNode.getServerId() });
    paramContentValues.put(paramString, Long.valueOf(System.currentTimeMillis()));
  }

  private Map<String, Long> i(Long paramLong)
  {
    if (paramLong == null);
    do
    {
      return null;
      paramLong = String.valueOf(paramLong);
      long l = fr.getId();
      paramLong = mContext.getContentResolver().query(i.t.BX, new String[] { "_id", "email" }, "tree_entity_id=? AND account_id=?", new String[] { paramLong, String.valueOf(l) }, null);
    }
    while (paramLong == null);
    HashMap localHashMap = Maps.newHashMapWithExpectedSize(paramLong.getCount());
    try
    {
      paramLong.moveToPosition(-1);
      while (paramLong.moveToNext())
        localHashMap.put(paramLong.getString(1), Long.valueOf(paramLong.getLong(0)));
    }
    finally
    {
      paramLong.close();
    }
    paramLong.close();
    return localMap;
  }

  private void i(Node paramNode, ContentValues paramContentValues, String paramString)
  {
    String str = paramNode.getText();
    paramNode = str;
    if (str == null)
      paramNode = "";
    paramContentValues.put(paramString, paramNode);
  }

  private List<Long> j(Long paramLong)
  {
    if ((paramLong == null) || (paramLong.longValue() == -1L));
    do
    {
      return null;
      paramLong = String.valueOf(paramLong);
      paramLong = mContext.getContentResolver().query(i.o.BX, new String[] { "_id" }, "tree_entity_id=?", new String[] { paramLong }, null);
    }
    while (paramLong == null);
    ArrayList localArrayList = new ArrayList();
    try
    {
      paramLong.moveToPosition(-1);
      while (paramLong.moveToNext())
        localArrayList.add(Long.valueOf(paramLong.getLong(0)));
    }
    finally
    {
      paramLong.close();
    }
    paramLong.close();
    return localList;
  }

  private void j(Node paramNode, ContentValues paramContentValues, String paramString)
  {
    String str = paramNode.getTitle();
    paramNode = str;
    if (str == null)
      paramNode = "";
    paramContentValues.put(paramString, paramNode);
  }

  private Map<String, Long> k(Long paramLong)
  {
    HashMap localHashMap = new HashMap();
    if (paramLong == null);
    do
    {
      return localHashMap;
      paramLong = String.valueOf(paramLong);
      long l = fr.getId();
      paramLong = mContext.getContentResolver().query(i.p.BX, new String[] { "label_id", "_id" }, "tree_entity_id=? AND account_id=?", new String[] { paramLong, String.valueOf(l) }, null);
    }
    while (paramLong == null);
    try
    {
      paramLong.moveToPosition(-1);
      while (paramLong.moveToNext())
        localHashMap.put(paramLong.getString(0), Long.valueOf(paramLong.getLong(1)));
    }
    finally
    {
      paramLong.close();
    }
    paramLong.close();
    return localMap;
  }

  private void k(Node paramNode, ContentValues paramContentValues, String paramString)
  {
    paramNode = paramNode.getServerId();
    if (paramNode == null)
      throw new IllegalStateException("Missing server id in sync request from server.");
    paramContentValues.put(paramString, paramNode);
  }

  private boolean k(String paramString1, String paramString2)
  {
    paramString1 = aZ(paramString1);
    if ((paramString1 == null) || (paramString1.getShareRequests() == null));
    do
      while (!paramString1.hasNext())
      {
        return false;
        paramString1 = paramString1.getShareRequests().iterator();
      }
    while (!TextUtils.equals(paramString2, ((Node.ShareRequests)paramString1.next()).getEmail()));
    return true;
  }

  private boolean l(Long paramLong)
  {
    if ((paramLong == null) || (paramLong.longValue() == -1L));
    do
    {
      return false;
      ContentResolver localContentResolver = mContext.getContentResolver();
      Uri localUri = i.t.CONTENT_URI;
      paramLong = "tree_entity_id=" + paramLong;
      paramLong = localContentResolver.query(localUri, new String[] { "_id" }, paramLong, null, null);
    }
    while (paramLong == null);
    try
    {
      int i = paramLong.getCount();
      if (i > 0)
      {
        bool = true;
        return bool;
      }
      boolean bool = false;
    }
    finally
    {
      paramLong.close();
    }
  }

  private Map<String, Long> lk()
  {
    HashMap localHashMap = new HashMap();
    long l = fr.getId();
    Cursor localCursor = mContext.getContentResolver().query(i.k.BX, new String[] { "uuid", "_id" }, "account_id=?", new String[] { String.valueOf(l) }, null);
    if (localCursor == null)
      return localHashMap;
    try
    {
      if (localCursor.moveToNext())
        localHashMap.put(localCursor.getString(0), Long.valueOf(localCursor.getLong(1)));
    }
    finally
    {
      localCursor.close();
    }
    return localMap;
  }

  private void ll()
  {
    Object localObject = FB.getResponseHeader();
    int j = 0;
    int i;
    if (localObject == null)
      i = 1;
    while (true)
    {
      if (i != 0)
        A.ak(mContext);
      return;
      Config.UpgradeType localUpgradeType = Config.UpgradeType.bx(((DownSync.ResponseHeader)localObject).getUpdateState());
      if ((localUpgradeType == null) || (localUpgradeType == Config.UpgradeType.Pu))
      {
        i = 1;
      }
      else
      {
        localObject = ((DownSync.ResponseHeader)localObject).getLatestClientVersion();
        i = j;
        if (localObject != null)
        {
          i = j;
          if (((DownSync.ResponseHeader.LatestClientVersion)localObject).getMajor() != null)
          {
            i = j;
            if (((DownSync.ResponseHeader.LatestClientVersion)localObject).getMinor() != null)
            {
              i = j;
              if (((DownSync.ResponseHeader.LatestClientVersion)localObject).getBuild() != null)
              {
                i = j;
                if (((DownSync.ResponseHeader.LatestClientVersion)localObject).getRevision() != null)
                {
                  localObject = C.b(((DownSync.ResponseHeader.LatestClientVersion)localObject).getMajor().intValue(), ((DownSync.ResponseHeader.LatestClientVersion)localObject).getMinor().intValue(), ((DownSync.ResponseHeader.LatestClientVersion)localObject).getBuild().intValue(), ((DownSync.ResponseHeader.LatestClientVersion)localObject).getRevision().intValue());
                  com.google.android.keep.util.r.a("KeepSync", "Upgrade type: " + localUpgradeType, new Object[0]);
                  com.google.android.keep.util.r.a("KeepSync", "Upgrade version: " + (String)localObject, new Object[0]);
                  A.a(mContext, localUpgradeType);
                  A.r(mContext, (String)localObject);
                  i = j;
                }
              }
            }
          }
        }
      }
    }
  }

  private void lm()
  {
    FT = new HashMap();
    Cursor localCursor = mContext.getContentResolver().query(i.k.BX, new String[] { "uuid", "merged_uuids" }, null, null, null);
    if (localCursor != null)
    {
      try
      {
        if (localCursor.moveToNext())
        {
          String str1 = localCursor.getString(0);
          Iterator localIterator = i.k.aI(localCursor.getString(1)).iterator();
          while (localIterator.hasNext())
          {
            String str2 = (String)localIterator.next();
            FT.put(str2, str1);
          }
        }
      }
      finally
      {
        localCursor.close();
      }
      localCursor.close();
    }
  }

  private void ln()
  {
    if (FS.size() > 0)
    {
      Object localObject = TextUtils.join(",", FS);
      localObject = "_id IN (" + (String)localObject + ") AND " + "is_dirty" + "=?";
      localObject = ContentProviderOperation.newUpdate(i.p.BX).withValue("is_dirty", Integer.valueOf(0)).withSelection((String)localObject, new String[] { String.valueOf(1) });
      FJ.add(((ContentProviderOperation.Builder)localObject).build());
    }
  }

  private void lo()
  {
    if (FR.size() > 0)
    {
      com.google.android.keep.util.r.a("KeepSync", "# of NoteLabels to delete: " + FR.size(), new Object[0]);
      Object localObject = TextUtils.join(",", FR);
      localObject = "_id IN (" + (String)localObject + ")";
      localObject = ContentProviderOperation.newDelete(i.p.BX).withSelection((String)localObject, null);
      FJ.add(((ContentProviderOperation.Builder)localObject).build());
    }
  }

  private ContentProviderOperation lp()
  {
    com.google.android.keep.util.r.a("KeepSync", "Update last synced version for account " + fr.getName() + " to version " + FB.getToVersion(), new Object[0]);
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("last_sync_version", FB.getToVersion());
    return ContentProviderOperation.newUpdate(i.a.BX).withValues(localContentValues).withSelection("name=?", new String[] { fr.getName() }).build();
  }

  private int x(List<UserInfo.Labels> paramList)
  {
    if (paramList == null)
      return 0;
    ArrayList localArrayList = new ArrayList();
    Map localMap = lk();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      UserInfo.Labels localLabels = (UserInfo.Labels)paramList.next();
      String str = localLabels.getMainId();
      Long localLong = (Long)localMap.get(str);
      if (localLong != null)
        localMap.remove(str);
      if (!a(localArrayList, localLabels, localLong))
        return 2;
    }
    a(localArrayList, localMap);
    return b(localArrayList);
  }

  private int y(List<Node> paramList)
  {
    lm();
    int i = 0;
    int j = Config.nA();
    int k = paramList.size();
    while (i + j < k)
      try
      {
        z(paramList.subList(i, i + j));
        i += j;
        int m = b(FJ);
        if (m != 0)
          return m;
      }
      catch (VersionNumberNotFoundException paramList)
      {
        return 4;
      }
      catch (UnknownParentIdException paramList)
      {
        return 5;
      }
    try
    {
      z(paramList.subList(i, k));
      FJ.add(lp());
      return b(FJ);
    }
    catch (VersionNumberNotFoundException paramList)
    {
      return 4;
    }
    catch (UnknownParentIdException paramList)
    {
    }
    return 5;
  }

  private void z(List<Node> paramList)
    throws DownSyncResponseProcessor.VersionNumberNotFoundException, DownSyncResponseProcessor.UnknownParentIdException
  {
    FG.clear();
    FH.clear();
    FI.clear();
    FJ.clear();
    FK.clear();
    FL.clear();
    FM.clear();
    FP.clear();
    FQ.clear();
    FR.clear();
    FS.clear();
    FN.clear();
    FO.clear();
    Object localObject = ContentUris.withAppendedId(i.a.BX, fr.getId());
    FJ.add(ContentProviderOperation.newAssertQuery((Uri)localObject).withExpectedCount(1).build());
    com.google.android.keep.util.r.a("KeepSync", "applyNonEmptyResults - Process the result and increment the synced version number", new Object[0]);
    A(paramList);
    com.google.android.keep.util.r.a("KeepSync", "\n******* Ready to process all nodes **********", new Object[0]);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject = (Node)paramList.next();
      if (d((Node)localObject))
      {
        e((Node)localObject);
      }
      else
      {
        SyncType localSyncType = SyncType.ba(((Node)localObject).getType());
        switch (1.FU[localSyncType.ordinal()])
        {
        case 5:
        default:
          break;
        case 1:
          a((Node)localObject, 0);
          break;
        case 2:
          a((Node)localObject, 1);
          break;
        case 3:
          c((Node)localObject);
          break;
        case 4:
          b((Node)localObject);
        }
      }
    }
    if (FL.size() > 0)
    {
      com.google.android.keep.util.r.a("KeepSync", "# of blobs to delete: " + FL.size(), new Object[0]);
      paramList = ContentProviderOperation.newDelete(i.e.BX);
      paramList.withSelection("(blob_node._id IN (" + TextUtils.join(",", FL) + "))", null);
      FJ.add(paramList.build());
    }
    if (FM.size() > 0)
    {
      com.google.android.keep.util.r.a("KeepSync", "# of list items to delete: " + FM.size(), new Object[0]);
      paramList = ContentProviderOperation.newDelete(i.m.BX);
      paramList.withSelection("(_id IN (" + TextUtils.join(",", FM) + "))", null);
      FJ.add(paramList.build());
    }
    if (FK.size() > 0)
    {
      paramList = TextUtils.join(",", FK);
      localObject = "tree_entity_id IN (" + paramList + ")" + " AND " + "account_id" + "=?";
      long l = fr.getId();
      localObject = ContentProviderOperation.newDelete(i.t.BX).withSelection((String)localObject, new String[] { String.valueOf(l) });
      FJ.add(((ContentProviderOperation.Builder)localObject).build());
      com.google.android.keep.util.r.a("KeepSync", "# of tree entities to delete: " + FK.size(), new Object[0]);
      localObject = ContentProviderOperation.newDelete(i.v.BX);
      ((ContentProviderOperation.Builder)localObject).withSelection("(_id IN (" + paramList + "))", null);
      FJ.add(((ContentProviderOperation.Builder)localObject).build());
    }
    if ((FN.size() > 0) || (FO.size() > 0))
    {
      Log.i("KeepSync", "documents to pin: " + FN.size() + " Documents to unpin: " + FO.size());
      if (!gh.isConnected())
        gh.blockingConnect();
      if (gh.isConnected())
        Drive.DriveFirstPartyApi.requestRealtimeDocumentSync(gh, FN, FO);
    }
    if (FQ.size() > 0)
    {
      paramList = TextUtils.join(",", FQ);
      paramList = "_id IN (" + paramList + ") AND " + "is_dirty" + "=?";
      localObject = new ContentValues();
      ((ContentValues)localObject).put("is_dirty", Integer.valueOf(0));
      paramList = ContentProviderOperation.newUpdate(i.t.BX).withValues((ContentValues)localObject).withSelection(paramList, new String[] { String.valueOf(1) });
      FJ.add(paramList.build());
    }
    if (FP.size() > 0)
    {
      com.google.android.keep.util.r.a("KeepSync", "# of sharees to delete: " + FP.size(), new Object[0]);
      paramList = TextUtils.join(",", FP);
      paramList = "_id IN (" + paramList + ") AND (" + "is_dirty" + "=? OR " + "is_deleted" + "=?)";
      paramList = ContentProviderOperation.newDelete(i.t.BX).withSelection(paramList, new String[] { String.valueOf(0), String.valueOf(1) });
      FJ.add(paramList.build());
    }
    ln();
    lo();
  }

  public int lj()
  {
    List localList1;
    List localList2;
    if (FB.getNodes() == null)
    {
      localList1 = Collections.emptyList();
      localList2 = a(FB.getUserInfo());
      if ((!TextUtils.isEmpty(FB.getToVersion())) && ((!FB.getToVersion().equals(FC)) || (!localList1.isEmpty()) || (localList2 != null)))
        break label86;
      i = 0;
    }
    label86: int j;
    do
    {
      return i;
      localList1 = FB.getNodes();
      break;
      j = x(localList2);
      i = j;
    }
    while (j != 0);
    int i = y(localList1);
    if (i == 0)
      a(FE, FD);
    ll();
    return i;
  }

  public static enum SyncType
  {
    private static final Map<String, SyncType> Gb;
    private final String mTypeName;

    static
    {
      Gb = new HashMap();
      SyncType[] arrayOfSyncType = values();
      int j = arrayOfSyncType.length;
      int i = 0;
      while (i < j)
      {
        SyncType localSyncType = arrayOfSyncType[i];
        Gb.put(localSyncType.mTypeName, localSyncType);
        i += 1;
      }
    }

    private SyncType(String paramString)
    {
      mTypeName = paramString;
    }

    public static SyncType ba(String paramString)
    {
      SyncType localSyncType = (SyncType)Gb.get(paramString);
      paramString = localSyncType;
      if (localSyncType == null)
        paramString = Ga;
      return paramString;
    }

    public String getTypeName()
    {
      return mTypeName;
    }
  }

  private static final class UnknownParentIdException extends Exception
  {
    public UnknownParentIdException(String paramString)
    {
      super();
    }
  }

  private static final class VersionNumberNotFoundException extends Exception
  {
    public VersionNumberNotFoundException(String paramString, Integer paramInteger)
    {
      super();
    }
  }

  private static class a
  {
    public final Long Gd;
    public final String Ge;
    public final String serverId;

    a(Long paramLong, String paramString1, String paramString2)
    {
      Gd = paramLong;
      Ge = paramString1;
      serverId = paramString2;
    }
  }
}
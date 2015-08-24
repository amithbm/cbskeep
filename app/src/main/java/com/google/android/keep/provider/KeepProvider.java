package com.google.android.keep.provider;

import android.accounts.AccountManager;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.OperationApplicationException;
import android.content.UriMatcher;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Log;
import com.android.common.content.SQLiteContentProvider;
import com.google.android.keep.model.VoiceBlob;
import com.google.android.keep.sharing.SharingNotificationService;
import com.google.android.keep.util.Config;
import com.google.android.keep.util.h;
import com.google.android.keep.util.r;
import com.google.api.client.util.Lists;
import com.google.common.collect.Maps;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class KeepProvider extends SQLiteContentProvider
{
  private static final UriMatcher CM = new UriMatcher(-1);
  private static final Map<String, String> CN = Maps.newHashMap();
  private static final Map<String, String> CO = Maps.newHashMap();
  private static final Map<String, String> CP = Maps.newHashMap();
  private static final Map<String, String> CQ = Maps.newHashMap();
  private static final Map<String, String> CR = Maps.newHashMap();
  private static final Map<String, String> CS = Maps.newHashMap();
  private static final Map<String, String> CT = Maps.newHashMap();
  private static final Map<String, String> CU = Maps.newHashMap();
  private static final Map<String, String> CV = Maps.newHashMap();
  private static final Map<String, String> CW = Maps.newHashMap();
  private static final Map<String, String> CX = Maps.newHashMap();
  private static final Map<String, String> CY = Maps.newHashMap();
  private static final Map<String, String> CZ = Maps.newHashMap();
  private static final Map<String, String> Da = Maps.newHashMap();
  private static final long Db = ReorderEntitiesHelper.Db;
  private final ThreadLocal<ArrayList<Long>> Dc = new ThreadLocal();
  private SQLiteOpenHelper Dd;
  private ContentResolver mContentResolver;

  static
  {
    a(i.a.CONTENT_URI, 800);
    a(i.a.CONTENT_URI, "#", 801);
    a(i.v.CONTENT_URI, 100);
    a(i.v.CONTENT_URI, "#", 101);
    a(i.v.Ck, 200);
    a(i.v.Ck, "#", 203);
    a(i.v.CA, 202);
    a(i.v.CA, "#", 205);
    a(i.v.CJ, "#", 206);
    a(i.q.Cx, "tree_entities", 501);
    a(i.q.Cy, "tree_entities", 502);
    a(i.q.Cx, "list_items", 503);
    a(i.q.Cy, "list_items", 504);
    a(i.e.CONTENT_URI, 600);
    a(i.e.CONTENT_URI, "#", 601);
    a(i.j.Cq, "#", 602);
    a(i.y.CK, "#", 603);
    a(i.j.Cr, "#/#", 604);
    a(i.y.CL, "#/#", 605);
    a(i.e.Cf, 606);
    a(i.i.Cp, "#", 610);
    a(i.l.CONTENT_URI, "#", 700);
    a(i.w.CONTENT_URI, "#", 701);
    a(i.v.Cb, "#", 1200);
    a(i.v.Cc, "#", 1201);
    a(i.v.Cd, "#", 1202);
    a(i.v.Ce, "#", 1203);
    a(i.v.Cb, 1204);
    a(i.v.Cc, 1205);
    a(i.v.Cd, 1206);
    a(i.v.Ce, 1207);
    a(i.v.CI, 1208);
    a(i.v.CC, 1209);
    a(i.v.CE, "#", 1210);
    a(i.v.CF, "#", 1211);
    a(i.v.CG, "#", 1212);
    a(i.v.CH, "#", 1213);
    a(i.v.CD, "#", 1214);
    a(i.f.Ch, 1820);
    a(i.f.Ci, 1800);
    a(i.f.Ck, 1801);
    a(i.f.Cj, 1806);
    a(i.f.Cl, 1802);
    a(i.f.Cm, 1804);
    a(i.f.Cm, "#", 1805);
    a(i.e.Cb, "#", 1300);
    a(i.e.Cc, "#", 1301);
    a(i.e.Cd, "#", 1302);
    a(i.e.Ce, "#", 1303);
    a(i.e.Cb, 1304);
    a(i.e.Cc, 1305);
    a(i.e.Cd, 1306);
    a(i.e.Ce, 1307);
    a(i.m.CONTENT_URI, 1100);
    a(i.m.CONTENT_URI, "#", 1101);
    a(i.n.CONTENT_URI, 1120);
    a(i.n.CONTENT_URI, "#", 1122);
    a(i.n.Ct, 1121);
    a(i.m.Cb, "#", 1400);
    a(i.m.Cc, "#", 1401);
    a(i.m.Cd, "#", 1402);
    a(i.m.Ce, "#", 1403);
    a(i.m.Cb, 1404);
    a(i.m.Cc, 1405);
    a(i.m.Cd, 1406);
    a(i.m.Ce, 1407);
    a(i.c.CONTENT_URI, 1600);
    a(i.c.CONTENT_URI, "#", 1601);
    a(i.t.CONTENT_URI, 1900);
    a(i.t.CONTENT_URI, "#", 1901);
    a(i.o.CONTENT_URI, 2000);
    a(i.o.CONTENT_URI, "#", 2001);
    a(i.k.CONTENT_URI, 2100);
    a(i.k.CONTENT_URI, "#", 2101);
    a(i.p.CONTENT_URI, 2200);
    a(i.p.CONTENT_URI, "#", 2201);
    CN.put("_id", "_id");
    CN.put("name", "name");
    CN.put("last_sync_version", "last_sync_version");
    CO.put("_id", "tree_entity._id");
    CO.put("account_id", "tree_entity.account_id");
    CO.put("uuid", "tree_entity.uuid");
    CO.put("server_id", "tree_entity.server_id");
    CO.put("type", "tree_entity.type");
    CO.put("title", "tree_entity.title");
    CO.put("color_name", "tree_entity.color_name");
    CO.put("parent_id", "tree_entity.parent_id");
    CO.put("order_in_parent", "tree_entity.order_in_parent");
    CO.put("is_archived", "tree_entity.is_archived");
    CO.put("is_trashed", "tree_entity.is_trashed");
    CO.put("has_read", "tree_entity.has_read");
    CO.put("sharer_email", "tree_entity.sharer_email");
    CO.put("is_owner", "tree_entity.is_owner");
    CO.put("last_modifier_email", "tree_entity.last_modifier_email");
    CO.put("is_graveyard_off", "tree_entity.is_graveyard_off");
    CO.put("is_graveyard_closed", "tree_entity.is_graveyard_closed");
    CO.put("is_new_list_item_from_top", "tree_entity.is_new_list_item_from_top");
    CO.put("time_created", "tree_entity.time_created");
    CO.put("time_last_updated", "tree_entity.time_last_updated");
    CO.put("user_edited_timestamp", "tree_entity.user_edited_timestamp");
    CO.put("last_changes_seen_timestamp", "tree_entity.last_changes_seen_timestamp");
    CO.put("is_dirty", "tree_entity.is_dirty");
    CO.put("is_deleted", "tree_entity.is_deleted");
    CO.put("version", "tree_entity.version");
    CO.put("base_version", "tree_entity.base_version");
    CO.put("notification_state", "tree_entity.notification_state");
    CO.put("shared_timestamp", "tree_entity.shared_timestamp");
    CO.put("is_brix_document_created", "tree_entity.is_brix_document_created");
    CO.put("realtime_data_server_version", "tree_entity.realtime_data_server_version");
    CQ.put("max_order_in_parent", "MAX(order_in_parent)");
    CQ.put("min_order_in_parent", "MIN(order_in_parent)");
    CQ.put("COUNT_ENTITIES", "COUNT(1)");
    CP.put("_id", "blob_node._id");
    CP.put("account_id", "blob_node.account_id");
    CP.put("type", "blob_node.type");
    CP.put("uuid", "blob_node.uuid");
    CP.put("server_id", "blob_node.server_id");
    CP.put("tree_entity_id", "blob_node.tree_entity_id");
    CP.put("time_created", "blob_node.time_created");
    CP.put("time_last_updated", "blob_node.time_last_updated");
    CP.put("is_dirty", "blob_node.is_dirty");
    CP.put("is_deleted", "blob_node.is_deleted");
    CP.put("version", "blob_node.version");
    CP.put("base_version", "blob_node.base_version");
    CP.put("use_edited", "blob_node.use_edited");
    CP.put("original_id", "blob_node.original_id");
    CP.put("edited_id", "blob_node.edited_id");
    CP.put("blob_id", "blob.blob_id");
    CP.put("blob_account_id", "blob.blob_account_id");
    CP.put("blob_type", "blob.blob_type");
    CP.put("mime_type", "blob.mime_type");
    CP.put("media_id", "blob.media_id");
    CP.put("file_name", "blob.file_name");
    CP.put("blob_size", "blob.blob_size");
    CP.put("data1", "blob.data1");
    CP.put("data2", "blob.data2");
    CP.put("extracted_text", "blob.extracted_text");
    CP.put("extraction_status", "blob.extraction_status");
    CW.put("_id", "alert._id");
    CW.put("account_id", "alert.account_id");
    CW.put("reminder_id", "alert.reminder_id");
    CW.put("alert_time", "alert.alert_time");
    CW.put("scheduled_time", "alert.scheduled_time");
    CW.put("fired_time", "alert.fired_time");
    CW.put("dismissed_time", "alert.dismissed_time");
    CW.put("state", "alert.state");
    CW.put("trigger_condition", "alert.trigger_condition");
    CW.put("_count", "COUNT(*) AS _count");
    CV.putAll(CO);
    CV.put("tree_entity._id", "tree_entity._id");
    CV.put("children", k.bI(11));
    CV.put("images", "(SELECT GROUP_CONCAT(imagesGroupConcatSourceTable._id, ' / ') FROM (SELECT imagesGroupConcatBlobsTable._id FROM blob_node AS imagesGroupConcatBlobsTable WHERE imagesGroupConcatBlobsTable.tree_entity_id=tree_entity._id AND imagesGroupConcatBlobsTable.type=0 AND imagesGroupConcatBlobsTable.is_deleted=0 ORDER BY imagesGroupConcatBlobsTable.time_created DESC LIMIT 6) AS imagesGroupConcatSourceTable)");
    CV.put("image_blob_count", "(SELECT COUNT(*) FROM blob_node AS blobCountTable WHERE tree_entity._id=blobCountTable.tree_entity_id AND blobCountTable.is_deleted=0 AND blobCountTable.type=0)");
    CV.put("voice_blob_count", "(SELECT COUNT(*) FROM blob_node AS blobCountTable WHERE tree_entity._id=blobCountTable.tree_entity_id AND blobCountTable.is_deleted=0 AND blobCountTable.type=1)");
    CV.put("has_conflict", "(SELECT COUNT(1) FROM list_item_conflict WHERE tree_entity._id=list_item_conflict.list_parent_id)");
    CV.put("sharee_count", "(SELECT COUNT(1) FROM sharing WHERE tree_entity._id=sharing.tree_entity_id AND sharing.is_deleted=0)");
    CV.put("sharees", n.bI(0));
    CR.put("_id", "list_item._id");
    CR.put("account_id", "list_item.account_id");
    CR.put("uuid", "list_item.uuid");
    CR.put("server_id", "list_item.server_id");
    CR.put("text", "list_item.text");
    CR.put("list_parent_id", "list_item.list_parent_id");
    CR.put("order_in_parent", "list_item.order_in_parent");
    CR.put("time_created", "list_item.time_created");
    CR.put("time_last_updated", "list_item.time_last_updated");
    CR.put("is_checked", "list_item.is_checked");
    CR.put("is_dirty", "list_item.is_dirty");
    CR.put("is_deleted", "list_item.is_deleted");
    CR.put("base_version", "list_item.base_version");
    CR.put("realtime_data_server_version", "list_item.realtime_data_server_version");
    CR.put("merge_token", "list_item.merge_token");
    CR.put("version", "list_item.version");
    CT.put("max_order_in_parent", "MAX(order_in_parent)");
    CT.put("min_order_in_parent", "MIN(order_in_parent)");
    CT.put("COUNT_ENTITIES", "COUNT(1)");
    CU.put("_id", "list_item_conflict._id");
    CU.put("server_id", "list_item_conflict.server_id");
    CU.put("text", "list_item_conflict.text");
    CU.put("list_parent_id", "list_item_conflict.list_parent_id");
    CU.put("time_last_updated", "list_item_conflict.time_last_updated");
    CU.put("is_checked", "list_item_conflict.is_checked");
    CU.put("merge_token", "list_item_conflict.merge_token");
    CS.putAll(CR);
    CS.put("list_item_conflict._id", "list_item_conflict._id");
    CS.put("list_item_conflict.server_id", "list_item_conflict.server_id");
    CS.put("list_item_conflict.text", "list_item_conflict.text");
    CS.put("list_item_conflict.list_parent_id", "list_item_conflict.list_parent_id");
    CS.put("list_item_conflict.time_last_updated", "list_item_conflict.time_last_updated");
    CS.put("list_item_conflict.is_checked", "list_item_conflict.is_checked");
    CS.put("list_item_conflict.merge_token", "list_item_conflict.merge_token");
    CX.put("_id", "sharing._id");
    CX.put("tree_entity_id", "sharing.tree_entity_id");
    CX.put("email", "sharing.email");
    CX.put("name", "sharing.name");
    CX.put("role", "sharing.role");
    CX.put("avatar_uri", "sharing.avatar_uri");
    CX.put("is_dirty", "sharing.is_dirty");
    CX.put("is_deleted", "sharing.is_deleted");
    CX.put("account_id", "sharing.account_id");
    CX.put("gaia_id", "sharing.gaia_id");
    CY.put("_id", "note_error._id");
    CY.put("tree_entity_id", "note_error.tree_entity_id");
    CY.put("code", "note_error.code");
    CY.put("data", "note_error.data");
    CY.put("account_id", "note_error.account_id");
    CY.put("time_created", "note_error.time_created");
    CY.put("dismissed", "note_error.dismissed");
    CZ.put("_id", "label._id");
    CZ.put("uuid", "label.uuid");
    CZ.put("name", "label.name");
    CZ.put("account_id", "label.account_id");
    CZ.put("version", "label.version");
    CZ.put("server_version_number", "label.server_version_number");
    CZ.put("last_used_timestamp", "label.last_used_timestamp");
    CZ.put("merged_uuids", "label.merged_uuids");
    CZ.put("is_deleted", "label.is_deleted");
    CZ.put("is_dirty", "label.is_dirty");
    Da.put("_id", "note_label._id");
    Da.put("tree_entity_id", "note_label.tree_entity_id");
    Da.put("label_id", "note_label.label_id");
    Da.put("account_id", "note_label.account_id");
    Da.put("is_deleted", "note_label.is_deleted");
    Da.put("is_dirty", "note_label.is_dirty");
  }

  private long Q(long paramLong)
  {
    Cursor localCursor = query(ContentUris.withAppendedId(i.v.CONTENT_URI, paramLong), new String[] { "parent_id" }, null, null, null);
    if (localCursor == null)
      return -1L;
    paramLong = -1L;
    try
    {
      if (localCursor.moveToFirst())
        paramLong = localCursor.getLong(0);
      return paramLong;
    }
    finally
    {
      localCursor.close();
    }
  }

  private int R(long paramLong)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("is_archived", Integer.valueOf(0));
    localContentValues.put("time_last_updated", Long.valueOf(System.currentTimeMillis()));
    localContentValues.put("is_dirty", Integer.valueOf(1));
    localContentValues.put("order_in_parent", Long.valueOf(e(Q(paramLong), T(paramLong).cU)));
    return mDb.update("tree_entity", localContentValues, "_id=? AND is_archived=1", new String[] { String.valueOf(paramLong) });
  }

  private int S(long paramLong)
  {
    Object localObject = T(paramLong);
    if (localObject == null)
      return 0;
    long l = e(0L, ((a)localObject).cU);
    localObject = new ContentValues();
    ((ContentValues)localObject).put("order_in_parent", Long.valueOf(l));
    return mDb.update("tree_entity", (ContentValues)localObject, "_id=?", new String[] { String.valueOf(paramLong) });
  }

  private a T(long paramLong)
  {
    Cursor localCursor = query(ContentUris.withAppendedId(i.v.BX, paramLong), new String[] { "type", "account_id" }, null, null, null);
    if (localCursor == null)
      return null;
    try
    {
      if (localCursor.moveToFirst())
      {
        a locala = new a(localCursor.getInt(0), localCursor.getLong(1));
        return locala;
      }
      throw new IllegalStateException("Tree entity " + paramLong + " could not be found");
    }
    finally
    {
      localCursor.close();
    }
  }

  private int U(long paramLong)
  {
    Cursor localCursor = mDb.query("list_item_conflict", new String[] { "server_id", "merge_token" }, "list_parent_id=?", new String[] { String.valueOf(paramLong) }, null, null, null);
    if (localCursor == null)
      return 0;
    int i = 0;
    try
    {
      while (localCursor.moveToNext())
      {
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("merge_token", localCursor.getString(1));
        localContentValues.put("is_dirty", Integer.valueOf(1));
        int j = mDb.update("list_item", localContentValues, "server_id=?", new String[] { localCursor.getString(0) });
        i += j;
      }
      localCursor.close();
      mDb.delete("list_item_conflict", "list_parent_id=?", new String[] { String.valueOf(paramLong) });
      return i;
    }
    finally
    {
      localCursor.close();
    }
  }

  private int V(long paramLong)
  {
    Cursor localCursor = mDb.query("list_item_conflict", new String[] { "server_id", "merge_token" }, "list_parent_id=?", new String[] { String.valueOf(paramLong) }, null, null, null);
    if (localCursor == null)
      return 0;
    int i = 0;
    try
    {
      while (localCursor.moveToNext())
      {
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("merge_token", localCursor.getString(1));
        localContentValues.put("is_dirty", Integer.valueOf(1));
        int j = mDb.update("list_item", localContentValues, "server_id=?", new String[] { localCursor.getString(0) });
        i += j;
      }
      localCursor.close();
      mDb.delete("list_item_conflict", "list_parent_id=?", new String[] { String.valueOf(paramLong) });
      return i;
    }
    finally
    {
      localCursor.close();
    }
  }

  private int W(long paramLong)
  {
    Cursor localCursor = mDb.query("list_item_conflict", new String[] { "server_id", "text", "is_checked" }, "list_parent_id=?", new String[] { String.valueOf(paramLong) }, null, null, null);
    if (localCursor == null)
      return 0;
    int i = 0;
    try
    {
      while (localCursor.moveToNext())
      {
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("text", localCursor.getString(1));
        localContentValues.put("is_checked", Integer.valueOf(localCursor.getInt(2)));
        localContentValues.put("merge_token", "");
        localContentValues.put("is_dirty", Integer.valueOf(0));
        int j = mDb.update("list_item", localContentValues, "server_id=?", new String[] { localCursor.getString(0) });
        i += j;
      }
      localCursor.close();
      mDb.delete("list_item_conflict", "list_parent_id=?", new String[] { String.valueOf(paramLong) });
      return i;
    }
    finally
    {
      localCursor.close();
    }
  }

  private long X(long paramLong)
  {
    String[] arrayOfString = new String[10];
    arrayOfString[0] = "account_id";
    arrayOfString[1] = "type";
    arrayOfString[2] = "title";
    arrayOfString[3] = "color_name";
    arrayOfString[4] = "parent_id";
    arrayOfString[5] = "is_archived";
    arrayOfString[6] = "is_trashed";
    arrayOfString[7] = "is_graveyard_closed";
    arrayOfString[8] = "is_graveyard_off";
    arrayOfString[9] = "is_new_list_item_from_top";
    Cursor localCursor = mDb.query("tree_entity", arrayOfString, "_id=?", new String[] { String.valueOf(paramLong) }, null, null, null);
    if (localCursor == null)
      return -1L;
    try
    {
      while (localCursor.moveToNext())
      {
        Object localObject2 = new ContentValues();
        int i = 0;
        while (i < arrayOfString.length)
        {
          ((ContentValues)localObject2).put(arrayOfString[i], localCursor.getString(i));
          i += 1;
        }
        localObject2 = a(i.v.CONTENT_URI, (ContentValues)localObject2);
        if (localObject2 != null)
        {
          paramLong = ContentUris.parseId((Uri)localObject2);
          return paramLong;
        }
      }
      return -1L;
    }
    finally
    {
      localCursor.close();
    }
  }

  private void Y(long paramLong)
  {
    if (Dc.get() == null)
      Dc.set(new ArrayList());
    ((ArrayList)Dc.get()).add(Long.valueOf(paramLong));
  }

  private int a(long paramLong, ContentValues paramContentValues)
  {
    return b(paramLong, paramContentValues) + W(paramLong);
  }

  private int a(ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    Integer localInteger = paramContentValues.getAsInteger("is_checked");
    if ((localInteger == null) || (paramContentValues.containsKey("order_in_parent")))
      return mDb.update("list_item", paramContentValues, paramString, paramArrayOfString);
    Object localObject2 = new StringBuilder().append("order_in_parent");
    if (localInteger.intValue() == 1);
    for (Object localObject1 = " ASC "; ; localObject1 = " DESC ")
    {
      localObject2 = (String)localObject1;
      localObject1 = mDb;
      localObject2 = "list_parent_id ASC, " + (String)localObject2;
      paramString = ((SQLiteDatabase)localObject1).query("list_item", new String[] { "_id", "is_checked", "list_parent_id" }, paramString, paramArrayOfString, null, null, (String)localObject2);
      if (paramString != null)
        break;
      return 0;
    }
    int i = 0;
    long l4 = -1L;
    int j = 0;
    long l2 = 0L;
    try
    {
      if (paramString.moveToNext())
      {
        long l3 = l4;
        long l1 = l2;
        if (l4 != paramString.getLong(2))
        {
          l4 = paramString.getLong(2);
          boolean bool = ReorderEntitiesHelper.a(mDb, l4);
          l3 = l4;
          l1 = l2;
          j = bool;
          if (bool)
          {
            l1 = d(l4, localInteger.intValue());
            j = bool;
            l3 = l4;
          }
        }
        l4 = paramString.getLong(0);
        if ((j != 0) && (paramString.getInt(1) != localInteger.intValue()))
          if (localInteger.intValue() == 1)
          {
            l2 = Db;
            label303: l1 += l2;
            paramContentValues.put("order_in_parent", Long.valueOf(l1));
          }
        while (true)
        {
          i += mDb.update("list_item", paramContentValues, "_id=?", new String[] { String.valueOf(l4) });
          l4 = l3;
          l2 = l1;
          break;
          l2 = -Db;
          break label303;
          paramContentValues.remove("order_in_parent");
        }
      }
    }
    finally
    {
      paramString.close();
    }
    paramString.close();
    return i;
  }

  private int a(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    if (!o(paramUri))
    {
      paramUri = paramContentValues.getAsInteger("is_deleted");
      if ((paramUri != null) && (paramUri.intValue() == 1))
        paramContentValues.put("is_dirty", Integer.valueOf(1));
      paramUri = "SELECT sharing.tree_entity_id FROM sharing WHERE " + paramString;
      c("_id IN (" + paramUri + ")", paramArrayOfString);
    }
    return mDb.update("sharing", paramContentValues, paramString, paramArrayOfString);
  }

  private int a(Uri paramUri, String paramString1, String paramString2, long paramLong1, long paramLong2, String[] paramArrayOfString1, String paramString3, String[] paramArrayOfString2)
  {
    paramString3 = h.p(paramString3, paramString2 + "=?");
    paramArrayOfString2 = com.google.android.keep.util.e.a(paramArrayOfString2, new String[] { String.valueOf(paramLong2) });
    paramString1 = mDb.query(paramString1, paramArrayOfString1, paramString3, paramArrayOfString2, null, null, null);
    int i = 0;
    if (paramString1 == null)
      return 0;
    try
    {
      paramString3.put(paramString2, Long.valueOf(paramLong1));
      if (insertInTransaction(paramUri, paramString3) != null)
        i += 1;
      if (paramString1.moveToNext())
      {
        paramString3 = new ContentValues();
        int j = 0;
        while (j < paramArrayOfString1.length)
        {
          paramString3.put(paramArrayOfString1[j], paramString1.getString(j));
          j += 1;
        }
      }
      return i;
    }
    finally
    {
      paramString1.close();
    }
    throw paramUri;
  }

  private int a(Uri paramUri, String paramString, String[] paramArrayOfString, ContentValues paramContentValues)
  {
    if (!o(paramUri))
      paramContentValues.put("is_dirty", Integer.valueOf(1));
    return mDb.update("label", paramContentValues, paramString, paramArrayOfString);
  }

  private int a(String paramString1, String paramString2, String paramString3, String[] paramArrayOfString, long paramLong)
  {
    return d("_id IN ( SELECT " + paramString1 + "." + paramString2 + " FROM " + paramString1 + " WHERE " + paramString3 + ")", paramArrayOfString, paramLong);
  }

  private int a(String paramString, String[] paramArrayOfString, int paramInt1, int paramInt2)
  {
    o(paramInt1, paramInt2);
    SQLiteDatabase localSQLiteDatabase = mDb;
    paramString = paramString + " AND " + "is_deleted" + "=" + paramInt1;
    paramString = localSQLiteDatabase.query("tree_entity", new String[] { "_id" }, paramString, paramArrayOfString, null, null, null);
    if (paramString == null)
      return 0;
    paramArrayOfString = new ArrayList(paramString.getCount());
    try
    {
      if (paramString.moveToNext())
        paramArrayOfString.add(Long.valueOf(paramString.getLong(0)));
    }
    finally
    {
      paramString.close();
    }
    paramString = "(" + TextUtils.join(",", paramArrayOfString) + ")";
    return a("tree_entity_id IN " + paramString, null, paramInt1, paramInt2, false) + b("list_parent_id IN " + paramString, null, paramInt1, paramInt2, false) + mDb.update("tree_entity", bG(paramInt2), "_id IN " + paramString, null);
  }

  private int a(String paramString, String[] paramArrayOfString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    o(paramInt1, paramInt2);
    paramString = paramString + " AND " + "is_deleted" + "=?";
    paramArrayOfString = com.google.android.keep.util.e.a(paramArrayOfString, new String[] { String.valueOf(paramInt1) });
    int i = 0;
    ContentValues localContentValues1 = bH(paramInt2);
    paramInt1 = i;
    if (paramInt2 == 1)
    {
      d(paramString, paramArrayOfString);
      paramInt1 = i;
      if (paramBoolean)
        paramInt1 = 0 + b(paramString, paramArrayOfString, localContentValues1.getAsLong("time_last_updated").longValue());
    }
    ContentValues localContentValues2 = i.e.d(localContentValues1);
    if (localContentValues1.size() > 0)
    {
      String str = a(mDb, paramString, paramArrayOfString);
      mDb.update("blob", localContentValues1, str, null);
    }
    paramInt2 = paramInt1;
    if (localContentValues2.size() > 0)
      paramInt2 = paramInt1 + mDb.update("blob_node", localContentValues2, paramString, paramArrayOfString);
    return paramInt2;
  }

  private int a(String paramString, String[] paramArrayOfString, long paramLong)
  {
    String str1 = " IN ( SELECT tree_entity._id FROM tree_entity WHERE " + paramString + ")";
    paramString = new ContentValues();
    paramString.put("is_dirty", Integer.valueOf(1));
    paramString.put("time_last_updated", Long.valueOf(paramLong));
    String str2 = "tree_entity_id" + str1;
    int i = mDb.update("blob_node", paramString, str2, paramArrayOfString);
    str1 = "list_parent_id" + str1;
    return i + mDb.update("list_item", paramString, str1, paramArrayOfString);
  }

  private int a(String paramString, String[] paramArrayOfString, ContentValues paramContentValues)
  {
    int i = mDb.update("note_error", paramContentValues, paramString, paramArrayOfString);
    if (i == -1)
      Log.e("Keep", "Failed to update error row");
    return i;
  }

  private int a(boolean paramBoolean, String paramString, String[] paramArrayOfString)
  {
    int i;
    if (paramBoolean)
    {
      i = 0;
      if (!paramBoolean)
        break label148;
    }
    ContentValues localContentValues;
    label148: for (int j = 1; ; j = 0)
    {
      localContentValues = new ContentValues();
      localContentValues.put("is_archived", Integer.valueOf(j));
      localContentValues.put("time_last_updated", Long.valueOf(System.currentTimeMillis()));
      localContentValues.put("is_dirty", Integer.valueOf(1));
      SQLiteDatabase localSQLiteDatabase = mDb;
      paramString = paramString + " AND " + "is_archived" + "=" + i;
      paramString = localSQLiteDatabase.query("tree_entity", new String[] { "_id", "account_id" }, paramString, paramArrayOfString, null, null, "tree_entity.order_in_parent DESC,tree_entity.time_last_updated DESC");
      if (paramString != null)
        break label154;
      return 0;
      i = 1;
      break;
    }
    try
    {
      label154: if (!paramString.moveToNext())
      {
        paramString.close();
        return 0;
      }
      long l1 = paramString.getLong(1);
      l1 = a(i.v.CONTENT_URI, l1, "is_archived=" + j + " AND " + "account_id" + "=" + l1, null, false, false, Db);
      i = 0;
      l1 += (paramString.getCount() - 1) * Db;
      paramString.moveToPosition(-1);
      while (paramString.moveToNext())
      {
        localContentValues.put("order_in_parent", Long.valueOf(l1));
        i += mDb.update("tree_entity", localContentValues, "_id=?", new String[] { String.valueOf(paramString.getLong(0)) });
        long l2 = Db;
        l1 -= l2;
      }
      return i;
    }
    finally
    {
      paramString.close();
    }
    throw paramArrayOfString;
  }

  private long a(Uri paramUri, long paramLong1, String paramString, String[] paramArrayOfString, boolean paramBoolean1, boolean paramBoolean2, long paramLong2)
  {
    Object localObject;
    if (paramBoolean1)
    {
      localObject = "min_order_in_parent";
      localObject = query(paramUri, new String[] { "COUNT_ENTITIES", localObject }, paramString, paramArrayOfString, null);
    }
    while (true)
    {
      long l3;
      long l2;
      try
      {
        if (((Cursor)localObject).moveToFirst())
        {
          int i = ((Cursor)localObject).getInt(0);
          if (i == 0)
          {
            l1 = 0L;
            return l1;
            localObject = "max_order_in_parent";
            break;
          }
          l3 = ((Cursor)localObject).getLong(1);
          l2 = l3 + paramLong2;
          if ((paramLong2 <= 0L) || (l2 >= l3))
            break label216;
          if (paramBoolean2)
          {
            ReorderEntitiesHelper.c(mDb, paramString, paramArrayOfString);
            paramLong1 = a(paramUri, paramLong1, paramString, paramArrayOfString, paramBoolean1, paramBoolean2, paramLong2);
            return paramLong1;
          }
          ReorderEntitiesHelper.a(mDb, paramLong1, ReorderEntitiesHelper.RebaseType.DI);
          continue;
        }
      }
      finally
      {
        ((Cursor)localObject).close();
      }
      throw new IllegalStateException("Cannot use order in parent value " + -1L);
      label216: long l1 = l2;
      if (paramLong2 < 0L)
      {
        l1 = l2;
        if (l2 <= l3);
      }
    }
  }

  private Cursor a(SQLiteDatabase paramSQLiteDatabase, SQLiteQueryBuilder paramSQLiteQueryBuilder, Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    paramSQLiteQueryBuilder.setTables("list_item");
    paramSQLiteQueryBuilder.setProjectionMap(CR);
    long l = ContentUris.parseId(paramUri);
    paramString1 = h.p(paramString1, "list_parent_id=? AND is_deleted=0");
    paramArrayOfString2 = com.google.android.keep.util.e.a(paramArrayOfString2, new String[] { String.valueOf(l) });
    paramUri = paramString2;
    if (TextUtils.isEmpty(paramString2))
      paramUri = "order_in_parent DESC, time_last_updated DESC";
    paramSQLiteQueryBuilder = a(paramSQLiteDatabase, paramSQLiteQueryBuilder, paramArrayOfString1, paramString1, paramArrayOfString2, null, paramUri);
    return new o(getContext().getContentResolver(), paramSQLiteDatabase, CO, paramSQLiteQueryBuilder, l);
  }

  private Cursor a(SQLiteDatabase paramSQLiteDatabase, SQLiteQueryBuilder paramSQLiteQueryBuilder, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2, String paramString3)
  {
    return a(paramSQLiteDatabase, paramSQLiteQueryBuilder, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2, paramString3, null);
  }

  private Cursor a(SQLiteDatabase paramSQLiteDatabase, SQLiteQueryBuilder paramSQLiteQueryBuilder, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2, String paramString3, String paramString4)
  {
    paramSQLiteDatabase = paramSQLiteQueryBuilder.query(paramSQLiteDatabase, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2, null, paramString3, paramString4);
    if (paramSQLiteDatabase != null)
      paramSQLiteDatabase.setNotificationUri(getContext().getContentResolver(), i.AUTHORITY_URI);
    return paramSQLiteDatabase;
  }

  private Cursor a(SQLiteDatabase paramSQLiteDatabase, String[] paramArrayOfString1, String paramString, String[] paramArrayOfString2)
  {
    SQLiteQueryBuilder localSQLiteQueryBuilder = new SQLiteQueryBuilder();
    localSQLiteQueryBuilder.setStrict(true);
    localSQLiteQueryBuilder.setTables("note_error");
    localSQLiteQueryBuilder.setProjectionMap(CY);
    return a(paramSQLiteDatabase, localSQLiteQueryBuilder, paramArrayOfString1, paramString, paramArrayOfString2, null, null);
  }

  private Cursor a(SQLiteDatabase paramSQLiteDatabase, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    SQLiteQueryBuilder localSQLiteQueryBuilder = new SQLiteQueryBuilder();
    localSQLiteQueryBuilder.setStrict(true);
    localSQLiteQueryBuilder.setTables("list_item_conflict");
    localSQLiteQueryBuilder.setProjectionMap(CU);
    return a(paramSQLiteDatabase, localSQLiteQueryBuilder, paramArrayOfString1, paramString1, paramArrayOfString2, null, paramString2);
  }

  private Uri a(Uri paramUri, ContentValues paramContentValues)
  {
    Object localObject = paramContentValues.getAsInteger("type");
    if (localObject == null)
      throw new IllegalArgumentException("No type was specified");
    if (!i.v.bE(((Integer)localObject).intValue()))
      throw new IllegalArgumentException("Invalid tree entity type " + localObject);
    paramContentValues.put("title", e(paramContentValues.getAsString("title"), Config.nB()));
    if (paramContentValues.getAsLong("account_id") == null)
      throw new IllegalArgumentException("Account is not set!");
    localObject = paramContentValues.getAsLong("parent_id");
    if (localObject == null);
    for (long l1 = 0L; l1 != 0L; l1 = ((Long)localObject).longValue())
      throw new IllegalArgumentException("Parent must be the root " + l1);
    localObject = paramContentValues.getAsInteger("is_archived");
    if ((localObject != null) && ((((Integer)localObject).intValue() < 0) || (((Integer)localObject).intValue() > 1)))
      throw new IllegalArgumentException("Invalid is_archived value " + localObject);
    localObject = paramContentValues.getAsInteger("is_trashed");
    if ((localObject != null) && ((((Integer)localObject).intValue() < 0) || (((Integer)localObject).intValue() > 1)))
      throw new IllegalArgumentException("Invalid isTrashed value " + localObject);
    localObject = paramContentValues.getAsString("uuid");
    String str = paramContentValues.getAsString("server_id");
    Long localLong1 = paramContentValues.getAsLong("time_created");
    Long localLong2 = paramContentValues.getAsLong("time_last_updated");
    if (o(paramUri))
    {
      if (localObject == null)
        throw new IllegalStateException("Missing UUID in insert from syncadapter");
      if (str == null)
        throw new IllegalStateException("Missing server ID in insert from syncadapter");
      if (localLong1 == null)
        throw new IllegalStateException("Missing timeCreated in insert from syncadapter for treeEntity with id " + (String)localObject);
      if (localLong2 == null)
        throw new IllegalStateException("Missing timeLastUpdated in insert from  syncadapter for treeEntity with id " + (String)localObject);
    }
    else
    {
      if (localObject == null)
        paramContentValues.put("uuid", kw());
      long l2 = System.currentTimeMillis();
      if (localLong1 == null)
        paramContentValues.put("time_created", Long.valueOf(l2));
      paramContentValues.put("time_last_updated", Long.valueOf(l2));
      paramContentValues.put("user_edited_timestamp", Long.valueOf(l2));
      paramContentValues.put("is_dirty", Integer.valueOf(1));
    }
    if (paramContentValues.getAsLong("order_in_parent") == null)
      paramContentValues.put("order_in_parent", Long.valueOf(e(l1, paramContentValues.getAsLong("account_id").longValue())));
    if (!paramContentValues.containsKey("has_read"))
      paramContentValues.put("has_read", Integer.valueOf(1));
    paramContentValues.put("notification_state", Integer.valueOf(0));
    l1 = mDb.insert("tree_entity", null, paramContentValues);
    if (l1 == -1L)
    {
      Log.e("Keep", "Failed to insert row for " + paramUri);
      return null;
    }
    q(paramUri);
    Y(l1);
    return ContentUris.withAppendedId(i.v.CONTENT_URI, l1);
  }

  private static String a(SQLiteDatabase paramSQLiteDatabase, SQLiteQueryBuilder paramSQLiteQueryBuilder, long paramLong)
  {
    paramSQLiteQueryBuilder.setTables("blob");
    paramSQLiteDatabase = paramSQLiteQueryBuilder.query(paramSQLiteDatabase, new String[] { "mime_type" }, "blob_id=?", new String[] { String.valueOf(paramLong) }, null, null, null);
    if (paramSQLiteDatabase == null)
      return null;
    try
    {
      if (paramSQLiteDatabase.moveToFirst())
      {
        paramSQLiteQueryBuilder = paramSQLiteDatabase.getString(0);
        return paramSQLiteQueryBuilder;
      }
      return null;
    }
    finally
    {
      paramSQLiteDatabase.close();
    }
    throw paramSQLiteQueryBuilder;
  }

  private static String a(SQLiteDatabase paramSQLiteDatabase, String paramString, String[] paramArrayOfString)
  {
    ArrayList localArrayList = Lists.newArrayList();
    paramSQLiteDatabase = paramSQLiteDatabase.query("blob_node", new String[] { "original_id", "edited_id" }, paramString, paramArrayOfString, null, null, null);
    if (paramSQLiteDatabase == null)
      return "()";
    try
    {
      while (paramSQLiteDatabase.moveToNext())
      {
        localArrayList.add(Long.valueOf(paramSQLiteDatabase.getLong(0)));
        paramString = h.l(paramSQLiteDatabase, 1);
        if (paramString != null)
          localArrayList.add(paramString);
      }
    }
    finally
    {
      paramSQLiteDatabase.close();
    }
    paramString = "blob_id IN (" + TextUtils.join(",", localArrayList) + ")";
    paramSQLiteDatabase.close();
    return paramString;
  }

  private void a(MatrixCursor paramMatrixCursor, Object[] paramArrayOfObject, String paramString, Object paramObject)
  {
    if (paramMatrixCursor == null);
    int i;
    do
    {
      return;
      i = paramMatrixCursor.getColumnIndex(paramString);
    }
    while (i < 0);
    paramArrayOfObject[i] = paramObject;
  }

  private static void a(Uri paramUri, int paramInt)
  {
    CM.addURI("com.google.android.keep", n(paramUri), paramInt);
  }

  private static void a(Uri paramUri, String paramString, int paramInt)
  {
    CM.addURI("com.google.android.keep", n(paramUri) + '/' + paramString, paramInt);
  }

  private static boolean a(SQLiteDatabase paramSQLiteDatabase, Long paramLong, Cursor paramCursor)
  {
    if (((paramCursor != null) && (paramCursor.getCount() > 0)) || (paramLong == null))
      return true;
    paramCursor = new SQLiteQueryBuilder();
    paramCursor.setTables("account");
    paramLong = String.valueOf(paramLong);
    paramSQLiteDatabase = paramCursor.query(paramSQLiteDatabase, new String[] { "last_sync_version" }, "_id=?", new String[] { paramLong }, null, null, null);
    if (paramSQLiteDatabase != null);
    try
    {
      if (paramSQLiteDatabase.moveToFirst())
      {
        boolean bool = TextUtils.isEmpty(paramSQLiteDatabase.getString(0));
        if (!bool);
        for (bool = true; ; bool = false)
          return bool;
      }
      return false;
    }
    finally
    {
      if (paramSQLiteDatabase != null)
        paramSQLiteDatabase.close();
    }
    throw paramLong;
  }

  static boolean a(Uri paramUri, String paramString, boolean paramBoolean)
  {
    boolean bool = true;
    paramUri = paramUri.getEncodedQuery();
    if (paramUri == null);
    int i;
    do
    {
      return paramBoolean;
      i = paramUri.indexOf(paramString);
    }
    while (i == -1);
    i += paramString.length();
    if ((!a(paramUri, i, "=0", false)) && (!a(paramUri, i, "=false", true)));
    for (paramBoolean = bool; ; paramBoolean = false)
      return paramBoolean;
  }

  private static boolean a(String paramString1, int paramInt, String paramString2, boolean paramBoolean)
  {
    boolean bool2 = false;
    int i = paramString2.length();
    boolean bool1 = bool2;
    if (paramString1.regionMatches(paramBoolean, paramInt, paramString2, 0, i))
      if (paramString1.length() != paramInt + i)
      {
        bool1 = bool2;
        if (paramString1.charAt(paramInt + i) != '&');
      }
      else
      {
        bool1 = true;
      }
    return bool1;
  }

  private String aK(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      return "is_deleted=0";
    return "(" + paramString + ") AND " + "is_deleted=0";
  }

  private int b(long paramLong, ContentValues paramContentValues)
  {
    long l = X(paramLong);
    if (paramContentValues != null)
      paramContentValues.put("_id", Long.valueOf(l));
    if (l == -1L)
      return 0;
    return 1 + g(l, paramLong) + h(l, paramLong) + f(l, paramLong);
  }

  private int b(ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    Integer localInteger = paramContentValues.getAsInteger("state");
    ContentValues localContentValues = new ContentValues();
    i.c.c(paramContentValues);
    paramContentValues.remove("reminder_id");
    if (localInteger == null)
      return mDb.update("alert", localContentValues, paramString, null);
    switch (localInteger.intValue())
    {
    case 2:
    default:
      throw new IllegalStateException("Try to update the alert to an invalid state " + localInteger);
    case 1:
      localContentValues.put("fired_time", Long.valueOf(System.currentTimeMillis()));
    case 3:
    case 4:
    case 5:
    case 0:
    }
    while (true)
    {
      localContentValues.put("trigger_condition", paramContentValues.getAsLong("trigger_condition"));
      localContentValues.put("state", localInteger);
      return mDb.update("alert", localContentValues, paramString, paramArrayOfString);
      paramString = h.p(paramString, "state=1");
      localContentValues.put("dismissed_time", Long.valueOf(System.currentTimeMillis()));
      continue;
      paramString = h.p(paramString, "state=0");
      continue;
      paramString = h.p(paramString, "state=0");
      continue;
      if (paramContentValues.containsKey("alert_time"))
        localContentValues.put("alert_time", paramContentValues.getAsLong("alert_time"));
      localContentValues.put("fired_time", Integer.valueOf(0));
      localContentValues.put("dismissed_time", Integer.valueOf(0));
      localContentValues.put("scheduled_time", Long.valueOf(System.currentTimeMillis()));
    }
  }

  private int b(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    i.v.c(paramContentValues);
    if (paramContentValues.containsKey("title"))
      paramContentValues.put("title", e(paramContentValues.getAsString("title"), Config.nB()));
    Integer localInteger = paramContentValues.getAsInteger("is_archived");
    if ((localInteger != null) && ((localInteger.intValue() < 0) || (localInteger.intValue() > 1)))
      throw new IllegalArgumentException("Invalid is_archived value " + localInteger);
    localInteger = paramContentValues.getAsInteger("is_trashed");
    if ((localInteger != null) && ((localInteger.intValue() < 0) || (localInteger.intValue() > 1)))
      throw new IllegalArgumentException("Invalid isTrashed value " + localInteger);
    int k = 0;
    int i = 0;
    int j = 0;
    if (paramContentValues.size() > 0)
    {
      i = k;
      if (!o(paramUri))
      {
        long l = System.currentTimeMillis();
        if (paramContentValues.getAsLong("time_last_updated") == null)
          paramContentValues.put("time_last_updated", Long.valueOf(l));
        if ((paramContentValues.containsKey("type")) || (paramContentValues.containsKey("title")))
          paramContentValues.put("user_edited_timestamp", Long.valueOf(l));
        paramContentValues.put("is_dirty", Integer.valueOf(1));
        if (paramContentValues.containsKey("is_trashed"))
          j = 0 + a(paramString, paramArrayOfString, l);
        paramUri = paramContentValues.getAsInteger("is_graveyard_off");
        i = j;
        if (paramUri != null)
        {
          i = j;
          if (paramUri.intValue() == 1)
            i = j + ReorderEntitiesHelper.c(mDb, paramString, paramArrayOfString);
        }
      }
      b(mDb, paramString, paramArrayOfString);
      i += mDb.update("tree_entity", paramContentValues, paramString, paramArrayOfString);
    }
    return i;
  }

  private int b(Uri paramUri, String paramString, String[] paramArrayOfString, ContentValues paramContentValues)
  {
    if (!o(paramUri))
    {
      paramContentValues.put("is_dirty", Integer.valueOf(1));
      paramUri = "SELECT note_label.tree_entity_id FROM note_label WHERE " + paramString;
      c("_id IN (" + paramUri + ")", paramArrayOfString);
    }
    return mDb.update("note_label", paramContentValues, paramString, paramArrayOfString);
  }

  private int b(String paramString, String[] paramArrayOfString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    o(paramInt1, paramInt2);
    paramString = paramString + " AND " + "is_deleted" + "=?";
    paramArrayOfString = com.google.android.keep.util.e.a(paramArrayOfString, new String[] { String.valueOf(paramInt1) });
    ContentValues localContentValues = bG(paramInt2);
    int i = 0;
    paramInt1 = i;
    if (paramBoolean)
    {
      paramInt1 = i;
      if (paramInt2 == 1)
        paramInt1 = 0 + c(paramString, paramArrayOfString, localContentValues.getAsLong("time_last_updated").longValue());
    }
    return paramInt1 + mDb.update("list_item", localContentValues, paramString, paramArrayOfString);
  }

  private int b(String paramString, String[] paramArrayOfString, long paramLong)
  {
    return a("blob_node", "tree_entity_id", paramString, paramArrayOfString, paramLong);
  }

  private Cursor b(SQLiteDatabase paramSQLiteDatabase, SQLiteQueryBuilder paramSQLiteQueryBuilder, Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    paramSQLiteQueryBuilder.setTables("list_item LEFT OUTER JOIN list_item_conflict ON (list_item.server_id=list_item_conflict.server_id AND list_item.list_parent_id=list_item_conflict.list_parent_id)");
    paramSQLiteQueryBuilder.setProjectionMap(CS);
    long l = ContentUris.parseId(paramUri);
    paramString1 = h.p(paramString1, "list_item.list_parent_id=? AND list_item.is_deleted=0");
    paramArrayOfString2 = com.google.android.keep.util.e.a(paramArrayOfString2, new String[] { String.valueOf(l) });
    paramUri = paramString2;
    if (TextUtils.isEmpty(paramString2))
      paramUri = "list_item.order_in_parent DESC, list_item.time_last_updated DESC";
    paramSQLiteQueryBuilder = a(paramSQLiteDatabase, paramSQLiteQueryBuilder, paramArrayOfString1, paramString1, paramArrayOfString2, null, paramUri);
    return new o(getContext().getContentResolver(), paramSQLiteDatabase, CO, paramSQLiteQueryBuilder, l);
  }

  private Cursor b(SQLiteDatabase paramSQLiteDatabase, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    SQLiteQueryBuilder localSQLiteQueryBuilder = new SQLiteQueryBuilder();
    localSQLiteQueryBuilder.setStrict(true);
    localSQLiteQueryBuilder.setTables("sharing");
    localSQLiteQueryBuilder.setProjectionMap(CX);
    return a(paramSQLiteDatabase, localSQLiteQueryBuilder, paramArrayOfString1, paramString1, paramArrayOfString2, null, paramString2);
  }

  private Uri b(Uri paramUri, int paramInt)
  {
    Uri localUri = null;
    long l = ContentUris.parseId(paramUri);
    paramUri = i.e.CONTENT_URI;
    int i = bF(paramInt);
    Cursor localCursor = query(paramUri, new String[] { "file_name", "account_id" }, "blob_node._id=? AND type=?", new String[] { String.valueOf(l), String.valueOf(i) }, null);
    if (localCursor != null);
    try
    {
      if (localCursor.getCount() == 1)
      {
        localCursor.moveToFirst();
        paramUri = e.a(getContext(), localCursor.getLong(1), bF(paramInt), localCursor.getString(0));
        localUri = paramUri;
        if (localCursor != null)
        {
          localCursor.close();
          localUri = paramUri;
        }
        return localUri;
      }
      return null;
    }
    finally
    {
      if (localCursor != null)
        localCursor.close();
    }
    throw paramUri;
  }

  private Uri b(Uri paramUri, ContentValues paramContentValues)
  {
    if (!o(paramUri))
      throw new IllegalStateException("Conflicts cannot be created locally");
    Object localObject = paramContentValues.getAsString("server_id");
    if (localObject == null)
      throw new IllegalArgumentException("Missing server ID in insert");
    if (paramContentValues.getAsLong("time_last_updated") == null)
      throw new IllegalArgumentException("Missing timeLastUpdated in insert for conflicting list item with id " + (String)localObject);
    paramContentValues.put("text", e(paramContentValues.getAsString("text"), Config.nB()));
    localObject = paramContentValues.getAsLong("list_parent_id");
    if (localObject == null)
      throw new IllegalArgumentException("Parent of a list item is missing");
    if (paramContentValues.getAsString("merge_token") == null)
      throw new IllegalArgumentException("Merge token is required for a conflicting item.");
    int i = T(((Long)localObject).longValue()).mType;
    if ((i != 0) && (i != 1))
      throw new IllegalArgumentException("The parent of list item should be note or list instead of type " + i);
    localObject = paramContentValues.getAsInteger("is_checked");
    if ((localObject != null) && ((((Integer)localObject).intValue() < 0) || (((Integer)localObject).intValue() > 1)))
      throw new IllegalArgumentException("Invalid is_checked value " + localObject);
    long l = mDb.insert("list_item_conflict", null, paramContentValues);
    if (l == -1L)
    {
      Log.e("Keep", "Failed to insert row for " + paramUri);
      return null;
    }
    q(paramUri);
    return ContentUris.withAppendedId(i.n.CONTENT_URI, l);
  }

  private void b(SQLiteDatabase paramSQLiteDatabase, String paramString, String[] paramArrayOfString)
  {
    paramSQLiteDatabase = paramSQLiteDatabase.query("tree_entity", new String[] { "_id" }, paramString, paramArrayOfString, null, null, null);
    if (paramSQLiteDatabase == null)
      return;
    try
    {
      if (paramSQLiteDatabase.moveToNext())
        Y(paramSQLiteDatabase.getLong(0));
    }
    finally
    {
      paramSQLiteDatabase.close();
    }
  }

  private int bF(int paramInt)
  {
    if (paramInt == 602)
      return 0;
    if (paramInt == 603)
      return 1;
    throw new IllegalStateException("Type not supported:" + paramInt);
  }

  private ContentValues bG(int paramInt)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("is_deleted", Integer.valueOf(paramInt));
    if (paramInt == 1)
    {
      localContentValues.put("is_dirty", Integer.valueOf(1));
      localContentValues.put("time_last_updated", Long.valueOf(System.currentTimeMillis()));
    }
    return localContentValues;
  }

  private ContentValues bH(int paramInt)
  {
    ContentValues localContentValues = bG(paramInt);
    if (paramInt == 1)
      localContentValues.putNull("file_name");
    return localContentValues;
  }

  private int c(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    i.m.c(paramContentValues);
    if (paramContentValues.containsKey("text"))
      paramContentValues.put("text", e(paramContentValues.getAsString("text"), Config.nB()));
    Integer localInteger = paramContentValues.getAsInteger("is_checked");
    if ((localInteger != null) && ((localInteger.intValue() < 0) || (localInteger.intValue() > 1)))
      throw new IllegalArgumentException("Invalid is_checked value " + localInteger);
    int i = 0;
    if (paramContentValues.size() > 0)
    {
      if (!o(paramUri))
      {
        if (paramContentValues.getAsLong("time_last_updated") == null)
          paramContentValues.put("time_last_updated", Long.valueOf(System.currentTimeMillis()));
        if ((paramContentValues.containsKey("text")) && (!paramContentValues.containsKey("base_version")))
          Log.e("Keep", "Update list item text, without set base version " + paramUri);
        paramContentValues.put("is_dirty", Integer.valueOf(1));
        i = c(paramString, paramArrayOfString, paramContentValues.getAsLong("time_last_updated").longValue()) + a(paramContentValues, paramString, paramArrayOfString);
      }
    }
    else
      return i;
    return 0 + mDb.update("list_item", paramContentValues, paramString, paramArrayOfString);
  }

  private int c(String paramString, String[] paramArrayOfString, long paramLong)
  {
    return a("list_item", "list_parent_id", paramString, paramArrayOfString, paramLong);
  }

  private Cursor c(SQLiteDatabase paramSQLiteDatabase, SQLiteQueryBuilder paramSQLiteQueryBuilder, Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    paramSQLiteQueryBuilder.setTables("tree_entity");
    paramSQLiteQueryBuilder.setProjectionMap(CV);
    paramString1 = h.p("tree_entity.is_deleted=0", paramString1);
    long l = i.f.m(paramUri);
    paramSQLiteQueryBuilder = paramSQLiteQueryBuilder.query(paramSQLiteDatabase, paramArrayOfString1, d(paramString1, l), paramArrayOfString2, "tree_entity._id", null, paramString2);
    paramUri = new Bundle();
    if (l == -2L);
    for (boolean bool = true; ; bool = a(paramSQLiteDatabase, Long.valueOf(l), paramSQLiteQueryBuilder))
    {
      paramUri.putBoolean("hasDataReady", bool);
      paramSQLiteDatabase = new d(paramSQLiteQueryBuilder, paramUri);
      paramSQLiteDatabase.setNotificationUri(getContext().getContentResolver(), i.AUTHORITY_URI);
      return paramSQLiteDatabase;
    }
  }

  private Uri c(Uri paramUri, ContentValues paramContentValues)
  {
    if (!o(paramUri))
      throw new IllegalStateException("Conflicts cannot be upserted locally");
    String str = paramContentValues.getAsString("server_id");
    if (str == null)
      throw new IllegalArgumentException("Missing server ID");
    Cursor localCursor = a(mDb, new String[] { "_id" }, "server_id=?", new String[] { str }, null);
    if (localCursor != null);
    try
    {
      if (localCursor.getCount() > 0)
      {
        if (d(paramUri, paramContentValues, "list_item_conflict.server_id=?", new String[] { str }) > 0)
          q(paramUri);
        localCursor.moveToFirst();
        paramContentValues = ContentUris.withAppendedId(i.n.CONTENT_URI, localCursor.getLong(0));
        paramUri = paramContentValues;
        if (localCursor != null)
        {
          localCursor.close();
          paramUri = paramContentValues;
        }
        return paramUri;
      }
      paramContentValues = b(paramUri, paramContentValues);
      paramUri = paramContentValues;
      return paramContentValues;
    }
    finally
    {
      if (localCursor != null)
        localCursor.close();
    }
    throw paramUri;
  }

  private String c(long paramLong, int paramInt)
  {
    if (paramInt == 602)
      return e.O(paramLong);
    if (paramInt == 603)
      return e.P(paramLong);
    throw new IllegalStateException("Type not supported:" + paramInt);
  }

  private void c(String paramString, String[] paramArrayOfString)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("is_dirty", Integer.valueOf(1));
    localContentValues.put("time_last_updated", Long.valueOf(System.currentTimeMillis()));
    mDb.update("tree_entity", localContentValues, paramString, paramArrayOfString);
  }

  private int d(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    if (paramContentValues.containsKey("text"))
      paramContentValues.put("text", e(paramContentValues.getAsString("text"), Config.nB()));
    paramUri = paramContentValues.getAsInteger("is_checked");
    if ((paramUri != null) && ((paramUri.intValue() < 0) || (paramUri.intValue() > 1)))
      throw new IllegalArgumentException("Invalid is_checked value " + paramUri);
    int i = 0;
    if (paramContentValues.size() > 0)
      i = 0 + mDb.update("list_item_conflict", paramContentValues, paramString, paramArrayOfString);
    return i;
  }

  private int d(String paramString, String[] paramArrayOfString, long paramLong)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("time_last_updated", Long.valueOf(paramLong));
    localContentValues.put("user_edited_timestamp", Long.valueOf(paramLong));
    localContentValues.put("is_dirty", Integer.valueOf(1));
    return mDb.update("tree_entity", localContentValues, paramString, paramArrayOfString);
  }

  private long d(long paramLong, int paramInt)
  {
    if (paramInt == 1);
    for (Object localObject1 = "MAX"; ; localObject1 = "MIN")
    {
      localObject1 = (String)localObject1 + "(" + "order_in_parent" + ")";
      localObject1 = mDb.query("list_item", new String[] { localObject1 }, "list_parent_id = ? AND is_checked = ?", new String[] { String.valueOf(paramLong), String.valueOf(paramInt) }, null, null, null);
      if (localObject1 != null)
        break;
      return 0L;
    }
    try
    {
      if (((Cursor)localObject1).moveToFirst())
      {
        paramLong = ((Cursor)localObject1).getLong(0);
        return paramLong;
      }
      return 0L;
    }
    finally
    {
      ((Cursor)localObject1).close();
    }
  }

  private Uri d(Uri paramUri, ContentValues paramContentValues)
  {
    Object localObject2 = paramContentValues.getAsLong("list_parent_id");
    if ((localObject2 == null) || (((Long)localObject2).longValue() == -1L))
      throw new IllegalArgumentException("Parent of a list item is missing or invalid");
    Object localObject1 = paramContentValues.getAsString("uuid");
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = String.valueOf(localObject2);
      localObject1 = query(paramUri, new String[] { "_id" }, "list_item.list_parent_id=? AND list_item.uuid=?", new String[] { localObject2, localObject1 }, null);
      if (localObject1 == null);
    }
    try
    {
      if (((Cursor)localObject1).moveToFirst())
      {
        paramUri = ContentUris.withAppendedId(paramUri, ((Cursor)localObject1).getLong(0));
        update(paramUri, paramContentValues, null, null);
        return paramUri;
      }
      return e(paramUri, paramContentValues);
    }
    finally
    {
      if (localObject1 != null)
        ((Cursor)localObject1).close();
    }
    throw paramUri;
  }

  private String d(String paramString, long paramLong)
  {
    String str = paramString;
    if (paramLong != -2L)
      str = h.p("tree_entity.account_id=" + paramLong, paramString);
    return str;
  }

  private int e(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    i.e.c(paramContentValues);
    int i = 0;
    int j = 0;
    long l1;
    if (paramContentValues.size() > 0)
    {
      i = j;
      if (!o(paramUri))
      {
        l1 = System.currentTimeMillis();
        if (paramContentValues.getAsLong("time_last_updated") == null)
          paramContentValues.put("time_last_updated", Long.valueOf(l1));
        paramContentValues.put("is_dirty", Integer.valueOf(1));
        i = 0 + b(paramString, paramArrayOfString, l1);
      }
      paramUri = i.e.d(paramContentValues);
      paramString = mDb.query("blob_node JOIN blob ON CASE use_edited WHEN 1 THEN edited_id = blob_id ELSE original_id = blob_id END", new String[] { "_id", "blob_id" }, paramString, paramArrayOfString, null, null, null);
      if (paramString == null)
        return 0;
    }
    try
    {
      while (paramString.moveToNext())
      {
        l1 = paramString.getLong(0);
        long l2 = paramString.getLong(1);
        j = i;
        if (paramContentValues.size() > 0)
          j = i + mDb.update("blob", paramContentValues, "blob_id=?", new String[] { String.valueOf(l2) });
        i = j;
        if (paramUri.size() > 0)
        {
          i = mDb.update("blob_node", paramUri, "_id=?", new String[] { String.valueOf(l1) });
          i = j + i;
        }
      }
      return i;
    }
    finally
    {
      paramString.close();
    }
    throw paramUri;
  }

  private int e(String paramString, String[] paramArrayOfString)
  {
    return a(true, paramString, paramArrayOfString);
  }

  private long e(long paramLong1, long paramLong2)
  {
    long l;
    if (paramLong1 == 0L)
    {
      localObject1 = i.v.CONTENT_URI;
      l = Db;
      return a((Uri)localObject1, paramLong2, "parent_id=? AND is_archived=0 AND account_id=?", new String[] { String.valueOf(paramLong1), String.valueOf(paramLong2) }, false, false, l);
    }
    Object localObject1 = mDb.query("tree_entity", new String[] { "is_new_list_item_from_top" }, "_id=?", new String[] { String.valueOf(paramLong1) }, null, null, null);
    if (localObject1 == null)
      return 0L;
    try
    {
      boolean bool = ((Cursor)localObject1).moveToFirst();
      if (!bool)
        return 0L;
      if (((Cursor)localObject1).getInt(0) == 1);
      for (int i = 1; i != 0; i = 0)
      {
        localUri = i.m.CONTENT_URI;
        l = Db;
        paramLong1 = a(localUri, paramLong2, "list_parent_id=?", new String[] { String.valueOf(paramLong1) }, false, true, l);
        return paramLong1;
      }
      Uri localUri = i.m.CONTENT_URI;
      l = -Db;
      paramLong1 = a(localUri, paramLong2, "list_parent_id=?", new String[] { String.valueOf(paramLong1) }, true, true, l);
      return paramLong1;
    }
    finally
    {
      ((Cursor)localObject1).close();
    }
  }

  private Uri e(Uri paramUri, ContentValues paramContentValues)
  {
    paramContentValues.put("text", e(paramContentValues.getAsString("text"), Config.nB()));
    Long localLong1 = paramContentValues.getAsLong("list_parent_id");
    a locala = T(localLong1.longValue());
    int i = locala.mType;
    if ((i != 0) && (i != 1))
      throw new IllegalArgumentException("The parent of list item should be note or list instead of type " + i);
    Object localObject = paramContentValues.getAsInteger("is_checked");
    if ((localObject != null) && ((((Integer)localObject).intValue() < 0) || (((Integer)localObject).intValue() > 1)))
      throw new IllegalArgumentException("Invalid is_checked value " + localObject);
    paramContentValues.put("account_id", Long.valueOf(locala.cU));
    localObject = paramContentValues.getAsString("uuid");
    String str = paramContentValues.getAsString("server_id");
    Long localLong2 = paramContentValues.getAsLong("time_created");
    Long localLong3 = paramContentValues.getAsLong("time_last_updated");
    if (o(paramUri))
    {
      if (localObject == null)
        throw new IllegalStateException("Missing uuid in insert from syncadapter");
      if (str == null)
        throw new IllegalStateException("Missing server ID in insert from syncadapter");
      if (localLong2 == null)
        throw new IllegalStateException("Missing timeCreated in insert from syncadapter for list item with id " + (String)localObject);
      if (localLong3 == null)
        throw new IllegalStateException("Missing timeLastUpdated in insert from  syncadapter for list item with id " + (String)localObject);
    }
    else
    {
      if (localObject == null)
        paramContentValues.put("uuid", kw());
      l = System.currentTimeMillis();
      if (localLong2 == null)
        paramContentValues.put("time_created", Long.valueOf(l));
      paramContentValues.put("time_last_updated", Long.valueOf(l));
      i(localLong1.longValue(), paramContentValues.getAsLong("time_last_updated").longValue());
      paramContentValues.put("is_dirty", Integer.valueOf(1));
    }
    if (paramContentValues.getAsLong("order_in_parent") == null)
      paramContentValues.put("order_in_parent", Long.valueOf(e(localLong1.longValue(), locala.cU)));
    long l = mDb.insert("list_item", null, paramContentValues);
    if (l == -1L)
    {
      Log.e("Keep", "Failed to insert row for " + paramUri);
      return null;
    }
    paramContentValues.put("_id", Long.valueOf(l));
    q(paramUri);
    return ContentUris.withAppendedId(i.m.CONTENT_URI, l);
  }

  private String e(String paramString, int paramInt)
  {
    String str;
    if (paramString == null)
      str = "";
    do
    {
      return str;
      str = paramString;
    }
    while (paramString.length() < paramInt);
    return paramString.substring(0, paramInt - 1);
  }

  private int f(long paramLong1, long paramLong2)
  {
    return a(i.p.CONTENT_URI, "note_label", "tree_entity_id", paramLong1, paramLong2, new String[] { "label_id", "is_deleted", "deleted_timestamp" }, null, null);
  }

  private int f(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    int i;
    if (paramContentValues.size() <= 0)
      i = 0;
    int j;
    do
    {
      do
      {
        return i;
        paramUri = i.e.d(paramContentValues);
        paramArrayOfString = paramUri.getAsString("_id");
        paramString = new String[1];
        paramString[0] = String.valueOf(paramArrayOfString);
        Object localObject = mDb.query("blob_node", new String[] { "edited_id" }, "_id=?", paramString, null, null, null);
        if (localObject == null)
          return 0;
        try
        {
          if (((Cursor)localObject).getCount() != 1)
            throw new IllegalStateException("Blob node not found: " + paramArrayOfString);
        }
        finally
        {
          ((Cursor)localObject).close();
        }
        ((Cursor)localObject).moveToFirst();
        paramArrayOfString = Long.valueOf(((Cursor)localObject).getLong(0));
        ((Cursor)localObject).close();
        localObject = paramUri.getAsInteger("type");
        String str = paramContentValues.getAsString("file_name");
        long l = paramUri.getAsLong("account_id").longValue();
        localObject = e.a(getContext(), l, ((Integer)localObject).intValue(), str);
        if (localObject == null)
          throw new NullPointerException("File does not exist, failed to insert blob into database");
        paramContentValues.put("blob_size", Long.valueOf(new File(((Uri)localObject).getPath()).length()));
        localObject = g.b(getContext().getContentResolver(), (Uri)localObject);
        if (!i.j.isSupported(((BitmapFactory.Options)localObject).outMimeType))
          throw new IllegalArgumentException("Image inserted has invalid type:" + ((BitmapFactory.Options)localObject).outMimeType);
        paramContentValues.put("mime_type", ((BitmapFactory.Options)localObject).outMimeType);
        paramContentValues.put("data1", Integer.valueOf(((BitmapFactory.Options)localObject).outWidth));
        paramContentValues.put("data2", Integer.valueOf(((BitmapFactory.Options)localObject).outHeight));
        l = mDb.insert("blob", null, paramContentValues);
        paramUri.put("use_edited", Integer.valueOf(1));
        paramUri.put("edited_id", Long.valueOf(l));
        paramUri.remove("_id");
        paramUri.remove("type");
        paramUri.remove("account_id");
        j = mDb.update("blob_node", paramUri, "_id=?", paramString);
        i = j;
      }
      while (paramArrayOfString == null);
      i = j;
    }
    while (paramArrayOfString.longValue() == 0L);
    paramUri = new String[1];
    paramUri[0] = String.valueOf(paramArrayOfString.toString());
    d("blob_id=?", paramUri);
    mDb.delete("blob", "blob_id=?", paramUri);
    return j;
  }

  private int f(String paramString, String[] paramArrayOfString)
  {
    return a(false, paramString, paramArrayOfString);
  }

  private Uri f(Uri paramUri, ContentValues paramContentValues)
  {
    Object localObject1 = paramContentValues.getAsInteger("type");
    if ((localObject1 == null) || (((Integer)localObject1).intValue() < 0) || (((Integer)localObject1).intValue() > 1))
      throw new IllegalArgumentException("Invalid blob type " + localObject1);
    Object localObject2 = paramContentValues.getAsLong("tree_entity_id");
    if (localObject2 == null)
      throw new IllegalArgumentException("Must specify tree_entity_id");
    Object localObject3 = T(((Long)localObject2).longValue());
    int i = ((a)localObject3).mType;
    if ((i != 0) && (i != 1))
      throw new IllegalArgumentException("The parent of Blob should be note or list instead of type " + i);
    Object localObject4 = paramContentValues.getAsInteger("extraction_status");
    if ((localObject4 != null) && ((((Integer)localObject4).intValue() < 0) || (((Integer)localObject4).intValue() > 4)))
      throw new IllegalArgumentException("Invalid extraction status " + localObject4);
    paramContentValues.put("account_id", Long.valueOf(((a)localObject3).cU));
    String str1 = paramContentValues.getAsString("uuid");
    String str2 = paramContentValues.getAsString("server_id");
    Long localLong1 = paramContentValues.getAsLong("time_created");
    Long localLong2 = paramContentValues.getAsLong("time_last_updated");
    localObject3 = paramContentValues.getAsLong("blob_size");
    localObject4 = paramContentValues.getAsString("mime_type");
    if (o(paramUri))
    {
      if (str1 == null)
        throw new IllegalStateException("Missing uuid in insert from syncadapter");
      if (str2 == null)
        throw new IllegalStateException("Missing server ID in insert from syncadapter");
      if (localLong1 == null)
        throw new IllegalStateException("Missing timeCreated in insert from syncadapter for blob with id " + str1);
      if (localLong2 == null)
        throw new IllegalStateException("Missing timeLastUpdated in insert from  syncadapter for blob with id " + str1);
      if (localObject3 == null)
        throw new IllegalStateException("Missing blob_size in insert from  syncadapter for blob with id " + str1);
      if (localObject4 == null)
        throw new IllegalStateException("Missing blob_mime_type in insert from  syncadapter for blob with id " + str1);
    }
    else
    {
      if (str1 == null)
        paramContentValues.put("uuid", kw());
      l1 = System.currentTimeMillis();
      if (localLong1 == null)
        paramContentValues.put("time_created", Long.valueOf(l1));
      paramContentValues.put("time_last_updated", Long.valueOf(l1));
      i(((Long)localObject2).longValue(), paramContentValues.getAsLong("time_last_updated").longValue());
      localObject2 = paramContentValues.getAsString("file_name");
      l1 = paramContentValues.getAsLong("account_id").longValue();
      localObject2 = e.a(getContext(), l1, ((Integer)localObject1).intValue(), (String)localObject2);
      if (localObject3 == null)
      {
        if (localObject2 == null)
          throw new NullPointerException("File does not exist, fail to insert into database");
        paramContentValues.put("blob_size", Long.valueOf(new File(((Uri)localObject2).getPath()).length()));
      }
      if (localObject4 == null)
      {
        if (localObject2 == null)
          throw new NullPointerException("File does not exist, fail to insert into database");
        if (((Integer)localObject1).intValue() != 0)
          break label777;
        localObject1 = g.b(getContext().getContentResolver(), (Uri)localObject2);
        if (!i.j.isSupported(((BitmapFactory.Options)localObject1).outMimeType))
          throw new IllegalArgumentException("Image inserted has invalid type:" + ((BitmapFactory.Options)localObject1).outMimeType);
        paramContentValues.put("mime_type", ((BitmapFactory.Options)localObject1).outMimeType);
      }
    }
    long l2;
    while (true)
    {
      paramContentValues.put("is_dirty", Integer.valueOf(1));
      localObject1 = i.e.d(paramContentValues);
      l1 = 0L;
      if (paramContentValues.size() <= 0)
        break;
      l2 = mDb.insert("blob", null, paramContentValues);
      l1 = l2;
      if (l2 != -1L)
        break;
      Log.e("Keep", "Failed to insert row for " + paramUri);
      return null;
      label777: if (((Integer)localObject1).intValue() == 1)
      {
        localObject1 = b.a(getContext().getContentResolver(), (Uri)localObject2);
        if (!VoiceBlob.Ak.contains(localObject1))
          throw new IllegalArgumentException("Audio inserted has invalid type:" + (String)localObject1);
        paramContentValues.put("mime_type", (String)localObject1);
      }
    }
    ((ContentValues)localObject1).put("original_id", Long.valueOf(l1));
    long l1 = -1L;
    if (((ContentValues)localObject1).size() > 0)
    {
      l2 = mDb.insert("blob_node", null, (ContentValues)localObject1);
      l1 = l2;
      if (l2 == -1L)
      {
        Log.e("Keep", "Failed to insert row for " + paramUri);
        return null;
      }
    }
    q(paramUri);
    return ContentUris.withAppendedId(i.e.CONTENT_URI, l1);
  }

  private void f(ContentValues paramContentValues)
  {
    Long localLong = paramContentValues.getAsLong("tree_entity_id");
    if ((localLong == null) || (localLong.longValue() == -1L))
      throw new IllegalArgumentException("Invalid sharing.tree_entity_id");
    if (TextUtils.isEmpty(paramContentValues.getAsString("email")))
      throw new IllegalArgumentException("Missing email");
  }

  private int g(long paramLong1, long paramLong2)
  {
    return a(i.m.CONTENT_URI, "list_item", "list_parent_id", paramLong1, paramLong2, new String[] { "text", "is_checked", "order_in_parent", "is_deleted" }, null, null);
  }

  private int g(String paramString, String[] paramArrayOfString)
  {
    String str1 = " IN ( SELECT tree_entity._id FROM tree_entity WHERE " + paramString + ")";
    String str2 = "tree_entity_id" + str1;
    d(str2, paramArrayOfString);
    String str3 = a(mDb, str2, paramArrayOfString);
    int i = mDb.delete("blob", str3, null);
    int j = mDb.delete("blob_node", str2, paramArrayOfString);
    str2 = "list_parent_id" + str1;
    int k = mDb.delete("list_item", str2, paramArrayOfString);
    str1 = "tree_entity_id" + str1;
    return i + j + k + mDb.delete("sharing", str1, paramArrayOfString) + mDb.delete("tree_entity", paramString, paramArrayOfString);
  }

  private Uri g(Uri paramUri, ContentValues paramContentValues)
  {
    long l = mDb.insert("account", null, paramContentValues);
    if (l == -1L)
    {
      Log.e("Keep", "Failed to insert row for " + paramUri);
      return null;
    }
    q(paramUri);
    return ContentUris.withAppendedId(paramUri, l);
  }

  private int h(long paramLong1, long paramLong2)
  {
    a locala = T(paramLong2);
    String[] arrayOfString = new String[15];
    arrayOfString[0] = ((String)CP.get("full_path"));
    arrayOfString[1] = "file_name";
    arrayOfString[2] = "media_id";
    arrayOfString[3] = "type";
    arrayOfString[4] = "mime_type";
    arrayOfString[5] = "blob_size";
    arrayOfString[6] = "data1";
    arrayOfString[7] = "data2";
    arrayOfString[8] = "is_deleted";
    arrayOfString[9] = "extracted_text";
    arrayOfString[10] = "extraction_status";
    arrayOfString[11] = "base_version";
    arrayOfString[12] = "use_edited";
    arrayOfString[13] = "original_id";
    arrayOfString[14] = "edited_id";
    Cursor localCursor = mDb.query("blob_node JOIN blob ON CASE use_edited WHEN 1 THEN edited_id = blob_id ELSE original_id = blob_id END", arrayOfString, "tree_entity_id=?", new String[] { String.valueOf(paramLong2) }, null, null, null);
    int i = 0;
    if (localCursor == null)
      return 0;
    try
    {
      ContentValues localContentValues;
      localContentValues.put("tree_entity_id", Long.valueOf(paramLong1));
      Object localObject1;
      int k;
      String str1;
      label230: String str2;
      Object localObject3;
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        paramLong2 = com.google.android.keep.util.e.currentTimeMillis();
        if (k == 0)
        {
          localObject1 = e.b(getContext(), locala.cU, paramLong2);
          str1 = e.O(paramLong2);
          e.a(new File(str2), (File)localObject1);
          localContentValues.put("file_name", str1);
          if (!TextUtils.isEmpty((CharSequence)localObject3))
            localContentValues.put("media_id", (String)localObject3);
        }
      }
      while (true)
      {
        if (insertInTransaction(i.e.CONTENT_URI, localContentValues) != null)
          i += 1;
        do
        {
          if (!localCursor.moveToNext())
            break label444;
          localContentValues = new ContentValues();
          str2 = localCursor.getString(0);
          localObject1 = localCursor.getString(1);
          localObject3 = localCursor.getString(2);
          k = localCursor.getInt(3);
          int j = 3;
          while (j < arrayOfString.length)
          {
            localContentValues.put(arrayOfString[j], localCursor.getString(j));
            j += 1;
          }
        }
        while (k != 1);
        localObject1 = e.c(getContext(), locala.cU, paramLong2);
        str1 = e.P(paramLong2);
        break label230;
        localContentValues.put("media_id", (String)localObject3);
      }
    }
    finally
    {
      localCursor.close();
    }
    label444: localCursor.close();
    return i;
  }

  private Uri h(Uri paramUri, ContentValues paramContentValues)
  {
    i.c.c(paramContentValues);
    paramContentValues.put("scheduled_time", Long.valueOf(System.currentTimeMillis()));
    if (paramContentValues.getAsInteger("state") == null)
      paramContentValues.put("state", Integer.valueOf(0));
    int i = paramContentValues.getAsInteger("state").intValue();
    if (i == 0)
      paramContentValues.put("scheduled_time", Long.valueOf(System.currentTimeMillis()));
    long l;
    while (true)
    {
      l = mDb.insert("alert", null, paramContentValues);
      if (l != -1L)
        break;
      Log.e("Keep", "Failed to insert row for " + paramUri);
      return null;
      if (i == 1)
        paramContentValues.put("fired_time", Long.valueOf(System.currentTimeMillis()));
      else if (i == 3)
        paramContentValues.put("dismissed_time", Long.valueOf(System.currentTimeMillis()));
    }
    return ContentUris.withAppendedId(paramUri, l);
  }

  private void h(Long paramLong)
  {
    c("tree_entity._id=?", new String[] { String.valueOf(paramLong) });
  }

  private int i(long paramLong1, long paramLong2)
  {
    return d("_id=?", new String[] { String.valueOf(paramLong1) }, paramLong2);
  }

  private Uri i(Uri paramUri, ContentValues paramContentValues)
  {
    f(paramContentValues);
    Object localObject2 = paramContentValues.getAsLong("tree_entity_id");
    Object localObject1 = paramContentValues.getAsString("email");
    localObject2 = String.valueOf(localObject2);
    localObject1 = b(mDb, new String[] { "_id" }, "sharing.tree_entity_id=? AND sharing.email=?", new String[] { localObject2, localObject1 }, null);
    if (localObject1 != null);
    try
    {
      if (((Cursor)localObject1).moveToFirst())
      {
        long l = ((Cursor)localObject1).getLong(0);
        paramContentValues.put("is_deleted", Integer.valueOf(0));
        i.t.e(paramContentValues);
        update(ContentUris.withAppendedId(paramUri, l), paramContentValues, null, null);
        paramContentValues = ContentUris.withAppendedId(paramUri, l);
        paramUri = paramContentValues;
        if (localObject1 != null)
        {
          ((Cursor)localObject1).close();
          paramUri = paramContentValues;
        }
        return paramUri;
      }
      paramContentValues = j(paramUri, paramContentValues);
      paramUri = paramContentValues;
      return paramContentValues;
    }
    finally
    {
      if (localObject1 != null)
        ((Cursor)localObject1).close();
    }
    throw paramUri;
  }

  private Uri j(Uri paramUri, ContentValues paramContentValues)
  {
    f(paramContentValues);
    Long localLong = paramContentValues.getAsLong("tree_entity_id");
    paramContentValues.put("account_id", Long.valueOf(T(localLong.longValue()).cU));
    if (!o(paramUri))
      paramContentValues.put("is_dirty", Integer.valueOf(1));
    long l = mDb.insert("sharing", null, paramContentValues);
    if (l == -1L)
    {
      Log.e("Keep", "Failed to insert row for " + paramUri);
      return null;
    }
    q(paramUri);
    if (!o(paramUri))
      h(localLong);
    return ContentUris.withAppendedId(paramUri, l);
  }

  public static String j(long paramLong1, long paramLong2)
  {
    return String.format("%s.%s", new Object[] { Long.toHexString(paramLong1), Long.toHexString(paramLong2) });
  }

  private Uri k(Uri paramUri, ContentValues paramContentValues)
  {
    long l = mDb.insert("note_error", null, paramContentValues);
    if (l == -1L)
    {
      Log.e("Keep", "Failed to insert row for " + paramUri);
      return null;
    }
    return ContentUris.withAppendedId(paramUri, l);
  }

  public static String kw()
  {
    long l = UUID.randomUUID().getLeastSignificantBits();
    return j(com.google.android.keep.util.e.currentTimeMillis(), l);
  }

  private Uri l(Uri paramUri, ContentValues paramContentValues)
  {
    if (paramContentValues.getAsLong("account_id") == null)
      throw new IllegalArgumentException("Account is not set!");
    Object localObject = paramContentValues.getAsString("uuid");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = mDb.query("label", new String[] { "_id" }, "label.uuid=?", new String[] { localObject }, null, null, null);
      if (localObject == null);
    }
    try
    {
      if (((Cursor)localObject).getCount() > 0)
      {
        ((Cursor)localObject).moveToFirst();
        long l = ((Cursor)localObject).getLong(0);
        a(paramUri, "label._id=?", new String[] { String.valueOf(l) }, paramContentValues);
        paramUri = ContentUris.withAppendedId(i.k.CONTENT_URI, l);
        return paramUri;
      }
      return m(paramUri, paramContentValues);
    }
    finally
    {
      ((Cursor)localObject).close();
    }
    throw paramUri;
  }

  private Uri m(Uri paramUri, ContentValues paramContentValues)
  {
    n(paramUri, paramContentValues);
    long l = mDb.insert("label", null, paramContentValues);
    if (l == -1L)
    {
      Log.e("Keep", "Failed to insert row for " + paramUri);
      return null;
    }
    q(paramUri);
    return ContentUris.withAppendedId(i.k.CONTENT_URI, l);
  }

  private static String n(Uri paramUri)
  {
    String str = paramUri.getPath();
    paramUri = str;
    if (str.length() > 0)
    {
      paramUri = str;
      if (str.charAt(0) == '/')
        paramUri = str.substring(1);
    }
    return paramUri;
  }

  private void n(Uri paramUri, ContentValues paramContentValues)
  {
    if (TextUtils.isEmpty(paramContentValues.getAsString("name")))
      throw new IllegalArgumentException("Name is not set!");
    String str = paramContentValues.getAsString("uuid");
    Long localLong1 = paramContentValues.getAsLong("last_used_timestamp");
    Object localObject = paramContentValues.getAsLong("time_created");
    Long localLong2 = paramContentValues.getAsLong("user_edited_timestamp");
    if (o(paramUri))
    {
      if (TextUtils.isEmpty(str))
        throw new IllegalStateException("Missing UUID in insert from syncadapter");
      if (localLong1 == null)
        throw new IllegalStateException("Missing timeLastUsed in insert from syncadapter for label with id " + str);
      if (localObject == null)
        throw new IllegalStateException("Missing timeCreated in insert from syncadapter for label with id " + str);
      if (localLong2 == null)
        throw new IllegalStateException("Missing userEditedTimestamp in insert from syncadapter for label with id " + str);
    }
    else
    {
      if (TextUtils.isEmpty(str))
        paramContentValues.put("uuid", kw());
      paramUri = (Uri)localObject;
      if (localObject == null)
      {
        paramUri = Long.valueOf(System.currentTimeMillis());
        paramContentValues.put("time_created", paramUri);
      }
      localObject = localLong1;
      if (localLong1 == null)
      {
        paramContentValues.put("last_used_timestamp", paramUri);
        localObject = paramUri;
      }
      if (localLong2 == null)
        paramContentValues.put("user_edited_timestamp", (Long)localObject);
      paramContentValues.put("is_dirty", Integer.valueOf(1));
    }
  }

  private Uri o(Uri paramUri, ContentValues paramContentValues)
  {
    Long localLong = paramContentValues.getAsLong("tree_entity_id");
    if (localLong == null)
      throw new IllegalArgumentException("Tree entity id is not set!");
    Object localObject = paramContentValues.getAsString("label_id");
    if (TextUtils.isEmpty((CharSequence)localObject))
      throw new IllegalArgumentException("Label id is not set!");
    if (!o(paramUri))
      paramContentValues.put("is_dirty", Integer.valueOf(1));
    SQLiteDatabase localSQLiteDatabase = mDb;
    String str = String.valueOf(localLong);
    localObject = localSQLiteDatabase.query("note_label", new String[] { "_id" }, "note_label.label_id=? AND note_label.tree_entity_id=?", new String[] { localObject, str }, null, null, null);
    if (localObject != null);
    long l;
    try
    {
      if (((Cursor)localObject).moveToFirst())
      {
        l = ((Cursor)localObject).getLong(0);
        paramContentValues.put("is_deleted", Integer.valueOf(0));
        mDb.update("note_label", paramContentValues, "note_label._id=?", new String[] { String.valueOf(l) });
        paramUri = ContentUris.withAppendedId(paramUri, l);
        return paramUri;
      }
      ((Cursor)localObject).close();
      paramContentValues.put("account_id", Long.valueOf(T(localLong.longValue()).cU));
      l = mDb.insert("note_label", null, paramContentValues);
      if (l == -1L)
      {
        Log.e("Keep", "Failed to insert row for " + paramUri);
        return null;
      }
    }
    finally
    {
      ((Cursor)localObject).close();
    }
    if (!o(paramUri))
      h(paramContentValues.getAsLong("tree_entity_id"));
    q(paramUri);
    return ContentUris.withAppendedId(i.p.CONTENT_URI, l);
  }

  private void o(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) && (paramInt2 == -1));
    while (((paramInt1 == 0) && (paramInt2 == 1)) || ((paramInt1 == -1) && (paramInt2 == 0)) || ((paramInt1 == -1) && (paramInt2 == 1)))
      return;
    throw new IllegalStateException("Invalid state transform:" + paramInt1 + " to " + paramInt2);
  }

  private boolean o(Uri paramUri)
  {
    return a(paramUri, "caller_is_syncadapter", false);
  }

  private boolean p(Uri paramUri)
  {
    return a(paramUri, "client_only", false);
  }

  private void q(Uri paramUri)
  {
    if ((!o(paramUri)) && (!p(paramUri)));
    for (boolean bool = true; ; bool = false)
    {
      r.a("Keep", "Notify sync manager, because of " + paramUri + ". Need sync " + bool, new Object[] { new Throwable() });
      mContentResolver.notifyChange(i.AUTHORITY_URI, null, bool);
      return;
    }
  }

  public ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> paramArrayList)
    throws OperationApplicationException
  {
    SQLiteDatabase localSQLiteDatabase = Dd.getWritableDatabase();
    localSQLiteDatabase.beginTransaction();
    try
    {
      paramArrayList = super.applyBatch(paramArrayList);
      localSQLiteDatabase.setTransactionSuccessful();
      return paramArrayList;
    }
    finally
    {
      localSQLiteDatabase.endTransaction();
    }
    throw paramArrayList;
  }

  protected void d(String paramString, String[] paramArrayOfString)
  {
    paramString = query(i.e.BX, new String[] { "type", "full_path" }, paramString, paramArrayOfString, null);
    if (paramString == null)
      return;
    try
    {
      paramString.moveToPosition(-1);
      while (paramString.moveToNext())
      {
        int i = paramString.getInt(0);
        if ((i == 0) || (i == 1))
        {
          paramArrayOfString = paramString.getString(1);
          if (!TextUtils.isEmpty(paramArrayOfString))
            e.aC(paramArrayOfString);
        }
      }
    }
    finally
    {
      paramString.close();
    }
    paramString.close();
  }

  protected int deleteInTransaction(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    int i = CM.match(paramUri);
    switch (i)
    {
    default:
      throw new IllegalArgumentException("Deletion is not supported for " + paramUri);
    case 800:
      i = mDb.delete("account", paramString, paramArrayOfString);
    case 801:
    case 100:
    case 101:
    case 1208:
    case 1100:
    case 1101:
    case 1120:
    case 1122:
    case 600:
    case 601:
    case 1600:
    case 1601:
    case 1900:
    case 1901:
    case 2000:
    case 2001:
    case 2100:
    case 2101:
    case 2200:
    case 2201:
    }
    while (true)
    {
      if (i > 0)
        q(paramUri);
      return i;
      long l = ContentUris.parseId(paramUri);
      i = mDb.delete("account", "_id=?", new String[] { String.valueOf(l) });
      continue;
      if (o(paramUri))
      {
        b(mDb, paramString, paramArrayOfString);
        i = mDb.delete("tree_entity", paramString, paramArrayOfString);
      }
      else
      {
        throw new IllegalStateException("Delete TreeEntity not supported. Use update uri in TreeEntities.");
        l = ContentUris.parseId(paramUri);
        if (o(paramUri))
        {
          i = mDb.delete("tree_entity", "_id=?", new String[] { String.valueOf(l) });
        }
        else
        {
          throw new IllegalStateException("Delete TreeEntity not supported. Use update uri in TreeEntities.");
          i = g(paramString, paramArrayOfString);
          continue;
          if (o(paramUri))
          {
            i = mDb.delete("list_item", paramString, paramArrayOfString);
          }
          else
          {
            throw new IllegalStateException("Delete list items not supported. Use update uri in ListItems.");
            l = ContentUris.parseId(paramUri);
            if (o(paramUri))
            {
              i = mDb.delete("list_item", "_id=?", new String[] { String.valueOf(l) });
            }
            else
            {
              throw new IllegalStateException("Delete list item not supported. Use update uri in ListItems.");
              i = mDb.delete("list_item_conflict", paramString, paramArrayOfString);
              continue;
              l = ContentUris.parseId(paramUri);
              i = mDb.delete("list_item_conflict", "_id=?", new String[] { String.valueOf(l) });
              continue;
              if (o(paramUri))
              {
                d(paramString, paramArrayOfString);
                String str = a(mDb, paramString, paramArrayOfString);
                mDb.delete("blob", str, null);
                i = mDb.delete("blob_node", paramString, paramArrayOfString);
              }
              else
              {
                throw new IllegalStateException("Delete Blob not supported. Use update uri in Blob.");
                paramString = new String[1];
                paramString[0] = String.valueOf(ContentUris.parseId(paramUri));
                if (o(paramUri))
                {
                  d("_id=?", paramString);
                  paramArrayOfString = a(mDb, "_id=?", paramString);
                  mDb.delete("blob", paramArrayOfString, null);
                  i = mDb.delete("blob_node", "_id=?", paramString);
                }
                else
                {
                  throw new IllegalStateException("Delete Blob not supported. Use update uri in Blob.");
                  if (i == 1601)
                  {
                    paramString = "_id=?";
                    paramArrayOfString = new String[1];
                    paramArrayOfString[0] = String.valueOf(ContentUris.parseId(paramUri));
                  }
                  i = mDb.delete("alert", paramString, paramArrayOfString);
                  continue;
                  if (i == 1901)
                  {
                    paramString = "sharing._id=?";
                    paramArrayOfString = new String[1];
                    paramArrayOfString[0] = String.valueOf(ContentUris.parseId(paramUri));
                  }
                  if (o(paramUri))
                  {
                    i = mDb.delete("sharing", paramString, paramArrayOfString);
                  }
                  else
                  {
                    throw new IllegalStateException("Delete sharing entry not supported. Use update uri in Sharing.");
                    if (i == 2001)
                    {
                      paramString = "note_error._id=?";
                      paramArrayOfString = new String[1];
                      paramArrayOfString[0] = String.valueOf(ContentUris.parseId(paramUri));
                    }
                    i = mDb.delete("note_error", paramString, paramArrayOfString);
                    continue;
                    if (i == 2101)
                    {
                      paramString = "label._id=?";
                      paramArrayOfString = new String[1];
                      paramArrayOfString[0] = String.valueOf(ContentUris.parseId(paramUri));
                    }
                    if (o(paramUri))
                    {
                      i = mDb.delete("label", paramString, paramArrayOfString);
                    }
                    else
                    {
                      throw new IllegalStateException("Delete labels not supported. Use update uri in Labels.");
                      if (i == 2201)
                      {
                        paramString = "note_label._id=?";
                        paramArrayOfString = new String[1];
                        paramArrayOfString[0] = String.valueOf(ContentUris.parseId(paramUri));
                      }
                      if (!o(paramUri))
                        break;
                      i = mDb.delete("note_label", paramString, paramArrayOfString);
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    throw new IllegalStateException("Delete note labels not supported. Use update uri in NoteLabels.");
  }

  protected SQLiteOpenHelper getDatabaseHelper(Context paramContext)
  {
    if (Dd == null)
      Dd = DatabaseHelper.getInstance(paramContext);
    return Dd;
  }

  public String getType(Uri paramUri)
  {
    int i = CM.match(paramUri);
    switch (i)
    {
    default:
      throw new IllegalStateException("Unknown URI " + paramUri + " with match " + i);
    case 800:
      return "vnd.android.cursor.dir/vnd.com.google.android.keep.accounts";
    case 801:
      return "vnd.android.cursor.item/vnd.com.google.android.keep.account";
    case 100:
      return "vnd.android.cursor.dir/vnd.com.google.android.keep.tree_entities";
    case 101:
      return "vnd.android.cursor.item/vnd.com.google.android.keep.tree_entity";
    case 600:
      return "vnd.android.cursor.dir/vnd.com.google.android.keep.blobs";
    case 601:
      return "vnd.android.cursor.item/vnd.com.google.android.keep.blob";
    case 602:
      return "image/*";
    case 603:
      return "audio/*";
    case 610:
      return "vnd.android.cursor.dir/vnd.com.google.android.keep.gallery";
    case 700:
      return "vnd.android.cursor.item/vnd.com.google.android.keep.list_and_children";
    case 701:
    }
    return "vnd.android.cursor.item/vnd.com.google.android.keep.children_and_conflicts";
  }

  protected Uri insertInTransaction(Uri paramUri, ContentValues paramContentValues)
  {
    switch (CM.match(paramUri))
    {
    default:
      throw new IllegalArgumentException("Insertion is not supported for " + paramUri);
    case 800:
      return g(paramUri, paramContentValues);
    case 100:
      return a(paramUri, paramContentValues);
    case 600:
      return f(paramUri, paramContentValues);
    case 1100:
      return d(paramUri, paramContentValues);
    case 1120:
    case 1121:
      return c(paramUri, paramContentValues);
    case 1600:
      return h(paramUri, paramContentValues);
    case 1900:
      return i(paramUri, paramContentValues);
    case 2000:
      return k(paramUri, paramContentValues);
    case 2100:
      return l(paramUri, paramContentValues);
    case 2200:
    }
    return o(paramUri, paramContentValues);
  }

  protected void notifyChange()
  {
    Context localContext = getContext();
    localContext.sendBroadcast(new Intent("com.google.android.keep.intent.action.PROVIDER_CHANGED"));
    ArrayList localArrayList = (ArrayList)Dc.get();
    if ((localArrayList != null) && (!localArrayList.isEmpty()))
    {
      localContext.startService(SharingNotificationService.a(localContext, com.google.android.keep.util.e.G(localArrayList)));
      localArrayList.clear();
    }
  }

  public boolean onCreate()
  {
    super.onCreate();
    Context localContext = getContext();
    Dd = getDatabaseHelper(localContext);
    mContentResolver = localContext.getContentResolver();
    CP.put("full_path", e.w(localContext));
    x(localContext);
    return true;
  }

  public AssetFileDescriptor openAssetFile(Uri paramUri, String paramString)
  {
    int i = CM.match(paramUri);
    switch (i)
    {
    default:
      throw new IllegalArgumentException("Cannot query unknown URI " + paramUri);
    case 602:
    case 603:
      if (!TextUtils.equals(paramString, "r"))
        return null;
      paramString = b(paramUri, i);
      if (paramString != null)
        paramString = new File(paramString.getPath());
      break;
    case 604:
    case 605:
    }
    while (true)
    {
      try
      {
        paramString = new AssetFileDescriptor(ParcelFileDescriptor.open(paramString, 268435456), 0L, -1L);
        paramUri = paramString;
        return paramUri;
      }
      catch (FileNotFoundException paramString)
      {
        Log.e("Keep", "File not found:" + paramUri);
      }
      paramUri = null;
      continue;
      if (!"com.google.android.keep".equals(getContext().getApplicationInfo().packageName))
        return null;
      Object localObject = paramUri.getPathSegments();
      long l1 = ContentUris.parseId(paramUri);
      if (((List)localObject).size() < 2)
        throw new IllegalStateException("Invalid uri format:" + paramUri);
      long l2 = Long.valueOf((String)((List)localObject).get(((List)localObject).size() - 2)).longValue();
      if (i == 604)
        localObject = e.b(getContext(), l2, l1);
      try
      {
        while (true)
        {
          paramString = getContext().getContentResolver().openAssetFileDescriptor(Uri.fromFile((File)localObject), paramString);
          paramUri = paramString;
          break;
          localObject = e.c(getContext(), l2, l1);
        }
      }
      catch (FileNotFoundException paramString)
      {
        Log.e("Keep", "File not found:" + paramUri);
        paramUri = null;
      }
    }
  }

  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    SQLiteDatabase localSQLiteDatabase = Dd.getReadableDatabase();
    SQLiteQueryBuilder localSQLiteQueryBuilder = new SQLiteQueryBuilder();
    localSQLiteQueryBuilder.setStrict(true);
    int i = CM.match(paramUri);
    switch (i)
    {
    default:
      throw new IllegalArgumentException("Cannot query unknown URI " + paramUri);
    case 800:
      localSQLiteQueryBuilder.setTables("account");
      localSQLiteQueryBuilder.setProjectionMap(CN);
      paramArrayOfString1 = a(localSQLiteDatabase, localSQLiteQueryBuilder, paramArrayOfString1, paramString1, paramArrayOfString2, null, paramString2);
    case 801:
    case 100:
    case 101:
    case 1100:
    case 1101:
    case 1120:
    case 1122:
    case 600:
    case 601:
    case 610:
    case 700:
    case 701:
    case 602:
    case 603:
      do
      {
        return paramArrayOfString1;
        localSQLiteQueryBuilder.setTables("account");
        localSQLiteQueryBuilder.setProjectionMap(CN);
        return a(localSQLiteDatabase, localSQLiteQueryBuilder, paramArrayOfString1, "_id=?", new String[] { String.valueOf(ContentUris.parseId(paramUri)) }, null, paramString2);
        localSQLiteQueryBuilder.setTables("tree_entity");
        if ((paramArrayOfString1 != null) && (paramArrayOfString1.length <= 3) && (i.v.b(paramArrayOfString1)))
          localSQLiteQueryBuilder.setProjectionMap(CQ);
        while (true)
        {
          str = paramString1;
          if (!o(paramUri))
            str = aK(paramString1);
          return a(localSQLiteDatabase, localSQLiteQueryBuilder, paramArrayOfString1, str, paramArrayOfString2, null, paramString2);
          localSQLiteQueryBuilder.setProjectionMap(CO);
        }
        localSQLiteQueryBuilder.setTables("tree_entity");
        localSQLiteQueryBuilder.setProjectionMap(CO);
        paramString1 = "_id=?";
        long l = ContentUris.parseId(paramUri);
        if (!o(paramUri))
          paramString1 = aK("_id=?");
        return a(localSQLiteDatabase, localSQLiteQueryBuilder, paramArrayOfString1, paramString1, new String[] { String.valueOf(l) }, null, paramString2);
        localSQLiteQueryBuilder.setTables("list_item");
        if ((paramArrayOfString1 != null) && (paramArrayOfString1.length <= 3) && (i.m.b(paramArrayOfString1)))
          localSQLiteQueryBuilder.setProjectionMap(CT);
        while (true)
        {
          str = paramString1;
          if (!o(paramUri))
            str = aK(paramString1);
          return a(localSQLiteDatabase, localSQLiteQueryBuilder, paramArrayOfString1, str, paramArrayOfString2, null, paramString2);
          localSQLiteQueryBuilder.setProjectionMap(CR);
        }
        localSQLiteQueryBuilder.setTables("list_item");
        localSQLiteQueryBuilder.setProjectionMap(CR);
        paramString1 = "_id=?";
        l = ContentUris.parseId(paramUri);
        if (!o(paramUri))
          paramString1 = aK("_id=?");
        return a(localSQLiteDatabase, localSQLiteQueryBuilder, paramArrayOfString1, paramString1, new String[] { String.valueOf(l) }, null, paramString2);
        if (i == 1122)
        {
          paramString1 = "_id=?";
          paramArrayOfString2 = new String[1];
          paramArrayOfString2[0] = String.valueOf(ContentUris.parseId(paramUri));
        }
        return a(localSQLiteDatabase, paramArrayOfString1, paramString1, paramArrayOfString2, null);
        localSQLiteQueryBuilder.setTables("blob_node JOIN blob ON CASE use_edited WHEN 1 THEN edited_id = blob_id ELSE original_id = blob_id END");
        localSQLiteQueryBuilder.setProjectionMap(CP);
        str = paramString1;
        if (!o(paramUri))
          str = aK(paramString1);
        return a(localSQLiteDatabase, localSQLiteQueryBuilder, paramArrayOfString1, str, paramArrayOfString2, null, paramString2);
        localSQLiteQueryBuilder.setTables("blob_node JOIN blob ON CASE use_edited WHEN 1 THEN edited_id = blob_id ELSE original_id = blob_id END");
        localSQLiteQueryBuilder.setProjectionMap(CP);
        paramString1 = "blob_node._id=?";
        l = ContentUris.parseId(paramUri);
        if (!o(paramUri))
          paramString1 = aK("blob_node._id=?");
        return a(localSQLiteDatabase, localSQLiteQueryBuilder, paramArrayOfString1, paramString1, new String[] { String.valueOf(l) }, null, paramString2);
        localSQLiteQueryBuilder.setTables("blob_node JOIN blob ON CASE use_edited WHEN 1 THEN edited_id = blob_id ELSE original_id = blob_id END");
        paramString1 = "tree_entity_id=? AND blob_node.type=?";
        l = ContentUris.parseId(paramUri);
        if (!o(paramUri))
          paramString1 = aK("tree_entity_id=? AND blob_node.type=?");
        return a(localSQLiteDatabase, localSQLiteQueryBuilder, paramArrayOfString1, paramString1, new String[] { String.valueOf(l), String.valueOf(0) }, null, "time_created DESC");
        return a(localSQLiteDatabase, localSQLiteQueryBuilder, paramUri, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2);
        return b(localSQLiteDatabase, localSQLiteQueryBuilder, paramUri, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2);
        if (paramArrayOfString1 != null)
          break;
        paramArrayOfString1 = i.e.Cg;
        paramString1 = new MatrixCursor(paramArrayOfString1, 1);
        paramArrayOfString2 = new Object[paramArrayOfString1.length];
        paramString2 = openAssetFile(paramUri, "r");
        paramArrayOfString1 = paramString1;
      }
      while (paramString2 == null);
      while (true)
      {
        try
        {
          a(paramString1, paramArrayOfString2, "_display_name", c(com.google.android.keep.util.e.currentTimeMillis(), i));
          a(paramString1, paramArrayOfString2, "_size", Long.valueOf(paramString2.getLength()));
          if (i != 602)
            break label1099;
          a(paramString1, paramArrayOfString2, "mime_type", a(localSQLiteDatabase, localSQLiteQueryBuilder, ContentUris.parseId(paramUri)));
          paramString1.addRow(paramArrayOfString2);
          paramString2.close();
          return paramString1;
        }
        catch (IOException paramUri)
        {
          Log.e("Keep", "Failed to close the file descriptor.");
          return paramString1;
        }
        break;
        paramArrayOfString1 = b.a(getContext().getContentResolver(), paramUri);
        paramUri = paramArrayOfString1;
        if ("UNKNOWN".equals(paramArrayOfString1))
          paramUri = null;
        a(paramString1, paramArrayOfString2, "mime_type", paramUri);
      }
    case 1600:
    case 1601:
      localSQLiteQueryBuilder.setTables("alert");
      localSQLiteQueryBuilder.setProjectionMap(CW);
      if (i == 1601)
      {
        paramString1 = "alert._id=?";
        paramArrayOfString2 = new String[1];
        paramArrayOfString2[0] = String.valueOf(ContentUris.parseId(paramUri));
      }
      return a(localSQLiteDatabase, localSQLiteQueryBuilder, paramArrayOfString1, paramString1, paramArrayOfString2, null, paramString2);
    case 1900:
    case 1901:
      if (i == 1901)
      {
        paramString1 = "sharing._id=?";
        paramArrayOfString2 = new String[1];
        paramArrayOfString2[0] = String.valueOf(ContentUris.parseId(paramUri));
      }
      str = paramString1;
      if (!o(paramUri))
        str = aK(paramString1);
      paramUri = "sharing.role DESC,sharing.name COLLATE NOCASE,sharing.email COLLATE NOCASE";
      if (!TextUtils.isEmpty(paramString2))
        paramUri = "sharing.role DESC,sharing.name COLLATE NOCASE,sharing.email COLLATE NOCASE" + " " + paramString2;
      return b(localSQLiteDatabase, paramArrayOfString1, str, paramArrayOfString2, paramUri);
    case 2000:
    case 2001:
      if (i == 2001)
      {
        paramString1 = "note_error._id=?";
        paramArrayOfString2 = new String[1];
        paramArrayOfString2[0] = String.valueOf(ContentUris.parseId(paramUri));
      }
      return a(localSQLiteDatabase, paramArrayOfString1, paramString1, paramArrayOfString2);
    case 1800:
    case 1820:
      paramString1 = "tree_entity.order_in_parent DESC,tree_entity.time_last_updated DESC";
      if (!TextUtils.isEmpty(paramString2))
        paramString1 = "tree_entity.order_in_parent DESC,tree_entity.time_last_updated DESC" + " " + paramString2;
      return c(localSQLiteDatabase, localSQLiteQueryBuilder, paramUri, paramArrayOfString1, "tree_entity.is_archived=0 AND tree_entity.is_trashed=0", null, paramString1);
    case 1801:
      paramString1 = "tree_entity.order_in_parent DESC,tree_entity.time_last_updated DESC";
      if (!TextUtils.isEmpty(paramString2))
        paramString1 = "tree_entity.order_in_parent DESC,tree_entity.time_last_updated DESC" + " " + paramString2;
      return c(localSQLiteDatabase, localSQLiteQueryBuilder, paramUri, paramArrayOfString1, "tree_entity.is_archived=1 AND tree_entity.is_trashed=0", null, paramString1);
    case 1806:
      paramString1 = "tree_entity.time_last_updated DESC,tree_entity.order_in_parent DESC";
      if (!TextUtils.isEmpty(paramString2))
        paramString1 = "tree_entity.time_last_updated DESC,tree_entity.order_in_parent DESC" + " " + paramString2;
      return c(localSQLiteDatabase, localSQLiteQueryBuilder, paramUri, paramArrayOfString1, "tree_entity.is_trashed=1", null, paramString1);
    case 1804:
    case 1805:
      if (i == 1805)
      {
        paramString1 = "tree_entity._id=?";
        paramArrayOfString2 = new String[1];
        paramArrayOfString2[0] = String.valueOf(ContentUris.parseId(paramUri));
      }
      return c(localSQLiteDatabase, localSQLiteQueryBuilder, paramUri, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2);
    case 1802:
      paramString1 = paramUri.getQueryParameter(i.f.Cn);
      return c(localSQLiteDatabase, localSQLiteQueryBuilder, paramUri, paramArrayOfString1, m.aN(paramString1), m.aO(paramString1), "tree_entity.is_trashed ASC,tree_entity.is_archived ASC,tree_entity.time_last_updated DESC");
    case 2100:
    case 2101:
      label1099: localSQLiteQueryBuilder.setTables("label");
      localSQLiteQueryBuilder.setProjectionMap(CZ);
      if (i == 2101)
      {
        paramString1 = "label._id=?";
        paramArrayOfString2 = new String[1];
        paramArrayOfString2[0] = String.valueOf(ContentUris.parseId(paramUri));
      }
      str = paramString1;
      if (!o(paramUri))
        str = aK(paramString1);
      return a(localSQLiteDatabase, localSQLiteQueryBuilder, paramArrayOfString1, str, paramArrayOfString2, null, paramString2);
    case 2200:
    case 2201:
    }
    localSQLiteQueryBuilder.setTables("note_label");
    localSQLiteQueryBuilder.setProjectionMap(Da);
    if (i == 2201)
    {
      paramString1 = "note_label._id=?";
      paramArrayOfString2 = new String[1];
      paramArrayOfString2[0] = String.valueOf(ContentUris.parseId(paramUri));
    }
    String str = paramString1;
    if (!o(paramUri))
      str = aK(paramString1);
    return a(localSQLiteDatabase, localSQLiteQueryBuilder, paramArrayOfString1, str, paramArrayOfString2, null, paramString2);
  }

  protected int updateInTransaction(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    int i = CM.match(paramUri);
    switch (i)
    {
    default:
      throw new IllegalArgumentException("Update is not supported for " + paramUri);
    case 800:
    case 801:
      if (i == 801)
      {
        paramString = "_id=?";
        paramArrayOfString = new String[1];
        paramArrayOfString[0] = String.valueOf(ContentUris.parseId(paramUri));
      }
      if ((paramContentValues != null) && (paramContentValues.size() > 0))
        i = mDb.update("account", paramContentValues, paramString, paramArrayOfString);
      break;
    case 200:
    case 203:
    case 202:
    case 205:
    case 206:
    case 2000:
    case 2100:
    case 2101:
    case 2200:
    case 2201:
    case 501:
    case 502:
    case 503:
    case 504:
    case 1100:
    case 1101:
    case 1120:
    case 1122:
    case 100:
    case 101:
    case 600:
    case 601:
    case 606:
    case 1200:
    case 1204:
    case 1201:
    case 1205:
    case 1202:
    case 1206:
    case 1203:
    case 1207:
    case 1209:
    case 1210:
    case 1211:
    case 1212:
    case 1213:
    case 1214:
    case 1300:
    case 1304:
    case 1301:
    case 1305:
    case 1302:
    case 1306:
    case 1303:
    case 1307:
    case 1400:
    case 1404:
    case 1401:
    case 1405:
    case 1402:
    case 1406:
    case 1403:
    case 1407:
    case 1600:
    case 1601:
    case 1900:
    case 1901:
    }
    while (true)
    {
      if (i > 0)
        q(paramUri);
      return i;
      i = 0;
      continue;
      if (i == 203)
      {
        paramString = "_id=?";
        paramArrayOfString = new String[1];
        paramArrayOfString[0] = String.valueOf(ContentUris.parseId(paramUri));
      }
      i = e(paramString, paramArrayOfString);
      continue;
      i = f(paramString, paramArrayOfString);
      continue;
      i = R(ContentUris.parseId(paramUri));
      continue;
      i = S(ContentUris.parseId(paramUri));
      continue;
      i = a(paramString, paramArrayOfString, paramContentValues);
      continue;
      if (i == 2101)
      {
        paramString = "label._id=?";
        paramArrayOfString = new String[1];
        paramArrayOfString[0] = String.valueOf(ContentUris.parseId(paramUri));
      }
      i = a(paramUri, paramString, paramArrayOfString, paramContentValues);
      continue;
      if (i == 2201)
      {
        paramString = "note_label._id=?";
        paramArrayOfString = new String[1];
        paramArrayOfString[0] = String.valueOf(ContentUris.parseId(paramUri));
      }
      i = b(paramUri, paramString, paramArrayOfString, paramContentValues);
      continue;
      i = ReorderEntitiesHelper.a(mDb, "tree_entity", paramUri, true);
      continue;
      i = ReorderEntitiesHelper.a(mDb, "tree_entity", paramUri, false);
      continue;
      i = ReorderEntitiesHelper.a(mDb, "list_item", paramUri, true);
      continue;
      i = ReorderEntitiesHelper.a(mDb, "list_item", paramUri, false);
      continue;
      if (i == 1101)
      {
        paramString = "_id=?";
        paramArrayOfString = new String[1];
        paramArrayOfString[0] = String.valueOf(ContentUris.parseId(paramUri));
      }
      i = c(paramUri, paramContentValues, paramString, paramArrayOfString);
      continue;
      if (i == 1122)
      {
        paramString = "_id=?";
        paramArrayOfString = new String[1];
        paramArrayOfString[0] = String.valueOf(ContentUris.parseId(paramUri));
      }
      i = d(paramUri, paramContentValues, paramString, paramArrayOfString);
      continue;
      if (i == 101)
      {
        paramString = "_id=?";
        paramArrayOfString = new String[1];
        paramArrayOfString[0] = String.valueOf(ContentUris.parseId(paramUri));
      }
      i = b(paramUri, paramContentValues, paramString, paramArrayOfString);
      continue;
      if (i == 601)
      {
        paramString = "blob_node._id=?";
        paramArrayOfString = new String[1];
        paramArrayOfString[0] = String.valueOf(ContentUris.parseId(paramUri));
      }
      i = e(paramUri, paramContentValues, paramString, paramArrayOfString);
      continue;
      i = f(paramUri, paramContentValues, paramString, paramArrayOfString);
      continue;
      if (i == 1200)
      {
        paramString = "_id=?";
        paramArrayOfString = new String[1];
        paramArrayOfString[0] = String.valueOf(ContentUris.parseId(paramUri));
      }
      i = a(paramString, paramArrayOfString, 0, -1);
      continue;
      if (i == 1201)
      {
        paramString = "_id=?";
        paramArrayOfString = new String[1];
        paramArrayOfString[0] = String.valueOf(ContentUris.parseId(paramUri));
      }
      i = a(paramString, paramArrayOfString, -1, 0);
      continue;
      if (i == 1202)
      {
        paramString = "_id=?";
        paramArrayOfString = new String[1];
        paramArrayOfString[0] = String.valueOf(ContentUris.parseId(paramUri));
      }
      i = a(paramString, paramArrayOfString, -1, 1);
      continue;
      if (i == 1203)
      {
        paramString = "_id=?";
        paramArrayOfString = new String[1];
        paramArrayOfString[0] = String.valueOf(ContentUris.parseId(paramUri));
      }
      i = a(paramString, paramArrayOfString, 0, 1);
      continue;
      i = a(h.p(paramString, "is_trashed=1"), paramArrayOfString, 0, 1);
      continue;
      i = U(ContentUris.parseId(paramUri));
      continue;
      i = V(ContentUris.parseId(paramUri));
      continue;
      i = W(ContentUris.parseId(paramUri));
      continue;
      i = a(ContentUris.parseId(paramUri), paramContentValues);
      continue;
      i = b(ContentUris.parseId(paramUri), paramContentValues);
      continue;
      if (i == 1300)
      {
        paramString = "blob_node._id=?";
        paramArrayOfString = new String[1];
        paramArrayOfString[0] = String.valueOf(ContentUris.parseId(paramUri));
      }
      i = a(paramString, paramArrayOfString, 0, -1, true);
      continue;
      if (i == 1301)
      {
        paramString = "blob_node._id=?";
        paramArrayOfString = new String[1];
        paramArrayOfString[0] = String.valueOf(ContentUris.parseId(paramUri));
      }
      i = a(paramString, paramArrayOfString, -1, 0, true);
      continue;
      if (i == 1302)
      {
        paramString = "blob_node._id=?";
        paramArrayOfString = new String[1];
        paramArrayOfString[0] = String.valueOf(ContentUris.parseId(paramUri));
      }
      i = a(paramString, paramArrayOfString, -1, 1, true);
      continue;
      if (i == 1303)
      {
        paramString = "blob_node._id=?";
        paramArrayOfString = new String[1];
        paramArrayOfString[0] = String.valueOf(ContentUris.parseId(paramUri));
      }
      i = a(paramString, paramArrayOfString, 0, 1, true);
      continue;
      if (i == 1400)
      {
        paramString = "_id=?";
        paramArrayOfString = new String[1];
        paramArrayOfString[0] = String.valueOf(ContentUris.parseId(paramUri));
      }
      i = b(paramString, paramArrayOfString, 0, -1, true);
      continue;
      if (i == 1401)
      {
        paramString = "_id=?";
        paramArrayOfString = new String[1];
        paramArrayOfString[0] = String.valueOf(ContentUris.parseId(paramUri));
      }
      i = b(paramString, paramArrayOfString, -1, 0, true);
      continue;
      if (i == 1402)
      {
        paramString = "_id=?";
        paramArrayOfString = new String[1];
        paramArrayOfString[0] = String.valueOf(ContentUris.parseId(paramUri));
      }
      i = b(paramString, paramArrayOfString, -1, 1, true);
      continue;
      if (i == 1403)
      {
        paramString = "_id=?";
        paramArrayOfString = new String[1];
        paramArrayOfString[0] = String.valueOf(ContentUris.parseId(paramUri));
      }
      i = b(paramString, paramArrayOfString, 0, 1, true);
      continue;
      if (i == 1601)
      {
        paramString = "_id=?";
        paramArrayOfString = new String[1];
        paramArrayOfString[0] = String.valueOf(ContentUris.parseId(paramUri));
      }
      i = b(paramContentValues, paramString, paramArrayOfString);
      continue;
      if (i == 1901)
      {
        paramString = "sharing._id=?";
        paramArrayOfString = new String[1];
        paramArrayOfString[0] = String.valueOf(ContentUris.parseId(paramUri));
      }
      i = a(paramUri, paramContentValues, paramString, paramArrayOfString);
    }
  }

  protected void x(Context paramContext)
  {
    AccountManager localAccountManager = AccountManager.get(paramContext);
    paramContext = new a(paramContext);
    localAccountManager.addOnAccountsUpdatedListener(paramContext, null, false);
    paramContext.onAccountsUpdated(localAccountManager.getAccountsByType("com.google"));
  }

  private static class a
  {
    public final long cU;
    public final int mType;

    public a(int paramInt, long paramLong)
    {
      mType = paramInt;
      cU = paramLong;
    }
  }
}
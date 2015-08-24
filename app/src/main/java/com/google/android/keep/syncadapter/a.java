package com.google.android.keep.syncadapter;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import com.google.common.collect.Lists;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class a
{
  private static final String[] COLUMNS;
  static final int Fo;
  static final int Fp;
  static final int Fq;
  static final int Fr;
  static final int Fs;
  static final int Ft;
  static final int Fu;
  static final int Fv;
  static final int Fw;
  public static final Map<String, String> Fx;
  static final int tu;
  static final int tv;
  static final int tw;
  static final int tx;
  static final int uR;
  static final int uS;
  static final int uT;
  static final int uU;
  static final int uV;
  private static final List<String> uo = Lists.newArrayList();
  static final int vR;
  static final int yB = F("_id");
  private final int FA;
  private final SQLiteDatabase Fy;
  private final int Fz;
  private final long cU;

  static
  {
    tv = F("uuid");
    tw = F("server_id");
    tx = F("type");
    tu = F("tree_entity_id");
    uR = F("time_created");
    Fo = F("time_last_updated");
    Fp = F("is_deleted");
    Fq = F("version");
    vR = F("base_version");
    Fr = F("mime_type");
    Fs = F("media_id");
    uS = F("data1");
    uT = F("data2");
    uU = F("extracted_text");
    uV = F("extraction_status");
    Ft = F("blob_size");
    Fu = F("parent_uuid");
    Fv = F("parent_server_id");
    Fw = F("is_trashed");
    COLUMNS = (String[])uo.toArray(new String[uo.size()]);
    Fx = new HashMap();
    int i = 0;
    while (i < Fr)
    {
      Fx.put(COLUMNS[i], "blob_node." + COLUMNS[i]);
      i += 1;
    }
    i = Fr;
    while (i < Fu)
    {
      Fx.put(COLUMNS[i], "blob." + COLUMNS[i]);
      i += 1;
    }
    Fx.put("parent_uuid", "parent_tree_entity.uuid");
    Fx.put("parent_server_id", "parent_tree_entity.server_id");
    Fx.put("is_trashed", "parent_tree_entity.is_trashed");
  }

  a(SQLiteDatabase paramSQLiteDatabase, long paramLong, boolean paramBoolean, int paramInt)
  {
    Fy = paramSQLiteDatabase;
    cU = paramLong;
    if (paramBoolean);
    for (int i = 1; ; i = 0)
    {
      Fz = i;
      FA = paramInt;
      return;
    }
  }

  private static int F(String paramString)
  {
    uo.add(paramString);
    return uo.size() - 1;
  }

  Cursor li()
  {
    SQLiteQueryBuilder localSQLiteQueryBuilder = new SQLiteQueryBuilder();
    localSQLiteQueryBuilder.setStrict(true);
    localSQLiteQueryBuilder.setTables("blob_node JOIN blob ON CASE use_edited WHEN 1 THEN edited_id = blob_id ELSE original_id = blob_id END LEFT OUTER JOIN tree_entity as parent_tree_entity ON blob_node.tree_entity_id=parent_tree_entity._id");
    localSQLiteQueryBuilder.setProjectionMap(Fx);
    SQLiteDatabase localSQLiteDatabase = Fy;
    String[] arrayOfString = COLUMNS;
    int i = Fz;
    long l = cU;
    int j = FA;
    return localSQLiteQueryBuilder.query(localSQLiteDatabase, arrayOfString, "blob_node.is_dirty=1 AND blob_node.is_deleted=? AND blob_node.account_id=?", new String[] { String.valueOf(i), String.valueOf(l) }, null, null, "blob_node.time_created ASC ", String.valueOf(j));
  }
}
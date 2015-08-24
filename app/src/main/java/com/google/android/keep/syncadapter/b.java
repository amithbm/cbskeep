package com.google.android.keep.syncadapter;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import com.google.common.collect.Lists;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class b
{
  private static final String[] COLUMNS;
  static final int Fq;
  public static final Map<String, String> Fx;
  static final int Gk;
  static final int Gl;
  static final int Gm;
  static final int Gn;
  static final int tv;
  static final int uR;
  private static final List<String> uo = Lists.newArrayList();
  static final int vA;
  static final int vz;
  static final int yi;
  private final SQLiteDatabase Fy;
  private final int Fz;
  private final long cU;

  static
  {
    tv = F("uuid");
    vz = F("name");
    vA = F("last_used_timestamp");
    Gk = F("server_version_number");
    Fq = F("version");
    Gl = F("deleted_timestamp");
    uR = F("time_created");
    yi = F("user_edited_timestamp");
    Gm = F("merged_uuids");
    Gn = F("time_merged");
    COLUMNS = (String[])uo.toArray(new String[uo.size()]);
    Fx = new HashMap();
    Fx.put("uuid", "label.uuid");
    Fx.put("name", "label.name");
    Fx.put("last_used_timestamp", "label.last_used_timestamp");
    Fx.put("server_version_number", "label.server_version_number");
    Fx.put("version", "label.version");
    Fx.put("deleted_timestamp", "label.deleted_timestamp");
    Fx.put("time_created", "label.time_created");
    Fx.put("user_edited_timestamp", "label.user_edited_timestamp");
    Fx.put("merged_uuids", "label.merged_uuids");
    Fx.put("time_merged", "label.time_merged");
  }

  b(SQLiteDatabase paramSQLiteDatabase, long paramLong, boolean paramBoolean)
  {
    Fy = paramSQLiteDatabase;
    cU = paramLong;
    if (paramBoolean);
    for (int i = 1; ; i = 0)
    {
      Fz = i;
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
    localSQLiteQueryBuilder.setTables("label");
    localSQLiteQueryBuilder.setProjectionMap(Fx);
    return localSQLiteQueryBuilder.query(Fy, COLUMNS, "label.is_dirty=1 AND label.is_deleted=? AND label.account_id=?", new String[] { String.valueOf(Fz), String.valueOf(cU) }, null, null, "label.time_created ASC");
  }
}
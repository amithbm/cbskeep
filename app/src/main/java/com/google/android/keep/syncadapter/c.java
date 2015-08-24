package com.google.android.keep.syncadapter;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import com.google.common.collect.Lists;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class c
{
  private static final String[] COLUMNS;
  static final int Fo;
  static final int Fp;
  static final int Fq;
  static final int Fu;
  static final int Fv;
  static final int Fw;
  public static final Map<String, String> Fx;
  static final int Go;
  static final int TEXT;
  static final int tv;
  static final int tw;
  static final int uR;
  private static final List<String> uo = Lists.newArrayList();
  static final int vP;
  static final int vR;
  static final int vW;
  static final int xT;
  static final int yB = F("_id");
  private final int FA;
  private final SQLiteDatabase Fy;
  private final int Fz;
  private final long cU;

  static
  {
    tv = F("uuid");
    tw = F("server_id");
    TEXT = F("text");
    vP = F("is_checked");
    xT = F("order_in_parent");
    uR = F("time_created");
    Fo = F("time_last_updated");
    Fp = F("is_deleted");
    Fq = F("version");
    vR = F("base_version");
    vW = F("merge_token");
    Go = F("realtime_data_server_version");
    Fu = F("parent_uuid");
    Fv = F("parent_server_id");
    Fw = F("is_trashed");
    COLUMNS = (String[])uo.toArray(new String[uo.size()]);
    Fx = new HashMap();
    int i = 0;
    while (i < Fu)
    {
      Fx.put(COLUMNS[i], "list_item." + COLUMNS[i]);
      i += 1;
    }
    Fx.put("parent_uuid", "parent_tree_entity.uuid");
    Fx.put("parent_server_id", "parent_tree_entity.server_id");
    Fx.put("is_trashed", "parent_tree_entity.is_trashed");
  }

  c(SQLiteDatabase paramSQLiteDatabase, long paramLong, boolean paramBoolean, int paramInt)
  {
    Fy = paramSQLiteDatabase;
    if (paramBoolean);
    for (int i = 1; ; i = 0)
    {
      Fz = i;
      FA = paramInt;
      cU = paramLong;
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
    localSQLiteQueryBuilder.setTables("list_item LEFT OUTER JOIN tree_entity AS parent_tree_entity ON list_item.list_parent_id=parent_tree_entity._id LEFT OUTER JOIN list_item_conflict ON list_item.server_id=list_item_conflict.server_id");
    localSQLiteQueryBuilder.setProjectionMap(Fx);
    SQLiteDatabase localSQLiteDatabase = Fy;
    String[] arrayOfString = COLUMNS;
    int i = Fz;
    long l = cU;
    int j = FA;
    return localSQLiteQueryBuilder.query(localSQLiteDatabase, arrayOfString, "list_item.is_dirty=1 AND list_item.is_deleted=? AND list_item.account_id=? AND list_item_conflict.server_id IS NULL", new String[] { String.valueOf(i), String.valueOf(l) }, null, null, "list_item.time_created ASC ", String.valueOf(j));
  }
}
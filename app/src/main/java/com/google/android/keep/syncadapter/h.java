package com.google.android.keep.syncadapter;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import com.google.common.collect.Lists;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class h
{
  private static final String[] COLUMNS;
  static final int Fo;
  static final int Fp;
  static final int Fq;
  static final int Fu;
  static final int Fv;
  public static final Map<String, String> Fx;
  static final int Go;
  static final int tB;
  static final int tv;
  static final int tw;
  static final int tx;
  static final int ty;
  static final int tz;
  static final int uR;
  private static final List<String> uo = Lists.newArrayList();
  static final int vR;
  static final int vS;
  static final int xR;
  static final int xS;
  static final int xT;
  static final int xU;
  static final int xV;
  static final int yB = F("_id");
  static final int yb;
  static final int yf;
  static final int yg;
  static final int yi;
  static final int zX;
  private final int FA;
  private final SQLiteDatabase Fy;
  private final int Fz;
  private final long cU;

  static
  {
    tv = F("uuid");
    tw = F("server_id");
    tx = F("type");
    ty = F("title");
    tz = F("color_name");
    vS = F("parent_id");
    xT = F("order_in_parent");
    xU = F("is_archived");
    xV = F("is_trashed");
    tB = F("is_graveyard_off");
    xR = F("is_graveyard_closed");
    xS = F("is_new_list_item_from_top");
    uR = F("time_created");
    Fo = F("time_last_updated");
    yi = F("user_edited_timestamp");
    Fp = F("is_deleted");
    Fq = F("version");
    vR = F("base_version");
    yb = F("has_read");
    yf = F("last_modifier_email");
    yg = F("last_changes_seen_timestamp");
    zX = F("is_brix_document_created");
    Go = F("realtime_data_server_version");
    Fu = F("parent_uuid");
    Fv = F("parent_server_id");
    COLUMNS = (String[])uo.toArray(new String[uo.size()]);
    Fx = new HashMap();
    int i = 0;
    while (i <= Go)
    {
      Fx.put(COLUMNS[i], "tree_entity." + COLUMNS[i]);
      i += 1;
    }
    Fx.put("parent_uuid", "parent_tree_entity.uuid");
    Fx.put("parent_server_id", "parent_tree_entity.server_id");
  }

  h(SQLiteDatabase paramSQLiteDatabase, long paramLong, boolean paramBoolean, int paramInt)
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
    localSQLiteQueryBuilder.setTables("tree_entity LEFT OUTER JOIN tree_entity as parent_tree_entity ON (tree_entity.parent_id=parent_tree_entity._id)");
    localSQLiteQueryBuilder.setProjectionMap(Fx);
    SQLiteDatabase localSQLiteDatabase = Fy;
    String[] arrayOfString = COLUMNS;
    int i = Fz;
    long l = cU;
    int j = FA;
    return localSQLiteQueryBuilder.query(localSQLiteDatabase, arrayOfString, "tree_entity.is_dirty=1 AND tree_entity.is_deleted=? AND tree_entity.account_id=?", new String[] { String.valueOf(i), String.valueOf(l) }, null, null, "tree_entity.time_created ASC", String.valueOf(j));
  }
}
package com.google.android.keep.syncadapter;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import com.google.common.collect.Lists;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class d
{
  private static final String[] COLUMNS;
  public static final Map<String, String> Fx;
  static final int Gp;
  static final int Gq;
  private static final List<String> uo = Lists.newArrayList();
  static final int yJ = F("label_id");
  private final int FA;
  private final SQLiteDatabase Fy;
  private final long cU;
  private final long mId;

  static
  {
    Gp = F("deleted_timestamp");
    Gq = F("is_deleted");
    COLUMNS = (String[])uo.toArray(new String[uo.size()]);
    Fx = new HashMap();
    Fx.put("label_id", "note_label.label_id");
    Fx.put("deleted_timestamp", "note_label.deleted_timestamp");
    Fx.put("is_deleted", "note_label.is_deleted");
  }

  d(SQLiteDatabase paramSQLiteDatabase, long paramLong1, long paramLong2, int paramInt)
  {
    Fy = paramSQLiteDatabase;
    mId = paramLong1;
    cU = paramLong2;
    FA = paramInt;
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
    localSQLiteQueryBuilder.setTables("note_label");
    localSQLiteQueryBuilder.setProjectionMap(Fx);
    SQLiteDatabase localSQLiteDatabase = Fy;
    String[] arrayOfString = COLUMNS;
    long l1 = mId;
    long l2 = cU;
    int i = FA;
    return localSQLiteQueryBuilder.query(localSQLiteDatabase, arrayOfString, "note_label.is_dirty=1 AND note_label.tree_entity_id=? AND note_label.account_id=?", new String[] { String.valueOf(l1), String.valueOf(l2) }, null, null, null, String.valueOf(i));
  }
}
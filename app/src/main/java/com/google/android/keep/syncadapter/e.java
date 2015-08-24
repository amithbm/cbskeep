package com.google.android.keep.syncadapter;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import com.google.common.collect.Lists;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class e
{
  private static final String[] COLUMNS;
  static final int EMAIL;
  static final int Fp;
  static final Map<String, String> Fx;
  private static final List<String> uo = Lists.newArrayList();
  private final SQLiteDatabase Fy;
  private final String[] Gr;

  static
  {
    EMAIL = F("email");
    Fp = F("is_deleted");
    COLUMNS = (String[])uo.toArray(new String[uo.size()]);
    Fx = new HashMap();
    String[] arrayOfString = COLUMNS;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      Fx.put(str, "sharing." + str);
      i += 1;
    }
  }

  e(SQLiteDatabase paramSQLiteDatabase, long paramLong1, long paramLong2)
  {
    Fy = paramSQLiteDatabase;
    Gr = new String[] { String.valueOf(paramLong1), String.valueOf(paramLong2) };
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
    localSQLiteQueryBuilder.setTables("sharing");
    localSQLiteQueryBuilder.setProjectionMap(Fx);
    return localSQLiteQueryBuilder.query(Fy, COLUMNS, "sharing.tree_entity_id=? AND sharing.account_id=? AND sharing.is_dirty=1 AND sharing.role!=4", Gr, null, null, null);
  }
}
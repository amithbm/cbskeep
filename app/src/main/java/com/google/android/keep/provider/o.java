package com.google.android.keep.provider;

import android.content.ContentResolver;
import android.database.Cursor;
import android.database.CursorWrapper;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.Map;

public class o extends CursorWrapper
{
  private static final String[] DV = { "account_id" };
  private final Bundle BR = new Bundle();
  private boolean DW;
  private boolean DX = true;
  private boolean DY;
  private boolean DZ;
  private long Ea;
  private long cU;

  public o(ContentResolver paramContentResolver, SQLiteDatabase paramSQLiteDatabase, Map<String, String> paramMap, Cursor paramCursor, long paramLong)
  {
    super(paramCursor);
    b(paramSQLiteDatabase, paramLong);
    c(paramSQLiteDatabase, paramLong);
    a(paramSQLiteDatabase, paramMap, paramLong);
    if (DW)
      b(paramSQLiteDatabase, Long.valueOf(cU), paramCursor);
    BR.putBoolean("hasDataReady", DX);
    BR.putBoolean("hasCheckedItems", DY);
    BR.putBoolean("hasConflict", DZ);
    BR.putLong("conflictTimeLastUpdated", Ea);
    setNotificationUri(paramContentResolver, i.AUTHORITY_URI);
  }

  o(SQLiteDatabase paramSQLiteDatabase, Cursor paramCursor, long paramLong)
  {
    super(paramCursor);
    b(paramSQLiteDatabase, paramLong);
  }

  private void a(SQLiteDatabase paramSQLiteDatabase, Map<String, String> paramMap, long paramLong)
  {
    SQLiteQueryBuilder localSQLiteQueryBuilder = new SQLiteQueryBuilder();
    localSQLiteQueryBuilder.setTables("tree_entity");
    localSQLiteQueryBuilder.setProjectionMap(paramMap);
    paramSQLiteDatabase = localSQLiteQueryBuilder.query(paramSQLiteDatabase, DV, "tree_entity._id=? AND tree_entity.is_deleted=0 ", new String[] { String.valueOf(paramLong) }, null, null, null);
    try
    {
      if (paramSQLiteDatabase.moveToFirst())
      {
        DW = true;
        cU = paramSQLiteDatabase.getLong(0);
      }
      while (true)
      {
        return;
        DW = false;
      }
    }
    finally
    {
      paramSQLiteDatabase.close();
    }
    throw paramMap;
  }

  private void b(SQLiteDatabase paramSQLiteDatabase, long paramLong)
  {
    SQLiteQueryBuilder localSQLiteQueryBuilder = new SQLiteQueryBuilder();
    localSQLiteQueryBuilder.setTables("list_item");
    paramSQLiteDatabase = localSQLiteQueryBuilder.query(paramSQLiteDatabase, new String[] { "_id" }, "list_parent_id=? AND is_checked<>0 AND is_deleted=0", new String[] { String.valueOf(paramLong) }, null, null, "time_created LIMIT 1");
    try
    {
      if (paramSQLiteDatabase.getCount() > 0);
      for (boolean bool = true; ; bool = false)
      {
        DY = bool;
        return;
      }
    }
    finally
    {
      paramSQLiteDatabase.close();
    }
  }

  private void b(SQLiteDatabase paramSQLiteDatabase, Long paramLong, Cursor paramCursor)
  {
    if (((paramCursor != null) && (paramCursor.getCount() > 0)) || (paramLong == null))
      DX = true;
    while (true)
    {
      return;
      paramCursor = new SQLiteQueryBuilder();
      paramCursor.setTables("account");
      paramLong = String.valueOf(paramLong);
      paramSQLiteDatabase = paramCursor.query(paramSQLiteDatabase, new String[] { "last_sync_version" }, "_id=?", new String[] { paramLong }, null, null, null);
      if (paramSQLiteDatabase != null);
      try
      {
        if (paramSQLiteDatabase.moveToFirst())
          if (TextUtils.isEmpty(paramSQLiteDatabase.getString(0)))
            break label116;
        label116: for (boolean bool = true; ; bool = false)
        {
          DX = bool;
          return;
        }
      }
      finally
      {
        if (paramSQLiteDatabase != null)
          paramSQLiteDatabase.close();
      }
    }
    throw paramLong;
  }

  private void c(SQLiteDatabase paramSQLiteDatabase, long paramLong)
  {
    SQLiteQueryBuilder localSQLiteQueryBuilder = new SQLiteQueryBuilder();
    localSQLiteQueryBuilder.setTables("list_item_conflict");
    paramSQLiteDatabase = localSQLiteQueryBuilder.query(paramSQLiteDatabase, new String[] { "_id", "time_last_updated" }, "list_parent_id=?", new String[] { String.valueOf(paramLong) }, null, null, "time_last_updated DESC LIMIT 1");
    try
    {
      boolean bool;
      if (paramSQLiteDatabase.getCount() > 0)
      {
        bool = true;
        DZ = bool;
        if (!DZ)
          break label110;
        paramSQLiteDatabase.moveToFirst();
      }
      label110: for (Ea = paramSQLiteDatabase.getLong(1); ; Ea = 0L)
      {
        return;
        bool = false;
        break;
      }
    }
    finally
    {
      paramSQLiteDatabase.close();
    }
  }

  public Bundle getExtras()
  {
    return BR;
  }

  boolean kE()
  {
    return DY;
  }
}
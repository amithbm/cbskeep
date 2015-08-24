package com.android.common.content;

import android.content.ContentProvider;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentValues;
import android.content.Context;
import android.content.OperationApplicationException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteTransactionListener;
import android.net.Uri;
import java.util.ArrayList;

public abstract class SQLiteContentProvider extends ContentProvider
  implements SQLiteTransactionListener
{
  private final ThreadLocal<Boolean> mApplyingBatch = new ThreadLocal();
  protected SQLiteDatabase mDb;
  private volatile boolean mNotifyChange;
  private SQLiteOpenHelper mOpenHelper;

  private boolean applyingBatch()
  {
    return (mApplyingBatch.get() != null) && (((Boolean)mApplyingBatch.get()).booleanValue());
  }

  public ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> paramArrayList)
    throws OperationApplicationException
  {
    int j = 0;
    int i = 0;
    mDb = mOpenHelper.getWritableDatabase();
    mDb.beginTransactionWithListener(this);
    ContentProviderResult[] arrayOfContentProviderResult;
    while (true)
    {
      int k;
      int n;
      try
      {
        mApplyingBatch.set(Boolean.valueOf(true));
        int i1 = paramArrayList.size();
        arrayOfContentProviderResult = new ContentProviderResult[i1];
        k = 0;
        if (k >= i1)
          break;
        n = i + 1;
        if (n > getMaxOperationsPerYield())
          throw new OperationApplicationException("Too many content provider operations between yield points. The maximum number of operations per yield point is 500", j);
      }
      finally
      {
        mApplyingBatch.set(Boolean.valueOf(false));
        mDb.endTransaction();
        onEndTransaction();
      }
      ContentProviderOperation localContentProviderOperation = (ContentProviderOperation)paramArrayList.get(k);
      i = n;
      int m = j;
      if (k > 0)
      {
        i = n;
        m = j;
        if (localContentProviderOperation.isYieldAllowed())
        {
          n = 0;
          boolean bool = mNotifyChange;
          i = n;
          m = j;
          if (mDb.yieldIfContendedSafely(4000L))
          {
            mDb = mOpenHelper.getWritableDatabase();
            mNotifyChange = bool;
            m = j + 1;
            i = n;
          }
        }
      }
      arrayOfContentProviderResult[k] = localContentProviderOperation.apply(this, arrayOfContentProviderResult, k);
      k += 1;
      j = m;
    }
    mDb.setTransactionSuccessful();
    mApplyingBatch.set(Boolean.valueOf(false));
    mDb.endTransaction();
    onEndTransaction();
    return arrayOfContentProviderResult;
  }

  protected void beforeTransactionCommit()
  {
  }

  public int bulkInsert(Uri paramUri, ContentValues[] paramArrayOfContentValues)
  {
    int j = paramArrayOfContentValues.length;
    mDb = mOpenHelper.getWritableDatabase();
    mDb.beginTransactionWithListener(this);
    int i = 0;
    while (true)
    {
      if (i < j);
      try
      {
        if (insertInTransaction(paramUri, paramArrayOfContentValues[i]) != null)
          mNotifyChange = true;
        boolean bool = mNotifyChange;
        SQLiteDatabase localSQLiteDatabase = mDb;
        mDb.yieldIfContendedSafely();
        mDb = localSQLiteDatabase;
        mNotifyChange = bool;
        i += 1;
        continue;
        mDb.setTransactionSuccessful();
        mDb.endTransaction();
        onEndTransaction();
        return j;
      }
      finally
      {
        mDb.endTransaction();
      }
    }
    throw paramUri;
  }

  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    if (!applyingBatch())
    {
      mDb = mOpenHelper.getWritableDatabase();
      mDb.beginTransactionWithListener(this);
    }
    int j;
    do
    {
      try
      {
        i = deleteInTransaction(paramUri, paramString, paramArrayOfString);
        if (i > 0)
          mNotifyChange = true;
        mDb.setTransactionSuccessful();
        mDb.endTransaction();
        onEndTransaction();
        return i;
      }
      finally
      {
        mDb.endTransaction();
      }
      j = deleteInTransaction(paramUri, paramString, paramArrayOfString);
      int i = j;
    }
    while (j <= 0);
    mNotifyChange = true;
    return j;
  }

  protected abstract int deleteInTransaction(Uri paramUri, String paramString, String[] paramArrayOfString);

  protected abstract SQLiteOpenHelper getDatabaseHelper(Context paramContext);

  public int getMaxOperationsPerYield()
  {
    return 500;
  }

  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    if (!applyingBatch())
    {
      mDb = mOpenHelper.getWritableDatabase();
      mDb.beginTransactionWithListener(this);
    }
    do
    {
      try
      {
        paramUri = insertInTransaction(paramUri, paramContentValues);
        if (paramUri != null)
          mNotifyChange = true;
        mDb.setTransactionSuccessful();
        mDb.endTransaction();
        onEndTransaction();
        return paramUri;
      }
      finally
      {
        mDb.endTransaction();
      }
      paramContentValues = insertInTransaction(paramUri, paramContentValues);
      paramUri = paramContentValues;
    }
    while (paramContentValues == null);
    mNotifyChange = true;
    return paramContentValues;
  }

  protected abstract Uri insertInTransaction(Uri paramUri, ContentValues paramContentValues);

  protected abstract void notifyChange();

  public void onBegin()
  {
    onBeginTransaction();
  }

  protected void onBeginTransaction()
  {
  }

  public void onCommit()
  {
    beforeTransactionCommit();
  }

  public boolean onCreate()
  {
    mOpenHelper = getDatabaseHelper(getContext());
    return true;
  }

  protected void onEndTransaction()
  {
    if (mNotifyChange)
    {
      mNotifyChange = false;
      notifyChange();
    }
  }

  public void onRollback()
  {
  }

  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    if (!applyingBatch())
    {
      mDb = mOpenHelper.getWritableDatabase();
      mDb.beginTransactionWithListener(this);
    }
    int j;
    do
    {
      try
      {
        i = updateInTransaction(paramUri, paramContentValues, paramString, paramArrayOfString);
        if (i > 0)
          mNotifyChange = true;
        mDb.setTransactionSuccessful();
        mDb.endTransaction();
        onEndTransaction();
        return i;
      }
      finally
      {
        mDb.endTransaction();
      }
      j = updateInTransaction(paramUri, paramContentValues, paramString, paramArrayOfString);
      int i = j;
    }
    while (j <= 0);
    mNotifyChange = true;
    return j;
  }

  protected abstract int updateInTransaction(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString);
}
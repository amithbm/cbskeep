package com.google.android.keep.provider;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Binder;
import android.os.Process;
import android.util.Log;
import com.android.common.content.SQLiteContentProvider;
import java.io.FileNotFoundException;

public class KeepPublicProvider extends SQLiteContentProvider
{
  private static final UriMatcher CM = new UriMatcher(-1);
  private static final AutoRevocablePermissions Df = new AutoRevocablePermissions(new c.a());

  static
  {
    CM.addURI("com.google.android.keeppublic", "blob", 100);
  }

  private static final Uri aB(String paramString)
  {
    return Df.aB(paramString);
  }

  public static final Uri d(Uri paramUri, long paramLong)
  {
    if (Binder.getCallingPid() != Process.myPid())
      throw new IllegalStateException("Cannot grant permission from another process.");
    paramUri = Df.b(paramUri, paramLong);
    return j.De.buildUpon().appendQueryParameter("t", paramUri).build();
  }

  public static final Uri r(Uri paramUri)
  {
    return d(paramUri, 300000L);
  }

  protected int deleteInTransaction(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    throw new UnsupportedOperationException("Deletion is not supported.");
  }

  protected SQLiteOpenHelper getDatabaseHelper(Context paramContext)
  {
    return null;
  }

  public String getType(Uri paramUri)
  {
    int i = CM.match(paramUri);
    switch (i)
    {
    default:
      throw new IllegalStateException("Unknown URI " + paramUri + " with match " + i);
    case 100:
    }
    paramUri = aB(paramUri.getQueryParameter("t"));
    if (paramUri == null)
      return null;
    long l = Binder.clearCallingIdentity();
    try
    {
      paramUri = getContext().getContentResolver().getType(paramUri);
      return paramUri;
    }
    finally
    {
      Binder.restoreCallingIdentity(l);
    }
    throw paramUri;
  }

  protected Uri insertInTransaction(Uri paramUri, ContentValues paramContentValues)
  {
    throw new UnsupportedOperationException("Insertion is not supported.");
  }

  protected void notifyChange()
  {
  }

  public AssetFileDescriptor openAssetFile(Uri paramUri, String paramString)
  {
    switch (CM.match(paramUri))
    {
    default:
      throw new IllegalArgumentException("Cannot query unknown URI " + paramUri);
    case 100:
    }
    paramUri = aB(paramUri.getQueryParameter("t"));
    if (paramUri == null)
      return null;
    long l = Binder.clearCallingIdentity();
    try
    {
      paramUri = getContext().getContentResolver().openAssetFileDescriptor(paramUri, paramString);
      return paramUri;
    }
    catch (FileNotFoundException paramUri)
    {
      Log.e("Keep", "File not found");
      return null;
    }
    finally
    {
      Binder.restoreCallingIdentity(l);
    }
    throw paramUri;
  }

  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    switch (CM.match(paramUri))
    {
    default:
      throw new IllegalArgumentException("Cannot query unknown URI " + paramUri);
    case 100:
    }
    paramUri = aB(paramUri.getQueryParameter("t"));
    if (paramUri == null)
      return null;
    long l = Binder.clearCallingIdentity();
    try
    {
      paramUri = getContext().getContentResolver().query(paramUri, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2);
      return paramUri;
    }
    finally
    {
      Binder.restoreCallingIdentity(l);
    }
    throw paramUri;
  }

  protected int updateInTransaction(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    throw new UnsupportedOperationException("Update is not supported.");
  }
}
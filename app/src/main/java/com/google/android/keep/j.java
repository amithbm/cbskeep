package com.google.android.keep;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore.Images.Media;
import android.util.Log;
import java.io.File;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class j
{
  private static ContentValues a(Context paramContext, Uri paramUri, File paramFile, long paramLong)
  {
    ContentValues localContentValues = new ContentValues();
    paramLong /= 1000L;
    localContentValues.put("title", paramFile.getName());
    localContentValues.put("_display_name", paramFile.getName());
    localContentValues.put("mime_type", "image/jpeg");
    localContentValues.put("datetaken", Long.valueOf(paramLong));
    localContentValues.put("date_modified", Long.valueOf(paramLong));
    localContentValues.put("date_added", Long.valueOf(paramLong));
    localContentValues.put("orientation", Integer.valueOf(0));
    localContentValues.put("_data", paramFile.getAbsolutePath());
    localContentValues.put("_size", Long.valueOf(paramFile.length()));
    paramFile = new a()
    {
      public void f(Cursor paramAnonymousCursor)
      {
        rg.put("datetaken", Long.valueOf(paramAnonymousCursor.getLong(0)));
        double d1 = paramAnonymousCursor.getDouble(1);
        double d2 = paramAnonymousCursor.getDouble(2);
        if ((d1 != 0.0D) || (d2 != 0.0D))
        {
          rg.put("latitude", Double.valueOf(d1));
          rg.put("longitude", Double.valueOf(d2));
        }
      }
    };
    a(paramContext, paramUri, new String[] { "datetaken", "latitude", "longitude" }, paramFile);
    return localContentValues;
  }

  public static Uri a(Context paramContext, Uri paramUri, File paramFile, long paramLong, boolean paramBoolean)
  {
    File localFile = h(paramContext, paramUri);
    ContentValues localContentValues = a(paramContext, paramUri, paramFile, paramLong);
    paramFile = paramUri;
    if ((e(paramUri)) || (localFile == null) || (!paramBoolean))
      paramContext = paramContext.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, localContentValues);
    do
    {
      return paramContext;
      paramContext.getContentResolver().update(paramUri, localContentValues, null, null);
      paramContext = paramFile;
    }
    while (!localFile.exists());
    localFile.delete();
    return paramFile;
  }

  private static void a(ContentResolver paramContentResolver, Uri paramUri, String[] paramArrayOfString, a parama)
  {
    ContentResolver localContentResolver2 = null;
    ContentResolver localContentResolver1 = null;
    try
    {
      paramContentResolver = paramContentResolver.query(paramUri, paramArrayOfString, null, null, null);
      if (paramContentResolver != null)
      {
        localContentResolver1 = paramContentResolver;
        localContentResolver2 = paramContentResolver;
        if (paramContentResolver.moveToNext())
        {
          localContentResolver1 = paramContentResolver;
          localContentResolver2 = paramContentResolver;
          parama.f(paramContentResolver);
        }
      }
      return;
    }
    catch (Exception paramContentResolver)
    {
      return;
    }
    finally
    {
      if (localContentResolver2 != null)
        localContentResolver2.close();
    }
    throw paramContentResolver;
  }

  public static void a(Context paramContext, Uri paramUri, String[] paramArrayOfString, a parama)
  {
    a(paramContext.getContentResolver(), paramUri, paramArrayOfString, parama);
  }

  public static File e(Context paramContext, Uri paramUri)
  {
    paramUri = g(paramContext, paramUri);
    if (paramUri != null)
    {
      paramContext = paramUri;
      if (paramUri.canWrite());
    }
    else
    {
      paramContext = new File(Environment.getExternalStorageDirectory(), "EditedOnlinePhotos");
    }
    if (!paramContext.exists())
      paramContext.mkdirs();
    return paramContext;
  }

  private static boolean e(Uri paramUri)
  {
    paramUri = paramUri.getScheme();
    return (paramUri != null) && (paramUri.equals("file"));
  }

  public static Uri f(Context paramContext, Uri paramUri)
  {
    long l = System.currentTimeMillis();
    String str = new SimpleDateFormat("_yyyyMMdd_HHmmss").format(new Date(l));
    return a(paramContext, paramUri, new File(e(paramContext, paramUri), str + ".JPG"), l, false);
  }

  private static File g(Context paramContext, Uri paramUri)
  {
    paramContext = h(paramContext, paramUri);
    if (paramContext != null)
      return paramContext.getParentFile();
    return null;
  }

  private static File h(Context paramContext, Uri paramUri)
  {
    if (paramUri == null)
    {
      Log.e("SaveImage", "srcUri is null.");
      return null;
    }
    Object localObject = paramUri.getScheme();
    if (localObject == null)
    {
      Log.e("SaveImage", "scheme is null.");
      return null;
    }
    File[] arrayOfFile = new File[1];
    if (((String)localObject).equals("content"))
      if (paramUri.getAuthority().equals("media"))
      {
        localObject = new a()
        {
          public void f(Cursor paramAnonymousCursor)
          {
            rf[0] = new File(paramAnonymousCursor.getString(0));
          }
        };
        a(paramContext, paramUri, new String[] { "_data" }, (a)localObject);
      }
    while (true)
    {
      return arrayOfFile[0];
      if (((String)localObject).equals("file"))
        arrayOfFile[0] = new File(paramUri.getPath());
    }
  }

  public static abstract interface a
  {
    public abstract void f(Cursor paramCursor);
  }
}
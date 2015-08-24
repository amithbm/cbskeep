package com.android.ex.chips;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v4.util.LruCache;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class DefaultPhotoManager
  implements PhotoManager
{
  private final ContentResolver mContentResolver;
  private final LruCache<Uri, byte[]> mPhotoCacheMap;

  public DefaultPhotoManager(ContentResolver paramContentResolver)
  {
    mContentResolver = paramContentResolver;
    mPhotoCacheMap = new LruCache(20);
  }

  private void fetchPhotoAsync(final RecipientEntry paramRecipientEntry, final Uri paramUri, final PhotoManager.PhotoManagerCallback paramPhotoManagerCallback)
  {
    new AsyncTask()
    {
      protected byte[] doInBackground(Void[] paramAnonymousArrayOfVoid)
      {
        paramAnonymousArrayOfVoid = null;
        Object localObject = mContentResolver.query(paramUri, DefaultPhotoManager.PhotoQuery.PROJECTION, null, null, null);
        if (localObject != null);
        while (true)
        {
          try
          {
            if (((Cursor)localObject).moveToFirst())
            {
              paramAnonymousArrayOfVoid = ((Cursor)localObject).getBlob(0);
              return paramAnonymousArrayOfVoid;
            }
            return null;
          }
          finally
          {
            ((Cursor)localObject).close();
          }
          try
          {
            localObject = mContentResolver.openInputStream(paramUri);
            if (localObject != null)
            {
              paramAnonymousArrayOfVoid = new byte[16384];
              ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
              try
              {
                while (true)
                {
                  int i = ((InputStream)localObject).read(paramAnonymousArrayOfVoid);
                  if (i == -1)
                    break;
                  localByteArrayOutputStream.write(paramAnonymousArrayOfVoid, 0, i);
                }
              }
              finally
              {
                ((InputStream)localObject).close();
              }
              ((InputStream)localObject).close();
              paramAnonymousArrayOfVoid = localByteArrayOutputStream.toByteArray();
              return paramAnonymousArrayOfVoid;
            }
          }
          catch (IOException paramAnonymousArrayOfVoid)
          {
          }
        }
        return null;
      }

      protected void onPostExecute(byte[] paramAnonymousArrayOfByte)
      {
        paramRecipientEntry.setPhotoBytes(paramAnonymousArrayOfByte);
        if (paramAnonymousArrayOfByte != null)
        {
          mPhotoCacheMap.put(paramUri, paramAnonymousArrayOfByte);
          if (paramPhotoManagerCallback != null)
            paramPhotoManagerCallback.onPhotoBytesAsynchronouslyPopulated();
        }
        while (paramPhotoManagerCallback == null)
          return;
        paramPhotoManagerCallback.onPhotoBytesAsyncLoadFailed();
      }
    }
    .executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
  }

  public void populatePhotoBytesAsync(RecipientEntry paramRecipientEntry, PhotoManager.PhotoManagerCallback paramPhotoManagerCallback)
  {
    Uri localUri = paramRecipientEntry.getPhotoThumbnailUri();
    if (localUri != null)
    {
      arrayOfByte = (byte[])mPhotoCacheMap.get(localUri);
      if (arrayOfByte != null)
      {
        paramRecipientEntry.setPhotoBytes(arrayOfByte);
        if (paramPhotoManagerCallback != null)
          paramPhotoManagerCallback.onPhotoBytesPopulated();
      }
    }
    while (paramPhotoManagerCallback == null)
    {
      byte[] arrayOfByte;
      return;
      fetchPhotoAsync(paramRecipientEntry, localUri, paramPhotoManagerCallback);
      return;
    }
    paramPhotoManagerCallback.onPhotoBytesAsyncLoadFailed();
  }

  private static class PhotoQuery
  {
    public static final String[] PROJECTION = { "data15" };
  }
}
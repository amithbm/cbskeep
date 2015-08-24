package com.google.android.keep;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.LruCache;
import com.google.android.keep.provider.g;

public class w
{
  private static w sK;
  private final LruCache<Uri, Bitmap> sJ;

  private w(Context paramContext)
  {
    sJ = new LruCache(1048576 * ((ActivityManager)paramContext.getSystemService("activity")).getMemoryClass() / 8)
    {
      protected int b(Uri paramAnonymousUri, Bitmap paramAnonymousBitmap)
      {
        return paramAnonymousBitmap.getByteCount();
      }
    };
  }

  public static w fU()
  {
    return sK;
  }

  public static void init(Context paramContext)
  {
    if (sK == null)
      sK = new w(paramContext.getApplicationContext());
  }

  public void a(Uri paramUri, Bitmap paramBitmap)
  {
    if ((sJ.get(paramUri) == null) && (paramBitmap != null))
      sJ.put(paramUri, paramBitmap);
  }

  public Bitmap f(Uri paramUri)
  {
    return (Bitmap)sJ.get(paramUri);
  }

  public Bitmap i(Context paramContext, Uri paramUri)
  {
    Bitmap localBitmap = f(paramUri);
    if (localBitmap != null)
      return localBitmap;
    paramContext = g.c(paramContext.getContentResolver(), paramUri);
    if (paramContext != null)
      sJ.put(paramUri, paramContext);
    return paramContext;
  }
}
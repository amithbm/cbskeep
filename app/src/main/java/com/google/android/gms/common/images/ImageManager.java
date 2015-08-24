package com.google.android.gms.common.images;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.internal.zzlt;
import com.google.android.gms.internal.zzme;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

public final class ImageManager
{
  private static HashSet<Uri> zzajA = new HashSet();
  private static final Object zzajz = new Object();
  private final Context mContext;
  private final Handler mHandler;
  private final ExecutorService zzajD;
  private final zzb zzajE;
  private final zzlt zzajF;
  private final Map<zza, ImageReceiver> zzajG;
  private final Map<Uri, ImageReceiver> zzajH;
  private final Map<Uri, Long> zzajI;

  private final class ImageReceiver extends ResultReceiver
  {
    private final Uri mUri;
    private final ArrayList<zza> zzajJ;

    public void onReceiveResult(int paramInt, Bundle paramBundle)
    {
      paramBundle = (ParcelFileDescriptor)paramBundle.getParcelable("com.google.android.gms.extra.fileDescriptor");
      ImageManager.zzf(zzajK).execute(new ImageManager.zzc(zzajK, mUri, paramBundle));
    }
  }

  public static abstract interface OnImageLoadedListener
  {
    public abstract void onImageLoaded(Uri paramUri, Drawable paramDrawable, boolean paramBoolean);
  }

  private static final class zzb extends zzme<zza.zza, Bitmap>
  {
    protected int zza(zza.zza paramzza, Bitmap paramBitmap)
    {
      return paramBitmap.getHeight() * paramBitmap.getRowBytes();
    }

    protected void zza(boolean paramBoolean, zza.zza paramzza, Bitmap paramBitmap1, Bitmap paramBitmap2)
    {
      super.entryRemoved(paramBoolean, paramzza, paramBitmap1, paramBitmap2);
    }
  }

  private final class zzc
    implements Runnable
  {
    private final Uri mUri;
    private final ParcelFileDescriptor zzajL;

    public zzc(Uri paramParcelFileDescriptor, ParcelFileDescriptor arg3)
    {
      mUri = paramParcelFileDescriptor;
      Object localObject;
      zzajL = localObject;
    }

    public void run()
    {
      zzb.zzbU("LoadBitmapFromDiskRunnable can't be executed in the main thread");
      boolean bool1 = false;
      boolean bool2 = false;
      Bitmap localBitmap = null;
      CountDownLatch localCountDownLatch = null;
      if (zzajL != null);
      try
      {
        localBitmap = BitmapFactory.decodeFileDescriptor(zzajL.getFileDescriptor());
        bool1 = bool2;
      }
      catch (OutOfMemoryError localIOException)
      {
        try
        {
          zzajL.close();
          localCountDownLatch = new CountDownLatch(1);
          ImageManager.zzg(ImageManager.this).post(new ImageManager.zzf(ImageManager.this, mUri, localBitmap, bool1, localCountDownLatch));
        }
        catch (IOException localIOException)
        {
          try
          {
            while (true)
            {
              localCountDownLatch.await();
              return;
              localOutOfMemoryError = localOutOfMemoryError;
              Log.e("ImageManager", "OOM while loading bitmap for uri: " + mUri, localOutOfMemoryError);
              bool1 = true;
              Object localObject = localCountDownLatch;
            }
            localIOException = localIOException;
            Log.e("ImageManager", "closed failed", localIOException);
          }
          catch (InterruptedException localInterruptedException)
          {
            Log.w("ImageManager", "Latch interrupted while posting " + mUri);
          }
        }
      }
    }
  }

  private final class zzf
    implements Runnable
  {
    private final Bitmap mBitmap;
    private final Uri mUri;
    private boolean zzajN;
    private final CountDownLatch zzpi;

    public zzf(Uri paramBitmap, Bitmap paramBoolean, boolean paramCountDownLatch, CountDownLatch arg5)
    {
      mUri = paramBitmap;
      mBitmap = paramBoolean;
      zzajN = paramCountDownLatch;
      Object localObject;
      zzpi = localObject;
    }

    private void zza(ImageManager.ImageReceiver paramImageReceiver, boolean paramBoolean)
    {
      paramImageReceiver = ImageManager.ImageReceiver.zza(paramImageReceiver);
      int j = paramImageReceiver.size();
      int i = 0;
      if (i < j)
      {
        zza localzza = (zza)paramImageReceiver.get(i);
        if (paramBoolean)
          localzza.zza(ImageManager.zzb(ImageManager.this), mBitmap, false);
        while (true)
        {
          if (!(localzza instanceof zza.zzc))
            ImageManager.zza(ImageManager.this).remove(localzza);
          i += 1;
          break;
          ImageManager.zzd(ImageManager.this).put(mUri, Long.valueOf(SystemClock.elapsedRealtime()));
          localzza.zza(ImageManager.zzb(ImageManager.this), ImageManager.zzc(ImageManager.this), false);
        }
      }
    }

    public void run()
    {
      zzb.zzbT("OnBitmapLoadedRunnable must be executed in the main thread");
      boolean bool;
      if (mBitmap != null)
        bool = true;
      while (ImageManager.zzh(ImageManager.this) != null)
        if (zzajN)
        {
          ImageManager.zzh(ImageManager.this).evictAll();
          System.gc();
          zzajN = false;
          ImageManager.zzg(ImageManager.this).post(this);
          return;
          bool = false;
        }
        else if (bool)
        {
          ImageManager.zzh(ImageManager.this).put(new zza.zza(mUri), mBitmap);
        }
      ??? = (ImageManager.ImageReceiver)ImageManager.zze(ImageManager.this).remove(mUri);
      if (??? != null)
        zza((ImageManager.ImageReceiver)???, bool);
      zzpi.countDown();
      synchronized (ImageManager.zzpo())
      {
        ImageManager.zzpp().remove(mUri);
        return;
      }
    }
  }
}
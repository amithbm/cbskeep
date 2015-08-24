package com.google.android.gms.location.places.internal;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.internal.zzv;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class zzq
{
  private static final String TAG = zzq.class.getSimpleName();
  private static final long zzaVH = TimeUnit.SECONDS.toMillis(1L);
  private static zzq zzaVI;
  private final Context mContext;
  private final Handler mHandler;
  private final Runnable zzaVJ = new zza(null);
  private ArrayList<String> zzaVK = null;
  private ArrayList<String> zzaVL = null;
  private final Object zzqY = new Object();

  private zzq(Context paramContext)
  {
    this((Context)zzv.zzz(paramContext), new Handler(Looper.getMainLooper()));
  }

  zzq(Context paramContext, Handler paramHandler)
  {
    mContext = paramContext;
    mHandler = paramHandler;
  }

  public static zzq zzaD(Context paramContext)
  {
    try
    {
      zzv.zzz(paramContext);
      int i = Build.VERSION.SDK_INT;
      if (i < 14);
      for (paramContext = null; ; paramContext = zzaVI)
      {
        return paramContext;
        if (zzaVI == null)
          zzaVI = new zzq(paramContext.getApplicationContext());
      }
    }
    finally
    {
    }
    throw paramContext;
  }

  public void log(String paramString1, String paramString2)
  {
    synchronized (zzqY)
    {
      if (zzaVK == null)
      {
        zzaVK = new ArrayList();
        zzaVL = new ArrayList();
        mHandler.postDelayed(zzaVJ, zzaVH);
      }
      zzaVK.add(paramString1);
      zzaVL.add(paramString2);
      if (zzaVK.size() >= 10000)
      {
        if (Log.isLoggable(TAG, 5))
          Log.w(TAG, "Event buffer full, flushing");
        zzaVJ.run();
        mHandler.removeCallbacks(zzaVJ);
        return;
      }
      return;
    }
  }

  private class zza
    implements Runnable
  {
    private zza()
    {
    }

    public void run()
    {
      synchronized (zzq.zzb(zzq.this))
      {
        Intent localIntent = new Intent("com.google.android.location.places.METHOD_CALL");
        localIntent.setPackage("com.google.android.gms");
        localIntent.putStringArrayListExtra("PLACE_IDS", zzq.zzc(zzq.this));
        localIntent.putStringArrayListExtra("METHOD_NAMES", zzq.zzd(zzq.this));
        zzq.zze(zzq.this).sendBroadcast(localIntent);
        zzq.zza(zzq.this, null);
        zzq.zzb(zzq.this, null);
        return;
      }
    }
  }
}
package com.google.android.gms.drive.realtime.internal;

import android.os.Handler;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.internal.zzx;
import java.util.Locale;

public class zzaj extends zzs.zza
{
  private final Handler mHandler;
  private final zzt zzazp;
  private final zzag zzazq;

  public zzaj(zzt paramzzt, zzag paramzzag, Handler paramHandler)
  {
    zzazp = paramzzt;
    zzazq = paramzzag;
    mHandler = paramHandler;
  }

  public void zzQ(Status paramStatus)
    throws RemoteException
  {
  }

  public void zzhL(int paramInt)
    throws RemoteException
  {
    mHandler.post(new Runnable()
    {
      public void run()
      {
        try
        {
          zzab localzzab = new zzab(zzaj.zza(zzaj.this).zztM());
          long l1 = System.currentTimeMillis();
          zzaj.zzb(zzaj.this).zza(0, localzzab);
          long l2 = System.currentTimeMillis();
          zzaj.zza(zzaj.this).zzb(localzzab.zztI());
          long l3 = System.currentTimeMillis();
          zzx.zzB("RealtimeChangeCallback", String.format(Locale.US, "Applied remote changes (apply: %d ms; events: %d ms; total: %d ms)", new Object[] { Long.valueOf(l2 - l1), Long.valueOf(l3 - l2), Long.valueOf(l3 - l1) }));
          return;
        }
        catch (Exception localException)
        {
          zzx.zzb("RealtimeChangeCallback", localException, "Exception while applying remote change.");
        }
      }
    });
  }
}
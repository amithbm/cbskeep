package com.google.android.gms.common.api;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.internal.zzv;

public final class zzi<L>
{
  private volatile L mListener;
  private final zzi<L>.zza zzaie;

  zzi(Looper paramLooper, L paramL)
  {
    zzaie = new zza(paramLooper);
    mListener = zzv.zzb(paramL, "Listener must not be null");
  }

  public void clear()
  {
    mListener = null;
  }

  public void zza(zzb<? super L> paramzzb)
  {
    zzv.zzb(paramzzb, "Notifier must not be null");
    paramzzb = zzaie.obtainMessage(1, paramzzb);
    zzaie.sendMessage(paramzzb);
  }

  void zzb(zzb<? super L> paramzzb)
  {
    Object localObject = mListener;
    if (localObject == null)
    {
      paramzzb.zzoy();
      return;
    }
    try
    {
      paramzzb.zzr(localObject);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      paramzzb.zzoy();
      throw localRuntimeException;
    }
  }

  private final class zza extends Handler
  {
    public zza(Looper arg2)
    {
      super();
    }

    public void handleMessage(Message paramMessage)
    {
      boolean bool = true;
      if (paramMessage.what == 1);
      while (true)
      {
        zzv.zzS(bool);
        zzb((zzi.zzb)paramMessage.obj);
        return;
        bool = false;
      }
    }
  }

  public static abstract interface zzb<L>
  {
    public abstract void zzoy();

    public abstract void zzr(L paramL);
  }
}
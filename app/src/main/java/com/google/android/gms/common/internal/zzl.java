package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;

public abstract class zzl
{
  private static final Object zzalO = new Object();
  private static zzl zzalP;

  public static zzl zzal(Context paramContext)
  {
    synchronized (zzalO)
    {
      if (zzalP == null)
        zzalP = new zzm(paramContext.getApplicationContext());
      return zzalP;
    }
  }

  public abstract boolean zza(ComponentName paramComponentName, ServiceConnection paramServiceConnection, String paramString);

  public abstract boolean zza(String paramString1, ServiceConnection paramServiceConnection, String paramString2);

  public abstract void zzb(ComponentName paramComponentName, ServiceConnection paramServiceConnection, String paramString);

  public abstract void zzb(String paramString1, ServiceConnection paramServiceConnection, String paramString2);
}
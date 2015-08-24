package com.google.android.gms.nearby.sharing.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza.zzb;

final class zzg extends zzd.zza
{
  private final zza.zzb<Status> zzbbn;

  private zzg(zza.zzb<Status> paramzzb)
  {
    zzbbn = paramzzb;
  }

  public static zzg zzr(zza.zzb<Status> paramzzb)
  {
    return new zzg(paramzzb);
  }

  public void zzl(Status paramStatus)
    throws RemoteException
  {
    zzbbn.zzq(paramStatus);
  }
}
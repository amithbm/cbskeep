package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza.zzb;

public class zzbq extends zzd
{
  private final zza.zzb<Status> zzPu;

  public zzbq(zza.zzb<Status> paramzzb)
  {
    zzPu = paramzzb;
  }

  public void onSuccess()
    throws RemoteException
  {
    zzPu.zzq(Status.zzaii);
  }

  public void zzQ(Status paramStatus)
    throws RemoteException
  {
    zzPu.zzq(paramStatus);
  }
}
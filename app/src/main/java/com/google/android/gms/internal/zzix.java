package com.google.android.gms.internal;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.appdatasearch.GetRecentContextCall.Response;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza.zzb;

public abstract class zzix<T> extends zziw.zza
{
  protected zza.zzb<T> zzOF;

  public zzix(zza.zzb<T> paramzzb)
  {
    zzOF = paramzzb;
  }

  public void zza(GetRecentContextCall.Response paramResponse)
  {
  }

  public void zza(Status paramStatus, ParcelFileDescriptor paramParcelFileDescriptor)
  {
  }

  public void zza(Status paramStatus, boolean paramBoolean)
  {
  }

  public void zzb(Status paramStatus)
  {
  }
}
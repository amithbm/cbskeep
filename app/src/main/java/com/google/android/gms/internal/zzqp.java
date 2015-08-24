package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;

public class zzqp extends zzj<zzqu>
{
  public zzqp(Context paramContext, Looper paramLooper, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, zzf paramzzf)
  {
    super(paramContext, paramLooper, 69, paramConnectionCallbacks, paramOnConnectionFailedListener, paramzzf);
  }

  protected String getServiceDescriptor()
  {
    return "com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService";
  }

  protected String getStartServiceAction()
  {
    return "com.google.android.gms.nearby.bootstrap.service.NearbyBootstrapService.START";
  }

  protected zzqu zzfe(IBinder paramIBinder)
  {
    return zzqu.zza.zzfi(paramIBinder);
  }
}
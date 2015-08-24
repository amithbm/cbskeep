package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;

public class zzaj<T extends IInterface> extends zzj<T>
{
  private final Api.zzb<T> zzamj;

  public zzaj(Context paramContext, Looper paramLooper, int paramInt, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, zzf paramzzf, Api.zzb paramzzb)
  {
    super(paramContext, paramLooper, paramInt, paramConnectionCallbacks, paramOnConnectionFailedListener, paramzzf);
    zzamj = paramzzb;
  }

  protected String getServiceDescriptor()
  {
    return zzamj.getServiceDescriptor();
  }

  protected String getStartServiceAction()
  {
    return zzamj.getStartServiceAction();
  }

  protected T zzX(IBinder paramIBinder)
  {
    return zzamj.zzX(paramIBinder);
  }
}
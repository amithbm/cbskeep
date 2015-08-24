package com.google.android.gms.internal;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzj;

public class zziy extends zzj<zziv>
{
  public zziy(Context paramContext, Looper paramLooper, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, 19, paramConnectionCallbacks, paramOnConnectionFailedListener);
  }

  protected String getServiceDescriptor()
  {
    return "com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch";
  }

  protected String getStartServiceAction()
  {
    return "com.google.android.gms.icing.LIGHTWEIGHT_INDEX_SERVICE";
  }

  protected zziv zzaj(IBinder paramIBinder)
  {
    return zziv.zza.zzah(paramIBinder);
  }

  public zziv zzkD()
    throws DeadObjectException
  {
    return (zziv)zzpN();
  }
}
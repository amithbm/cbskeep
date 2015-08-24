package com.google.android.gms.googlehelp.internal.common;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzj;

public class zzc extends zzj<zzf>
{
  public zzc(Context paramContext, Looper paramLooper, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, 63, paramConnectionCallbacks, paramOnConnectionFailedListener);
  }

  protected String getServiceDescriptor()
  {
    return "com.google.android.gms.googlehelp.internal.common.IGoogleHelpService";
  }

  protected String getStartServiceAction()
  {
    return "com.google.android.gms.googlehelp.service.GoogleHelpService.START";
  }

  protected zzf zzdA(IBinder paramIBinder)
  {
    return zzf.zza.zzdB(paramIBinder);
  }
}
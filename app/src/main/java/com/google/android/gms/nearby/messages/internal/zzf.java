package com.google.android.gms.nearby.messages.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.nearby.messages.MessagesOptions;

class zzf extends zzj<zzc>
{
  private String zzOZ;
  private String zzaSa;

  zzf(Context paramContext, Looper paramLooper, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, com.google.android.gms.common.internal.zzf paramzzf, MessagesOptions paramMessagesOptions)
  {
    super(paramContext, paramLooper, 62, paramConnectionCallbacks, paramOnConnectionFailedListener, paramzzf);
    zzOZ = paramzzf.zzpA();
    if (paramMessagesOptions != null)
      zzaSa = paramMessagesOptions.zeroPartyPackageName;
  }

  protected String getServiceDescriptor()
  {
    return "com.google.android.gms.nearby.messages.internal.INearbyMessagesService";
  }

  protected String getStartServiceAction()
  {
    return "com.google.android.gms.nearby.messages.service.NearbyMessagesService.START";
  }

  public boolean requiresAccount()
  {
    return true;
  }

  protected zzc zzfq(IBinder paramIBinder)
  {
    return zzc.zza.zzfp(paramIBinder);
  }
}
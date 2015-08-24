package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzj;

public final class zzqx extends zzj<zzra>
{
  private final long zzaGH = hashCode();

  public zzqx(Context paramContext, Looper paramLooper, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, 54, paramConnectionCallbacks, paramOnConnectionFailedListener);
  }

  public void disconnect()
  {
    if (isConnected());
    try
    {
      ((zzra)zzpN()).zzO(zzaGH);
      super.disconnect();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
        Log.w("NearbyConnectionsClient", "Failed to notify client disconnect.", localRemoteException);
    }
  }

  protected String getServiceDescriptor()
  {
    return "com.google.android.gms.nearby.internal.connection.INearbyConnectionService";
  }

  protected String getStartServiceAction()
  {
    return "com.google.android.gms.nearby.connection.service.START";
  }

  protected zzra zzfk(IBinder paramIBinder)
  {
    return zzra.zza.zzfm(paramIBinder);
  }
}
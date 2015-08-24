package com.google.android.gms.nearby.sharing.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Binder;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza.zzb;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.nearby.sharing.ShareCallback;

class zzh extends zzj<zze>
{
  private IBinder zzaSr;

  public zzh(Context paramContext, Looper paramLooper, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, zzf paramzzf)
  {
    super(paramContext, paramLooper, 49, paramConnectionCallbacks, paramOnConnectionFailedListener, paramzzf);
  }

  private IBinder zzkN()
  {
    if (zzaSr == null)
      zzaSr = new Binder();
    return zzaSr;
  }

  protected String getServiceDescriptor()
  {
    return "com.google.android.gms.nearby.sharing.internal.INearbySharingService";
  }

  protected String getStartServiceAction()
  {
    return "com.google.android.gms.nearby.sharing.service.NearbySharingService.START";
  }

  public void zza(zza.zzb<Status> paramzzb, Activity paramActivity)
    throws RemoteException
  {
    zzpM();
    StopProvidingContentRequest localStopProvidingContentRequest = new StopProvidingContentRequest();
    localStopProvidingContentRequest.zzbbI = paramActivity.hashCode();
    localStopProvidingContentRequest.zzbbJ = zzg.zzr(paramzzb);
    ((zze)zzpN()).zza(localStopProvidingContentRequest);
  }

  public void zza(zza.zzb<Status> paramzzb, Activity paramActivity, ShareCallback paramShareCallback)
    throws RemoteException
  {
    zzpM();
    long l = paramActivity.hashCode();
    paramActivity = new zzk(paramShareCallback);
    paramShareCallback = new ProvideContentRequest();
    paramShareCallback.zzbbF = zzkN();
    paramShareCallback.zzbbI = l;
    paramShareCallback.zzbbJ = zzg.zzr(paramzzb);
    paramShareCallback.zzbbG = paramActivity;
    ((zze)zzpN()).zza(paramShareCallback);
  }

  protected zze zzfv(IBinder paramIBinder)
  {
    return zze.zza.zzfu(paramIBinder);
  }
}
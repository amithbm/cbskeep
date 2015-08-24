package com.google.android.gms.nearby.sharing.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.ClientKey;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.nearby.sharing.ShareCallback;
import com.google.android.gms.nearby.sharing.Sharing;

public final class zzl
  implements Sharing
{
  public static final Api.zza<zzh, Api.ApiOptions.NoOptions> CLIENT_BUILDER = new Api.zza()
  {
    public int getPriority()
    {
      return 2147483647;
    }

    public zzh zzG(Context paramAnonymousContext, Looper paramAnonymousLooper, zzf paramAnonymouszzf, Api.ApiOptions.NoOptions paramAnonymousNoOptions, GoogleApiClient.ConnectionCallbacks paramAnonymousConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramAnonymousOnConnectionFailedListener)
    {
      return new zzh(paramAnonymousContext, paramAnonymousLooper, paramAnonymousConnectionCallbacks, paramAnonymousOnConnectionFailedListener, paramAnonymouszzf);
    }
  };
  public static final Api.ClientKey<zzh> CLIENT_KEY = new Api.ClientKey();

  public PendingResult<Status> registerShareCallback(GoogleApiClient paramGoogleApiClient, final Activity paramActivity, final ShareCallback paramShareCallback)
  {
    return paramGoogleApiClient.zza(new zzf.zza(paramGoogleApiClient)
    {
      protected void zza(zzh paramAnonymouszzh)
        throws RemoteException
      {
        paramAnonymouszzh.zza(this, paramActivity, paramShareCallback);
      }
    });
  }

  public PendingResult<Status> unregisterShareCallback(GoogleApiClient paramGoogleApiClient, final Activity paramActivity)
  {
    return paramGoogleApiClient.zza(new zzf.zza(paramGoogleApiClient)
    {
      protected void zza(zzh paramAnonymouszzh)
        throws RemoteException
      {
        paramAnonymouszzh.zza(this, paramActivity);
      }
    });
  }
}
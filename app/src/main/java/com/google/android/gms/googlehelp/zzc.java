package com.google.android.gms.googlehelp;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.ClientKey;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.googlehelp.internal.common.zzb;

public class zzc
{
  public static final Api<Api.ApiOptions.NoOptions> API = new Api("Help.API", CLIENT_BUILDER, CLIENT_KEY, new Scope[0]);
  public static final Api.zza<com.google.android.gms.googlehelp.internal.common.zzc, Api.ApiOptions.NoOptions> CLIENT_BUILDER;
  public static final Api.ClientKey<com.google.android.gms.googlehelp.internal.common.zzc> CLIENT_KEY = new Api.ClientKey();
  public static final zza zzaOB = new zzb();

  static
  {
    CLIENT_BUILDER = new Api.zza()
    {
      public int getPriority()
      {
        return 2147483647;
      }

      public com.google.android.gms.googlehelp.internal.common.zzc zzw(Context paramAnonymousContext, Looper paramAnonymousLooper, zzf paramAnonymouszzf, Api.ApiOptions.NoOptions paramAnonymousNoOptions, GoogleApiClient.ConnectionCallbacks paramAnonymousConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramAnonymousOnConnectionFailedListener)
      {
        return new com.google.android.gms.googlehelp.internal.common.zzc(paramAnonymousContext, paramAnonymousLooper, paramAnonymousConnectionCallbacks, paramAnonymousOnConnectionFailedListener);
      }
    };
  }

  public static void zza(GoogleApiClient paramGoogleApiClient, final zza paramzza)
  {
    new AsyncTask()
    {
      protected Void zzb(Void[] paramAnonymousArrayOfVoid)
      {
        if (zzaOC.blockingConnect().isSuccess())
          paramzza.zzl(zzaOC).setResultCallback(new ResultCallback()
          {
            public void zzu(Status paramAnonymous2Status)
            {
              if (!paramAnonymous2Status.isSuccess())
                zzaOD.zzxJ();
              zzaOC.disconnect();
            }
          });
        while (true)
        {
          return null;
          paramzza.zzxJ();
          zzaOC.disconnect();
        }
      }
    }
    .execute(new Void[0]);
  }

  public static abstract interface zza
  {
    public abstract PendingResult<Status> zzl(GoogleApiClient paramGoogleApiClient);

    public abstract void zzxJ();
  }
}
package com.google.android.gms.reminders;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.ClientKey;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.internal.zztj;
import com.google.android.gms.internal.zztn;

public class Reminders
{
  public static final Api<Api.ApiOptions.NoOptions> API = new Api("Reminders.API", CLIENT_BUILDER, CLIENT_KEY, new Scope[0]);
  private static final Api.zza<zztj, Api.ApiOptions.NoOptions> CLIENT_BUILDER;
  public static final Api.ClientKey<zztj> CLIENT_KEY = new Api.ClientKey();
  public static final RemindersApi RemindersApi = new zztn();

  static
  {
    CLIENT_BUILDER = new Api.zza()
    {
      public int getPriority()
      {
        return 2147483647;
      }

      public zztj zzL(Context paramAnonymousContext, Looper paramAnonymousLooper, zzf paramAnonymouszzf, Api.ApiOptions.NoOptions paramAnonymousNoOptions, GoogleApiClient.ConnectionCallbacks paramAnonymousConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramAnonymousOnConnectionFailedListener)
      {
        return new zztj(paramAnonymousContext, paramAnonymousLooper, paramAnonymouszzf, paramAnonymousConnectionCallbacks, paramAnonymousOnConnectionFailedListener);
      }
    };
  }
}
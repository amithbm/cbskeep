package com.google.android.gms.appdatasearch;

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
import com.google.android.gms.internal.zziy;
import com.google.android.gms.internal.zzja;

public final class AppDataSearch
{
  public static final Api<Api.ApiOptions.NoOptions> LIGHTWEIGHT_API = new Api("AppDataSearch.LIGHTWEIGHT_API", zzMu, LIGHTWEIGHT_CLIENT_KEY, new Scope[0]);
  public static final Api.ClientKey<zziy> LIGHTWEIGHT_CLIENT_KEY = new Api.ClientKey();
  public static final UsageReportingApi UsageReportingApi = new zzja();
  private static final Api.zza<zziy, Api.ApiOptions.NoOptions> zzMu = new Api.zza()
  {
    public int getPriority()
    {
      return 2147483647;
    }

    public zziy zza(Context paramAnonymousContext, Looper paramAnonymousLooper, zzf paramAnonymouszzf, Api.ApiOptions.NoOptions paramAnonymousNoOptions, GoogleApiClient.ConnectionCallbacks paramAnonymousConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramAnonymousOnConnectionFailedListener)
    {
      return new zziy(paramAnonymousContext, paramAnonymousLooper, paramAnonymousConnectionCallbacks, paramAnonymousOnConnectionFailedListener);
    }
  };
}
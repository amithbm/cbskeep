package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzf.zza;
import com.google.android.gms.common.internal.zzv;
import com.google.android.gms.internal.zzve;
import com.google.android.gms.internal.zzvg;
import com.google.android.gms.internal.zzvh;
import com.google.android.gms.internal.zzvh.zza;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public abstract interface GoogleApiClient
{
  public abstract ConnectionResult blockingConnect();

  public abstract ConnectionResult blockingConnect(long paramLong, TimeUnit paramTimeUnit);

  public abstract void connect();

  public abstract void disconnect();

  public abstract void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString);

  public abstract Context getContext();

  public abstract Looper getLooper();

  public abstract boolean isConnected();

  public abstract boolean isConnecting();

  public abstract void registerConnectionCallbacks(ConnectionCallbacks paramConnectionCallbacks);

  public abstract void registerConnectionFailedListener(OnConnectionFailedListener paramOnConnectionFailedListener);

  public abstract void unregisterConnectionCallbacks(ConnectionCallbacks paramConnectionCallbacks);

  public abstract void unregisterConnectionFailedListener(OnConnectionFailedListener paramOnConnectionFailedListener);

  public abstract <C extends Api.Client> C zza(Api.ClientKey<C> paramClientKey);

  public abstract <A extends Api.Client, R extends Result, T extends zza.zza<R, A>> T zza(T paramT);

  public abstract <A extends Api.Client, T extends zza.zza<? extends Result, A>> T zzb(T paramT);

  public abstract <L> zzi<L> zzs(L paramL);

  public static final class Builder
  {
    private final Context mContext;
    private Account zzMF;
    private String zzOY;
    private String zzOZ;
    private final Set<Scope> zzagP = new HashSet();
    private int zzagQ;
    private View zzagR;
    private final Map<Api<?>, zzf.zza> zzagS = new HashMap();
    private final Map<Api<?>, Api.ApiOptions> zzagT = new HashMap();
    private FragmentActivity zzagU;
    private int zzagV = -1;
    private int zzagW = -1;
    private GoogleApiClient.OnConnectionFailedListener zzagX;
    private Api.zza<? extends zzvg, zzvh> zzagY;
    private final Set<GoogleApiClient.ConnectionCallbacks> zzagZ = new HashSet();
    private final Set<GoogleApiClient.OnConnectionFailedListener> zzaha = new HashSet();
    private zzvh.zza zzahb = new zzvh.zza();
    private Looper zznW;

    public Builder(Context paramContext)
    {
      mContext = paramContext;
      zznW = paramContext.getMainLooper();
      zzOZ = paramContext.getPackageName();
      zzOY = paramContext.getClass().getName();
      zzagY = zzve.CLIENT_BUILDER;
    }

    private GoogleApiClient zzoA()
    {
      zzm localzzm = zzm.zza(zzagU);
      zzg localzzg = new zzg(mContext.getApplicationContext(), zznW, zzoz(), zzagY, zzagT, zzagZ, zzaha, zzagV, -1);
      localzzm.zza(zzagV, localzzg, zzagX);
      return localzzg;
    }

    private GoogleApiClient zzoB()
    {
      zzn localzzn = zzn.zzb(zzagU);
      GoogleApiClient localGoogleApiClient = localzzn.zzeu(zzagW);
      Object localObject = localGoogleApiClient;
      if (localGoogleApiClient == null)
        localObject = new zzg(mContext.getApplicationContext(), zznW, zzoz(), zzagY, zzagT, zzagZ, zzaha, -1, zzagW);
      localzzn.zza(zzagW, (GoogleApiClient)localObject, zzagX);
      return localObject;
    }

    public Builder addApi(Api<? extends Api.ApiOptions.NotRequiredOptions> paramApi)
    {
      zzagT.put(paramApi, null);
      zzagP.addAll(paramApi.zzot());
      return this;
    }

    public <O extends Api.ApiOptions.HasOptions> Builder addApi(Api<O> paramApi, O paramO)
    {
      zzv.zzb(paramO, "Null options are not permitted for this Api");
      zzagT.put(paramApi, paramO);
      zzagP.addAll(paramApi.zzot());
      return this;
    }

    public Builder addConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
    {
      zzagZ.add(paramConnectionCallbacks);
      return this;
    }

    public Builder addOnConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
    {
      zzaha.add(paramOnConnectionFailedListener);
      return this;
    }

    public Builder addScope(Scope paramScope)
    {
      zzagP.add(paramScope);
      return this;
    }

    public GoogleApiClient build()
    {
      if (!zzagT.isEmpty());
      for (boolean bool = true; ; bool = false)
      {
        zzv.zzb(bool, "must call addApi() to add at least one API");
        if (zzagV < 0)
          break;
        return zzoA();
      }
      if (zzagW >= 0)
        return zzoB();
      return new zzg(mContext, zznW, zzoz(), zzagY, zzagT, zzagZ, zzaha, -1, -1);
    }

    public Builder setAccountName(String paramString)
    {
      if (paramString == null);
      for (paramString = null; ; paramString = new Account(paramString, "com.google"))
      {
        zzMF = paramString;
        return this;
      }
    }

    public zzf zzoz()
    {
      return new zzf(zzMF, zzagP, zzagS, zzagQ, zzagR, zzOZ, zzOY, zzahb.zzCA());
    }
  }

  public static abstract interface ConnectionCallbacks
  {
    public abstract void onConnected(Bundle paramBundle);

    public abstract void onConnectionSuspended(int paramInt);
  }

  public static abstract interface ConnectionProgressReportCallbacks
  {
    public abstract void onReportAccountValidation(ConnectionResult paramConnectionResult);

    public abstract void onReportServiceBinding(ConnectionResult paramConnectionResult);
  }

  public static abstract interface OnConnectionFailedListener
  {
    public abstract void onConnectionFailed(ConnectionResult paramConnectionResult);
  }

  public static abstract interface ServerAuthCodeCallbacks
  {
    public abstract CheckResult onCheckServerAuthorization(String paramString, Set<Scope> paramSet);

    public abstract boolean onUploadServerAuthCode(String paramString1, String paramString2);

    public static class CheckResult
    {
      private boolean zzahc;
      private Set<Scope> zzahd;

      public boolean zzoC()
      {
        return zzahc;
      }

      public Set<Scope> zzoD()
      {
        return zzahd;
      }
    }
  }
}
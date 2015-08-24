package com.google.android.gms.common.api;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzv;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public final class Api<O extends ApiOptions>
{
  private final String mName;
  private final ClientKey<?> zzaeA;
  private final zza<?, O> zzagD;
  private final zzc<?, O> zzagE;
  private final zzd<?> zzagF;
  private final ArrayList<Scope> zzagG;

  public <C extends Client> Api(String paramString, zza<C, O> paramzza, ClientKey<C> paramClientKey, Scope[] paramArrayOfScope)
  {
    zzv.zzb(paramzza, "Cannot construct an Api with a null ClientBuilder");
    zzv.zzb(paramClientKey, "Cannot construct an Api with a null ClientKey");
    mName = paramString;
    zzagD = paramzza;
    zzagE = null;
    zzaeA = paramClientKey;
    zzagF = null;
    zzagG = new ArrayList(Arrays.asList(paramArrayOfScope));
  }

  public String getName()
  {
    return mName;
  }

  public zza<?, O> zzor()
  {
    if (zzagD != null);
    for (boolean bool = true; ; bool = false)
    {
      zzv.zza(bool, "This API was constructed with a SimpleClientBuilder. Use getSimpleClientBuilder");
      return zzagD;
    }
  }

  public zzc<?, O> zzos()
  {
    if (zzagE != null);
    for (boolean bool = true; ; bool = false)
    {
      zzv.zza(bool, "This API was constructed with a ClientBuilder. Use getClientBuilder");
      return zzagE;
    }
  }

  public List<Scope> zzot()
  {
    return zzagG;
  }

  public ClientKey<?> zzou()
  {
    if (zzaeA != null);
    for (boolean bool = true; ; bool = false)
    {
      zzv.zza(bool, "This API was constructed with a SimpleClientKey. Use getSimpleClientKey");
      return zzaeA;
    }
  }

  public boolean zzov()
  {
    return zzagF != null;
  }

  public static abstract interface ApiOptions
  {
    public static abstract interface HasOptions extends Api.ApiOptions
    {
    }

    public static final class NoOptions
      implements Api.ApiOptions.NotRequiredOptions
    {
    }

    public static abstract interface NotRequiredOptions extends Api.ApiOptions
    {
    }

    public static abstract interface Optional extends Api.ApiOptions.HasOptions, Api.ApiOptions.NotRequiredOptions
    {
    }
  }

  public static abstract interface Client
  {
    public abstract void connect(GoogleApiClient.ConnectionProgressReportCallbacks paramConnectionProgressReportCallbacks);

    public abstract void disconnect();

    public abstract void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString);

    public abstract void getRemoteService(IAccountAccessor paramIAccountAccessor, Set<Scope> paramSet);

    public abstract boolean isConnected();

    public abstract boolean requiresSignIn();

    public abstract void validateAccount(IAccountAccessor paramIAccountAccessor);
  }

  public static final class ClientKey<C extends Api.Client>
  {
  }

  public static abstract interface zza<T extends Api.Client, O>
  {
    public abstract int getPriority();

    public abstract T zza(Context paramContext, Looper paramLooper, zzf paramzzf, O paramO, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener);
  }

  public static abstract interface zzb<T extends IInterface>
  {
    public abstract String getServiceDescriptor();

    public abstract String getStartServiceAction();

    public abstract T zzX(IBinder paramIBinder);
  }

  public static abstract interface zzc<T extends Api.zzb, O>
  {
    public abstract int zzow();

    public abstract T zzp(O paramO);
  }

  public static final class zzd<C extends Api.zzb>
  {
  }
}
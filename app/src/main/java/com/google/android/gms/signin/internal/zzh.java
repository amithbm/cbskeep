package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.GoogleApiClient.ServerAuthCodeCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.ServerAuthCodeCallbacks.CheckResult;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.AuthAccountRequest;
import com.google.android.gms.common.internal.BinderWrapper;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzj.zzf;
import com.google.android.gms.common.internal.zzr;
import com.google.android.gms.common.internal.zzv;
import com.google.android.gms.internal.zzvg;
import com.google.android.gms.internal.zzvh;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;

public class zzh extends zzj<zzf>
  implements zzvg
{
  private final com.google.android.gms.common.internal.zzf zzahu;
  private final zzvh zzala;
  private Integer zzalb;
  private final boolean zzbqT;
  private final ExecutorService zzbqU;

  public zzh(Context paramContext, Looper paramLooper, boolean paramBoolean, com.google.android.gms.common.internal.zzf paramzzf, zzvh paramzzvh, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, ExecutorService paramExecutorService)
  {
    super(paramContext, paramLooper, 44, paramConnectionCallbacks, paramOnConnectionFailedListener, paramzzf);
    zzbqT = paramBoolean;
    zzahu = paramzzf;
    zzala = paramzzvh;
    zzalb = paramzzf.zzpE();
    zzbqU = paramExecutorService;
  }

  public static Bundle zza(zzvh paramzzvh, Integer paramInteger, ExecutorService paramExecutorService)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", paramzzvh.zzCx());
    localBundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", paramzzvh.zzCy());
    localBundle.putString("com.google.android.gms.signin.internal.serverClientId", paramzzvh.zzkT());
    if (paramzzvh.zzCz() != null)
      localBundle.putParcelable("com.google.android.gms.signin.internal.signInCallbacks", new BinderWrapper(new zza(paramzzvh, paramExecutorService).asBinder()));
    if (paramInteger != null)
      localBundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", paramInteger.intValue());
    return localBundle;
  }

  public void connect()
  {
    connect(new zzj.zzf(this));
  }

  protected String getServiceDescriptor()
  {
    return "com.google.android.gms.signin.internal.ISignInService";
  }

  protected String getStartServiceAction()
  {
    return "com.google.android.gms.signin.service.START";
  }

  public boolean requiresSignIn()
  {
    return zzbqT;
  }

  public void zzCw()
  {
    try
    {
      ((zzf)zzpN()).zzpw(zzalb.intValue());
      return;
    }
    catch (RemoteException localRemoteException)
    {
      Log.w("SignInClientImpl", "Remote service probably died when clearAccountFromSessionStore is called");
    }
  }

  public void zza(IAccountAccessor paramIAccountAccessor, Set<Scope> paramSet, zze paramzze)
  {
    zzv.zzb(paramzze, "Expecting a valid ISignInCallbacks");
    try
    {
      ((zzf)zzpN()).zza(new AuthAccountRequest(paramIAccountAccessor, paramSet), paramzze);
      return;
    }
    catch (RemoteException paramIAccountAccessor)
    {
      Log.w("SignInClientImpl", "Remote service probably died when authAccount is called");
      try
      {
        paramzze.zza(new ConnectionResult(8, null), new AuthAccountResult());
        return;
      }
      catch (RemoteException paramIAccountAccessor)
      {
        Log.wtf("SignInClientImpl", "ISignInCallbacks#onAuthAccount should be executed from the same process, unexpected RemoteException.");
      }
    }
  }

  public void zza(IAccountAccessor paramIAccountAccessor, boolean paramBoolean)
  {
    try
    {
      ((zzf)zzpN()).zza(paramIAccountAccessor, zzalb.intValue(), paramBoolean);
      return;
    }
    catch (RemoteException paramIAccountAccessor)
    {
      Log.w("SignInClientImpl", "Remote service probably died when saveDefaultAccount is called");
    }
  }

  public void zza(zzr paramzzr)
  {
    zzv.zzb(paramzzr, "Expecting a valid IResolveAccountCallbacks");
    try
    {
      Account localAccount = zzahu.zzpv();
      ((zzf)zzpN()).zza(new ResolveAccountRequest(localAccount, zzalb.intValue()), paramzzr);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      Log.w("SignInClientImpl", "Remote service probably died when resolveAccount is called");
      try
      {
        paramzzr.zzb(new ResolveAccountResponse(8));
        return;
      }
      catch (RemoteException paramzzr)
      {
        Log.wtf("SignInClientImpl", "IResolveAccountCallbacks#onAccountResolutionComplete should be executed from the same process, unexpected RemoteException.");
      }
    }
  }

  protected zzf zzgy(IBinder paramIBinder)
  {
    return zzf.zza.zzgx(paramIBinder);
  }

  protected Bundle zzkG()
  {
    Bundle localBundle = zza(zzala, zzahu.zzpE(), zzbqU);
    String str = zzahu.zzpA();
    if (!getContext().getPackageName().equals(str))
      localBundle.putString("com.google.android.gms.signin.internal.realClientPackageName", zzahu.zzpA());
    return localBundle;
  }

  private static class zza extends zzd.zza
  {
    private final zzvh zzala;
    private final ExecutorService zzbqU;

    public zza(zzvh paramzzvh, ExecutorService paramExecutorService)
    {
      zzala = paramzzvh;
      zzbqU = paramExecutorService;
    }

    private GoogleApiClient.ServerAuthCodeCallbacks zzCz()
      throws RemoteException
    {
      return zzala.zzCz();
    }

    public void zza(final String paramString1, final String paramString2, final zzf paramzzf)
      throws RemoteException
    {
      zzbqU.submit(new Runnable()
      {
        public void run()
        {
          try
          {
            boolean bool = zzh.zza.zza(zzh.zza.this).onUploadServerAuthCode(paramString1, paramString2);
            paramzzf.zzak(bool);
            return;
          }
          catch (RemoteException localRemoteException)
          {
            Log.e("SignInClientImpl", "RemoteException thrown when processing uploadServerAuthCode callback", localRemoteException);
          }
        }
      });
    }

    public void zza(final String paramString, final List<Scope> paramList, final zzf paramzzf)
      throws RemoteException
    {
      zzbqU.submit(new Runnable()
      {
        public void run()
        {
          try
          {
            Object localObject = zzh.zza.zza(zzh.zza.this);
            Set localSet = Collections.unmodifiableSet(new HashSet(paramList));
            localObject = ((GoogleApiClient.ServerAuthCodeCallbacks)localObject).onCheckServerAuthorization(paramString, localSet);
            localObject = new CheckServerAuthResult(((GoogleApiClient.ServerAuthCodeCallbacks.CheckResult)localObject).zzoC(), ((GoogleApiClient.ServerAuthCodeCallbacks.CheckResult)localObject).zzoD());
            paramzzf.zza((CheckServerAuthResult)localObject);
            return;
          }
          catch (RemoteException localRemoteException)
          {
            Log.e("SignInClientImpl", "RemoteException thrown when processing checkServerAuthorization callback", localRemoteException);
          }
        }
      });
    }
  }
}
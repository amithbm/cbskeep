package com.google.android.gms.drive.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzv;
import com.google.android.gms.drive.DriveId;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class zzs extends zzj<zzak>
{
  private final String zzOZ;
  final GoogleApiClient.ConnectionCallbacks zzalx;
  private final Bundle zzaul;
  private final boolean zzaum;
  private DriveId zzaun;
  private DriveId zzauo;
  final Map<DriveId, Map<Object, Object>> zzaup = new HashMap();
  final Map<Object, Object> zzauq = new HashMap();
  final Map<DriveId, Map<Object, Object>> zzaur = new HashMap();
  final Map<DriveId, Map<Object, Object>> zzaus = new HashMap();

  public zzs(Context paramContext, Looper paramLooper, zzf paramzzf, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, Bundle paramBundle)
  {
    super(paramContext, paramLooper, 11, paramConnectionCallbacks, paramOnConnectionFailedListener, paramzzf);
    zzOZ = paramzzf.zzpA();
    zzalx = paramConnectionCallbacks;
    zzaul = paramBundle;
    paramLooper = new Intent("com.google.android.gms.drive.events.HANDLE_EVENT");
    paramLooper.setPackage(paramContext.getPackageName());
    paramContext = paramContext.getPackageManager().queryIntentServices(paramLooper, 0);
    switch (paramContext.size())
    {
    default:
      throw new IllegalStateException("AndroidManifest.xml can only define one service that handles the " + paramLooper.getAction() + " action");
    case 0:
      zzaum = false;
      return;
    case 1:
    }
    paramContext = ((ResolveInfo)paramContext.get(0)).serviceInfo;
    if (!paramContext.exported)
      throw new IllegalStateException("Drive event service " + paramContext.name + " must be exported in AndroidManifest.xml");
    zzaum = true;
  }

  public void disconnect()
  {
    if (isConnected());
    try
    {
      ((zzak)zzpN()).zza(new DisconnectRequest());
      label26: super.disconnect();
      synchronized (zzaup)
      {
        zzaup.clear();
        synchronized (zzauq)
        {
          zzauq.clear();
          synchronized (zzaur)
          {
            zzaur.clear();
          }
        }
      }
      synchronized (zzaus)
      {
        zzaus.clear();
        return;
        localObject1 = finally;
        throw localObject1;
        localObject2 = finally;
        throw localObject2;
        localObject3 = finally;
        throw localObject3;
      }
    }
    catch (RemoteException localRemoteException)
    {
      break label26;
    }
  }

  protected String getServiceDescriptor()
  {
    return "com.google.android.gms.drive.internal.IDriveService";
  }

  protected String getStartServiceAction()
  {
    return "com.google.android.gms.drive.ApiService.START";
  }

  public boolean requiresSignIn()
  {
    return true;
  }

  protected void zza(int paramInt1, IBinder paramIBinder, Bundle paramBundle, int paramInt2)
  {
    if (paramBundle != null)
    {
      paramBundle.setClassLoader(getClass().getClassLoader());
      zzaun = ((DriveId)paramBundle.getParcelable("com.google.android.gms.drive.root_id"));
      zzauo = ((DriveId)paramBundle.getParcelable("com.google.android.gms.drive.appdata_id"));
    }
    super.zza(paramInt1, paramIBinder, paramBundle, paramInt2);
  }

  protected zzak zzcs(IBinder paramIBinder)
  {
    return zzak.zza.zzct(paramIBinder);
  }

  protected Bundle zzkG()
  {
    String str = getContext().getPackageName();
    zzv.zzz(str);
    if (!zzpL().zzpy().isEmpty());
    for (boolean bool = true; ; bool = false)
    {
      zzv.zzR(bool);
      Bundle localBundle = new Bundle();
      if (!str.equals(zzOZ))
        localBundle.putString("proxy_package_name", zzOZ);
      localBundle.putAll(zzaul);
      return localBundle;
    }
  }

  public zzak zzsS()
    throws DeadObjectException
  {
    return (zzak)zzpN();
  }
}
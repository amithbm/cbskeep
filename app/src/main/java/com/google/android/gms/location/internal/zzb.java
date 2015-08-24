package com.google.android.gms.location.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;

public class zzb extends zzj<zzg>
{
  protected final zzn<zzg> zzaSx = new zzn()
  {
    public void zzpM()
    {
      zzb.zza(zzb.this);
    }

    public zzg zzyK()
      throws DeadObjectException
    {
      return (zzg)zzb.this.zzpN();
    }
  };
  private final String zzaTg;

  public zzb(Context paramContext, Looper paramLooper, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, String paramString, zzf paramzzf)
  {
    super(paramContext, paramLooper, 23, paramConnectionCallbacks, paramOnConnectionFailedListener, paramzzf);
    zzaTg = paramString;
  }

  protected String getServiceDescriptor()
  {
    return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
  }

  protected String getStartServiceAction()
  {
    return "com.google.android.location.internal.GoogleLocationManagerService.START";
  }

  protected zzg zzdY(IBinder paramIBinder)
  {
    return zzg.zza.zzea(paramIBinder);
  }

  protected Bundle zzkG()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("client_name", zzaTg);
    return localBundle;
  }
}
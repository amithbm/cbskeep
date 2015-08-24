package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzv;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.location.copresence.internal.CopresenceApiOptions;
import com.google.android.gms.location.copresence.internal.zzd;
import com.google.android.gms.location.zzf.zzb;
import java.util.List;

public class zzj extends zzb
{
  private final zzi zzaTD = new zzi(paramContext, zzaSx);
  private final zzd zzaTE;

  public zzj(Context paramContext, Looper paramLooper, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, String paramString, zzf paramzzf)
  {
    this(paramContext, paramLooper, paramConnectionCallbacks, paramOnConnectionFailedListener, paramString, paramzzf, CopresenceApiOptions.zzaSv);
  }

  public zzj(Context paramContext, Looper paramLooper, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, String paramString, zzf paramzzf, CopresenceApiOptions paramCopresenceApiOptions)
  {
    super(paramContext, paramLooper, paramConnectionCallbacks, paramOnConnectionFailedListener, paramString, paramzzf);
    zzaTE = zzd.zza(paramContext, paramzzf.getAccountName(), paramzzf.zzpA(), zzaSx, paramCopresenceApiOptions);
  }

  public void disconnect()
  {
    synchronized (zzaTD)
    {
      boolean bool = isConnected();
      if (bool);
      try
      {
        zzaTD.removeAllListeners();
        zzaTD.zzyO();
        super.disconnect();
        return;
      }
      catch (Exception localException)
      {
        while (true)
          Log.e("LocationClientImpl", "Client disconnected before listeners could be cleaned up", localException);
      }
    }
  }

  public Location getLastLocation()
  {
    return zzaTD.getLastLocation();
  }

  public boolean requiresAccount()
  {
    return true;
  }

  public void zza(PendingIntent paramPendingIntent, zzf.zzb paramzzb)
    throws RemoteException
  {
    zzpM();
    zzv.zzb(paramPendingIntent, "PendingIntent must be specified.");
    zzv.zzb(paramzzb, "OnRemoveGeofencesResultListener not provided.");
    if (paramzzb == null);
    for (paramzzb = null; ; paramzzb = new zzb(paramzzb, this))
    {
      ((zzg)zzpN()).zza(paramPendingIntent, paramzzb, getContext().getPackageName());
      return;
    }
  }

  public void zza(GeofencingRequest paramGeofencingRequest, PendingIntent paramPendingIntent, com.google.android.gms.location.zzf.zza paramzza)
    throws RemoteException
  {
    zzpM();
    zzv.zzb(paramGeofencingRequest, "geofencingRequest can't be null.");
    zzv.zzb(paramPendingIntent, "PendingIntent must be specified.");
    zzv.zzb(paramzza, "OnAddGeofencesResultListener not provided.");
    if (paramzza == null);
    for (paramzza = null; ; paramzza = new zzb(paramzza, this))
    {
      ((zzg)zzpN()).zza(paramGeofencingRequest, paramPendingIntent, paramzza);
      return;
    }
  }

  public void zza(List<String> paramList, zzf.zzb paramzzb)
    throws RemoteException
  {
    zzpM();
    boolean bool;
    String[] arrayOfString;
    if ((paramList != null) && (paramList.size() > 0))
    {
      bool = true;
      zzv.zzb(bool, "geofenceRequestIds can't be null nor empty.");
      zzv.zzb(paramzzb, "OnRemoveGeofencesResultListener not provided.");
      arrayOfString = (String[])paramList.toArray(new String[0]);
      if (paramzzb != null)
        break label81;
    }
    label81: for (paramList = null; ; paramList = new zzb(paramzzb, this))
    {
      ((zzg)zzpN()).zza(arrayOfString, paramList, getContext().getPackageName());
      return;
      bool = false;
      break;
    }
  }

  private final class zza extends com.google.android.gms.common.internal.zzj<zzg>.zzc<com.google.android.gms.location.zzf.zza>
  {
    private final String[] zzaTF;
    private final int zzacY;

    public zza(com.google.android.gms.location.zzf.zza paramInt, int paramArrayOfString, String[] arg4)
    {
      super(paramInt);
      zzacY = LocationStatusCodes.zzkQ(paramArrayOfString);
      Object localObject;
      zzaTF = localObject;
    }

    protected void zza(com.google.android.gms.location.zzf.zza paramzza)
    {
      if (paramzza != null)
        paramzza.zza(zzacY, zzaTF);
    }

    protected void zzpQ()
    {
    }
  }

  private static final class zzb extends zzf.zza
  {
    private com.google.android.gms.location.zzf.zza zzaTH;
    private zzf.zzb zzaTI;
    private zzj zzaTJ;

    public zzb(com.google.android.gms.location.zzf.zza paramzza, zzj paramzzj)
    {
      zzaTH = paramzza;
      zzaTI = null;
      zzaTJ = paramzzj;
    }

    public zzb(zzf.zzb paramzzb, zzj paramzzj)
    {
      zzaTI = paramzzb;
      zzaTH = null;
      zzaTJ = paramzzj;
    }

    public void zza(int paramInt, PendingIntent paramPendingIntent)
    {
      if (zzaTJ == null)
      {
        Log.wtf("LocationClientImpl", "onRemoveGeofencesByPendingIntentResult called multiple times");
        return;
      }
      zzj localzzj1 = zzaTJ;
      zzj localzzj2 = zzaTJ;
      localzzj2.getClass();
      localzzj1.zza(new zzj.zzc(localzzj2, 1, zzaTI, paramInt, paramPendingIntent));
      zzaTJ = null;
      zzaTH = null;
      zzaTI = null;
    }

    public void zza(int paramInt, String[] paramArrayOfString)
      throws RemoteException
    {
      if (zzaTJ == null)
      {
        Log.wtf("LocationClientImpl", "onAddGeofenceResult called multiple times");
        return;
      }
      zzj localzzj1 = zzaTJ;
      zzj localzzj2 = zzaTJ;
      localzzj2.getClass();
      localzzj1.zza(new zzj.zza(localzzj2, zzaTH, paramInt, paramArrayOfString));
      zzaTJ = null;
      zzaTH = null;
      zzaTI = null;
    }

    public void zzb(int paramInt, String[] paramArrayOfString)
    {
      if (zzaTJ == null)
      {
        Log.wtf("LocationClientImpl", "onRemoveGeofencesByRequestIdsResult called multiple times");
        return;
      }
      zzj localzzj1 = zzaTJ;
      zzj localzzj2 = zzaTJ;
      localzzj2.getClass();
      localzzj1.zza(new zzj.zzc(localzzj2, 2, zzaTI, paramInt, paramArrayOfString));
      zzaTJ = null;
      zzaTH = null;
      zzaTI = null;
    }
  }

  private final class zzc extends com.google.android.gms.common.internal.zzj<zzg>.zzc<zzf.zzb>
  {
    private final PendingIntent mPendingIntent;
    private final String[] zzaTF;
    private final int zzaTK;
    private final int zzacY;

    public zzc(int paramzzb, zzf.zzb paramInt1, int paramPendingIntent, PendingIntent arg5)
    {
      super(paramInt1);
      if (paramzzb == 1);
      while (true)
      {
        com.google.android.gms.common.internal.zzb.zzR(bool);
        zzaTK = paramzzb;
        zzacY = LocationStatusCodes.zzkQ(paramPendingIntent);
        Object localObject;
        mPendingIntent = localObject;
        zzaTF = null;
        return;
        bool = false;
      }
    }

    public zzc(int paramzzb, zzf.zzb paramInt1, int paramArrayOfString, String[] arg5)
    {
      super(paramInt1);
      if (paramzzb == 2);
      for (boolean bool = true; ; bool = false)
      {
        com.google.android.gms.common.internal.zzb.zzR(bool);
        zzaTK = paramzzb;
        zzacY = LocationStatusCodes.zzkQ(paramArrayOfString);
        Object localObject;
        zzaTF = localObject;
        mPendingIntent = null;
        return;
      }
    }

    protected void zza(zzf.zzb paramzzb)
    {
      if (paramzzb != null);
      switch (zzaTK)
      {
      default:
        Log.wtf("LocationClientImpl", "Unsupported action: " + zzaTK);
        return;
      case 1:
        paramzzb.zza(zzacY, mPendingIntent);
        return;
      case 2:
      }
      paramzzb.zzb(zzacY, zzaTF);
    }

    protected void zzpQ()
    {
    }
  }
}
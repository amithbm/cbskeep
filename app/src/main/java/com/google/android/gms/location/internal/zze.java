package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.GeofencingApi;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationServices.zza;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.location.zzf.zza;
import com.google.android.gms.location.zzf.zzb;
import java.util.List;

public class zze
  implements GeofencingApi
{
  public PendingResult<Status> addGeofences(GoogleApiClient paramGoogleApiClient, final GeofencingRequest paramGeofencingRequest, final PendingIntent paramPendingIntent)
  {
    return paramGoogleApiClient.zzb(new zza(paramGoogleApiClient)
    {
      protected void zza(zzj paramAnonymouszzj)
        throws RemoteException
      {
        zzf.zza local1 = new zzf.zza()
        {
          public void zza(int paramAnonymous2Int, String[] paramAnonymous2ArrayOfString)
          {
            setResult(LocationStatusCodes.zzkR(paramAnonymous2Int));
          }
        };
        paramAnonymouszzj.zza(paramGeofencingRequest, paramPendingIntent, local1);
      }
    });
  }

  public PendingResult<Status> removeGeofences(GoogleApiClient paramGoogleApiClient, final PendingIntent paramPendingIntent)
  {
    return paramGoogleApiClient.zzb(new zza(paramGoogleApiClient)
    {
      protected void zza(zzj paramAnonymouszzj)
        throws RemoteException
      {
        zzf.zzb local1 = new zzf.zzb()
        {
          public void zza(int paramAnonymous2Int, PendingIntent paramAnonymous2PendingIntent)
          {
            setResult(LocationStatusCodes.zzkR(paramAnonymous2Int));
          }

          public void zzb(int paramAnonymous2Int, String[] paramAnonymous2ArrayOfString)
          {
            Log.wtf("GeofencingImpl", "Request ID callback shouldn't have been called");
          }
        };
        paramAnonymouszzj.zza(paramPendingIntent, local1);
      }
    });
  }

  public PendingResult<Status> removeGeofences(GoogleApiClient paramGoogleApiClient, final List<String> paramList)
  {
    return paramGoogleApiClient.zzb(new zza(paramGoogleApiClient)
    {
      protected void zza(zzj paramAnonymouszzj)
        throws RemoteException
      {
        zzf.zzb local1 = new zzf.zzb()
        {
          public void zza(int paramAnonymous2Int, PendingIntent paramAnonymous2PendingIntent)
          {
            Log.wtf("GeofencingImpl", "PendingIntent callback shouldn't have been called");
          }

          public void zzb(int paramAnonymous2Int, String[] paramAnonymous2ArrayOfString)
          {
            setResult(LocationStatusCodes.zzkR(paramAnonymous2Int));
          }
        };
        paramAnonymouszzj.zza(paramList, local1);
      }
    });
  }

  private static abstract class zza extends LocationServices.zza<Status>
  {
    public zza(GoogleApiClient paramGoogleApiClient)
    {
      super();
    }

    public Status zze(Status paramStatus)
    {
      return paramStatus;
    }
  }
}
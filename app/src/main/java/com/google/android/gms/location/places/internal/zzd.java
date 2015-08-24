package com.google.android.gms.location.places.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.location.places.PlacesOptions;
import com.google.android.gms.location.places.PlacesOptions.Builder;
import com.google.android.gms.location.places.UserDataType;
import com.google.android.gms.location.places.zzk;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.List;
import java.util.Locale;

public class zzd extends zzj<zzf>
{
  private final PlacesParams zzaVb;
  private final Locale zzaVc = Locale.getDefault();

  public zzd(Context paramContext, Looper paramLooper, com.google.android.gms.common.internal.zzf paramzzf, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, String paramString1, String paramString2, PlacesOptions paramPlacesOptions)
  {
    super(paramContext, paramLooper, 65, paramConnectionCallbacks, paramOnConnectionFailedListener, paramzzf);
    paramContext = null;
    if (paramzzf.getAccount() != null)
      paramContext = paramzzf.getAccount().name;
    zzaVb = new PlacesParams(paramString1, zzaVc, paramContext, paramPlacesOptions.gCoreClientName, paramString2);
  }

  protected String getServiceDescriptor()
  {
    return "com.google.android.gms.location.places.internal.IGooglePlacesService";
  }

  protected String getStartServiceAction()
  {
    return "com.google.android.gms.location.places.GeoDataApi";
  }

  public void zza(zzk paramzzk, UserDataType paramUserDataType, LatLngBounds paramLatLngBounds, List<String> paramList)
    throws RemoteException
  {
    ((zzf)zzpN()).zza(paramUserDataType, paramLatLngBounds, paramList, zzaVb, paramzzk);
  }

  public void zza(zzk paramzzk, List<String> paramList)
    throws RemoteException
  {
    ((zzf)zzpN()).zzb(paramList, zzaVb, paramzzk);
  }

  protected zzf zzec(IBinder paramIBinder)
  {
    return zzf.zza.zzee(paramIBinder);
  }

  public static class zza
    implements Api.zza<zzd, PlacesOptions>
  {
    private final String zzaVd;
    private final String zzaVe;

    public zza(String paramString1, String paramString2)
    {
      zzaVd = paramString1;
      zzaVe = paramString2;
    }

    public int getPriority()
    {
      return 2147483647;
    }

    public zzd zza(Context paramContext, Looper paramLooper, com.google.android.gms.common.internal.zzf paramzzf, PlacesOptions paramPlacesOptions, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
    {
      String str1;
      String str2;
      if (zzaVd != null)
      {
        str1 = zzaVd;
        if (zzaVe == null)
          break label73;
        str2 = zzaVe;
        label26: if (paramPlacesOptions != null)
          break label82;
        paramPlacesOptions = new PlacesOptions.Builder().build();
      }
      label73: label82: 
      while (true)
      {
        return new zzd(paramContext, paramLooper, paramzzf, paramConnectionCallbacks, paramOnConnectionFailedListener, str1, str2, paramPlacesOptions);
        str1 = paramContext.getPackageName();
        break;
        str2 = paramContext.getPackageName();
        break label26;
      }
    }
  }
}
package com.google.android.gms.location.places.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.ClientKey;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.internal.zzv;
import com.google.android.gms.location.places.GeoDataApi;
import com.google.android.gms.location.places.PlaceBuffer;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.location.places.UserDataType;
import com.google.android.gms.location.places.personalized.PlaceUserDataBuffer;
import com.google.android.gms.location.places.zzk;
import com.google.android.gms.location.places.zzk.zzc;
import com.google.android.gms.location.places.zzk.zze;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.Arrays;
import java.util.List;

public class zzc
  implements GeoDataApi
{
  public PendingResult<PlaceBuffer> getPlaceById(GoogleApiClient paramGoogleApiClient, final String[] paramArrayOfString)
  {
    boolean bool = true;
    if ((paramArrayOfString != null) && (paramArrayOfString.length >= 1));
    while (true)
    {
      zzv.zzS(bool);
      return paramGoogleApiClient.zza(new zzk.zzc(Places.zzaUB, paramGoogleApiClient)
      {
        protected void zza(zzd paramAnonymouszzd)
          throws RemoteException
        {
          List localList = Arrays.asList(paramArrayOfString);
          paramAnonymouszzd.zza(new zzk(this, paramAnonymouszzd.getContext()), localList);
        }
      });
      bool = false;
    }
  }

  public PendingResult<PlaceUserDataBuffer> getPlaceUserData(GoogleApiClient paramGoogleApiClient, final UserDataType paramUserDataType, final LatLngBounds paramLatLngBounds, final List<String> paramList)
  {
    return paramGoogleApiClient.zza(new zzk.zze(Places.zzaUB, paramGoogleApiClient)
    {
      protected void zza(zzd paramAnonymouszzd)
        throws RemoteException
      {
        paramAnonymouszzd.zza(new zzk(this), paramUserDataType, paramLatLngBounds, paramList);
      }
    });
  }
}
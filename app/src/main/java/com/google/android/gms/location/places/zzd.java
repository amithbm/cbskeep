package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzd
  implements Parcelable.Creator<NearbyAlertRequest>
{
  static void zza(NearbyAlertRequest paramNearbyAlertRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, paramNearbyAlertRequest.getTransitionTypes());
    zzb.zzc(paramParcel, 1000, paramNearbyAlertRequest.getVersionCode());
    zzb.zzc(paramParcel, 2, paramNearbyAlertRequest.getLoiteringTimeMillis());
    zzb.zza(paramParcel, 3, paramNearbyAlertRequest.getFilter(), paramInt, false);
    zzb.zza(paramParcel, 4, paramNearbyAlertRequest.getNearbyAlertFilter(), paramInt, false);
    zzb.zzJ(paramParcel, i);
  }

  public NearbyAlertRequest zzit(Parcel paramParcel)
  {
    NearbyAlertFilter localNearbyAlertFilter = null;
    int j = 0;
    int m = zza.zzcQ(paramParcel);
    int i = -1;
    PlaceFilter localPlaceFilter = null;
    int k = 0;
    while (paramParcel.dataPosition() < m)
    {
      int n = zza.zzcP(paramParcel);
      switch (zza.zzeS(n))
      {
      default:
        zza.zzb(paramParcel, n);
        break;
      case 1:
        j = zza.zzg(paramParcel, n);
        break;
      case 1000:
        k = zza.zzg(paramParcel, n);
        break;
      case 2:
        i = zza.zzg(paramParcel, n);
        break;
      case 3:
        localPlaceFilter = (PlaceFilter)zza.zza(paramParcel, n, PlaceFilter.CREATOR);
        break;
      case 4:
        localNearbyAlertFilter = (NearbyAlertFilter)zza.zza(paramParcel, n, NearbyAlertFilter.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != m)
      throw new zza.zza("Overread allowed size end=" + m, paramParcel);
    return new NearbyAlertRequest(k, j, i, localPlaceFilter, localNearbyAlertFilter);
  }

  public NearbyAlertRequest[] zzlw(int paramInt)
  {
    return new NearbyAlertRequest[paramInt];
  }
}
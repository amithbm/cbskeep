package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzo
  implements Parcelable.Creator<VisibleRegion>
{
  static void zza(VisibleRegion paramVisibleRegion, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, paramVisibleRegion.getVersionCode());
    zzb.zza(paramParcel, 2, nearLeft, paramInt, false);
    zzb.zza(paramParcel, 3, nearRight, paramInt, false);
    zzb.zza(paramParcel, 4, farLeft, paramInt, false);
    zzb.zza(paramParcel, 5, farRight, paramInt, false);
    zzb.zza(paramParcel, 6, latLngBounds, paramInt, false);
    zzb.zzJ(paramParcel, i);
  }

  public VisibleRegion zzjk(Parcel paramParcel)
  {
    LatLngBounds localLatLngBounds = null;
    int j = zza.zzcQ(paramParcel);
    int i = 0;
    LatLng localLatLng1 = null;
    LatLng localLatLng2 = null;
    LatLng localLatLng3 = null;
    LatLng localLatLng4 = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = zza.zzcP(paramParcel);
      switch (zza.zzeS(k))
      {
      default:
        zza.zzb(paramParcel, k);
        break;
      case 1:
        i = zza.zzg(paramParcel, k);
        break;
      case 2:
        localLatLng4 = (LatLng)zza.zza(paramParcel, k, LatLng.CREATOR);
        break;
      case 3:
        localLatLng3 = (LatLng)zza.zza(paramParcel, k, LatLng.CREATOR);
        break;
      case 4:
        localLatLng2 = (LatLng)zza.zza(paramParcel, k, LatLng.CREATOR);
        break;
      case 5:
        localLatLng1 = (LatLng)zza.zza(paramParcel, k, LatLng.CREATOR);
        break;
      case 6:
        localLatLngBounds = (LatLngBounds)zza.zza(paramParcel, k, LatLngBounds.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new VisibleRegion(i, localLatLng4, localLatLng3, localLatLng2, localLatLng1, localLatLngBounds);
  }

  public VisibleRegion[] zzmv(int paramInt)
  {
    return new VisibleRegion[paramInt];
  }
}
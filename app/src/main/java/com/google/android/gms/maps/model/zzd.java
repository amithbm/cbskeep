package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzd
  implements Parcelable.Creator<LatLngBounds>
{
  static void zza(LatLngBounds paramLatLngBounds, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, paramLatLngBounds.getVersionCode());
    zzb.zza(paramParcel, 2, southwest, paramInt, false);
    zzb.zza(paramParcel, 3, northeast, paramInt, false);
    zzb.zzJ(paramParcel, i);
  }

  public LatLngBounds zziZ(Parcel paramParcel)
  {
    LatLng localLatLng1 = null;
    int j = zza.zzcQ(paramParcel);
    int i = 0;
    LatLng localLatLng2 = null;
    if (paramParcel.dataPosition() < j)
    {
      int k = zza.zzcP(paramParcel);
      switch (zza.zzeS(k))
      {
      default:
        zza.zzb(paramParcel, k);
      case 1:
      case 2:
      case 3:
      }
      while (true)
      {
        break;
        i = zza.zzg(paramParcel, k);
        continue;
        localLatLng2 = (LatLng)zza.zza(paramParcel, k, LatLng.CREATOR);
        continue;
        localLatLng1 = (LatLng)zza.zza(paramParcel, k, LatLng.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new LatLngBounds(i, localLatLng2, localLatLng1);
  }

  public LatLngBounds[] zzmk(int paramInt)
  {
    return new LatLngBounds[paramInt];
  }
}
package com.google.android.gms.maps.model.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzm
  implements Parcelable.Creator<MarkerOptionsParcelable>
{
  static void zza(MarkerOptionsParcelable paramMarkerOptionsParcelable, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, paramMarkerOptionsParcelable.getVersionCode());
    zzb.zza(paramParcel, 2, paramMarkerOptionsParcelable.zzzX(), paramInt, false);
    zzb.zzJ(paramParcel, i);
  }

  public MarkerOptionsParcelable zzjo(Parcel paramParcel)
  {
    int j = zza.zzcQ(paramParcel);
    int i = 0;
    BitmapDescriptorParcelable localBitmapDescriptorParcelable = null;
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
        localBitmapDescriptorParcelable = (BitmapDescriptorParcelable)zza.zza(paramParcel, k, BitmapDescriptorParcelable.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new MarkerOptionsParcelable(i, localBitmapDescriptorParcelable);
  }

  public MarkerOptionsParcelable[] zzmA(int paramInt)
  {
    return new MarkerOptionsParcelable[paramInt];
  }
}
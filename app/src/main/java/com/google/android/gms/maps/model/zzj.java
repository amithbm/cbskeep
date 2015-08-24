package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzj
  implements Parcelable.Creator<StreetViewPanoramaLink>
{
  static void zza(StreetViewPanoramaLink paramStreetViewPanoramaLink, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, paramStreetViewPanoramaLink.getVersionCode());
    zzb.zza(paramParcel, 2, panoId, false);
    zzb.zza(paramParcel, 3, bearing);
    zzb.zzJ(paramParcel, paramInt);
  }

  public StreetViewPanoramaLink zzjf(Parcel paramParcel)
  {
    int j = zza.zzcQ(paramParcel);
    int i = 0;
    String str = null;
    float f = 0.0F;
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
        str = zza.zzp(paramParcel, k);
        break;
      case 3:
        f = zza.zzl(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new StreetViewPanoramaLink(i, str, f);
  }

  public StreetViewPanoramaLink[] zzmq(int paramInt)
  {
    return new StreetViewPanoramaLink[paramInt];
  }
}
package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzaf
  implements Parcelable.Creator<GetCapabilityResponse>
{
  static void zza(GetCapabilityResponse paramGetCapabilityResponse, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, versionCode);
    zzb.zzc(paramParcel, 2, statusCode);
    zzb.zza(paramParcel, 3, zzbHX, paramInt, false);
    zzb.zzJ(paramParcel, i);
  }

  public GetCapabilityResponse zzns(Parcel paramParcel)
  {
    int j = 0;
    int k = zza.zzcQ(paramParcel);
    CapabilityInfoParcelable localCapabilityInfoParcelable = null;
    int i = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = zza.zzcP(paramParcel);
      switch (zza.zzeS(m))
      {
      default:
        zza.zzb(paramParcel, m);
        break;
      case 1:
        i = zza.zzg(paramParcel, m);
        break;
      case 2:
        j = zza.zzg(paramParcel, m);
        break;
      case 3:
        localCapabilityInfoParcelable = (CapabilityInfoParcelable)zza.zza(paramParcel, m, CapabilityInfoParcelable.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != k)
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    return new GetCapabilityResponse(i, j, localCapabilityInfoParcelable);
  }

  public GetCapabilityResponse[] zzrx(int paramInt)
  {
    return new GetCapabilityResponse[paramInt];
  }
}
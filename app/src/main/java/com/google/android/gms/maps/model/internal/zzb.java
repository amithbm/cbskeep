package com.google.android.gms.maps.model.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;

public class zzb
  implements Parcelable.Creator<CameraUpdateParcelable>
{
  static void zza(CameraUpdateParcelable paramCameraUpdateParcelable, Parcel paramParcel, int paramInt)
  {
    paramInt = com.google.android.gms.common.internal.safeparcel.zzb.zzcR(paramParcel);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 1, paramCameraUpdateParcelable.getVersionCode());
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 2, paramCameraUpdateParcelable.getType());
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 3, paramCameraUpdateParcelable.getParameters(), false);
    com.google.android.gms.common.internal.safeparcel.zzb.zzJ(paramParcel, paramInt);
  }

  public CameraUpdateParcelable zzjm(Parcel paramParcel)
  {
    int j = 0;
    int k = zza.zzcQ(paramParcel);
    Bundle localBundle = null;
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
        localBundle = zza.zzr(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k)
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    return new CameraUpdateParcelable(i, j, localBundle);
  }

  public CameraUpdateParcelable[] zzmx(int paramInt)
  {
    return new CameraUpdateParcelable[paramInt];
  }
}
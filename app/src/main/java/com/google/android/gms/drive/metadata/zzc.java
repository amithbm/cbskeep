package com.google.android.gms.drive.metadata;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc
  implements Parcelable.Creator<CustomPropertyKey>
{
  static void zza(CustomPropertyKey paramCustomPropertyKey, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zza(paramParcel, 2, zzua, false);
    zzb.zzc(paramParcel, 3, mVisibility);
    zzb.zzJ(paramParcel, paramInt);
  }

  public CustomPropertyKey zzeU(Parcel paramParcel)
  {
    int j = 0;
    int k = zza.zzcQ(paramParcel);
    String str = null;
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
        str = zza.zzp(paramParcel, m);
        break;
      case 3:
        j = zza.zzg(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k)
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    return new CustomPropertyKey(i, str, j);
  }

  public CustomPropertyKey[] zzho(int paramInt)
  {
    return new CustomPropertyKey[paramInt];
  }
}
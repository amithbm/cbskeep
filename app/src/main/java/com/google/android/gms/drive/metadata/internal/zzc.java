package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.metadata.CustomPropertyKey;

public class zzc
  implements Parcelable.Creator<CustomProperty>
{
  static void zza(CustomProperty paramCustomProperty, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zza(paramParcel, 2, zzawB, paramInt, false);
    zzb.zza(paramParcel, 3, mValue, false);
    zzb.zzJ(paramParcel, i);
  }

  public CustomProperty zzeW(Parcel paramParcel)
  {
    String str = null;
    int j = zza.zzcQ(paramParcel);
    int i = 0;
    CustomPropertyKey localCustomPropertyKey = null;
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
        localCustomPropertyKey = (CustomPropertyKey)zza.zza(paramParcel, k, CustomPropertyKey.CREATOR);
        continue;
        str = zza.zzp(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new CustomProperty(i, localCustomPropertyKey, str);
  }

  public CustomProperty[] zzhq(int paramInt)
  {
    return new CustomProperty[paramInt];
  }
}
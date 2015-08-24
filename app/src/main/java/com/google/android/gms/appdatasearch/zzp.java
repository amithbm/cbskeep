package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzp
  implements Parcelable.Creator<NativeApiInfo>
{
  static void zza(NativeApiInfo paramNativeApiInfo, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcR(paramParcel);
    zzb.zza(paramParcel, 1, sharedLibAbsoluteFilename, false);
    zzb.zzc(paramParcel, 1000, mVersionCode);
    zzb.zza(paramParcel, 2, sharedLibExtensionAbsoluteFilename, false);
    zzb.zza(paramParcel, 3, downloadManagerFilename, false);
    zzb.zzJ(paramParcel, paramInt);
  }

  public NativeApiInfo zzH(Parcel paramParcel)
  {
    String str3 = null;
    int j = zza.zzcQ(paramParcel);
    int i = 0;
    String str2 = null;
    String str1 = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = zza.zzcP(paramParcel);
      switch (zza.zzeS(k))
      {
      default:
        zza.zzb(paramParcel, k);
        break;
      case 1:
        str1 = zza.zzp(paramParcel, k);
        break;
      case 1000:
        i = zza.zzg(paramParcel, k);
        break;
      case 2:
        str2 = zza.zzp(paramParcel, k);
        break;
      case 3:
        str3 = zza.zzp(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new NativeApiInfo(i, str1, str2, str3);
  }

  public NativeApiInfo[] zzat(int paramInt)
  {
    return new NativeApiInfo[paramInt];
  }
}
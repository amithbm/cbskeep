package com.google.android.gms.auth.frp;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;

public class zzb
  implements Parcelable.Creator<UnlockFactoryResetProtectionRequest>
{
  static void zza(UnlockFactoryResetProtectionRequest paramUnlockFactoryResetProtectionRequest, Parcel paramParcel, int paramInt)
  {
    paramInt = com.google.android.gms.common.internal.safeparcel.zzb.zzcR(paramParcel);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 1, version);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 2, accountName, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 3, password, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 4, accountType, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zzJ(paramParcel, paramInt);
  }

  public UnlockFactoryResetProtectionRequest zzbK(Parcel paramParcel)
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
        i = zza.zzg(paramParcel, k);
        break;
      case 2:
        str1 = zza.zzp(paramParcel, k);
        break;
      case 3:
        str2 = zza.zzp(paramParcel, k);
        break;
      case 4:
        str3 = zza.zzp(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new UnlockFactoryResetProtectionRequest(i, str1, str2, str3);
  }

  public UnlockFactoryResetProtectionRequest[] zzcG(int paramInt)
  {
    return new UnlockFactoryResetProtectionRequest[paramInt];
  }
}
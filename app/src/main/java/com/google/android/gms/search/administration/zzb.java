package com.google.android.gms.search.administration;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;

public class zzb
  implements Parcelable.Creator<GetStorageStatsCall.PackageStats>
{
  static void zza(GetStorageStatsCall.PackageStats paramPackageStats, Parcel paramParcel, int paramInt)
  {
    paramInt = com.google.android.gms.common.internal.safeparcel.zzb.zzcR(paramParcel);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 1000, mVersionCode);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 1, packageName, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 2, zzbpV);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 3, blocked);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 4, zzbpW);
    com.google.android.gms.common.internal.safeparcel.zzb.zzJ(paramParcel, paramInt);
  }

  public GetStorageStatsCall.PackageStats zzld(Parcel paramParcel)
  {
    long l1 = 0L;
    boolean bool = false;
    int j = zza.zzcQ(paramParcel);
    String str = null;
    long l2 = 0L;
    int i = 0;
    while (paramParcel.dataPosition() < j)
    {
      int k = zza.zzcP(paramParcel);
      switch (zza.zzeS(k))
      {
      default:
        zza.zzb(paramParcel, k);
        break;
      case 1000:
        i = zza.zzg(paramParcel, k);
        break;
      case 1:
        str = zza.zzp(paramParcel, k);
        break;
      case 2:
        l2 = zza.zzi(paramParcel, k);
        break;
      case 3:
        bool = zza.zzc(paramParcel, k);
        break;
      case 4:
        l1 = zza.zzi(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new GetStorageStatsCall.PackageStats(i, str, l2, bool, l1);
  }

  public GetStorageStatsCall.PackageStats[] zzoH(int paramInt)
  {
    return new GetStorageStatsCall.PackageStats[paramInt];
  }
}
package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzad
  implements Parcelable.Creator<StorageStats>
{
  static void zza(StorageStats paramStorageStats, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zza(paramParcel, 1, packageStats, paramInt, false);
    zzb.zzc(paramParcel, 1000, mVersionCode);
    zzb.zza(paramParcel, 2, otherReclaimableBytes);
    zzb.zza(paramParcel, 3, searchDiskUsageBytes);
    zzb.zza(paramParcel, 4, allServicesDiskUsageBytes);
    zzb.zzJ(paramParcel, i);
  }

  public StorageStats zzV(Parcel paramParcel)
  {
    long l1 = 0L;
    int j = zza.zzcQ(paramParcel);
    int i = 0;
    RegisteredPackageInfo[] arrayOfRegisteredPackageInfo = null;
    long l2 = 0L;
    long l3 = 0L;
    while (paramParcel.dataPosition() < j)
    {
      int k = zza.zzcP(paramParcel);
      switch (zza.zzeS(k))
      {
      default:
        zza.zzb(paramParcel, k);
        break;
      case 1:
        arrayOfRegisteredPackageInfo = (RegisteredPackageInfo[])zza.zzb(paramParcel, k, RegisteredPackageInfo.CREATOR);
        break;
      case 1000:
        i = zza.zzg(paramParcel, k);
        break;
      case 2:
        l3 = zza.zzi(paramParcel, k);
        break;
      case 3:
        l2 = zza.zzi(paramParcel, k);
        break;
      case 4:
        l1 = zza.zzi(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new StorageStats(i, arrayOfRegisteredPackageInfo, l3, l2, l1);
  }

  public StorageStats[] zzaL(int paramInt)
  {
    return new StorageStats[paramInt];
  }
}
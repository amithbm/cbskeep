package com.google.android.gms.search.administration;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzd
  implements Parcelable.Creator<GetStorageStatsCall.Response>
{
  static void zza(GetStorageStatsCall.Response paramResponse, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1000, mVersionCode);
    zzb.zza(paramParcel, 1, status, paramInt, false);
    zzb.zza(paramParcel, 2, zzbpX, paramInt, false);
    zzb.zza(paramParcel, 3, zzbpY);
    zzb.zza(paramParcel, 4, zzbpZ);
    zzb.zza(paramParcel, 5, zzbqa);
    zzb.zzJ(paramParcel, i);
  }

  public GetStorageStatsCall.Response zzlf(Parcel paramParcel)
  {
    GetStorageStatsCall.PackageStats[] arrayOfPackageStats = null;
    long l1 = 0L;
    int j = zza.zzcQ(paramParcel);
    int i = 0;
    long l2 = 0L;
    long l3 = 0L;
    Status localStatus = null;
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
        localStatus = (Status)zza.zza(paramParcel, k, Status.CREATOR);
        break;
      case 2:
        arrayOfPackageStats = (GetStorageStatsCall.PackageStats[])zza.zzb(paramParcel, k, GetStorageStatsCall.PackageStats.CREATOR);
        break;
      case 3:
        l3 = zza.zzi(paramParcel, k);
        break;
      case 4:
        l2 = zza.zzi(paramParcel, k);
        break;
      case 5:
        l1 = zza.zzi(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new GetStorageStatsCall.Response(i, localStatus, arrayOfPackageStats, l3, l2, l1);
  }

  public GetStorageStatsCall.Response[] zzoJ(int paramInt)
  {
    return new GetStorageStatsCall.Response[paramInt];
  }
}
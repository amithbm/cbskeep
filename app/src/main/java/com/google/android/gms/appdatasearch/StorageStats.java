package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class StorageStats
  implements SafeParcelable
{
  public static final zzad CREATOR = new zzad();
  public final long allServicesDiskUsageBytes;
  final int mVersionCode;
  public final long otherReclaimableBytes;
  public final RegisteredPackageInfo[] packageStats;
  public final long searchDiskUsageBytes;

  StorageStats(int paramInt, RegisteredPackageInfo[] paramArrayOfRegisteredPackageInfo, long paramLong1, long paramLong2, long paramLong3)
  {
    mVersionCode = paramInt;
    packageStats = paramArrayOfRegisteredPackageInfo;
    otherReclaimableBytes = paramLong1;
    searchDiskUsageBytes = paramLong2;
    allServicesDiskUsageBytes = paramLong3;
  }

  public int describeContents()
  {
    zzad localzzad = CREATOR;
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzad localzzad = CREATOR;
    zzad.zza(this, paramParcel, paramInt);
  }
}
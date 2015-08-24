package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class RegisteredPackageInfo
  implements SafeParcelable
{
  public static final zzz CREATOR = new zzz();
  public final boolean blocked;
  final int mVersionCode;
  public final String packageName;
  public final long reclaimableDiskBytes;
  public final long usedDiskBytes;

  RegisteredPackageInfo(int paramInt, String paramString, long paramLong1, boolean paramBoolean, long paramLong2)
  {
    mVersionCode = paramInt;
    packageName = paramString;
    usedDiskBytes = paramLong1;
    blocked = paramBoolean;
    reclaimableDiskBytes = paramLong2;
  }

  public int describeContents()
  {
    zzz localzzz = CREATOR;
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzz localzzz = CREATOR;
    zzz.zza(this, paramParcel, paramInt);
  }
}
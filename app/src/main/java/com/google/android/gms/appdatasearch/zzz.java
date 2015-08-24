package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzz
  implements Parcelable.Creator<RegisteredPackageInfo>
{
  static void zza(RegisteredPackageInfo paramRegisteredPackageInfo, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcR(paramParcel);
    zzb.zza(paramParcel, 1, packageName, false);
    zzb.zzc(paramParcel, 1000, mVersionCode);
    zzb.zza(paramParcel, 2, usedDiskBytes);
    zzb.zza(paramParcel, 3, blocked);
    zzb.zza(paramParcel, 4, reclaimableDiskBytes);
    zzb.zzJ(paramParcel, paramInt);
  }

  public RegisteredPackageInfo zzR(Parcel paramParcel)
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
      case 1:
        str = zza.zzp(paramParcel, k);
        break;
      case 1000:
        i = zza.zzg(paramParcel, k);
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
    return new RegisteredPackageInfo(i, str, l2, bool, l1);
  }

  public RegisteredPackageInfo[] zzaD(int paramInt)
  {
    return new RegisteredPackageInfo[paramInt];
  }
}
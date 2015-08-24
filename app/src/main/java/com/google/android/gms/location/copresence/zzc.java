package com.google.android.gms.location.copresence;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc
  implements Parcelable.Creator<AccessPolicy>
{
  static void zza(AccessPolicy paramAccessPolicy, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, paramAccessPolicy.getVersionCode());
    zzb.zzc(paramParcel, 2, paramAccessPolicy.zzyq());
    zzb.zza(paramParcel, 4, paramAccessPolicy.zzyr());
    zzb.zza(paramParcel, 5, paramAccessPolicy.zzys(), paramInt, false);
    zzb.zzc(paramParcel, 7, paramAccessPolicy.zzyt());
    zzb.zzJ(paramParcel, i);
  }

  public AccessPolicy zzhT(Parcel paramParcel)
  {
    int i = 0;
    int m = zza.zzcQ(paramParcel);
    long l = 0L;
    AccessLock localAccessLock = null;
    int j = 0;
    int k = 0;
    while (paramParcel.dataPosition() < m)
    {
      int n = zza.zzcP(paramParcel);
      switch (zza.zzeS(n))
      {
      case 3:
      case 6:
      default:
        zza.zzb(paramParcel, n);
        break;
      case 1:
        k = zza.zzg(paramParcel, n);
        break;
      case 2:
        j = zza.zzg(paramParcel, n);
        break;
      case 4:
        l = zza.zzi(paramParcel, n);
        break;
      case 5:
        localAccessLock = (AccessLock)zza.zza(paramParcel, n, AccessLock.CREATOR);
        break;
      case 7:
        i = zza.zzg(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m)
      throw new zza.zza("Overread allowed size end=" + m, paramParcel);
    return new AccessPolicy(k, j, l, localAccessLock, i);
  }

  public AccessPolicy[] zzkU(int paramInt)
  {
    return new AccessPolicy[paramInt];
  }
}
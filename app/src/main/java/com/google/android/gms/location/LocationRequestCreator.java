package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class LocationRequestCreator
  implements Parcelable.Creator<LocationRequest>
{
  static void zza(LocationRequest paramLocationRequest, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, mPriority);
    zzb.zzc(paramParcel, 1000, paramLocationRequest.getVersionCode());
    zzb.zza(paramParcel, 2, zzaRx);
    zzb.zza(paramParcel, 3, zzaRy);
    zzb.zza(paramParcel, 4, zzaEt);
    zzb.zza(paramParcel, 5, zzaQX);
    zzb.zzc(paramParcel, 6, zzaRz);
    zzb.zza(paramParcel, 7, zzaRA);
    zzb.zza(paramParcel, 8, zzaRB);
    zzb.zzJ(paramParcel, paramInt);
  }

  public LocationRequest createFromParcel(Parcel paramParcel)
  {
    int m = zza.zzcQ(paramParcel);
    int k = 0;
    int j = 102;
    long l4 = 3600000L;
    long l3 = 600000L;
    boolean bool = false;
    long l2 = 9223372036854775807L;
    int i = 2147483647;
    float f = 0.0F;
    long l1 = 0L;
    while (paramParcel.dataPosition() < m)
    {
      int n = zza.zzcP(paramParcel);
      switch (zza.zzeS(n))
      {
      default:
        zza.zzb(paramParcel, n);
        break;
      case 1:
        j = zza.zzg(paramParcel, n);
        break;
      case 1000:
        k = zza.zzg(paramParcel, n);
        break;
      case 2:
        l4 = zza.zzi(paramParcel, n);
        break;
      case 3:
        l3 = zza.zzi(paramParcel, n);
        break;
      case 4:
        bool = zza.zzc(paramParcel, n);
        break;
      case 5:
        l2 = zza.zzi(paramParcel, n);
        break;
      case 6:
        i = zza.zzg(paramParcel, n);
        break;
      case 7:
        f = zza.zzl(paramParcel, n);
        break;
      case 8:
        l1 = zza.zzi(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m)
      throw new zza.zza("Overread allowed size end=" + m, paramParcel);
    return new LocationRequest(k, j, l4, l3, bool, l2, i, f, l1);
  }

  public LocationRequest[] newArray(int paramInt)
  {
    return new LocationRequest[paramInt];
  }
}
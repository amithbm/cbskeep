package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzg
  implements Parcelable.Creator<LatencyTracker>
{
  static void zza(LatencyTracker paramLatencyTracker, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, mVersion);
    zzb.zza(paramParcel, 2, mName, false);
    zzb.zza(paramParcel, 3, zzUk);
    zzb.zza(paramParcel, 4, parent, paramInt, false);
    zzb.zzJ(paramParcel, i);
  }

  public LatencyTracker zzbG(Parcel paramParcel)
  {
    LatencyTracker localLatencyTracker = null;
    int j = zza.zzcQ(paramParcel);
    int i = 0;
    long l = 0L;
    String str = null;
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
        str = zza.zzp(paramParcel, k);
        break;
      case 3:
        l = zza.zzi(paramParcel, k);
        break;
      case 4:
        localLatencyTracker = (LatencyTracker)zza.zza(paramParcel, k, LatencyTracker.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new LatencyTracker(i, str, l, localLatencyTracker);
  }

  public LatencyTracker[] zzcC(int paramInt)
  {
    return new LatencyTracker[paramInt];
  }
}
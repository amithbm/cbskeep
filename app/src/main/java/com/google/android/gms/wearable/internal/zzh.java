package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzh
  implements Parcelable.Creator<CapabilityInfoParcelable>
{
  static void zza(CapabilityInfoParcelable paramCapabilityInfoParcelable, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zza(paramParcel, 2, paramCapabilityInfoParcelable.getName(), false);
    zzb.zzd(paramParcel, 3, paramCapabilityInfoParcelable.zzGS(), false);
    zzb.zzJ(paramParcel, paramInt);
  }

  public CapabilityInfoParcelable zzni(Parcel paramParcel)
  {
    ArrayList localArrayList = null;
    int j = zza.zzcQ(paramParcel);
    int i = 0;
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
        localArrayList = zza.zzc(paramParcel, k, NodeParcelable.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new CapabilityInfoParcelable(i, str, localArrayList);
  }

  public CapabilityInfoParcelable[] zzrk(int paramInt)
  {
    return new CapabilityInfoParcelable[paramInt];
  }
}
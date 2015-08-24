package com.google.android.gms.location.copresence;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzj
  implements Parcelable.Creator<People>
{
  static void zza(People paramPeople, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, paramPeople.getVersionCode());
    zzb.zzc(paramParcel, 2, paramPeople.zzyA(), false);
    zzb.zzc(paramParcel, 3, paramPeople.zzyB());
    zzb.zzJ(paramParcel, paramInt);
  }

  public People zzhY(Parcel paramParcel)
  {
    int j = 0;
    int k = zza.zzcQ(paramParcel);
    ArrayList localArrayList = null;
    int i = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = zza.zzcP(paramParcel);
      switch (zza.zzeS(m))
      {
      default:
        zza.zzb(paramParcel, m);
        break;
      case 1:
        i = zza.zzg(paramParcel, m);
        break;
      case 2:
        localArrayList = zza.zzE(paramParcel, m);
        break;
      case 3:
        j = zza.zzg(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k)
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    return new People(i, localArrayList, j);
  }

  public People[] zzkZ(int paramInt)
  {
    return new People[paramInt];
  }
}
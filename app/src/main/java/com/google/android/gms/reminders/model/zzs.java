package com.google.android.gms.reminders.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzs
  implements Parcelable.Creator<TimeEntity>
{
  static void zza(TimeEntity paramTimeEntity, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zza(paramParcel, 2, paramTimeEntity.getHour(), false);
    zzb.zza(paramParcel, 3, paramTimeEntity.getMinute(), false);
    zzb.zza(paramParcel, 4, paramTimeEntity.getSecond(), false);
    zzb.zzJ(paramParcel, paramInt);
  }

  public TimeEntity zzkX(Parcel paramParcel)
  {
    Integer localInteger3 = null;
    int j = zza.zzcQ(paramParcel);
    int i = 0;
    Integer localInteger2 = null;
    Integer localInteger1 = null;
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
        localInteger1 = zza.zzh(paramParcel, k);
        break;
      case 3:
        localInteger2 = zza.zzh(paramParcel, k);
        break;
      case 4:
        localInteger3 = zza.zzh(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new TimeEntity(i, localInteger1, localInteger2, localInteger3);
  }

  public TimeEntity[] zzoB(int paramInt)
  {
    return new TimeEntity[paramInt];
  }
}
package com.google.android.gms.reminders.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zze
  implements Parcelable.Creator<DailyPatternEntity>
{
  static void zza(DailyPatternEntity paramDailyPatternEntity, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zza(paramParcel, 2, paramDailyPatternEntity.getTimeOfDay(), paramInt, false);
    zzb.zza(paramParcel, 3, paramDailyPatternEntity.getDayPeriod(), false);
    zzb.zza(paramParcel, 4, paramDailyPatternEntity.getAllDay(), false);
    zzb.zzJ(paramParcel, i);
  }

  public DailyPatternEntity zzkJ(Parcel paramParcel)
  {
    Boolean localBoolean = null;
    int j = zza.zzcQ(paramParcel);
    int i = 0;
    Object localObject2 = null;
    Object localObject1 = null;
    if (paramParcel.dataPosition() < j)
    {
      int k = zza.zzcP(paramParcel);
      Object localObject3;
      switch (zza.zzeS(k))
      {
      default:
        zza.zzb(paramParcel, k);
        localObject3 = localObject2;
        localObject2 = localObject1;
        localObject1 = localObject3;
      case 1:
      case 2:
      case 3:
      case 4:
      }
      while (true)
      {
        localObject3 = localObject2;
        localObject2 = localObject1;
        localObject1 = localObject3;
        break;
        i = zza.zzg(paramParcel, k);
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
        continue;
        localObject3 = (TimeEntity)zza.zza(paramParcel, k, TimeEntity.CREATOR);
        localObject1 = localObject2;
        localObject2 = localObject3;
        continue;
        localObject3 = zza.zzh(paramParcel, k);
        localObject2 = localObject1;
        localObject1 = localObject3;
        continue;
        localBoolean = zza.zzd(paramParcel, k);
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new DailyPatternEntity(i, localObject1, localObject2, localBoolean);
  }

  public DailyPatternEntity[] zzon(int paramInt)
  {
    return new DailyPatternEntity[paramInt];
  }
}
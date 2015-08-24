package com.google.android.gms.reminders.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzd
  implements Parcelable.Creator<CustomizedSnoozePresetEntity>
{
  static void zza(CustomizedSnoozePresetEntity paramCustomizedSnoozePresetEntity, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zza(paramParcel, 2, paramCustomizedSnoozePresetEntity.getMorningCustomizedTime(), paramInt, false);
    zzb.zza(paramParcel, 3, paramCustomizedSnoozePresetEntity.getAfternoonCustomizedTime(), paramInt, false);
    zzb.zza(paramParcel, 4, paramCustomizedSnoozePresetEntity.getEveningCustomizedTime(), paramInt, false);
    zzb.zzJ(paramParcel, i);
  }

  public CustomizedSnoozePresetEntity zzkI(Parcel paramParcel)
  {
    TimeEntity localTimeEntity = null;
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
        localObject3 = (TimeEntity)zza.zza(paramParcel, k, TimeEntity.CREATOR);
        localObject2 = localObject1;
        localObject1 = localObject3;
        continue;
        localTimeEntity = (TimeEntity)zza.zza(paramParcel, k, TimeEntity.CREATOR);
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new CustomizedSnoozePresetEntity(i, localObject1, localObject2, localTimeEntity);
  }

  public CustomizedSnoozePresetEntity[] zzom(int paramInt)
  {
    return new CustomizedSnoozePresetEntity[paramInt];
  }
}
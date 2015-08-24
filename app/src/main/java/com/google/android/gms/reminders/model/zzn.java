package com.google.android.gms.reminders.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzn
  implements Parcelable.Creator<RecurrenceInfoEntity>
{
  static void zza(RecurrenceInfoEntity paramRecurrenceInfoEntity, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zza(paramParcel, 2, paramRecurrenceInfoEntity.getRecurrence(), paramInt, false);
    zzb.zza(paramParcel, 3, paramRecurrenceInfoEntity.getRecurrenceId(), false);
    zzb.zza(paramParcel, 4, paramRecurrenceInfoEntity.getMaster(), false);
    zzb.zza(paramParcel, 5, paramRecurrenceInfoEntity.getExceptional(), false);
    zzb.zzJ(paramParcel, i);
  }

  public RecurrenceInfoEntity zzkS(Parcel paramParcel)
  {
    Boolean localBoolean1 = null;
    int j = zza.zzcQ(paramParcel);
    int i = 0;
    Boolean localBoolean2 = null;
    String str = null;
    RecurrenceEntity localRecurrenceEntity = null;
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
        localRecurrenceEntity = (RecurrenceEntity)zza.zza(paramParcel, k, RecurrenceEntity.CREATOR);
        break;
      case 3:
        str = zza.zzp(paramParcel, k);
        break;
      case 4:
        localBoolean2 = zza.zzd(paramParcel, k);
        break;
      case 5:
        localBoolean1 = zza.zzd(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new RecurrenceInfoEntity(i, localRecurrenceEntity, str, localBoolean2, localBoolean1);
  }

  public RecurrenceInfoEntity[] zzow(int paramInt)
  {
    return new RecurrenceInfoEntity[paramInt];
  }
}
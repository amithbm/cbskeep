package com.google.android.gms.reminders.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzm
  implements Parcelable.Creator<RecurrenceEndEntity>
{
  static void zza(RecurrenceEndEntity paramRecurrenceEndEntity, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zza(paramParcel, 2, paramRecurrenceEndEntity.getEndDateTime(), paramInt, false);
    zzb.zza(paramParcel, 4, paramRecurrenceEndEntity.getNumOccurrences(), false);
    zzb.zza(paramParcel, 5, paramRecurrenceEndEntity.getAutoRenew(), false);
    zzb.zza(paramParcel, 6, paramRecurrenceEndEntity.getAutoRenewUntil(), paramInt, false);
    zzb.zzJ(paramParcel, i);
  }

  public RecurrenceEndEntity zzkR(Parcel paramParcel)
  {
    DateTimeEntity localDateTimeEntity1 = null;
    int j = zza.zzcQ(paramParcel);
    int i = 0;
    Boolean localBoolean = null;
    Integer localInteger = null;
    DateTimeEntity localDateTimeEntity2 = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = zza.zzcP(paramParcel);
      switch (zza.zzeS(k))
      {
      case 3:
      default:
        zza.zzb(paramParcel, k);
        break;
      case 1:
        i = zza.zzg(paramParcel, k);
        break;
      case 2:
        localDateTimeEntity2 = (DateTimeEntity)zza.zza(paramParcel, k, DateTimeEntity.CREATOR);
        break;
      case 4:
        localInteger = zza.zzh(paramParcel, k);
        break;
      case 5:
        localBoolean = zza.zzd(paramParcel, k);
        break;
      case 6:
        localDateTimeEntity1 = (DateTimeEntity)zza.zza(paramParcel, k, DateTimeEntity.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new RecurrenceEndEntity(i, localDateTimeEntity2, localInteger, localBoolean, localDateTimeEntity1);
  }

  public RecurrenceEndEntity[] zzov(int paramInt)
  {
    return new RecurrenceEndEntity[paramInt];
  }
}
package com.google.android.gms.reminders.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzo
  implements Parcelable.Creator<RecurrenceStartEntity>
{
  static void zza(RecurrenceStartEntity paramRecurrenceStartEntity, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zza(paramParcel, 2, paramRecurrenceStartEntity.getStartDateTime(), paramInt, false);
    zzb.zzJ(paramParcel, i);
  }

  public RecurrenceStartEntity zzkT(Parcel paramParcel)
  {
    int j = zza.zzcQ(paramParcel);
    int i = 0;
    DateTimeEntity localDateTimeEntity = null;
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
        localDateTimeEntity = (DateTimeEntity)zza.zza(paramParcel, k, DateTimeEntity.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new RecurrenceStartEntity(i, localDateTimeEntity);
  }

  public RecurrenceStartEntity[] zzox(int paramInt)
  {
    return new RecurrenceStartEntity[paramInt];
  }
}
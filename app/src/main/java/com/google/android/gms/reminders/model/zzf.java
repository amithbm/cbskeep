package com.google.android.gms.reminders.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzf
  implements Parcelable.Creator<DateTimeEntity>
{
  static void zza(DateTimeEntity paramDateTimeEntity, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zza(paramParcel, 2, paramDateTimeEntity.getYear(), false);
    zzb.zza(paramParcel, 3, paramDateTimeEntity.getMonth(), false);
    zzb.zza(paramParcel, 4, paramDateTimeEntity.getDay(), false);
    zzb.zza(paramParcel, 5, paramDateTimeEntity.getTime(), paramInt, false);
    zzb.zza(paramParcel, 6, paramDateTimeEntity.getPeriod(), false);
    zzb.zza(paramParcel, 7, paramDateTimeEntity.getDateRange(), false);
    zzb.zza(paramParcel, 8, paramDateTimeEntity.getAbsoluteTimeMs(), false);
    zzb.zza(paramParcel, 9, paramDateTimeEntity.getUnspecifiedFutureTime(), false);
    zzb.zza(paramParcel, 10, paramDateTimeEntity.getAllDay(), false);
    zzb.zzJ(paramParcel, i);
  }

  public DateTimeEntity zzkK(Parcel paramParcel)
  {
    Boolean localBoolean1 = null;
    int j = zza.zzcQ(paramParcel);
    int i = 0;
    Boolean localBoolean2 = null;
    Long localLong = null;
    Integer localInteger1 = null;
    Integer localInteger2 = null;
    TimeEntity localTimeEntity = null;
    Integer localInteger3 = null;
    Integer localInteger4 = null;
    Integer localInteger5 = null;
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
        localInteger5 = zza.zzh(paramParcel, k);
        break;
      case 3:
        localInteger4 = zza.zzh(paramParcel, k);
        break;
      case 4:
        localInteger3 = zza.zzh(paramParcel, k);
        break;
      case 5:
        localTimeEntity = (TimeEntity)zza.zza(paramParcel, k, TimeEntity.CREATOR);
        break;
      case 6:
        localInteger2 = zza.zzh(paramParcel, k);
        break;
      case 7:
        localInteger1 = zza.zzh(paramParcel, k);
        break;
      case 8:
        localLong = zza.zzj(paramParcel, k);
        break;
      case 9:
        localBoolean2 = zza.zzd(paramParcel, k);
        break;
      case 10:
        localBoolean1 = zza.zzd(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new DateTimeEntity(i, localInteger5, localInteger4, localInteger3, localTimeEntity, localInteger2, localInteger1, localLong, localBoolean2, localBoolean1);
  }

  public DateTimeEntity[] zzoo(int paramInt)
  {
    return new DateTimeEntity[paramInt];
  }
}
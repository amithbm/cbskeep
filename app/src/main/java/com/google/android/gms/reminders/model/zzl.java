package com.google.android.gms.reminders.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzl
  implements Parcelable.Creator<RecurrenceEntity>
{
  static void zza(RecurrenceEntity paramRecurrenceEntity, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zza(paramParcel, 2, paramRecurrenceEntity.getFrequency(), false);
    zzb.zza(paramParcel, 3, paramRecurrenceEntity.getEvery(), false);
    zzb.zza(paramParcel, 4, paramRecurrenceEntity.getRecurrenceStart(), paramInt, false);
    zzb.zza(paramParcel, 5, paramRecurrenceEntity.getRecurrenceEnd(), paramInt, false);
    zzb.zza(paramParcel, 6, paramRecurrenceEntity.getDailyPattern(), paramInt, false);
    zzb.zza(paramParcel, 7, paramRecurrenceEntity.getWeeklyPattern(), paramInt, false);
    zzb.zza(paramParcel, 8, paramRecurrenceEntity.getMonthlyPattern(), paramInt, false);
    zzb.zza(paramParcel, 9, paramRecurrenceEntity.getYearlyPattern(), paramInt, false);
    zzb.zzJ(paramParcel, i);
  }

  public RecurrenceEntity zzkQ(Parcel paramParcel)
  {
    YearlyPatternEntity localYearlyPatternEntity = null;
    int j = zza.zzcQ(paramParcel);
    int i = 0;
    MonthlyPatternEntity localMonthlyPatternEntity = null;
    WeeklyPatternEntity localWeeklyPatternEntity = null;
    DailyPatternEntity localDailyPatternEntity = null;
    RecurrenceEndEntity localRecurrenceEndEntity = null;
    RecurrenceStartEntity localRecurrenceStartEntity = null;
    Integer localInteger1 = null;
    Integer localInteger2 = null;
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
        localInteger2 = zza.zzh(paramParcel, k);
        break;
      case 3:
        localInteger1 = zza.zzh(paramParcel, k);
        break;
      case 4:
        localRecurrenceStartEntity = (RecurrenceStartEntity)zza.zza(paramParcel, k, RecurrenceStartEntity.CREATOR);
        break;
      case 5:
        localRecurrenceEndEntity = (RecurrenceEndEntity)zza.zza(paramParcel, k, RecurrenceEndEntity.CREATOR);
        break;
      case 6:
        localDailyPatternEntity = (DailyPatternEntity)zza.zza(paramParcel, k, DailyPatternEntity.CREATOR);
        break;
      case 7:
        localWeeklyPatternEntity = (WeeklyPatternEntity)zza.zza(paramParcel, k, WeeklyPatternEntity.CREATOR);
        break;
      case 8:
        localMonthlyPatternEntity = (MonthlyPatternEntity)zza.zza(paramParcel, k, MonthlyPatternEntity.CREATOR);
        break;
      case 9:
        localYearlyPatternEntity = (YearlyPatternEntity)zza.zza(paramParcel, k, YearlyPatternEntity.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new RecurrenceEntity(i, localInteger2, localInteger1, localRecurrenceStartEntity, localRecurrenceEndEntity, localDailyPatternEntity, localWeeklyPatternEntity, localMonthlyPatternEntity, localYearlyPatternEntity);
  }

  public RecurrenceEntity[] zzou(int paramInt)
  {
    return new RecurrenceEntity[paramInt];
  }
}
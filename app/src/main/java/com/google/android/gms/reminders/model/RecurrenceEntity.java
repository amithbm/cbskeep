package com.google.android.gms.reminders.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;

public class RecurrenceEntity
  implements SafeParcelable, Recurrence
{
  public static final Parcelable.Creator<RecurrenceEntity> CREATOR = new zzl();
  public final int mVersionCode;
  private final RecurrenceStartEntity zzboG;
  private final RecurrenceEndEntity zzboH;
  private final DailyPatternEntity zzboI;
  private final WeeklyPatternEntity zzboJ;
  private final MonthlyPatternEntity zzboK;
  private final YearlyPatternEntity zzboL;
  private final Integer zzbos;
  private final Integer zzbot;

  RecurrenceEntity(int paramInt, Integer paramInteger1, Integer paramInteger2, RecurrenceStartEntity paramRecurrenceStartEntity, RecurrenceEndEntity paramRecurrenceEndEntity, DailyPatternEntity paramDailyPatternEntity, WeeklyPatternEntity paramWeeklyPatternEntity, MonthlyPatternEntity paramMonthlyPatternEntity, YearlyPatternEntity paramYearlyPatternEntity)
  {
    zzbos = paramInteger1;
    zzbot = paramInteger2;
    zzboG = paramRecurrenceStartEntity;
    zzboH = paramRecurrenceEndEntity;
    zzboI = paramDailyPatternEntity;
    zzboJ = paramWeeklyPatternEntity;
    zzboK = paramMonthlyPatternEntity;
    zzboL = paramYearlyPatternEntity;
    mVersionCode = paramInt;
  }

  public RecurrenceEntity(Recurrence paramRecurrence)
  {
    this(paramRecurrence.getFrequency(), paramRecurrence.getEvery(), paramRecurrence.getRecurrenceStart(), paramRecurrence.getRecurrenceEnd(), paramRecurrence.getDailyPattern(), paramRecurrence.getWeeklyPattern(), paramRecurrence.getMonthlyPattern(), paramRecurrence.getYearlyPattern(), false);
  }

  RecurrenceEntity(Integer paramInteger1, Integer paramInteger2, RecurrenceStart paramRecurrenceStart, RecurrenceEnd paramRecurrenceEnd, DailyPattern paramDailyPattern, WeeklyPattern paramWeeklyPattern, MonthlyPattern paramMonthlyPattern, YearlyPattern paramYearlyPattern, boolean paramBoolean)
  {
    mVersionCode = 1;
    zzbos = paramInteger1;
    zzbot = paramInteger2;
    if (paramBoolean)
    {
      zzboG = ((RecurrenceStartEntity)paramRecurrenceStart);
      zzboH = ((RecurrenceEndEntity)paramRecurrenceEnd);
      zzboI = ((DailyPatternEntity)paramDailyPattern);
      zzboJ = ((WeeklyPatternEntity)paramWeeklyPattern);
      zzboK = ((MonthlyPatternEntity)paramMonthlyPattern);
      zzboL = ((YearlyPatternEntity)paramYearlyPattern);
      return;
    }
    if (paramRecurrenceStart == null)
    {
      paramInteger1 = null;
      zzboG = paramInteger1;
      if (paramRecurrenceEnd != null)
        break label166;
      paramInteger1 = null;
      label99: zzboH = paramInteger1;
      if (paramDailyPattern != null)
        break label179;
      paramInteger1 = null;
      label111: zzboI = paramInteger1;
      if (paramWeeklyPattern != null)
        break label192;
      paramInteger1 = null;
      label123: zzboJ = paramInteger1;
      if (paramMonthlyPattern != null)
        break label205;
      paramInteger1 = null;
      label135: zzboK = paramInteger1;
      if (paramYearlyPattern != null)
        break label218;
    }
    label166: label179: label192: label205: label218: for (paramInteger1 = localObject; ; paramInteger1 = new YearlyPatternEntity(paramYearlyPattern))
    {
      zzboL = paramInteger1;
      return;
      paramInteger1 = new RecurrenceStartEntity(paramRecurrenceStart);
      break;
      paramInteger1 = new RecurrenceEndEntity(paramRecurrenceEnd);
      break label99;
      paramInteger1 = new DailyPatternEntity(paramDailyPattern);
      break label111;
      paramInteger1 = new WeeklyPatternEntity(paramWeeklyPattern);
      break label123;
      paramInteger1 = new MonthlyPatternEntity(paramMonthlyPattern);
      break label135;
    }
  }

  public static boolean zza(Recurrence paramRecurrence1, Recurrence paramRecurrence2)
  {
    return (zzu.equal(paramRecurrence1.getFrequency(), paramRecurrence2.getFrequency())) && (zzu.equal(paramRecurrence1.getEvery(), paramRecurrence2.getEvery())) && (zzu.equal(paramRecurrence1.getRecurrenceStart(), paramRecurrence2.getRecurrenceStart())) && (zzu.equal(paramRecurrence1.getRecurrenceEnd(), paramRecurrence2.getRecurrenceEnd())) && (zzu.equal(paramRecurrence1.getDailyPattern(), paramRecurrence2.getDailyPattern())) && (zzu.equal(paramRecurrence1.getWeeklyPattern(), paramRecurrence2.getWeeklyPattern())) && (zzu.equal(paramRecurrence1.getMonthlyPattern(), paramRecurrence2.getMonthlyPattern())) && (zzu.equal(paramRecurrence1.getYearlyPattern(), paramRecurrence2.getYearlyPattern()));
  }

  public static int zzb(Recurrence paramRecurrence)
  {
    return zzu.hashCode(new Object[] { paramRecurrence.getFrequency(), paramRecurrence.getEvery(), paramRecurrence.getRecurrenceStart(), paramRecurrence.getRecurrenceEnd(), paramRecurrence.getDailyPattern(), paramRecurrence.getWeeklyPattern(), paramRecurrence.getMonthlyPattern(), paramRecurrence.getYearlyPattern() });
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof Recurrence))
      return false;
    if (this == paramObject)
      return true;
    return zza(this, (Recurrence)paramObject);
  }

  public DailyPattern getDailyPattern()
  {
    return zzboI;
  }

  public Integer getEvery()
  {
    return zzbot;
  }

  public Integer getFrequency()
  {
    return zzbos;
  }

  public MonthlyPattern getMonthlyPattern()
  {
    return zzboK;
  }

  public RecurrenceEnd getRecurrenceEnd()
  {
    return zzboH;
  }

  public RecurrenceStart getRecurrenceStart()
  {
    return zzboG;
  }

  public WeeklyPattern getWeeklyPattern()
  {
    return zzboJ;
  }

  public YearlyPattern getYearlyPattern()
  {
    return zzboL;
  }

  public int hashCode()
  {
    return zzb(this);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzl.zza(this, paramParcel, paramInt);
  }

  public Recurrence zzCn()
  {
    return this;
  }
}
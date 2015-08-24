package com.google.android.gms.reminders.model;

import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.common.internal.zzv;

public abstract interface Recurrence extends Parcelable, Freezable<Recurrence>
{
  public abstract DailyPattern getDailyPattern();

  public abstract Integer getEvery();

  public abstract Integer getFrequency();

  public abstract MonthlyPattern getMonthlyPattern();

  public abstract RecurrenceEnd getRecurrenceEnd();

  public abstract RecurrenceStart getRecurrenceStart();

  public abstract WeeklyPattern getWeeklyPattern();

  public abstract YearlyPattern getYearlyPattern();

  public static class Builder
  {
    private Integer zzbos;
    private Integer zzbot;
    private RecurrenceStart zzbou;
    private RecurrenceEnd zzbov;
    private DailyPattern zzbow;
    private WeeklyPattern zzbox;
    private MonthlyPattern zzboy;
    private YearlyPattern zzboz;

    public Builder()
    {
    }

    public Builder(Recurrence paramRecurrence)
    {
      zzbos = paramRecurrence.getFrequency();
      zzbot = paramRecurrence.getEvery();
      Object localObject1;
      if (paramRecurrence.getRecurrenceStart() == null)
      {
        localObject1 = null;
        zzbou = ((RecurrenceStart)localObject1);
        if (paramRecurrence.getRecurrenceEnd() != null)
          break label140;
        localObject1 = null;
        label53: zzbov = ((RecurrenceEnd)localObject1);
        if (paramRecurrence.getDailyPattern() != null)
          break label157;
        localObject1 = null;
        label69: zzbow = ((DailyPattern)localObject1);
        if (paramRecurrence.getWeeklyPattern() != null)
          break label174;
        localObject1 = null;
        label85: zzbox = ((WeeklyPattern)localObject1);
        if (paramRecurrence.getMonthlyPattern() != null)
          break label191;
        localObject1 = null;
        label101: zzboy = ((MonthlyPattern)localObject1);
        if (paramRecurrence.getYearlyPattern() != null)
          break label208;
      }
      label140: label157: label174: label191: label208: for (paramRecurrence = localObject2; ; paramRecurrence = new YearlyPatternEntity(paramRecurrence.getYearlyPattern()))
      {
        zzboz = paramRecurrence;
        return;
        localObject1 = new RecurrenceStartEntity(paramRecurrence.getRecurrenceStart());
        break;
        localObject1 = new RecurrenceEndEntity(paramRecurrence.getRecurrenceEnd());
        break label53;
        localObject1 = new DailyPatternEntity(paramRecurrence.getDailyPattern());
        break label69;
        localObject1 = new WeeklyPatternEntity(paramRecurrence.getWeeklyPattern());
        break label85;
        localObject1 = new MonthlyPatternEntity(paramRecurrence.getMonthlyPattern());
        break label101;
      }
    }

    public Recurrence build()
    {
      return new RecurrenceEntity(zzbos, zzbot, zzbou, zzbov, zzbow, zzbox, zzboy, zzboz, true);
    }

    public Builder setDailyPattern(DailyPattern paramDailyPattern)
    {
      if (paramDailyPattern != null);
      for (paramDailyPattern = (DailyPattern)paramDailyPattern.freeze(); ; paramDailyPattern = null)
      {
        zzbow = paramDailyPattern;
        return this;
      }
    }

    public Builder setEvery(Integer paramInteger)
    {
      zzbot = paramInteger;
      return this;
    }

    public Builder setFrequency(Integer paramInteger)
    {
      boolean bool2 = true;
      boolean bool1 = bool2;
      if (paramInteger != null)
      {
        bool1 = bool2;
        if (paramInteger.intValue() != 0)
        {
          bool1 = bool2;
          if (paramInteger.intValue() != 1)
          {
            bool1 = bool2;
            if (paramInteger.intValue() != 2)
              if (paramInteger.intValue() != 3)
                break label60;
          }
        }
      }
      label60: for (bool1 = bool2; ; bool1 = false)
      {
        zzv.zzb(bool1, "Invalid constant for Frequency. Use value in ModelConstants");
        zzbos = paramInteger;
        return this;
      }
    }

    public Builder setMonthlyPattern(MonthlyPattern paramMonthlyPattern)
    {
      if (paramMonthlyPattern != null);
      for (paramMonthlyPattern = (MonthlyPattern)paramMonthlyPattern.freeze(); ; paramMonthlyPattern = null)
      {
        zzboy = paramMonthlyPattern;
        return this;
      }
    }

    public Builder setRecurrenceEnd(RecurrenceEnd paramRecurrenceEnd)
    {
      if (paramRecurrenceEnd != null);
      for (paramRecurrenceEnd = (RecurrenceEnd)paramRecurrenceEnd.freeze(); ; paramRecurrenceEnd = null)
      {
        zzbov = paramRecurrenceEnd;
        return this;
      }
    }

    public Builder setRecurrenceStart(RecurrenceStart paramRecurrenceStart)
    {
      if (paramRecurrenceStart != null);
      for (paramRecurrenceStart = (RecurrenceStart)paramRecurrenceStart.freeze(); ; paramRecurrenceStart = null)
      {
        zzbou = paramRecurrenceStart;
        return this;
      }
    }

    public Builder setWeeklyPattern(WeeklyPattern paramWeeklyPattern)
    {
      if (paramWeeklyPattern != null);
      for (paramWeeklyPattern = (WeeklyPattern)paramWeeklyPattern.freeze(); ; paramWeeklyPattern = null)
      {
        zzbox = paramWeeklyPattern;
        return this;
      }
    }

    public Builder setYearlyPattern(YearlyPattern paramYearlyPattern)
    {
      if (paramYearlyPattern != null);
      for (paramYearlyPattern = (YearlyPattern)paramYearlyPattern.freeze(); ; paramYearlyPattern = null)
      {
        zzboz = paramYearlyPattern;
        return this;
      }
    }
  }
}
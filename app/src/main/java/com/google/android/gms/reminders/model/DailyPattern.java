package com.google.android.gms.reminders.model;

import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.common.internal.zzv;

public abstract interface DailyPattern extends Parcelable, Freezable<DailyPattern>
{
  public abstract Boolean getAllDay();

  public abstract Integer getDayPeriod();

  public abstract Time getTimeOfDay();

  public static class Builder
  {
    private Time zzbnJ;
    private Integer zzbnK;
    private Boolean zzbnL;

    public DailyPattern build()
    {
      return new DailyPatternEntity(zzbnJ, zzbnK, zzbnL, true);
    }

    public Builder setDayPeriod(Integer paramInteger)
    {
      boolean bool2 = true;
      boolean bool1 = bool2;
      if (paramInteger != null)
      {
        bool1 = bool2;
        if (paramInteger.intValue() != 1)
        {
          bool1 = bool2;
          if (paramInteger.intValue() != 2)
          {
            bool1 = bool2;
            if (paramInteger.intValue() != 3)
              if (paramInteger.intValue() != 4)
                break label61;
          }
        }
      }
      label61: for (bool1 = bool2; ; bool1 = false)
      {
        zzv.zzb(bool1, "Invalid constant for Period. Use value in ModelConstants");
        zzbnK = paramInteger;
        return this;
      }
    }

    public Builder setTimeOfDay(Time paramTime)
    {
      if (paramTime != null);
      for (paramTime = (Time)paramTime.freeze(); ; paramTime = null)
      {
        zzbnJ = paramTime;
        return this;
      }
    }
  }
}
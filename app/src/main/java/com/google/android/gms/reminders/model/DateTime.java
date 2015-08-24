package com.google.android.gms.reminders.model;

import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.common.internal.zzv;

public abstract interface DateTime extends Parcelable, Freezable<DateTime>
{
  public abstract Long getAbsoluteTimeMs();

  public abstract Boolean getAllDay();

  public abstract Integer getDateRange();

  public abstract Integer getDay();

  public abstract Integer getMonth();

  public abstract Integer getPeriod();

  public abstract Time getTime();

  public abstract Boolean getUnspecifiedFutureTime();

  public abstract Integer getYear();

  public static class Builder
  {
    private Boolean zzbnL;
    private Integer zzbnN;
    private Integer zzbnO;
    private Integer zzbnP;
    private Time zzbnQ;
    private Integer zzbnR;
    private Integer zzbnS;
    private Long zzbnT;
    private Boolean zzbnU;

    public Builder()
    {
    }

    public Builder(DateTime paramDateTime)
    {
      zzbnN = paramDateTime.getYear();
      zzbnO = paramDateTime.getMonth();
      zzbnP = paramDateTime.getDay();
      if (paramDateTime.getTime() == null);
      for (TimeEntity localTimeEntity = null; ; localTimeEntity = new TimeEntity(paramDateTime.getTime()))
      {
        zzbnQ = localTimeEntity;
        zzbnR = paramDateTime.getPeriod();
        zzbnS = paramDateTime.getDateRange();
        zzbnT = paramDateTime.getAbsoluteTimeMs();
        zzbnU = paramDateTime.getUnspecifiedFutureTime();
        zzbnL = paramDateTime.getAllDay();
        return;
      }
    }

    public DateTime build()
    {
      return new DateTimeEntity(zzbnN, zzbnO, zzbnP, zzbnQ, zzbnR, zzbnS, zzbnT, zzbnU, zzbnL, true);
    }

    public Builder setDay(Integer paramInteger)
    {
      zzbnP = paramInteger;
      return this;
    }

    public Builder setMonth(Integer paramInteger)
    {
      zzbnO = paramInteger;
      return this;
    }

    public Builder setPeriod(Integer paramInteger)
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
        zzbnR = paramInteger;
        return this;
      }
    }

    public Builder setTime(Time paramTime)
    {
      if (paramTime != null);
      for (paramTime = (Time)paramTime.freeze(); ; paramTime = null)
      {
        zzbnQ = paramTime;
        return this;
      }
    }

    public Builder setYear(Integer paramInteger)
    {
      zzbnN = paramInteger;
      return this;
    }
  }
}
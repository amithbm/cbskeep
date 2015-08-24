package com.google.android.gms.reminders.model;

import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.common.internal.zzv;
import java.util.ArrayList;
import java.util.List;

public abstract interface MonthlyPattern extends Parcelable, Freezable<MonthlyPattern>
{
  public abstract List<Integer> getMonthDay();

  public abstract Integer getWeekDay();

  public abstract Integer getWeekDayNumber();

  public static class Builder
  {
    private List<Integer> zzbop;
    private Integer zzboq;
    private Integer zzbor;

    public Builder addMonthDay(Integer[] paramArrayOfInteger)
    {
      if (zzbop == null)
        zzbop = new ArrayList();
      int j = paramArrayOfInteger.length;
      int i = 0;
      while (i < j)
      {
        Integer localInteger = paramArrayOfInteger[i];
        zzbop.add(localInteger);
        i += 1;
      }
      return this;
    }

    public MonthlyPattern build()
    {
      return new MonthlyPatternEntity(zzbop, zzboq, zzbor, true);
    }

    public Builder setWeekDay(Integer paramInteger)
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
            {
              bool1 = bool2;
              if (paramInteger.intValue() != 4)
              {
                bool1 = bool2;
                if (paramInteger.intValue() != 5)
                {
                  bool1 = bool2;
                  if (paramInteger.intValue() != 6)
                    if (paramInteger.intValue() != 7)
                      break label93;
                }
              }
            }
          }
        }
      }
      label93: for (bool1 = bool2; ; bool1 = false)
      {
        zzv.zzb(bool1, "Invalid constant for Weekday. Use value in ModelConstants");
        zzboq = paramInteger;
        return this;
      }
    }

    public Builder setWeekDayNumber(Integer paramInteger)
    {
      zzbor = paramInteger;
      return this;
    }
  }
}
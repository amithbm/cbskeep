package com.google.android.gms.reminders.model;

import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.common.internal.zzv;
import java.util.ArrayList;
import java.util.List;

public abstract interface WeeklyPattern extends Parcelable, Freezable<WeeklyPattern>
{
  public abstract List<Integer> getWeekDay();

  public static class Builder
  {
    private List<Integer> zzbpB;

    public Builder addWeekDay(Integer[] paramArrayOfInteger)
    {
      if (zzbpB == null)
        zzbpB = new ArrayList();
      int j = paramArrayOfInteger.length;
      int i = 0;
      if (i < j)
      {
        Integer localInteger = paramArrayOfInteger[i];
        if ((localInteger == null) || (localInteger.intValue() == 1) || (localInteger.intValue() == 2) || (localInteger.intValue() == 3) || (localInteger.intValue() == 4) || (localInteger.intValue() == 5) || (localInteger.intValue() == 6) || (localInteger.intValue() == 7));
        for (boolean bool = true; ; bool = false)
        {
          zzv.zzb(bool, "Invalid constant for Weekday. Use value in ModelConstants");
          zzbpB.add(localInteger);
          i += 1;
          break;
        }
      }
      return this;
    }

    public WeeklyPattern build()
    {
      return new WeeklyPatternEntity(zzbpB, true);
    }
  }
}
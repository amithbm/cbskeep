package com.google.android.gms.reminders.model;

import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.common.internal.zzv;
import java.util.ArrayList;
import java.util.List;

public abstract interface YearlyPattern extends Parcelable, Freezable<YearlyPattern>
{
  public abstract MonthlyPattern getMonthlyPattern();

  public abstract List<Integer> getYearMonth();

  public static class Builder
  {
    private MonthlyPattern zzboy;
    private List<Integer> zzbpC;

    public Builder addYearMonth(Integer[] paramArrayOfInteger)
    {
      if (zzbpC == null)
        zzbpC = new ArrayList();
      int j = paramArrayOfInteger.length;
      int i = 0;
      if (i < j)
      {
        Integer localInteger = paramArrayOfInteger[i];
        if ((localInteger == null) || (localInteger.intValue() == 1) || (localInteger.intValue() == 2) || (localInteger.intValue() == 3) || (localInteger.intValue() == 4) || (localInteger.intValue() == 5) || (localInteger.intValue() == 6) || (localInteger.intValue() == 7) || (localInteger.intValue() == 8) || (localInteger.intValue() == 9) || (localInteger.intValue() == 10) || (localInteger.intValue() == 11) || (localInteger.intValue() == 12));
        for (boolean bool = true; ; bool = false)
        {
          zzv.zzb(bool, "Invalid constant for Month. Use value in ModelConstants");
          zzbpC.add(localInteger);
          i += 1;
          break;
        }
      }
      return this;
    }

    public YearlyPattern build()
    {
      return new YearlyPatternEntity(zzboy, zzbpC, true);
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
  }
}
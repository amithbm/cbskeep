package com.google.android.gms.reminders.internal.ref;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.reminders.model.MonthlyPattern;
import com.google.android.gms.reminders.model.MonthlyPatternEntity;
import java.util.List;

public class MonthlyPatternRef extends zza
  implements MonthlyPattern
{
  public MonthlyPatternRef(DataHolder paramDataHolder, int paramInt, String paramString)
  {
    super(paramDataHolder, paramInt, paramString);
  }

  public static boolean zza(DataHolder paramDataHolder, int paramInt1, int paramInt2, String paramString)
  {
    return (paramDataHolder.zzj(zzT(paramString, "monthly_pattern_month_day"), paramInt1, paramInt2)) && (paramDataHolder.zzj(zzT(paramString, "monthly_pattern_week_day"), paramInt1, paramInt2)) && (paramDataHolder.zzj(zzT(paramString, "monthly_pattern_week_day_number"), paramInt1, paramInt2));
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof MonthlyPattern))
      return false;
    if (this == paramObject)
      return true;
    return MonthlyPatternEntity.zza(this, (MonthlyPattern)paramObject);
  }

  public List<Integer> getMonthDay()
  {
    return zzes(zzer("monthly_pattern_month_day"));
  }

  public Integer getWeekDay()
  {
    return getAsInteger(zzer("monthly_pattern_week_day"));
  }

  public Integer getWeekDayNumber()
  {
    return getAsInteger(zzer("monthly_pattern_week_day_number"));
  }

  public int hashCode()
  {
    return MonthlyPatternEntity.zza(this);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    new MonthlyPatternEntity(this).writeToParcel(paramParcel, paramInt);
  }

  public MonthlyPattern zzCk()
  {
    return new MonthlyPatternEntity(this);
  }
}
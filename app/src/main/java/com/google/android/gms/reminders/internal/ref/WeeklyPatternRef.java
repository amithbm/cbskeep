package com.google.android.gms.reminders.internal.ref;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.reminders.model.WeeklyPattern;
import com.google.android.gms.reminders.model.WeeklyPatternEntity;
import java.util.List;

public class WeeklyPatternRef extends zza
  implements WeeklyPattern
{
  public WeeklyPatternRef(DataHolder paramDataHolder, int paramInt, String paramString)
  {
    super(paramDataHolder, paramInt, paramString);
  }

  public static boolean zza(DataHolder paramDataHolder, int paramInt1, int paramInt2, String paramString)
  {
    return paramDataHolder.zzj(zzT(paramString, "weekly_pattern_weekday"), paramInt1, paramInt2);
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof WeeklyPattern))
      return false;
    if (this == paramObject)
      return true;
    return WeeklyPatternEntity.zza(this, (WeeklyPattern)paramObject);
  }

  public List<Integer> getWeekDay()
  {
    return zzes(zzer("weekly_pattern_weekday"));
  }

  public int hashCode()
  {
    return WeeklyPatternEntity.zza(this);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    new WeeklyPatternEntity(this).writeToParcel(paramParcel, paramInt);
  }

  public WeeklyPattern zzCs()
  {
    return new WeeklyPatternEntity(this);
  }
}
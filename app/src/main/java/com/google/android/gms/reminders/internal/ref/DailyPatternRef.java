package com.google.android.gms.reminders.internal.ref;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.reminders.model.DailyPattern;
import com.google.android.gms.reminders.model.DailyPatternEntity;
import com.google.android.gms.reminders.model.Time;

public class DailyPatternRef extends zza
  implements DailyPattern
{
  private boolean zzbmy = false;
  private TimeRef zzbmz;

  public DailyPatternRef(DataHolder paramDataHolder, int paramInt, String paramString)
  {
    super(paramDataHolder, paramInt, paramString);
  }

  public static boolean zza(DataHolder paramDataHolder, int paramInt1, int paramInt2, String paramString)
  {
    return (TimeRef.zza(paramDataHolder, paramInt1, paramInt2, paramString + "daily_pattern_")) && (paramDataHolder.zzj(zzT(paramString, "daily_pattern_period"), paramInt1, paramInt2)) && (paramDataHolder.zzj(zzT(paramString, "daily_pattern_all_day"), paramInt1, paramInt2));
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof DailyPattern))
      return false;
    if (this == paramObject)
      return true;
    return DailyPatternEntity.zza(this, (DailyPattern)paramObject);
  }

  public Boolean getAllDay()
  {
    return Boolean.valueOf(getBoolean(zzer("daily_pattern_all_day")));
  }

  public Integer getDayPeriod()
  {
    return getAsInteger(zzer("daily_pattern_period"));
  }

  public Time getTimeOfDay()
  {
    if (!zzbmy)
    {
      zzbmy = true;
      if (!TimeRef.zza(mDataHolder, zzaiZ, zzaja, zzbne + "daily_pattern_"))
        break label62;
    }
    label62: for (zzbmz = null; ; zzbmz = new TimeRef(mDataHolder, zzaiZ, zzbne + "daily_pattern_"))
      return zzbmz;
  }

  public int hashCode()
  {
    return DailyPatternEntity.zza(this);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    new DailyPatternEntity(this).writeToParcel(paramParcel, paramInt);
  }

  public DailyPattern zzCe()
  {
    return new DailyPatternEntity(this);
  }
}
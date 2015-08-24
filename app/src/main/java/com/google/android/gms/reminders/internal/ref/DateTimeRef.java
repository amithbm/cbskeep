package com.google.android.gms.reminders.internal.ref;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.reminders.model.DateTime;
import com.google.android.gms.reminders.model.DateTimeEntity;
import com.google.android.gms.reminders.model.Time;

public class DateTimeRef extends zza
  implements DateTime
{
  private boolean zzbmA = false;
  private TimeRef zzbmB;

  public DateTimeRef(DataHolder paramDataHolder, int paramInt, String paramString)
  {
    super(paramDataHolder, paramInt, paramString);
  }

  public static boolean zza(DataHolder paramDataHolder, int paramInt1, int paramInt2, String paramString)
  {
    return (paramDataHolder.zzj(zzT(paramString, "year"), paramInt1, paramInt2)) && (paramDataHolder.zzj(zzT(paramString, "month"), paramInt1, paramInt2)) && (paramDataHolder.zzj(zzT(paramString, "day"), paramInt1, paramInt2)) && (TimeRef.zza(paramDataHolder, paramInt1, paramInt2, paramString)) && (paramDataHolder.zzj(zzT(paramString, "period"), paramInt1, paramInt2)) && (paramDataHolder.zzj(zzT(paramString, "date_range"), paramInt1, paramInt2)) && (paramDataHolder.zzj(zzT(paramString, "absolute_time_ms"), paramInt1, paramInt2)) && (paramDataHolder.zzj(zzT(paramString, "unspecified_future_time"), paramInt1, paramInt2)) && (paramDataHolder.zzj(zzT(paramString, "all_day"), paramInt1, paramInt2));
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof DateTime))
      return false;
    if (this == paramObject)
      return true;
    return DateTimeEntity.zza(this, (DateTime)paramObject);
  }

  public Long getAbsoluteTimeMs()
  {
    return getAsLong(zzer("absolute_time_ms"));
  }

  public Boolean getAllDay()
  {
    return Boolean.valueOf(getBoolean(zzer("all_day")));
  }

  public Integer getDateRange()
  {
    return getAsInteger(zzer("date_range"));
  }

  public Integer getDay()
  {
    return getAsInteger(zzer("day"));
  }

  public Integer getMonth()
  {
    return getAsInteger(zzer("month"));
  }

  public Integer getPeriod()
  {
    return getAsInteger(zzer("period"));
  }

  public Time getTime()
  {
    if (!zzbmA)
    {
      zzbmA = true;
      if (!TimeRef.zza(mDataHolder, zzaiZ, zzaja, zzbne))
        break label44;
    }
    label44: for (zzbmB = null; ; zzbmB = new TimeRef(mDataHolder, zzaiZ, zzbne))
      return zzbmB;
  }

  public Boolean getUnspecifiedFutureTime()
  {
    return Boolean.valueOf(getBoolean(zzer("unspecified_future_time")));
  }

  public Integer getYear()
  {
    return getAsInteger(zzer("year"));
  }

  public int hashCode()
  {
    return DateTimeEntity.zzb(this);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    new DateTimeEntity(this).writeToParcel(paramParcel, paramInt);
  }

  public DateTime zzCf()
  {
    return new DateTimeEntity(this);
  }
}
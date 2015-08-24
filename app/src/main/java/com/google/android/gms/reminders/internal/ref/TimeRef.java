package com.google.android.gms.reminders.internal.ref;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.reminders.model.Time;
import com.google.android.gms.reminders.model.TimeEntity;

public class TimeRef extends zza
  implements Time
{
  public TimeRef(DataHolder paramDataHolder, int paramInt, String paramString)
  {
    super(paramDataHolder, paramInt, paramString);
  }

  public static boolean zza(DataHolder paramDataHolder, int paramInt1, int paramInt2, String paramString)
  {
    return (paramDataHolder.zzj(zzT(paramString, "hour"), paramInt1, paramInt2)) && (paramDataHolder.zzj(zzT(paramString, "minute"), paramInt1, paramInt2)) && (paramDataHolder.zzj(zzT(paramString, "second"), paramInt1, paramInt2));
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof Time))
      return false;
    if (this == paramObject)
      return true;
    return TimeEntity.zza(this, (Time)paramObject);
  }

  public Integer getHour()
  {
    return getAsInteger(zzer("hour"));
  }

  public Integer getMinute()
  {
    return getAsInteger(zzer("minute"));
  }

  public Integer getSecond()
  {
    return getAsInteger(zzer("second"));
  }

  public int hashCode()
  {
    return TimeEntity.zzc(this);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    new TimeEntity(this).writeToParcel(paramParcel, paramInt);
  }

  public Time zzCr()
  {
    return new TimeEntity(this);
  }
}
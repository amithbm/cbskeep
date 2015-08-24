package com.google.android.gms.reminders.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;

public class TimeEntity
  implements SafeParcelable, Time
{
  public static final Parcelable.Creator<TimeEntity> CREATOR = new zzs();
  public final int mVersionCode;
  private final Integer zzbpA;
  private final Integer zzbpy;
  private final Integer zzbpz;

  TimeEntity(int paramInt, Integer paramInteger1, Integer paramInteger2, Integer paramInteger3)
  {
    zzbpy = paramInteger1;
    zzbpz = paramInteger2;
    zzbpA = paramInteger3;
    mVersionCode = paramInt;
  }

  public TimeEntity(Time paramTime)
  {
    this(paramTime.getHour(), paramTime.getMinute(), paramTime.getSecond(), false);
  }

  TimeEntity(Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, boolean paramBoolean)
  {
    this(1, paramInteger1, paramInteger2, paramInteger3);
  }

  public static boolean zza(Time paramTime1, Time paramTime2)
  {
    return (zzu.equal(paramTime1.getHour(), paramTime2.getHour())) && (zzu.equal(paramTime1.getMinute(), paramTime2.getMinute())) && (zzu.equal(paramTime1.getSecond(), paramTime2.getSecond()));
  }

  public static int zzc(Time paramTime)
  {
    return zzu.hashCode(new Object[] { paramTime.getHour(), paramTime.getMinute(), paramTime.getSecond() });
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
    return zza(this, (Time)paramObject);
  }

  public Integer getHour()
  {
    return zzbpy;
  }

  public Integer getMinute()
  {
    return zzbpz;
  }

  public Integer getSecond()
  {
    return zzbpA;
  }

  public int hashCode()
  {
    return zzc(this);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzs.zza(this, paramParcel, paramInt);
  }

  public Time zzCr()
  {
    return this;
  }
}
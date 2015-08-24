package com.google.android.gms.reminders.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;

public class DateTimeEntity
  implements SafeParcelable, DateTime
{
  public static final Parcelable.Creator<DateTimeEntity> CREATOR = new zzf();
  public final int mVersionCode;
  private final Boolean zzbnL;
  private final Integer zzbnN;
  private final Integer zzbnO;
  private final Integer zzbnP;
  private final Integer zzbnR;
  private final Integer zzbnS;
  private final Long zzbnT;
  private final Boolean zzbnU;
  private final TimeEntity zzbnV;

  DateTimeEntity(int paramInt, Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, TimeEntity paramTimeEntity, Integer paramInteger4, Integer paramInteger5, Long paramLong, Boolean paramBoolean1, Boolean paramBoolean2)
  {
    zzbnN = paramInteger1;
    zzbnO = paramInteger2;
    zzbnP = paramInteger3;
    zzbnV = paramTimeEntity;
    zzbnR = paramInteger4;
    zzbnS = paramInteger5;
    zzbnT = paramLong;
    zzbnU = paramBoolean1;
    zzbnL = paramBoolean2;
    mVersionCode = paramInt;
  }

  public DateTimeEntity(DateTime paramDateTime)
  {
    this(paramDateTime.getYear(), paramDateTime.getMonth(), paramDateTime.getDay(), paramDateTime.getTime(), paramDateTime.getPeriod(), paramDateTime.getDateRange(), paramDateTime.getAbsoluteTimeMs(), paramDateTime.getUnspecifiedFutureTime(), paramDateTime.getAllDay(), false);
  }

  DateTimeEntity(Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, Time paramTime, Integer paramInteger4, Integer paramInteger5, Long paramLong, Boolean paramBoolean1, Boolean paramBoolean2, boolean paramBoolean)
  {
    mVersionCode = 2;
    zzbnN = paramInteger1;
    zzbnO = paramInteger2;
    zzbnP = paramInteger3;
    zzbnR = paramInteger4;
    zzbnS = paramInteger5;
    zzbnT = paramLong;
    zzbnU = paramBoolean1;
    zzbnL = paramBoolean2;
    if (paramBoolean)
    {
      zzbnV = ((TimeEntity)paramTime);
      return;
    }
    if (paramTime == null);
    for (paramInteger1 = null; ; paramInteger1 = new TimeEntity(paramTime))
    {
      zzbnV = paramInteger1;
      return;
    }
  }

  public static boolean zza(DateTime paramDateTime1, DateTime paramDateTime2)
  {
    return (zzu.equal(paramDateTime1.getYear(), paramDateTime2.getYear())) && (zzu.equal(paramDateTime1.getMonth(), paramDateTime2.getMonth())) && (zzu.equal(paramDateTime1.getDay(), paramDateTime2.getDay())) && (zzu.equal(paramDateTime1.getTime(), paramDateTime2.getTime())) && (zzu.equal(paramDateTime1.getPeriod(), paramDateTime2.getPeriod())) && (zzu.equal(paramDateTime1.getDateRange(), paramDateTime2.getDateRange())) && (zzu.equal(paramDateTime1.getAbsoluteTimeMs(), paramDateTime2.getAbsoluteTimeMs())) && (zzu.equal(paramDateTime1.getUnspecifiedFutureTime(), paramDateTime2.getUnspecifiedFutureTime())) && (zzu.equal(paramDateTime1.getAllDay(), paramDateTime2.getAllDay()));
  }

  public static int zzb(DateTime paramDateTime)
  {
    return zzu.hashCode(new Object[] { paramDateTime.getYear(), paramDateTime.getMonth(), paramDateTime.getDay(), paramDateTime.getTime(), paramDateTime.getPeriod(), paramDateTime.getDateRange(), paramDateTime.getAbsoluteTimeMs(), paramDateTime.getUnspecifiedFutureTime(), paramDateTime.getAllDay() });
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
    return zza(this, (DateTime)paramObject);
  }

  public Long getAbsoluteTimeMs()
  {
    return zzbnT;
  }

  public Boolean getAllDay()
  {
    return zzbnL;
  }

  public Integer getDateRange()
  {
    return zzbnS;
  }

  public Integer getDay()
  {
    return zzbnP;
  }

  public Integer getMonth()
  {
    return zzbnO;
  }

  public Integer getPeriod()
  {
    return zzbnR;
  }

  public Time getTime()
  {
    return zzbnV;
  }

  public Boolean getUnspecifiedFutureTime()
  {
    return zzbnU;
  }

  public Integer getYear()
  {
    return zzbnN;
  }

  public int hashCode()
  {
    return zzb(this);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzf.zza(this, paramParcel, paramInt);
  }

  public DateTime zzCf()
  {
    return this;
  }
}
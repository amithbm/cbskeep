package com.google.android.gms.reminders.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;

public class DailyPatternEntity
  implements SafeParcelable, DailyPattern
{
  public static final Parcelable.Creator<DailyPatternEntity> CREATOR = new zze();
  public final int mVersionCode;
  private final Integer zzbnK;
  private final Boolean zzbnL;
  private final TimeEntity zzbnM;

  DailyPatternEntity(int paramInt, TimeEntity paramTimeEntity, Integer paramInteger, Boolean paramBoolean)
  {
    zzbnM = paramTimeEntity;
    zzbnK = paramInteger;
    zzbnL = paramBoolean;
    mVersionCode = paramInt;
  }

  public DailyPatternEntity(DailyPattern paramDailyPattern)
  {
    this(paramDailyPattern.getTimeOfDay(), paramDailyPattern.getDayPeriod(), paramDailyPattern.getAllDay(), false);
  }

  DailyPatternEntity(Time paramTime, Integer paramInteger, Boolean paramBoolean, boolean paramBoolean1)
  {
    mVersionCode = 1;
    zzbnK = paramInteger;
    zzbnL = paramBoolean;
    if (paramBoolean1)
    {
      zzbnM = ((TimeEntity)paramTime);
      return;
    }
    if (paramTime == null);
    for (paramTime = null; ; paramTime = new TimeEntity(paramTime))
    {
      zzbnM = paramTime;
      return;
    }
  }

  public static int zza(DailyPattern paramDailyPattern)
  {
    return zzu.hashCode(new Object[] { paramDailyPattern.getTimeOfDay(), paramDailyPattern.getDayPeriod(), paramDailyPattern.getAllDay() });
  }

  public static boolean zza(DailyPattern paramDailyPattern1, DailyPattern paramDailyPattern2)
  {
    return (zzu.equal(paramDailyPattern1.getTimeOfDay(), paramDailyPattern2.getTimeOfDay())) && (zzu.equal(paramDailyPattern1.getDayPeriod(), paramDailyPattern2.getDayPeriod())) && (zzu.equal(paramDailyPattern1.getAllDay(), paramDailyPattern2.getAllDay()));
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
    return zza(this, (DailyPattern)paramObject);
  }

  public Boolean getAllDay()
  {
    return zzbnL;
  }

  public Integer getDayPeriod()
  {
    return zzbnK;
  }

  public Time getTimeOfDay()
  {
    return zzbnM;
  }

  public int hashCode()
  {
    return zza(this);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zze.zza(this, paramParcel, paramInt);
  }

  public DailyPattern zzCe()
  {
    return this;
  }
}
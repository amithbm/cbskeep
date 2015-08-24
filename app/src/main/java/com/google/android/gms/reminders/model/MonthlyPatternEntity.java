package com.google.android.gms.reminders.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import java.util.ArrayList;
import java.util.List;

public class MonthlyPatternEntity
  implements SafeParcelable, MonthlyPattern
{
  public static final Parcelable.Creator<MonthlyPatternEntity> CREATOR = new zzk();
  public final int mVersionCode;
  private final List<Integer> zzbop;
  private final Integer zzboq;
  private final Integer zzbor;

  MonthlyPatternEntity(int paramInt, List<Integer> paramList, Integer paramInteger1, Integer paramInteger2)
  {
    zzbop = paramList;
    zzboq = paramInteger1;
    zzbor = paramInteger2;
    mVersionCode = paramInt;
  }

  public MonthlyPatternEntity(MonthlyPattern paramMonthlyPattern)
  {
    this(paramMonthlyPattern.getMonthDay(), paramMonthlyPattern.getWeekDay(), paramMonthlyPattern.getWeekDayNumber(), false);
  }

  MonthlyPatternEntity(List<Integer> paramList, Integer paramInteger1, Integer paramInteger2, boolean paramBoolean)
  {
    mVersionCode = 1;
    zzboq = paramInteger1;
    zzbor = paramInteger2;
    if (paramBoolean)
    {
      zzbop = paramList;
      return;
    }
    if (paramList == null);
    for (paramList = null; ; paramList = new ArrayList(paramList))
    {
      zzbop = paramList;
      return;
    }
  }

  public static int zza(MonthlyPattern paramMonthlyPattern)
  {
    return zzu.hashCode(new Object[] { paramMonthlyPattern.getMonthDay(), paramMonthlyPattern.getWeekDay(), paramMonthlyPattern.getWeekDayNumber() });
  }

  public static boolean zza(MonthlyPattern paramMonthlyPattern1, MonthlyPattern paramMonthlyPattern2)
  {
    return (zzu.equal(paramMonthlyPattern1.getMonthDay(), paramMonthlyPattern2.getMonthDay())) && (zzu.equal(paramMonthlyPattern1.getWeekDay(), paramMonthlyPattern2.getWeekDay())) && (zzu.equal(paramMonthlyPattern1.getWeekDayNumber(), paramMonthlyPattern2.getWeekDayNumber()));
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
    return zza(this, (MonthlyPattern)paramObject);
  }

  public List<Integer> getMonthDay()
  {
    return zzbop;
  }

  public Integer getWeekDay()
  {
    return zzboq;
  }

  public Integer getWeekDayNumber()
  {
    return zzbor;
  }

  public int hashCode()
  {
    return zza(this);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzk.zza(this, paramParcel, paramInt);
  }

  public MonthlyPattern zzCk()
  {
    return this;
  }
}
package com.google.android.gms.reminders.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import java.util.ArrayList;
import java.util.List;

public class WeeklyPatternEntity
  implements SafeParcelable, WeeklyPattern
{
  public static final Parcelable.Creator<WeeklyPatternEntity> CREATOR = new zzt();
  public final int mVersionCode;
  private final List<Integer> zzbpB;

  WeeklyPatternEntity(int paramInt, List<Integer> paramList)
  {
    zzbpB = paramList;
    mVersionCode = paramInt;
  }

  public WeeklyPatternEntity(WeeklyPattern paramWeeklyPattern)
  {
    this(paramWeeklyPattern.getWeekDay(), false);
  }

  WeeklyPatternEntity(List<Integer> paramList, boolean paramBoolean)
  {
    mVersionCode = 1;
    if (paramBoolean)
    {
      zzbpB = paramList;
      return;
    }
    if (paramList == null);
    for (paramList = null; ; paramList = new ArrayList(paramList))
    {
      zzbpB = paramList;
      return;
    }
  }

  public static int zza(WeeklyPattern paramWeeklyPattern)
  {
    return zzu.hashCode(new Object[] { paramWeeklyPattern.getWeekDay() });
  }

  public static boolean zza(WeeklyPattern paramWeeklyPattern1, WeeklyPattern paramWeeklyPattern2)
  {
    return zzu.equal(paramWeeklyPattern1.getWeekDay(), paramWeeklyPattern2.getWeekDay());
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
    return zza(this, (WeeklyPattern)paramObject);
  }

  public List<Integer> getWeekDay()
  {
    return zzbpB;
  }

  public int hashCode()
  {
    return zza(this);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzt.zza(this, paramParcel, paramInt);
  }

  public WeeklyPattern zzCs()
  {
    return this;
  }
}
package com.google.android.gms.reminders.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.List;

public class YearlyPatternEntity
  implements SafeParcelable, YearlyPattern
{
  public static final Parcelable.Creator<YearlyPatternEntity> CREATOR = new zzu();
  public final int mVersionCode;
  private final MonthlyPatternEntity zzboK;
  private final List<Integer> zzbpC;

  YearlyPatternEntity(int paramInt, MonthlyPatternEntity paramMonthlyPatternEntity, List<Integer> paramList)
  {
    zzboK = paramMonthlyPatternEntity;
    zzbpC = paramList;
    mVersionCode = paramInt;
  }

  YearlyPatternEntity(MonthlyPattern paramMonthlyPattern, List<Integer> paramList, boolean paramBoolean)
  {
    mVersionCode = 1;
    if (paramBoolean)
    {
      zzboK = ((MonthlyPatternEntity)paramMonthlyPattern);
      zzbpC = paramList;
      return;
    }
    if (paramMonthlyPattern == null)
    {
      paramMonthlyPattern = null;
      zzboK = paramMonthlyPattern;
      if (paramList != null)
        break label66;
    }
    label66: for (paramMonthlyPattern = localObject; ; paramMonthlyPattern = new ArrayList(paramList))
    {
      zzbpC = paramMonthlyPattern;
      return;
      paramMonthlyPattern = new MonthlyPatternEntity(paramMonthlyPattern);
      break;
    }
  }

  public YearlyPatternEntity(YearlyPattern paramYearlyPattern)
  {
    this(paramYearlyPattern.getMonthlyPattern(), paramYearlyPattern.getYearMonth(), false);
  }

  public static int zza(YearlyPattern paramYearlyPattern)
  {
    return com.google.android.gms.common.internal.zzu.hashCode(new Object[] { paramYearlyPattern.getMonthlyPattern(), paramYearlyPattern.getYearMonth() });
  }

  public static boolean zza(YearlyPattern paramYearlyPattern1, YearlyPattern paramYearlyPattern2)
  {
    return (com.google.android.gms.common.internal.zzu.equal(paramYearlyPattern1.getMonthlyPattern(), paramYearlyPattern2.getMonthlyPattern())) && (com.google.android.gms.common.internal.zzu.equal(paramYearlyPattern1.getYearMonth(), paramYearlyPattern2.getYearMonth()));
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof YearlyPattern))
      return false;
    if (this == paramObject)
      return true;
    return zza(this, (YearlyPattern)paramObject);
  }

  public MonthlyPattern getMonthlyPattern()
  {
    return zzboK;
  }

  public List<Integer> getYearMonth()
  {
    return zzbpC;
  }

  public int hashCode()
  {
    return zza(this);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzu.zza(this, paramParcel, paramInt);
  }

  public YearlyPattern zzCt()
  {
    return this;
  }
}
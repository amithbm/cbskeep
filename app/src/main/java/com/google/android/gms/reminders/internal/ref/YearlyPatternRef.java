package com.google.android.gms.reminders.internal.ref;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.reminders.model.MonthlyPattern;
import com.google.android.gms.reminders.model.YearlyPattern;
import com.google.android.gms.reminders.model.YearlyPatternEntity;
import java.util.List;

public class YearlyPatternRef extends zza
  implements YearlyPattern
{
  private boolean zzbmY = false;
  private MonthlyPatternRef zzbmZ;

  public YearlyPatternRef(DataHolder paramDataHolder, int paramInt, String paramString)
  {
    super(paramDataHolder, paramInt, paramString);
  }

  public static boolean zza(DataHolder paramDataHolder, int paramInt1, int paramInt2, String paramString)
  {
    return (MonthlyPatternRef.zza(paramDataHolder, paramInt1, paramInt2, paramString + "yearly_pattern_")) && (paramDataHolder.zzj(zzT(paramString, "yearly_pattern_year_month"), paramInt1, paramInt2));
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
    return YearlyPatternEntity.zza(this, (YearlyPattern)paramObject);
  }

  public MonthlyPattern getMonthlyPattern()
  {
    if (!zzbmY)
    {
      zzbmY = true;
      if (!MonthlyPatternRef.zza(mDataHolder, zzaiZ, zzaja, zzbne + "yearly_pattern_"))
        break label62;
    }
    label62: for (zzbmZ = null; ; zzbmZ = new MonthlyPatternRef(mDataHolder, zzaiZ, zzbne + "yearly_pattern_"))
      return zzbmZ;
  }

  public List<Integer> getYearMonth()
  {
    return zzes(zzer("yearly_pattern_year_month"));
  }

  public int hashCode()
  {
    return YearlyPatternEntity.zza(this);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    new YearlyPatternEntity(this).writeToParcel(paramParcel, paramInt);
  }

  public YearlyPattern zzCt()
  {
    return new YearlyPatternEntity(this);
  }
}
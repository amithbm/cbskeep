package com.google.android.gms.reminders.internal.ref;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.reminders.model.DailyPattern;
import com.google.android.gms.reminders.model.MonthlyPattern;
import com.google.android.gms.reminders.model.Recurrence;
import com.google.android.gms.reminders.model.RecurrenceEnd;
import com.google.android.gms.reminders.model.RecurrenceEntity;
import com.google.android.gms.reminders.model.RecurrenceStart;
import com.google.android.gms.reminders.model.WeeklyPattern;
import com.google.android.gms.reminders.model.YearlyPattern;

public class RecurrenceRef extends zza
  implements Recurrence
{
  private boolean zzbmQ = false;
  private RecurrenceStartRef zzbmR;
  private boolean zzbmS = false;
  private RecurrenceEndRef zzbmT;
  private boolean zzbmU = false;
  private DailyPatternRef zzbmV;
  private boolean zzbmW = false;
  private WeeklyPatternRef zzbmX;
  private boolean zzbmY = false;
  private MonthlyPatternRef zzbmZ;
  private boolean zzbna = false;
  private YearlyPatternRef zzbnb;

  public RecurrenceRef(DataHolder paramDataHolder, int paramInt, String paramString)
  {
    super(paramDataHolder, paramInt, paramString);
  }

  public static boolean zza(DataHolder paramDataHolder, int paramInt1, int paramInt2, String paramString)
  {
    return (paramDataHolder.zzj(zzT(paramString, "recurrence_frequency"), paramInt1, paramInt2)) && (paramDataHolder.zzj(zzT(paramString, "recurrence_every"), paramInt1, paramInt2)) && (RecurrenceStartRef.zza(paramDataHolder, paramInt1, paramInt2, paramString)) && (RecurrenceEndRef.zza(paramDataHolder, paramInt1, paramInt2, paramString)) && (DailyPatternRef.zza(paramDataHolder, paramInt1, paramInt2, paramString)) && (WeeklyPatternRef.zza(paramDataHolder, paramInt1, paramInt2, paramString)) && (MonthlyPatternRef.zza(paramDataHolder, paramInt1, paramInt2, paramString)) && (YearlyPatternRef.zza(paramDataHolder, paramInt1, paramInt2, paramString));
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof Recurrence))
      return false;
    if (this == paramObject)
      return true;
    return RecurrenceEntity.zza(this, (Recurrence)paramObject);
  }

  public DailyPattern getDailyPattern()
  {
    if (!zzbmU)
    {
      zzbmU = true;
      if (!DailyPatternRef.zza(mDataHolder, zzaiZ, zzaja, zzbne))
        break label44;
    }
    label44: for (zzbmV = null; ; zzbmV = new DailyPatternRef(mDataHolder, zzaiZ, zzbne))
      return zzbmV;
  }

  public Integer getEvery()
  {
    return getAsInteger(zzer("recurrence_every"));
  }

  public Integer getFrequency()
  {
    return getAsInteger(zzer("recurrence_frequency"));
  }

  public MonthlyPattern getMonthlyPattern()
  {
    if (!zzbmY)
    {
      zzbmY = true;
      if (!MonthlyPatternRef.zza(mDataHolder, zzaiZ, zzaja, zzbne))
        break label44;
    }
    label44: for (zzbmZ = null; ; zzbmZ = new MonthlyPatternRef(mDataHolder, zzaiZ, zzbne))
      return zzbmZ;
  }

  public RecurrenceEnd getRecurrenceEnd()
  {
    if (!zzbmS)
    {
      zzbmS = true;
      if (!RecurrenceEndRef.zza(mDataHolder, zzaiZ, zzaja, zzbne))
        break label44;
    }
    label44: for (zzbmT = null; ; zzbmT = new RecurrenceEndRef(mDataHolder, zzaiZ, zzbne))
      return zzbmT;
  }

  public RecurrenceStart getRecurrenceStart()
  {
    if (!zzbmQ)
    {
      zzbmQ = true;
      if (!RecurrenceStartRef.zza(mDataHolder, zzaiZ, zzaja, zzbne))
        break label44;
    }
    label44: for (zzbmR = null; ; zzbmR = new RecurrenceStartRef(mDataHolder, zzaiZ, zzbne))
      return zzbmR;
  }

  public WeeklyPattern getWeeklyPattern()
  {
    if (!zzbmW)
    {
      zzbmW = true;
      if (!WeeklyPatternRef.zza(mDataHolder, zzaiZ, zzaja, zzbne))
        break label44;
    }
    label44: for (zzbmX = null; ; zzbmX = new WeeklyPatternRef(mDataHolder, zzaiZ, zzbne))
      return zzbmX;
  }

  public YearlyPattern getYearlyPattern()
  {
    if (!zzbna)
    {
      zzbna = true;
      if (!YearlyPatternRef.zza(mDataHolder, zzaiZ, zzaja, zzbne))
        break label44;
    }
    label44: for (zzbnb = null; ; zzbnb = new YearlyPatternRef(mDataHolder, zzaiZ, zzbne))
      return zzbnb;
  }

  public int hashCode()
  {
    return RecurrenceEntity.zzb(this);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    new RecurrenceEntity(this).writeToParcel(paramParcel, paramInt);
  }

  public Recurrence zzCn()
  {
    return new RecurrenceEntity(this);
  }
}
package com.google.android.gms.reminders.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;

public class RecurrenceInfoEntity
  implements SafeParcelable, RecurrenceInfo
{
  public static final Parcelable.Creator<RecurrenceInfoEntity> CREATOR = new zzn();
  public final int mVersionCode;
  private final String zzboN;
  private final Boolean zzboO;
  private final Boolean zzboP;
  private final RecurrenceEntity zzboQ;

  RecurrenceInfoEntity(int paramInt, RecurrenceEntity paramRecurrenceEntity, String paramString, Boolean paramBoolean1, Boolean paramBoolean2)
  {
    zzboQ = paramRecurrenceEntity;
    zzboN = paramString;
    zzboO = paramBoolean1;
    zzboP = paramBoolean2;
    mVersionCode = paramInt;
  }

  RecurrenceInfoEntity(Recurrence paramRecurrence, String paramString, Boolean paramBoolean1, Boolean paramBoolean2, boolean paramBoolean)
  {
    mVersionCode = 1;
    zzboN = paramString;
    zzboO = paramBoolean1;
    zzboP = paramBoolean2;
    if (paramBoolean)
    {
      zzboQ = ((RecurrenceEntity)paramRecurrence);
      return;
    }
    if (paramRecurrence == null);
    for (paramRecurrence = null; ; paramRecurrence = new RecurrenceEntity(paramRecurrence))
    {
      zzboQ = paramRecurrence;
      return;
    }
  }

  public RecurrenceInfoEntity(RecurrenceInfo paramRecurrenceInfo)
  {
    this(paramRecurrenceInfo.getRecurrence(), paramRecurrenceInfo.getRecurrenceId(), paramRecurrenceInfo.getMaster(), paramRecurrenceInfo.getExceptional(), false);
  }

  public static int zza(RecurrenceInfo paramRecurrenceInfo)
  {
    return zzu.hashCode(new Object[] { paramRecurrenceInfo.getRecurrence(), paramRecurrenceInfo.getRecurrenceId(), paramRecurrenceInfo.getMaster(), paramRecurrenceInfo.getExceptional() });
  }

  public static boolean zza(RecurrenceInfo paramRecurrenceInfo1, RecurrenceInfo paramRecurrenceInfo2)
  {
    return (zzu.equal(paramRecurrenceInfo1.getRecurrence(), paramRecurrenceInfo2.getRecurrence())) && (zzu.equal(paramRecurrenceInfo1.getRecurrenceId(), paramRecurrenceInfo2.getRecurrenceId())) && (zzu.equal(paramRecurrenceInfo1.getMaster(), paramRecurrenceInfo2.getMaster())) && (zzu.equal(paramRecurrenceInfo1.getExceptional(), paramRecurrenceInfo2.getExceptional()));
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof RecurrenceInfo))
      return false;
    if (this == paramObject)
      return true;
    return zza(this, (RecurrenceInfo)paramObject);
  }

  public Boolean getExceptional()
  {
    return zzboP;
  }

  public Boolean getMaster()
  {
    return zzboO;
  }

  public Recurrence getRecurrence()
  {
    return zzboQ;
  }

  public String getRecurrenceId()
  {
    return zzboN;
  }

  public int hashCode()
  {
    return zza(this);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzn.zza(this, paramParcel, paramInt);
  }

  public RecurrenceInfo zzCm()
  {
    return this;
  }
}
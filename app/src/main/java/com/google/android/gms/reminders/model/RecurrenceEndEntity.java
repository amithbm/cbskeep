package com.google.android.gms.reminders.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;

public class RecurrenceEndEntity
  implements SafeParcelable, RecurrenceEnd
{
  public static final Parcelable.Creator<RecurrenceEndEntity> CREATOR = new zzm();
  public final int mVersionCode;
  private final Integer zzboB;
  private final Boolean zzboC;
  private final DateTimeEntity zzboE;
  private final DateTimeEntity zzboF;

  RecurrenceEndEntity(int paramInt, DateTimeEntity paramDateTimeEntity1, Integer paramInteger, Boolean paramBoolean, DateTimeEntity paramDateTimeEntity2)
  {
    zzboE = paramDateTimeEntity1;
    zzboB = paramInteger;
    zzboC = paramBoolean;
    zzboF = paramDateTimeEntity2;
    mVersionCode = paramInt;
  }

  RecurrenceEndEntity(DateTime paramDateTime1, Integer paramInteger, Boolean paramBoolean, DateTime paramDateTime2, boolean paramBoolean1)
  {
    mVersionCode = 1;
    zzboB = paramInteger;
    zzboC = paramBoolean;
    if (paramBoolean1)
    {
      zzboE = ((DateTimeEntity)paramDateTime1);
      zzboF = ((DateTimeEntity)paramDateTime2);
      return;
    }
    if (paramDateTime1 == null)
    {
      paramDateTime1 = null;
      zzboE = paramDateTime1;
      if (paramDateTime2 != null)
        break label82;
    }
    label82: for (paramDateTime1 = localObject; ; paramDateTime1 = new DateTimeEntity(paramDateTime2))
    {
      zzboF = paramDateTime1;
      return;
      paramDateTime1 = new DateTimeEntity(paramDateTime1);
      break;
    }
  }

  public RecurrenceEndEntity(RecurrenceEnd paramRecurrenceEnd)
  {
    this(paramRecurrenceEnd.getEndDateTime(), paramRecurrenceEnd.getNumOccurrences(), paramRecurrenceEnd.getAutoRenew(), paramRecurrenceEnd.getAutoRenewUntil(), false);
  }

  public static int zza(RecurrenceEnd paramRecurrenceEnd)
  {
    return zzu.hashCode(new Object[] { paramRecurrenceEnd.getEndDateTime(), paramRecurrenceEnd.getNumOccurrences(), paramRecurrenceEnd.getAutoRenew(), paramRecurrenceEnd.getAutoRenewUntil() });
  }

  public static boolean zza(RecurrenceEnd paramRecurrenceEnd1, RecurrenceEnd paramRecurrenceEnd2)
  {
    return (zzu.equal(paramRecurrenceEnd1.getEndDateTime(), paramRecurrenceEnd2.getEndDateTime())) && (zzu.equal(paramRecurrenceEnd1.getNumOccurrences(), paramRecurrenceEnd2.getNumOccurrences())) && (zzu.equal(paramRecurrenceEnd1.getAutoRenew(), paramRecurrenceEnd2.getAutoRenew())) && (zzu.equal(paramRecurrenceEnd1.getAutoRenewUntil(), paramRecurrenceEnd2.getAutoRenewUntil()));
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof RecurrenceEnd))
      return false;
    if (this == paramObject)
      return true;
    return zza(this, (RecurrenceEnd)paramObject);
  }

  public Boolean getAutoRenew()
  {
    return zzboC;
  }

  public DateTime getAutoRenewUntil()
  {
    return zzboF;
  }

  public DateTime getEndDateTime()
  {
    return zzboE;
  }

  public Integer getNumOccurrences()
  {
    return zzboB;
  }

  public int hashCode()
  {
    return zza(this);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzm.zza(this, paramParcel, paramInt);
  }

  public RecurrenceEnd zzCl()
  {
    return this;
  }
}
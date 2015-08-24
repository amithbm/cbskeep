package com.google.android.gms.reminders.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;

public class RecurrenceStartEntity
  implements SafeParcelable, RecurrenceStart
{
  public static final Parcelable.Creator<RecurrenceStartEntity> CREATOR = new zzo();
  public final int mVersionCode;
  private final DateTimeEntity zzboS;

  RecurrenceStartEntity(int paramInt, DateTimeEntity paramDateTimeEntity)
  {
    zzboS = paramDateTimeEntity;
    mVersionCode = paramInt;
  }

  RecurrenceStartEntity(DateTime paramDateTime, boolean paramBoolean)
  {
    mVersionCode = 1;
    if (paramBoolean)
    {
      zzboS = ((DateTimeEntity)paramDateTime);
      return;
    }
    if (paramDateTime == null);
    for (paramDateTime = null; ; paramDateTime = new DateTimeEntity(paramDateTime))
    {
      zzboS = paramDateTime;
      return;
    }
  }

  public RecurrenceStartEntity(RecurrenceStart paramRecurrenceStart)
  {
    this(paramRecurrenceStart.getStartDateTime(), false);
  }

  public static int zza(RecurrenceStart paramRecurrenceStart)
  {
    return zzu.hashCode(new Object[] { paramRecurrenceStart.getStartDateTime() });
  }

  public static boolean zza(RecurrenceStart paramRecurrenceStart1, RecurrenceStart paramRecurrenceStart2)
  {
    return zzu.equal(paramRecurrenceStart1.getStartDateTime(), paramRecurrenceStart2.getStartDateTime());
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof RecurrenceStart))
      return false;
    if (this == paramObject)
      return true;
    return zza(this, (RecurrenceStart)paramObject);
  }

  public DateTime getStartDateTime()
  {
    return zzboS;
  }

  public int hashCode()
  {
    return zza(this);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzo.zza(this, paramParcel, paramInt);
  }

  public RecurrenceStart zzCo()
  {
    return this;
  }
}
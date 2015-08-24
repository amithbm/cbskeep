package com.google.android.gms.reminders.model;

import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;

public abstract interface RecurrenceEnd extends Parcelable, Freezable<RecurrenceEnd>
{
  public abstract Boolean getAutoRenew();

  public abstract DateTime getAutoRenewUntil();

  public abstract DateTime getEndDateTime();

  public abstract Integer getNumOccurrences();

  public static class Builder
  {
    private DateTime zzboA;
    private Integer zzboB;
    private Boolean zzboC;
    private DateTime zzboD;

    public Builder()
    {
    }

    public Builder(RecurrenceEnd paramRecurrenceEnd)
    {
      DateTimeEntity localDateTimeEntity;
      if (paramRecurrenceEnd.getEndDateTime() == null)
      {
        localDateTimeEntity = null;
        zzboA = localDateTimeEntity;
        zzboB = paramRecurrenceEnd.getNumOccurrences();
        zzboC = paramRecurrenceEnd.getAutoRenew();
        if (paramRecurrenceEnd.getAutoRenewUntil() != null)
          break label76;
      }
      label76: for (paramRecurrenceEnd = localObject; ; paramRecurrenceEnd = new DateTimeEntity(paramRecurrenceEnd.getAutoRenewUntil()))
      {
        zzboD = paramRecurrenceEnd;
        return;
        localDateTimeEntity = new DateTimeEntity(paramRecurrenceEnd.getEndDateTime());
        break;
      }
    }

    public RecurrenceEnd build()
    {
      return new RecurrenceEndEntity(zzboA, zzboB, zzboC, zzboD, true);
    }

    public Builder setAutoRenew(Boolean paramBoolean)
    {
      zzboC = paramBoolean;
      return this;
    }

    public Builder setAutoRenewUntil(DateTime paramDateTime)
    {
      if (paramDateTime != null);
      for (paramDateTime = (DateTime)paramDateTime.freeze(); ; paramDateTime = null)
      {
        zzboD = paramDateTime;
        return this;
      }
    }

    public Builder setEndDateTime(DateTime paramDateTime)
    {
      if (paramDateTime != null);
      for (paramDateTime = (DateTime)paramDateTime.freeze(); ; paramDateTime = null)
      {
        zzboA = paramDateTime;
        return this;
      }
    }

    public Builder setNumOccurrences(Integer paramInteger)
    {
      zzboB = paramInteger;
      return this;
    }
  }
}
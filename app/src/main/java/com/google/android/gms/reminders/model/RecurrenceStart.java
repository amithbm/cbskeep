package com.google.android.gms.reminders.model;

import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;

public abstract interface RecurrenceStart extends Parcelable, Freezable<RecurrenceStart>
{
  public abstract DateTime getStartDateTime();

  public static class Builder
  {
    private DateTime zzboR;

    public RecurrenceStart build()
    {
      return new RecurrenceStartEntity(zzboR, true);
    }

    public Builder setStartDateTime(DateTime paramDateTime)
    {
      if (paramDateTime != null);
      for (paramDateTime = (DateTime)paramDateTime.freeze(); ; paramDateTime = null)
      {
        zzboR = paramDateTime;
        return this;
      }
    }
  }
}
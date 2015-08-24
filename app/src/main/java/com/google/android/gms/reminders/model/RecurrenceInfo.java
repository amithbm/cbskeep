package com.google.android.gms.reminders.model;

import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;

public abstract interface RecurrenceInfo extends Parcelable, Freezable<RecurrenceInfo>
{
  public abstract Boolean getExceptional();

  public abstract Boolean getMaster();

  public abstract Recurrence getRecurrence();

  public abstract String getRecurrenceId();

  public static class Builder
  {
    private Recurrence zzboM;
    private String zzboN;
    private Boolean zzboO;
    private Boolean zzboP;

    public RecurrenceInfo build()
    {
      return new RecurrenceInfoEntity(zzboM, zzboN, zzboO, zzboP, true);
    }

    public Builder setRecurrence(Recurrence paramRecurrence)
    {
      if (paramRecurrence != null);
      for (paramRecurrence = (Recurrence)paramRecurrence.freeze(); ; paramRecurrence = null)
      {
        zzboM = paramRecurrence;
        return this;
      }
    }

    public Builder setRecurrenceId(String paramString)
    {
      zzboN = paramString;
      return this;
    }
  }
}
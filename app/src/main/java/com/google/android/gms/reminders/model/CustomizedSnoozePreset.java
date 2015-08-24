package com.google.android.gms.reminders.model;

import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;

public abstract interface CustomizedSnoozePreset extends Parcelable, Freezable<CustomizedSnoozePreset>
{
  public abstract Time getAfternoonCustomizedTime();

  public abstract Time getEveningCustomizedTime();

  public abstract Time getMorningCustomizedTime();

  public static class Builder
  {
    private Time zzbnD;
    private Time zzbnE;
    private Time zzbnF;

    public CustomizedSnoozePreset build()
    {
      return new CustomizedSnoozePresetEntity(zzbnD, zzbnE, zzbnF, true);
    }

    public Builder setAfternoonCustomizedTime(Time paramTime)
    {
      if (paramTime != null);
      for (paramTime = (Time)paramTime.freeze(); ; paramTime = null)
      {
        zzbnE = paramTime;
        return this;
      }
    }

    public Builder setEveningCustomizedTime(Time paramTime)
    {
      if (paramTime != null);
      for (paramTime = (Time)paramTime.freeze(); ; paramTime = null)
      {
        zzbnF = paramTime;
        return this;
      }
    }

    public Builder setMorningCustomizedTime(Time paramTime)
    {
      if (paramTime != null);
      for (paramTime = (Time)paramTime.freeze(); ; paramTime = null)
      {
        zzbnD = paramTime;
        return this;
      }
    }
  }
}
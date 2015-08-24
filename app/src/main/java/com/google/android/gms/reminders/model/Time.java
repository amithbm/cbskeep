package com.google.android.gms.reminders.model;

import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;

public abstract interface Time extends Parcelable, Freezable<Time>
{
  public abstract Integer getHour();

  public abstract Integer getMinute();

  public abstract Integer getSecond();

  public static class Builder
  {
    private Integer zzbpA;
    private Integer zzbpy;
    private Integer zzbpz;

    public Time build()
    {
      return new TimeEntity(zzbpy, zzbpz, zzbpA, true);
    }

    public Builder setHour(Integer paramInteger)
    {
      zzbpy = paramInteger;
      return this;
    }

    public Builder setMinute(Integer paramInteger)
    {
      zzbpz = paramInteger;
      return this;
    }

    public Builder setSecond(Integer paramInteger)
    {
      zzbpA = paramInteger;
      return this;
    }
  }
}
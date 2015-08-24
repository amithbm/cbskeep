package com.google.android.gms.reminders.model;

import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;

public abstract interface FeatureIdProto extends Parcelable, Freezable<FeatureIdProto>
{
  public abstract Long getCellId();

  public abstract Long getFprint();

  public static class Builder
  {
    private Long zzbnX;
    private Long zzbnY;

    public FeatureIdProto build()
    {
      return new FeatureIdProtoEntity(zzbnX, zzbnY, true);
    }

    public Builder setCellId(Long paramLong)
    {
      zzbnX = paramLong;
      return this;
    }

    public Builder setFprint(Long paramLong)
    {
      zzbnY = paramLong;
      return this;
    }
  }
}
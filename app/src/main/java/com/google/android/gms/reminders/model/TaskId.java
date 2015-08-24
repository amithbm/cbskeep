package com.google.android.gms.reminders.model;

import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;

public abstract interface TaskId extends Parcelable, Freezable<TaskId>
{
  public abstract String getClientAssignedId();

  public abstract String getClientAssignedThreadId();

  @Deprecated
  public abstract Long getServerAssignedId();

  public static class Builder
  {
    private Long zzbpv;
    private String zzbpw;
    private String zzbpx;

    public TaskId build()
    {
      return new TaskIdEntity(zzbpv, zzbpw, zzbpx, true);
    }

    public Builder setClientAssignedId(String paramString)
    {
      zzbpw = paramString;
      return this;
    }
  }
}
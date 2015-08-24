package com.google.android.gms.reminders.model;

import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;

public abstract interface LocationGroup extends Parcelable, Freezable<LocationGroup>
{
  public abstract CategoryInfo getCategoryInfo();

  public abstract ChainInfo getChainInfo();

  public abstract String getLocationQuery();

  public abstract Integer getLocationQueryType();
}
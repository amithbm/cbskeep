package com.google.android.gms.reminders.model;

import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;

public abstract interface ChainInfo extends Parcelable, Freezable<ChainInfo>
{
  public abstract FeatureIdProto getChainId();

  public abstract String getChainName();
}
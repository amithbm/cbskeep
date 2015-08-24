package com.google.android.gms.wearable;

import com.google.android.gms.common.data.Freezable;

public abstract interface DataEvent extends Freezable<DataEvent>
{
  public abstract DataItem getDataItem();

  public abstract int getType();
}
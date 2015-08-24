package com.google.android.gms.wearable;

import com.google.android.gms.common.data.Freezable;

public abstract interface DataItemAsset extends Freezable<DataItemAsset>
{
  public abstract String getDataItemKey();

  public abstract String getId();
}
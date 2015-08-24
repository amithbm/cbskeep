package com.google.android.gms.people.model;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;

public abstract class DataBufferWithSyncInfo<T> extends AbstractDataBuffer<T>
{
  protected DataBufferWithSyncInfo(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
  }
}
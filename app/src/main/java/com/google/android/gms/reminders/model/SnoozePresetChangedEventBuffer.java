package com.google.android.gms.reminders.model;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.zztl;

public class SnoozePresetChangedEventBuffer extends AbstractDataBuffer<SnoozePresetChangedEvent>
  implements Result
{
  private final Status zzOQ;

  public SnoozePresetChangedEventBuffer(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
    zzOQ = new Status(paramDataHolder.getStatusCode());
  }

  public SnoozePresetChangedEvent get(int paramInt)
  {
    return new zztl(mDataHolder, paramInt);
  }

  public Status getStatus()
  {
    return zzOQ;
  }
}
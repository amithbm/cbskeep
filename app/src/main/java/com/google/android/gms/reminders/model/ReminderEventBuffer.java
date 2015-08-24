package com.google.android.gms.reminders.model;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.zzti;

public class ReminderEventBuffer extends AbstractDataBuffer<ReminderEvent>
  implements Result
{
  private final Status zzOQ;

  public ReminderEventBuffer(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
    zzOQ = new Status(paramDataHolder.getStatusCode());
  }

  public ReminderEvent get(int paramInt)
  {
    return new zzti(mDataHolder, paramInt);
  }

  public Status getStatus()
  {
    return zzOQ;
  }
}
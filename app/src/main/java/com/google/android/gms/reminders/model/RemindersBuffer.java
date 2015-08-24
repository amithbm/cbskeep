package com.google.android.gms.reminders.model;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.reminders.internal.ref.TaskRef;

public final class RemindersBuffer extends AbstractDataBuffer<Task>
{
  public RemindersBuffer(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
  }

  public Task get(int paramInt)
  {
    return new TaskRef(mDataHolder, paramInt);
  }
}
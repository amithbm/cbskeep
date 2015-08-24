package com.google.android.gms.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.reminders.internal.ref.TaskRef;
import com.google.android.gms.reminders.internal.ref.zza;
import com.google.android.gms.reminders.model.ReminderEvent;
import com.google.android.gms.reminders.model.ReminderEventEntity;
import com.google.android.gms.reminders.model.Task;

public final class zzti extends zza
  implements ReminderEvent
{
  public zzti(DataHolder paramDataHolder, int paramInt)
  {
    super(paramDataHolder, paramInt);
  }

  public String getAccountName()
  {
    return getString("account_name");
  }

  public Task getTask()
  {
    return new TaskRef(mDataHolder, zzaiZ);
  }

  public int getType()
  {
    int i = 1;
    if (getInteger("deleted") == 1)
      i = 2;
    return i;
  }

  public ReminderEvent zzBZ()
  {
    return new ReminderEventEntity(this);
  }
}
package com.google.android.gms.reminders.model;

import com.google.android.gms.common.data.Freezable;

public abstract interface ReminderEvent extends Freezable<ReminderEvent>
{
  public abstract String getAccountName();

  public abstract Task getTask();

  public abstract int getType();
}
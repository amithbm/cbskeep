package com.google.android.gms.reminders.model;

import com.google.android.gms.common.data.Freezable;

public abstract interface SnoozePresetChangedEvent extends Freezable<SnoozePresetChangedEvent>
{
  public abstract String getAccountName();

  public abstract CustomizedSnoozePreset getCustomizedSnoozePreset();
}
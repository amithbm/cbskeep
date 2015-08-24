package com.google.android.gms.reminders.model;

public class zzp
  implements SnoozePresetChangedEvent
{
  private final String zzQt;
  private final CustomizedSnoozePreset zzbmd;

  public zzp(SnoozePresetChangedEvent paramSnoozePresetChangedEvent)
  {
    zzQt = paramSnoozePresetChangedEvent.getAccountName();
    zzbmd = paramSnoozePresetChangedEvent.getCustomizedSnoozePreset();
  }

  public String getAccountName()
  {
    return zzQt;
  }

  public CustomizedSnoozePreset getCustomizedSnoozePreset()
  {
    return zzbmd;
  }

  public SnoozePresetChangedEvent zzCa()
  {
    return this;
  }
}
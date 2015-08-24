package com.google.android.gms.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.reminders.internal.ref.zza;
import com.google.android.gms.reminders.model.CustomizedSnoozePreset;
import com.google.android.gms.reminders.model.CustomizedSnoozePreset.Builder;
import com.google.android.gms.reminders.model.SnoozePresetChangedEvent;
import com.google.android.gms.reminders.model.zzp;
import com.google.android.gms.reminders.zzd;

public final class zztl extends zza
  implements SnoozePresetChangedEvent
{
  private CustomizedSnoozePreset zzbmd;

  public zztl(DataHolder paramDataHolder, int paramInt)
  {
    super(paramDataHolder, paramInt);
  }

  public String getAccountName()
  {
    return getString("account_name");
  }

  public CustomizedSnoozePreset getCustomizedSnoozePreset()
  {
    if (zzbmd != null)
      return zzbmd;
    CustomizedSnoozePreset.Builder localBuilder = new CustomizedSnoozePreset.Builder();
    if (!zzbS("morning_customized_time"))
      localBuilder.setMorningCustomizedTime(zzd.zzad(getAsLong("morning_customized_time").longValue()));
    if (!zzbS("afternoon_customized_time"))
      localBuilder.setAfternoonCustomizedTime(zzd.zzad(getAsLong("afternoon_customized_time").longValue()));
    if (!zzbS("evening_customized_time"))
      localBuilder.setEveningCustomizedTime(zzd.zzad(getAsLong("evening_customized_time").longValue()));
    zzbmd = localBuilder.build();
    return zzbmd;
  }

  public SnoozePresetChangedEvent zzCa()
  {
    return new zzp(this);
  }
}
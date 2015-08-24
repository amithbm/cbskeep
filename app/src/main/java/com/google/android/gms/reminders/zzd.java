package com.google.android.gms.reminders;

import com.google.android.gms.common.internal.zzv;
import com.google.android.gms.reminders.model.Time;
import com.google.android.gms.reminders.model.Time.Builder;

public class zzd
{
  public static Time zzad(long paramLong)
  {
    if ((paramLong >= 0L) && (paramLong < 86400000L));
    for (boolean bool = true; ; bool = false)
    {
      zzv.zzb(bool, "Invalid timestamp:" + paramLong);
      int i = (int)(paramLong / 3600000L);
      paramLong -= i * 3600000L;
      int j = (int)(paramLong / 60000L);
      int k = (int)((paramLong - j * 60000L) / 1000L);
      return new Time.Builder().setHour(Integer.valueOf(i)).setMinute(Integer.valueOf(j)).setSecond(Integer.valueOf(k)).build();
    }
  }
}
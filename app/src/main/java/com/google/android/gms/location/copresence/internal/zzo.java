package com.google.android.gms.location.copresence.internal;

import com.google.android.gms.common.internal.zzv;

public class zzo
{
  public static long zzV(long paramLong)
  {
    if ((paramLong == 9223372036854775807L) || ((0L < paramLong) && (paramLong <= 86400000L)));
    for (boolean bool = true; ; bool = false)
    {
      zzv.zzb(bool, "TTL millis value " + paramLong + " not between 1 and " + 86400000L + " or INFINITE_TIME_TO_LIVE_MILLIS");
      return paramLong;
    }
  }
}
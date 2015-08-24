package com.google.android.gms.common.stats;

import android.os.SystemClock;
import android.support.v4.util.SimpleArrayMap;
import android.util.Log;

public class zze
{
  private final long zzaoi;
  private final int zzaoj;
  private final SimpleArrayMap<String, Long> zzaok;

  public zze()
  {
    zzaoi = 60000L;
    zzaoj = 10;
    zzaok = new SimpleArrayMap(10);
  }

  public zze(int paramInt, long paramLong)
  {
    zzaoi = paramLong;
    zzaoj = paramInt;
    zzaok = new SimpleArrayMap();
  }

  private void zze(long paramLong1, long paramLong2)
  {
    int i = zzaok.size() - 1;
    while (i >= 0)
    {
      if (paramLong2 - ((Long)zzaok.valueAt(i)).longValue() > paramLong1)
        zzaok.removeAt(i);
      i -= 1;
    }
  }

  public Long zzcg(String paramString)
  {
    long l2 = SystemClock.elapsedRealtime();
    long l1 = zzaoi;
    try
    {
      while (zzaok.size() >= zzaoj)
      {
        zze(l1, l2);
        l1 /= 2L;
        Log.w("ConnectionTracker", "The max capacity " + zzaoj + " is not enough. Current durationThreshold is: " + l1);
      }
    }
    finally
    {
    }
    paramString = (Long)zzaok.put(paramString, Long.valueOf(l2));
    return paramString;
  }

  public boolean zzch(String paramString)
  {
    while (true)
    {
      try
      {
        if (zzaok.remove(paramString) != null)
        {
          bool = true;
          return bool;
        }
      }
      finally
      {
      }
      boolean bool = false;
    }
  }
}
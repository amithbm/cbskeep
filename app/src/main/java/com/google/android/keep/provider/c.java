package com.google.android.keep.provider;

import android.os.SystemClock;

public abstract interface c
{
  public abstract long currentTimeMillis();

  public static class a
    implements c
  {
    public long currentTimeMillis()
    {
      return SystemClock.elapsedRealtime();
    }
  }
}
package com.google.android.keep.util;

import android.text.format.Time;

public class KeepTime extends Time
{
  public KeepTime()
  {
    setToNow();
  }

  public KeepTime(long paramLong)
  {
    set(paramLong);
  }

  public KeepTime(KeepTime paramKeepTime)
  {
    super(paramKeepTime);
  }

  public KeepTime(String paramString)
  {
    super(paramString);
    setToNow();
  }

  public static long aP(boolean paramBoolean)
  {
    KeepTime localKeepTime = new KeepTime();
    localKeepTime.set(0, 0, 0, localKeepTime.monthDay, localKeepTime.month, localKeepTime.year);
    return localKeepTime.toMillis(paramBoolean);
  }

  public static long or()
  {
    return aP(true);
  }

  public int aO(boolean paramBoolean)
  {
    normalize(paramBoolean);
    return getJulianDay(toMillis(paramBoolean), gmtoff);
  }

  public int jm()
  {
    return aO(true);
  }

  public long on()
  {
    return super.normalize(true);
  }

  public long oo()
  {
    return super.normalize(false);
  }

  public long op()
  {
    return super.toMillis(true);
  }

  public long oq()
  {
    normalize(true);
    KeepTime localKeepTime = new KeepTime(timezone);
    localKeepTime.set(0, 0, 0, monthDay, month, year);
    return toMillis(true) - localKeepTime.toMillis(true);
  }

  public void set(int paramInt1, int paramInt2, int paramInt3)
  {
    super.set(paramInt1, paramInt2, paramInt3);
    on();
  }

  public void set(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    super.set(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
    on();
  }
}
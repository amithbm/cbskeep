package com.google.api.client.util;

public abstract interface Sleeper
{
  public static final Sleeper DEFAULT = new Sleeper()
  {
    public void sleep(long paramAnonymousLong)
      throws InterruptedException
    {
      Thread.sleep(paramAnonymousLong);
    }
  };

  public abstract void sleep(long paramLong)
    throws InterruptedException;
}
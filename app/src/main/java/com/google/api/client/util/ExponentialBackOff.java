package com.google.api.client.util;

import java.io.IOException;

public class ExponentialBackOff
{
  private int currentIntervalMillis;
  private final int initialIntervalMillis;
  private final int maxElapsedTimeMillis;
  private final int maxIntervalMillis;
  private final double multiplier;
  private final NanoClock nanoClock;
  private final double randomizationFactor;
  long startTimeNanos;

  public ExponentialBackOff()
  {
    this(new Builder());
  }

  protected ExponentialBackOff(Builder paramBuilder)
  {
    initialIntervalMillis = paramBuilder.initialIntervalMillis;
    randomizationFactor = paramBuilder.randomizationFactor;
    multiplier = paramBuilder.multiplier;
    maxIntervalMillis = paramBuilder.maxIntervalMillis;
    maxElapsedTimeMillis = paramBuilder.maxElapsedTimeMillis;
    nanoClock = paramBuilder.nanoClock;
    if (initialIntervalMillis > 0)
    {
      bool1 = true;
      Preconditions.checkArgument(bool1);
      if ((0.0D > randomizationFactor) || (randomizationFactor >= 1.0D))
        break label146;
      bool1 = true;
      label87: Preconditions.checkArgument(bool1);
      if (multiplier < 1.0D)
        break label151;
      bool1 = true;
      label102: Preconditions.checkArgument(bool1);
      if (maxIntervalMillis < initialIntervalMillis)
        break label156;
      bool1 = true;
      label119: Preconditions.checkArgument(bool1);
      if (maxElapsedTimeMillis <= 0)
        break label161;
    }
    label146: label151: label156: label161: for (boolean bool1 = bool2; ; bool1 = false)
    {
      Preconditions.checkArgument(bool1);
      reset();
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label87;
      bool1 = false;
      break label102;
      bool1 = false;
      break label119;
    }
  }

  static int getRandomValueFromInterval(double paramDouble1, double paramDouble2, int paramInt)
  {
    paramDouble1 *= paramInt;
    double d = paramInt - paramDouble1;
    return (int)((paramInt + paramDouble1 - d + 1.0D) * paramDouble2 + d);
  }

  private void incrementCurrentInterval()
  {
    if (currentIntervalMillis >= maxIntervalMillis / multiplier)
    {
      currentIntervalMillis = maxIntervalMillis;
      return;
    }
    currentIntervalMillis = ((int)(currentIntervalMillis * multiplier));
  }

  public final long getElapsedTimeMillis()
  {
    return (nanoClock.nanoTime() - startTimeNanos) / 1000000L;
  }

  public long nextBackOffMillis()
    throws IOException
  {
    if (getElapsedTimeMillis() > maxElapsedTimeMillis)
      return -1L;
    int i = getRandomValueFromInterval(randomizationFactor, Math.random(), currentIntervalMillis);
    incrementCurrentInterval();
    return i;
  }

  public final void reset()
  {
    currentIntervalMillis = initialIntervalMillis;
    startTimeNanos = nanoClock.nanoTime();
  }

  public static class Builder
  {
    int initialIntervalMillis = 500;
    int maxElapsedTimeMillis = 900000;
    int maxIntervalMillis = 60000;
    double multiplier = 1.5D;
    NanoClock nanoClock = NanoClock.SYSTEM;
    double randomizationFactor = 0.5D;

    public ExponentialBackOff build()
    {
      return new ExponentialBackOff(this);
    }
  }
}
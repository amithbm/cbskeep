package com.google.api.client.http;

import com.google.api.client.util.ExponentialBackOff;
import com.google.api.client.util.ExponentialBackOff.Builder;
import java.io.IOException;

@Deprecated
public class ExponentialBackOffPolicy
  implements BackOffPolicy
{
  private final ExponentialBackOff exponentialBackOff;

  public ExponentialBackOffPolicy()
  {
    this(new Builder());
  }

  protected ExponentialBackOffPolicy(Builder paramBuilder)
  {
    exponentialBackOff = paramBuilder.exponentialBackOffBuilder.build();
  }

  public long getNextBackOffMillis()
    throws IOException
  {
    return exponentialBackOff.nextBackOffMillis();
  }

  public boolean isBackOffRequired(int paramInt)
  {
    switch (paramInt)
    {
    case 501:
    case 502:
    default:
      return false;
    case 500:
    case 503:
    }
    return true;
  }

  public final void reset()
  {
    exponentialBackOff.reset();
  }

  @Deprecated
  public static class Builder
  {
    final ExponentialBackOff.Builder exponentialBackOffBuilder = new ExponentialBackOff.Builder();
  }
}
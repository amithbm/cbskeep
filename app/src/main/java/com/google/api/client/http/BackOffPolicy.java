package com.google.api.client.http;

import java.io.IOException;

@Deprecated
public abstract interface BackOffPolicy
{
  public abstract long getNextBackOffMillis()
    throws IOException;

  public abstract boolean isBackOffRequired(int paramInt);

  public abstract void reset();
}
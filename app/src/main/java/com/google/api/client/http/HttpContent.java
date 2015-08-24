package com.google.api.client.http;

import com.google.api.client.util.StreamingContent;
import java.io.IOException;

public abstract interface HttpContent extends StreamingContent
{
  public abstract long getLength()
    throws IOException;

  public abstract String getType();

  public abstract boolean retrySupported();
}
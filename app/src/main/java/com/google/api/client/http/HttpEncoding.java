package com.google.api.client.http;

import com.google.api.client.util.StreamingContent;
import java.io.IOException;
import java.io.OutputStream;

public abstract interface HttpEncoding
{
  public abstract void encode(StreamingContent paramStreamingContent, OutputStream paramOutputStream)
    throws IOException;

  public abstract String getName();
}
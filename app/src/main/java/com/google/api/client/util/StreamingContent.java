package com.google.api.client.util;

import java.io.IOException;
import java.io.OutputStream;

public abstract interface StreamingContent
{
  public abstract void writeTo(OutputStream paramOutputStream)
    throws IOException;
}
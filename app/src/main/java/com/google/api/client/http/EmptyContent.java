package com.google.api.client.http;

import java.io.IOException;
import java.io.OutputStream;

public class EmptyContent
  implements HttpContent
{
  public long getLength()
    throws IOException
  {
    return 0L;
  }

  public String getType()
  {
    return null;
  }

  public boolean retrySupported()
  {
    return true;
  }

  public void writeTo(OutputStream paramOutputStream)
    throws IOException
  {
    paramOutputStream.flush();
  }
}
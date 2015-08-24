package com.google.api.client.http;

import com.google.api.client.util.Preconditions;
import java.io.InputStream;

public final class InputStreamContent extends AbstractInputStreamContent
{
  private final InputStream inputStream;
  private long length = -1L;
  private boolean retrySupported;

  public InputStreamContent(String paramString, InputStream paramInputStream)
  {
    super(paramString);
    inputStream = ((InputStream)Preconditions.checkNotNull(paramInputStream));
  }

  public InputStream getInputStream()
  {
    return inputStream;
  }

  public long getLength()
  {
    return length;
  }

  public boolean retrySupported()
  {
    return retrySupported;
  }

  public InputStreamContent setCloseInputStream(boolean paramBoolean)
  {
    return (InputStreamContent)super.setCloseInputStream(paramBoolean);
  }

  public InputStreamContent setLength(long paramLong)
  {
    length = paramLong;
    return this;
  }

  public InputStreamContent setRetrySupported(boolean paramBoolean)
  {
    retrySupported = paramBoolean;
    return this;
  }

  public InputStreamContent setType(String paramString)
  {
    return (InputStreamContent)super.setType(paramString);
  }
}
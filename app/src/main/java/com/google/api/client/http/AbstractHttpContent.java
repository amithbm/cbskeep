package com.google.api.client.http;

import com.google.api.client.util.Charsets;
import com.google.api.client.util.IOUtils;
import java.io.IOException;
import java.nio.charset.Charset;

public abstract class AbstractHttpContent
  implements HttpContent
{
  private long computedLength = -1L;
  private HttpMediaType mediaType;

  protected AbstractHttpContent(HttpMediaType paramHttpMediaType)
  {
    mediaType = paramHttpMediaType;
  }

  protected AbstractHttpContent(String paramString)
  {
  }

  public static long computeLength(HttpContent paramHttpContent)
    throws IOException
  {
    if (!paramHttpContent.retrySupported())
      return -1L;
    return IOUtils.computeLength(paramHttpContent);
  }

  protected long computeLength()
    throws IOException
  {
    return computeLength(this);
  }

  protected final Charset getCharset()
  {
    if ((mediaType == null) || (mediaType.getCharsetParameter() == null))
      return Charsets.UTF_8;
    return mediaType.getCharsetParameter();
  }

  public long getLength()
    throws IOException
  {
    if (computedLength == -1L)
      computedLength = computeLength();
    return computedLength;
  }

  public final HttpMediaType getMediaType()
  {
    return mediaType;
  }

  public String getType()
  {
    if (mediaType == null)
      return null;
    return mediaType.build();
  }

  public boolean retrySupported()
  {
    return true;
  }
}
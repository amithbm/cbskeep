package com.google.api.client.http;

import com.google.api.client.util.StreamingContent;
import java.io.IOException;

public abstract class LowLevelHttpRequest
{
  private String contentEncoding;
  private long contentLength = -1L;
  private String contentType;
  private StreamingContent streamingContent;

  public abstract void addHeader(String paramString1, String paramString2)
    throws IOException;

  public abstract LowLevelHttpResponse execute()
    throws IOException;

  public final String getContentEncoding()
  {
    return contentEncoding;
  }

  public final long getContentLength()
  {
    return contentLength;
  }

  public final String getContentType()
  {
    return contentType;
  }

  public final StreamingContent getStreamingContent()
  {
    return streamingContent;
  }

  public final void setContentEncoding(String paramString)
    throws IOException
  {
    contentEncoding = paramString;
  }

  public final void setContentLength(long paramLong)
    throws IOException
  {
    contentLength = paramLong;
  }

  public final void setContentType(String paramString)
    throws IOException
  {
    contentType = paramString;
  }

  public final void setStreamingContent(StreamingContent paramStreamingContent)
    throws IOException
  {
    streamingContent = paramStreamingContent;
  }

  public void setTimeout(int paramInt1, int paramInt2)
    throws IOException
  {
  }
}
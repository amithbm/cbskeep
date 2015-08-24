package com.google.api.client.http;

import com.google.api.client.util.Preconditions;
import com.google.api.client.util.StreamingContent;
import java.io.IOException;
import java.io.OutputStream;

public final class HttpEncodingStreamingContent
  implements StreamingContent
{
  private final StreamingContent content;
  private final HttpEncoding encoding;

  public HttpEncodingStreamingContent(StreamingContent paramStreamingContent, HttpEncoding paramHttpEncoding)
  {
    content = ((StreamingContent)Preconditions.checkNotNull(paramStreamingContent));
    encoding = ((HttpEncoding)Preconditions.checkNotNull(paramHttpEncoding));
  }

  public void writeTo(OutputStream paramOutputStream)
    throws IOException
  {
    encoding.encode(content, paramOutputStream);
  }
}
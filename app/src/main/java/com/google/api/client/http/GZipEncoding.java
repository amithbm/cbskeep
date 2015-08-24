package com.google.api.client.http;

import com.google.api.client.util.StreamingContent;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

public class GZipEncoding
  implements HttpEncoding
{
  public void encode(StreamingContent paramStreamingContent, OutputStream paramOutputStream)
    throws IOException
  {
    paramOutputStream = new GZIPOutputStream(new FilterOutputStream(paramOutputStream)
    {
      public void close()
        throws IOException
      {
        try
        {
          flush();
          return;
        }
        catch (IOException localIOException)
        {
        }
      }
    });
    paramStreamingContent.writeTo(paramOutputStream);
    paramOutputStream.close();
  }

  public String getName()
  {
    return "gzip";
  }
}
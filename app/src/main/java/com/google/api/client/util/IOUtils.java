package com.google.api.client.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IOUtils
{
  public static long computeLength(StreamingContent paramStreamingContent)
    throws IOException
  {
    ByteCountingOutputStream localByteCountingOutputStream = new ByteCountingOutputStream();
    try
    {
      paramStreamingContent.writeTo(localByteCountingOutputStream);
      return localByteCountingOutputStream.count;
    }
    finally
    {
      localByteCountingOutputStream.close();
    }
    throw paramStreamingContent;
  }

  public static void copy(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    copy(paramInputStream, paramOutputStream, true);
  }

  public static void copy(InputStream paramInputStream, OutputStream paramOutputStream, boolean paramBoolean)
    throws IOException
  {
    try
    {
      ByteStreams.copy(paramInputStream, paramOutputStream);
      return;
    }
    finally
    {
      if (paramBoolean)
        paramInputStream.close();
    }
    throw paramOutputStream;
  }
}
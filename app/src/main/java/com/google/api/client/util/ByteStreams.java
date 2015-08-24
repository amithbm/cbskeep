package com.google.api.client.util;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class ByteStreams
{
  public static long copy(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    Preconditions.checkNotNull(paramInputStream);
    Preconditions.checkNotNull(paramOutputStream);
    byte[] arrayOfByte = new byte[4096];
    int i;
    for (long l = 0L; ; l += i)
    {
      i = paramInputStream.read(arrayOfByte);
      if (i == -1)
        return l;
      paramOutputStream.write(arrayOfByte, 0, i);
    }
  }

  public static InputStream limit(InputStream paramInputStream, long paramLong)
  {
    return new LimitedInputStream(paramInputStream, paramLong);
  }

  public static int read(InputStream paramInputStream, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    Preconditions.checkNotNull(paramInputStream);
    Preconditions.checkNotNull(paramArrayOfByte);
    if (paramInt2 < 0)
      throw new IndexOutOfBoundsException("len is negative");
    int i = 0;
    while (true)
    {
      int j;
      if (i < paramInt2)
      {
        j = paramInputStream.read(paramArrayOfByte, paramInt1 + i, paramInt2 - i);
        if (j != -1);
      }
      else
      {
        return i;
      }
      i += j;
    }
  }

  private static final class LimitedInputStream extends FilterInputStream
  {
    private long left;
    private long mark = -1L;

    LimitedInputStream(InputStream paramInputStream, long paramLong)
    {
      super();
      Preconditions.checkNotNull(paramInputStream);
      if (paramLong >= 0L);
      for (boolean bool = true; ; bool = false)
      {
        Preconditions.checkArgument(bool, "limit must be non-negative");
        left = paramLong;
        return;
      }
    }

    public int available()
      throws IOException
    {
      return (int)Math.min(in.available(), left);
    }

    public void mark(int paramInt)
    {
      try
      {
        in.mark(paramInt);
        mark = left;
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }

    public int read()
      throws IOException
    {
      int i;
      if (left == 0L)
        i = -1;
      int j;
      do
      {
        return i;
        j = in.read();
        i = j;
      }
      while (j == -1);
      left -= 1L;
      return j;
    }

    public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      if (left == 0L)
        paramInt1 = -1;
      do
      {
        return paramInt1;
        paramInt2 = (int)Math.min(paramInt2, left);
        paramInt2 = in.read(paramArrayOfByte, paramInt1, paramInt2);
        paramInt1 = paramInt2;
      }
      while (paramInt2 == -1);
      left -= paramInt2;
      return paramInt2;
    }

    public void reset()
      throws IOException
    {
      try
      {
        if (!in.markSupported())
          throw new IOException("Mark not supported");
      }
      finally
      {
      }
      if (mark == -1L)
        throw new IOException("Mark not set");
      in.reset();
      left = mark;
    }

    public long skip(long paramLong)
      throws IOException
    {
      paramLong = Math.min(paramLong, left);
      paramLong = in.skip(paramLong);
      left -= paramLong;
      return paramLong;
    }
  }
}
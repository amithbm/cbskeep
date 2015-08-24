package com.google.api.client.util;

import java.io.IOException;
import java.io.OutputStream;

final class ByteCountingOutputStream extends OutputStream
{
  long count;

  public void write(int paramInt)
    throws IOException
  {
    count += 1L;
  }

  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    count += paramInt2;
  }
}
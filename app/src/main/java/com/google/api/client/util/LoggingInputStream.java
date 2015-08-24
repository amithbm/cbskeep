package com.google.api.client.util;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggingInputStream extends FilterInputStream
{
  private final LoggingByteArrayOutputStream logStream;

  public LoggingInputStream(InputStream paramInputStream, Logger paramLogger, Level paramLevel, int paramInt)
  {
    super(paramInputStream);
    logStream = new LoggingByteArrayOutputStream(paramLogger, paramLevel, paramInt);
  }

  public void close()
    throws IOException
  {
    logStream.close();
    super.close();
  }

  public int read()
    throws IOException
  {
    int i = super.read();
    logStream.write(i);
    return i;
  }

  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    paramInt2 = super.read(paramArrayOfByte, paramInt1, paramInt2);
    if (paramInt2 > 0)
      logStream.write(paramArrayOfByte, paramInt1, paramInt2);
    return paramInt2;
  }
}
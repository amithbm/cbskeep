package com.google.api.client.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggingByteArrayOutputStream extends ByteArrayOutputStream
{
  private int bytesWritten;
  private boolean closed;
  private final Logger logger;
  private final Level loggingLevel;
  private final int maximumBytesToLog;

  public LoggingByteArrayOutputStream(Logger paramLogger, Level paramLevel, int paramInt)
  {
    logger = ((Logger)Preconditions.checkNotNull(paramLogger));
    loggingLevel = ((Level)Preconditions.checkNotNull(paramLevel));
    if (paramInt >= 0);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool);
      maximumBytesToLog = paramInt;
      return;
    }
  }

  private static void appendBytes(StringBuilder paramStringBuilder, int paramInt)
  {
    if (paramInt == 1)
    {
      paramStringBuilder.append("1 byte");
      return;
    }
    paramStringBuilder.append(NumberFormat.getInstance().format(paramInt)).append(" bytes");
  }

  public void close()
    throws IOException
  {
    try
    {
      if (!closed)
      {
        if (bytesWritten != 0)
        {
          StringBuilder localStringBuilder = new StringBuilder().append("Total: ");
          appendBytes(localStringBuilder, bytesWritten);
          if ((count != 0) && (count < bytesWritten))
          {
            localStringBuilder.append(" (logging first ");
            appendBytes(localStringBuilder, count);
            localStringBuilder.append(")");
          }
          logger.config(localStringBuilder.toString());
          if (count != 0)
            logger.log(loggingLevel, toString("UTF-8").replaceAll("[\\x00-\\x09\\x0B\\x0C\\x0E-\\x1F\\x7F]", " "));
        }
        closed = true;
      }
      return;
    }
    finally
    {
    }
  }

  public void write(int paramInt)
  {
    try
    {
      if (!closed);
      for (boolean bool = true; ; bool = false)
      {
        Preconditions.checkArgument(bool);
        bytesWritten += 1;
        if (count < maximumBytesToLog)
          super.write(paramInt);
        return;
      }
    }
    finally
    {
    }
  }

  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      if (!closed);
      for (boolean bool = true; ; bool = false)
      {
        Preconditions.checkArgument(bool);
        bytesWritten += paramInt2;
        if (count < maximumBytesToLog)
        {
          int j = count + paramInt2;
          int i = paramInt2;
          if (j > maximumBytesToLog)
            i = paramInt2 + (maximumBytesToLog - j);
          super.write(paramArrayOfByte, paramInt1, i);
        }
        return;
      }
    }
    finally
    {
    }
    throw paramArrayOfByte;
  }
}
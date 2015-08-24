package com.google.api.client.util;

import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class LoggingStreamingContent
  implements StreamingContent
{
  private final StreamingContent content;
  private final int contentLoggingLimit;
  private final Logger logger;
  private final Level loggingLevel;

  public LoggingStreamingContent(StreamingContent paramStreamingContent, Logger paramLogger, Level paramLevel, int paramInt)
  {
    content = paramStreamingContent;
    logger = paramLogger;
    loggingLevel = paramLevel;
    contentLoggingLimit = paramInt;
  }

  public void writeTo(OutputStream paramOutputStream)
    throws IOException
  {
    LoggingOutputStream localLoggingOutputStream = new LoggingOutputStream(paramOutputStream, logger, loggingLevel, contentLoggingLimit);
    try
    {
      content.writeTo(localLoggingOutputStream);
      localLoggingOutputStream.getLogStream().close();
      paramOutputStream.flush();
      return;
    }
    finally
    {
      localLoggingOutputStream.getLogStream().close();
    }
    throw paramOutputStream;
  }
}
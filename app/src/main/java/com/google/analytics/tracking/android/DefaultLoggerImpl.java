package com.google.analytics.tracking.android;

import android.util.Log;

class DefaultLoggerImpl
  implements Logger
{
  private Logger.LogLevel mLogLevel = Logger.LogLevel.INFO;

  private String formatMessage(String paramString)
  {
    return Thread.currentThread().toString() + ": " + paramString;
  }

  public void error(String paramString)
  {
    if (mLogLevel.ordinal() <= Logger.LogLevel.ERROR.ordinal())
      Log.e("GAV3", formatMessage(paramString));
  }

  public Logger.LogLevel getLogLevel()
  {
    return mLogLevel;
  }

  public void info(String paramString)
  {
    if (mLogLevel.ordinal() <= Logger.LogLevel.INFO.ordinal())
      Log.i("GAV3", formatMessage(paramString));
  }

  public void setLogLevel(Logger.LogLevel paramLogLevel)
  {
    mLogLevel = paramLogLevel;
  }

  public void verbose(String paramString)
  {
    if (mLogLevel.ordinal() <= Logger.LogLevel.VERBOSE.ordinal())
      Log.v("GAV3", formatMessage(paramString));
  }

  public void warn(String paramString)
  {
    if (mLogLevel.ordinal() <= Logger.LogLevel.WARNING.ordinal())
      Log.w("GAV3", formatMessage(paramString));
  }
}
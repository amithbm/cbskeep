package com.google.analytics.tracking.android;

public class Log
{
  private static GoogleAnalytics sGaInstance;

  public static void e(String paramString)
  {
    Logger localLogger = getLogger();
    if (localLogger != null)
      localLogger.error(paramString);
  }

  private static Logger getLogger()
  {
    if (sGaInstance == null)
      sGaInstance = GoogleAnalytics.getInstance();
    if (sGaInstance != null)
      return sGaInstance.getLogger();
    return null;
  }

  public static void i(String paramString)
  {
    Logger localLogger = getLogger();
    if (localLogger != null)
      localLogger.info(paramString);
  }

  public static boolean isVerbose()
  {
    if (getLogger() != null)
      return Logger.LogLevel.VERBOSE.equals(getLogger().getLogLevel());
    return false;
  }

  public static void v(String paramString)
  {
    Logger localLogger = getLogger();
    if (localLogger != null)
      localLogger.verbose(paramString);
  }

  public static void w(String paramString)
  {
    Logger localLogger = getLogger();
    if (localLogger != null)
      localLogger.warn(paramString);
  }
}
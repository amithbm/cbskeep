package com.google.analytics.tracking.android;

import android.content.Context;
import java.util.ArrayList;

public class ExceptionReporter
  implements Thread.UncaughtExceptionHandler
{
  private ExceptionParser mExceptionParser;
  private final Thread.UncaughtExceptionHandler mOriginalHandler;
  private final ServiceManager mServiceManager;
  private final Tracker mTracker;

  public ExceptionReporter(Tracker paramTracker, ServiceManager paramServiceManager, Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler, Context paramContext)
  {
    if (paramTracker == null)
      throw new NullPointerException("tracker cannot be null");
    if (paramServiceManager == null)
      throw new NullPointerException("serviceManager cannot be null");
    mOriginalHandler = paramUncaughtExceptionHandler;
    mTracker = paramTracker;
    mServiceManager = paramServiceManager;
    mExceptionParser = new StandardExceptionParser(paramContext, new ArrayList());
    paramServiceManager = new StringBuilder().append("ExceptionReporter created, original handler is ");
    if (paramUncaughtExceptionHandler == null);
    for (paramTracker = "null"; ; paramTracker = paramUncaughtExceptionHandler.getClass().getName())
    {
      Log.v(paramTracker);
      return;
    }
  }

  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    String str = "UncaughtException";
    if (mExceptionParser != null)
      if (paramThread == null)
        break label102;
    label102: for (str = paramThread.getName(); ; str = null)
    {
      str = mExceptionParser.getDescription(str, paramThrowable);
      Log.v("Tracking Exception: " + str);
      mTracker.send(MapBuilder.createException(str, Boolean.valueOf(true)).build());
      mServiceManager.dispatchLocalHits();
      if (mOriginalHandler != null)
      {
        Log.v("Passing exception to original handler.");
        mOriginalHandler.uncaughtException(paramThread, paramThrowable);
      }
      return;
    }
  }
}
package com.google.analytics.tracking.android;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

class ScreenResolutionDefaultProvider
  implements DefaultProvider
{
  private static ScreenResolutionDefaultProvider sInstance;
  private static Object sInstanceLock = new Object();
  private final Context mContext;

  protected ScreenResolutionDefaultProvider(Context paramContext)
  {
    mContext = paramContext;
  }

  public static ScreenResolutionDefaultProvider getProvider()
  {
    synchronized (sInstanceLock)
    {
      ScreenResolutionDefaultProvider localScreenResolutionDefaultProvider = sInstance;
      return localScreenResolutionDefaultProvider;
    }
  }

  public static void initializeProvider(Context paramContext)
  {
    synchronized (sInstanceLock)
    {
      if (sInstance == null)
        sInstance = new ScreenResolutionDefaultProvider(paramContext);
      return;
    }
  }

  protected String getScreenResolutionString()
  {
    DisplayMetrics localDisplayMetrics = mContext.getResources().getDisplayMetrics();
    return localDisplayMetrics.widthPixels + "x" + localDisplayMetrics.heightPixels;
  }

  public String getValue(String paramString)
  {
    if (paramString == null);
    while (!paramString.equals("&sr"))
      return null;
    return getScreenResolutionString();
  }
}
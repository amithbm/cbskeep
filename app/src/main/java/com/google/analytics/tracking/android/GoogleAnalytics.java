package com.google.analytics.tracking.android;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class GoogleAnalytics extends TrackerHandler
{
  private static GoogleAnalytics sInstance;
  private volatile Boolean mAppOptOut = Boolean.valueOf(false);
  private Context mContext;
  private Tracker mDefaultTracker;
  private boolean mDryRun;
  private Logger mLogger;
  private AnalyticsThread mThread;
  private final Map<String, Tracker> mTrackers = new HashMap();

  protected GoogleAnalytics(Context paramContext)
  {
    this(paramContext, GAThread.getInstance(paramContext));
  }

  private GoogleAnalytics(Context paramContext, AnalyticsThread paramAnalyticsThread)
  {
    if (paramContext == null)
      throw new IllegalArgumentException("context cannot be null");
    mContext = paramContext.getApplicationContext();
    mThread = paramAnalyticsThread;
    AppFieldsDefaultProvider.initializeProvider(mContext);
    ScreenResolutionDefaultProvider.initializeProvider(mContext);
    ClientIdDefaultProvider.initializeProvider(mContext);
    mLogger = new DefaultLoggerImpl();
  }

  static GoogleAnalytics getInstance()
  {
    try
    {
      GoogleAnalytics localGoogleAnalytics = sInstance;
      return localGoogleAnalytics;
    }
    finally
    {
    }
  }

  public static GoogleAnalytics getInstance(Context paramContext)
  {
    try
    {
      if (sInstance == null)
        sInstance = new GoogleAnalytics(paramContext);
      paramContext = sInstance;
      return paramContext;
    }
    finally
    {
    }
    throw paramContext;
  }

  public boolean getAppOptOut()
  {
    GAUsage.getInstance().setUsage(GAUsage.Field.GET_APP_OPT_OUT);
    return mAppOptOut.booleanValue();
  }

  public Logger getLogger()
  {
    return mLogger;
  }

  public Tracker getTracker(String paramString)
  {
    return getTracker(paramString, paramString);
  }

  public Tracker getTracker(String paramString1, String paramString2)
  {
    try
    {
      if (TextUtils.isEmpty(paramString1))
        throw new IllegalArgumentException("Tracker name cannot be empty");
    }
    finally
    {
    }
    Tracker localTracker2 = (Tracker)mTrackers.get(paramString1);
    Tracker localTracker1 = localTracker2;
    if (localTracker2 == null)
    {
      localTracker2 = new Tracker(paramString1, paramString2, this);
      mTrackers.put(paramString1, localTracker2);
      localTracker1 = localTracker2;
      if (mDefaultTracker == null)
      {
        mDefaultTracker = localTracker2;
        localTracker1 = localTracker2;
      }
    }
    if (!TextUtils.isEmpty(paramString2))
      localTracker1.set("&tid", paramString2);
    GAUsage.getInstance().setUsage(GAUsage.Field.GET_TRACKER);
    return localTracker1;
  }

  public boolean isDryRunEnabled()
  {
    GAUsage.getInstance().setUsage(GAUsage.Field.GET_DRY_RUN);
    return mDryRun;
  }

  void sendHit(Map<String, String> paramMap)
  {
    if (paramMap == null)
      try
      {
        throw new IllegalArgumentException("hit cannot be null");
      }
      finally
      {
      }
    Utils.putIfAbsent(paramMap, "&ul", Utils.getLanguage(Locale.getDefault()));
    Utils.putIfAbsent(paramMap, "&sr", ScreenResolutionDefaultProvider.getProvider().getValue("&sr"));
    paramMap.put("&_u", GAUsage.getInstance().getAndClearSequence());
    GAUsage.getInstance().getAndClearUsage();
    mThread.sendHit(paramMap);
  }

  public void setDryRun(boolean paramBoolean)
  {
    GAUsage.getInstance().setUsage(GAUsage.Field.SET_DRY_RUN);
    mDryRun = paramBoolean;
  }
}
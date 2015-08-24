package com.google.analytics.tracking.android;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public class Tracker
{
  private final AppFieldsDefaultProvider mAppFieldsDefaultProvider;
  private final ClientIdDefaultProvider mClientIdDefaultProvider;
  private final TrackerHandler mHandler;
  private long mLastTrackTime;
  private final String mName;
  private final Map<String, String> mParams = new HashMap();
  private final ScreenResolutionDefaultProvider mScreenResolutionDefaultProvider;
  private long mTokens = 120000L;

  Tracker(String paramString1, String paramString2, TrackerHandler paramTrackerHandler)
  {
    this(paramString1, paramString2, paramTrackerHandler, ClientIdDefaultProvider.getProvider(), ScreenResolutionDefaultProvider.getProvider(), AppFieldsDefaultProvider.getProvider());
  }

  Tracker(String paramString1, String paramString2, TrackerHandler paramTrackerHandler, ClientIdDefaultProvider paramClientIdDefaultProvider, ScreenResolutionDefaultProvider paramScreenResolutionDefaultProvider, AppFieldsDefaultProvider paramAppFieldsDefaultProvider)
  {
    if (TextUtils.isEmpty(paramString1))
      throw new IllegalArgumentException("Tracker name cannot be empty.");
    mName = paramString1;
    mHandler = paramTrackerHandler;
    mParams.put("&tid", paramString2);
    mParams.put("useSecure", "1");
    mClientIdDefaultProvider = paramClientIdDefaultProvider;
    mScreenResolutionDefaultProvider = paramScreenResolutionDefaultProvider;
    mAppFieldsDefaultProvider = paramAppFieldsDefaultProvider;
  }

  public void send(Map<String, String> paramMap)
  {
    GAUsage.getInstance().setUsage(GAUsage.Field.SEND);
    HashMap localHashMap = new HashMap();
    localHashMap.putAll(mParams);
    if (paramMap != null)
      localHashMap.putAll(paramMap);
    if (TextUtils.isEmpty((CharSequence)localHashMap.get("&tid")))
      Log.w(String.format("Missing tracking id (%s) parameter.", new Object[] { "&tid" }));
    String str = (String)localHashMap.get("&t");
    paramMap = str;
    if (TextUtils.isEmpty(str))
    {
      Log.w(String.format("Missing hit type (%s) parameter.", new Object[] { "&t" }));
      paramMap = "";
    }
    if ((!paramMap.equals("transaction")) && (!paramMap.equals("item")) && (!tokensAvailable()))
    {
      Log.w("Too many hits sent too quickly, rate limiting invoked.");
      return;
    }
    mHandler.sendHit(localHashMap);
  }

  public void set(String paramString1, String paramString2)
  {
    GAUsage.getInstance().setUsage(GAUsage.Field.SET);
    if (paramString2 == null)
    {
      mParams.remove(paramString1);
      return;
    }
    mParams.put(paramString1, paramString2);
  }

  boolean tokensAvailable()
  {
    try
    {
      long l1 = System.currentTimeMillis();
      if (mTokens < 120000L)
      {
        long l2 = l1 - mLastTrackTime;
        if (l2 > 0L)
          mTokens = Math.min(120000L, mTokens + l2);
      }
      mLastTrackTime = l1;
      if (mTokens >= 2000L)
        mTokens -= 2000L;
      for (boolean bool = true; ; bool = false)
      {
        return bool;
        Log.w("Excessive tracking detected.  Tracking call ignored.");
      }
    }
    finally
    {
    }
  }
}
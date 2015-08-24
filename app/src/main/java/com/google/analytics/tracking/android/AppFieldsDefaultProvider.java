package com.google.analytics.tracking.android;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;

class AppFieldsDefaultProvider
  implements DefaultProvider
{
  private static AppFieldsDefaultProvider sInstance;
  private static Object sInstanceLock = new Object();
  protected String mAppId;
  protected String mAppInstallerId;
  protected String mAppName;
  protected String mAppVersion;

  protected AppFieldsDefaultProvider()
  {
  }

  private AppFieldsDefaultProvider(Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    mAppId = paramContext.getPackageName();
    mAppInstallerId = localPackageManager.getInstallerPackageName(mAppId);
    String str2 = mAppId;
    Object localObject = null;
    String str1 = str2;
    try
    {
      PackageInfo localPackageInfo = localPackageManager.getPackageInfo(paramContext.getPackageName(), 0);
      str1 = str2;
      paramContext = localObject;
      if (localPackageInfo != null)
      {
        str1 = str2;
        str2 = localPackageManager.getApplicationLabel(localPackageInfo.applicationInfo).toString();
        str1 = str2;
        paramContext = localPackageInfo.versionName;
        str1 = str2;
      }
      mAppName = str1;
      mAppVersion = paramContext;
      return;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      while (true)
      {
        Log.e("Error retrieving package info: appName set to " + str1);
        paramContext = localObject;
      }
    }
  }

  public static AppFieldsDefaultProvider getProvider()
  {
    return sInstance;
  }

  public static void initializeProvider(Context paramContext)
  {
    synchronized (sInstanceLock)
    {
      if (sInstance == null)
        sInstance = new AppFieldsDefaultProvider(paramContext);
      return;
    }
  }

  public String getValue(String paramString)
  {
    if (paramString == null);
    do
    {
      return null;
      if (paramString.equals("&an"))
        return mAppName;
      if (paramString.equals("&av"))
        return mAppVersion;
      if (paramString.equals("&aid"))
        return mAppId;
    }
    while (!paramString.equals("&aiid"));
    return mAppInstallerId;
  }
}
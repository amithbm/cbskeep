package com.google.android.keep.activities;

import android.annotation.SuppressLint;
import android.app.Application;
import android.appwidget.AppWidgetManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.Settings.Global;
import android.provider.Settings.System;
import android.view.View;
import com.google.analytics.tracking.android.GoogleAnalytics;
import com.google.analytics.tracking.android.Logger;
import com.google.analytics.tracking.android.Logger.LogLevel;
import com.google.analytics.tracking.android.MapBuilder;
import com.google.analytics.tracking.android.Tracker;
import com.google.android.gsf.GservicesValue;
import com.google.android.keep.binder.Binder;
import com.google.android.keep.binder.b;
import com.google.android.keep.model.ColorMap;
import com.google.android.keep.provider.RemindersDBUpgradeService;
import com.google.android.keep.service.CleanupService;
import com.google.android.keep.syncadapter.g;
import com.google.android.keep.util.Config;
import com.google.android.keep.w;
import com.google.android.keep.x;
import com.google.api.client.util.Maps;
import java.util.HashMap;

public class KeepApplication extends Application
  implements b
{
  private static Typeface dh = null;
  private static Typeface di = null;
  private static Typeface dj = null;
  private static Typeface dk = null;
  private static final String[] dl = { "TR", "EC", "SH", "RB", "LB" };
  private static Tracker jdField_do;
  private static final int dp = Build.VERSION.SDK_INT;
  public static final String dq = Build.VERSION.RELEASE;
  public static final String dr = Build.MODEL;
  public static final String ds = Build.ID;
  private static final HashMap<String, Object> dt = Maps.newHashMap();
  protected volatile Binder dm;
  private final Object dn = new Object();

  public static Typeface Z()
  {
    return dh;
  }

  @SuppressLint({"NewApi"})
  public static boolean a(AppWidgetManager paramAppWidgetManager, int paramInt)
  {
    if (dp < 17);
    while (paramAppWidgetManager.getAppWidgetOptions(paramInt).getInt("appWidgetCategory", -1) != 2)
      return false;
    return true;
  }

  @SuppressLint({"NewApi"})
  public static boolean a(ContentResolver paramContentResolver)
  {
    if (dp < 17)
      if (Settings.System.getInt(paramContentResolver, "airplane_mode_on", 0) == 0);
    while (Settings.Global.getInt(paramContentResolver, "airplane_mode_on", 0) != 0)
    {
      return true;
      return false;
    }
    return false;
  }

  @SuppressLint({"NewApi"})
  public static boolean a(Context paramContext)
  {
    if (dp < 18)
      return false;
    return ((WifiManager)paramContext.getSystemService("wifi")).isScanAlwaysAvailable();
  }

  public static Typeface aa()
  {
    return di;
  }

  public static Typeface ab()
  {
    return dj;
  }

  public static Typeface ac()
  {
    return dk;
  }

  public static boolean ad()
  {
    return dp >= 16;
  }

  public static boolean ae()
  {
    return dp >= 16;
  }

  public static boolean af()
  {
    return dp >= 16;
  }

  public static boolean ag()
  {
    return dp >= 16;
  }

  public static boolean ah()
  {
    return dp >= 16;
  }

  public static boolean ai()
  {
    return dp >= 16;
  }

  public static boolean aj()
  {
    return dp >= 16;
  }

  public static boolean ak()
  {
    return dp >= 16;
  }

  public static boolean al()
  {
    return dp >= 16;
  }

  public static boolean am()
  {
    return dp >= 19;
  }

  public static boolean an()
  {
    return dp >= 18;
  }

  public static boolean ao()
  {
    return dp < 16;
  }

  public static boolean ap()
  {
    return Build.VERSION.SDK_INT >= 21;
  }

  public static boolean aq()
  {
    return Build.VERSION.SDK_INT > 21;
  }

  public static boolean ar()
  {
    return dp > 22;
  }

  public static boolean as()
  {
    return Build.VERSION.SDK_INT >= 15;
  }

  public static boolean at()
  {
    return dp >= 19;
  }

  public static String[] au()
  {
    return dl;
  }

  public static HashMap<String, Object> av()
  {
    return dt;
  }

  public static Tracker b(Context paramContext)
  {
    if (jdField_do == null)
    {
      GoogleAnalytics localGoogleAnalytics = GoogleAnalytics.getInstance(paramContext.getApplicationContext());
      localGoogleAnalytics.getLogger().setLogLevel(Logger.LogLevel.VERBOSE);
      jdField_do = localGoogleAnalytics.getTracker(paramContext.getString(2131230840));
      jdField_do.send(MapBuilder.createEvent(paramContext.getString(2131230867), paramContext.getString(2131230868), paramContext.getString(2131231018), null).set("&sc", "start").build());
    }
    return jdField_do;
  }

  public static String c(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName;
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
    }
    return null;
  }

  public static int d(Context paramContext)
  {
    try
    {
      int i = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionCode;
      return i;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
    }
    return -1;
  }

  public static String d(String paramString)
  {
    return "active_document_" + paramString;
  }

  @SuppressLint({"NewApi"})
  public static boolean isLayoutRtl(View paramView)
  {
    if (dp >= 17)
      return 1 == paramView.getLayoutDirection();
    return false;
  }

  public Binder aw()
  {
    if (dm == null);
    synchronized (dn)
    {
      if (dm == null)
        dm = new Binder(this);
      return dm;
    }
  }

  public final void onCreate()
  {
    super.onCreate();
    ColorMap.init(this);
    AssetManager localAssetManager = getAssets();
    dh = Typeface.createFromAsset(localAssetManager, "fonts/RobotoSlab/RobotoSlab-Regular.ttf");
    di = Typeface.createFromAsset(localAssetManager, "fonts/RobotoSlab/RobotoSlab-Bold.ttf");
    dj = Typeface.createFromAsset(localAssetManager, "fonts/RobotoSlab/RobotoSlab-Light.ttf");
    dk = Typeface.createFromAsset(localAssetManager, "fonts/RobotoSlab/RobotoSlab-Thin.ttf");
    Config.E(this);
    GservicesValue.init(this);
    w.init(this);
    x.init(this);
    g.E(this);
    startService(new Intent(this, CleanupService.class));
    RemindersDBUpgradeService.y(this);
  }
}
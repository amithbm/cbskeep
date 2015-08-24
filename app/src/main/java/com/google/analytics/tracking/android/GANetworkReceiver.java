package com.google.analytics.tracking.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

class GANetworkReceiver extends BroadcastReceiver
{
  static final String SELF_IDENTIFYING_EXTRA = GANetworkReceiver.class.getName();
  private final ServiceManager mManager;

  GANetworkReceiver(ServiceManager paramServiceManager)
  {
    mManager = paramServiceManager;
  }

  public static void sendRadioPoweredBroadcast(Context paramContext)
  {
    Intent localIntent = new Intent("com.google.analytics.RADIO_POWERED");
    localIntent.addCategory(paramContext.getPackageName());
    localIntent.putExtra(SELF_IDENTIFYING_EXTRA, true);
    paramContext.sendBroadcast(localIntent);
  }

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ("android.net.conn.CONNECTIVITY_CHANGE".equals(paramContext))
    {
      localBundle = paramIntent.getExtras();
      paramContext = Boolean.FALSE;
      if (localBundle != null)
        paramContext = Boolean.valueOf(paramIntent.getExtras().getBoolean("noConnectivity"));
      paramIntent = mManager;
      if (!paramContext.booleanValue())
      {
        bool = true;
        paramIntent.updateConnectivityStatus(bool);
      }
    }
    while ((!"com.google.analytics.RADIO_POWERED".equals(paramContext)) || (paramIntent.hasExtra(SELF_IDENTIFYING_EXTRA)))
      while (true)
      {
        Bundle localBundle;
        return;
        boolean bool = false;
      }
    mManager.onRadioPowered();
  }

  public void register(Context paramContext)
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    paramContext.registerReceiver(this, localIntentFilter);
    localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.google.analytics.RADIO_POWERED");
    localIntentFilter.addCategory(paramContext.getPackageName());
    paramContext.registerReceiver(this, localIntentFilter);
  }
}
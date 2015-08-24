package com.google.android.keep.notification;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;

public class AlertReceiver extends WakefulBroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(paramContext, AlertService.class);
    String str = paramIntent.getAction();
    localIntent.setAction(str);
    localIntent.putExtras(paramIntent);
    if (("android.intent.action.LOCALE_CHANGED".equals(str)) || ("com.google.android.keep.intent.action.PROVIDER_CHANGED".equals(str)) || ("android.net.wifi.WIFI_STATE_CHANGED".equals(str)))
    {
      paramContext.startService(localIntent);
      return;
    }
    startWakefulService(paramContext, localIntent);
  }
}
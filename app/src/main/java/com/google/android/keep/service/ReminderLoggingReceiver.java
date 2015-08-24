package com.google.android.keep.service;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;

public class ReminderLoggingReceiver extends WakefulBroadcastReceiver
{
  private static final String TAG = ReminderLoggingReceiver.class.getSimpleName();

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null);
    do
    {
      return;
      localObject = paramIntent.getAction();
    }
    while ((!"android.intent.action.BOOT_COMPLETED".equals(localObject)) && (!"android.intent.action.MY_PACKAGE_REPLACED".equals(localObject)));
    Object localObject = new Intent();
    ((Intent)localObject).setClass(paramContext, ReminderLoggingService.class);
    ((Intent)localObject).putExtras(paramIntent);
    ((Intent)localObject).setAction("com.google.android.keep.intent.action.SCHEDULE_REMINDER_LOGGING");
    startWakefulService(paramContext, (Intent)localObject);
  }
}
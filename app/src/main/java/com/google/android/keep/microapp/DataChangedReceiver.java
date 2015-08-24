package com.google.android.keep.microapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class DataChangedReceiver extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(paramContext, WearableDataChangedService.class);
    localIntent.setAction(paramIntent.getAction());
    localIntent.putExtras(paramIntent);
    paramContext.startService(localIntent);
  }
}
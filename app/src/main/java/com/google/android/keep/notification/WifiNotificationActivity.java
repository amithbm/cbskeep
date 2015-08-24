package com.google.android.keep.notification;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.google.android.keep.util.A;

public class WifiNotificationActivity extends FragmentActivity
{
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getAction();
      if (!"com.google.android.keep.intent.action.WIFI_NOTIFICATION_GOTO_SETTINGS".equals(paramBundle))
        break label73;
      A.e(this, A.Z(this) + 1);
      new g(this).bB(3);
      startActivity(new Intent("android.settings.WIFI_SETTINGS").setFlags(268435456));
    }
    while (true)
    {
      finish();
      return;
      label73: if ("com.google.android.keep.intent.action.WIFI_NOTIFICATION_IGNORE".equals(paramBundle))
      {
        new g(this).bB(3);
        A.c(this, true);
      }
      else if ("com.google.android.keep.intent.action.WIFI_NOTIFICATION_DISMISS".equals(paramBundle))
      {
        A.e(this, A.Z(this) + 1);
      }
    }
  }
}
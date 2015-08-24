package com.google.android.gms.wearable;

public abstract interface AncsApi
{
  public static abstract interface AncsListener
  {
    public abstract void onNotificationReceived(AncsNotification paramAncsNotification);
  }
}
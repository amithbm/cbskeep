package com.google.android.gms.wearable;

public abstract interface CapabilityApi
{
  public static abstract interface CapabilityListener
  {
    public abstract void onCapabilityChanged(CapabilityInfo paramCapabilityInfo);
  }
}
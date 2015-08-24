package com.google.analytics.tracking.android;

public abstract class ServiceManager
{
  @Deprecated
  public abstract void dispatchLocalHits();

  abstract void onRadioPowered();

  @Deprecated
  public abstract void setLocalDispatchPeriod(int paramInt);

  abstract void updateConnectivityStatus(boolean paramBoolean);
}
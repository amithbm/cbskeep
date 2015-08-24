package com.google.analytics.tracking.android;

import java.util.List;

abstract interface Dispatcher
{
  public abstract int dispatchHits(List<Hit> paramList);

  public abstract boolean okToDispatch();

  public abstract void overrideHostUrl(String paramString);
}
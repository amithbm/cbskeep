package com.google.analytics.tracking.android;

import com.google.android.gms.analytics.internal.Command;
import java.util.List;
import java.util.Map;

abstract interface ServiceProxy
{
  public abstract void createService();

  public abstract void dispatch();

  public abstract void putHit(Map<String, String> paramMap, long paramLong, String paramString, List<Command> paramList);

  public abstract void setForceLocalDispatch();
}
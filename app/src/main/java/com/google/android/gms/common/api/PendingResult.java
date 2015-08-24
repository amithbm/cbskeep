package com.google.android.gms.common.api;

import java.util.concurrent.TimeUnit;

public abstract interface PendingResult<R extends Result>
{
  public abstract R await();

  public abstract R await(long paramLong, TimeUnit paramTimeUnit);

  public abstract void setResultCallback(ResultCallback<R> paramResultCallback);

  public abstract void setResultCallback(ResultCallback<R> paramResultCallback, long paramLong, TimeUnit paramTimeUnit);

  public static abstract interface BatchCallback
  {
    public abstract void zzG(Status paramStatus);
  }
}
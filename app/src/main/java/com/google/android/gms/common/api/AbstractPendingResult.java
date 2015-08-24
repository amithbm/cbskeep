package com.google.android.gms.common.api;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.internal.ICancelToken;
import com.google.android.gms.common.internal.zzv;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public abstract class AbstractPendingResult<R extends Result>
  implements PendingResult<R>
{
  protected final CallbackHandler<R> mHandler;
  private boolean zzL;
  private volatile boolean zzagA;
  private boolean zzagB;
  private ICancelToken zzagC;
  private final Object zzagw = new Object();
  private final ArrayList<PendingResult.BatchCallback> zzagx = new ArrayList();
  private ResultCallback<R> zzagy;
  private volatile R zzagz;
  private final CountDownLatch zzpi = new CountDownLatch(1);

  protected AbstractPendingResult(Looper paramLooper)
  {
    mHandler = new CallbackHandler(paramLooper);
  }

  private void zza(R paramR)
  {
    zzagz = paramR;
    zzagC = null;
    zzpi.countDown();
    paramR = zzagz.getStatus();
    if (zzagy != null)
    {
      mHandler.removeTimeoutMessages();
      if (!zzL)
        mHandler.sendResultCallback(zzagy, zzoq());
    }
    Iterator localIterator = zzagx.iterator();
    while (localIterator.hasNext())
      ((PendingResult.BatchCallback)localIterator.next()).zzG(paramR);
    zzagx.clear();
  }

  static void zzb(Result paramResult)
  {
    if ((paramResult instanceof Releasable));
    try
    {
      ((Releasable)paramResult).release();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      Log.w("AbstractPendingResult", "Unable to release " + paramResult, localRuntimeException);
    }
  }

  private R zzoq()
  {
    boolean bool = true;
    synchronized (zzagw)
    {
      if (!zzagA)
      {
        zzv.zza(bool, "Result has already been consumed.");
        zzv.zza(isReady(), "Result is not ready.");
        Result localResult = zzagz;
        zzagz = null;
        zzagy = null;
        zzagA = true;
        onResultConsumed();
        return localResult;
      }
      bool = false;
    }
  }

  public final R await()
  {
    boolean bool2 = true;
    boolean bool1;
    if (Looper.myLooper() != Looper.getMainLooper())
      bool1 = true;
    while (true)
    {
      zzv.zza(bool1, "await must not be called on the UI thread");
      if (!zzagA)
      {
        bool1 = bool2;
        zzv.zza(bool1, "Result has already been consumed");
      }
      try
      {
        zzpi.await();
        zzv.zza(isReady(), "Result is not ready.");
        return zzoq();
        bool1 = false;
        continue;
        bool1 = false;
      }
      catch (InterruptedException localInterruptedException)
      {
        while (true)
          forceFailureUnlessReady(Status.zzaij);
      }
    }
  }

  public final R await(long paramLong, TimeUnit paramTimeUnit)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramLong <= 0L) || (Looper.myLooper() != Looper.getMainLooper()))
      bool1 = true;
    while (true)
    {
      zzv.zza(bool1, "await must not be called on the UI thread when time is greater than zero.");
      if (!zzagA)
      {
        bool1 = bool2;
        zzv.zza(bool1, "Result has already been consumed.");
      }
      try
      {
        if (!zzpi.await(paramLong, paramTimeUnit))
          forceFailureUnlessReady(Status.zzail);
        zzv.zza(isReady(), "Result is not ready.");
        return zzoq();
        bool1 = false;
        continue;
        bool1 = false;
      }
      catch (InterruptedException paramTimeUnit)
      {
        while (true)
          forceFailureUnlessReady(Status.zzaij);
      }
    }
  }

  public void cancel()
  {
    synchronized (zzagw)
    {
      if ((zzL) || (zzagA))
        return;
      ICancelToken localICancelToken = zzagC;
      if (localICancelToken == null);
    }
    try
    {
      zzagC.cancel();
      label42: zzb(zzagz);
      zzagy = null;
      zzL = true;
      zza(createFailedResult(Status.zzaim));
      return;
      localObject2 = finally;
      throw localObject2;
    }
    catch (RemoteException localRemoteException)
    {
      break label42;
    }
  }

  protected abstract R createFailedResult(Status paramStatus);

  public final void forceFailureUnlessReady(Status paramStatus)
  {
    synchronized (zzagw)
    {
      if (!isReady())
      {
        setResult(createFailedResult(paramStatus));
        zzagB = true;
      }
      return;
    }
  }

  public boolean isCanceled()
  {
    synchronized (zzagw)
    {
      boolean bool = zzL;
      return bool;
    }
  }

  public final boolean isReady()
  {
    return zzpi.getCount() == 0L;
  }

  protected void onResultConsumed()
  {
  }

  protected final void setCancelToken(ICancelToken paramICancelToken)
  {
    synchronized (zzagw)
    {
      zzagC = paramICancelToken;
      return;
    }
  }

  public final void setResult(R paramR)
  {
    boolean bool2 = true;
    while (true)
    {
      synchronized (zzagw)
      {
        if ((zzagB) || (zzL))
        {
          zzb(paramR);
          return;
        }
        if (!isReady())
        {
          bool1 = true;
          zzv.zza(bool1, "Results have already been set");
          if (zzagA)
            break label83;
          bool1 = bool2;
          zzv.zza(bool1, "Result has already been consumed");
          zza(paramR);
          return;
        }
      }
      boolean bool1 = false;
      continue;
      label83: bool1 = false;
    }
  }

  public final void setResultCallback(ResultCallback<R> paramResultCallback)
  {
    if (!zzagA);
    for (boolean bool = true; ; bool = false)
    {
      zzv.zza(bool, "Result has already been consumed.");
      while (true)
      {
        synchronized (zzagw)
        {
          if (isCanceled())
            return;
          if (isReady())
          {
            mHandler.sendResultCallback(paramResultCallback, zzoq());
            return;
          }
        }
        zzagy = paramResultCallback;
      }
    }
  }

  public final void setResultCallback(ResultCallback<R> paramResultCallback, long paramLong, TimeUnit paramTimeUnit)
  {
    if (!zzagA);
    for (boolean bool = true; ; bool = false)
    {
      zzv.zza(bool, "Result has already been consumed.");
      while (true)
      {
        synchronized (zzagw)
        {
          if (isCanceled())
            return;
          if (isReady())
          {
            mHandler.sendResultCallback(paramResultCallback, zzoq());
            return;
          }
        }
        zzagy = paramResultCallback;
        mHandler.sendTimeoutResultCallback(this, paramTimeUnit.toMillis(paramLong));
      }
    }
  }

  public static class CallbackHandler<R extends Result> extends Handler
  {
    public CallbackHandler()
    {
      this(Looper.getMainLooper());
    }

    public CallbackHandler(Looper paramLooper)
    {
      super();
    }

    protected void deliverResultCallback(ResultCallback<R> paramResultCallback, R paramR)
    {
      try
      {
        paramResultCallback.onResult(paramR);
        return;
      }
      catch (RuntimeException paramResultCallback)
      {
        AbstractPendingResult.zzb(paramR);
      }
      throw paramResultCallback;
    }

    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default:
        Log.wtf("AbstractPendingResult", "Don't know how to handle this message.");
        return;
      case 1:
        paramMessage = (Pair)paramMessage.obj;
        deliverResultCallback((ResultCallback)paramMessage.first, (Result)paramMessage.second);
        return;
      case 2:
      }
      ((AbstractPendingResult)paramMessage.obj).forceFailureUnlessReady(Status.zzail);
    }

    public void removeTimeoutMessages()
    {
      removeMessages(2);
    }

    public void sendResultCallback(ResultCallback<R> paramResultCallback, R paramR)
    {
      sendMessage(obtainMessage(1, new Pair(paramResultCallback, paramR)));
    }

    public void sendTimeoutResultCallback(AbstractPendingResult<R> paramAbstractPendingResult, long paramLong)
    {
      sendMessageDelayed(obtainMessage(2, paramAbstractPendingResult), paramLong);
    }
  }
}
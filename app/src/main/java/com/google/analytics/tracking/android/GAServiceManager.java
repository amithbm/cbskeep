package com.google.analytics.tracking.android;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;

public class GAServiceManager extends ServiceManager
{
  private static final Object MSG_OBJECT = new Object();
  private static GAServiceManager instance;
  private boolean connected = true;
  private Context ctx;
  private int dispatchPeriodInSeconds = 1800;
  private Handler handler;
  private boolean listenForNetwork = true;
  private AnalyticsStoreStateListener listener = new AnalyticsStoreStateListener()
  {
    public void reportStoreIsEmpty(boolean paramAnonymousBoolean)
    {
      updatePowerSaveMode(paramAnonymousBoolean, connected);
    }
  };
  private GANetworkReceiver networkReceiver;
  private boolean pendingDispatch = true;
  private boolean pendingForceLocalDispatch;
  private String pendingHostOverride;
  private AnalyticsStore store;
  private boolean storeIsEmpty = false;
  private volatile AnalyticsThread thread;

  public static GAServiceManager getInstance()
  {
    if (instance == null)
      instance = new GAServiceManager();
    return instance;
  }

  private void initializeHandler()
  {
    handler = new Handler(ctx.getMainLooper(), new Handler.Callback()
    {
      public boolean handleMessage(Message paramAnonymousMessage)
      {
        if ((1 == paramAnonymousMessage.what) && (GAServiceManager.MSG_OBJECT.equals(paramAnonymousMessage.obj)))
        {
          GAUsage.getInstance().setDisableUsage(true);
          dispatchLocalHits();
          GAUsage.getInstance().setDisableUsage(false);
          if ((dispatchPeriodInSeconds > 0) && (!storeIsEmpty))
            handler.sendMessageDelayed(handler.obtainMessage(1, GAServiceManager.MSG_OBJECT), dispatchPeriodInSeconds * 1000);
        }
        return true;
      }
    });
    if (dispatchPeriodInSeconds > 0)
      handler.sendMessageDelayed(handler.obtainMessage(1, MSG_OBJECT), dispatchPeriodInSeconds * 1000);
  }

  private void initializeNetworkReceiver()
  {
    networkReceiver = new GANetworkReceiver(this);
    networkReceiver.register(ctx);
  }

  @Deprecated
  public void dispatchLocalHits()
  {
    try
    {
      if (thread == null)
      {
        Log.v("Dispatch call queued. Dispatch will run once initialization is complete.");
        pendingDispatch = true;
      }
      while (true)
      {
        return;
        GAUsage.getInstance().setUsage(GAUsage.Field.DISPATCH);
        thread.dispatch();
      }
    }
    finally
    {
    }
  }

  AnalyticsStore getStore()
  {
    try
    {
      if (store != null)
        break label80;
      if (ctx == null)
        throw new IllegalStateException("Cant get a store unless we have a context");
    }
    finally
    {
    }
    store = new PersistentAnalyticsStore(listener, ctx);
    if (pendingHostOverride != null)
    {
      store.getDispatcher().overrideHostUrl(pendingHostOverride);
      pendingHostOverride = null;
    }
    label80: if (handler == null)
      initializeHandler();
    if ((networkReceiver == null) && (listenForNetwork))
      initializeNetworkReceiver();
    AnalyticsStore localAnalyticsStore = store;
    return localAnalyticsStore;
  }

  void initialize(Context paramContext, AnalyticsThread paramAnalyticsThread)
  {
    try
    {
      Context localContext = ctx;
      if (localContext != null);
      while (true)
      {
        return;
        ctx = paramContext.getApplicationContext();
        if (thread == null)
        {
          thread = paramAnalyticsThread;
          if (pendingDispatch)
          {
            dispatchLocalHits();
            pendingDispatch = false;
          }
          if (pendingForceLocalDispatch)
          {
            setForceLocalDispatch();
            pendingForceLocalDispatch = false;
          }
        }
      }
    }
    finally
    {
    }
    throw paramContext;
  }

  void onRadioPowered()
  {
    try
    {
      if ((!storeIsEmpty) && (connected) && (dispatchPeriodInSeconds > 0))
      {
        handler.removeMessages(1, MSG_OBJECT);
        handler.sendMessage(handler.obtainMessage(1, MSG_OBJECT));
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  @Deprecated
  public void setForceLocalDispatch()
  {
    if (thread == null)
    {
      Log.v("setForceLocalDispatch() queued. It will be called once initialization is complete.");
      pendingForceLocalDispatch = true;
      return;
    }
    GAUsage.getInstance().setUsage(GAUsage.Field.SET_FORCE_LOCAL_DISPATCH);
    thread.setForceLocalDispatch();
  }

  @Deprecated
  public void setLocalDispatchPeriod(int paramInt)
  {
    try
    {
      if (handler == null)
      {
        Log.v("Dispatch period set with null handler. Dispatch will run once initialization is complete.");
        dispatchPeriodInSeconds = paramInt;
      }
      while (true)
      {
        return;
        GAUsage.getInstance().setUsage(GAUsage.Field.SET_DISPATCH_PERIOD);
        if ((!storeIsEmpty) && (connected) && (dispatchPeriodInSeconds > 0))
          handler.removeMessages(1, MSG_OBJECT);
        dispatchPeriodInSeconds = paramInt;
        if ((paramInt > 0) && (!storeIsEmpty) && (connected))
          handler.sendMessageDelayed(handler.obtainMessage(1, MSG_OBJECT), paramInt * 1000);
      }
    }
    finally
    {
    }
  }

  void updateConnectivityStatus(boolean paramBoolean)
  {
    try
    {
      updatePowerSaveMode(storeIsEmpty, paramBoolean);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  void updatePowerSaveMode(boolean paramBoolean1, boolean paramBoolean2)
  {
    while (true)
    {
      try
      {
        if (storeIsEmpty == paramBoolean1)
        {
          boolean bool = connected;
          if (bool == paramBoolean2)
            return;
        }
        if (((paramBoolean1) || (!paramBoolean2)) && (dispatchPeriodInSeconds > 0))
          handler.removeMessages(1, MSG_OBJECT);
        if ((!paramBoolean1) && (paramBoolean2) && (dispatchPeriodInSeconds > 0))
          handler.sendMessageDelayed(handler.obtainMessage(1, MSG_OBJECT), dispatchPeriodInSeconds * 1000);
        StringBuilder localStringBuilder = new StringBuilder().append("PowerSaveMode ");
        if (paramBoolean1)
          break label157;
        if (!paramBoolean2)
        {
          break label157;
          String str1;
          Log.v(str1);
          storeIsEmpty = paramBoolean1;
          connected = paramBoolean2;
          continue;
        }
      }
      finally
      {
      }
      String str2 = "terminated.";
      continue;
      label157: str2 = "initiated.";
    }
  }
}
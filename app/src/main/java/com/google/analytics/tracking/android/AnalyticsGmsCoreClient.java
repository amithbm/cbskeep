package com.google.analytics.tracking.android;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.analytics.internal.Command;
import com.google.android.gms.analytics.internal.IAnalyticsService;
import com.google.android.gms.analytics.internal.IAnalyticsService.Stub;
import java.util.List;
import java.util.Map;

class AnalyticsGmsCoreClient
  implements AnalyticsClient
{
  private ServiceConnection mConnection;
  private Context mContext;
  private OnConnectedListener mOnConnectedListener;
  private OnConnectionFailedListener mOnConnectionFailedListener;
  private IAnalyticsService mService;

  public AnalyticsGmsCoreClient(Context paramContext, OnConnectedListener paramOnConnectedListener, OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    mContext = paramContext;
    if (paramOnConnectedListener == null)
      throw new IllegalArgumentException("onConnectedListener cannot be null");
    mOnConnectedListener = paramOnConnectedListener;
    if (paramOnConnectionFailedListener == null)
      throw new IllegalArgumentException("onConnectionFailedListener cannot be null");
    mOnConnectionFailedListener = paramOnConnectionFailedListener;
  }

  private IAnalyticsService getService()
  {
    checkConnected();
    return mService;
  }

  private void onConnectionSuccess()
  {
    mOnConnectedListener.onConnected();
  }

  private void onServiceBound()
  {
    onConnectionSuccess();
  }

  protected void checkConnected()
  {
    if (!isConnected())
      throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
  }

  public void clearHits()
  {
    try
    {
      getService().clearHits();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      Log.e("clear hits failed: " + localRemoteException);
    }
  }

  public void connect()
  {
    Intent localIntent = new Intent("com.google.android.gms.analytics.service.START");
    localIntent.setComponent(new ComponentName("com.google.android.gms", "com.google.android.gms.analytics.service.AnalyticsService"));
    localIntent.putExtra("app_package_name", mContext.getPackageName());
    if (mConnection != null)
      Log.e("Calling connect() while still connected, missing disconnect().");
    boolean bool;
    do
    {
      return;
      mConnection = new AnalyticsServiceConnection();
      bool = mContext.bindService(localIntent, mConnection, 129);
      Log.v("connect: bindService returned " + bool + " for " + localIntent);
    }
    while (bool);
    mConnection = null;
    mOnConnectionFailedListener.onConnectionFailed(1, null);
  }

  public void disconnect()
  {
    mService = null;
    if (mConnection != null);
    try
    {
      mContext.unbindService(mConnection);
      label23: mConnection = null;
      mOnConnectedListener.onDisconnected();
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      break label23;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      break label23;
    }
  }

  public boolean isConnected()
  {
    return mService != null;
  }

  public void sendHit(Map<String, String> paramMap, long paramLong, String paramString, List<Command> paramList)
  {
    try
    {
      getService().sendHit(paramMap, paramLong, paramString, paramList);
      return;
    }
    catch (RemoteException paramMap)
    {
      Log.e("sendHit failed: " + paramMap);
    }
  }

  final class AnalyticsServiceConnection
    implements ServiceConnection
  {
    AnalyticsServiceConnection()
    {
    }

    public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
    {
      Log.v("service connected, binder: " + paramIBinder);
      try
      {
        if ("com.google.android.gms.analytics.internal.IAnalyticsService".equals(paramIBinder.getInterfaceDescriptor()))
        {
          Log.v("bound to service");
          AnalyticsGmsCoreClient.access$002(AnalyticsGmsCoreClient.this, IAnalyticsService.Stub.asInterface(paramIBinder));
          AnalyticsGmsCoreClient.this.onServiceBound();
          return;
        }
      }
      catch (RemoteException paramComponentName)
      {
        mContext.unbindService(this);
        AnalyticsGmsCoreClient.access$302(AnalyticsGmsCoreClient.this, null);
        mOnConnectionFailedListener.onConnectionFailed(2, null);
      }
    }

    public void onServiceDisconnected(ComponentName paramComponentName)
    {
      Log.v("service disconnected: " + paramComponentName);
      AnalyticsGmsCoreClient.access$302(AnalyticsGmsCoreClient.this, null);
      mOnConnectedListener.onDisconnected();
    }
  }

  public static abstract interface OnConnectedListener
  {
    public abstract void onConnected();

    public abstract void onDisconnected();
  }

  public static abstract interface OnConnectionFailedListener
  {
    public abstract void onConnectionFailed(int paramInt, Intent paramIntent);
  }
}
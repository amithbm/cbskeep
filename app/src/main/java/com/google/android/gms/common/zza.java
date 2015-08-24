package com.google.android.gms.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class zza
  implements ServiceConnection
{
  boolean zzafZ = false;
  private final BlockingQueue<IBinder> zzaga = new LinkedBlockingQueue();

  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    zzaga.add(paramIBinder);
  }

  public void onServiceDisconnected(ComponentName paramComponentName)
  {
  }

  public IBinder zzok()
    throws InterruptedException
  {
    if (Looper.myLooper() == Looper.getMainLooper())
      throw new IllegalStateException("BlockingServiceConnection.getService() called on main thread");
    if (zzafZ)
      throw new IllegalStateException();
    zzafZ = true;
    return (IBinder)zzaga.take();
  }
}
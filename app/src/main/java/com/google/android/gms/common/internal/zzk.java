package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

public final class zzk
  implements Handler.Callback
{
  private final Handler mHandler;
  private final zza zzalH;
  private final ArrayList<GoogleApiClient.ConnectionCallbacks> zzalI = new ArrayList();
  final ArrayList<GoogleApiClient.ConnectionCallbacks> zzalJ = new ArrayList();
  private final ArrayList<GoogleApiClient.OnConnectionFailedListener> zzalK = new ArrayList();
  private volatile boolean zzalL = false;
  private final AtomicInteger zzalM = new AtomicInteger(0);
  private boolean zzalN = false;
  private final Object zzqY = new Object();

  public zzk(Looper paramLooper, zza paramzza)
  {
    zzalH = paramzza;
    mHandler = new Handler(paramLooper, this);
  }

  public boolean handleMessage(Message arg1)
  {
    if (???.what == 1)
    {
      GoogleApiClient.ConnectionCallbacks localConnectionCallbacks = (GoogleApiClient.ConnectionCallbacks)???.obj;
      synchronized (zzqY)
      {
        if ((zzalL) && (zzalH.isConnected()) && (zzalI.contains(localConnectionCallbacks)))
          localConnectionCallbacks.onConnected(zzalH.zznK());
        return true;
      }
    }
    Log.wtf("GmsClientEvents", "Don't know how to handle this message.");
    return false;
  }

  public void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    zzv.zzz(paramConnectionCallbacks);
    synchronized (zzqY)
    {
      if (zzalI.contains(paramConnectionCallbacks))
      {
        Log.w("GmsClientEvents", "registerConnectionCallbacks(): listener " + paramConnectionCallbacks + " is already registered");
        if (zzalH.isConnected())
          mHandler.sendMessage(mHandler.obtainMessage(1, paramConnectionCallbacks));
        return;
      }
      zzalI.add(paramConnectionCallbacks);
    }
  }

  public void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    zzv.zzz(paramOnConnectionFailedListener);
    synchronized (zzqY)
    {
      if (zzalK.contains(paramOnConnectionFailedListener))
      {
        Log.w("GmsClientEvents", "registerConnectionFailedListener(): listener " + paramOnConnectionFailedListener + " is already registered");
        return;
      }
      zzalK.add(paramOnConnectionFailedListener);
    }
  }

  public void unregisterConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    zzv.zzz(paramConnectionCallbacks);
    synchronized (zzqY)
    {
      if (!zzalI.remove(paramConnectionCallbacks))
        Log.w("GmsClientEvents", "unregisterConnectionCallbacks(): listener " + paramConnectionCallbacks + " not found");
      while (!zzalN)
        return;
      zzalJ.add(paramConnectionCallbacks);
    }
  }

  public void unregisterConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    zzv.zzz(paramOnConnectionFailedListener);
    synchronized (zzqY)
    {
      if (!zzalK.remove(paramOnConnectionFailedListener))
        Log.w("GmsClientEvents", "unregisterConnectionFailedListener(): listener " + paramOnConnectionFailedListener + " not found");
      return;
    }
  }

  public void zzeM(int paramInt)
  {
    mHandler.removeMessages(1);
    synchronized (zzqY)
    {
      zzalN = true;
      Object localObject2 = new ArrayList(zzalI);
      int i = zzalM.get();
      localObject2 = ((ArrayList)localObject2).iterator();
      GoogleApiClient.ConnectionCallbacks localConnectionCallbacks;
      do
        if (((Iterator)localObject2).hasNext())
        {
          localConnectionCallbacks = (GoogleApiClient.ConnectionCallbacks)((Iterator)localObject2).next();
          if ((zzalL) && (zzalM.get() == i));
        }
        else
        {
          zzalJ.clear();
          zzalN = false;
          return;
        }
      while (!zzalI.contains(localConnectionCallbacks));
      localConnectionCallbacks.onConnectionSuspended(paramInt);
    }
  }

  public void zzh(ConnectionResult paramConnectionResult)
  {
    mHandler.removeMessages(1);
    synchronized (zzqY)
    {
      Object localObject2 = new ArrayList(zzalK);
      int i = zzalM.get();
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        GoogleApiClient.OnConnectionFailedListener localOnConnectionFailedListener = (GoogleApiClient.OnConnectionFailedListener)((Iterator)localObject2).next();
        if ((!zzalL) || (zzalM.get() != i))
          return;
        if (zzalK.contains(localOnConnectionFailedListener))
          localOnConnectionFailedListener.onConnectionFailed(paramConnectionResult);
      }
    }
  }

  public void zzl(Bundle paramBundle)
  {
    boolean bool2 = true;
    while (true)
    {
      synchronized (zzqY)
      {
        if (!zzalN)
        {
          bool1 = true;
          zzv.zzR(bool1);
          mHandler.removeMessages(1);
          zzalN = true;
          if (zzalJ.size() != 0)
            break label185;
          bool1 = bool2;
          zzv.zzR(bool1);
          Object localObject2 = new ArrayList(zzalI);
          int i = zzalM.get();
          localObject2 = ((ArrayList)localObject2).iterator();
          GoogleApiClient.ConnectionCallbacks localConnectionCallbacks;
          if (((Iterator)localObject2).hasNext())
          {
            localConnectionCallbacks = (GoogleApiClient.ConnectionCallbacks)((Iterator)localObject2).next();
            if ((zzalL) && (zzalH.isConnected()) && (zzalM.get() == i));
          }
          else
          {
            zzalJ.clear();
            zzalN = false;
            return;
          }
          if (zzalJ.contains(localConnectionCallbacks))
            continue;
          localConnectionCallbacks.onConnected(paramBundle);
        }
      }
      boolean bool1 = false;
      continue;
      label185: bool1 = false;
    }
  }

  public void zzpU()
  {
    zzalL = false;
    zzalM.incrementAndGet();
  }

  public void zzpV()
  {
    zzalL = true;
  }

  public static abstract interface zza
  {
    public abstract boolean isConnected();

    public abstract Bundle zznK();
  }
}
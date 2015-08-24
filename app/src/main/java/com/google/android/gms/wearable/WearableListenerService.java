package com.google.android.gms.wearable;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.internal.AncsNotificationParcelable;
import com.google.android.gms.wearable.internal.CapabilityInfoParcelable;
import com.google.android.gms.wearable.internal.ChannelEventParcelable;
import com.google.android.gms.wearable.internal.MessageEventParcelable;
import com.google.android.gms.wearable.internal.NodeParcelable;
import com.google.android.gms.wearable.internal.zzas.zza;
import java.util.List;

public abstract class WearableListenerService extends Service
  implements CapabilityApi.CapabilityListener, ChannelApi.ChannelListener, DataApi.DataListener, MessageApi.MessageListener, NodeApi.ConnectedNodesListener, NodeApi.NodeListener
{
  private String mPackageName;
  private volatile int zzoG = -1;
  private Handler zzoH;
  private IBinder zzoI;
  private Object zzoJ = new Object();
  private boolean zzoK;

  private void zzbj()
    throws SecurityException
  {
    int i = Binder.getCallingUid();
    if (i == zzoG)
      return;
    if (GooglePlayServicesUtil.zze(this, i))
    {
      zzoG = i;
      return;
    }
    throw new SecurityException("Caller is not GooglePlayServices");
  }

  public final IBinder onBind(Intent paramIntent)
  {
    if ("com.google.android.gms.wearable.BIND_LISTENER".equals(paramIntent.getAction()))
      return zzoI;
    return null;
  }

  public void onCapabilityChanged(CapabilityInfo paramCapabilityInfo)
  {
  }

  public void onChannelClosed(Channel paramChannel, int paramInt1, int paramInt2)
  {
  }

  public void onChannelOpened(Channel paramChannel)
  {
  }

  public void onConnectedNodes(List<Node> paramList)
  {
  }

  public void onCreate()
  {
    super.onCreate();
    if (Log.isLoggable("WearableLS", 3))
      Log.d("WearableLS", "onCreate: " + getPackageName());
    mPackageName = getPackageName();
    HandlerThread localHandlerThread = new HandlerThread("WearableListenerService");
    localHandlerThread.start();
    zzoH = new Handler(localHandlerThread.getLooper());
    zzoI = new zza();
  }

  public void onDataChanged(DataEventBuffer paramDataEventBuffer)
  {
  }

  public void onDestroy()
  {
    synchronized (zzoJ)
    {
      zzoK = true;
      if (zzoH == null)
        throw new IllegalStateException("onDestroy: mServiceHandler not set, did you override onCreate() but forget to call super.onCreate()?");
    }
    zzoH.getLooper().quit();
    super.onDestroy();
  }

  public void onInputClosed(Channel paramChannel, int paramInt1, int paramInt2)
  {
  }

  public void onMessageReceived(MessageEvent paramMessageEvent)
  {
  }

  public void onOutputClosed(Channel paramChannel, int paramInt1, int paramInt2)
  {
  }

  public void onPeerConnected(Node paramNode)
  {
  }

  public void onPeerDisconnected(Node paramNode)
  {
  }

  private class zza extends zzas.zza
  {
    boolean zzbGA = false;

    zza()
    {
    }

    public void onConnectedNodes(final List<NodeParcelable> paramList)
    {
      if (Log.isLoggable("WearableLS", 3))
        Log.d("WearableLS", "onConnectedNodes: " + WearableListenerService.zza(WearableListenerService.this) + ": " + paramList);
      WearableListenerService.zzb(WearableListenerService.this);
      synchronized (WearableListenerService.zzc(WearableListenerService.this))
      {
        if (WearableListenerService.zzd(WearableListenerService.this))
          return;
        WearableListenerService.zze(WearableListenerService.this).post(new Runnable()
        {
          public void run()
          {
            WearableListenerService.this.onConnectedNodes(paramList);
          }
        });
        return;
      }
    }

    public void zza(final AncsNotificationParcelable paramAncsNotificationParcelable)
    {
      if (Log.isLoggable("WearableLS", 3))
        Log.d("WearableLS", "onNotificationReceived: " + paramAncsNotificationParcelable);
      if (!zzbGA)
        return;
      WearableListenerService.zzb(WearableListenerService.this);
      final WearableListenerServiceFirstParty localWearableListenerServiceFirstParty = (WearableListenerServiceFirstParty)WearableListenerService.this;
      synchronized (WearableListenerService.zzc(WearableListenerService.this))
      {
        if (WearableListenerService.zzd(WearableListenerService.this))
          return;
      }
      WearableListenerService.zze(WearableListenerService.this).post(new Runnable()
      {
        public void run()
        {
          localWearableListenerServiceFirstParty.onNotificationReceived(paramAncsNotificationParcelable);
        }
      });
    }

    public void zza(final CapabilityInfoParcelable paramCapabilityInfoParcelable)
    {
      if (Log.isLoggable("WearableLS", 3))
        Log.d("WearableLS", "onConnectedCapabilityChanged: " + paramCapabilityInfoParcelable);
      WearableListenerService.zzb(WearableListenerService.this);
      synchronized (WearableListenerService.zzc(WearableListenerService.this))
      {
        if (WearableListenerService.zzd(WearableListenerService.this))
          return;
        WearableListenerService.zze(WearableListenerService.this).post(new Runnable()
        {
          public void run()
          {
            onCapabilityChanged(paramCapabilityInfoParcelable);
          }
        });
        return;
      }
    }

    public void zza(final ChannelEventParcelable paramChannelEventParcelable)
    {
      if (Log.isLoggable("WearableLS", 3))
        Log.d("WearableLS", "onChannelEvent: " + paramChannelEventParcelable);
      WearableListenerService.zzb(WearableListenerService.this);
      synchronized (WearableListenerService.zzc(WearableListenerService.this))
      {
        if (WearableListenerService.zzd(WearableListenerService.this))
          return;
        WearableListenerService.zze(WearableListenerService.this).post(new Runnable()
        {
          public void run()
          {
            paramChannelEventParcelable.zza(WearableListenerService.this);
          }
        });
        return;
      }
    }

    public void zza(final MessageEventParcelable paramMessageEventParcelable)
    {
      if (Log.isLoggable("WearableLS", 3))
        Log.d("WearableLS", "onMessageReceived: " + paramMessageEventParcelable);
      WearableListenerService.zzb(WearableListenerService.this);
      synchronized (WearableListenerService.zzc(WearableListenerService.this))
      {
        if (WearableListenerService.zzd(WearableListenerService.this))
          return;
        WearableListenerService.zze(WearableListenerService.this).post(new Runnable()
        {
          public void run()
          {
            onMessageReceived(paramMessageEventParcelable);
          }
        });
        return;
      }
    }

    public void zza(final NodeParcelable paramNodeParcelable)
    {
      if (Log.isLoggable("WearableLS", 3))
        Log.d("WearableLS", "onPeerConnected: " + WearableListenerService.zza(WearableListenerService.this) + ": " + paramNodeParcelable);
      WearableListenerService.zzb(WearableListenerService.this);
      synchronized (WearableListenerService.zzc(WearableListenerService.this))
      {
        if (WearableListenerService.zzd(WearableListenerService.this))
          return;
        WearableListenerService.zze(WearableListenerService.this).post(new Runnable()
        {
          public void run()
          {
            onPeerConnected(paramNodeParcelable);
          }
        });
        return;
      }
    }

    public void zzam(final DataHolder paramDataHolder)
    {
      if (Log.isLoggable("WearableLS", 3))
        Log.d("WearableLS", "onDataItemChanged: " + WearableListenerService.zza(WearableListenerService.this) + ": " + paramDataHolder);
      WearableListenerService.zzb(WearableListenerService.this);
      synchronized (WearableListenerService.zzc(WearableListenerService.this))
      {
        if (WearableListenerService.zzd(WearableListenerService.this))
        {
          paramDataHolder.close();
          return;
        }
        WearableListenerService.zze(WearableListenerService.this).post(new Runnable()
        {
          public void run()
          {
            DataEventBuffer localDataEventBuffer = new DataEventBuffer(paramDataHolder);
            try
            {
              onDataChanged(localDataEventBuffer);
              return;
            }
            finally
            {
              localDataEventBuffer.release();
            }
          }
        });
        return;
      }
    }

    public void zzb(final NodeParcelable paramNodeParcelable)
    {
      if (Log.isLoggable("WearableLS", 3))
        Log.d("WearableLS", "onPeerDisconnected: " + WearableListenerService.zza(WearableListenerService.this) + ": " + paramNodeParcelable);
      WearableListenerService.zzb(WearableListenerService.this);
      synchronized (WearableListenerService.zzc(WearableListenerService.this))
      {
        if (WearableListenerService.zzd(WearableListenerService.this))
          return;
        WearableListenerService.zze(WearableListenerService.this).post(new Runnable()
        {
          public void run()
          {
            onPeerDisconnected(paramNodeParcelable);
          }
        });
        return;
      }
    }
  }
}
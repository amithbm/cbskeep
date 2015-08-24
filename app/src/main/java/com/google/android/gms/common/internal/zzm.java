package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.IBinder;
import android.os.Message;
import com.google.android.gms.common.stats.zzb;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

final class zzm extends zzl
  implements Handler.Callback
{
  private final Handler mHandler;
  private final HashMap<zza, zzb> zzalQ = new HashMap();
  private final zzb zzalR;
  private final long zzalS;
  private final Context zzrb;

  zzm(Context paramContext)
  {
    zzrb = paramContext.getApplicationContext();
    mHandler = new Handler(paramContext.getMainLooper(), this);
    zzalR = zzb.zzqA();
    zzalS = 5000L;
  }

  private boolean zza(zza paramzza, ServiceConnection paramServiceConnection, String paramString)
  {
    zzv.zzb(paramServiceConnection, "ServiceConnection must not be null");
    while (true)
    {
      zzb localzzb;
      synchronized (zzalQ)
      {
        localzzb = (zzb)zzalQ.get(paramzza);
        if (localzzb == null)
        {
          localzzb = new zzb(paramzza);
          localzzb.zza(paramServiceConnection, paramString);
          localzzb.zzbX(paramString);
          zzalQ.put(paramzza, localzzb);
          paramzza = localzzb;
          boolean bool = paramzza.isBound();
          return bool;
        }
        mHandler.removeMessages(0, localzzb);
        if (localzzb.zza(paramServiceConnection))
          throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  config=" + paramzza);
      }
      localzzb.zza(paramServiceConnection, paramString);
      switch (localzzb.getState())
      {
      case 1:
        paramServiceConnection.onServiceConnected(localzzb.getComponentName(), localzzb.getBinder());
        paramzza = localzzb;
        break;
      case 2:
        localzzb.zzbX(paramString);
        paramzza = localzzb;
        break;
      default:
        paramzza = localzzb;
      }
    }
  }

  private void zzb(zza paramzza, ServiceConnection paramServiceConnection, String paramString)
  {
    zzv.zzb(paramServiceConnection, "ServiceConnection must not be null");
    zzb localzzb;
    synchronized (zzalQ)
    {
      localzzb = (zzb)zzalQ.get(paramzza);
      if (localzzb == null)
        throw new IllegalStateException("Nonexistent connection status for service config: " + paramzza);
    }
    if (!localzzb.zza(paramServiceConnection))
      throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  config=" + paramzza);
    localzzb.zzb(paramServiceConnection, paramString);
    if (localzzb.zzpX())
    {
      paramzza = mHandler.obtainMessage(0, localzzb);
      mHandler.sendMessageDelayed(paramzza, zzalS);
    }
  }

  public boolean handleMessage(Message arg1)
  {
    switch (???.what)
    {
    default:
      return false;
    case 0:
    }
    zzb localzzb = (zzb)???.obj;
    synchronized (zzalQ)
    {
      if (localzzb.zzpX())
      {
        if (localzzb.isBound())
          localzzb.zzbY("GmsClientSupervisor");
        zzalQ.remove(zzb.zza(localzzb));
      }
      return true;
    }
  }

  public boolean zza(ComponentName paramComponentName, ServiceConnection paramServiceConnection, String paramString)
  {
    return zza(new zza(paramComponentName), paramServiceConnection, paramString);
  }

  public boolean zza(String paramString1, ServiceConnection paramServiceConnection, String paramString2)
  {
    return zza(new zza(paramString1), paramServiceConnection, paramString2);
  }

  public void zzb(ComponentName paramComponentName, ServiceConnection paramServiceConnection, String paramString)
  {
    zzb(new zza(paramComponentName), paramServiceConnection, paramString);
  }

  public void zzb(String paramString1, ServiceConnection paramServiceConnection, String paramString2)
  {
    zzb(new zza(paramString1), paramServiceConnection, paramString2);
  }

  private static final class zza
  {
    private final String mAction;
    private final ComponentName zzUY;

    public zza(ComponentName paramComponentName)
    {
      mAction = null;
      zzUY = ((ComponentName)zzv.zzz(paramComponentName));
    }

    public zza(String paramString)
    {
      mAction = zzv.zzce(paramString);
      zzUY = null;
    }

    public boolean equals(Object paramObject)
    {
      if (this == paramObject);
      do
      {
        return true;
        if (!(paramObject instanceof zza))
          return false;
        paramObject = (zza)paramObject;
      }
      while ((zzu.equal(mAction, paramObject.mAction)) && (zzu.equal(zzUY, paramObject.zzUY)));
      return false;
    }

    public int hashCode()
    {
      return zzu.hashCode(new Object[] { mAction, zzUY });
    }

    public String toString()
    {
      if (mAction == null)
        return zzUY.flattenToString();
      return mAction;
    }

    public Intent zzpW()
    {
      if (mAction != null)
        return new Intent(mAction).setPackage("com.google.android.gms");
      return new Intent().setComponent(zzUY);
    }
  }

  private final class zzb
  {
    private int mState;
    private ComponentName zzUY;
    private final zza zzalT;
    private final Set<ServiceConnection> zzalU;
    private boolean zzalV;
    private final zzm.zza zzalW;
    private IBinder zzoI;

    public zzb(zzm.zza arg2)
    {
      Object localObject;
      zzalW = localObject;
      zzalT = new zza();
      zzalU = new HashSet();
      mState = 2;
    }

    public IBinder getBinder()
    {
      return zzoI;
    }

    public ComponentName getComponentName()
    {
      return zzUY;
    }

    public int getState()
    {
      return mState;
    }

    public boolean isBound()
    {
      return zzalV;
    }

    public void zza(ServiceConnection paramServiceConnection, String paramString)
    {
      zzm.zzc(zzm.this).zza(zzm.zzb(zzm.this), paramServiceConnection, paramString, zzalW.zzpW());
      zzalU.add(paramServiceConnection);
    }

    public boolean zza(ServiceConnection paramServiceConnection)
    {
      return zzalU.contains(paramServiceConnection);
    }

    public void zzb(ServiceConnection paramServiceConnection, String paramString)
    {
      zzm.zzc(zzm.this).zzb(zzm.zzb(zzm.this), paramServiceConnection);
      zzalU.remove(paramServiceConnection);
    }

    public void zzbX(String paramString)
    {
      zzalV = zzm.zzc(zzm.this).zza(zzm.zzb(zzm.this), paramString, zzalW.zzpW(), zzalT, 129);
      if (zzalV)
      {
        mState = 3;
        return;
      }
      try
      {
        zzm.zzc(zzm.this).zza(zzm.zzb(zzm.this), zzalT);
        return;
      }
      catch (IllegalArgumentException paramString)
      {
      }
    }

    public void zzbY(String paramString)
    {
      zzm.zzc(zzm.this).zza(zzm.zzb(zzm.this), zzalT);
      zzalV = false;
      mState = 2;
    }

    public boolean zzpX()
    {
      return zzalU.isEmpty();
    }

    public class zza
      implements ServiceConnection
    {
      public zza()
      {
      }

      public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
      {
        synchronized (zzm.zza(zzm.this))
        {
          zzm.zzb.zza(zzm.zzb.this, paramIBinder);
          zzm.zzb.zza(zzm.zzb.this, paramComponentName);
          Iterator localIterator = zzm.zzb.zzb(zzm.zzb.this).iterator();
          if (localIterator.hasNext())
            ((ServiceConnection)localIterator.next()).onServiceConnected(paramComponentName, paramIBinder);
        }
        zzm.zzb.zza(zzm.zzb.this, 1);
      }

      public void onServiceDisconnected(ComponentName paramComponentName)
      {
        synchronized (zzm.zza(zzm.this))
        {
          zzm.zzb.zza(zzm.zzb.this, null);
          zzm.zzb.zza(zzm.zzb.this, paramComponentName);
          Iterator localIterator = zzm.zzb.zzb(zzm.zzb.this).iterator();
          if (localIterator.hasNext())
            ((ServiceConnection)localIterator.next()).onServiceDisconnected(paramComponentName);
        }
        zzm.zzb.zza(zzm.zzb.this, 2);
      }
    }
  }
}
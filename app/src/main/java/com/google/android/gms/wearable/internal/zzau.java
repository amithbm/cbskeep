package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class zzau<T>
{
  private final Map<T, zzbl<T>> zzaCq = new HashMap();

  public void zzb(zzbk paramzzbk)
  {
    synchronized (zzaCq)
    {
      zzbj.zzs localzzs = new zzbj.zzs();
      Iterator localIterator = zzaCq.entrySet().iterator();
      while (true)
        if (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          zzbl localzzbl = (zzbl)localEntry.getValue();
          if (localzzbl == null)
            continue;
          localzzbl.clear();
          boolean bool = paramzzbk.isConnected();
          if (!bool)
            continue;
          try
          {
            ((zzat)paramzzbk.zzpN()).zza(localzzs, new RemoveListenerRequest(localzzbl));
            if (Log.isLoggable("WearableClient", 2))
              Log.d("WearableClient", "disconnect: removed: " + localEntry.getKey() + "/" + localzzbl);
          }
          catch (RemoteException localRemoteException)
          {
            Log.w("WearableClient", "disconnect: Didn't remove: " + localEntry.getKey() + "/" + localzzbl);
          }
        }
    }
    zzaCq.clear();
  }

  public void zzhy(IBinder paramIBinder)
  {
    synchronized (zzaCq)
    {
      paramIBinder = zzat.zza.zzhx(paramIBinder);
      zzbj.zzs localzzs = new zzbj.zzs();
      Iterator localIterator = zzaCq.entrySet().iterator();
      while (true)
        if (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          zzbl localzzbl = (zzbl)localEntry.getValue();
          try
          {
            paramIBinder.zza(localzzs, new AddListenerRequest(localzzbl));
            if (Log.isLoggable("WearableClient", 2))
              Log.d("WearableClient", "onPostInitHandler: added: " + localEntry.getKey() + "/" + localzzbl);
          }
          catch (RemoteException localRemoteException)
          {
            Log.d("WearableClient", "onPostInitHandler: Didn't add: " + localEntry.getKey() + "/" + localzzbl);
          }
        }
    }
  }
}
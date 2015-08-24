package com.google.android.gms.location.internal;

import android.content.ContentProviderClient;
import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.zzd;
import com.google.android.gms.location.zzd.zza;
import com.google.android.gms.location.zze;
import com.google.android.gms.location.zze.zza;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class zzi
{
  private final Context mContext;
  private Map<Object, zzc> zzaCq = new HashMap();
  private final zzn<zzg> zzaSx;
  private ContentProviderClient zzaTx = null;
  private boolean zzaTy = false;
  private Map<Object, zza> zzaTz = new HashMap();

  public zzi(Context paramContext, zzn<zzg> paramzzn)
  {
    mContext = paramContext;
    zzaSx = paramzzn;
  }

  public Location getLastLocation()
  {
    zzaSx.zzpM();
    try
    {
      Location localLocation = ((zzg)zzaSx.zzpN()).zzdx(mContext.getPackageName());
      return localLocation;
    }
    catch (RemoteException localRemoteException)
    {
      throw new IllegalStateException(localRemoteException);
    }
  }

  public void removeAllListeners()
  {
    Object localObject2;
    try
    {
      synchronized (zzaCq)
      {
        Iterator localIterator1 = zzaCq.values().iterator();
        while (localIterator1.hasNext())
        {
          localObject2 = (zzc)localIterator1.next();
          if (localObject2 != null)
            ((zzg)zzaSx.zzpN()).zza(LocationRequestUpdateData.zzb((zze)localObject2));
        }
      }
    }
    catch (RemoteException localRemoteException)
    {
      throw new IllegalStateException(localRemoteException);
    }
    zzaCq.clear();
    Iterator localIterator2 = zzaTz.values().iterator();
    while (localIterator2.hasNext())
    {
      localObject2 = (zza)localIterator2.next();
      if (localObject2 != null)
        ((zzg)zzaSx.zzpN()).zza(LocationRequestUpdateData.zza((zzd)localObject2));
    }
    zzaTz.clear();
  }

  public void zzac(boolean paramBoolean)
    throws RemoteException
  {
    zzaSx.zzpM();
    ((zzg)zzaSx.zzpN()).zzac(paramBoolean);
    zzaTy = paramBoolean;
  }

  public void zzyO()
  {
    if (zzaTy);
    try
    {
      zzac(false);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new IllegalStateException(localRemoteException);
    }
  }

  private static class zza extends zzd.zza
  {
    private Handler zzaTA;

    private void zzb(int paramInt, Object paramObject)
    {
      if (zzaTA == null)
      {
        Log.e("LocationClientHelper", "Received a data in client after calling removeLocationUpdates.");
        return;
      }
      Message localMessage = Message.obtain();
      localMessage.what = paramInt;
      localMessage.obj = paramObject;
      zzaTA.sendMessage(localMessage);
    }

    public void onLocationAvailability(LocationAvailability paramLocationAvailability)
    {
      zzb(1, paramLocationAvailability);
    }

    public void onLocationResult(LocationResult paramLocationResult)
    {
      zzb(0, paramLocationResult);
    }
  }

  private static class zzc extends zze.zza
  {
    private Handler zzaTA;

    public void onLocationChanged(Location paramLocation)
    {
      if (zzaTA == null)
      {
        Log.e("LocationClientHelper", "Received a location in client after calling removeLocationUpdates.");
        return;
      }
      Message localMessage = Message.obtain();
      localMessage.what = 1;
      localMessage.obj = paramLocation;
      zzaTA.sendMessage(localMessage);
    }
  }
}
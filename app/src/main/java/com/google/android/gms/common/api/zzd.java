package com.google.android.gms.common.api;

import android.os.Bundle;
import android.os.DeadObjectException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zzk;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class zzd
  implements zzh
{
  private final zzg zzahe;

  public zzd(zzg paramzzg)
  {
    zzahe = paramzzg;
  }

  private <A extends Api.Client> void zza(zzg.zze<A> paramzze)
    throws DeadObjectException
  {
    zzahe.zzb(paramzze);
    Api.Client localClient = zzahe.zza(paramzze.zzou());
    if ((!localClient.isConnected()) && (zzahe.zzahP.containsKey(paramzze.zzou())))
    {
      paramzze.zzI(new Status(17));
      return;
    }
    paramzze.zzb(localClient);
  }

  public void begin()
  {
    while (!zzahe.zzahI.isEmpty())
      try
      {
        zza((zzg.zze)zzahe.zzahI.remove());
      }
      catch (DeadObjectException localDeadObjectException)
      {
        Log.w("GoogleApiClientConnected", "Service died while flushing queue", localDeadObjectException);
      }
  }

  public void connect()
  {
  }

  public String getName()
  {
    return "CONNECTED";
  }

  public void onConnected(Bundle paramBundle)
  {
  }

  public void onConnectionSuspended(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return;
    case 2:
      zzen(paramInt);
      zzahe.connect();
      return;
    case 1:
    }
    zzahe.zzoS();
    zzen(paramInt);
  }

  public <A extends Api.Client, R extends Result, T extends zza.zza<R, A>> T zza(T paramT)
  {
    return zzb(paramT);
  }

  public void zza(ConnectionResult paramConnectionResult, Api<?> paramApi, int paramInt)
  {
  }

  public <A extends Api.Client, T extends zza.zza<? extends Result, A>> T zzb(T paramT)
  {
    try
    {
      zza(paramT);
      return paramT;
    }
    catch (DeadObjectException localDeadObjectException)
    {
      zzen(1);
    }
    return paramT;
  }

  public void zzen(int paramInt)
  {
    int i;
    if (paramInt == -1)
    {
      i = 1;
      if (i == 0)
        break label69;
      zzahe.zzoM();
      zzahe.zzahP.clear();
    }
    while (true)
    {
      zzahe.zze(null);
      if (i == 0)
        zzahe.zzahH.zzeM(paramInt);
      zzahe.zzahH.zzpU();
      return;
      i = 0;
      break;
      label69: Iterator localIterator = zzahe.zzahT.iterator();
      while (localIterator.hasNext())
        ((zzg.zze)localIterator.next()).forceFailureUnlessReady(new Status(8, "The connection to Google Play services was lost"));
    }
  }
}
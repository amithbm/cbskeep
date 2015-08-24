package com.google.android.gms.common.api;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;

public class zzf
  implements zzh
{
  private final zzg zzahe;

  public zzf(zzg paramzzg)
  {
    zzahe = paramzzg;
  }

  public void begin()
  {
    zzahe.zzoN();
  }

  public void connect()
  {
    zzahe.zzoO();
  }

  public String getName()
  {
    return "DISCONNECTED";
  }

  public void onConnected(Bundle paramBundle)
  {
  }

  public void onConnectionSuspended(int paramInt)
  {
  }

  public <A extends Api.Client, R extends Result, T extends zza.zza<R, A>> T zza(T paramT)
  {
    zzahe.zzahI.add(paramT);
    return paramT;
  }

  public void zza(ConnectionResult paramConnectionResult, Api<?> paramApi, int paramInt)
  {
  }

  public <A extends Api.Client, T extends zza.zza<? extends Result, A>> T zzb(T paramT)
  {
    throw new IllegalStateException("GoogleApiClient is not connected yet.");
  }

  public void zzen(int paramInt)
  {
    if (paramInt == -1)
      paramInt = 1;
    while (paramInt != 0)
    {
      Iterator localIterator = zzahe.zzahI.iterator();
      while (true)
        if (localIterator.hasNext())
        {
          ((zzg.zze)localIterator.next()).cancel();
          continue;
          paramInt = 0;
          break;
        }
      zzahe.zzahI.clear();
      zzahe.zzoM();
      zzahe.zzahP.clear();
    }
  }
}
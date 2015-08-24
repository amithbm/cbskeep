package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzf.zza;
import com.google.android.gms.common.internal.zzk;
import com.google.android.gms.common.internal.zzr.zza;
import com.google.android.gms.common.internal.zzv;
import com.google.android.gms.internal.zzvg;
import com.google.android.gms.internal.zzvh;
import com.google.android.gms.signin.internal.AuthAccountResult;
import com.google.android.gms.signin.internal.zzb;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.locks.Lock;

public class zze
  implements zzh
{
  private final Context mContext;
  private final Api.zza<? extends zzvg, zzvh> zzagY;
  private final zzg zzahe;
  private final Lock zzahf;
  private ConnectionResult zzahg;
  private int zzahh;
  private int zzahi = 0;
  private boolean zzahj = false;
  private int zzahk;
  private final Bundle zzahl = new Bundle();
  private final Set<Api.ClientKey> zzahm = new HashSet();
  private zzvg zzahn;
  private int zzaho;
  private boolean zzahp;
  private boolean zzahq;
  private IAccountAccessor zzahr;
  private boolean zzahs;
  private boolean zzaht;
  private final zzf zzahu;
  private final Map<Api<?>, Integer> zzahv;

  public zze(zzg paramzzg, zzf paramzzf, Map<Api<?>, Integer> paramMap, Api.zza<? extends zzvg, zzvh> paramzza, Lock paramLock, Context paramContext)
  {
    zzahe = paramzzg;
    zzahu = paramzzf;
    zzahv = paramMap;
    zzagY = paramzza;
    zzahf = paramLock;
    mContext = paramContext;
  }

  private void zzQ(boolean paramBoolean)
  {
    if (zzahn != null)
    {
      if (zzahn.isConnected())
      {
        if (paramBoolean)
          zzahn.zzCw();
        zzahn.disconnect();
      }
      zzahr = null;
    }
  }

  private void zza(ConnectionResult paramConnectionResult)
  {
    zzahf.lock();
    while (true)
    {
      try
      {
        boolean bool = zzeo(2);
        if (!bool)
          return;
        if (paramConnectionResult.isSuccess())
        {
          zzoI();
          return;
        }
        if (zzc(paramConnectionResult))
        {
          zzoK();
          zzoI();
          continue;
        }
      }
      finally
      {
        zzahf.unlock();
      }
      zzd(paramConnectionResult);
    }
  }

  private void zza(ResolveAccountResponse paramResolveAccountResponse)
  {
    ConnectionResult localConnectionResult = paramResolveAccountResponse.zzqb();
    zzahf.lock();
    while (true)
    {
      try
      {
        boolean bool = zzeo(0);
        if (!bool)
          return;
        if (localConnectionResult.isSuccess())
        {
          zzahr = paramResolveAccountResponse.zzqa();
          zzahq = true;
          zzahs = paramResolveAccountResponse.zzqc();
          zzaht = paramResolveAccountResponse.zzqd();
          zzoG();
          return;
        }
        if (zzc(localConnectionResult))
        {
          zzoK();
          if (zzahk != 0)
            continue;
          zzoI();
          continue;
        }
      }
      finally
      {
        zzahf.unlock();
      }
      zzd(localConnectionResult);
    }
  }

  private boolean zza(int paramInt1, int paramInt2, ConnectionResult paramConnectionResult)
  {
    if ((paramInt2 == 1) && (!zzb(paramConnectionResult)));
    while ((zzahg != null) && (paramInt1 >= zzahh))
      return false;
    return true;
  }

  private void zzb(ConnectionResult paramConnectionResult, Api<?> paramApi, int paramInt)
  {
    if (paramInt != 2)
    {
      int i = paramApi.zzor().getPriority();
      if (zza(i, paramInt, paramConnectionResult))
      {
        zzahg = paramConnectionResult;
        zzahh = i;
      }
    }
    zzahe.zzahP.put(paramApi.zzou(), paramConnectionResult);
  }

  private static boolean zzb(ConnectionResult paramConnectionResult)
  {
    if (paramConnectionResult.hasResolution());
    while (GooglePlayServicesUtil.getGooglePlayServicesAvailabilityRecoveryIntent(paramConnectionResult.getErrorCode()) != null)
      return true;
    return false;
  }

  private boolean zzc(ConnectionResult paramConnectionResult)
  {
    return (zzaho == 2) || ((zzaho == 1) && (!paramConnectionResult.hasResolution()));
  }

  private void zzd(ConnectionResult paramConnectionResult)
  {
    boolean bool = false;
    zzahj = false;
    zzahe.zzahQ.clear();
    zzahg = paramConnectionResult;
    if (!paramConnectionResult.hasResolution())
      bool = true;
    zzQ(bool);
    zzen(3);
    if ((!zzahe.zzoQ()) || (!GooglePlayServicesUtil.isPlayServicesPossiblyUpdating(mContext, paramConnectionResult.getErrorCode())))
    {
      zzahe.zzoT();
      zzahe.zzahH.zzh(paramConnectionResult);
    }
    zzahe.zzahH.zzpU();
  }

  private boolean zzeo(int paramInt)
  {
    if (zzahi != paramInt)
    {
      Log.wtf("GoogleApiClientConnecting", "GoogleApiClient connecting is in step " + zzep(zzahi) + " but received callback for step " + zzep(paramInt));
      zzd(new ConnectionResult(8, null));
      return false;
    }
    return true;
  }

  private String zzep(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return "UNKNOWN";
    case 0:
      return "STEP_GETTING_SERVICE_BINDINGS";
    case 1:
      return "STEP_VALIDATING_ACCOUNT";
    case 2:
      return "STEP_AUTHENTICATING";
    case 3:
    }
    return "STEP_GETTING_REMOTE_SERVICE";
  }

  private boolean zzoE()
  {
    zzahk -= 1;
    if (zzahk > 0)
      return false;
    if (zzahk < 0)
    {
      Log.wtf("GoogleApiClientConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.");
      zzd(new ConnectionResult(8, null));
      return false;
    }
    if (zzahg != null)
    {
      zzd(zzahg);
      return false;
    }
    return true;
  }

  private void zzoF()
  {
    if (zzahp)
    {
      zzoG();
      return;
    }
    zzoI();
  }

  private void zzoG()
  {
    if ((zzahq) && (zzahk == 0))
    {
      zzahi = 1;
      zzahk = zzahe.zzahO.size();
      Iterator localIterator = zzahe.zzahO.keySet().iterator();
      while (localIterator.hasNext())
      {
        Api.ClientKey localClientKey = (Api.ClientKey)localIterator.next();
        if (zzahe.zzahP.containsKey(localClientKey))
        {
          if (zzoE())
            zzoH();
        }
        else
          ((Api.Client)zzahe.zzahO.get(localClientKey)).validateAccount(zzahr);
      }
    }
  }

  private void zzoH()
  {
    zzahi = 2;
    zzahe.zzahQ = zzoL();
    zzahn.zza(zzahr, zzahe.zzahQ, new zza(this));
  }

  private void zzoI()
  {
    Set localSet = zzahe.zzahQ;
    if (localSet.isEmpty())
      localSet = zzoL();
    while (true)
    {
      zzahi = 3;
      zzahk = zzahe.zzahO.size();
      Iterator localIterator = zzahe.zzahO.keySet().iterator();
      while (localIterator.hasNext())
      {
        Api.ClientKey localClientKey = (Api.ClientKey)localIterator.next();
        if (zzahe.zzahP.containsKey(localClientKey))
        {
          if (zzoE())
            zzoJ();
        }
        else
          ((Api.Client)zzahe.zzahO.get(localClientKey)).getRemoteService(zzahr, localSet);
      }
      return;
    }
  }

  private void zzoJ()
  {
    zzahe.zzoP();
    if (zzahn != null)
    {
      if (zzahs)
        zzahn.zza(zzahr, zzaht);
      zzQ(false);
    }
    Object localObject = zzahe.zzahP.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Api.ClientKey localClientKey = (Api.ClientKey)((Iterator)localObject).next();
      ((Api.Client)zzahe.zzahO.get(localClientKey)).disconnect();
    }
    if (zzahj)
    {
      zzahj = false;
      zzen(-1);
      return;
    }
    if (zzahl.isEmpty());
    for (localObject = null; ; localObject = zzahl)
    {
      zzahe.zzahH.zzl((Bundle)localObject);
      return;
    }
  }

  private void zzoK()
  {
    zzahp = false;
    zzahe.zzahQ.clear();
    Iterator localIterator = zzahm.iterator();
    while (localIterator.hasNext())
    {
      Api.ClientKey localClientKey = (Api.ClientKey)localIterator.next();
      if (!zzahe.zzahP.containsKey(localClientKey))
        zzahe.zzahP.put(localClientKey, new ConnectionResult(17, null));
    }
  }

  private Set<Scope> zzoL()
  {
    HashSet localHashSet = new HashSet(zzahu.zzpx());
    Map localMap = zzahu.zzpz();
    Iterator localIterator = localMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Api localApi = (Api)localIterator.next();
      if (!zzahe.zzahP.containsKey(localApi.zzou()))
        localHashSet.addAll(((zzf.zza)localMap.get(localApi)).zzahd);
    }
    return localHashSet;
  }

  public void begin()
  {
    zzahe.zzahH.zzpV();
    zzahe.zzahP.clear();
    zzahj = false;
    zzahp = false;
    zzahg = null;
    zzahi = 0;
    zzaho = 2;
    zzahq = false;
    zzahs = false;
    int i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(mContext);
    Object localObject1;
    if (i != 0)
    {
      localObject1 = new ConnectionResult(i, null);
      zzahe.zzahM.post(new Runnable()
      {
        public void run()
        {
          zze.zza(zze.this).lock();
          try
          {
            zze.zza(zze.this, zzahw);
            return;
          }
          finally
          {
            zze.zza(zze.this).unlock();
          }
        }
      });
    }
    while (true)
    {
      return;
      localObject1 = new HashMap();
      Object localObject2 = zzahv.keySet().iterator();
      i = 0;
      Object localObject3;
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Api)((Iterator)localObject2).next();
        Api.Client localClient = (Api.Client)zzahe.zzahO.get(((Api)localObject3).zzou());
        int k = ((Integer)zzahv.get(localObject3)).intValue();
        if (((Api)localObject3).zzor().getPriority() == 1);
        for (int j = 1; ; j = 0)
        {
          if (localClient.requiresSignIn())
          {
            zzahp = true;
            if (k < zzaho)
              zzaho = k;
            if (k != 0)
              zzahm.add(((Api)localObject3).zzou());
          }
          ((Map)localObject1).put(localClient, new zzc(this, (Api)localObject3, k));
          i = j | i;
          break;
        }
      }
      if (i != 0)
        zzahp = false;
      if (zzahp)
      {
        zzahu.zzb(Integer.valueOf(zzahe.getSessionId()));
        localObject2 = new zzd(null);
        zzahn = ((zzvg)zzagY.zza(mContext, zzahe.getLooper(), zzahu, zzahu.zzpD(), (GoogleApiClient.ConnectionCallbacks)localObject2, (GoogleApiClient.OnConnectionFailedListener)localObject2));
        zzahn.connect();
      }
      zzahk = zzahe.zzahO.size();
      localObject2 = zzahe.zzahO.values().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Api.Client)((Iterator)localObject2).next();
        ((Api.Client)localObject3).connect((GoogleApiClient.ConnectionProgressReportCallbacks)((Map)localObject1).get(localObject3));
      }
    }
  }

  public void connect()
  {
    zzahj = false;
  }

  public String getName()
  {
    return "CONNECTING";
  }

  public void onConnected(Bundle paramBundle)
  {
    if (!zzeo(3));
    do
    {
      return;
      if (paramBundle != null)
        zzahl.putAll(paramBundle);
    }
    while (!zzoE());
    zzoJ();
  }

  public void onConnectionSuspended(int paramInt)
  {
    zzd(new ConnectionResult(8, null));
  }

  public <A extends Api.Client, R extends Result, T extends zza.zza<R, A>> T zza(T paramT)
  {
    zzahe.zzahI.add(paramT);
    return paramT;
  }

  public void zza(ConnectionResult paramConnectionResult, Api<?> paramApi, int paramInt)
  {
    if (!zzeo(3));
    do
    {
      return;
      zzb(paramConnectionResult, paramApi, paramInt);
    }
    while (!zzoE());
    zzoJ();
  }

  public <A extends Api.Client, T extends zza.zza<? extends Result, A>> T zzb(T paramT)
  {
    throw new IllegalStateException("GoogleApiClient is not connected yet.");
  }

  public void zzen(int paramInt)
  {
    if (paramInt == -1)
    {
      Iterator localIterator = zzahe.zzahI.iterator();
      while (localIterator.hasNext())
      {
        zzg.zze localzze = (zzg.zze)localIterator.next();
        if (localzze.zzox() != 1)
        {
          localzze.cancel();
          localIterator.remove();
        }
      }
      zzahe.zzoM();
      if ((zzahg == null) && (!zzahe.zzahI.isEmpty()))
      {
        zzahj = true;
        return;
      }
      zzahe.zzahP.clear();
      zzahg = null;
      zzQ(true);
    }
    zzahe.zze(zzahg);
  }

  private static class zza extends zzb
  {
    private final WeakReference<zze> zzahy;

    zza(zze paramzze)
    {
      zzahy = new WeakReference(paramzze);
    }

    public void zza(final ConnectionResult paramConnectionResult, final AuthAccountResult paramAuthAccountResult)
    {
      paramAuthAccountResult = (zze)zzahy.get();
      if (paramAuthAccountResult == null)
        return;
      zze.zzb(paramAuthAccountResult).zzahM.post(new Runnable()
      {
        public void run()
        {
          zze.zzc(paramAuthAccountResult, paramConnectionResult);
        }
      });
    }
  }

  private static class zzb extends zzr.zza
  {
    private final WeakReference<zze> zzahy;

    zzb(zze paramzze)
    {
      zzahy = new WeakReference(paramzze);
    }

    public void zzb(final ResolveAccountResponse paramResolveAccountResponse)
    {
      final zze localzze = (zze)zzahy.get();
      if (localzze == null)
        return;
      zze.zzb(localzze).zzahM.post(new Runnable()
      {
        public void run()
        {
          zze.zza(localzze, paramResolveAccountResponse);
        }
      });
    }
  }

  private static class zzc
    implements GoogleApiClient.ConnectionProgressReportCallbacks
  {
    private final Api<?> zzahE;
    private final int zzahF;
    private final WeakReference<zze> zzahy;

    public zzc(zze paramzze, Api<?> paramApi, int paramInt)
    {
      zzahy = new WeakReference(paramzze);
      zzahE = paramApi;
      zzahF = paramInt;
    }

    public void onReportAccountValidation(ConnectionResult paramConnectionResult)
    {
      boolean bool = true;
      zze localzze = (zze)zzahy.get();
      if (localzze == null)
        return;
      if (Looper.myLooper() == zze.zzb(localzze).getLooper());
      while (true)
      {
        zzv.zza(bool, "onReportAccountValidation must be called on the GoogleApiClient handler thread");
        zze.zza(localzze).lock();
        try
        {
          bool = zze.zza(localzze, 1);
          if (!bool)
          {
            return;
            bool = false;
          }
          else
          {
            if (!paramConnectionResult.isSuccess())
              zze.zza(localzze, paramConnectionResult, zzahE, zzahF);
            if (zze.zzf(localzze))
              zze.zzh(localzze);
            return;
          }
        }
        finally
        {
          zze.zza(localzze).unlock();
        }
      }
      throw paramConnectionResult;
    }

    public void onReportServiceBinding(ConnectionResult paramConnectionResult)
    {
      boolean bool = false;
      zze localzze = (zze)zzahy.get();
      if (localzze == null)
        return;
      if (Looper.myLooper() == zze.zzb(localzze).getLooper())
        bool = true;
      zzv.zza(bool, "onReportServiceBinding must be called on the GoogleApiClient handler thread");
      zze.zza(localzze).lock();
      try
      {
        bool = zze.zza(localzze, 0);
        if (!bool)
          return;
        if (!paramConnectionResult.isSuccess())
          zze.zza(localzze, paramConnectionResult, zzahE, zzahF);
        if (zze.zzf(localzze))
          zze.zzg(localzze);
        return;
      }
      finally
      {
        zze.zza(localzze).unlock();
      }
      throw paramConnectionResult;
    }
  }

  private class zzd
    implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener
  {
    private zzd()
    {
    }

    public void onConnected(Bundle paramBundle)
    {
      zze.zzc(zze.this).zza(new zze.zzb(zze.this));
    }

    public void onConnectionFailed(ConnectionResult paramConnectionResult)
    {
      zze.zza(zze.this).lock();
      try
      {
        if (zze.zzb(zze.this, paramConnectionResult))
        {
          zze.zzd(zze.this);
          zze.zze(zze.this);
        }
        while (true)
        {
          return;
          zze.zza(zze.this, paramConnectionResult);
        }
      }
      finally
      {
        zze.zza(zze.this).unlock();
      }
      throw paramConnectionResult;
    }

    public void onConnectionSuspended(int paramInt)
    {
    }
  }
}
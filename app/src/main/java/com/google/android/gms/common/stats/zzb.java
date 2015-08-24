package com.google.android.gms.common.stats;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Debug;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.common.util.zzo;
import com.google.android.gms.internal.zzlk;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class zzb
{
  private static final Object zzalO = new Object();
  private static zzb zzanM;
  private static final ComponentName zzanR = new ComponentName("com.google.android.gms", "com.google.android.gms.common.stats.GmsCoreStatsService");
  private final List<String> zzanN;
  private final List<String> zzanO;
  private final List<String> zzanP;
  private final List<String> zzanQ;
  private zze zzanS;

  private zzb()
  {
    if (getLogLevel() == zzd.zzaob)
    {
      zzanN = Collections.EMPTY_LIST;
      zzanO = Collections.EMPTY_LIST;
      zzanP = Collections.EMPTY_LIST;
      zzanQ = Collections.EMPTY_LIST;
      return;
    }
    Object localObject = (String)zzc.zza.zzanW.get();
    if (localObject == null)
    {
      localObject = Collections.EMPTY_LIST;
      zzanN = ((List)localObject);
      localObject = (String)zzc.zza.zzanX.get();
      if (localObject != null)
        break label175;
      localObject = Collections.EMPTY_LIST;
      label84: zzanO = ((List)localObject);
      localObject = (String)zzc.zza.zzanY.get();
      if (localObject != null)
        break label188;
      localObject = Collections.EMPTY_LIST;
      label107: zzanP = ((List)localObject);
      localObject = (String)zzc.zza.zzanZ.get();
      if (localObject != null)
        break label201;
    }
    label175: label188: label201: for (localObject = Collections.EMPTY_LIST; ; localObject = Arrays.asList(((String)localObject).split(",")))
    {
      zzanQ = ((List)localObject);
      zzanS = new zze(1024, ((Long)zzc.zza.zzaoa.get()).longValue());
      return;
      localObject = Arrays.asList(((String)localObject).split(","));
      break;
      localObject = Arrays.asList(((String)localObject).split(","));
      break label84;
      localObject = Arrays.asList(((String)localObject).split(","));
      break label107;
    }
  }

  private int getLogLevel()
  {
    try
    {
      if (com.google.android.gms.common.util.zzd.zziP())
        return ((Integer)zzc.zza.zzanV.get()).intValue();
      int i = zzd.zzaob;
      return i;
    }
    catch (SecurityException localSecurityException)
    {
    }
    return zzd.zzaob;
  }

  private void zza(Context paramContext, ServiceConnection paramServiceConnection, String paramString, Intent paramIntent, int paramInt)
  {
    if (!com.google.android.gms.common.internal.zzd.zzakB);
    String str;
    do
    {
      return;
      str = zzb(paramServiceConnection);
    }
    while (!zza(paramContext, paramString, paramIntent, str, paramInt));
    long l2 = System.currentTimeMillis();
    paramServiceConnection = null;
    if ((getLogLevel() & zzd.zzaof) != 0)
      paramServiceConnection = zzo.zzx(3, 5);
    long l1 = 0L;
    if ((getLogLevel() & zzd.zzaoh) != 0)
      l1 = Debug.getNativeHeapAllocatedSize();
    if ((paramInt == 1) || (paramInt == 4));
    for (paramServiceConnection = new ConnectionEvent(l2, paramInt, null, null, null, null, paramServiceConnection, str, SystemClock.elapsedRealtime(), l1); ; paramServiceConnection = new ConnectionEvent(l2, paramInt, zzo.zzaq(paramContext), paramString, paramIntent.processName, paramIntent.name, paramServiceConnection, str, SystemClock.elapsedRealtime(), l1))
    {
      paramContext.startService(new Intent().setComponent(zzanR).putExtra("com.google.android.gms.common.stats.EXTRA_LOG_EVENT", paramServiceConnection));
      return;
      paramIntent = zzb(paramContext, paramIntent);
    }
  }

  private boolean zza(Context paramContext, Intent paramIntent)
  {
    paramIntent = paramIntent.getComponent();
    if ((paramIntent == null) || ((com.google.android.gms.common.internal.zzd.zzakB) && ("com.google.android.gms".equals(paramIntent.getPackageName()))))
      return false;
    return com.google.android.gms.common.util.zzd.zzo(paramContext, paramIntent.getPackageName());
  }

  private boolean zza(Context paramContext, String paramString1, Intent paramIntent, String paramString2, int paramInt)
  {
    int i = getLogLevel();
    if ((i == zzd.zzaob) || (zzanS == null));
    Object localObject;
    do
    {
      do
      {
        return false;
        if ((paramInt != 4) && (paramInt != 1))
          break;
      }
      while (!zzanS.zzch(paramString2));
      return true;
      localObject = zzb(paramContext, paramIntent);
      if (localObject == null)
      {
        Log.w("ConnectionTracker", String.format("Client %s made an invalid request %s", new Object[] { paramString1, paramIntent.toUri(0) }));
        return false;
      }
      paramContext = zzo.zzaq(paramContext);
      paramIntent = ((ServiceInfo)localObject).processName;
      localObject = ((ServiceInfo)localObject).name;
    }
    while ((zzanN.contains(paramContext)) || (zzanO.contains(paramString1)) || (zzanP.contains(paramIntent)) || (zzanQ.contains(localObject)) || ((paramIntent.equals(paramContext)) && ((i & zzd.zzaog) != 0)));
    zzanS.zzcg(paramString2);
    return true;
  }

  private static ServiceInfo zzb(Context paramContext, Intent paramIntent)
  {
    paramContext = paramContext.getPackageManager().queryIntentServices(paramIntent, 128);
    if ((paramContext == null) || (paramContext.size() == 0))
    {
      Log.w("ConnectionTracker", String.format("There are no handler of this intent: %s\n Stack trace: %s", new Object[] { paramIntent.toUri(0), zzo.zzx(3, 20) }));
      return null;
    }
    if (paramContext.size() > 1)
    {
      Log.w("ConnectionTracker", String.format("Multiple handlers found for this intent: %s\n Stack trace: %s", new Object[] { paramIntent.toUri(0), zzo.zzx(3, 20) }));
      paramIntent = paramContext.iterator();
      if (paramIntent.hasNext())
      {
        Log.w("ConnectionTracker", ((ResolveInfo)paramIntent.next()).serviceInfo.name);
        return null;
      }
    }
    return ((ResolveInfo)paramContext.get(0)).serviceInfo;
  }

  private String zzb(ServiceConnection paramServiceConnection)
  {
    return String.valueOf(Process.myPid() << 32 | System.identityHashCode(paramServiceConnection));
  }

  public static zzb zzqA()
  {
    synchronized (zzalO)
    {
      if (zzanM == null)
        zzanM = new zzb();
      return zzanM;
    }
  }

  public void zza(Context paramContext, ServiceConnection paramServiceConnection)
  {
    zza(paramContext, paramServiceConnection, null, null, 1);
    paramContext.unbindService(paramServiceConnection);
  }

  public void zza(Context paramContext, ServiceConnection paramServiceConnection, String paramString, Intent paramIntent)
  {
    zza(paramContext, paramServiceConnection, paramString, paramIntent, 3);
  }

  public boolean zza(Context paramContext, String paramString, Intent paramIntent, ServiceConnection paramServiceConnection, int paramInt)
  {
    if (zza(paramContext, paramIntent))
    {
      Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
      return false;
    }
    zza(paramContext, paramServiceConnection, paramString, paramIntent, 2);
    return paramContext.bindService(paramIntent, paramServiceConnection, paramInt);
  }

  public void zzb(Context paramContext, ServiceConnection paramServiceConnection)
  {
    zza(paramContext, paramServiceConnection, null, null, 4);
  }
}
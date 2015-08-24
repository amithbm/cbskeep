package com.google.android.gms.drive.realtime.internal;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.drive.realtime.CollaborativeList;
import com.google.android.gms.drive.realtime.CollaborativeMap;
import com.google.android.gms.drive.realtime.CollaborativeObject;
import com.google.android.gms.drive.realtime.CollaborativeObject.ObjectChangedEvent;
import com.google.android.gms.drive.realtime.CollaborativeObjectEvent;
import com.google.android.gms.drive.realtime.CollaborativeString;
import com.google.android.gms.drive.realtime.CompoundOperation;
import com.google.android.gms.drive.realtime.Model;
import com.google.android.gms.drive.realtime.Model.UndoRedoStateChangedEvent;
import com.google.android.gms.drive.realtime.RealtimeEvent.Listener;
import com.google.android.gms.drive.realtime.internal.event.ParcelableEventList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class zzag
  implements Model
{
  private final List<String> zzauO = new ArrayList();
  private final zzak zzazF;
  private final Set<RealtimeEvent.Listener<Model.UndoRedoStateChangedEvent>> zzazG = Collections.newSetFromMap(new IdentityHashMap());
  private final Map<String, zzf> zzazH = new HashMap();
  private final zzd zzazI;
  private final zzt zzazp;

  public zzag(zzak paramzzak, zzt paramzzt)
  {
    zzazF = paramzzak;
    zzazp = paramzzt;
    zzazI = new zzd(zzazp, "root", this);
    zzazH.put("root", zzazI);
  }

  private void zza(CollaborativeObject.ObjectChangedEvent paramObjectChangedEvent)
  {
    Iterator localIterator = paramObjectChangedEvent.getObjectIdsToInform().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (zzf)zzazH.get(localObject);
      if (localObject != null)
        ((zzf)localObject).zza(paramObjectChangedEvent);
    }
  }

  private CollaborativeObject zzcG(String paramString)
  {
    zztA();
    zzae localzzae = new zzae(zztM());
    try
    {
      zzazp.zza(paramString, localzzae);
      return zzF(localzzae.zztK(), paramString);
    }
    catch (RemoteException paramString)
    {
    }
    throw new IllegalStateException();
  }

  public boolean canRedo()
  {
    zztA();
    zzw localzzw = new zzw(zztM());
    try
    {
      zzazp.zze(localzzw);
      return localzzw.zztE();
    }
    catch (RemoteException localRemoteException)
    {
    }
    throw new IllegalStateException();
  }

  public boolean canUndo()
  {
    zztA();
    zzw localzzw = new zzw(zztM());
    try
    {
      zzazp.zzd(localzzw);
      return localzzw.zztE();
    }
    catch (RemoteException localRemoteException)
    {
    }
    throw new IllegalStateException();
  }

  public CollaborativeList createList()
  {
    zztA();
    return (CollaborativeList)zzcG("List");
  }

  public CollaborativeMap createMap()
  {
    zztA();
    return (CollaborativeMap)zzcG("Map");
  }

  public CollaborativeString createString()
  {
    zztA();
    return (CollaborativeString)zzcG("EditableString");
  }

  public CollaborativeMap getRoot()
  {
    zztA();
    return zzazI;
  }

  public void performCompoundOperation(CompoundOperation paramCompoundOperation, String paramString)
  {
    zztA();
    performCompoundOperation(paramCompoundOperation, paramString, true);
  }

  public void performCompoundOperation(CompoundOperation paramCompoundOperation, String paramString, boolean paramBoolean)
  {
    zztA();
    String str = paramString;
    if (paramString == null)
      str = "";
    zza(false, str, paramBoolean);
    paramCompoundOperation.performCompoundOperation(this);
    zztL();
  }

  public zzf zzF(String paramString1, String paramString2)
  {
    if (zzazH.containsKey(paramString1))
      return (zzf)zzazH.get(paramString1);
    paramString2 = new zze(zzauO).zza(paramString1, paramString2, zzazp, this);
    zzazH.put(paramString1, paramString2);
    return paramString2;
  }

  public void zza(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    zztA();
    zzaf localzzaf = new zzaf(zztM());
    try
    {
      zzazp.zza(new BeginCompoundOperationRequest(paramBoolean1, paramString, paramBoolean2), localzzaf);
      localzzaf.await();
      return;
    }
    catch (RemoteException paramString)
    {
    }
    throw new IllegalStateException();
  }

  protected void zzb(ParcelableEventList paramParcelableEventList)
  {
    Iterator localIterator;
    Object localObject;
    try
    {
      localIterator = paramParcelableEventList.zzuk().iterator();
      while (localIterator.hasNext())
      {
        localObject = (String)localIterator.next();
        localObject = (zzf)zzazH.get(localObject);
        if (localObject != null)
          ((zzf)localObject).flushCache();
      }
    }
    catch (Exception paramParcelableEventList)
    {
      Log.e("ModelImpl", "Error decoding and firing events.", paramParcelableEventList);
    }
    while (true)
    {
      return;
      localIterator = com.google.android.gms.drive.realtime.internal.event.zzd.zza(this, paramParcelableEventList).iterator();
      while (localIterator.hasNext())
      {
        localObject = (CollaborativeObjectEvent)localIterator.next();
        if ((localObject instanceof CollaborativeObject.ObjectChangedEvent))
          zza((CollaborativeObject.ObjectChangedEvent)localObject);
        else
          ((zzf)((CollaborativeObjectEvent)localObject).getTarget()).zza((CollaborativeObjectEvent)localObject);
      }
      if (paramParcelableEventList.zzuj())
      {
        paramParcelableEventList = zzazG.iterator();
        while (paramParcelableEventList.hasNext())
          ((RealtimeEvent.Listener)paramParcelableEventList.next()).onEvent(new Model.UndoRedoStateChangedEvent(canUndo(), canRedo()));
      }
    }
  }

  public void zzb(boolean paramBoolean, String paramString)
  {
    zztA();
    if (!paramBoolean);
    for (boolean bool = true; ; bool = false)
    {
      zza(paramBoolean, paramString, bool);
      return;
    }
  }

  public void zzo(List<String> paramList)
  {
    zzauO.addAll(paramList);
  }

  void zztA()
  {
    zzazF.zztA();
  }

  public void zztL()
  {
    zztA();
    zzab localzzab = new zzab(zztM());
    try
    {
      zzazp.zza(new EndCompoundOperationRequest(), localzzab);
      zzb(localzzab.zztI());
      localzzab.zztI();
      return;
    }
    catch (RemoteException localRemoteException)
    {
    }
    throw new IllegalStateException();
  }

  zzak zztM()
  {
    return zzazF;
  }
}
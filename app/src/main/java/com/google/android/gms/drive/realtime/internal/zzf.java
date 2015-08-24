package com.google.android.gms.drive.realtime.internal;

import android.os.RemoteException;
import com.google.android.gms.drive.realtime.CollaborativeObject;
import com.google.android.gms.drive.realtime.CollaborativeObject.ObjectChangedEvent;
import com.google.android.gms.drive.realtime.CollaborativeObjectEvent;
import com.google.android.gms.drive.realtime.RealtimeEvent.Listener;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public abstract class zzf
  implements CollaborativeObject
{
  private final String zzEK;
  private final String zzLf;
  private final zzt zzazp;
  private final zzag zzazq;
  private final Set<RealtimeEvent.Listener<CollaborativeObject.ObjectChangedEvent>> zzazr;

  public zzf(zzt paramzzt, String paramString1, zzag paramzzag, String paramString2)
  {
    zzazp = paramzzt;
    zzLf = paramString1;
    zzazq = paramzzag;
    zzEK = paramString2;
    zzazr = new HashSet();
  }

  public void addObjectChangedListener(RealtimeEvent.Listener<CollaborativeObject.ObjectChangedEvent> paramListener)
  {
    zztA();
    zzazr.add(paramListener);
    if (zzazr.size() == 1)
      paramListener = new zzaf(zztz().zztM());
    try
    {
      zzazp.zza(getId(), paramListener);
      paramListener.await();
      return;
    }
    catch (RemoteException paramListener)
    {
    }
    throw new RuntimeException("The GoogleApiClient must be actively connected.");
  }

  abstract void flushCache();

  public String getId()
  {
    zztA();
    return zzLf;
  }

  public String getType()
  {
    return zzEK;
  }

  public void removeObjectChangedListener(RealtimeEvent.Listener<CollaborativeObject.ObjectChangedEvent> paramListener)
  {
    zztA();
    zzazr.remove(paramListener);
    if (zzazr.size() == 0)
      paramListener = new zzaf(zztz().zztM());
    try
    {
      zzazp.zzb(getId(), paramListener);
      paramListener.await();
      return;
    }
    catch (RemoteException paramListener)
    {
    }
    throw new RuntimeException("The GoogleApiClient must be actively connected.");
  }

  public void zza(CollaborativeObjectEvent paramCollaborativeObjectEvent)
  {
    if ((paramCollaborativeObjectEvent instanceof CollaborativeObject.ObjectChangedEvent))
    {
      Iterator localIterator = zzazr.iterator();
      while (localIterator.hasNext())
        ((RealtimeEvent.Listener)localIterator.next()).onEvent((CollaborativeObject.ObjectChangedEvent)paramCollaborativeObjectEvent);
    }
  }

  protected void zztA()
  {
    zzazq.zztM().zztA();
  }

  protected zzt zztB()
  {
    return zzazp;
  }

  public zzag zztz()
  {
    zztA();
    return zzazq;
  }
}
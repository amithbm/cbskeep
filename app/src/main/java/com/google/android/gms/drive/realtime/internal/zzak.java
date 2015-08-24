package com.google.android.gms.drive.realtime.internal;

import android.os.Handler;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.realtime.Model;
import com.google.android.gms.drive.realtime.RealtimeDocument;
import com.google.android.gms.drive.realtime.RealtimeDocument.CollaboratorJoinedEvent;
import com.google.android.gms.drive.realtime.RealtimeDocument.CollaboratorLeftEvent;
import com.google.android.gms.drive.realtime.RealtimeDocument.ErrorEvent;
import com.google.android.gms.drive.realtime.RealtimeEvent.Listener;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Set;

public class zzak
  implements IBinder.DeathRecipient, RealtimeDocument
{
  private final Handler mHandler;
  private final Set<RealtimeEvent.Listener<RealtimeDocument.CollaboratorJoinedEvent>> zzazS = Collections.newSetFromMap(new IdentityHashMap());
  private final Set<RealtimeEvent.Listener<RealtimeDocument.CollaboratorLeftEvent>> zzazT = Collections.newSetFromMap(new IdentityHashMap());
  private final Set<RealtimeEvent.Listener<RealtimeDocument.ErrorEvent>> zzazU = Collections.newSetFromMap(new IdentityHashMap());
  private final Set<RealtimeEvent.Listener<Object>> zzazV = Collections.newSetFromMap(new IdentityHashMap());
  private final Model zzazW;
  private zzx zzazX;
  private boolean zzazY;
  private zzk zzazZ;
  private final zzt zzazp;
  private final Looper zznW;

  public zzak(zzt paramzzt, Handler paramHandler)
    throws RemoteException
  {
    zzazp = paramzzt;
    zzazW = new zzag(this, paramzzt);
    zznW = paramHandler.getLooper();
    mHandler = paramHandler;
    zzazp.asBinder().linkToDeath(this, 0);
    zztQ();
    zztT();
  }

  private void zztQ()
  {
    try
    {
      zzazp.zza(new zzp.zza()
      {
        public void zzQ(final Status paramAnonymousStatus)
          throws RemoteException
        {
          paramAnonymousStatus = new RealtimeDocument.ErrorEvent(paramAnonymousStatus);
          zzak.zzb(zzak.this).post(new Runnable()
          {
            public void run()
            {
              Iterator localIterator = zzak.zza(zzak.this).iterator();
              while (localIterator.hasNext())
                ((RealtimeEvent.Listener)localIterator.next()).onEvent(paramAnonymousStatus);
            }
          });
        }
      });
      return;
    }
    catch (RemoteException localRemoteException)
    {
    }
    throw new RuntimeException("Need to be connected.");
  }

  private void zztR()
  {
    if (zzazZ == null);
    try
    {
      zzazp.zza(new zzk.zza()
      {
        public void zza(final ParcelableCollaborator paramAnonymousParcelableCollaborator)
        {
          Iterator localIterator = zzak.zzc(zzak.this).iterator();
          while (localIterator.hasNext())
          {
            final RealtimeEvent.Listener localListener = (RealtimeEvent.Listener)localIterator.next();
            zzak.zzb(zzak.this).post(new Runnable()
            {
              public void run()
              {
                localListener.onEvent(new RealtimeDocument.CollaboratorJoinedEvent(paramAnonymousParcelableCollaborator));
              }
            });
          }
        }

        public void zzb(final ParcelableCollaborator paramAnonymousParcelableCollaborator)
        {
          Iterator localIterator = zzak.zzd(zzak.this).iterator();
          while (localIterator.hasNext())
          {
            final RealtimeEvent.Listener localListener = (RealtimeEvent.Listener)localIterator.next();
            zzak.zzb(zzak.this).post(new Runnable()
            {
              public void run()
              {
                localListener.onEvent(new RealtimeDocument.CollaboratorLeftEvent(paramAnonymousParcelableCollaborator));
              }
            });
          }
        }
      });
      return;
    }
    catch (RemoteException localRemoteException)
    {
    }
    throw new RuntimeException("Need to be connected.");
  }

  private void zztT()
  {
    try
    {
      zzazp.zztD();
      return;
    }
    catch (RemoteException localRemoteException)
    {
    }
    throw new RuntimeException("Need to be connected");
  }

  public void addCollaboratorJoinedListener(RealtimeEvent.Listener<RealtimeDocument.CollaboratorJoinedEvent> paramListener)
  {
    zztA();
    zzazS.add(paramListener);
    zztR();
  }

  public void addCollaboratorLeftListener(RealtimeEvent.Listener<RealtimeDocument.CollaboratorLeftEvent> paramListener)
  {
    zztA();
    zzazT.add(paramListener);
    zztR();
  }

  public void binderDied()
  {
    zztO();
  }

  public void close()
  {
    zzaf localzzaf;
    if (!zzazY)
    {
      zztA();
      localzzaf = new zzaf(this);
    }
    try
    {
      zzazp.zzb(localzzaf);
      localzzaf.await();
      zztO();
      return;
    }
    catch (RemoteException localRemoteException)
    {
    }
    throw new RuntimeException("Need to be connected.");
  }

  public Model getModel()
  {
    zztA();
    return zzazW;
  }

  public void removeCollaboratorJoinedListener(RealtimeEvent.Listener<RealtimeDocument.CollaboratorJoinedEvent> paramListener)
  {
    zztA();
    zzazS.remove(paramListener);
  }

  public void removeCollaboratorLeftListener(RealtimeEvent.Listener<RealtimeDocument.CollaboratorLeftEvent> paramListener)
  {
    zztA();
    zzazT.remove(paramListener);
  }

  void zza(zzx paramzzx)
  {
    if ((zzazX != null) && (paramzzx != null))
      throw new IllegalStateException("The Realtime API does not support more than one pending request at a time.");
    zzazX = paramzzx;
  }

  void zztA()
  {
    if (zzazY)
      throw new IllegalStateException("Realtime document is closed.");
    if (!zznW.equals(Looper.myLooper()))
      throw new IllegalStateException("Realtime methods must be run on the same thread as the GoogleApiClient's handler (typically this is the UI thread).");
  }

  void zztO()
  {
    if (!zzazY)
    {
      zzazY = true;
      com.google.android.gms.drive.internal.zzx.zzB("RealtimeDocumentImpl", "Closing Realtime client.");
      if (zzazX != null)
      {
        zzazX.zzQ(Status.zzaim);
        zzazX = null;
      }
      zzazp.asBinder().unlinkToDeath(this, 0);
    }
  }

  void zztP()
  {
    zzazX = null;
  }
}
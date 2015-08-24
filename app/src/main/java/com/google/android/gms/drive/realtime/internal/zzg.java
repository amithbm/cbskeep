package com.google.android.gms.drive.realtime.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.drive.realtime.CollaborativeObjectEvent;
import com.google.android.gms.drive.realtime.CollaborativeString;
import com.google.android.gms.drive.realtime.CollaborativeString.TextDeletedEvent;
import com.google.android.gms.drive.realtime.CollaborativeString.TextInsertedEvent;
import com.google.android.gms.drive.realtime.RealtimeEvent.Listener;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class zzg extends zzf
  implements CollaborativeString
{
  private String zzazs;
  private Set<RealtimeEvent.Listener<CollaborativeString.TextInsertedEvent>> zzazt = new HashSet();
  private Set<RealtimeEvent.Listener<CollaborativeString.TextDeletedEvent>> zzazu = new HashSet();

  public zzg(zzt paramzzt, String paramString, zzag paramzzag)
  {
    super(paramzzt, paramString, paramzzag, "EditableString");
  }

  private void zzhJ(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > length()))
      throw new IndexOutOfBoundsException("index: " + paramInt + " length: " + length());
  }

  private void zztC()
  {
    zzae localzzae;
    if (zzazs == null)
      localzzae = new zzae(zztz().zztM());
    try
    {
      zztB().zzb(getId(), localzzae);
      zzazs = localzzae.zztK();
      return;
    }
    catch (RemoteException localRemoteException)
    {
    }
    throw new IllegalStateException("The GoogleApiClient must be actively connected.");
  }

  public void addTextDeletedListener(RealtimeEvent.Listener<CollaborativeString.TextDeletedEvent> paramListener)
  {
    zztA();
    zzazu.add(paramListener);
  }

  public void addTextInsertedListener(RealtimeEvent.Listener<CollaborativeString.TextInsertedEvent> paramListener)
  {
    zztA();
    zzazt.add(paramListener);
  }

  public Appendable append(char paramChar)
    throws IOException
  {
    zztA();
    return append(String.valueOf(paramChar));
  }

  public Appendable append(CharSequence paramCharSequence)
    throws IOException
  {
    zztA();
    return append(paramCharSequence, 0, paramCharSequence.length());
  }

  public Appendable append(CharSequence paramCharSequence, int paramInt1, int paramInt2)
    throws IOException
  {
    zztA();
    insertString(length(), paramCharSequence.subSequence(paramInt1, paramInt2).toString());
    return this;
  }

  public char charAt(int paramInt)
  {
    zztA();
    zzhJ(paramInt);
    return subSequence(paramInt, paramInt + 1).charAt(0);
  }

  void flushCache()
  {
    zzazs = null;
  }

  public void insertString(int paramInt, String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      return;
    zztA();
    zzhJ(paramInt);
    zzab localzzab = new zzab(zztz().zztM());
    try
    {
      zztB().zza(getId(), paramInt, paramString, localzzab);
      zzazs = null;
      zztz().zzb(localzzab.zztI());
      return;
    }
    catch (RemoteException paramString)
    {
    }
    throw new IllegalStateException("The GoogleApiClient must be actively connected.");
  }

  public int length()
  {
    zztA();
    if (zzazs != null)
      return zzazs.length();
    zzad localzzad = new zzad(zztz().zztM());
    try
    {
      zztB().zzb(getId(), localzzad);
      int i = localzzad.await();
      return i;
    }
    catch (RemoteException localRemoteException)
    {
    }
    throw new IllegalStateException("The GoogleApiClient must be actively connected.");
  }

  public void removeRange(int paramInt1, int paramInt2)
  {
    zztA();
    zzhJ(paramInt1);
    zzhJ(paramInt2);
    zzab localzzab = new zzab(zztz().zztM());
    try
    {
      zztB().zza(getId(), paramInt1, paramInt2, localzzab);
      zzazs = null;
      zztz().zzb(localzzab.zztI());
      return;
    }
    catch (RemoteException localRemoteException)
    {
    }
    throw new IllegalStateException("The GoogleApiClient must be actively connected.");
  }

  public void removeTextDeletedListener(RealtimeEvent.Listener<CollaborativeString.TextDeletedEvent> paramListener)
  {
    zztA();
    zzazu.remove(paramListener);
  }

  public void removeTextInsertedListener(RealtimeEvent.Listener<CollaborativeString.TextInsertedEvent> paramListener)
  {
    zztA();
    zzazt.remove(paramListener);
  }

  public void setText(String paramString)
  {
    zztA();
    zzab localzzab = new zzab(zztz().zztM());
    try
    {
      zztB().zza(getId(), paramString, localzzab);
      zztz().zzb(localzzab.zztI());
      zzazs = null;
      return;
    }
    catch (RemoteException paramString)
    {
    }
    throw new IllegalStateException("The GoogleApiClient must be actively connected.");
  }

  public CharSequence subSequence(int paramInt1, int paramInt2)
  {
    zztA();
    zzhJ(paramInt1);
    zzhJ(paramInt2);
    zztC();
    return zzazs.subSequence(paramInt1, paramInt2);
  }

  public String toString()
  {
    zztA();
    return subSequence(0, length()).toString();
  }

  public void zza(CollaborativeObjectEvent paramCollaborativeObjectEvent)
  {
    super.zza(paramCollaborativeObjectEvent);
    Iterator localIterator;
    if ((paramCollaborativeObjectEvent instanceof CollaborativeString.TextInsertedEvent))
    {
      localIterator = zzazt.iterator();
      while (localIterator.hasNext())
        ((RealtimeEvent.Listener)localIterator.next()).onEvent((CollaborativeString.TextInsertedEvent)paramCollaborativeObjectEvent);
    }
    if ((paramCollaborativeObjectEvent instanceof CollaborativeString.TextDeletedEvent))
    {
      localIterator = zzazu.iterator();
      while (localIterator.hasNext())
        ((RealtimeEvent.Listener)localIterator.next()).onEvent((CollaborativeString.TextDeletedEvent)paramCollaborativeObjectEvent);
    }
  }
}
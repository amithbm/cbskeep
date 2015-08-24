package com.google.android.gms.drive.realtime.internal;

import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.realtime.CollaborativeList;
import com.google.android.gms.drive.realtime.CollaborativeList.ValuesAddedEvent;
import com.google.android.gms.drive.realtime.CollaborativeList.ValuesRemovedEvent;
import com.google.android.gms.drive.realtime.CollaborativeList.ValuesSetEvent;
import com.google.android.gms.drive.realtime.CollaborativeObjectEvent;
import com.google.android.gms.drive.realtime.RealtimeEvent.Listener;
import com.google.android.gms.internal.zzmy;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

public class zzc extends zzf
  implements CollaborativeList
{
  private int mSize = -1;
  private List<Object> zzazf;
  private List<Object> zzazg;
  private Set<RealtimeEvent.Listener<CollaborativeList.ValuesAddedEvent>> zzazh = new HashSet();
  private Set<RealtimeEvent.Listener<CollaborativeList.ValuesRemovedEvent>> zzazi = new HashSet();
  private Set<RealtimeEvent.Listener<CollaborativeList.ValuesSetEvent>> zzazj = new HashSet();

  public zzc(zzt paramzzt, String paramString, zzag paramzzag)
  {
    super(paramzzt, paramString, paramzzag, "List");
  }

  private void zzhJ(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > size()))
      throw new IndexOutOfBoundsException("index: " + paramInt + " size: " + size());
  }

  // ERROR //
  private void zzty()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 74	com/google/android/gms/drive/realtime/internal/zzc:zzazf	Ljava/util/List;
    //   4: ifnull +4 -> 8
    //   7: return
    //   8: new 76	com/google/android/gms/drive/realtime/internal/zzz
    //   11: dup
    //   12: aload_0
    //   13: invokevirtual 80	com/google/android/gms/drive/realtime/internal/zzc:zztz	()Lcom/google/android/gms/drive/realtime/internal/zzag;
    //   16: invokevirtual 86	com/google/android/gms/drive/realtime/internal/zzag:zztM	()Lcom/google/android/gms/drive/realtime/internal/zzak;
    //   19: invokespecial 89	com/google/android/gms/drive/realtime/internal/zzz:<init>	(Lcom/google/android/gms/drive/realtime/internal/zzak;)V
    //   22: astore_2
    //   23: aconst_null
    //   24: astore_1
    //   25: aload_0
    //   26: invokevirtual 93	com/google/android/gms/drive/realtime/internal/zzc:zztB	()Lcom/google/android/gms/drive/realtime/internal/zzt;
    //   29: aload_0
    //   30: invokevirtual 96	com/google/android/gms/drive/realtime/internal/zzc:getId	()Ljava/lang/String;
    //   33: aload_2
    //   34: invokeinterface 102 3 0
    //   39: new 104	com/google/android/gms/internal/zznc
    //   42: dup
    //   43: aload_0
    //   44: invokevirtual 80	com/google/android/gms/drive/realtime/internal/zzc:zztz	()Lcom/google/android/gms/drive/realtime/internal/zzag;
    //   47: aload_2
    //   48: invokevirtual 108	com/google/android/gms/drive/realtime/internal/zzz:zztG	()Lcom/google/android/gms/common/data/DataHolder;
    //   51: invokespecial 111	com/google/android/gms/internal/zznc:<init>	(Lcom/google/android/gms/drive/realtime/internal/zzag;Lcom/google/android/gms/common/data/DataHolder;)V
    //   54: astore_2
    //   55: aload_2
    //   56: astore_1
    //   57: aload_0
    //   58: new 113	java/util/ArrayList
    //   61: dup
    //   62: aload_2
    //   63: invokeinterface 118 1 0
    //   68: invokespecial 120	java/util/ArrayList:<init>	(I)V
    //   71: putfield 74	com/google/android/gms/drive/realtime/internal/zzc:zzazf	Ljava/util/List;
    //   74: aload_2
    //   75: astore_1
    //   76: aload_2
    //   77: invokeinterface 124 1 0
    //   82: astore_3
    //   83: aload_2
    //   84: astore_1
    //   85: aload_3
    //   86: invokeinterface 130 1 0
    //   91: ifeq +56 -> 147
    //   94: aload_2
    //   95: astore_1
    //   96: aload_3
    //   97: invokeinterface 134 1 0
    //   102: astore 4
    //   104: aload_2
    //   105: astore_1
    //   106: aload_0
    //   107: getfield 74	com/google/android/gms/drive/realtime/internal/zzc:zzazf	Ljava/util/List;
    //   110: aload 4
    //   112: invokeinterface 140 2 0
    //   117: pop
    //   118: goto -35 -> 83
    //   121: astore_1
    //   122: aload_2
    //   123: astore_1
    //   124: new 142	java/lang/IllegalStateException
    //   127: dup
    //   128: ldc 144
    //   130: invokespecial 145	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   133: athrow
    //   134: astore_2
    //   135: aload_1
    //   136: ifnull +9 -> 145
    //   139: aload_1
    //   140: invokeinterface 148 1 0
    //   145: aload_2
    //   146: athrow
    //   147: aload_2
    //   148: astore_1
    //   149: aload_0
    //   150: aload_0
    //   151: getfield 74	com/google/android/gms/drive/realtime/internal/zzc:zzazf	Ljava/util/List;
    //   154: invokestatic 154	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   157: putfield 156	com/google/android/gms/drive/realtime/internal/zzc:zzazg	Ljava/util/List;
    //   160: aload_2
    //   161: ifnull -154 -> 7
    //   164: aload_2
    //   165: invokeinterface 148 1 0
    //   170: return
    //   171: astore_2
    //   172: goto -37 -> 135
    //   175: astore_1
    //   176: aconst_null
    //   177: astore_1
    //   178: goto -54 -> 124
    //
    // Exception table:
    //   from	to	target	type
    //   57	74	121	android/os/RemoteException
    //   76	83	121	android/os/RemoteException
    //   85	94	121	android/os/RemoteException
    //   96	104	121	android/os/RemoteException
    //   106	118	121	android/os/RemoteException
    //   149	160	121	android/os/RemoteException
    //   57	74	134	finally
    //   76	83	134	finally
    //   85	94	134	finally
    //   96	104	134	finally
    //   106	118	134	finally
    //   124	134	134	finally
    //   149	160	134	finally
    //   25	55	171	finally
    //   25	55	175	android/os/RemoteException
  }

  public void add(int paramInt, Object paramObject)
  {
    zztA();
    addAll(paramInt, Collections.singletonList(paramObject));
  }

  public boolean add(Object paramObject)
  {
    zztA();
    add(size(), paramObject);
    return true;
  }

  public boolean addAll(int paramInt, Collection<?> paramCollection)
  {
    zztA();
    zzhJ(paramInt);
    zzab localzzab = new zzab(zztz().zztM());
    paramCollection = zzmy.zzk(paramCollection);
    try
    {
      zztB().zza(getId(), paramInt, paramCollection, localzzab);
      zztz().zzb(localzzab.zztI());
      return true;
    }
    catch (RemoteException localRemoteException)
    {
      throw new IllegalStateException("The GoogleApiClient must be actively connected.");
    }
    finally
    {
      paramCollection.close();
    }
  }

  public boolean addAll(Collection<?> paramCollection)
  {
    zztA();
    return addAll(size(), paramCollection);
  }

  public void addValuesAddedListener(RealtimeEvent.Listener<CollaborativeList.ValuesAddedEvent> paramListener)
  {
    zztA();
    zzazh.add(paramListener);
  }

  public void addValuesRemovedListener(RealtimeEvent.Listener<CollaborativeList.ValuesRemovedEvent> paramListener)
  {
    zztA();
    zzazi.add(paramListener);
  }

  public void clear()
  {
    int i = size();
    if (i == 0)
      return;
    zztA();
    zzaa localzzaa = new zzaa(zztz().zztM());
    DataHolder localDataHolder2 = null;
    DataHolder localDataHolder1 = localDataHolder2;
    try
    {
      zztB().zza(getId(), 0, i, localzzaa);
      localDataHolder1 = localDataHolder2;
      localDataHolder2 = localzzaa.zztG();
      localDataHolder1 = localDataHolder2;
      zztz().zzb(localzzaa.zztH());
      return;
    }
    catch (RemoteException localRemoteException)
    {
      if (localDataHolder1 != null)
        localDataHolder1.close();
    }
    throw new IllegalStateException("The GoogleApiClient must be actively connected.");
  }

  public boolean contains(Object paramObject)
  {
    zztA();
    zzty();
    return zzazf.contains(paramObject);
  }

  public boolean containsAll(Collection<?> paramCollection)
  {
    zztA();
    zzty();
    return zzazf.containsAll(paramCollection);
  }

  void flushCache()
  {
    mSize = -1;
    zzazf = null;
    zzazg = null;
  }

  public Object get(int paramInt)
  {
    zztA();
    zzty();
    return zzazf.get(paramInt);
  }

  public int indexOf(Object paramObject)
  {
    zztA();
    zzty();
    return zzazf.indexOf(paramObject);
  }

  public boolean isEmpty()
  {
    zztA();
    return size() == 0;
  }

  public Iterator<Object> iterator()
  {
    zztA();
    return listIterator();
  }

  public int lastIndexOf(Object paramObject)
  {
    zztA();
    zzty();
    return zzazf.lastIndexOf(paramObject);
  }

  public ListIterator<Object> listIterator()
  {
    zztA();
    return listIterator(0);
  }

  public ListIterator<Object> listIterator(int paramInt)
  {
    zztA();
    zzty();
    return zzazg.listIterator(paramInt);
  }

  // ERROR //
  public Object remove(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 160	com/google/android/gms/drive/realtime/internal/zzc:zztA	()V
    //   4: aload_0
    //   5: iload_1
    //   6: invokespecial 172	com/google/android/gms/drive/realtime/internal/zzc:zzhJ	(I)V
    //   9: new 210	com/google/android/gms/drive/realtime/internal/zzaa
    //   12: dup
    //   13: aload_0
    //   14: invokevirtual 80	com/google/android/gms/drive/realtime/internal/zzc:zztz	()Lcom/google/android/gms/drive/realtime/internal/zzag;
    //   17: invokevirtual 86	com/google/android/gms/drive/realtime/internal/zzag:zztM	()Lcom/google/android/gms/drive/realtime/internal/zzak;
    //   20: invokespecial 211	com/google/android/gms/drive/realtime/internal/zzaa:<init>	(Lcom/google/android/gms/drive/realtime/internal/zzak;)V
    //   23: astore_3
    //   24: aload_0
    //   25: invokevirtual 93	com/google/android/gms/drive/realtime/internal/zzc:zztB	()Lcom/google/android/gms/drive/realtime/internal/zzt;
    //   28: aload_0
    //   29: invokevirtual 96	com/google/android/gms/drive/realtime/internal/zzc:getId	()Ljava/lang/String;
    //   32: iload_1
    //   33: iconst_1
    //   34: aload_3
    //   35: invokeinterface 214 5 0
    //   40: new 104	com/google/android/gms/internal/zznc
    //   43: dup
    //   44: aload_0
    //   45: invokevirtual 80	com/google/android/gms/drive/realtime/internal/zzc:zztz	()Lcom/google/android/gms/drive/realtime/internal/zzag;
    //   48: aload_3
    //   49: invokevirtual 215	com/google/android/gms/drive/realtime/internal/zzaa:zztG	()Lcom/google/android/gms/common/data/DataHolder;
    //   52: invokespecial 111	com/google/android/gms/internal/zznc:<init>	(Lcom/google/android/gms/drive/realtime/internal/zzag;Lcom/google/android/gms/common/data/DataHolder;)V
    //   55: astore_2
    //   56: aload_2
    //   57: iconst_0
    //   58: invokevirtual 252	com/google/android/gms/internal/zznc:get	(I)Ljava/lang/Object;
    //   61: astore 4
    //   63: aload_0
    //   64: invokevirtual 80	com/google/android/gms/drive/realtime/internal/zzc:zztz	()Lcom/google/android/gms/drive/realtime/internal/zzag;
    //   67: aload_3
    //   68: invokevirtual 218	com/google/android/gms/drive/realtime/internal/zzaa:zztH	()Lcom/google/android/gms/drive/realtime/internal/event/ParcelableEventList;
    //   71: invokevirtual 192	com/google/android/gms/drive/realtime/internal/zzag:zzb	(Lcom/google/android/gms/drive/realtime/internal/event/ParcelableEventList;)V
    //   74: aload 4
    //   76: areturn
    //   77: astore_2
    //   78: aconst_null
    //   79: astore_2
    //   80: aload_2
    //   81: ifnull +7 -> 88
    //   84: aload_2
    //   85: invokevirtual 253	com/google/android/gms/internal/zznc:close	()V
    //   88: new 142	java/lang/IllegalStateException
    //   91: dup
    //   92: ldc 144
    //   94: invokespecial 145	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   97: athrow
    //   98: astore_3
    //   99: goto -19 -> 80
    //
    // Exception table:
    //   from	to	target	type
    //   24	56	77	android/os/RemoteException
    //   56	74	98	android/os/RemoteException
  }

  public boolean remove(Object paramObject)
  {
    zztA();
    int i = indexOf(paramObject);
    if (i >= 0)
    {
      remove(i);
      return true;
    }
    return false;
  }

  public boolean removeAll(Collection<?> paramCollection)
  {
    zztA();
    boolean bool = false;
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
      bool |= remove(paramCollection.next());
    return bool;
  }

  public void removeValuesAddedListener(RealtimeEvent.Listener<CollaborativeList.ValuesAddedEvent> paramListener)
  {
    zztA();
    zzazh.remove(paramListener);
  }

  public void removeValuesRemovedListener(RealtimeEvent.Listener<CollaborativeList.ValuesRemovedEvent> paramListener)
  {
    zztA();
    zzazi.remove(paramListener);
  }

  public boolean retainAll(Collection<?> paramCollection)
  {
    zztA();
    throw new UnsupportedOperationException();
  }

  // ERROR //
  public Object set(int paramInt, Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 160	com/google/android/gms/drive/realtime/internal/zzc:zztA	()V
    //   4: aload_0
    //   5: iload_1
    //   6: invokespecial 172	com/google/android/gms/drive/realtime/internal/zzc:zzhJ	(I)V
    //   9: new 210	com/google/android/gms/drive/realtime/internal/zzaa
    //   12: dup
    //   13: aload_0
    //   14: invokevirtual 80	com/google/android/gms/drive/realtime/internal/zzc:zztz	()Lcom/google/android/gms/drive/realtime/internal/zzag;
    //   17: invokevirtual 86	com/google/android/gms/drive/realtime/internal/zzag:zztM	()Lcom/google/android/gms/drive/realtime/internal/zzak;
    //   20: invokespecial 211	com/google/android/gms/drive/realtime/internal/zzaa:<init>	(Lcom/google/android/gms/drive/realtime/internal/zzak;)V
    //   23: astore 5
    //   25: aconst_null
    //   26: astore 4
    //   28: aload_0
    //   29: invokevirtual 93	com/google/android/gms/drive/realtime/internal/zzc:zztB	()Lcom/google/android/gms/drive/realtime/internal/zzt;
    //   32: aload_0
    //   33: invokevirtual 96	com/google/android/gms/drive/realtime/internal/zzc:getId	()Ljava/lang/String;
    //   36: iload_1
    //   37: aload_2
    //   38: invokestatic 275	com/google/android/gms/internal/zzmy:zzC	(Ljava/lang/Object;)Lcom/google/android/gms/common/data/DataHolder;
    //   41: aload 5
    //   43: invokeinterface 278 5 0
    //   48: new 104	com/google/android/gms/internal/zznc
    //   51: dup
    //   52: aload_0
    //   53: invokevirtual 80	com/google/android/gms/drive/realtime/internal/zzc:zztz	()Lcom/google/android/gms/drive/realtime/internal/zzag;
    //   56: aload 5
    //   58: invokevirtual 215	com/google/android/gms/drive/realtime/internal/zzaa:zztG	()Lcom/google/android/gms/common/data/DataHolder;
    //   61: invokespecial 111	com/google/android/gms/internal/zznc:<init>	(Lcom/google/android/gms/drive/realtime/internal/zzag;Lcom/google/android/gms/common/data/DataHolder;)V
    //   64: astore_3
    //   65: aload_3
    //   66: astore_2
    //   67: aload_0
    //   68: invokevirtual 80	com/google/android/gms/drive/realtime/internal/zzc:zztz	()Lcom/google/android/gms/drive/realtime/internal/zzag;
    //   71: aload 5
    //   73: invokevirtual 218	com/google/android/gms/drive/realtime/internal/zzaa:zztH	()Lcom/google/android/gms/drive/realtime/internal/event/ParcelableEventList;
    //   76: invokevirtual 192	com/google/android/gms/drive/realtime/internal/zzag:zzb	(Lcom/google/android/gms/drive/realtime/internal/event/ParcelableEventList;)V
    //   79: aload_3
    //   80: astore_2
    //   81: aload_3
    //   82: iconst_0
    //   83: invokevirtual 252	com/google/android/gms/internal/zznc:get	(I)Ljava/lang/Object;
    //   86: astore 4
    //   88: aload_3
    //   89: ifnull +7 -> 96
    //   92: aload_3
    //   93: invokevirtual 253	com/google/android/gms/internal/zznc:close	()V
    //   96: aload 4
    //   98: areturn
    //   99: astore_2
    //   100: aconst_null
    //   101: astore_2
    //   102: new 142	java/lang/IllegalStateException
    //   105: dup
    //   106: ldc 144
    //   108: invokespecial 145	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   111: athrow
    //   112: astore_3
    //   113: aload_2
    //   114: ifnull +7 -> 121
    //   117: aload_2
    //   118: invokevirtual 253	com/google/android/gms/internal/zznc:close	()V
    //   121: aload_3
    //   122: athrow
    //   123: astore_3
    //   124: aload 4
    //   126: astore_2
    //   127: goto -14 -> 113
    //   130: astore_2
    //   131: aload_3
    //   132: astore_2
    //   133: goto -31 -> 102
    //
    // Exception table:
    //   from	to	target	type
    //   28	65	99	android/os/RemoteException
    //   67	79	112	finally
    //   81	88	112	finally
    //   102	112	112	finally
    //   28	65	123	finally
    //   67	79	130	android/os/RemoteException
    //   81	88	130	android/os/RemoteException
  }

  public int size()
  {
    zztA();
    zzad localzzad;
    if (mSize == -1)
      localzzad = new zzad(zztz().zztM());
    try
    {
      zztB().zzc(getId(), localzzad);
      mSize = localzzad.await();
      return mSize;
    }
    catch (RemoteException localRemoteException)
    {
    }
    throw new IllegalStateException("The GoogleApiClient must be actively connected.");
  }

  public List<Object> subList(int paramInt1, int paramInt2)
  {
    zztA();
    zzhJ(paramInt1);
    zzhJ(paramInt2);
    zzty();
    return zzazg.subList(paramInt1, paramInt2);
  }

  public Object[] toArray()
  {
    zztA();
    zzty();
    return zzazg.toArray();
  }

  public <T> T[] toArray(T[] paramArrayOfT)
  {
    zztA();
    zzty();
    return zzazg.toArray(paramArrayOfT);
  }

  public void zza(CollaborativeObjectEvent paramCollaborativeObjectEvent)
  {
    super.zza(paramCollaborativeObjectEvent);
    Iterator localIterator;
    if ((paramCollaborativeObjectEvent instanceof CollaborativeList.ValuesAddedEvent))
    {
      localIterator = zzazh.iterator();
      while (localIterator.hasNext())
        ((RealtimeEvent.Listener)localIterator.next()).onEvent((CollaborativeList.ValuesAddedEvent)paramCollaborativeObjectEvent);
    }
    if ((paramCollaborativeObjectEvent instanceof CollaborativeList.ValuesRemovedEvent))
    {
      localIterator = zzazi.iterator();
      while (localIterator.hasNext())
        ((RealtimeEvent.Listener)localIterator.next()).onEvent((CollaborativeList.ValuesRemovedEvent)paramCollaborativeObjectEvent);
    }
    if ((paramCollaborativeObjectEvent instanceof CollaborativeList.ValuesSetEvent))
    {
      localIterator = zzazj.iterator();
      while (localIterator.hasNext())
        ((RealtimeEvent.Listener)localIterator.next()).onEvent((CollaborativeList.ValuesSetEvent)paramCollaborativeObjectEvent);
    }
  }
}
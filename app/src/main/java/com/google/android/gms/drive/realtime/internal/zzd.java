package com.google.android.gms.drive.realtime.internal;

import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.realtime.CollaborativeMap;
import com.google.android.gms.drive.realtime.CollaborativeMap.ValueChangedEvent;
import com.google.android.gms.drive.realtime.CollaborativeObjectEvent;
import com.google.android.gms.drive.realtime.RealtimeEvent.Listener;
import com.google.android.gms.internal.zzmy;
import com.google.android.gms.internal.zznc;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class zzd extends zzf
  implements CollaborativeMap
{
  private int mSize = -1;
  private Map<String, Object> zzazk;
  private Map<String, Object> zzazl;
  boolean zzazm = false;
  private Set<RealtimeEvent.Listener<CollaborativeMap.ValueChangedEvent>> zzazn = new HashSet();

  public zzd(zzt paramzzt, String paramString, zzag paramzzag)
  {
    super(paramzzt, paramString, paramzzag, "Map");
  }

  private Object zzf(DataHolder paramDataHolder)
  {
    paramDataHolder = new zznc(zztz(), paramDataHolder);
    try
    {
      if (paramDataHolder.getCount() > 0)
      {
        Object localObject1 = paramDataHolder.get(0);
        return localObject1;
      }
      return null;
    }
    finally
    {
      paramDataHolder.close();
    }
  }

  // ERROR //
  private void zzty()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 63	com/google/android/gms/drive/realtime/internal/zzd:zzazk	Ljava/util/Map;
    //   4: ifnull +11 -> 15
    //   7: aload_0
    //   8: getfield 26	com/google/android/gms/drive/realtime/internal/zzd:zzazm	Z
    //   11: ifeq +4 -> 15
    //   14: return
    //   15: new 65	com/google/android/gms/drive/realtime/internal/zzz
    //   18: dup
    //   19: aload_0
    //   20: invokevirtual 44	com/google/android/gms/drive/realtime/internal/zzd:zztz	()Lcom/google/android/gms/drive/realtime/internal/zzag;
    //   23: invokevirtual 71	com/google/android/gms/drive/realtime/internal/zzag:zztM	()Lcom/google/android/gms/drive/realtime/internal/zzak;
    //   26: invokespecial 74	com/google/android/gms/drive/realtime/internal/zzz:<init>	(Lcom/google/android/gms/drive/realtime/internal/zzak;)V
    //   29: astore_3
    //   30: aconst_null
    //   31: astore_2
    //   32: aload_0
    //   33: invokevirtual 78	com/google/android/gms/drive/realtime/internal/zzd:zztB	()Lcom/google/android/gms/drive/realtime/internal/zzt;
    //   36: aload_0
    //   37: invokevirtual 82	com/google/android/gms/drive/realtime/internal/zzd:getId	()Ljava/lang/String;
    //   40: aload_3
    //   41: invokeinterface 88 3 0
    //   46: new 90	com/google/android/gms/internal/zznd
    //   49: dup
    //   50: aload_0
    //   51: invokevirtual 44	com/google/android/gms/drive/realtime/internal/zzd:zztz	()Lcom/google/android/gms/drive/realtime/internal/zzag;
    //   54: aload_3
    //   55: invokevirtual 94	com/google/android/gms/drive/realtime/internal/zzz:zztG	()Lcom/google/android/gms/common/data/DataHolder;
    //   58: invokespecial 95	com/google/android/gms/internal/zznd:<init>	(Lcom/google/android/gms/drive/realtime/internal/zzag;Lcom/google/android/gms/common/data/DataHolder;)V
    //   61: astore_3
    //   62: aload_3
    //   63: astore_2
    //   64: aload_0
    //   65: new 97	java/util/HashMap
    //   68: dup
    //   69: aload_3
    //   70: invokevirtual 98	com/google/android/gms/internal/zznd:getCount	()I
    //   73: invokespecial 101	java/util/HashMap:<init>	(I)V
    //   76: putfield 63	com/google/android/gms/drive/realtime/internal/zzd:zzazk	Ljava/util/Map;
    //   79: iconst_0
    //   80: istore_1
    //   81: aload_3
    //   82: astore_2
    //   83: iload_1
    //   84: aload_3
    //   85: invokevirtual 98	com/google/android/gms/internal/zznd:getCount	()I
    //   88: if_icmpge +32 -> 120
    //   91: aload_3
    //   92: astore_2
    //   93: aload_0
    //   94: getfield 63	com/google/android/gms/drive/realtime/internal/zzd:zzazk	Ljava/util/Map;
    //   97: aload_3
    //   98: iload_1
    //   99: invokevirtual 105	com/google/android/gms/internal/zznd:zzhP	(I)Ljava/lang/String;
    //   102: aload_3
    //   103: iload_1
    //   104: invokevirtual 106	com/google/android/gms/internal/zznd:get	(I)Ljava/lang/Object;
    //   107: invokeinterface 112 3 0
    //   112: pop
    //   113: iload_1
    //   114: iconst_1
    //   115: iadd
    //   116: istore_1
    //   117: goto -36 -> 81
    //   120: aload_3
    //   121: astore_2
    //   122: aload_0
    //   123: aload_0
    //   124: getfield 63	com/google/android/gms/drive/realtime/internal/zzd:zzazk	Ljava/util/Map;
    //   127: invokestatic 118	java/util/Collections:unmodifiableMap	(Ljava/util/Map;)Ljava/util/Map;
    //   130: putfield 120	com/google/android/gms/drive/realtime/internal/zzd:zzazl	Ljava/util/Map;
    //   133: aload_3
    //   134: astore_2
    //   135: aload_0
    //   136: aload_0
    //   137: getfield 120	com/google/android/gms/drive/realtime/internal/zzd:zzazl	Ljava/util/Map;
    //   140: invokeinterface 123 1 0
    //   145: putfield 28	com/google/android/gms/drive/realtime/internal/zzd:mSize	I
    //   148: aload_3
    //   149: astore_2
    //   150: aload_0
    //   151: iconst_1
    //   152: putfield 26	com/google/android/gms/drive/realtime/internal/zzd:zzazm	Z
    //   155: aload_3
    //   156: ifnull -142 -> 14
    //   159: aload_3
    //   160: invokevirtual 124	com/google/android/gms/internal/zznd:close	()V
    //   163: return
    //   164: astore_2
    //   165: aconst_null
    //   166: astore_2
    //   167: new 126	java/lang/IllegalStateException
    //   170: dup
    //   171: ldc 128
    //   173: invokespecial 131	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   176: athrow
    //   177: astore_3
    //   178: aload_2
    //   179: ifnull +7 -> 186
    //   182: aload_2
    //   183: invokevirtual 124	com/google/android/gms/internal/zznd:close	()V
    //   186: aload_3
    //   187: athrow
    //   188: astore_3
    //   189: goto -11 -> 178
    //   192: astore_2
    //   193: aload_3
    //   194: astore_2
    //   195: goto -28 -> 167
    //
    // Exception table:
    //   from	to	target	type
    //   32	62	164	android/os/RemoteException
    //   64	79	177	finally
    //   83	91	177	finally
    //   93	113	177	finally
    //   122	133	177	finally
    //   135	148	177	finally
    //   150	155	177	finally
    //   167	177	177	finally
    //   32	62	188	finally
    //   64	79	192	android/os/RemoteException
    //   83	91	192	android/os/RemoteException
    //   93	113	192	android/os/RemoteException
    //   122	133	192	android/os/RemoteException
    //   135	148	192	android/os/RemoteException
    //   150	155	192	android/os/RemoteException
  }

  public void addValueChangedListener(RealtimeEvent.Listener<CollaborativeMap.ValueChangedEvent> paramListener)
  {
    zztA();
    zzazn.add(paramListener);
  }

  public void clear()
  {
    zztA();
    zzab localzzab = new zzab(zztz().zztM());
    try
    {
      zztB().zza(getId(), localzzab);
      zztz().zzb(localzzab.zztI());
      flushCache();
      return;
    }
    catch (RemoteException localRemoteException)
    {
    }
    throw new IllegalStateException("The GoogleApiClient must be actively connected.");
  }

  public boolean containsKey(Object paramObject)
  {
    zztA();
    return get(paramObject) != null;
  }

  public boolean containsValue(Object paramObject)
  {
    zztA();
    if (zzazk != null)
    {
      if (zzazk.containsValue(paramObject))
        return true;
      if (zzazm)
        return false;
    }
    zzty();
    return containsValue(paramObject);
  }

  public Set<Map.Entry<String, Object>> entrySet()
  {
    zztA();
    zzty();
    return zzazl.entrySet();
  }

  void flushCache()
  {
    mSize = -1;
    zzazk = null;
    zzazl = null;
  }

  public Object get(Object paramObject)
  {
    zztA();
    if (!(paramObject instanceof String));
    Object localObject;
    do
    {
      return null;
      paramObject = (String)paramObject;
      if (zzazk == null)
        break;
      localObject = zzazk.get(paramObject);
      if (localObject != null)
        return localObject;
    }
    while (zzazm);
    while (true)
    {
      localObject = new zzz(zztz().zztM());
      try
      {
        zztB().zza(getId(), paramObject, (zzm)localObject);
        localObject = zzf(((zzz)localObject).zztG());
        zzazk.put(paramObject, localObject);
        return localObject;
      }
      catch (RemoteException paramObject)
      {
        throw new IllegalStateException("The GoogleApiClient must be actively connected.");
      }
      zzazk = new HashMap();
      zzazm = false;
    }
  }

  public boolean isEmpty()
  {
    zztA();
    return size() == 0;
  }

  public Set<String> keySet()
  {
    zztA();
    zzty();
    return zzazl.keySet();
  }

  public void putAll(Map<? extends String, ? extends Object> paramMap)
  {
    zztA();
    zzab localzzab = new zzab(zztz().zztM());
    paramMap = zzmy.zzF(paramMap);
    try
    {
      zztB().zza(getId(), paramMap, localzzab);
      zztz().zzb(localzzab.zztI());
      flushCache();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new IllegalStateException("The GoogleApiClient must be actively connected.");
    }
    finally
    {
      paramMap.close();
    }
  }

  public Object remove(Object paramObject)
  {
    zztA();
    if (!(paramObject instanceof String))
      return null;
    zzaa localzzaa = new zzaa(zztz().zztM());
    try
    {
      zztB().zza(getId(), (String)paramObject, localzzaa);
      paramObject = zzf(localzzaa.zztG());
      zztz().zzb(localzzaa.zztH());
      flushCache();
      return paramObject;
    }
    catch (RemoteException paramObject)
    {
    }
    throw new IllegalStateException("The GoogleApiClient must be actively connected.");
  }

  public void removeValueChangedListener(RealtimeEvent.Listener<CollaborativeMap.ValueChangedEvent> paramListener)
  {
    zztA();
    zzazn.remove(paramListener);
  }

  public int size()
  {
    zztA();
    zzad localzzad;
    if (mSize == -1)
      localzzad = new zzad(zztz().zztM());
    try
    {
      zztB().zza(getId(), localzzad);
      mSize = localzzad.await();
      return mSize;
    }
    catch (RemoteException localRemoteException)
    {
    }
    throw new IllegalStateException("The GoogleApiClient must be actively connected.");
  }

  public Collection<Object> values()
  {
    zztA();
    zzty();
    return zzazl.values();
  }

  public void zza(CollaborativeObjectEvent paramCollaborativeObjectEvent)
  {
    super.zza(paramCollaborativeObjectEvent);
    if ((paramCollaborativeObjectEvent instanceof CollaborativeMap.ValueChangedEvent))
    {
      Iterator localIterator = zzazn.iterator();
      while (localIterator.hasNext())
        ((RealtimeEvent.Listener)localIterator.next()).onEvent((CollaborativeMap.ValueChangedEvent)paramCollaborativeObjectEvent);
    }
  }

  public Object zzf(String paramString, Object paramObject)
  {
    if (paramString == null)
      throw new IllegalArgumentException("Property is not valid.");
    Object localObject = get(paramString);
    zztA();
    putAll(Collections.singletonMap(paramString, paramObject));
    return localObject;
  }
}
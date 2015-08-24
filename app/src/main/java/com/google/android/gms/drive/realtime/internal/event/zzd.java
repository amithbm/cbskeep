package com.google.android.gms.drive.realtime.internal.event;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.realtime.CollaborativeList;
import com.google.android.gms.drive.realtime.CollaborativeList.ValuesAddedEvent;
import com.google.android.gms.drive.realtime.CollaborativeList.ValuesRemovedEvent;
import com.google.android.gms.drive.realtime.CollaborativeList.ValuesSetEvent;
import com.google.android.gms.drive.realtime.CollaborativeMap;
import com.google.android.gms.drive.realtime.CollaborativeMap.ValueChangedEvent;
import com.google.android.gms.drive.realtime.CollaborativeObject;
import com.google.android.gms.drive.realtime.CollaborativeObject.ObjectChangedEvent;
import com.google.android.gms.drive.realtime.CollaborativeObject.UnknownEvent;
import com.google.android.gms.drive.realtime.CollaborativeObjectEvent;
import com.google.android.gms.drive.realtime.CollaborativeString;
import com.google.android.gms.drive.realtime.CollaborativeString.TextDeletedEvent;
import com.google.android.gms.drive.realtime.CollaborativeString.TextInsertedEvent;
import com.google.android.gms.drive.realtime.CustomCollaborativeObject;
import com.google.android.gms.drive.realtime.CustomCollaborativeObject.FieldChangedEvent;
import com.google.android.gms.drive.realtime.IndexReference;
import com.google.android.gms.drive.realtime.IndexReference.ReferenceShiftedEvent;
import com.google.android.gms.drive.realtime.internal.zzag;
import com.google.android.gms.internal.zznc;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class zzd
{
  private static CollaborativeObjectEvent zza(zzag paramzzag, DataBuffer<Object> paramDataBuffer, ParcelableEvent paramParcelableEvent, Map<String, List<CollaborativeObjectEvent>> paramMap)
  {
    String str1 = paramParcelableEvent.getSessionId();
    String str2 = paramParcelableEvent.getUserId();
    boolean bool1 = paramParcelableEvent.isLocal();
    boolean bool2 = paramParcelableEvent.isUndo();
    boolean bool3 = paramParcelableEvent.isRedo();
    List localList = paramParcelableEvent.getCompoundOperationNames();
    Object localObject1 = paramParcelableEvent.getObjectId();
    Object localObject2 = paramzzag.zzF((String)localObject1, paramParcelableEvent.zztY());
    if (paramParcelableEvent.zztZ() != null)
    {
      paramzzag = (CollaborativeString)localObject2;
      paramParcelableEvent = paramParcelableEvent.zztZ();
      return new CollaborativeString.TextInsertedEvent(str1, str2, localList, bool1, bool2, bool3, paramzzag, (String)paramDataBuffer.get(paramParcelableEvent.zzul()), paramParcelableEvent.getIndex());
    }
    if (paramParcelableEvent.zzua() != null)
    {
      paramzzag = (CollaborativeString)localObject2;
      paramParcelableEvent = paramParcelableEvent.zzua();
      return new CollaborativeString.TextDeletedEvent(str1, str2, localList, bool1, bool2, bool3, paramzzag, (String)paramDataBuffer.get(paramParcelableEvent.zzul()), paramParcelableEvent.getIndex());
    }
    if (paramParcelableEvent.zzub() != null)
    {
      paramMap = (CollaborativeList)localObject2;
      paramParcelableEvent = paramParcelableEvent.zzub();
      localObject1 = zza(paramDataBuffer, paramParcelableEvent.zztX(), paramParcelableEvent.getValueCount());
      localObject2 = paramParcelableEvent.zzum();
      paramDataBuffer = null;
      if (localObject2 != null)
        paramDataBuffer = (CollaborativeList)paramzzag.zzF((String)localObject2, "List");
      return new CollaborativeList.ValuesAddedEvent(str1, str2, localList, bool1, bool2, bool3, paramMap, (List)localObject1, paramParcelableEvent.getIndex(), paramDataBuffer, paramParcelableEvent.getMovedFromIndex());
    }
    if (paramParcelableEvent.zzuc() != null)
    {
      paramMap = (CollaborativeList)localObject2;
      paramParcelableEvent = paramParcelableEvent.zzuc();
      localObject1 = zza(paramDataBuffer, paramParcelableEvent.zztX(), paramParcelableEvent.getValueCount());
      localObject2 = paramParcelableEvent.zzun();
      paramDataBuffer = null;
      if (localObject2 != null)
        paramDataBuffer = (CollaborativeList)paramzzag.zzF((String)localObject2, "List");
      return new CollaborativeList.ValuesRemovedEvent(str1, str2, localList, bool1, bool2, bool3, paramMap, (List)localObject1, paramParcelableEvent.getIndex(), paramDataBuffer, paramParcelableEvent.getMovedToIndex());
    }
    if (paramParcelableEvent.zzud() != null)
    {
      paramzzag = (CollaborativeList)localObject2;
      paramParcelableEvent = paramParcelableEvent.zzud();
      return new CollaborativeList.ValuesSetEvent(str1, str2, localList, bool1, bool2, bool3, paramzzag, zza(paramDataBuffer, paramParcelableEvent.zztV(), paramParcelableEvent.getValueCount()), zza(paramDataBuffer, paramParcelableEvent.zztW(), paramParcelableEvent.getValueCount()), paramParcelableEvent.getIndex());
    }
    if (paramParcelableEvent.zzue() != null)
    {
      paramzzag = (CollaborativeMap)localObject2;
      paramParcelableEvent = paramParcelableEvent.zzue();
      return new CollaborativeMap.ValueChangedEvent(str1, str2, localList, bool1, bool2, bool3, paramzzag, (String)paramDataBuffer.get(paramParcelableEvent.zztU()), paramDataBuffer.get(paramParcelableEvent.zztV()), paramDataBuffer.get(paramParcelableEvent.zztW()));
    }
    if (paramParcelableEvent.zzuf() != null)
    {
      paramzzag = (IndexReference)localObject2;
      paramDataBuffer = paramParcelableEvent.zzuf();
      return new IndexReference.ReferenceShiftedEvent(str1, str2, localList, bool1, bool2, bool3, paramzzag, paramDataBuffer.getOldObjectId(), paramDataBuffer.getNewObjectId(), paramDataBuffer.getOldIndex(), paramDataBuffer.getNewIndex());
    }
    if (paramParcelableEvent.zzug() != null)
    {
      paramzzag = paramParcelableEvent.zzug();
      paramzzag = zzb(paramDataBuffer, paramzzag.zztX(), paramzzag.getValueCount());
      return new CollaborativeObject.ObjectChangedEvent(str1, str2, localList, bool1, bool2, bool3, (CollaborativeObject)localObject2, (List)paramMap.get(localObject1), paramzzag);
    }
    if (paramParcelableEvent.zzuh() != null)
    {
      paramzzag = (CustomCollaborativeObject)localObject2;
      paramParcelableEvent = paramParcelableEvent.zzuh();
      return new CustomCollaborativeObject.FieldChangedEvent(paramzzag, str1, str2, localList, bool1, bool2, bool3, (String)paramDataBuffer.get(paramParcelableEvent.zztU()), paramDataBuffer.get(paramParcelableEvent.zztV()), paramDataBuffer.get(paramParcelableEvent.zztW()));
    }
    return new CollaborativeObject.UnknownEvent(str1, str2, localList, bool1, bool2, bool3, (CollaborativeObject)localObject2);
  }

  private static List<Object> zza(DataBuffer<Object> paramDataBuffer, int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList(paramInt2);
    int i = paramInt1;
    while (i < paramInt1 + paramInt2)
    {
      localArrayList.add(paramDataBuffer.get(i));
      i += 1;
    }
    return localArrayList;
  }

  public static List<CollaborativeObjectEvent> zza(zzag paramzzag, ParcelableEventList paramParcelableEventList)
  {
    HashMap localHashMap = new HashMap();
    DataHolder localDataHolder = paramParcelableEventList.zzui();
    while (true)
    {
      ArrayList localArrayList;
      CollaborativeObjectEvent localCollaborativeObjectEvent;
      try
      {
        Object localObject = paramParcelableEventList.getEvents();
        localArrayList = new ArrayList(((List)localObject).size());
        if (localDataHolder == null)
          break label157;
        paramParcelableEventList = new zznc(paramzzag, paramParcelableEventList.zzui());
        localObject = ((List)localObject).iterator();
        if (!((Iterator)localObject).hasNext())
          break label146;
        ParcelableEvent localParcelableEvent = (ParcelableEvent)((Iterator)localObject).next();
        localCollaborativeObjectEvent = zza(paramzzag, paramParcelableEventList, localParcelableEvent, localHashMap);
        if ((localCollaborativeObjectEvent instanceof CollaborativeObject.ObjectChangedEvent))
        {
          localHashMap.remove(localParcelableEvent.getObjectId());
          localArrayList.add(localCollaborativeObjectEvent);
          continue;
        }
      }
      finally
      {
        if (localDataHolder != null)
          localDataHolder.close();
      }
      zza(localHashMap, localCollaborativeObjectEvent);
      continue;
      label146: if (localDataHolder != null)
        localDataHolder.close();
      return localArrayList;
      label157: paramParcelableEventList = null;
    }
  }

  private static void zza(Map<String, List<CollaborativeObjectEvent>> paramMap, CollaborativeObjectEvent paramCollaborativeObjectEvent)
  {
    List localList = (List)paramMap.get(paramCollaborativeObjectEvent.getTarget().getId());
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new ArrayList();
      paramMap.put(paramCollaborativeObjectEvent.getTarget().getId(), localObject);
    }
    ((List)localObject).add(paramCollaborativeObjectEvent);
  }

  private static List<String> zzb(DataBuffer<Object> paramDataBuffer, int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList(paramInt2);
    int i = paramInt1;
    while (i < paramInt1 + paramInt2)
    {
      localArrayList.add((String)paramDataBuffer.get(i));
      i += 1;
    }
    return localArrayList;
  }
}
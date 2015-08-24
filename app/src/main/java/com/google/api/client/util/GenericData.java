package com.google.api.client.util;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class GenericData extends AbstractMap<String, Object>
  implements Cloneable
{
  final ClassInfo classInfo;
  Map<String, Object> unknownFields = ArrayMap.create();

  public GenericData()
  {
    this(EnumSet.noneOf(Flags.class));
  }

  public GenericData(EnumSet<Flags> paramEnumSet)
  {
    classInfo = ClassInfo.of(getClass(), paramEnumSet.contains(Flags.IGNORE_CASE));
  }

  public GenericData clone()
  {
    try
    {
      GenericData localGenericData = (GenericData)super.clone();
      Data.deepCopy(this, localGenericData);
      localGenericData.unknownFields = ((Map)Data.clone(unknownFields));
      return localGenericData;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new IllegalStateException(localCloneNotSupportedException);
    }
  }

  public Set<Map.Entry<String, Object>> entrySet()
  {
    return new EntrySet();
  }

  public final Object get(Object paramObject)
  {
    if (!(paramObject instanceof String))
      return null;
    String str = (String)paramObject;
    paramObject = classInfo.getFieldInfo(str);
    if (paramObject != null)
      return paramObject.getValue(this);
    paramObject = str;
    if (classInfo.getIgnoreCase())
      paramObject = str.toLowerCase();
    return unknownFields.get(paramObject);
  }

  public final ClassInfo getClassInfo()
  {
    return classInfo;
  }

  public final Object put(String paramString, Object paramObject)
  {
    Object localObject = classInfo.getFieldInfo(paramString);
    if (localObject != null)
    {
      paramString = ((FieldInfo)localObject).getValue(this);
      ((FieldInfo)localObject).setValue(this, paramObject);
      return paramString;
    }
    localObject = paramString;
    if (classInfo.getIgnoreCase())
      localObject = paramString.toLowerCase();
    return unknownFields.put(localObject, paramObject);
  }

  public final void putAll(Map<? extends String, ?> paramMap)
  {
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      set((String)localEntry.getKey(), localEntry.getValue());
    }
  }

  public final Object remove(Object paramObject)
  {
    if (!(paramObject instanceof String))
      return null;
    String str = (String)paramObject;
    if (classInfo.getFieldInfo(str) != null)
      throw new UnsupportedOperationException();
    paramObject = str;
    if (classInfo.getIgnoreCase())
      paramObject = str.toLowerCase();
    return unknownFields.remove(paramObject);
  }

  public GenericData set(String paramString, Object paramObject)
  {
    Object localObject = classInfo.getFieldInfo(paramString);
    if (localObject != null)
    {
      ((FieldInfo)localObject).setValue(this, paramObject);
      return this;
    }
    localObject = paramString;
    if (classInfo.getIgnoreCase())
      localObject = paramString.toLowerCase();
    unknownFields.put(localObject, paramObject);
    return this;
  }

  final class EntryIterator
    implements Iterator<Map.Entry<String, Object>>
  {
    private final Iterator<Map.Entry<String, Object>> fieldIterator;
    private boolean startedUnknown;
    private final Iterator<Map.Entry<String, Object>> unknownIterator;

    EntryIterator(DataMap.EntrySet arg2)
    {
      Object localObject;
      fieldIterator = localObject.iterator();
      unknownIterator = unknownFields.entrySet().iterator();
    }

    public boolean hasNext()
    {
      return (fieldIterator.hasNext()) || (unknownIterator.hasNext());
    }

    public Map.Entry<String, Object> next()
    {
      if (!startedUnknown)
      {
        if (fieldIterator.hasNext())
          return (Map.Entry)fieldIterator.next();
        startedUnknown = true;
      }
      return (Map.Entry)unknownIterator.next();
    }

    public void remove()
    {
      if (startedUnknown)
        unknownIterator.remove();
      fieldIterator.remove();
    }
  }

  final class EntrySet extends AbstractSet<Map.Entry<String, Object>>
  {
    private final DataMap.EntrySet dataEntrySet = new DataMap(GenericData.this, classInfo.getIgnoreCase()).entrySet();

    EntrySet()
    {
    }

    public void clear()
    {
      unknownFields.clear();
      dataEntrySet.clear();
    }

    public Iterator<Map.Entry<String, Object>> iterator()
    {
      return new GenericData.EntryIterator(GenericData.this, dataEntrySet);
    }

    public int size()
    {
      return unknownFields.size() + dataEntrySet.size();
    }
  }

  public static enum Flags
  {
    IGNORE_CASE;
  }
}
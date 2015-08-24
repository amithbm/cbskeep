package com.google.api.client.util;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.NoSuchElementException;

final class DataMap extends AbstractMap<String, Object>
{
  final ClassInfo classInfo;
  final Object object;

  DataMap(Object paramObject, boolean paramBoolean)
  {
    object = paramObject;
    classInfo = ClassInfo.of(paramObject.getClass(), paramBoolean);
    if (!classInfo.isEnum());
    for (paramBoolean = true; ; paramBoolean = false)
    {
      Preconditions.checkArgument(paramBoolean);
      return;
    }
  }

  public boolean containsKey(Object paramObject)
  {
    return get(paramObject) != null;
  }

  public EntrySet entrySet()
  {
    return new EntrySet();
  }

  public Object get(Object paramObject)
  {
    if (!(paramObject instanceof String));
    do
    {
      return null;
      paramObject = classInfo.getFieldInfo((String)paramObject);
    }
    while (paramObject == null);
    return paramObject.getValue(object);
  }

  public Object put(String paramString, Object paramObject)
  {
    FieldInfo localFieldInfo = classInfo.getFieldInfo(paramString);
    Preconditions.checkNotNull(localFieldInfo, "no field of key " + paramString);
    paramString = localFieldInfo.getValue(object);
    localFieldInfo.setValue(object, Preconditions.checkNotNull(paramObject));
    return paramString;
  }

  final class Entry
    implements Map.Entry<String, Object>
  {
    private final FieldInfo fieldInfo;
    private Object fieldValue;

    Entry(FieldInfo paramObject, Object arg3)
    {
      fieldInfo = paramObject;
      Object localObject;
      fieldValue = Preconditions.checkNotNull(localObject);
    }

    public boolean equals(Object paramObject)
    {
      if (this == paramObject);
      do
      {
        return true;
        if (!(paramObject instanceof Map.Entry))
          return false;
        paramObject = (Map.Entry)paramObject;
      }
      while ((getKey().equals(paramObject.getKey())) && (getValue().equals(paramObject.getValue())));
      return false;
    }

    public String getKey()
    {
      String str2 = fieldInfo.getName();
      String str1 = str2;
      if (classInfo.getIgnoreCase())
        str1 = str2.toLowerCase();
      return str1;
    }

    public Object getValue()
    {
      return fieldValue;
    }

    public int hashCode()
    {
      return getKey().hashCode() ^ getValue().hashCode();
    }

    public Object setValue(Object paramObject)
    {
      Object localObject = fieldValue;
      fieldValue = Preconditions.checkNotNull(paramObject);
      fieldInfo.setValue(object, paramObject);
      return localObject;
    }
  }

  final class EntryIterator
    implements Iterator<Map.Entry<String, Object>>
  {
    private FieldInfo currentFieldInfo;
    private boolean isComputed;
    private boolean isRemoved;
    private FieldInfo nextFieldInfo;
    private Object nextFieldValue;
    private int nextKeyIndex = -1;

    EntryIterator()
    {
    }

    public boolean hasNext()
    {
      if (!isComputed)
      {
        isComputed = true;
        for (nextFieldValue = null; nextFieldValue == null; nextFieldValue = nextFieldInfo.getValue(object))
        {
          int i = nextKeyIndex + 1;
          nextKeyIndex = i;
          if (i >= classInfo.names.size())
            break;
          nextFieldInfo = classInfo.getFieldInfo((String)classInfo.names.get(nextKeyIndex));
        }
      }
      return nextFieldValue != null;
    }

    public Map.Entry<String, Object> next()
    {
      if (!hasNext())
        throw new NoSuchElementException();
      currentFieldInfo = nextFieldInfo;
      Object localObject = nextFieldValue;
      isComputed = false;
      isRemoved = false;
      nextFieldInfo = null;
      nextFieldValue = null;
      return new DataMap.Entry(DataMap.this, currentFieldInfo, localObject);
    }

    public void remove()
    {
      if ((currentFieldInfo != null) && (!isRemoved));
      for (boolean bool = true; ; bool = false)
      {
        Preconditions.checkState(bool);
        isRemoved = true;
        currentFieldInfo.setValue(object, null);
        return;
      }
    }
  }

  final class EntrySet extends AbstractSet<Map.Entry<String, Object>>
  {
    EntrySet()
    {
    }

    public void clear()
    {
      Iterator localIterator = classInfo.names.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        classInfo.getFieldInfo(str).setValue(object, null);
      }
    }

    public boolean isEmpty()
    {
      Iterator localIterator = classInfo.names.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (classInfo.getFieldInfo(str).getValue(object) != null)
          return false;
      }
      return true;
    }

    public DataMap.EntryIterator iterator()
    {
      return new DataMap.EntryIterator(DataMap.this);
    }

    public int size()
    {
      int i = 0;
      Iterator localIterator = classInfo.names.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (classInfo.getFieldInfo(str).getValue(object) != null)
          i += 1;
      }
      return i;
    }
  }
}
package com.google.api.client.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class ArrayValueMap
{
  private final Object destination;
  private final Map<Field, ArrayValue> fieldMap = ArrayMap.create();
  private final Map<String, ArrayValue> keyMap = ArrayMap.create();

  public ArrayValueMap(Object paramObject)
  {
    destination = paramObject;
  }

  public void put(Field paramField, Class<?> paramClass, Object paramObject)
  {
    ArrayValue localArrayValue2 = (ArrayValue)fieldMap.get(paramField);
    ArrayValue localArrayValue1 = localArrayValue2;
    if (localArrayValue2 == null)
    {
      localArrayValue1 = new ArrayValue(paramClass);
      fieldMap.put(paramField, localArrayValue1);
    }
    localArrayValue1.addValue(paramClass, paramObject);
  }

  public void setValues()
  {
    Iterator localIterator = keyMap.entrySet().iterator();
    Map.Entry localEntry;
    while (localIterator.hasNext())
    {
      localEntry = (Map.Entry)localIterator.next();
      ((Map)destination).put(localEntry.getKey(), ((ArrayValue)localEntry.getValue()).toArray());
    }
    localIterator = fieldMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      localEntry = (Map.Entry)localIterator.next();
      FieldInfo.setFieldValue((Field)localEntry.getKey(), destination, ((ArrayValue)localEntry.getValue()).toArray());
    }
  }

  static class ArrayValue
  {
    final Class<?> componentType;
    final ArrayList<Object> values = new ArrayList();

    ArrayValue(Class<?> paramClass)
    {
      componentType = paramClass;
    }

    void addValue(Class<?> paramClass, Object paramObject)
    {
      if (paramClass == componentType);
      for (boolean bool = true; ; bool = false)
      {
        Preconditions.checkArgument(bool);
        values.add(paramObject);
        return;
      }
    }

    Object toArray()
    {
      return Types.toArray(values, componentType);
    }
  }
}
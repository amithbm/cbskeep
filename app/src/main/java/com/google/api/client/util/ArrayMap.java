package com.google.api.client.util;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;

public class ArrayMap<K, V> extends AbstractMap<K, V>
  implements Cloneable
{
  private Object[] data;
  int size;

  public static <K, V> ArrayMap<K, V> create()
  {
    return new ArrayMap();
  }

  private int getDataIndexOfKey(Object paramObject)
  {
    int j = size;
    Object[] arrayOfObject = data;
    int i = 0;
    while (i < j << 1)
    {
      Object localObject = arrayOfObject[i];
      if (paramObject == null)
      {
        if (localObject != null);
      }
      else
        while (paramObject.equals(localObject))
          return i;
      i += 2;
    }
    return -2;
  }

  private V removeFromDataIndexOfKey(int paramInt)
  {
    int i = size << 1;
    if ((paramInt < 0) || (paramInt >= i))
      return null;
    Object localObject = valueAtDataIndex(paramInt + 1);
    Object[] arrayOfObject = data;
    int j = i - paramInt - 2;
    if (j != 0)
      System.arraycopy(arrayOfObject, paramInt + 2, arrayOfObject, paramInt, j);
    size -= 1;
    setData(i - 2, null, null);
    return localObject;
  }

  private void setData(int paramInt, K paramK, V paramV)
  {
    Object[] arrayOfObject = data;
    arrayOfObject[paramInt] = paramK;
    arrayOfObject[(paramInt + 1)] = paramV;
  }

  private void setDataCapacity(int paramInt)
  {
    if (paramInt == 0)
      data = null;
    int i;
    Object[] arrayOfObject1;
    Object[] arrayOfObject2;
    do
    {
      do
      {
        return;
        i = size;
        arrayOfObject1 = data;
      }
      while ((i != 0) && (paramInt == arrayOfObject1.length));
      arrayOfObject2 = new Object[paramInt];
      data = arrayOfObject2;
    }
    while (i == 0);
    System.arraycopy(arrayOfObject1, 0, arrayOfObject2, 0, i << 1);
  }

  private V valueAtDataIndex(int paramInt)
  {
    if (paramInt < 0)
      return null;
    return data[paramInt];
  }

  public void clear()
  {
    size = 0;
    data = null;
  }

  public ArrayMap<K, V> clone()
  {
    try
    {
      ArrayMap localArrayMap = (ArrayMap)super.clone();
      Object[] arrayOfObject1 = data;
      if (arrayOfObject1 != null)
      {
        int i = arrayOfObject1.length;
        Object[] arrayOfObject2 = new Object[i];
        localArrayMap.data = arrayOfObject2;
        System.arraycopy(arrayOfObject1, 0, arrayOfObject2, 0, i);
      }
      return localArrayMap;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
    }
    return null;
  }

  public final boolean containsKey(Object paramObject)
  {
    return -2 != getDataIndexOfKey(paramObject);
  }

  public final boolean containsValue(Object paramObject)
  {
    int j = size;
    Object[] arrayOfObject = data;
    int i = 1;
    while (i < j << 1)
    {
      Object localObject = arrayOfObject[i];
      if (paramObject == null)
      {
        if (localObject != null);
      }
      else
        while (paramObject.equals(localObject))
          return true;
      i += 2;
    }
    return false;
  }

  public final void ensureCapacity(int paramInt)
  {
    if (paramInt < 0)
      throw new IndexOutOfBoundsException();
    Object[] arrayOfObject = data;
    int j = paramInt << 1;
    if (arrayOfObject == null);
    for (paramInt = 0; ; paramInt = arrayOfObject.length)
    {
      if (j > paramInt)
      {
        int i = paramInt / 2 * 3 + 1;
        paramInt = i;
        if (i % 2 != 0)
          paramInt = i + 1;
        i = paramInt;
        if (paramInt < j)
          i = j;
        setDataCapacity(i);
      }
      return;
    }
  }

  public final Set<Map.Entry<K, V>> entrySet()
  {
    return new EntrySet();
  }

  public final V get(Object paramObject)
  {
    return valueAtDataIndex(getDataIndexOfKey(paramObject) + 1);
  }

  public final int getIndexOfKey(K paramK)
  {
    return getDataIndexOfKey(paramK) >> 1;
  }

  public final K getKey(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= size))
      return null;
    return data[(paramInt << 1)];
  }

  public final V getValue(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= size))
      return null;
    return valueAtDataIndex((paramInt << 1) + 1);
  }

  public final V put(K paramK, V paramV)
  {
    int j = getIndexOfKey(paramK);
    int i = j;
    if (j == -1)
      i = size;
    return set(i, paramK, paramV);
  }

  public final V remove(int paramInt)
  {
    return removeFromDataIndexOfKey(paramInt << 1);
  }

  public final V remove(Object paramObject)
  {
    return removeFromDataIndexOfKey(getDataIndexOfKey(paramObject));
  }

  public final V set(int paramInt, V paramV)
  {
    int i = size;
    if ((paramInt < 0) || (paramInt >= i))
      throw new IndexOutOfBoundsException();
    paramInt = (paramInt << 1) + 1;
    Object localObject = valueAtDataIndex(paramInt);
    data[paramInt] = paramV;
    return localObject;
  }

  public final V set(int paramInt, K paramK, V paramV)
  {
    if (paramInt < 0)
      throw new IndexOutOfBoundsException();
    int i = paramInt + 1;
    ensureCapacity(i);
    paramInt <<= 1;
    Object localObject = valueAtDataIndex(paramInt + 1);
    setData(paramInt, paramK, paramV);
    if (i > size)
      size = i;
    return localObject;
  }

  public final int size()
  {
    return size;
  }

  final class Entry
    implements Map.Entry<K, V>
  {
    private int index;

    Entry(int arg2)
    {
      int i;
      index = i;
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
      while ((Objects.equal(getKey(), paramObject.getKey())) && (Objects.equal(getValue(), paramObject.getValue())));
      return false;
    }

    public K getKey()
    {
      return getKey(index);
    }

    public V getValue()
    {
      return getValue(index);
    }

    public int hashCode()
    {
      return getKey().hashCode() ^ getValue().hashCode();
    }

    public V setValue(V paramV)
    {
      return set(index, paramV);
    }
  }

  final class EntryIterator
    implements Iterator<Map.Entry<K, V>>
  {
    private int nextIndex;
    private boolean removed;

    EntryIterator()
    {
    }

    public boolean hasNext()
    {
      return nextIndex < size;
    }

    public Map.Entry<K, V> next()
    {
      int i = nextIndex;
      if (i == size)
        throw new NoSuchElementException();
      nextIndex += 1;
      return new ArrayMap.Entry(ArrayMap.this, i);
    }

    public void remove()
    {
      int i = nextIndex - 1;
      if ((removed) || (i < 0))
        throw new IllegalArgumentException();
      remove(i);
      removed = true;
    }
  }

  final class EntrySet extends AbstractSet<Map.Entry<K, V>>
  {
    EntrySet()
    {
    }

    public Iterator<Map.Entry<K, V>> iterator()
    {
      return new ArrayMap.EntryIterator(ArrayMap.this);
    }

    public int size()
    {
      return size;
    }
  }
}
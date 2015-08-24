package com.google.common.collect;

import java.io.Serializable;

class ImmutableEntry<K, V> extends AbstractMapEntry<K, V>
  implements Serializable
{
  private static final long serialVersionUID = 0L;
  private final K key;
  private final V value;

  ImmutableEntry(K paramK, V paramV)
  {
    key = paramK;
    value = paramV;
  }

  public K getKey()
  {
    return key;
  }

  public V getValue()
  {
    return value;
  }

  public final V setValue(V paramV)
  {
    throw new UnsupportedOperationException();
  }
}
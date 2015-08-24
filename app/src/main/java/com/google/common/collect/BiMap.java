package com.google.common.collect;

import java.util.Map;
import java.util.Set;

public abstract interface BiMap<K, V> extends Map<K, V>
{
  public abstract Set<V> values();
}
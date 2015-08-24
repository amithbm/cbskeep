package com.google.common.collect;

import java.util.Set;

public abstract interface Table<R, C, V>
{
  public abstract Set<Cell<R, C, V>> cellSet();

  public static abstract interface Cell<R, C, V>
  {
    public abstract V getValue();
  }
}
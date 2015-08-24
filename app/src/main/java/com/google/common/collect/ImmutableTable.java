package com.google.common.collect;

import java.util.Map;

public abstract class ImmutableTable<R, C, V>
  implements Table<R, C, V>
{
  public abstract ImmutableSet<Table.Cell<R, C, V>> cellSet();

  public boolean equals(Object paramObject)
  {
    if (paramObject == this)
      return true;
    if ((paramObject instanceof Table))
    {
      paramObject = (Table)paramObject;
      return cellSet().equals(paramObject.cellSet());
    }
    return false;
  }

  public int hashCode()
  {
    return cellSet().hashCode();
  }

  public abstract ImmutableMap<R, Map<C, V>> rowMap();

  public String toString()
  {
    return rowMap().toString();
  }
}
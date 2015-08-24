package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class Lists
{
  static int computeArrayListCapacity(int paramInt)
  {
    if (paramInt >= 0);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool);
      return Ints.saturatedCast(5L + paramInt + paramInt / 10);
    }
  }

  static boolean equalsImpl(List<?> paramList, Object paramObject)
  {
    if (paramObject == Preconditions.checkNotNull(paramList));
    do
    {
      return true;
      if (!(paramObject instanceof List))
        return false;
      paramObject = (List)paramObject;
    }
    while ((paramList.size() == paramObject.size()) && (Iterators.elementsEqual(paramList.iterator(), paramObject.iterator())));
    return false;
  }

  static int hashCodeImpl(List<?> paramList)
  {
    int i = 1;
    paramList = paramList.iterator();
    if (paramList.hasNext())
    {
      Object localObject = paramList.next();
      if (localObject == null);
      for (int j = 0; ; j = localObject.hashCode())
      {
        i = i * 31 + j;
        break;
      }
    }
    return i;
  }

  public static <E> ArrayList<E> newArrayList()
  {
    return new ArrayList();
  }

  public static <E> ArrayList<E> newArrayList(E[] paramArrayOfE)
  {
    Preconditions.checkNotNull(paramArrayOfE);
    ArrayList localArrayList = new ArrayList(computeArrayListCapacity(paramArrayOfE.length));
    Collections.addAll(localArrayList, paramArrayOfE);
    return localArrayList;
  }

  public static <E> ArrayList<E> newArrayListWithCapacity(int paramInt)
  {
    if (paramInt >= 0);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool);
      return new ArrayList(paramInt);
    }
  }

  public static <E> LinkedList<E> newLinkedList()
  {
    return new LinkedList();
  }
}
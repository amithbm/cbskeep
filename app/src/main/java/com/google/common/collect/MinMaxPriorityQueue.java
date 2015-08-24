package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;

public final class MinMaxPriorityQueue<E> extends AbstractQueue<E>
{
  private final MinMaxPriorityQueue<E>.Heap maxHeap;
  final int maximumSize;
  private final MinMaxPriorityQueue<E>.Heap minHeap;
  private int modCount;
  private Object[] queue;
  private int size;

  private int calculateNewCapacity()
  {
    int i = queue.length;
    if (i < 64);
    for (i = (i + 1) * 2; ; i = IntMath.checkedMultiply(i / 2, 3))
      return capAtMaximumSize(i, maximumSize);
  }

  private static int capAtMaximumSize(int paramInt1, int paramInt2)
  {
    return Math.min(paramInt1 - 1, paramInt2) + 1;
  }

  private MoveDesc<E> fillHole(int paramInt, E paramE)
  {
    Heap localHeap = heapForIndex(paramInt);
    int i = localHeap.fillHoleAt(paramInt);
    int j = localHeap.bubbleUpAlternatingLevels(i, paramE);
    if (j == i)
      return localHeap.tryCrossOverAndBubbleUp(paramInt, i, paramE);
    if (j < paramInt)
      return new MoveDesc(paramE, elementData(paramInt));
    return null;
  }

  private int getMaxElementIndex()
  {
    switch (size)
    {
    default:
      if (maxHeap.compareElements(1, 2) > 0)
        break;
    case 2:
      return 1;
    case 1:
      return 0;
    }
    return 2;
  }

  private void growIfNeeded()
  {
    if (size > queue.length)
    {
      Object[] arrayOfObject = new Object[calculateNewCapacity()];
      System.arraycopy(queue, 0, arrayOfObject, 0, queue.length);
      queue = arrayOfObject;
    }
  }

  private MinMaxPriorityQueue<E>.Heap heapForIndex(int paramInt)
  {
    if (isEvenLevel(paramInt))
      return minHeap;
    return maxHeap;
  }

  static int initialQueueSize(int paramInt1, int paramInt2, Iterable<?> paramIterable)
  {
    if (paramInt1 == -1)
      paramInt1 = 11;
    while (true)
    {
      int i = paramInt1;
      if ((paramIterable instanceof Collection))
        i = Math.max(paramInt1, ((Collection)paramIterable).size());
      return capAtMaximumSize(i, paramInt2);
    }
  }

  static boolean isEvenLevel(int paramInt)
  {
    paramInt += 1;
    if (paramInt > 0);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkState(bool, "negative index");
      if ((0x55555555 & paramInt) <= (0xAAAAAAAA & paramInt))
        break;
      return true;
    }
    return false;
  }

  private E removeAndGet(int paramInt)
  {
    Object localObject = elementData(paramInt);
    removeAt(paramInt);
    return localObject;
  }

  public boolean add(E paramE)
  {
    offer(paramE);
    return true;
  }

  public boolean addAll(Collection<? extends E> paramCollection)
  {
    boolean bool = false;
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      offer(paramCollection.next());
      bool = true;
    }
    return bool;
  }

  int capacity()
  {
    return queue.length;
  }

  public void clear()
  {
    int i = 0;
    while (i < size)
    {
      queue[i] = null;
      i += 1;
    }
    size = 0;
  }

  E elementData(int paramInt)
  {
    return queue[paramInt];
  }

  boolean isIntact()
  {
    int i = 1;
    while (i < size)
    {
      if (!heapForIndex(i).verifyIndex(i))
        return false;
      i += 1;
    }
    return true;
  }

  public Iterator<E> iterator()
  {
    return new QueueIterator(null);
  }

  public boolean offer(E paramE)
  {
    Preconditions.checkNotNull(paramE);
    modCount += 1;
    int i = size;
    size = (i + 1);
    growIfNeeded();
    heapForIndex(i).bubbleUp(i, paramE);
    return (size <= maximumSize) || (pollLast() != paramE);
  }

  public E peek()
  {
    if (isEmpty())
      return null;
    return elementData(0);
  }

  public E poll()
  {
    if (isEmpty())
      return null;
    return removeAndGet(0);
  }

  public E pollLast()
  {
    if (isEmpty())
      return null;
    return removeAndGet(getMaxElementIndex());
  }

  MoveDesc<E> removeAt(int paramInt)
  {
    Object localObject1 = null;
    Preconditions.checkPositionIndex(paramInt, size);
    modCount += 1;
    size -= 1;
    if (size == paramInt)
      queue[size] = null;
    Object localObject2;
    int i;
    Object localObject3;
    MoveDesc localMoveDesc;
    do
    {
      return localObject1;
      localObject2 = elementData(size);
      i = heapForIndex(size).getCorrectLastElement(localObject2);
      localObject3 = elementData(size);
      queue[size] = null;
      localMoveDesc = fillHole(paramInt, localObject3);
      localObject1 = localMoveDesc;
    }
    while (i >= paramInt);
    if (localMoveDesc == null)
      return new MoveDesc(localObject2, localObject3);
    return new MoveDesc(localObject2, localMoveDesc.replaced);
  }

  public int size()
  {
    return size;
  }

  public Object[] toArray()
  {
    Object[] arrayOfObject = new Object[size];
    System.arraycopy(queue, 0, arrayOfObject, 0, size);
    return arrayOfObject;
  }

  private class Heap
  {
    final Ordering<E> ordering;
    MinMaxPriorityQueue<E>.Heap otherHeap;

    private int getGrandparentIndex(int paramInt)
    {
      return getParentIndex(getParentIndex(paramInt));
    }

    private int getLeftChildIndex(int paramInt)
    {
      return paramInt * 2 + 1;
    }

    private int getParentIndex(int paramInt)
    {
      return (paramInt - 1) / 2;
    }

    private int getRightChildIndex(int paramInt)
    {
      return paramInt * 2 + 2;
    }

    private boolean verifyIndex(int paramInt)
    {
      if ((getLeftChildIndex(paramInt) < this$0.size) && (compareElements(paramInt, getLeftChildIndex(paramInt)) > 0));
      while (((getRightChildIndex(paramInt) < this$0.size) && (compareElements(paramInt, getRightChildIndex(paramInt)) > 0)) || ((paramInt > 0) && (compareElements(paramInt, getParentIndex(paramInt)) > 0)) || ((paramInt > 2) && (compareElements(getGrandparentIndex(paramInt), paramInt) > 0)))
        return false;
      return true;
    }

    void bubbleUp(int paramInt, E paramE)
    {
      int i = crossOverUp(paramInt, paramE);
      if (i == paramInt);
      for (Heap localHeap = this; ; localHeap = otherHeap)
      {
        localHeap.bubbleUpAlternatingLevels(paramInt, paramE);
        return;
        paramInt = i;
      }
    }

    int bubbleUpAlternatingLevels(int paramInt, E paramE)
    {
      while (true)
      {
        int i;
        Object localObject;
        if (paramInt > 2)
        {
          i = getGrandparentIndex(paramInt);
          localObject = this$0.elementData(i);
          if (ordering.compare(localObject, paramE) > 0);
        }
        else
        {
          this$0.queue[paramInt] = paramE;
          return paramInt;
        }
        this$0.queue[paramInt] = localObject;
        paramInt = i;
      }
    }

    int compareElements(int paramInt1, int paramInt2)
    {
      return ordering.compare(this$0.elementData(paramInt1), this$0.elementData(paramInt2));
    }

    int crossOver(int paramInt, E paramE)
    {
      int i = findMinChild(paramInt);
      if ((i > 0) && (ordering.compare(this$0.elementData(i), paramE) < 0))
      {
        this$0.queue[paramInt] = this$0.elementData(i);
        this$0.queue[i] = paramE;
        return i;
      }
      return crossOverUp(paramInt, paramE);
    }

    int crossOverUp(int paramInt, E paramE)
    {
      if (paramInt == 0)
      {
        this$0.queue[0] = paramE;
        return 0;
      }
      int j = getParentIndex(paramInt);
      Object localObject2 = this$0.elementData(j);
      Object localObject1 = localObject2;
      int i = j;
      if (j != 0)
      {
        int k = getRightChildIndex(getParentIndex(j));
        localObject1 = localObject2;
        i = j;
        if (k != j)
        {
          localObject1 = localObject2;
          i = j;
          if (getLeftChildIndex(k) >= this$0.size)
          {
            Object localObject3 = this$0.elementData(k);
            localObject1 = localObject2;
            i = j;
            if (ordering.compare(localObject3, localObject2) < 0)
            {
              i = k;
              localObject1 = localObject3;
            }
          }
        }
      }
      if (ordering.compare(localObject1, paramE) < 0)
      {
        this$0.queue[paramInt] = localObject1;
        this$0.queue[i] = paramE;
        return i;
      }
      this$0.queue[paramInt] = paramE;
      return paramInt;
    }

    int fillHoleAt(int paramInt)
    {
      while (true)
      {
        int i = findMinGrandChild(paramInt);
        if (i <= 0)
          break;
        this$0.queue[paramInt] = this$0.elementData(i);
        paramInt = i;
      }
      return paramInt;
    }

    int findMin(int paramInt1, int paramInt2)
    {
      int j;
      if (paramInt1 >= this$0.size)
      {
        j = -1;
        return j;
      }
      if (paramInt1 > 0);
      for (boolean bool = true; ; bool = false)
      {
        Preconditions.checkState(bool);
        int k = Math.min(paramInt1, this$0.size - paramInt2);
        int i = paramInt1;
        paramInt1 += 1;
        while (true)
        {
          j = i;
          if (paramInt1 >= k + paramInt2)
            break;
          j = i;
          if (compareElements(paramInt1, i) < 0)
            j = paramInt1;
          paramInt1 += 1;
          i = j;
        }
      }
    }

    int findMinChild(int paramInt)
    {
      return findMin(getLeftChildIndex(paramInt), 2);
    }

    int findMinGrandChild(int paramInt)
    {
      paramInt = getLeftChildIndex(paramInt);
      if (paramInt < 0)
        return -1;
      return findMin(getLeftChildIndex(paramInt), 4);
    }

    int getCorrectLastElement(E paramE)
    {
      int i = getParentIndex(this$0.size);
      if (i != 0)
      {
        int j = getRightChildIndex(getParentIndex(i));
        if ((j != i) && (getLeftChildIndex(j) >= this$0.size))
        {
          Object localObject = this$0.elementData(j);
          if (ordering.compare(localObject, paramE) < 0)
          {
            this$0.queue[j] = paramE;
            this$0.queue[this$0.size] = localObject;
            return j;
          }
        }
      }
      return this$0.size;
    }

    MinMaxPriorityQueue.MoveDesc<E> tryCrossOverAndBubbleUp(int paramInt1, int paramInt2, E paramE)
    {
      int i = crossOver(paramInt2, paramE);
      if (i == paramInt2);
      while (true)
      {
        return null;
        if (i < paramInt1);
        for (Object localObject = this$0.elementData(paramInt1); otherHeap.bubbleUpAlternatingLevels(i, paramE) < paramInt1; localObject = this$0.elementData(getParentIndex(paramInt1)))
          return new MinMaxPriorityQueue.MoveDesc(paramE, localObject);
      }
    }
  }

  static class MoveDesc<E>
  {
    final E replaced;
    final E toTrickle;

    MoveDesc(E paramE1, E paramE2)
    {
      toTrickle = paramE1;
      replaced = paramE2;
    }
  }

  private class QueueIterator
    implements Iterator<E>
  {
    private boolean canRemove;
    private int cursor = -1;
    private int expectedModCount = modCount;
    private Queue<E> forgetMeNot;
    private E lastFromForgetMeNot;
    private List<E> skipMe;

    private QueueIterator()
    {
    }

    private boolean containsExact(Iterable<E> paramIterable, E paramE)
    {
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext())
        if (paramIterable.next() == paramE)
          return true;
      return false;
    }

    private int nextNotInSkipMe(int paramInt)
    {
      int i = paramInt;
      if (skipMe != null)
        while (true)
        {
          i = paramInt;
          if (paramInt >= size())
            break;
          i = paramInt;
          if (!containsExact(skipMe, elementData(paramInt)))
            break;
          paramInt += 1;
        }
      return i;
    }

    void checkModCount()
    {
      if (modCount != expectedModCount)
        throw new ConcurrentModificationException();
    }

    public boolean hasNext()
    {
      checkModCount();
      return (nextNotInSkipMe(cursor + 1) < size()) || ((forgetMeNot != null) && (!forgetMeNot.isEmpty()));
    }

    public E next()
    {
      checkModCount();
      int i = nextNotInSkipMe(cursor + 1);
      if (i < size())
      {
        cursor = i;
        canRemove = true;
        return elementData(cursor);
      }
      if (forgetMeNot != null)
      {
        cursor = size();
        lastFromForgetMeNot = forgetMeNot.poll();
        if (lastFromForgetMeNot != null)
        {
          canRemove = true;
          return lastFromForgetMeNot;
        }
      }
      throw new NoSuchElementException("iterator moved past last element in queue.");
    }

    public void remove()
    {
      Preconditions.checkState(canRemove, "no calls to remove() since the last call to next()");
      checkModCount();
      canRemove = false;
      expectedModCount += 1;
      if (cursor < size())
      {
        MinMaxPriorityQueue.MoveDesc localMoveDesc = removeAt(cursor);
        if (localMoveDesc != null)
        {
          if (forgetMeNot == null)
          {
            forgetMeNot = new LinkedList();
            skipMe = new ArrayList(3);
          }
          forgetMeNot.add(localMoveDesc.toTrickle);
          skipMe.add(localMoveDesc.replaced);
        }
        cursor -= 1;
        return;
      }
      Preconditions.checkState(removeExact(lastFromForgetMeNot));
      lastFromForgetMeNot = null;
    }

    boolean removeExact(Object paramObject)
    {
      int i = 0;
      while (i < size)
      {
        if (queue[i] == paramObject)
        {
          removeAt(i);
          return true;
        }
        i += 1;
      }
      return false;
    }
  }
}
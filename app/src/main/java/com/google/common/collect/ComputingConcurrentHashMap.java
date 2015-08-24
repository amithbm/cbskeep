package com.google.common.collect;

import com.google.common.base.Equivalence;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ref.ReferenceQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;

class ComputingConcurrentHashMap<K, V> extends MapMakerInternalMap<K, V>
{
  private static final long serialVersionUID = 4L;
  final Function<? super K, ? extends V> computingFunction;

  ComputingConcurrentHashMap(MapMaker paramMapMaker, Function<? super K, ? extends V> paramFunction)
  {
    super(paramMapMaker);
    computingFunction = ((Function)Preconditions.checkNotNull(paramFunction));
  }

  MapMakerInternalMap.Segment<K, V> createSegment(int paramInt1, int paramInt2)
  {
    return new ComputingSegment(this, paramInt1, paramInt2);
  }

  V getOrCompute(K paramK)
    throws ExecutionException
  {
    int i = hash(Preconditions.checkNotNull(paramK));
    return segmentFor(i).getOrCompute(paramK, i, computingFunction);
  }

  ComputingSegment<K, V> segmentFor(int paramInt)
  {
    return (ComputingSegment)super.segmentFor(paramInt);
  }

  Object writeReplace()
  {
    return new ComputingSerializationProxy(keyStrength, valueStrength, keyEquivalence, valueEquivalence, expireAfterWriteNanos, expireAfterAccessNanos, maximumSize, concurrencyLevel, removalListener, this, computingFunction);
  }

  private static final class ComputationExceptionReference<K, V>
    implements MapMakerInternalMap.ValueReference<K, V>
  {
    final Throwable t;

    ComputationExceptionReference(Throwable paramThrowable)
    {
      t = paramThrowable;
    }

    public void clear(MapMakerInternalMap.ValueReference<K, V> paramValueReference)
    {
    }

    public MapMakerInternalMap.ValueReference<K, V> copyFor(ReferenceQueue<V> paramReferenceQueue, MapMakerInternalMap.ReferenceEntry<K, V> paramReferenceEntry)
    {
      return this;
    }

    public V get()
    {
      return null;
    }

    public MapMakerInternalMap.ReferenceEntry<K, V> getEntry()
    {
      return null;
    }

    public boolean isComputingReference()
    {
      return false;
    }

    public V waitForValue()
      throws ExecutionException
    {
      throw new ExecutionException(t);
    }
  }

  private static final class ComputedReference<K, V>
    implements MapMakerInternalMap.ValueReference<K, V>
  {
    final V value;

    ComputedReference(V paramV)
    {
      value = paramV;
    }

    public void clear(MapMakerInternalMap.ValueReference<K, V> paramValueReference)
    {
    }

    public MapMakerInternalMap.ValueReference<K, V> copyFor(ReferenceQueue<V> paramReferenceQueue, MapMakerInternalMap.ReferenceEntry<K, V> paramReferenceEntry)
    {
      return this;
    }

    public V get()
    {
      return value;
    }

    public MapMakerInternalMap.ReferenceEntry<K, V> getEntry()
    {
      return null;
    }

    public boolean isComputingReference()
    {
      return false;
    }

    public V waitForValue()
    {
      return get();
    }
  }

  static final class ComputingSegment<K, V> extends MapMakerInternalMap.Segment<K, V>
  {
    ComputingSegment(MapMakerInternalMap<K, V> paramMapMakerInternalMap, int paramInt1, int paramInt2)
    {
      super(paramInt1, paramInt2);
    }

    V compute(K paramK, int paramInt, MapMakerInternalMap.ReferenceEntry<K, V> paramReferenceEntry, ComputingConcurrentHashMap.ComputingValueReference<K, V> paramComputingValueReference)
      throws ExecutionException
    {
      Object localObject1 = null;
      Object localObject2 = null;
      System.nanoTime();
      long l2 = 0L;
      long l1 = l2;
      try
      {
        l1 = l2;
        localObject1 = localObject2;
        try
        {
          localObject2 = paramComputingValueReference.compute(paramK, paramInt);
          l1 = l2;
          localObject1 = localObject2;
          l2 = System.nanoTime();
          l1 = l2;
          localObject1 = localObject2;
          if (localObject2 != null)
          {
            l1 = l2;
            localObject1 = localObject2;
            if (put(paramK, paramInt, localObject2, true) != null)
            {
              l1 = l2;
              localObject1 = localObject2;
              enqueueNotification(paramK, paramInt, localObject2, MapMaker.RemovalCause.REPLACED);
            }
          }
          return localObject2;
        }
        finally
        {
        }
      }
      finally
      {
        if (l1 == 0L)
          System.nanoTime();
        if (localObject1 == null)
          clearValue(paramK, paramInt, paramComputingValueReference);
      }
      throw paramReferenceEntry;
    }

    // ERROR //
    V getOrCompute(K paramK, int paramInt, Function<? super K, ? extends V> paramFunction)
      throws ExecutionException
    {
      // Byte code:
      //   0: aload_0
      //   1: aload_1
      //   2: iload_2
      //   3: invokevirtual 56	com/google/common/collect/ComputingConcurrentHashMap$ComputingSegment:getEntry	(Ljava/lang/Object;I)Lcom/google/common/collect/MapMakerInternalMap$ReferenceEntry;
      //   6: astore 10
      //   8: aload 10
      //   10: ifnull +29 -> 39
      //   13: aload_0
      //   14: aload 10
      //   16: invokevirtual 60	com/google/common/collect/ComputingConcurrentHashMap$ComputingSegment:getLiveValue	(Lcom/google/common/collect/MapMakerInternalMap$ReferenceEntry;)Ljava/lang/Object;
      //   19: astore 9
      //   21: aload 9
      //   23: ifnull +16 -> 39
      //   26: aload_0
      //   27: aload 10
      //   29: invokevirtual 64	com/google/common/collect/ComputingConcurrentHashMap$ComputingSegment:recordRead	(Lcom/google/common/collect/MapMakerInternalMap$ReferenceEntry;)V
      //   32: aload_0
      //   33: invokevirtual 68	com/google/common/collect/ComputingConcurrentHashMap$ComputingSegment:postReadCleanup	()V
      //   36: aload 9
      //   38: areturn
      //   39: aload 10
      //   41: ifnull +22 -> 63
      //   44: aload 10
      //   46: astore 9
      //   48: aload 10
      //   50: invokeinterface 74 1 0
      //   55: invokeinterface 80 1 0
      //   60: ifne +396 -> 456
      //   63: iconst_1
      //   64: istore 5
      //   66: aconst_null
      //   67: astore 11
      //   69: aload_0
      //   70: invokevirtual 83	com/google/common/collect/ComputingConcurrentHashMap$ComputingSegment:lock	()V
      //   73: aload_0
      //   74: invokevirtual 86	com/google/common/collect/ComputingConcurrentHashMap$ComputingSegment:preWriteCleanup	()V
      //   77: aload_0
      //   78: getfield 90	com/google/common/collect/ComputingConcurrentHashMap$ComputingSegment:count	I
      //   81: istore 7
      //   83: aload_0
      //   84: getfield 94	com/google/common/collect/ComputingConcurrentHashMap$ComputingSegment:table	Ljava/util/concurrent/atomic/AtomicReferenceArray;
      //   87: astore 13
      //   89: iload_2
      //   90: aload 13
      //   92: invokevirtual 100	java/util/concurrent/atomic/AtomicReferenceArray:length	()I
      //   95: iconst_1
      //   96: isub
      //   97: iand
      //   98: istore 6
      //   100: aload 13
      //   102: iload 6
      //   104: invokevirtual 104	java/util/concurrent/atomic/AtomicReferenceArray:get	(I)Ljava/lang/Object;
      //   107: checkcast 70	com/google/common/collect/MapMakerInternalMap$ReferenceEntry
      //   110: astore 12
      //   112: aload 12
      //   114: astore 9
      //   116: iload 5
      //   118: istore 4
      //   120: aload 9
      //   122: ifnull +62 -> 184
      //   125: aload 9
      //   127: invokeinterface 108 1 0
      //   132: astore 10
      //   134: aload 9
      //   136: invokeinterface 111 1 0
      //   141: iload_2
      //   142: if_icmpne +282 -> 424
      //   145: aload 10
      //   147: ifnull +277 -> 424
      //   150: aload_0
      //   151: getfield 115	com/google/common/collect/ComputingConcurrentHashMap$ComputingSegment:map	Lcom/google/common/collect/MapMakerInternalMap;
      //   154: getfield 121	com/google/common/collect/MapMakerInternalMap:keyEquivalence	Lcom/google/common/base/Equivalence;
      //   157: aload_1
      //   158: aload 10
      //   160: invokevirtual 127	com/google/common/base/Equivalence:equivalent	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   163: ifeq +261 -> 424
      //   166: aload 9
      //   168: invokeinterface 74 1 0
      //   173: invokeinterface 80 1 0
      //   178: ifeq +100 -> 278
      //   181: iconst_0
      //   182: istore 4
      //   184: aload 9
      //   186: astore 10
      //   188: iload 4
      //   190: ifeq +54 -> 244
      //   193: new 27	com/google/common/collect/ComputingConcurrentHashMap$ComputingValueReference
      //   196: dup
      //   197: aload_3
      //   198: invokespecial 130	com/google/common/collect/ComputingConcurrentHashMap$ComputingValueReference:<init>	(Lcom/google/common/base/Function;)V
      //   201: astore 10
      //   203: aload 9
      //   205: ifnonnull +231 -> 436
      //   208: aload_0
      //   209: aload_1
      //   210: iload_2
      //   211: aload 12
      //   213: invokevirtual 134	com/google/common/collect/ComputingConcurrentHashMap$ComputingSegment:newEntry	(Ljava/lang/Object;ILcom/google/common/collect/MapMakerInternalMap$ReferenceEntry;)Lcom/google/common/collect/MapMakerInternalMap$ReferenceEntry;
      //   216: astore 9
      //   218: aload 9
      //   220: aload 10
      //   222: invokeinterface 138 2 0
      //   227: aload 13
      //   229: iload 6
      //   231: aload 9
      //   233: invokevirtual 142	java/util/concurrent/atomic/AtomicReferenceArray:set	(ILjava/lang/Object;)V
      //   236: aload 10
      //   238: astore 11
      //   240: aload 9
      //   242: astore 10
      //   244: aload_0
      //   245: invokevirtual 145	com/google/common/collect/ComputingConcurrentHashMap$ComputingSegment:unlock	()V
      //   248: aload_0
      //   249: invokevirtual 148	com/google/common/collect/ComputingConcurrentHashMap$ComputingSegment:postWriteCleanup	()V
      //   252: aload 10
      //   254: astore 9
      //   256: iload 4
      //   258: ifeq +198 -> 456
      //   261: aload_0
      //   262: aload_1
      //   263: iload_2
      //   264: aload 10
      //   266: aload 11
      //   268: invokevirtual 150	com/google/common/collect/ComputingConcurrentHashMap$ComputingSegment:compute	(Ljava/lang/Object;ILcom/google/common/collect/MapMakerInternalMap$ReferenceEntry;Lcom/google/common/collect/ComputingConcurrentHashMap$ComputingValueReference;)Ljava/lang/Object;
      //   271: astore_1
      //   272: aload_0
      //   273: invokevirtual 68	com/google/common/collect/ComputingConcurrentHashMap$ComputingSegment:postReadCleanup	()V
      //   276: aload_1
      //   277: areturn
      //   278: aload 9
      //   280: invokeinterface 74 1 0
      //   285: invokeinterface 152 1 0
      //   290: astore 14
      //   292: aload 14
      //   294: ifnonnull +72 -> 366
      //   297: aload_0
      //   298: aload 10
      //   300: iload_2
      //   301: aload 14
      //   303: getstatic 155	com/google/common/collect/MapMaker$RemovalCause:COLLECTED	Lcom/google/common/collect/MapMaker$RemovalCause;
      //   306: invokevirtual 44	com/google/common/collect/ComputingConcurrentHashMap$ComputingSegment:enqueueNotification	(Ljava/lang/Object;ILjava/lang/Object;Lcom/google/common/collect/MapMaker$RemovalCause;)V
      //   309: aload_0
      //   310: getfield 159	com/google/common/collect/ComputingConcurrentHashMap$ComputingSegment:evictionQueue	Ljava/util/Queue;
      //   313: aload 9
      //   315: invokeinterface 165 2 0
      //   320: pop
      //   321: aload_0
      //   322: getfield 168	com/google/common/collect/ComputingConcurrentHashMap$ComputingSegment:expirationQueue	Ljava/util/Queue;
      //   325: aload 9
      //   327: invokeinterface 165 2 0
      //   332: pop
      //   333: aload_0
      //   334: iload 7
      //   336: iconst_1
      //   337: isub
      //   338: putfield 90	com/google/common/collect/ComputingConcurrentHashMap$ComputingSegment:count	I
      //   341: iload 5
      //   343: istore 4
      //   345: goto -161 -> 184
      //   348: astore_1
      //   349: aload_0
      //   350: invokevirtual 145	com/google/common/collect/ComputingConcurrentHashMap$ComputingSegment:unlock	()V
      //   353: aload_0
      //   354: invokevirtual 148	com/google/common/collect/ComputingConcurrentHashMap$ComputingSegment:postWriteCleanup	()V
      //   357: aload_1
      //   358: athrow
      //   359: astore_1
      //   360: aload_0
      //   361: invokevirtual 68	com/google/common/collect/ComputingConcurrentHashMap$ComputingSegment:postReadCleanup	()V
      //   364: aload_1
      //   365: athrow
      //   366: aload_0
      //   367: getfield 115	com/google/common/collect/ComputingConcurrentHashMap$ComputingSegment:map	Lcom/google/common/collect/MapMakerInternalMap;
      //   370: invokevirtual 171	com/google/common/collect/MapMakerInternalMap:expires	()Z
      //   373: ifeq +30 -> 403
      //   376: aload_0
      //   377: getfield 115	com/google/common/collect/ComputingConcurrentHashMap$ComputingSegment:map	Lcom/google/common/collect/MapMakerInternalMap;
      //   380: aload 9
      //   382: invokevirtual 175	com/google/common/collect/MapMakerInternalMap:isExpired	(Lcom/google/common/collect/MapMakerInternalMap$ReferenceEntry;)Z
      //   385: ifeq +18 -> 403
      //   388: aload_0
      //   389: aload 10
      //   391: iload_2
      //   392: aload 14
      //   394: getstatic 178	com/google/common/collect/MapMaker$RemovalCause:EXPIRED	Lcom/google/common/collect/MapMaker$RemovalCause;
      //   397: invokevirtual 44	com/google/common/collect/ComputingConcurrentHashMap$ComputingSegment:enqueueNotification	(Ljava/lang/Object;ILjava/lang/Object;Lcom/google/common/collect/MapMaker$RemovalCause;)V
      //   400: goto -91 -> 309
      //   403: aload_0
      //   404: aload 9
      //   406: invokevirtual 181	com/google/common/collect/ComputingConcurrentHashMap$ComputingSegment:recordLockedRead	(Lcom/google/common/collect/MapMakerInternalMap$ReferenceEntry;)V
      //   409: aload_0
      //   410: invokevirtual 145	com/google/common/collect/ComputingConcurrentHashMap$ComputingSegment:unlock	()V
      //   413: aload_0
      //   414: invokevirtual 148	com/google/common/collect/ComputingConcurrentHashMap$ComputingSegment:postWriteCleanup	()V
      //   417: aload_0
      //   418: invokevirtual 68	com/google/common/collect/ComputingConcurrentHashMap$ComputingSegment:postReadCleanup	()V
      //   421: aload 14
      //   423: areturn
      //   424: aload 9
      //   426: invokeinterface 185 1 0
      //   431: astore 9
      //   433: goto -317 -> 116
      //   436: aload 9
      //   438: aload 10
      //   440: invokeinterface 138 2 0
      //   445: aload 10
      //   447: astore 11
      //   449: aload 9
      //   451: astore 10
      //   453: goto -209 -> 244
      //   456: aload 9
      //   458: invokestatic 190	java/lang/Thread:holdsLock	(Ljava/lang/Object;)Z
      //   461: ifne +45 -> 506
      //   464: iconst_1
      //   465: istore 8
      //   467: iload 8
      //   469: ldc 192
      //   471: invokestatic 198	com/google/common/base/Preconditions:checkState	(ZLjava/lang/Object;)V
      //   474: aload 9
      //   476: invokeinterface 74 1 0
      //   481: invokeinterface 201 1 0
      //   486: astore 10
      //   488: aload 10
      //   490: ifnull -490 -> 0
      //   493: aload_0
      //   494: aload 9
      //   496: invokevirtual 64	com/google/common/collect/ComputingConcurrentHashMap$ComputingSegment:recordRead	(Lcom/google/common/collect/MapMakerInternalMap$ReferenceEntry;)V
      //   499: aload_0
      //   500: invokevirtual 68	com/google/common/collect/ComputingConcurrentHashMap$ComputingSegment:postReadCleanup	()V
      //   503: aload 10
      //   505: areturn
      //   506: iconst_0
      //   507: istore 8
      //   509: goto -42 -> 467
      //   512: astore_1
      //   513: goto -164 -> 349
      //
      // Exception table:
      //   from	to	target	type
      //   73	112	348	finally
      //   125	145	348	finally
      //   150	181	348	finally
      //   193	203	348	finally
      //   278	292	348	finally
      //   297	309	348	finally
      //   309	341	348	finally
      //   366	400	348	finally
      //   403	409	348	finally
      //   424	433	348	finally
      //   0	8	359	finally
      //   13	21	359	finally
      //   26	32	359	finally
      //   48	63	359	finally
      //   69	73	359	finally
      //   244	252	359	finally
      //   261	272	359	finally
      //   349	359	359	finally
      //   409	417	359	finally
      //   456	464	359	finally
      //   467	488	359	finally
      //   493	499	359	finally
      //   208	236	512	finally
      //   436	445	512	finally
    }
  }

  static final class ComputingSerializationProxy<K, V> extends MapMakerInternalMap.AbstractSerializationProxy<K, V>
  {
    private static final long serialVersionUID = 4L;
    final Function<? super K, ? extends V> computingFunction;

    ComputingSerializationProxy(MapMakerInternalMap.Strength paramStrength1, MapMakerInternalMap.Strength paramStrength2, Equivalence<Object> paramEquivalence1, Equivalence<Object> paramEquivalence2, long paramLong1, long paramLong2, int paramInt1, int paramInt2, MapMaker.RemovalListener<? super K, ? super V> paramRemovalListener, ConcurrentMap<K, V> paramConcurrentMap, Function<? super K, ? extends V> paramFunction)
    {
      super(paramStrength2, paramEquivalence1, paramEquivalence2, paramLong1, paramLong2, paramInt1, paramInt2, paramRemovalListener, paramConcurrentMap);
      computingFunction = paramFunction;
    }

    private void readObject(ObjectInputStream paramObjectInputStream)
      throws IOException, ClassNotFoundException
    {
      paramObjectInputStream.defaultReadObject();
      delegate = readMapMaker(paramObjectInputStream).makeComputingMap(computingFunction);
      readEntries(paramObjectInputStream);
    }

    private void writeObject(ObjectOutputStream paramObjectOutputStream)
      throws IOException
    {
      paramObjectOutputStream.defaultWriteObject();
      writeMapTo(paramObjectOutputStream);
    }

    Object readResolve()
    {
      return delegate;
    }
  }

  private static final class ComputingValueReference<K, V>
    implements MapMakerInternalMap.ValueReference<K, V>
  {
    volatile MapMakerInternalMap.ValueReference<K, V> computedReference = MapMakerInternalMap.unset();
    final Function<? super K, ? extends V> computingFunction;

    public ComputingValueReference(Function<? super K, ? extends V> paramFunction)
    {
      computingFunction = paramFunction;
    }

    public void clear(MapMakerInternalMap.ValueReference<K, V> paramValueReference)
    {
      setValueReference(paramValueReference);
    }

    V compute(K paramK, int paramInt)
      throws ExecutionException
    {
      try
      {
        paramK = computingFunction.apply(paramK);
        setValueReference(new ComputingConcurrentHashMap.ComputedReference(paramK));
        return paramK;
      }
      catch (Throwable paramK)
      {
        setValueReference(new ComputingConcurrentHashMap.ComputationExceptionReference(paramK));
      }
      throw new ExecutionException(paramK);
    }

    public MapMakerInternalMap.ValueReference<K, V> copyFor(ReferenceQueue<V> paramReferenceQueue, MapMakerInternalMap.ReferenceEntry<K, V> paramReferenceEntry)
    {
      return this;
    }

    public V get()
    {
      return null;
    }

    public MapMakerInternalMap.ReferenceEntry<K, V> getEntry()
    {
      return null;
    }

    public boolean isComputingReference()
    {
      return true;
    }

    void setValueReference(MapMakerInternalMap.ValueReference<K, V> paramValueReference)
    {
      try
      {
        if (computedReference == MapMakerInternalMap.UNSET)
        {
          computedReference = paramValueReference;
          notifyAll();
        }
        return;
      }
      finally
      {
      }
      throw paramValueReference;
    }

    public V waitForValue()
      throws ExecutionException
    {
      int i;
      int j;
      if (computedReference == MapMakerInternalMap.UNSET)
      {
        i = 0;
        j = 0;
      }
      try
      {
        i = j;
        try
        {
          while (true)
          {
            MapMakerInternalMap.ValueReference localValueReference1 = computedReference;
            MapMakerInternalMap.ValueReference localValueReference2 = MapMakerInternalMap.UNSET;
            if (localValueReference1 != localValueReference2)
              break;
            try
            {
              wait();
            }
            catch (InterruptedException localInterruptedException)
            {
              i = 1;
            }
          }
          return computedReference.waitForValue();
        }
        finally
        {
        }
      }
      finally
      {
        if (i != 0)
          Thread.currentThread().interrupt();
      }
    }
  }
}
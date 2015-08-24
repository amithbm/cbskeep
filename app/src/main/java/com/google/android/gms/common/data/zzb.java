package com.google.android.gms.common.data;

import com.google.android.gms.common.internal.zzv;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class zzb<T>
  implements Iterator<T>
{
  protected final DataBuffer<T> zzaiW;
  protected int zzaiX;

  public zzb(DataBuffer<T> paramDataBuffer)
  {
    zzaiW = ((DataBuffer)zzv.zzz(paramDataBuffer));
    zzaiX = -1;
  }

  public boolean hasNext()
  {
    return zzaiX < zzaiW.getCount() - 1;
  }

  public T next()
  {
    if (!hasNext())
      throw new NoSuchElementException("Cannot advance the iterator beyond " + zzaiX);
    DataBuffer localDataBuffer = zzaiW;
    int i = zzaiX + 1;
    zzaiX = i;
    return localDataBuffer.get(i);
  }

  public void remove()
  {
    throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
  }
}
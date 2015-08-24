package com.google.android.gms.common.data;

import com.google.android.gms.common.api.Releasable;
import java.util.Iterator;

public abstract interface DataBuffer<T> extends Releasable, Iterable<T>
{
  @Deprecated
  public abstract void close();

  public abstract T get(int paramInt);

  public abstract int getCount();

  public abstract Iterator<T> iterator();
}
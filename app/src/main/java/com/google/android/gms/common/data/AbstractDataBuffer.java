package com.google.android.gms.common.data;

import android.os.Bundle;
import java.util.Iterator;

public abstract class AbstractDataBuffer<T>
  implements DataBuffer<T>
{
  protected final DataHolder mDataHolder;

  protected AbstractDataBuffer(DataHolder paramDataHolder)
  {
    mDataHolder = paramDataHolder;
    if (mDataHolder != null)
      mDataHolder.zzt(this);
  }

  @Deprecated
  public final void close()
  {
    release();
  }

  public int getCount()
  {
    if (mDataHolder == null)
      return 0;
    return mDataHolder.getCount();
  }

  public Bundle getMetadata()
  {
    return mDataHolder.getMetadata();
  }

  public Iterator<T> iterator()
  {
    return new zzb(this);
  }

  public void release()
  {
    if (mDataHolder != null)
      mDataHolder.close();
  }
}
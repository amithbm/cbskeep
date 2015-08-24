package com.google.android.gms.internal;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.realtime.internal.zzag;

public class zznd extends AbstractDataBuffer<Object>
{
  private final zzag zzazq;

  public zznd(zzag paramzzag, DataHolder paramDataHolder)
  {
    super(paramDataHolder);
    zzazq = paramzzag;
  }

  public Object get(int paramInt)
  {
    return zzmy.zza(mDataHolder, paramInt, zzazq);
  }

  public String zzhP(int paramInt)
  {
    int i = mDataHolder.zzez(paramInt);
    return mDataHolder.zzd("key", paramInt, i);
  }
}
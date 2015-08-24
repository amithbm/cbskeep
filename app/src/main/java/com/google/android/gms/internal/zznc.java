package com.google.android.gms.internal;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.realtime.internal.zzag;

public class zznc extends AbstractDataBuffer<Object>
{
  private final zzag zzazq;

  public zznc(zzag paramzzag, DataHolder paramDataHolder)
  {
    super(paramDataHolder);
    zzazq = paramzzag;
  }

  public Object get(int paramInt)
  {
    return zzmy.zza(mDataHolder, paramInt, zzazq);
  }
}
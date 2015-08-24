package com.google.android.gms.wearable;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzf;
import com.google.android.gms.wearable.internal.zzw;

public class DataEventBuffer extends zzf<DataEvent>
  implements Result
{
  private final Status zzOQ;

  public DataEventBuffer(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
    zzOQ = new Status(paramDataHolder.getStatusCode());
  }

  public Status getStatus()
  {
    return zzOQ;
  }

  protected DataEvent zzL(int paramInt1, int paramInt2)
  {
    return new zzw(mDataHolder, paramInt1, paramInt2);
  }

  protected String zzpk()
  {
    return "path";
  }
}
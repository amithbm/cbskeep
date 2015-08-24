package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataItem;

public class zzv
  implements DataEvent
{
  private int zzOu;
  private DataItem zzbHQ;

  public zzv(DataEvent paramDataEvent)
  {
    zzOu = paramDataEvent.getType();
    zzbHQ = ((DataItem)paramDataEvent.getDataItem().freeze());
  }

  public DataItem getDataItem()
  {
    return zzbHQ;
  }

  public int getType()
  {
    return zzOu;
  }

  public String toString()
  {
    String str;
    if (getType() == 1)
      str = "changed";
    while (true)
    {
      return "DataEventEntity{ type=" + str + ", dataitem=" + getDataItem() + " }";
      if (getType() == 2)
        str = "deleted";
      else
        str = "unknown";
    }
  }

  public DataEvent zzGU()
  {
    return this;
  }
}
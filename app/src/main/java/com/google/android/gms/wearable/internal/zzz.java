package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.wearable.DataItemAsset;

public class zzz extends zzc
  implements DataItemAsset
{
  public zzz(DataHolder paramDataHolder, int paramInt)
  {
    super(paramDataHolder, paramInt);
  }

  public String getDataItemKey()
  {
    return getString("asset_key");
  }

  public String getId()
  {
    return getString("asset_id");
  }

  public DataItemAsset zzGV()
  {
    return new zzx(this);
  }
}
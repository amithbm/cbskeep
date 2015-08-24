package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.DataItemAsset;

public class zzx
  implements DataItemAsset
{
  private final String zzLf;
  private final String zzua;

  public zzx(DataItemAsset paramDataItemAsset)
  {
    zzLf = paramDataItemAsset.getId();
    zzua = paramDataItemAsset.getDataItemKey();
  }

  public String getDataItemKey()
  {
    return zzua;
  }

  public String getId()
  {
    return zzLf;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DataItemAssetEntity[");
    localStringBuilder.append("@");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    if (zzLf == null)
      localStringBuilder.append(",noid");
    while (true)
    {
      localStringBuilder.append(", key=");
      localStringBuilder.append(zzua);
      localStringBuilder.append("]");
      return localStringBuilder.toString();
      localStringBuilder.append(",");
      localStringBuilder.append(zzLf);
    }
  }

  public DataItemAsset zzGV()
  {
    return this;
  }
}
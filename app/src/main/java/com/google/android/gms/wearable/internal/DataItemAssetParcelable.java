package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzv;
import com.google.android.gms.wearable.DataItemAsset;

public class DataItemAssetParcelable
  implements SafeParcelable, DataItemAsset
{
  public static final Parcelable.Creator<DataItemAssetParcelable> CREATOR = new zzy();
  final int mVersionCode;
  private final String zzLf;
  private final String zzua;

  DataItemAssetParcelable(int paramInt, String paramString1, String paramString2)
  {
    mVersionCode = paramInt;
    zzLf = paramString1;
    zzua = paramString2;
  }

  public DataItemAssetParcelable(DataItemAsset paramDataItemAsset)
  {
    mVersionCode = 1;
    zzLf = ((String)zzv.zzz(paramDataItemAsset.getId()));
    zzua = ((String)zzv.zzz(paramDataItemAsset.getDataItemKey()));
  }

  public int describeContents()
  {
    return 0;
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
    localStringBuilder.append("DataItemAssetParcelable[");
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

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzy.zza(this, paramParcel, paramInt);
  }

  public DataItemAsset zzGV()
  {
    return this;
  }
}
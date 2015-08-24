package com.google.android.gms.reminders.internal.ref;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.reminders.model.ChainInfo;
import com.google.android.gms.reminders.model.ChainInfoEntity;
import com.google.android.gms.reminders.model.FeatureIdProto;

public class ChainInfoRef extends zza
  implements ChainInfo
{
  private boolean zzbmw = false;
  private FeatureIdProtoRef zzbmx;

  public ChainInfoRef(DataHolder paramDataHolder, int paramInt, String paramString)
  {
    super(paramDataHolder, paramInt, paramString);
  }

  public static boolean zza(DataHolder paramDataHolder, int paramInt1, int paramInt2, String paramString)
  {
    return (paramDataHolder.zzj(zzT(paramString, "chain_name"), paramInt1, paramInt2)) && (FeatureIdProtoRef.zza(paramDataHolder, paramInt1, paramInt2, paramString + "chain_id_"));
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof ChainInfo))
      return false;
    if (this == paramObject)
      return true;
    return ChainInfoEntity.zza(this, (ChainInfo)paramObject);
  }

  public FeatureIdProto getChainId()
  {
    if (!zzbmw)
    {
      zzbmw = true;
      if (!FeatureIdProtoRef.zza(mDataHolder, zzaiZ, zzaja, zzbne + "chain_id_"))
        break label62;
    }
    label62: for (zzbmx = null; ; zzbmx = new FeatureIdProtoRef(mDataHolder, zzaiZ, zzbne + "chain_id_"))
      return zzbmx;
  }

  public String getChainName()
  {
    return getString(zzer("chain_name"));
  }

  public int hashCode()
  {
    return ChainInfoEntity.zza(this);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    new ChainInfoEntity(this).writeToParcel(paramParcel, paramInt);
  }

  public ChainInfo zzCd()
  {
    return new ChainInfoEntity(this);
  }
}
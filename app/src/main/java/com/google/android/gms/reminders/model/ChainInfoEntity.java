package com.google.android.gms.reminders.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;

public class ChainInfoEntity
  implements SafeParcelable, ChainInfo
{
  public static final Parcelable.Creator<ChainInfoEntity> CREATOR = new zzc();
  public final int mVersionCode;
  private final String zzbnA;
  private final FeatureIdProtoEntity zzbnC;

  ChainInfoEntity(int paramInt, String paramString, FeatureIdProtoEntity paramFeatureIdProtoEntity)
  {
    zzbnA = paramString;
    zzbnC = paramFeatureIdProtoEntity;
    mVersionCode = paramInt;
  }

  public ChainInfoEntity(ChainInfo paramChainInfo)
  {
    this(paramChainInfo.getChainName(), paramChainInfo.getChainId(), false);
  }

  ChainInfoEntity(String paramString, FeatureIdProto paramFeatureIdProto, boolean paramBoolean)
  {
    mVersionCode = 1;
    zzbnA = paramString;
    if (paramBoolean)
    {
      zzbnC = ((FeatureIdProtoEntity)paramFeatureIdProto);
      return;
    }
    if (paramFeatureIdProto == null);
    for (paramString = null; ; paramString = new FeatureIdProtoEntity(paramFeatureIdProto))
    {
      zzbnC = paramString;
      return;
    }
  }

  public static int zza(ChainInfo paramChainInfo)
  {
    return zzu.hashCode(new Object[] { paramChainInfo.getChainName(), paramChainInfo.getChainId() });
  }

  public static boolean zza(ChainInfo paramChainInfo1, ChainInfo paramChainInfo2)
  {
    return (zzu.equal(paramChainInfo1.getChainName(), paramChainInfo2.getChainName())) && (zzu.equal(paramChainInfo1.getChainId(), paramChainInfo2.getChainId()));
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
    return zza(this, (ChainInfo)paramObject);
  }

  public FeatureIdProto getChainId()
  {
    return zzbnC;
  }

  public String getChainName()
  {
    return zzbnA;
  }

  public int hashCode()
  {
    return zza(this);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc.zza(this, paramParcel, paramInt);
  }

  public ChainInfo zzCd()
  {
    return this;
  }
}
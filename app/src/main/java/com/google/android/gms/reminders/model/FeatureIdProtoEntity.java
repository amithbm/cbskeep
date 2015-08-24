package com.google.android.gms.reminders.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;

public class FeatureIdProtoEntity
  implements SafeParcelable, FeatureIdProto
{
  public static final Parcelable.Creator<FeatureIdProtoEntity> CREATOR = new zzh();
  public final int mVersionCode;
  private final Long zzbnX;
  private final Long zzbnY;

  FeatureIdProtoEntity(int paramInt, Long paramLong1, Long paramLong2)
  {
    zzbnX = paramLong1;
    zzbnY = paramLong2;
    mVersionCode = paramInt;
  }

  public FeatureIdProtoEntity(FeatureIdProto paramFeatureIdProto)
  {
    this(paramFeatureIdProto.getCellId(), paramFeatureIdProto.getFprint(), false);
  }

  FeatureIdProtoEntity(Long paramLong1, Long paramLong2, boolean paramBoolean)
  {
    this(1, paramLong1, paramLong2);
  }

  public static int zza(FeatureIdProto paramFeatureIdProto)
  {
    return zzu.hashCode(new Object[] { paramFeatureIdProto.getCellId(), paramFeatureIdProto.getFprint() });
  }

  public static boolean zza(FeatureIdProto paramFeatureIdProto1, FeatureIdProto paramFeatureIdProto2)
  {
    return (zzu.equal(paramFeatureIdProto1.getCellId(), paramFeatureIdProto2.getCellId())) && (zzu.equal(paramFeatureIdProto1.getFprint(), paramFeatureIdProto2.getFprint()));
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof FeatureIdProto))
      return false;
    if (this == paramObject)
      return true;
    return zza(this, (FeatureIdProto)paramObject);
  }

  public Long getCellId()
  {
    return zzbnX;
  }

  public Long getFprint()
  {
    return zzbnY;
  }

  public int hashCode()
  {
    return zza(this);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzh.zza(this, paramParcel, paramInt);
  }

  public FeatureIdProto zzCh()
  {
    return this;
  }
}
package com.google.android.gms.reminders.internal.ref;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.reminders.model.FeatureIdProto;
import com.google.android.gms.reminders.model.FeatureIdProtoEntity;

public class FeatureIdProtoRef extends zza
  implements FeatureIdProto
{
  public FeatureIdProtoRef(DataHolder paramDataHolder, int paramInt, String paramString)
  {
    super(paramDataHolder, paramInt, paramString);
  }

  public static boolean zza(DataHolder paramDataHolder, int paramInt1, int paramInt2, String paramString)
  {
    return (paramDataHolder.zzj(zzT(paramString, "cell_id"), paramInt1, paramInt2)) && (paramDataHolder.zzj(zzT(paramString, "fprint"), paramInt1, paramInt2));
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
    return FeatureIdProtoEntity.zza(this, (FeatureIdProto)paramObject);
  }

  public Long getCellId()
  {
    return getAsLong(zzer("cell_id"));
  }

  public Long getFprint()
  {
    return getAsLong(zzer("fprint"));
  }

  public int hashCode()
  {
    return FeatureIdProtoEntity.zza(this);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    new FeatureIdProtoEntity(this).writeToParcel(paramParcel, paramInt);
  }

  public FeatureIdProto zzCh()
  {
    return new FeatureIdProtoEntity(this);
  }
}
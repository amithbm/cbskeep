package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class FieldOnlyFilter extends AbstractFilter
{
  public static final Parcelable.Creator<FieldOnlyFilter> CREATOR = new zzb();
  final int mVersionCode;
  final MetadataBundle zzaxM;
  private final MetadataField<?> zzaxN;

  FieldOnlyFilter(int paramInt, MetadataBundle paramMetadataBundle)
  {
    mVersionCode = paramInt;
    zzaxM = paramMetadataBundle;
    zzaxN = zze.zzb(paramMetadataBundle);
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }

  public <T> T zza(zzf<T> paramzzf)
  {
    return paramzzf.zze(zzaxN);
  }
}
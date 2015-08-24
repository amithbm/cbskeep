package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class ComparisonFilter<T> extends AbstractFilter
{
  public static final zza CREATOR = new zza();
  final int mVersionCode;
  final Operator zzaxL;
  final MetadataBundle zzaxM;
  final MetadataField<T> zzaxN;

  ComparisonFilter(int paramInt, Operator paramOperator, MetadataBundle paramMetadataBundle)
  {
    mVersionCode = paramInt;
    zzaxL = paramOperator;
    zzaxM = paramMetadataBundle;
    zzaxN = zze.zzb(paramMetadataBundle);
  }

  public int describeContents()
  {
    return 0;
  }

  public T getValue()
  {
    return zzaxM.zza(zzaxN);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }

  public <F> F zza(zzf<F> paramzzf)
  {
    return paramzzf.zzb(zzaxL, zzaxN, getValue());
  }
}
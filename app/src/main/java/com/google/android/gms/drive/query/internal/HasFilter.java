package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class HasFilter<T> extends AbstractFilter
{
  public static final zzi CREATOR = new zzi();
  final int mVersionCode;
  final MetadataBundle zzaxM;
  final MetadataField<T> zzaxN;

  HasFilter(int paramInt, MetadataBundle paramMetadataBundle)
  {
    mVersionCode = paramInt;
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
    zzi.zza(this, paramParcel, paramInt);
  }

  public <F> F zza(zzf<F> paramzzf)
  {
    return paramzzf.zzd(zzaxN, getValue());
  }
}
package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.metadata.zzb;
import java.util.Collection;
import java.util.Iterator;

public class InFilter<T> extends AbstractFilter
{
  public static final zzj CREATOR = new zzj();
  final int mVersionCode;
  final MetadataBundle zzaxM;
  private final zzb<T> zzaxZ;

  InFilter(int paramInt, MetadataBundle paramMetadataBundle)
  {
    mVersionCode = paramInt;
    zzaxM = paramMetadataBundle;
    zzaxZ = ((zzb)zze.zzb(paramMetadataBundle));
  }

  public int describeContents()
  {
    return 0;
  }

  public T getValue()
  {
    return ((Collection)zzaxM.zza(zzaxZ)).iterator().next();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzj.zza(this, paramParcel, paramInt);
  }

  public <F> F zza(zzf<F> paramzzf)
  {
    return paramzzf.zzb(zzaxZ, getValue());
  }
}
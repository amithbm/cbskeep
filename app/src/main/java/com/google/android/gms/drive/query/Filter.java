package com.google.android.gms.drive.query;

import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.internal.zzf;

public abstract interface Filter extends SafeParcelable
{
  public abstract <T> T zza(zzf<T> paramzzf);
}
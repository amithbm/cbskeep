package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzv;

public final class Scope
  implements SafeParcelable
{
  public static final Parcelable.Creator<Scope> CREATOR = new zzj();
  final int mVersionCode;
  private final String zzaih;

  Scope(int paramInt, String paramString)
  {
    zzv.zzd(paramString, "scopeUri must not be null or empty");
    mVersionCode = paramInt;
    zzaih = paramString;
  }

  public Scope(String paramString)
  {
    this(1, paramString);
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject)
      return true;
    if (!(paramObject instanceof Scope))
      return false;
    return zzaih.equals(((Scope)paramObject).zzaih);
  }

  public int hashCode()
  {
    return zzaih.hashCode();
  }

  public String toString()
  {
    return zzaih;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzj.zza(this, paramParcel, paramInt);
  }

  public String zzoU()
  {
    return zzaih;
  }
}
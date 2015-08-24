package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.common.internal.zzu.zza;
import com.google.android.gms.location.places.NearbyLikelihood;

public class NearbyLikelihoodEntity
  implements SafeParcelable, NearbyLikelihood
{
  public static final Parcelable.Creator<NearbyLikelihoodEntity> CREATOR = new zzi();
  final int mVersionCode;
  final PlaceImpl zzaVf;
  final float zzaVg;

  NearbyLikelihoodEntity(int paramInt, PlaceImpl paramPlaceImpl, float paramFloat)
  {
    mVersionCode = paramInt;
    zzaVf = paramPlaceImpl;
    zzaVg = paramFloat;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    do
    {
      return true;
      if (!(paramObject instanceof NearbyLikelihoodEntity))
        return false;
      paramObject = (NearbyLikelihoodEntity)paramObject;
    }
    while ((zzaVf.equals(paramObject.zzaVf)) && (zzaVg == paramObject.zzaVg));
    return false;
  }

  public NearbyLikelihood freeze()
  {
    return this;
  }

  public int hashCode()
  {
    return zzu.hashCode(new Object[] { zzaVf, Float.valueOf(zzaVg) });
  }

  public String toString()
  {
    return zzu.zzy(this).zzc("nearby place", zzaVf).zzc("likelihood", Float.valueOf(zzaVg)).toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzi.zza(this, paramParcel, paramInt);
  }
}
package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.common.internal.zzu.zza;
import com.google.android.gms.common.internal.zzv;
import com.google.android.gms.location.places.PlaceLikelihood;

public class PlaceLikelihoodEntity
  implements SafeParcelable, PlaceLikelihood
{
  public static final Parcelable.Creator<PlaceLikelihoodEntity> CREATOR = new zzn();
  final int mVersionCode;
  final PlaceImpl zzaVf;
  final float zzaVg;

  PlaceLikelihoodEntity(int paramInt, PlaceImpl paramPlaceImpl, float paramFloat)
  {
    mVersionCode = paramInt;
    zzaVf = paramPlaceImpl;
    zzaVg = paramFloat;
  }

  public static PlaceLikelihoodEntity zza(PlaceImpl paramPlaceImpl, float paramFloat)
  {
    return new PlaceLikelihoodEntity(0, (PlaceImpl)zzv.zzz(paramPlaceImpl), paramFloat);
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
      if (!(paramObject instanceof PlaceLikelihoodEntity))
        return false;
      paramObject = (PlaceLikelihoodEntity)paramObject;
    }
    while ((zzaVf.equals(paramObject.zzaVf)) && (zzaVg == paramObject.zzaVg));
    return false;
  }

  public int hashCode()
  {
    return zzu.hashCode(new Object[] { zzaVf, Float.valueOf(zzaVg) });
  }

  public String toString()
  {
    return zzu.zzy(this).zzc("place", zzaVf).zzc("likelihood", Float.valueOf(zzaVg)).toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzn.zza(this, paramParcel, paramInt);
  }

  public PlaceLikelihood zzzg()
  {
    return this;
  }
}
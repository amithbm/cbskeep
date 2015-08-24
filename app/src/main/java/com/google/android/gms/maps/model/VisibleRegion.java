package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.common.internal.zzu.zza;

public final class VisibleRegion
  implements SafeParcelable
{
  public static final zzo CREATOR = new zzo();
  public final LatLng farLeft;
  public final LatLng farRight;
  public final LatLngBounds latLngBounds;
  private final int mVersionCode;
  public final LatLng nearLeft;
  public final LatLng nearRight;

  VisibleRegion(int paramInt, LatLng paramLatLng1, LatLng paramLatLng2, LatLng paramLatLng3, LatLng paramLatLng4, LatLngBounds paramLatLngBounds)
  {
    mVersionCode = paramInt;
    nearLeft = paramLatLng1;
    nearRight = paramLatLng2;
    farLeft = paramLatLng3;
    farRight = paramLatLng4;
    latLngBounds = paramLatLngBounds;
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
      if (!(paramObject instanceof VisibleRegion))
        return false;
      paramObject = (VisibleRegion)paramObject;
    }
    while ((nearLeft.equals(paramObject.nearLeft)) && (nearRight.equals(paramObject.nearRight)) && (farLeft.equals(paramObject.farLeft)) && (farRight.equals(paramObject.farRight)) && (latLngBounds.equals(paramObject.latLngBounds)));
    return false;
  }

  int getVersionCode()
  {
    return mVersionCode;
  }

  public int hashCode()
  {
    return zzu.hashCode(new Object[] { nearLeft, nearRight, farLeft, farRight, latLngBounds });
  }

  public String toString()
  {
    return zzu.zzy(this).zzc("nearLeft", nearLeft).zzc("nearRight", nearRight).zzc("farLeft", farLeft).zzc("farRight", farRight).zzc("latLngBounds", latLngBounds).toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzo.zza(this, paramParcel, paramInt);
  }
}
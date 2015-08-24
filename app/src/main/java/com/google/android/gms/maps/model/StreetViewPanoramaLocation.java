package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.common.internal.zzu.zza;

public class StreetViewPanoramaLocation
  implements SafeParcelable
{
  public static final zzk CREATOR = new zzk();
  public final StreetViewPanoramaLink[] links;
  private final int mVersionCode;
  public final String panoId;
  public final LatLng position;

  StreetViewPanoramaLocation(int paramInt, StreetViewPanoramaLink[] paramArrayOfStreetViewPanoramaLink, LatLng paramLatLng, String paramString)
  {
    mVersionCode = paramInt;
    links = paramArrayOfStreetViewPanoramaLink;
    position = paramLatLng;
    panoId = paramString;
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
      if (!(paramObject instanceof StreetViewPanoramaLocation))
        return false;
      paramObject = (StreetViewPanoramaLocation)paramObject;
    }
    while ((panoId.equals(paramObject.panoId)) && (position.equals(paramObject.position)));
    return false;
  }

  int getVersionCode()
  {
    return mVersionCode;
  }

  public int hashCode()
  {
    return zzu.hashCode(new Object[] { position, panoId });
  }

  public String toString()
  {
    return zzu.zzy(this).zzc("panoId", panoId).zzc("position", position.toString()).toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzk.zza(this, paramParcel, paramInt);
  }
}
package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.common.internal.zzu.zza;

public class StreetViewPanoramaLink
  implements SafeParcelable
{
  public static final zzj CREATOR = new zzj();
  public final float bearing;
  private final int mVersionCode;
  public final String panoId;

  StreetViewPanoramaLink(int paramInt, String paramString, float paramFloat)
  {
    mVersionCode = paramInt;
    panoId = paramString;
    float f = paramFloat;
    if (paramFloat <= 0.0D)
      f = paramFloat % 360.0F + 360.0F;
    bearing = (f % 360.0F);
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
      if (!(paramObject instanceof StreetViewPanoramaLink))
        return false;
      paramObject = (StreetViewPanoramaLink)paramObject;
    }
    while ((panoId.equals(paramObject.panoId)) && (Float.floatToIntBits(bearing) == Float.floatToIntBits(paramObject.bearing)));
    return false;
  }

  int getVersionCode()
  {
    return mVersionCode;
  }

  public int hashCode()
  {
    return zzu.hashCode(new Object[] { panoId, Float.valueOf(bearing) });
  }

  public String toString()
  {
    return zzu.zzy(this).zzc("panoId", panoId).zzc("bearing", Float.valueOf(bearing)).toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzj.zza(this, paramParcel, paramInt);
  }
}
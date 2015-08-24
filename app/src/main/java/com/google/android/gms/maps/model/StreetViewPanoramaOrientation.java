package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.common.internal.zzu.zza;
import com.google.android.gms.common.internal.zzv;

public class StreetViewPanoramaOrientation
  implements SafeParcelable
{
  public static final zzl CREATOR = new zzl();
  public final float bearing;
  private final int mVersionCode;
  public final float tilt;

  public StreetViewPanoramaOrientation(float paramFloat1, float paramFloat2)
  {
    this(1, paramFloat1, paramFloat2);
  }

  StreetViewPanoramaOrientation(int paramInt, float paramFloat1, float paramFloat2)
  {
    if ((-90.0F <= paramFloat1) && (paramFloat1 <= 90.0F));
    for (boolean bool = true; ; bool = false)
    {
      zzv.zzb(bool, "Tilt needs to be between -90 and 90 inclusive");
      mVersionCode = paramInt;
      tilt = (0.0F + paramFloat1);
      paramFloat1 = paramFloat2;
      if (paramFloat2 <= 0.0D)
        paramFloat1 = paramFloat2 % 360.0F + 360.0F;
      bearing = (paramFloat1 % 360.0F);
      return;
    }
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
      if (!(paramObject instanceof StreetViewPanoramaOrientation))
        return false;
      paramObject = (StreetViewPanoramaOrientation)paramObject;
    }
    while ((Float.floatToIntBits(tilt) == Float.floatToIntBits(paramObject.tilt)) && (Float.floatToIntBits(bearing) == Float.floatToIntBits(paramObject.bearing)));
    return false;
  }

  int getVersionCode()
  {
    return mVersionCode;
  }

  public int hashCode()
  {
    return zzu.hashCode(new Object[] { Float.valueOf(tilt), Float.valueOf(bearing) });
  }

  public String toString()
  {
    return zzu.zzy(this).zzc("tilt", Float.valueOf(tilt)).zzc("bearing", Float.valueOf(bearing)).toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzl.zza(this, paramParcel, paramInt);
  }

  public static final class Builder
  {
    public float bearing;
    public float tilt;

    public Builder bearing(float paramFloat)
    {
      bearing = paramFloat;
      return this;
    }

    public StreetViewPanoramaOrientation build()
    {
      return new StreetViewPanoramaOrientation(tilt, bearing);
    }

    public Builder tilt(float paramFloat)
    {
      tilt = paramFloat;
      return this;
    }
  }
}
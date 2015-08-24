package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.common.internal.zzu.zza;
import com.google.android.gms.common.internal.zzv;

public class StreetViewPanoramaCamera
  implements SafeParcelable
{
  public static final zzi CREATOR = new zzi();
  public final float bearing;
  private final int mVersionCode;
  public final float tilt;
  public final float zoom;
  private StreetViewPanoramaOrientation zzaZd;

  StreetViewPanoramaCamera(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    boolean bool;
    if ((-90.0F <= paramFloat2) && (paramFloat2 <= 90.0F))
    {
      bool = true;
      zzv.zzb(bool, "Tilt needs to be between -90 and 90 inclusive");
      mVersionCode = paramInt;
      float f = paramFloat1;
      if (paramFloat1 <= 0.0D)
        f = 0.0F;
      zoom = f;
      tilt = (paramFloat2 + 0.0F);
      if (paramFloat3 > 0.0D)
        break label114;
    }
    label114: for (paramFloat1 = paramFloat3 % 360.0F + 360.0F; ; paramFloat1 = paramFloat3)
    {
      bearing = (paramFloat1 % 360.0F);
      zzaZd = new StreetViewPanoramaOrientation.Builder().tilt(paramFloat2).bearing(paramFloat3).build();
      return;
      bool = false;
      break;
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
      if (!(paramObject instanceof StreetViewPanoramaCamera))
        return false;
      paramObject = (StreetViewPanoramaCamera)paramObject;
    }
    while ((Float.floatToIntBits(zoom) == Float.floatToIntBits(paramObject.zoom)) && (Float.floatToIntBits(tilt) == Float.floatToIntBits(paramObject.tilt)) && (Float.floatToIntBits(bearing) == Float.floatToIntBits(paramObject.bearing)));
    return false;
  }

  int getVersionCode()
  {
    return mVersionCode;
  }

  public int hashCode()
  {
    return zzu.hashCode(new Object[] { Float.valueOf(zoom), Float.valueOf(tilt), Float.valueOf(bearing) });
  }

  public String toString()
  {
    return zzu.zzy(this).zzc("zoom", Float.valueOf(zoom)).zzc("tilt", Float.valueOf(tilt)).zzc("bearing", Float.valueOf(bearing)).toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzi.zza(this, paramParcel, paramInt);
  }
}
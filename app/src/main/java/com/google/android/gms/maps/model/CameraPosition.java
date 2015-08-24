package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.common.internal.zzu.zza;
import com.google.android.gms.common.internal.zzv;

public final class CameraPosition
  implements SafeParcelable
{
  public static final zza CREATOR = new zza();
  public final float bearing;
  private final int mVersionCode;
  public final LatLng target;
  public final float tilt;
  public final float zoom;

  CameraPosition(int paramInt, LatLng paramLatLng, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    zzv.zzb(paramLatLng, "null camera target");
    if ((0.0F <= paramFloat2) && (paramFloat2 <= 90.0F));
    for (boolean bool = true; ; bool = false)
    {
      zzv.zzb(bool, "Tilt needs to be between 0 and 90 inclusive: %s", new Object[] { Float.valueOf(paramFloat2) });
      mVersionCode = paramInt;
      target = paramLatLng;
      zoom = paramFloat1;
      tilt = (paramFloat2 + 0.0F);
      paramFloat1 = paramFloat3;
      if (paramFloat3 <= 0.0D)
        paramFloat1 = paramFloat3 % 360.0F + 360.0F;
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
      if (!(paramObject instanceof CameraPosition))
        return false;
      paramObject = (CameraPosition)paramObject;
    }
    while ((target.equals(paramObject.target)) && (Float.floatToIntBits(zoom) == Float.floatToIntBits(paramObject.zoom)) && (Float.floatToIntBits(tilt) == Float.floatToIntBits(paramObject.tilt)) && (Float.floatToIntBits(bearing) == Float.floatToIntBits(paramObject.bearing)));
    return false;
  }

  int getVersionCode()
  {
    return mVersionCode;
  }

  public int hashCode()
  {
    return zzu.hashCode(new Object[] { target, Float.valueOf(zoom), Float.valueOf(tilt), Float.valueOf(bearing) });
  }

  public String toString()
  {
    return zzu.zzy(this).zzc("target", target).zzc("zoom", Float.valueOf(zoom)).zzc("tilt", Float.valueOf(tilt)).zzc("bearing", Float.valueOf(bearing)).toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
}
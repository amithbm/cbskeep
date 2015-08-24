package com.google.android.gms.maps.model.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class GroundOverlayOptionsParcelable
  implements SafeParcelable
{
  public static final zzc CREATOR = new zzc();
  private final int mVersionCode;
  private BitmapDescriptorParcelable zzaZo;

  public GroundOverlayOptionsParcelable()
  {
    mVersionCode = 1;
  }

  GroundOverlayOptionsParcelable(int paramInt, BitmapDescriptorParcelable paramBitmapDescriptorParcelable)
  {
    mVersionCode = paramInt;
    zzaZo = paramBitmapDescriptorParcelable;
  }

  public int describeContents()
  {
    return 0;
  }

  int getVersionCode()
  {
    return mVersionCode;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc.zza(this, paramParcel, paramInt);
  }

  public BitmapDescriptorParcelable zzzV()
  {
    return zzaZo;
  }
}
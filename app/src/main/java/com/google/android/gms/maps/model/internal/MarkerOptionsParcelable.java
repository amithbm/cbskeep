package com.google.android.gms.maps.model.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class MarkerOptionsParcelable
  implements SafeParcelable
{
  public static final zzm CREATOR = new zzm();
  private final int mVersionCode;
  private BitmapDescriptorParcelable zzaZp;

  public MarkerOptionsParcelable()
  {
    mVersionCode = 1;
  }

  MarkerOptionsParcelable(int paramInt, BitmapDescriptorParcelable paramBitmapDescriptorParcelable)
  {
    mVersionCode = paramInt;
    zzaZp = paramBitmapDescriptorParcelable;
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
    zzm.zza(this, paramParcel, paramInt);
  }

  public BitmapDescriptorParcelable zzzX()
  {
    return zzaZp;
  }
}
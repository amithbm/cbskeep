package com.google.android.gms.maps.model.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class CameraUpdateParcelable
  implements SafeParcelable
{
  public static final zzb CREATOR = new zzb();
  private final int mVersionCode;
  private int type;
  private Bundle zzaZm;

  CameraUpdateParcelable(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    mVersionCode = paramInt1;
    type = paramInt2;
    zzaZm = paramBundle;
  }

  public int describeContents()
  {
    return 0;
  }

  public Bundle getParameters()
  {
    return zzaZm;
  }

  public int getType()
  {
    return type;
  }

  public int getVersionCode()
  {
    return mVersionCode;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
}
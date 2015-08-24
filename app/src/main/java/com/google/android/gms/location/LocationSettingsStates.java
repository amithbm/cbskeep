package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class LocationSettingsStates
  implements SafeParcelable
{
  public static final Parcelable.Creator<LocationSettingsStates> CREATOR = new zzj();
  private final int mVersionCode;
  private final boolean zzaRJ;
  private final boolean zzaRK;
  private final boolean zzaRL;
  private final boolean zzaRM;
  private final boolean zzaRN;
  private final boolean zzaRO;
  private final boolean zzaRP;

  LocationSettingsStates(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7)
  {
    mVersionCode = paramInt;
    zzaRJ = paramBoolean1;
    zzaRK = paramBoolean2;
    zzaRL = paramBoolean3;
    zzaRM = paramBoolean4;
    zzaRN = paramBoolean5;
    zzaRO = paramBoolean6;
    zzaRP = paramBoolean7;
  }

  public int describeContents()
  {
    return 0;
  }

  public int getVersionCode()
  {
    return mVersionCode;
  }

  public boolean isBlePresent()
  {
    return zzaRO;
  }

  public boolean isBleUsable()
  {
    return zzaRL;
  }

  public boolean isGpsPresent()
  {
    return zzaRM;
  }

  public boolean isGpsUsable()
  {
    return zzaRJ;
  }

  public boolean isNetworkLocationPresent()
  {
    return zzaRN;
  }

  public boolean isNetworkLocationUsable()
  {
    return zzaRK;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzj.zza(this, paramParcel, paramInt);
  }

  public boolean zzyo()
  {
    return zzaRP;
  }
}
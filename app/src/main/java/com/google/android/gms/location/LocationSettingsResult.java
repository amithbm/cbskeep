package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class LocationSettingsResult
  implements Result, SafeParcelable
{
  public static final Parcelable.Creator<LocationSettingsResult> CREATOR = new zzi();
  private final int mVersionCode;
  private final Status zzOQ;
  private final LocationSettingsStates zzaRI;

  LocationSettingsResult(int paramInt, Status paramStatus, LocationSettingsStates paramLocationSettingsStates)
  {
    mVersionCode = paramInt;
    zzOQ = paramStatus;
    zzaRI = paramLocationSettingsStates;
  }

  public int describeContents()
  {
    return 0;
  }

  public LocationSettingsStates getLocationSettingsStates()
  {
    return zzaRI;
  }

  public Status getStatus()
  {
    return zzOQ;
  }

  public int getVersionCode()
  {
    return mVersionCode;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzi.zza(this, paramParcel, paramInt);
  }
}
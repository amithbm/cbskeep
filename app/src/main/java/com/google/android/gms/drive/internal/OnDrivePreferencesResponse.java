package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DrivePreferences;

public class OnDrivePreferencesResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator<OnDrivePreferencesResponse> CREATOR = new zzay();
  final int mVersionCode;
  DrivePreferences zzavC;

  OnDrivePreferencesResponse(int paramInt, DrivePreferences paramDrivePreferences)
  {
    mVersionCode = paramInt;
    zzavC = paramDrivePreferences;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzay.zza(this, paramParcel, paramInt);
  }
}
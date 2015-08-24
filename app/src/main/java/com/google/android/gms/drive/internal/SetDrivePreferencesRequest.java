package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DrivePreferences;

public class SetDrivePreferencesRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<SetDrivePreferencesRequest> CREATOR = new zzbn();
  final int mVersionCode;
  final DrivePreferences zzavC;

  SetDrivePreferencesRequest(int paramInt, DrivePreferences paramDrivePreferences)
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
    zzbn.zza(this, paramParcel, paramInt);
  }
}
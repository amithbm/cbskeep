package com.google.android.gms.drive.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class DriveServiceResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator<DriveServiceResponse> CREATOR = new zzab();
  final int mVersionCode;
  final IBinder zzavD;

  DriveServiceResponse(int paramInt, IBinder paramIBinder)
  {
    mVersionCode = paramInt;
    zzavD = paramIBinder;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzab.zza(this, paramParcel, paramInt);
  }
}
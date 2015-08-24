package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class AuthorizeAccessRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<AuthorizeAccessRequest> CREATOR = new zzc();
  final int mVersionCode;
  final DriveId zzasr;
  final long zzatA;

  AuthorizeAccessRequest(int paramInt, long paramLong, DriveId paramDriveId)
  {
    mVersionCode = paramInt;
    zzatA = paramLong;
    zzasr = paramDriveId;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc.zza(this, paramParcel, paramInt);
  }
}
package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class GetMetadataRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<GetMetadataRequest> CREATOR = new zzah();
  final int mVersionCode;
  final DriveId zzatC;
  final boolean zzavP;

  GetMetadataRequest(int paramInt, DriveId paramDriveId, boolean paramBoolean)
  {
    mVersionCode = paramInt;
    zzatC = paramDriveId;
    zzavP = paramBoolean;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzah.zza(this, paramParcel, paramInt);
  }
}
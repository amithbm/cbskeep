package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class FetchThumbnailRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<FetchThumbnailRequest> CREATOR = new zzad();
  final int mVersionCode;
  final DriveId zzatC;

  FetchThumbnailRequest(int paramInt, DriveId paramDriveId)
  {
    mVersionCode = paramInt;
    zzatC = paramDriveId;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzad.zza(this, paramParcel, paramInt);
  }
}
package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class ListParentsRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<ListParentsRequest> CREATOR = new zzao();
  final int mVersionCode;
  final DriveId zzavQ;

  ListParentsRequest(int paramInt, DriveId paramDriveId)
  {
    mVersionCode = paramInt;
    zzavQ = paramDriveId;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzao.zza(this, paramParcel, paramInt);
  }
}
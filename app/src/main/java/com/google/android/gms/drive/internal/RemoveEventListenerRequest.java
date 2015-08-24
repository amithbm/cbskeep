package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class RemoveEventListenerRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<RemoveEventListenerRequest> CREATOR = new zzbl();
  final int mVersionCode;
  final int zzanC;
  final DriveId zzasr;

  RemoveEventListenerRequest(int paramInt1, DriveId paramDriveId, int paramInt2)
  {
    mVersionCode = paramInt1;
    zzasr = paramDriveId;
    zzanC = paramInt2;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzbl.zza(this, paramParcel, paramInt);
  }
}
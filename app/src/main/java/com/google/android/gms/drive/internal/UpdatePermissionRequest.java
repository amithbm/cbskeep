package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class UpdatePermissionRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<UpdatePermissionRequest> CREATOR = new zzbv();
  final int mVersionCode;
  final String zzasB;
  final String zzasN;
  final DriveId zzasr;
  final boolean zzatz;
  final int zzaws;

  UpdatePermissionRequest(int paramInt1, DriveId paramDriveId, String paramString1, int paramInt2, boolean paramBoolean, String paramString2)
  {
    mVersionCode = paramInt1;
    zzasr = paramDriveId;
    zzasN = paramString1;
    zzaws = paramInt2;
    zzatz = paramBoolean;
    zzasB = paramString2;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzbv.zza(this, paramParcel, paramInt);
  }
}
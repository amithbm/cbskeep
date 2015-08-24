package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.Permission;

public class AddPermissionRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<AddPermissionRequest> CREATOR = new zzb();
  final int mVersionCode;
  final String zzasB;
  final DriveId zzasr;
  final Permission zzatw;
  final boolean zzatx;
  final String zzaty;
  final boolean zzatz;

  AddPermissionRequest(int paramInt, DriveId paramDriveId, Permission paramPermission, boolean paramBoolean1, String paramString1, boolean paramBoolean2, String paramString2)
  {
    mVersionCode = paramInt;
    zzasr = paramDriveId;
    zzatw = paramPermission;
    zzatx = paramBoolean1;
    zzaty = paramString1;
    zzatz = paramBoolean2;
    zzasB = paramString2;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
}
package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class Contents
  implements SafeParcelable
{
  public static final Parcelable.Creator<Contents> CREATOR = new zzb();
  final int mVersionCode;
  final ParcelFileDescriptor zzajL;
  final int zzasp;
  final int zzasq;
  final DriveId zzasr;
  final boolean zzass;

  Contents(int paramInt1, ParcelFileDescriptor paramParcelFileDescriptor, int paramInt2, int paramInt3, DriveId paramDriveId, boolean paramBoolean)
  {
    mVersionCode = paramInt1;
    zzajL = paramParcelFileDescriptor;
    zzasp = paramInt2;
    zzasq = paramInt3;
    zzasr = paramDriveId;
    zzass = paramBoolean;
  }

  public int describeContents()
  {
    return 0;
  }

  public int getRequestId()
  {
    return zzasp;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
}
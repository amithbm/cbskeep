package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.query.internal.FilterHolder;

public class OpenFileIntentSenderRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<OpenFileIntentSenderRequest> CREATOR = new zzbj();
  final int mVersionCode;
  final String zzasJ;
  final String[] zzasK;
  final DriveId zzasM;
  final FilterHolder zzawo;

  OpenFileIntentSenderRequest(int paramInt, String paramString, String[] paramArrayOfString, DriveId paramDriveId, FilterHolder paramFilterHolder)
  {
    mVersionCode = paramInt;
    zzasJ = paramString;
    zzasK = paramArrayOfString;
    zzasM = paramDriveId;
    zzawo = paramFilterHolder;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzbj.zza(this, paramParcel, paramInt);
  }
}
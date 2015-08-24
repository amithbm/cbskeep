package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class CreateFileIntentSenderRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<CreateFileIntentSenderRequest> CREATOR = new zzk();
  final int mVersionCode;
  final String zzasJ;
  final DriveId zzasM;
  final int zzasp;
  final MetadataBundle zzatM;
  final Integer zzatN;

  CreateFileIntentSenderRequest(int paramInt1, MetadataBundle paramMetadataBundle, int paramInt2, String paramString, DriveId paramDriveId, Integer paramInteger)
  {
    mVersionCode = paramInt1;
    zzatM = paramMetadataBundle;
    zzasp = paramInt2;
    zzasJ = paramString;
    zzasM = paramDriveId;
    zzatN = paramInteger;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzk.zza(this, paramParcel, paramInt);
  }
}
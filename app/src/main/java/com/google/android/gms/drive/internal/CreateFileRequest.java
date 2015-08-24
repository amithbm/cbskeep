package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzv;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class CreateFileRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<CreateFileRequest> CREATOR = new zzl();
  final int mVersionCode;
  final String zzasB;
  final Contents zzatE;
  final MetadataBundle zzatM;
  final Integer zzatN;
  final DriveId zzatO;
  final int zzatP;
  final int zzatQ;
  final boolean zzatz;

  CreateFileRequest(int paramInt1, DriveId paramDriveId, MetadataBundle paramMetadataBundle, Contents paramContents, Integer paramInteger, boolean paramBoolean, String paramString, int paramInt2, int paramInt3)
  {
    if ((paramContents != null) && (paramInt3 != 0))
      if (paramContents.getRequestId() != paramInt3)
        break label67;
    label67: for (boolean bool = true; ; bool = false)
    {
      zzv.zzb(bool, "inconsistent contents reference");
      if (((paramInteger != null) && (paramInteger.intValue() != 0)) || (paramContents != null) || (paramInt3 != 0))
        break;
      throw new IllegalArgumentException("Need a valid contents");
    }
    mVersionCode = paramInt1;
    zzatO = ((DriveId)zzv.zzz(paramDriveId));
    zzatM = ((MetadataBundle)zzv.zzz(paramMetadataBundle));
    zzatE = paramContents;
    zzatN = paramInteger;
    zzasB = paramString;
    zzatP = paramInt2;
    zzatz = paramBoolean;
    zzatQ = paramInt3;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzl.zza(this, paramParcel, paramInt);
  }
}
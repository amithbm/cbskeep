package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class CloseContentsAndUpdateMetadataRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<CloseContentsAndUpdateMetadataRequest> CREATOR = new zzg();
  final int mVersionCode;
  final String zzasB;
  final boolean zzasC;
  final DriveId zzatC;
  final MetadataBundle zzatD;
  final Contents zzatE;
  final int zzatF;
  final int zzatG;
  final boolean zzatH;

  CloseContentsAndUpdateMetadataRequest(int paramInt1, DriveId paramDriveId, MetadataBundle paramMetadataBundle, Contents paramContents, boolean paramBoolean1, String paramString, int paramInt2, int paramInt3, boolean paramBoolean2)
  {
    mVersionCode = paramInt1;
    zzatC = paramDriveId;
    zzatD = paramMetadataBundle;
    zzatE = paramContents;
    zzasC = paramBoolean1;
    zzasB = paramString;
    zzatF = paramInt2;
    zzatG = paramInt3;
    zzatH = paramBoolean2;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzg.zza(this, paramParcel, paramInt);
  }
}
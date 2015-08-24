package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.ChangeSequenceNumber;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.WriteAwareParcelable;
import java.util.List;

public class OnChangesResponse extends WriteAwareParcelable
  implements SafeParcelable
{
  public static final Parcelable.Creator<OnChangesResponse> CREATOR = new zzat();
  final int mVersionCode;
  final List<DriveId> zzaug;
  final ChangeSequenceNumber zzauh;
  final boolean zzaui;
  final DataHolder zzawa;

  OnChangesResponse(int paramInt, DataHolder paramDataHolder, List<DriveId> paramList, ChangeSequenceNumber paramChangeSequenceNumber, boolean paramBoolean)
  {
    mVersionCode = paramInt;
    zzawa = paramDataHolder;
    zzaug = paramList;
    zzauh = paramChangeSequenceNumber;
    zzaui = paramBoolean;
  }

  public int describeContents()
  {
    return 0;
  }

  protected void zzK(Parcel paramParcel, int paramInt)
  {
    zzat.zza(this, paramParcel, paramInt | 0x1);
  }
}
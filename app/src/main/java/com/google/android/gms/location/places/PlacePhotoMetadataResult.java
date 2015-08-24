package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class PlacePhotoMetadataResult
  implements Result, SafeParcelable
{
  public static final Parcelable.Creator<PlacePhotoMetadataResult> CREATOR = new zzg();
  final int mVersionCode;
  private final Status zzOQ;
  final DataHolder zzaUt;
  private final PlacePhotoMetadataBuffer zzaUu;

  PlacePhotoMetadataResult(int paramInt, Status paramStatus, DataHolder paramDataHolder)
  {
    mVersionCode = paramInt;
    zzOQ = paramStatus;
    zzaUt = paramDataHolder;
    if (paramDataHolder == null)
    {
      zzaUu = null;
      return;
    }
    zzaUu = new PlacePhotoMetadataBuffer(zzaUt);
  }

  public int describeContents()
  {
    return 0;
  }

  public Status getStatus()
  {
    return zzOQ;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzg.zza(this, paramParcel, paramInt);
  }
}
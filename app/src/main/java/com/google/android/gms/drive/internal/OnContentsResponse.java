package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;

public class OnContentsResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator<OnContentsResponse> CREATOR = new zzau();
  final int mVersionCode;
  final Contents zzauA;
  final boolean zzawb;

  OnContentsResponse(int paramInt, Contents paramContents, boolean paramBoolean)
  {
    mVersionCode = paramInt;
    zzauA = paramContents;
    zzawb = paramBoolean;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzau.zza(this, paramParcel, paramInt);
  }
}
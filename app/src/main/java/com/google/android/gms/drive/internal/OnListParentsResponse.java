package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.WriteAwareParcelable;

public class OnListParentsResponse extends WriteAwareParcelable
  implements SafeParcelable
{
  public static final Parcelable.Creator<OnListParentsResponse> CREATOR = new zzbc();
  final int mVersionCode;
  final DataHolder zzawl;

  OnListParentsResponse(int paramInt, DataHolder paramDataHolder)
  {
    mVersionCode = paramInt;
    zzawl = paramDataHolder;
  }

  public int describeContents()
  {
    return 0;
  }

  protected void zzK(Parcel paramParcel, int paramInt)
  {
    zzbc.zza(this, paramParcel, paramInt);
  }
}
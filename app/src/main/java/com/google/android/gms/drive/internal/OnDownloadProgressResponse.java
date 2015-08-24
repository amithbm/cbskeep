package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class OnDownloadProgressResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator<OnDownloadProgressResponse> CREATOR = new zzaw();
  final int mVersionCode;
  final long zzawd;
  final long zzawe;

  OnDownloadProgressResponse(int paramInt, long paramLong1, long paramLong2)
  {
    mVersionCode = paramInt;
    zzawd = paramLong1;
    zzawe = paramLong2;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzaw.zza(this, paramParcel, paramInt);
  }
}
package com.google.android.gms.auth;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class RecoveryWriteResponse
  implements SafeParcelable
{
  public static final zzh CREATOR = new zzh();
  public String mErrorCode;
  final int mVersionCode;

  public RecoveryWriteResponse()
  {
    mVersionCode = 1;
  }

  RecoveryWriteResponse(int paramInt, String paramString)
  {
    mVersionCode = paramInt;
    mErrorCode = paramString;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzh.zza(this, paramParcel, paramInt);
  }
}
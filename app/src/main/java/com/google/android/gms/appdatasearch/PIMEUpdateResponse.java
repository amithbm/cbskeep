package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class PIMEUpdateResponse
  implements SafeParcelable
{
  public static final zzr CREATOR = new zzr();
  final String mErrorMessage;
  final int mVersionCode;
  public final byte[] nextIterToken;
  public final PIMEUpdate[] updates;

  PIMEUpdateResponse(int paramInt, String paramString, byte[] paramArrayOfByte, PIMEUpdate[] paramArrayOfPIMEUpdate)
  {
    mVersionCode = paramInt;
    mErrorMessage = paramString;
    nextIterToken = paramArrayOfByte;
    updates = paramArrayOfPIMEUpdate;
  }

  public int describeContents()
  {
    zzr localzzr = CREATOR;
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzr localzzr = CREATOR;
    zzr.zza(this, paramParcel, paramInt);
  }
}
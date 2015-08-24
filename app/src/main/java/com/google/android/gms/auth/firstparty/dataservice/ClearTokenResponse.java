package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ClearTokenResponse
  implements SafeParcelable
{
  public static final zzq CREATOR = new zzq();
  final int version;
  final String zzRY;

  ClearTokenResponse(int paramInt, String paramString)
  {
    version = paramInt;
    zzRY = paramString;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzq.zza(this, paramParcel, paramInt);
  }
}
package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ClearTokenRequest
  implements SafeParcelable
{
  public static final zzp CREATOR = new zzp();
  final int version;
  String zzSt;

  public ClearTokenRequest()
  {
    version = 1;
  }

  ClearTokenRequest(int paramInt, String paramString)
  {
    version = paramInt;
    zzSt = paramString;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzp.zza(this, paramParcel, paramInt);
  }
}
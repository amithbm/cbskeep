package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class CheckRealNameResponse
  implements SafeParcelable
{
  public static final zzo CREATOR = new zzo();
  final int version;
  String zzRY;

  CheckRealNameResponse(int paramInt, String paramString)
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
    zzo.zza(this, paramParcel, paramInt);
  }
}
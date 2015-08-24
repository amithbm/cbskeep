package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class OtpResponse
  implements SafeParcelable
{
  public static final zzz CREATOR = new zzz();
  final int mVersion;
  public final String otp;

  OtpResponse(int paramInt, String paramString)
  {
    mVersion = paramInt;
    otp = paramString;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzz.zza(this, paramParcel, paramInt);
  }
}
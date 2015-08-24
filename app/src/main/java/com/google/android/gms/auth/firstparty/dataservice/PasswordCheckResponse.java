package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class PasswordCheckResponse
  implements SafeParcelable
{
  public static final zzab CREATOR = new zzab();
  String status;
  final int version;
  String zzSa;
  String zzTi;

  PasswordCheckResponse(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    version = paramInt;
    status = paramString1;
    zzTi = paramString2;
    zzSa = paramString3;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzab.zza(this, paramParcel, paramInt);
  }
}
package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Parcel;
import com.google.android.gms.auth.firstparty.shared.AppDescription;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class PasswordCheckRequest
  implements SafeParcelable
{
  public static final zzaa CREATOR = new zzaa();
  String accountName;
  String password;
  final int version;
  String zzRU;
  String zzRV;
  AppDescription zzTh;

  PasswordCheckRequest(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, AppDescription paramAppDescription)
  {
    version = paramInt;
    accountName = paramString1;
    password = paramString2;
    zzRU = paramString3;
    zzRV = paramString4;
    zzTh = paramAppDescription;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzaa.zza(this, paramParcel, paramInt);
  }
}
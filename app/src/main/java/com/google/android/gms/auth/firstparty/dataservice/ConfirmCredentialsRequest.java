package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Parcel;
import com.google.android.gms.auth.firstparty.shared.AccountCredentials;
import com.google.android.gms.auth.firstparty.shared.CaptchaSolution;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ConfirmCredentialsRequest
  implements SafeParcelable
{
  public static final zzr CREATOR = new zzr();
  final int version;
  CaptchaSolution zzRW;
  AccountCredentials zzSs;

  public ConfirmCredentialsRequest()
  {
    version = 1;
  }

  ConfirmCredentialsRequest(int paramInt, AccountCredentials paramAccountCredentials, CaptchaSolution paramCaptchaSolution)
  {
    version = paramInt;
    zzSs = paramAccountCredentials;
    zzRW = paramCaptchaSolution;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzr.zza(this, paramParcel, paramInt);
  }
}
package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Parcel;
import com.google.android.gms.auth.firstparty.shared.AccountCredentials;
import com.google.android.gms.auth.firstparty.shared.AppDescription;
import com.google.android.gms.auth.firstparty.shared.CaptchaSolution;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class AccountSignInRequest
  implements SafeParcelable
{
  public static final zzk CREATOR = new zzk();
  AppDescription callingAppDescription;
  final int version;
  CaptchaSolution zzRW;
  boolean zzSq;
  boolean zzSr;
  AccountCredentials zzSs;

  public AccountSignInRequest()
  {
    version = 1;
  }

  AccountSignInRequest(int paramInt, AppDescription paramAppDescription, boolean paramBoolean1, boolean paramBoolean2, CaptchaSolution paramCaptchaSolution, AccountCredentials paramAccountCredentials)
  {
    version = paramInt;
    callingAppDescription = paramAppDescription;
    zzSq = paramBoolean1;
    zzSr = paramBoolean2;
    zzRW = paramCaptchaSolution;
    zzSs = paramAccountCredentials;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzk.zza(this, paramParcel, paramInt);
  }
}
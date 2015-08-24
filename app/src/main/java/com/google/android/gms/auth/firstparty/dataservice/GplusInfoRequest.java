package com.google.android.gms.auth.firstparty.dataservice;

import android.accounts.Account;
import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.auth.firstparty.shared.CaptchaSolution;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class GplusInfoRequest
  implements SafeParcelable
{
  public static final zzv CREATOR = new zzv();
  Account account;
  String accountName;
  final int version;
  CaptchaSolution zzRW;

  public GplusInfoRequest()
  {
    version = 2;
  }

  GplusInfoRequest(int paramInt, String paramString, CaptchaSolution paramCaptchaSolution, Account paramAccount)
  {
    version = paramInt;
    accountName = paramString;
    zzRW = paramCaptchaSolution;
    if ((paramAccount == null) && (!TextUtils.isEmpty(paramString)))
    {
      account = new Account(paramString, "com.google");
      return;
    }
    account = paramAccount;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzv.zza(this, paramParcel, paramInt);
  }
}
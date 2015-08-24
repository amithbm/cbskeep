package com.google.android.gms.auth.firstparty.dataservice;

import android.accounts.Account;
import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.auth.firstparty.shared.AppDescription;
import com.google.android.gms.auth.firstparty.shared.CaptchaSolution;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class AccountNameCheckRequest
  implements SafeParcelable
{
  public static final zza CREATOR = new zza();
  AppDescription callingAppDescription;
  final int version;

  @Deprecated
  String zzRT;
  String zzRU;
  String zzRV;
  CaptchaSolution zzRW;
  Account zzRX;

  public AccountNameCheckRequest()
  {
    version = 2;
  }

  AccountNameCheckRequest(int paramInt, String paramString1, String paramString2, String paramString3, AppDescription paramAppDescription, CaptchaSolution paramCaptchaSolution, Account paramAccount)
  {
    version = paramInt;
    zzRT = paramString1;
    zzRU = paramString2;
    zzRV = paramString3;
    callingAppDescription = paramAppDescription;
    zzRW = paramCaptchaSolution;
    if ((paramAccount == null) && (!TextUtils.isEmpty(paramString1)))
    {
      zzRX = new Account(paramString1, "com.google");
      return;
    }
    zzRX = paramAccount;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
}
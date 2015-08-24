package com.google.android.gms.auth.firstparty.dataservice;

import android.accounts.Account;
import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class VerifyPinRequest
  implements SafeParcelable
{
  public static final zzal CREATOR = new zzal();
  public final Account account;

  @Deprecated
  public final String accountName;
  public String callingPackageName;
  public final String pin;
  final int version;

  VerifyPinRequest(int paramInt, String paramString1, String paramString2, Account paramAccount, String paramString3)
  {
    version = paramInt;
    accountName = paramString1;
    pin = paramString2;
    if ((paramAccount == null) && (!TextUtils.isEmpty(paramString1)));
    for (account = new Account(paramString1, "com.google"); ; account = paramAccount)
    {
      callingPackageName = paramString3;
      return;
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzal.zza(this, paramParcel, paramInt);
  }
}
package com.google.android.gms.auth.firstparty.dataservice;

import android.accounts.Account;
import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class AccountRecoveryGuidanceRequest
  implements SafeParcelable
{
  public static final zzf CREATOR = new zzf();
  public final Account account;

  @Deprecated
  public final String accountName;
  final int version;

  AccountRecoveryGuidanceRequest(int paramInt, String paramString, Account paramAccount)
  {
    version = paramInt;
    accountName = paramString;
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
    zzf.zza(this, paramParcel, paramInt);
  }
}
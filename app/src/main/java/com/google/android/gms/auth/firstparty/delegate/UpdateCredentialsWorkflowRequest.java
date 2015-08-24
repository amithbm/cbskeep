package com.google.android.gms.auth.firstparty.delegate;

import android.accounts.Account;
import android.accounts.AccountAuthenticatorResponse;
import android.os.Bundle;
import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.auth.firstparty.shared.AppDescription;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class UpdateCredentialsWorkflowRequest
  implements SafeParcelable
{
  public static final zze CREATOR = new zze();
  Account account;

  @Deprecated
  String accountName;
  AccountAuthenticatorResponse amResponse;
  AppDescription callingAppDescription;
  Bundle options;
  final int version;

  public UpdateCredentialsWorkflowRequest()
  {
    version = 3;
    options = new Bundle();
  }

  UpdateCredentialsWorkflowRequest(int paramInt, String paramString, AppDescription paramAppDescription, Bundle paramBundle, Account paramAccount, AccountAuthenticatorResponse paramAccountAuthenticatorResponse)
  {
    version = paramInt;
    accountName = paramString;
    callingAppDescription = paramAppDescription;
    options = paramBundle;
    if ((paramAccount == null) && (!TextUtils.isEmpty(paramString)));
    for (account = new Account(paramString, "com.google"); ; account = paramAccount)
    {
      amResponse = paramAccountAuthenticatorResponse;
      return;
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zze.zza(this, paramParcel, paramInt);
  }
}
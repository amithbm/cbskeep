package com.google.android.gms.auth.firstparty.delegate;

import android.accounts.Account;
import android.accounts.AccountAuthenticatorResponse;
import android.os.Bundle;
import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.auth.firstparty.shared.AppDescription;
import com.google.android.gms.auth.firstparty.shared.FACLConfig;
import com.google.android.gms.auth.firstparty.shared.PACLConfig;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class TokenWorkflowRequest
  implements SafeParcelable
{
  public static final zzd CREATOR = new zzd();
  Account account;

  @Deprecated
  String accountName;
  AccountAuthenticatorResponse amResponse;
  AppDescription callingAppDescription;
  Bundle options;
  final int version;
  boolean zzTG;
  String zzTj;
  FACLConfig zzTk;
  PACLConfig zzTl;

  public TokenWorkflowRequest()
  {
    version = 2;
    options = new Bundle();
  }

  TokenWorkflowRequest(int paramInt, String paramString1, String paramString2, Bundle paramBundle, FACLConfig paramFACLConfig, PACLConfig paramPACLConfig, boolean paramBoolean, AppDescription paramAppDescription, Account paramAccount, AccountAuthenticatorResponse paramAccountAuthenticatorResponse)
  {
    version = paramInt;
    zzTj = paramString1;
    accountName = paramString2;
    options = paramBundle;
    zzTk = paramFACLConfig;
    zzTl = paramPACLConfig;
    zzTG = paramBoolean;
    callingAppDescription = paramAppDescription;
    if ((paramAccount == null) && (!TextUtils.isEmpty(paramString2)));
    for (account = new Account(paramString2, "com.google"); ; account = paramAccount)
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
    zzd.zza(this, paramParcel, paramInt);
  }
}
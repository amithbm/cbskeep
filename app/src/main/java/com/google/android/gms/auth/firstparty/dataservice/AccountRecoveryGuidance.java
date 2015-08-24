package com.google.android.gms.auth.firstparty.dataservice;

import android.accounts.Account;
import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class AccountRecoveryGuidance
  implements SafeParcelable
{
  public static final zze CREATOR = new zze();
  public final Account account;

  @Deprecated
  public final String accountName;
  public final boolean isRecoveryInfoNeeded;
  public final boolean isRecoveryInterstitialSuggested;
  public final boolean isRecoveryUpdateAllowed;
  final int version;

  AccountRecoveryGuidance(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, Account paramAccount)
  {
    version = paramInt;
    accountName = paramString;
    isRecoveryInfoNeeded = paramBoolean1;
    isRecoveryInterstitialSuggested = paramBoolean2;
    isRecoveryUpdateAllowed = paramBoolean3;
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
    zze.zza(this, paramParcel, paramInt);
  }
}
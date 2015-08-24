package com.google.android.gms.auth.firstparty.dataservice;

import android.accounts.Account;
import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.auth.firstparty.shared.AppDescription;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class AccountRecoveryUpdateRequest
  implements SafeParcelable
{
  public static final zzg CREATOR = new zzg();
  public final Account account;
  public final String accountName;
  public final AppDescription callingAppDescription;
  public final boolean isBroadUse;
  public final String phoneCountryCode;
  public final String phoneNumber;
  public final String secondaryEmail;
  final int version;

  AccountRecoveryUpdateRequest(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, AppDescription paramAppDescription, Account paramAccount)
  {
    version = paramInt;
    accountName = paramString1;
    secondaryEmail = paramString2;
    phoneNumber = paramString3;
    phoneCountryCode = paramString4;
    isBroadUse = paramBoolean;
    callingAppDescription = paramAppDescription;
    if ((paramAccount == null) && (!TextUtils.isEmpty(paramString1)))
    {
      account = new Account(paramString1, "com.google");
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
    zzg.zza(this, paramParcel, paramInt);
  }
}
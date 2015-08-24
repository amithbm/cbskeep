package com.google.android.gms.auth.firstparty.dataservice;

import android.accounts.Account;
import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.auth.firstparty.shared.AppDescription;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzv;

public class AccountRecoveryDataRequest
  implements SafeParcelable
{
  public static final zzd CREATOR = new zzd();
  private static final String zzSm = "[" + AccountRecoveryDataRequest.class.getSimpleName() + "]";
  public final Account account;

  @Deprecated
  public final String accountName;
  public final AppDescription callingAppDescription;
  public final boolean isClearUpdateSuggested;
  public final String requestDescription;
  final int version;

  AccountRecoveryDataRequest(int paramInt, String paramString1, boolean paramBoolean, AppDescription paramAppDescription, String paramString2, Account paramAccount)
  {
    accountName = zzv.zzd(paramString1, zzSm + " accountName cannot be empty or null!");
    zzv.zzd(paramString2, zzSm + " requestDescription cannot be empty or null!");
    version = paramInt;
    isClearUpdateSuggested = paramBoolean;
    callingAppDescription = ((AppDescription)zzv.zzz(paramAppDescription));
    requestDescription = paramString2;
    if ((paramAccount == null) && (!TextUtils.isEmpty(paramString1)));
    for (account = new Account(paramString1, "com.google"); ; account = paramAccount)
    {
      zzv.zzz(account);
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
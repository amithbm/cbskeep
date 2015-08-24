package com.google.android.gms.auth.firstparty.dataservice;

import android.accounts.Account;
import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.auth.Country;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.List;

public class AccountRecoveryData
  implements SafeParcelable
{
  public static final zzc CREATOR = new zzc();
  public final Account account;

  @Deprecated
  public final String accountName;
  public final String action;
  public final String allowedRecoveryOption;
  public final List<Country> countries;
  public final String defaultCountryCode;
  public final String error;
  public final AccountRecoveryGuidance guidance;
  public final String phoneNumber;
  public final String secondaryEmail;
  public final int version;

  AccountRecoveryData(int paramInt, AccountRecoveryGuidance paramAccountRecoveryGuidance, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, List<Country> paramList, String paramString6, String paramString7, Account paramAccount)
  {
    version = paramInt;
    guidance = paramAccountRecoveryGuidance;
    action = paramString1;
    allowedRecoveryOption = paramString2;
    accountName = paramString3;
    secondaryEmail = paramString4;
    phoneNumber = paramString5;
    if (paramList == null);
    for (paramAccountRecoveryGuidance = Collections.EMPTY_LIST; ; paramAccountRecoveryGuidance = Collections.unmodifiableList(paramList))
    {
      countries = paramAccountRecoveryGuidance;
      defaultCountryCode = paramString6;
      error = paramString7;
      if ((paramAccount != null) || (TextUtils.isEmpty(paramString3)))
        break;
      account = new Account(paramString3, "com.google");
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
    zzc.zza(this, paramParcel, paramInt);
  }
}
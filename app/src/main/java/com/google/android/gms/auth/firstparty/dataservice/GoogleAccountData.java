package com.google.android.gms.auth.firstparty.dataservice;

import android.accounts.Account;
import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class GoogleAccountData
  implements SafeParcelable
{
  public static final zzt CREATOR = new zzt();
  public Account account;

  @Deprecated
  String accountName;
  public String firstName;
  public String lastName;
  public List<String> services;
  final int version;
  boolean zzSu;

  GoogleAccountData(int paramInt, String paramString1, boolean paramBoolean, List<String> paramList, String paramString2, String paramString3, Account paramAccount)
  {
    version = paramInt;
    accountName = paramString1;
    zzSu = paramBoolean;
    services = paramList;
    firstName = paramString2;
    lastName = paramString3;
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
    zzt.zza(this, paramParcel, paramInt);
  }
}
package com.google.android.gms.auth.firstparty.dataservice;

import android.accounts.Account;
import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ReauthSettingsRequest
  implements SafeParcelable
{
  public static final zzaf CREATOR = new zzaf();
  public final Account account;

  @Deprecated
  public final String accountName;
  public String callingPackageName;
  public final boolean force;
  final int version;

  ReauthSettingsRequest(int paramInt, String paramString1, boolean paramBoolean, Account paramAccount, String paramString2)
  {
    version = paramInt;
    accountName = paramString1;
    force = paramBoolean;
    if ((paramAccount == null) && (!TextUtils.isEmpty(paramString1)));
    for (account = new Account(paramString1, "com.google"); ; account = paramAccount)
    {
      callingPackageName = paramString2;
      return;
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzaf.zza(this, paramParcel, paramInt);
  }
}
package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ResolveAccountRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<ResolveAccountRequest> CREATOR = new zzw();
  final int mVersionCode;
  private final Account zzMF;
  private final int zzamg;

  ResolveAccountRequest(int paramInt1, Account paramAccount, int paramInt2)
  {
    mVersionCode = paramInt1;
    zzMF = paramAccount;
    zzamg = paramInt2;
  }

  public ResolveAccountRequest(Account paramAccount, int paramInt)
  {
    this(1, paramAccount, paramInt);
  }

  public int describeContents()
  {
    return 0;
  }

  public Account getAccount()
  {
    return zzMF;
  }

  public int getSessionId()
  {
    return zzamg;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzw.zza(this, paramParcel, paramInt);
  }
}
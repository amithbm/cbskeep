package com.google.android.gms.appdatasearch;

import android.accounts.Account;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class PIMEUpdate
  implements SafeParcelable
{
  public static final zzq CREATOR = new zzq();
  public final Account account;
  public final long createdTimestamp;
  public final boolean inputByUser;
  final int mVersionCode;
  public final long score;
  public final int sourceClass;
  public final String sourceCorpusHandle;
  public final String sourcePackageName;
  final byte[] zzNm;
  final byte[] zzNn;
  final Bundle zzNo;

  PIMEUpdate(int paramInt1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt2, String paramString1, String paramString2, boolean paramBoolean, Bundle paramBundle, long paramLong1, long paramLong2, Account paramAccount)
  {
    mVersionCode = paramInt1;
    zzNm = paramArrayOfByte1;
    zzNn = paramArrayOfByte2;
    sourceClass = paramInt2;
    sourcePackageName = paramString1;
    sourceCorpusHandle = paramString2;
    inputByUser = paramBoolean;
    zzNo = paramBundle;
    score = paramLong1;
    createdTimestamp = paramLong2;
    account = paramAccount;
  }

  public int describeContents()
  {
    zzq localzzq = CREATOR;
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzq localzzq = CREATOR;
    zzq.zza(this, paramParcel, paramInt);
  }
}
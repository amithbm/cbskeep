package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class AccountRecoveryUpdateResult
  implements SafeParcelable
{
  public static final zzh CREATOR = new zzh();
  public final String error;
  final int version;

  AccountRecoveryUpdateResult(int paramInt, String paramString)
  {
    version = paramInt;
    error = paramString;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzh.zza(this, paramParcel, paramInt);
  }
}
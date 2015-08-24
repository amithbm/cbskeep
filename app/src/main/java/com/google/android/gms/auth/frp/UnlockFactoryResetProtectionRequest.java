package com.google.android.gms.auth.frp;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class UnlockFactoryResetProtectionRequest
  implements SafeParcelable
{
  public static final zzb CREATOR = new zzb();
  public final String accountName;
  public final String accountType;
  public final String password;
  final int version;

  UnlockFactoryResetProtectionRequest(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    version = paramInt;
    accountName = paramString1;
    password = paramString2;
    accountType = paramString3;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
}
package com.google.android.gms.people.identity.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class AccountToken
  implements SafeParcelable
{
  public static final zza CREATOR = new zza();
  private final int mVersionCode;
  private final String zzQt;
  private final String zzbcc;

  AccountToken(int paramInt, String paramString1, String paramString2)
  {
    mVersionCode = paramInt;
    zzQt = paramString1;
    zzbcc = paramString2;
  }

  public int describeContents()
  {
    return 0;
  }

  public String getAccountName()
  {
    return zzQt;
  }

  public int getVersionCode()
  {
    return mVersionCode;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }

  public String zzAz()
  {
    return zzbcc;
  }
}
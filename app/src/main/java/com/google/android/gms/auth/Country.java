package com.google.android.gms.auth;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class Country
  implements SafeParcelable
{
  public static final zzd CREATOR = new zzd();
  public String mCode;
  public String mName;
  final int mVersionCode;

  public Country()
  {
    mVersionCode = 1;
  }

  Country(int paramInt, String paramString1, String paramString2)
  {
    mVersionCode = paramInt;
    mName = paramString1;
    mCode = paramString2;
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
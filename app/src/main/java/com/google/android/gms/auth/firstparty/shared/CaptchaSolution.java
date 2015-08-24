package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class CaptchaSolution
  implements SafeParcelable
{
  public static final zzd CREATOR = new zzd();
  final int version;
  String zzSt;
  String zzTZ;

  CaptchaSolution(int paramInt, String paramString1, String paramString2)
  {
    version = paramInt;
    zzSt = paramString1;
    zzTZ = paramString2;
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
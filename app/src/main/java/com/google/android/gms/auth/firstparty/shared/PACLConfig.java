package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class PACLConfig
  implements SafeParcelable
{
  public static final zzh CREATOR = new zzh();
  final int version;
  String zzUl;
  String zzUm;

  PACLConfig(int paramInt, String paramString1, String paramString2)
  {
    version = paramInt;
    zzUl = paramString1;
    zzUm = paramString2;
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
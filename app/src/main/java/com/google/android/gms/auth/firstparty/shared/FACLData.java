package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class FACLData
  implements SafeParcelable
{
  public static final zzf CREATOR = new zzf();
  final int version;
  FACLConfig zzUg;
  String zzUh;
  boolean zzUi;
  String zzUj;

  FACLData(int paramInt, FACLConfig paramFACLConfig, String paramString1, boolean paramBoolean, String paramString2)
  {
    version = paramInt;
    zzUg = paramFACLConfig;
    zzUh = paramString1;
    zzUi = paramBoolean;
    zzUj = paramString2;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzf.zza(this, paramParcel, paramInt);
  }
}
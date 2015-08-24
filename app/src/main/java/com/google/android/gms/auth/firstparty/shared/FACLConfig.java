package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class FACLConfig
  implements SafeParcelable
{
  public static final zze CREATOR = new zze();
  private static final String zzSm = "[" + FACLConfig.class.getSimpleName() + "]";
  final int version;
  boolean zzUa;
  String zzUb;
  boolean zzUc;
  boolean zzUd;
  boolean zzUe;
  boolean zzUf;

  FACLConfig(int paramInt, boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    version = paramInt;
    zzUa = paramBoolean1;
    zzUb = paramString;
    zzUc = paramBoolean2;
    zzUd = paramBoolean3;
    zzUe = paramBoolean4;
    zzUf = paramBoolean5;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zze.zza(this, paramParcel, paramInt);
  }
}
package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class GplusInfoResponse
  implements SafeParcelable
{
  public static final zzw CREATOR = new zzw();
  String firstName;
  String lastName;
  final int version;
  String zzTa;
  boolean zzTb;
  String zzTc;
  boolean zzTd;
  boolean zzTe;
  String zzTf;
  String zzTg;

  GplusInfoResponse(int paramInt, boolean paramBoolean1, String paramString1, String paramString2, String paramString3, boolean paramBoolean2, boolean paramBoolean3, String paramString4, String paramString5, String paramString6)
  {
    version = paramInt;
    zzTb = paramBoolean1;
    firstName = paramString1;
    lastName = paramString2;
    zzTc = paramString3;
    zzTd = paramBoolean2;
    zzTe = paramBoolean3;
    zzTf = paramString4;
    zzTa = paramString5;
    zzTg = paramString6;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzw.zza(this, paramParcel, paramInt);
  }
}
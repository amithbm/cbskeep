package com.google.android.gms.googlehelp.internal.common;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class TogglingData
  implements SafeParcelable
{
  public static final Parcelable.Creator<TogglingData> CREATOR = new zzk();
  final int mVersionCode;
  String zzaOT;
  String zzaOU;
  String zzaOb;

  private TogglingData()
  {
    mVersionCode = 1;
  }

  TogglingData(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    mVersionCode = paramInt;
    zzaOb = paramString1;
    zzaOT = paramString2;
    zzaOU = paramString3;
  }

  public int describeContents()
  {
    return 0;
  }

  public TogglingData setPipTitle(String paramString)
  {
    zzaOU = paramString;
    return this;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzk.zza(this, paramParcel, paramInt);
  }
}
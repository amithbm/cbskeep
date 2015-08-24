package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class UserMetadata
  implements SafeParcelable
{
  public static final Parcelable.Creator<UserMetadata> CREATOR = new zzh();
  final int mVersionCode;
  final String zzPa;
  final String zzasV;
  final String zzasW;
  final boolean zzasX;
  final String zzasY;

  UserMetadata(int paramInt, String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4)
  {
    mVersionCode = paramInt;
    zzasV = paramString1;
    zzPa = paramString2;
    zzasW = paramString3;
    zzasX = paramBoolean;
    zzasY = paramString4;
  }

  public int describeContents()
  {
    return 0;
  }

  public String toString()
  {
    return String.format("Permission ID: '%s', Display Name: '%s', Picture URL: '%s', Authenticated User: %b, Email: '%s'", new Object[] { zzasV, zzPa, zzasW, Boolean.valueOf(zzasX), zzasY });
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzh.zza(this, paramParcel, paramInt);
  }
}
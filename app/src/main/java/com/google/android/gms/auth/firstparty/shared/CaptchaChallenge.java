package com.google.android.gms.auth.firstparty.shared;

import android.graphics.Bitmap;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class CaptchaChallenge
  implements SafeParcelable
{
  public static final zzc CREATOR = new zzc();
  final int version;
  String zzRY;
  String zzSt;
  Bitmap zzTY;

  CaptchaChallenge(int paramInt, String paramString1, String paramString2, Bitmap paramBitmap)
  {
    version = paramInt;
    zzRY = paramString1;
    zzSt = paramString2;
    zzTY = paramBitmap;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc.zza(this, paramParcel, paramInt);
  }
}
package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class PinSettings
  implements SafeParcelable
{
  public static final zzad CREATOR = new zzad();
  public final int length;
  public final String recoveryUrl;
  public final String resetUrl;
  public final String setupUrl;
  public final String status;
  final int version;

  PinSettings(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2)
  {
    version = paramInt1;
    status = paramString1;
    resetUrl = paramString2;
    setupUrl = paramString3;
    recoveryUrl = paramString4;
    length = paramInt2;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzad.zza(this, paramParcel, paramInt);
  }
}
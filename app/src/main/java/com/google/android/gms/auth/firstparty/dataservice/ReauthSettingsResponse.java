package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ReauthSettingsResponse
  implements SafeParcelable
{
  public static final zzag CREATOR = new zzag();
  public final PasswordSettings password;
  public final PinSettings pin;
  public final int status;
  final int version;

  ReauthSettingsResponse(int paramInt1, int paramInt2, PasswordSettings paramPasswordSettings, PinSettings paramPinSettings)
  {
    version = paramInt1;
    status = paramInt2;
    password = paramPasswordSettings;
    pin = paramPinSettings;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzag.zza(this, paramParcel, paramInt);
  }
}
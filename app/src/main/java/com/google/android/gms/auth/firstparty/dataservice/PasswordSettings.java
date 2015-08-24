package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class PasswordSettings
  implements SafeParcelable
{
  public static final zzac CREATOR = new zzac();
  public final String status;
  final int version;

  PasswordSettings(int paramInt, String paramString)
  {
    version = paramInt;
    status = paramString;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzac.zza(this, paramParcel, paramInt);
  }
}
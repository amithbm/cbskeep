package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class WebSetupConfig
  implements SafeParcelable
{
  public static final zzan CREATOR = new zzan();
  public final String url;
  final int version;

  WebSetupConfig(int paramInt, String paramString)
  {
    version = paramInt;
    url = paramString;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzan.zza(this, paramParcel, paramInt);
  }
}
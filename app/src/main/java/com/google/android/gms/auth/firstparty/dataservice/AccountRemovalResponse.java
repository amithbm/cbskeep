package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class AccountRemovalResponse
  implements SafeParcelable
{
  public static final zzj CREATOR = new zzj();
  final int version;
  final String zzRY;

  AccountRemovalResponse(int paramInt, String paramString)
  {
    version = paramInt;
    zzRY = paramString;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzj.zza(this, paramParcel, paramInt);
  }
}
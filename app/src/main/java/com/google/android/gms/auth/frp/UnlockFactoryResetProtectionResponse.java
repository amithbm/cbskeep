package com.google.android.gms.auth.frp;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class UnlockFactoryResetProtectionResponse
  implements SafeParcelable
{
  public static final zzc CREATOR = new zzc();
  public final int status;
  final int version;

  UnlockFactoryResetProtectionResponse(int paramInt1, int paramInt2)
  {
    version = paramInt1;
    status = paramInt2;
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
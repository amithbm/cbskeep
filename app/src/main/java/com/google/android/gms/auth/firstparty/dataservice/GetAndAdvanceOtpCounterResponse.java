package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class GetAndAdvanceOtpCounterResponse
  implements SafeParcelable
{
  public static final zzs CREATOR = new zzs();
  public final Long counter;
  final int mVersion;

  GetAndAdvanceOtpCounterResponse(int paramInt, Long paramLong)
  {
    mVersion = paramInt;
    counter = paramLong;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzs.zza(this, paramParcel, paramInt);
  }
}
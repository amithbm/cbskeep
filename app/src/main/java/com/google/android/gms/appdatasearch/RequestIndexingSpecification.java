package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class RequestIndexingSpecification
  implements SafeParcelable
{
  public static final zzaa CREATOR = new zzaa();
  final int mVersionCode;

  RequestIndexingSpecification(int paramInt)
  {
    mVersionCode = paramInt;
  }

  public int describeContents()
  {
    zzaa localzzaa = CREATOR;
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzaa localzzaa = CREATOR;
    zzaa.zza(this, paramParcel, paramInt);
  }
}
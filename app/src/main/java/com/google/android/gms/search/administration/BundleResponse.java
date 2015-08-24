package com.google.android.gms.search.administration;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class BundleResponse
  implements Result, SafeParcelable
{
  public static final zza CREATOR = new zza();
  final int mVersionCode;
  public Status status;
  public Bundle zzbpU;

  public BundleResponse()
  {
    mVersionCode = 1;
  }

  BundleResponse(int paramInt, Status paramStatus, Bundle paramBundle)
  {
    mVersionCode = paramInt;
    status = paramStatus;
    zzbpU = paramBundle;
  }

  public int describeContents()
  {
    zza localzza = CREATOR;
    return 0;
  }

  public Status getStatus()
  {
    return status;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza localzza = CREATOR;
    zza.zza(this, paramParcel, paramInt);
  }
}
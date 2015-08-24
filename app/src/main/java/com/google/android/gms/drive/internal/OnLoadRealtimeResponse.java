package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class OnLoadRealtimeResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator<OnLoadRealtimeResponse> CREATOR = new zzbe();
  final int mVersionCode;
  final boolean zzpG;

  OnLoadRealtimeResponse(int paramInt, boolean paramBoolean)
  {
    mVersionCode = paramInt;
    zzpG = paramBoolean;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean isInitialized()
  {
    return zzpG;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzbe.zza(this, paramParcel, paramInt);
  }
}
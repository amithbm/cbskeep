package com.google.android.gms.nearby.sharing.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class StopProvidingContentRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<StopProvidingContentRequest> CREATOR = new zzn();
  final int versionCode;
  public long zzbbI;
  public zzd zzbbJ;

  StopProvidingContentRequest()
  {
    versionCode = 1;
  }

  StopProvidingContentRequest(int paramInt, long paramLong, IBinder paramIBinder)
  {
    versionCode = paramInt;
    zzbbI = paramLong;
    zzbbJ = zzd.zza.zzft(paramIBinder);
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzn.zza(this, paramParcel, paramInt);
  }

  IBinder zzAv()
  {
    return zzbbJ.asBinder();
  }
}
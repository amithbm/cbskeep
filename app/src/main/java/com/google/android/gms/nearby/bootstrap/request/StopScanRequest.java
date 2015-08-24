package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzv;
import com.google.android.gms.internal.zzqt;
import com.google.android.gms.internal.zzqt.zza;

public class StopScanRequest
  implements SafeParcelable
{
  public static final zzh CREATOR = new zzh();
  final int versionCode;
  private final zzqt zzbaw;

  StopScanRequest(int paramInt, IBinder paramIBinder)
  {
    versionCode = paramInt;
    zzv.zzz(paramIBinder);
    zzbaw = zzqt.zza.zzfh(paramIBinder);
  }

  public int describeContents()
  {
    zzh localzzh = CREATOR;
    return 0;
  }

  public IBinder getCallbackBinder()
  {
    if (zzbaw == null)
      return null;
    return zzbaw.asBinder();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzh localzzh = CREATOR;
    zzh.zza(this, paramParcel, paramInt);
  }
}
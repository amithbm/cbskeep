package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzv;
import com.google.android.gms.internal.zzqt;
import com.google.android.gms.internal.zzqt.zza;
import com.google.android.gms.nearby.bootstrap.Device;

public class DisconnectRequest
  implements SafeParcelable
{
  public static final zzd CREATOR = new zzd();
  final int versionCode;
  private final Device zzbat;
  private final zzqt zzbaw;

  DisconnectRequest(int paramInt, Device paramDevice, IBinder paramIBinder)
  {
    versionCode = paramInt;
    zzbat = ((Device)zzv.zzz(paramDevice));
    zzv.zzz(paramIBinder);
    zzbaw = zzqt.zza.zzfh(paramIBinder);
  }

  public int describeContents()
  {
    zzd localzzd = CREATOR;
    return 0;
  }

  public IBinder getCallbackBinder()
  {
    return zzbaw.asBinder();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzd localzzd = CREATOR;
    zzd.zza(this, paramParcel, paramInt);
  }

  public Device zzAh()
  {
    return zzbat;
  }
}
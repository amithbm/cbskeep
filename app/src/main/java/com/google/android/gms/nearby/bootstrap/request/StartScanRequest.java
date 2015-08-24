package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzv;
import com.google.android.gms.internal.zzqt;
import com.google.android.gms.internal.zzqt.zza;
import com.google.android.gms.internal.zzqv;
import com.google.android.gms.internal.zzqv.zza;

public class StartScanRequest
  implements SafeParcelable
{
  public static final zzg CREATOR = new zzg();
  final int versionCode;
  private final zzqt zzbaw;
  private final zzqv zzbax;

  StartScanRequest(int paramInt, IBinder paramIBinder1, IBinder paramIBinder2)
  {
    versionCode = paramInt;
    zzv.zzz(paramIBinder1);
    zzbax = zzqv.zza.zzfj(paramIBinder1);
    zzv.zzz(paramIBinder2);
    zzbaw = zzqt.zza.zzfh(paramIBinder2);
  }

  public int describeContents()
  {
    zzg localzzg = CREATOR;
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
    zzg localzzg = CREATOR;
    zzg.zza(this, paramParcel, paramInt);
  }

  public IBinder zzAl()
  {
    if (zzbax == null)
      return null;
    return zzbax.asBinder();
  }
}
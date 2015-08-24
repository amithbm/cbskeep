package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzv;
import com.google.android.gms.internal.zzqt;
import com.google.android.gms.internal.zzqt.zza;

public class ContinueConnectRequest
  implements SafeParcelable
{
  public static final zzb CREATOR = new zzb();
  final int versionCode;
  private final String zzSt;
  private final zzqt zzbaw;

  ContinueConnectRequest(int paramInt, String paramString, IBinder paramIBinder)
  {
    versionCode = paramInt;
    zzSt = ((String)zzv.zzz(paramString));
    zzbaw = zzqt.zza.zzfh(paramIBinder);
  }

  public int describeContents()
  {
    zzb localzzb = CREATOR;
    return 0;
  }

  public IBinder getCallbackBinder()
  {
    if (zzbaw == null)
      return null;
    return zzbaw.asBinder();
  }

  public String getToken()
  {
    return zzSt;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb localzzb = CREATOR;
    zzb.zza(this, paramParcel, paramInt);
  }
}
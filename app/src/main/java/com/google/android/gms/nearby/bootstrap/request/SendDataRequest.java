package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzv;
import com.google.android.gms.internal.zzqt;
import com.google.android.gms.internal.zzqt.zza;
import com.google.android.gms.nearby.bootstrap.Device;

public class SendDataRequest
  implements SafeParcelable
{
  public static final zzf CREATOR = new zzf();
  private final byte[] data;
  final int versionCode;
  private final Device zzbat;
  private final zzqt zzbaw;

  SendDataRequest(int paramInt, Device paramDevice, byte[] paramArrayOfByte, IBinder paramIBinder)
  {
    versionCode = paramInt;
    zzbat = ((Device)zzv.zzz(paramDevice));
    data = ((byte[])zzv.zzz(paramArrayOfByte));
    zzv.zzz(paramIBinder);
    zzbaw = zzqt.zza.zzfh(paramIBinder);
  }

  public int describeContents()
  {
    zzf localzzf = CREATOR;
    return 0;
  }

  public IBinder getCallbackBinder()
  {
    if (zzbaw == null)
      return null;
    return zzbaw.asBinder();
  }

  public byte[] getData()
  {
    return data;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzf localzzf = CREATOR;
    zzf.zza(this, paramParcel, paramInt);
  }

  public Device zzAh()
  {
    return zzbat;
  }
}
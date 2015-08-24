package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.nearby.bootstrap.Device;

public class zzd
  implements Parcelable.Creator<DisconnectRequest>
{
  static void zza(DisconnectRequest paramDisconnectRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zza(paramParcel, 1, paramDisconnectRequest.zzAh(), paramInt, false);
    zzb.zzc(paramParcel, 1000, versionCode);
    zzb.zza(paramParcel, 2, paramDisconnectRequest.getCallbackBinder(), false);
    zzb.zzJ(paramParcel, i);
  }

  public DisconnectRequest zzjt(Parcel paramParcel)
  {
    IBinder localIBinder = null;
    int j = zza.zzcQ(paramParcel);
    int i = 0;
    Device localDevice = null;
    if (paramParcel.dataPosition() < j)
    {
      int k = zza.zzcP(paramParcel);
      switch (zza.zzeS(k))
      {
      default:
        zza.zzb(paramParcel, k);
      case 1:
      case 1000:
      case 2:
      }
      while (true)
      {
        break;
        localDevice = (Device)zza.zza(paramParcel, k, Device.CREATOR);
        continue;
        i = zza.zzg(paramParcel, k);
        continue;
        localIBinder = zza.zzq(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new DisconnectRequest(i, localDevice, localIBinder);
  }

  public DisconnectRequest[] zzmF(int paramInt)
  {
    return new DisconnectRequest[paramInt];
  }
}
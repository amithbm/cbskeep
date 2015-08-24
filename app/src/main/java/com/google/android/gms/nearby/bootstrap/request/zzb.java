package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;

public class zzb
  implements Parcelable.Creator<ContinueConnectRequest>
{
  static void zza(ContinueConnectRequest paramContinueConnectRequest, Parcel paramParcel, int paramInt)
  {
    paramInt = com.google.android.gms.common.internal.safeparcel.zzb.zzcR(paramParcel);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 1, paramContinueConnectRequest.getToken(), false);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 1000, versionCode);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 2, paramContinueConnectRequest.getCallbackBinder(), false);
    com.google.android.gms.common.internal.safeparcel.zzb.zzJ(paramParcel, paramInt);
  }

  public ContinueConnectRequest zzjr(Parcel paramParcel)
  {
    IBinder localIBinder = null;
    int j = zza.zzcQ(paramParcel);
    int i = 0;
    String str = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = zza.zzcP(paramParcel);
      switch (zza.zzeS(k))
      {
      default:
        zza.zzb(paramParcel, k);
        break;
      case 1:
        str = zza.zzp(paramParcel, k);
        break;
      case 1000:
        i = zza.zzg(paramParcel, k);
        break;
      case 2:
        localIBinder = zza.zzq(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new ContinueConnectRequest(i, str, localIBinder);
  }

  public ContinueConnectRequest[] zzmD(int paramInt)
  {
    return new ContinueConnectRequest[paramInt];
  }
}
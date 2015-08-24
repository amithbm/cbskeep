package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzh
  implements Parcelable.Creator<StopScanRequest>
{
  static void zza(StopScanRequest paramStopScanRequest, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcR(paramParcel);
    zzb.zza(paramParcel, 1, paramStopScanRequest.getCallbackBinder(), false);
    zzb.zzc(paramParcel, 1000, versionCode);
    zzb.zzJ(paramParcel, paramInt);
  }

  public StopScanRequest zzjx(Parcel paramParcel)
  {
    int j = zza.zzcQ(paramParcel);
    int i = 0;
    IBinder localIBinder = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = zza.zzcP(paramParcel);
      switch (zza.zzeS(k))
      {
      default:
        zza.zzb(paramParcel, k);
        break;
      case 1:
        localIBinder = zza.zzq(paramParcel, k);
        break;
      case 1000:
        i = zza.zzg(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new StopScanRequest(i, localIBinder);
  }

  public StopScanRequest[] zzmJ(int paramInt)
  {
    return new StopScanRequest[paramInt];
  }
}
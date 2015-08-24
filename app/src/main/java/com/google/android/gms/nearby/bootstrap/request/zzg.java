package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzg
  implements Parcelable.Creator<StartScanRequest>
{
  static void zza(StartScanRequest paramStartScanRequest, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcR(paramParcel);
    zzb.zza(paramParcel, 1, paramStartScanRequest.zzAl(), false);
    zzb.zzc(paramParcel, 1000, versionCode);
    zzb.zza(paramParcel, 2, paramStartScanRequest.getCallbackBinder(), false);
    zzb.zzJ(paramParcel, paramInt);
  }

  public StartScanRequest zzjw(Parcel paramParcel)
  {
    IBinder localIBinder2 = null;
    int j = zza.zzcQ(paramParcel);
    int i = 0;
    IBinder localIBinder1 = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = zza.zzcP(paramParcel);
      switch (zza.zzeS(k))
      {
      default:
        zza.zzb(paramParcel, k);
        break;
      case 1:
        localIBinder1 = zza.zzq(paramParcel, k);
        break;
      case 1000:
        i = zza.zzg(paramParcel, k);
        break;
      case 2:
        localIBinder2 = zza.zzq(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new StartScanRequest(i, localIBinder1, localIBinder2);
  }

  public StartScanRequest[] zzmI(int paramInt)
  {
    return new StartScanRequest[paramInt];
  }
}
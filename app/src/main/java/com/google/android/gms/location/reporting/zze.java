package com.google.android.gms.location.reporting;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zze
  implements Parcelable.Creator<UploadRequestResult>
{
  static void zza(UploadRequestResult paramUploadRequestResult, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, paramUploadRequestResult.getVersionCode());
    zzb.zzc(paramParcel, 2, paramUploadRequestResult.getResultCode());
    zzb.zza(paramParcel, 3, paramUploadRequestResult.getRequestId());
    zzb.zzJ(paramParcel, paramInt);
  }

  public UploadRequestResult zziP(Parcel paramParcel)
  {
    int j = 0;
    int k = zza.zzcQ(paramParcel);
    long l = 0L;
    int i = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = zza.zzcP(paramParcel);
      switch (zza.zzeS(m))
      {
      default:
        zza.zzb(paramParcel, m);
        break;
      case 1:
        i = zza.zzg(paramParcel, m);
        break;
      case 2:
        j = zza.zzg(paramParcel, m);
        break;
      case 3:
        l = zza.zzi(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k)
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    return new UploadRequestResult(i, j, l);
  }

  public UploadRequestResult[] zzlW(int paramInt)
  {
    return new UploadRequestResult[paramInt];
  }
}
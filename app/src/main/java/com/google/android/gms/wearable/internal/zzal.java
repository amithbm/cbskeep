package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.wearable.ConnectionConfiguration;

public class zzal
  implements Parcelable.Creator<GetConfigsResponse>
{
  static void zza(GetConfigsResponse paramGetConfigsResponse, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, versionCode);
    zzb.zzc(paramParcel, 2, statusCode);
    zzb.zza(paramParcel, 3, zzbIb, paramInt, false);
    zzb.zzJ(paramParcel, i);
  }

  public GetConfigsResponse zzny(Parcel paramParcel)
  {
    int j = 0;
    int k = zza.zzcQ(paramParcel);
    ConnectionConfiguration[] arrayOfConnectionConfiguration = null;
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
        arrayOfConnectionConfiguration = (ConnectionConfiguration[])zza.zzb(paramParcel, m, ConnectionConfiguration.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != k)
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    return new GetConfigsResponse(i, j, arrayOfConnectionConfiguration);
  }

  public GetConfigsResponse[] zzrD(int paramInt)
  {
    return new GetConfigsResponse[paramInt];
  }
}
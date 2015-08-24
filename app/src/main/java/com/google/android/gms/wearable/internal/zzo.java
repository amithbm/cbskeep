package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzo
  implements Parcelable.Creator<ChannelReceiveFileResponse>
{
  static void zza(ChannelReceiveFileResponse paramChannelReceiveFileResponse, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, versionCode);
    zzb.zzc(paramParcel, 2, statusCode);
    zzb.zzJ(paramParcel, paramInt);
  }

  public ChannelReceiveFileResponse zznl(Parcel paramParcel)
  {
    int j = 0;
    int k = zza.zzcQ(paramParcel);
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
      }
    }
    if (paramParcel.dataPosition() != k)
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    return new ChannelReceiveFileResponse(i, j);
  }

  public ChannelReceiveFileResponse[] zzrq(int paramInt)
  {
    return new ChannelReceiveFileResponse[paramInt];
  }
}
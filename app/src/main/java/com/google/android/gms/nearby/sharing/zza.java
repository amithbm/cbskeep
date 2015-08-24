package com.google.android.gms.nearby.sharing;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza
  implements Parcelable.Creator<AppContentReceivedResult>
{
  static void zza(AppContentReceivedResult paramAppContentReceivedResult, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, paramAppContentReceivedResult.getVersionCode());
    zzb.zza(paramParcel, 2, paramAppContentReceivedResult.getDestinationUri(), paramInt, false);
    zzb.zzc(paramParcel, 3, paramAppContentReceivedResult.getStatusCode());
    zzb.zzJ(paramParcel, i);
  }

  public AppContentReceivedResult zzjJ(Parcel paramParcel)
  {
    int i = 0;
    int k = com.google.android.gms.common.internal.safeparcel.zza.zzcQ(paramParcel);
    Uri localUri = null;
    int j = 0;
    if (paramParcel.dataPosition() < k)
    {
      int m = com.google.android.gms.common.internal.safeparcel.zza.zzcP(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.zza.zzeS(m))
      {
      default:
        com.google.android.gms.common.internal.safeparcel.zza.zzb(paramParcel, m);
      case 1:
      case 2:
      case 3:
      }
      while (true)
      {
        break;
        j = com.google.android.gms.common.internal.safeparcel.zza.zzg(paramParcel, m);
        continue;
        localUri = (Uri)com.google.android.gms.common.internal.safeparcel.zza.zza(paramParcel, m, Uri.CREATOR);
        continue;
        i = com.google.android.gms.common.internal.safeparcel.zza.zzg(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k)
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    return new AppContentReceivedResult(j, localUri, i);
  }

  public AppContentReceivedResult[] zznc(int paramInt)
  {
    return new AppContentReceivedResult[paramInt];
  }
}
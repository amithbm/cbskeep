package com.google.android.gms.search.administration;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza
  implements Parcelable.Creator<BundleResponse>
{
  static void zza(BundleResponse paramBundleResponse, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1000, mVersionCode);
    zzb.zza(paramParcel, 1, status, paramInt, false);
    zzb.zza(paramParcel, 2, zzbpU, false);
    zzb.zzJ(paramParcel, i);
  }

  public BundleResponse zzlc(Parcel paramParcel)
  {
    Bundle localBundle = null;
    int j = com.google.android.gms.common.internal.safeparcel.zza.zzcQ(paramParcel);
    int i = 0;
    Status localStatus = null;
    if (paramParcel.dataPosition() < j)
    {
      int k = com.google.android.gms.common.internal.safeparcel.zza.zzcP(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.zza.zzeS(k))
      {
      default:
        com.google.android.gms.common.internal.safeparcel.zza.zzb(paramParcel, k);
      case 1000:
      case 1:
      case 2:
      }
      while (true)
      {
        break;
        i = com.google.android.gms.common.internal.safeparcel.zza.zzg(paramParcel, k);
        continue;
        localStatus = (Status)com.google.android.gms.common.internal.safeparcel.zza.zza(paramParcel, k, Status.CREATOR);
        continue;
        localBundle = com.google.android.gms.common.internal.safeparcel.zza.zzr(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new BundleResponse(i, localStatus, localBundle);
  }

  public BundleResponse[] zzoG(int paramInt)
  {
    return new BundleResponse[paramInt];
  }
}
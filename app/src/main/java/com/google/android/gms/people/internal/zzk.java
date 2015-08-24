package com.google.android.gms.people.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzk
  implements Parcelable.Creator<ParcelableLoadImageOptions>
{
  static void zza(ParcelableLoadImageOptions paramParcelableLoadImageOptions, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, paramParcelableLoadImageOptions.zzAE());
    zzb.zzc(paramParcel, 1000, paramParcelableLoadImageOptions.getVersionCode());
    zzb.zzc(paramParcel, 2, paramParcelableLoadImageOptions.zzAF());
    zzb.zza(paramParcel, 3, paramParcelableLoadImageOptions.zzAG());
    zzb.zzJ(paramParcel, paramInt);
  }

  public ParcelableLoadImageOptions zzjV(Parcel paramParcel)
  {
    boolean bool = false;
    int m = zza.zzcQ(paramParcel);
    int k = 0;
    int j = 0;
    int i = 0;
    while (paramParcel.dataPosition() < m)
    {
      int n = zza.zzcP(paramParcel);
      switch (zza.zzeS(n))
      {
      default:
        zza.zzb(paramParcel, n);
        break;
      case 1:
        j = zza.zzg(paramParcel, n);
        break;
      case 1000:
        i = zza.zzg(paramParcel, n);
        break;
      case 2:
        k = zza.zzg(paramParcel, n);
        break;
      case 3:
        bool = zza.zzc(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m)
      throw new zza.zza("Overread allowed size end=" + m, paramParcel);
    return new ParcelableLoadImageOptions(i, j, k, bool);
  }

  public ParcelableLoadImageOptions[] zznq(int paramInt)
  {
    return new ParcelableLoadImageOptions[paramInt];
  }
}
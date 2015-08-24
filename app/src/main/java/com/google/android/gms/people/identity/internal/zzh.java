package com.google.android.gms.people.identity.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzh
  implements Parcelable.Creator<ParcelableListOptions>
{
  static void zza(ParcelableListOptions paramParcelableListOptions, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcR(paramParcel);
    zzb.zza(paramParcel, 1, zzbcN);
    zzb.zzc(paramParcel, 1000, paramParcelableListOptions.getVersionCode());
    zzb.zza(paramParcel, 2, zzbcO);
    zzb.zza(paramParcel, 3, zzbcP, false);
    zzb.zza(paramParcel, 4, zzbcQ);
    zzb.zza(paramParcel, 5, zzbcR, false);
    zzb.zzJ(paramParcel, paramInt);
  }

  public ParcelableListOptions zzjU(Parcel paramParcel)
  {
    Bundle localBundle = null;
    boolean bool1 = false;
    int j = zza.zzcQ(paramParcel);
    String str = null;
    boolean bool2 = false;
    boolean bool3 = false;
    int i = 0;
    while (paramParcel.dataPosition() < j)
    {
      int k = zza.zzcP(paramParcel);
      switch (zza.zzeS(k))
      {
      default:
        zza.zzb(paramParcel, k);
        break;
      case 1:
        bool3 = zza.zzc(paramParcel, k);
        break;
      case 1000:
        i = zza.zzg(paramParcel, k);
        break;
      case 2:
        bool2 = zza.zzc(paramParcel, k);
        break;
      case 3:
        str = zza.zzp(paramParcel, k);
        break;
      case 4:
        bool1 = zza.zzc(paramParcel, k);
        break;
      case 5:
        localBundle = zza.zzr(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new ParcelableListOptions(i, bool3, bool2, bool1, str, localBundle);
  }

  public ParcelableListOptions[] zznn(int paramInt)
  {
    return new ParcelableListOptions[paramInt];
  }
}
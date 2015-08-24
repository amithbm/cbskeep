package com.google.android.gms.appdatasearch;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc
  implements Parcelable.Creator<CorpusStatus>
{
  static void zza(CorpusStatus paramCorpusStatus, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcR(paramParcel);
    zzb.zza(paramParcel, 1, zzMv);
    zzb.zzc(paramParcel, 1000, mVersionCode);
    zzb.zza(paramParcel, 2, zzMw);
    zzb.zza(paramParcel, 3, zzMx);
    zzb.zza(paramParcel, 4, zzMy);
    zzb.zza(paramParcel, 5, zzMz, false);
    zzb.zza(paramParcel, 6, zzMA, false);
    zzb.zzJ(paramParcel, paramInt);
  }

  public CorpusStatus[] zzag(int paramInt)
  {
    return new CorpusStatus[paramInt];
  }

  public CorpusStatus zzu(Parcel paramParcel)
  {
    String str = null;
    boolean bool = false;
    long l1 = 0L;
    int j = zza.zzcQ(paramParcel);
    Bundle localBundle = null;
    long l2 = 0L;
    long l3 = 0L;
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
        bool = zza.zzc(paramParcel, k);
        break;
      case 1000:
        i = zza.zzg(paramParcel, k);
        break;
      case 2:
        l3 = zza.zzi(paramParcel, k);
        break;
      case 3:
        l2 = zza.zzi(paramParcel, k);
        break;
      case 4:
        l1 = zza.zzi(paramParcel, k);
        break;
      case 5:
        localBundle = zza.zzr(paramParcel, k);
        break;
      case 6:
        str = zza.zzp(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new CorpusStatus(i, bool, l3, l2, l1, localBundle, str);
  }
}
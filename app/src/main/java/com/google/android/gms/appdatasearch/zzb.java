package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;

public class zzb
  implements Parcelable.Creator<CorpusScoringInfo>
{
  static void zza(CorpusScoringInfo paramCorpusScoringInfo, Parcel paramParcel, int paramInt)
  {
    int i = com.google.android.gms.common.internal.safeparcel.zzb.zzcR(paramParcel);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 1, corpus, paramInt, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 1000, mVersionCode);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 2, weight);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 3, maxResults);
    com.google.android.gms.common.internal.safeparcel.zzb.zzJ(paramParcel, i);
  }

  public CorpusScoringInfo[] zzaf(int paramInt)
  {
    return new CorpusScoringInfo[paramInt];
  }

  public CorpusScoringInfo zzt(Parcel paramParcel)
  {
    int i = 0;
    int m = zza.zzcQ(paramParcel);
    CorpusId localCorpusId = null;
    int j = 0;
    int k = 0;
    if (paramParcel.dataPosition() < m)
    {
      int n = zza.zzcP(paramParcel);
      switch (zza.zzeS(n))
      {
      default:
        zza.zzb(paramParcel, n);
      case 1:
      case 1000:
      case 2:
      case 3:
      }
      while (true)
      {
        break;
        localCorpusId = (CorpusId)zza.zza(paramParcel, n, CorpusId.CREATOR);
        continue;
        k = zza.zzg(paramParcel, n);
        continue;
        j = zza.zzg(paramParcel, n);
        continue;
        i = zza.zzg(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m)
      throw new zza.zza("Overread allowed size end=" + m, paramParcel);
    return new CorpusScoringInfo(k, localCorpusId, j, i);
  }
}
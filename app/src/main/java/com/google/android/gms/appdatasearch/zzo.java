package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzo
  implements Parcelable.Creator<GlobalSearchQuerySpecification>
{
  static void zza(GlobalSearchQuerySpecification paramGlobalSearchQuerySpecification, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zza(paramParcel, 1, zzMX, paramInt, false);
    zzb.zzc(paramParcel, 1000, mVersionCode);
    zzb.zzc(paramParcel, 2, scoringVerbosityLevel);
    zzb.zza(paramParcel, 3, zzMY, paramInt, false);
    zzb.zzc(paramParcel, 4, debugLevel);
    zzb.zzc(paramParcel, 5, rankingStrategy);
    zzb.zzc(paramParcel, 6, queryTokenizer);
    zzb.zza(paramParcel, 7, context, false);
    zzb.zza(paramParcel, 8, returnPerCorpusResults);
    zzb.zzJ(paramParcel, i);
  }

  public GlobalSearchQuerySpecification zzG(Parcel paramParcel)
  {
    String str = null;
    boolean bool = false;
    int i1 = zza.zzcQ(paramParcel);
    int i = 0;
    int j = 0;
    int k = 0;
    CorpusScoringInfo[] arrayOfCorpusScoringInfo = null;
    int m = 0;
    CorpusId[] arrayOfCorpusId = null;
    int n = 0;
    while (paramParcel.dataPosition() < i1)
    {
      int i2 = zza.zzcP(paramParcel);
      switch (zza.zzeS(i2))
      {
      default:
        zza.zzb(paramParcel, i2);
        break;
      case 1:
        arrayOfCorpusId = (CorpusId[])zza.zzb(paramParcel, i2, CorpusId.CREATOR);
        break;
      case 1000:
        n = zza.zzg(paramParcel, i2);
        break;
      case 2:
        m = zza.zzg(paramParcel, i2);
        break;
      case 3:
        arrayOfCorpusScoringInfo = (CorpusScoringInfo[])zza.zzb(paramParcel, i2, CorpusScoringInfo.CREATOR);
        break;
      case 4:
        k = zza.zzg(paramParcel, i2);
        break;
      case 5:
        j = zza.zzg(paramParcel, i2);
        break;
      case 6:
        i = zza.zzg(paramParcel, i2);
        break;
      case 7:
        str = zza.zzp(paramParcel, i2);
        break;
      case 8:
        bool = zza.zzc(paramParcel, i2);
      }
    }
    if (paramParcel.dataPosition() != i1)
      throw new zza.zza("Overread allowed size end=" + i1, paramParcel);
    return new GlobalSearchQuerySpecification(n, arrayOfCorpusId, m, arrayOfCorpusScoringInfo, k, j, i, str, bool);
  }

  public GlobalSearchQuerySpecification[] zzas(int paramInt)
  {
    return new GlobalSearchQuerySpecification[paramInt];
  }
}
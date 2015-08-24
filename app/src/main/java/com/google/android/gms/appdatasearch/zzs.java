package com.google.android.gms.appdatasearch;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzs
  implements Parcelable.Creator<PhraseAffinityCorpusSpec>
{
  static void zza(PhraseAffinityCorpusSpec paramPhraseAffinityCorpusSpec, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zza(paramParcel, 1, corpus, paramInt, false);
    zzb.zzc(paramParcel, 1000, mVersionCode);
    zzb.zza(paramParcel, 2, zzNv, false);
    zzb.zzJ(paramParcel, i);
  }

  public PhraseAffinityCorpusSpec zzK(Parcel paramParcel)
  {
    Bundle localBundle = null;
    int j = zza.zzcQ(paramParcel);
    int i = 0;
    CorpusId localCorpusId = null;
    if (paramParcel.dataPosition() < j)
    {
      int k = zza.zzcP(paramParcel);
      switch (zza.zzeS(k))
      {
      default:
        zza.zzb(paramParcel, k);
      case 1:
      case 1000:
      case 2:
      }
      while (true)
      {
        break;
        localCorpusId = (CorpusId)zza.zza(paramParcel, k, CorpusId.CREATOR);
        continue;
        i = zza.zzg(paramParcel, k);
        continue;
        localBundle = zza.zzr(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new PhraseAffinityCorpusSpec(i, localCorpusId, localBundle);
  }

  public PhraseAffinityCorpusSpec[] zzaw(int paramInt)
  {
    return new PhraseAffinityCorpusSpec[paramInt];
  }
}
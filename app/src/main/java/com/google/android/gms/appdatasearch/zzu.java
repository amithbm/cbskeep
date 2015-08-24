package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzu
  implements Parcelable.Creator<PhraseAffinitySpecification>
{
  static void zza(PhraseAffinitySpecification paramPhraseAffinitySpecification, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zza(paramParcel, 1, zzNz, paramInt, false);
    zzb.zzc(paramParcel, 1000, mVersionCode);
    zzb.zzJ(paramParcel, i);
  }

  public PhraseAffinitySpecification zzM(Parcel paramParcel)
  {
    int j = zza.zzcQ(paramParcel);
    int i = 0;
    PhraseAffinityCorpusSpec[] arrayOfPhraseAffinityCorpusSpec = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = zza.zzcP(paramParcel);
      switch (zza.zzeS(k))
      {
      default:
        zza.zzb(paramParcel, k);
        break;
      case 1:
        arrayOfPhraseAffinityCorpusSpec = (PhraseAffinityCorpusSpec[])zza.zzb(paramParcel, k, PhraseAffinityCorpusSpec.CREATOR);
        break;
      case 1000:
        i = zza.zzg(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new PhraseAffinitySpecification(i, arrayOfPhraseAffinityCorpusSpec);
  }

  public PhraseAffinitySpecification[] zzay(int paramInt)
  {
    return new PhraseAffinitySpecification[paramInt];
  }
}
package com.google.android.gms.search.queries;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.appdatasearch.PhraseAffinityCorpusSpec;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc
  implements Parcelable.Creator<GetPhraseAffinityCall.Request>
{
  static void zza(GetPhraseAffinityCall.Request paramRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1000, mVersionCode);
    zzb.zza(paramParcel, 1, zzbqw, false);
    zzb.zza(paramParcel, 2, zzbqx, paramInt, false);
    zzb.zzJ(paramParcel, i);
  }

  public GetPhraseAffinityCall.Request zzlI(Parcel paramParcel)
  {
    PhraseAffinityCorpusSpec[] arrayOfPhraseAffinityCorpusSpec = null;
    int j = zza.zzcQ(paramParcel);
    int i = 0;
    String[] arrayOfString = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = zza.zzcP(paramParcel);
      switch (zza.zzeS(k))
      {
      default:
        zza.zzb(paramParcel, k);
        break;
      case 1000:
        i = zza.zzg(paramParcel, k);
        break;
      case 1:
        arrayOfString = zza.zzB(paramParcel, k);
        break;
      case 2:
        arrayOfPhraseAffinityCorpusSpec = (PhraseAffinityCorpusSpec[])zza.zzb(paramParcel, k, PhraseAffinityCorpusSpec.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new GetPhraseAffinityCall.Request(i, arrayOfString, arrayOfPhraseAffinityCorpusSpec);
  }

  public GetPhraseAffinityCall.Request[] zzpm(int paramInt)
  {
    return new GetPhraseAffinityCall.Request[paramInt];
  }
}
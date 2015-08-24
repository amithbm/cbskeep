package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzk
  implements Parcelable.Creator<GlobalSearchAppCorpusFeatures>
{
  static void zza(GlobalSearchAppCorpusFeatures paramGlobalSearchAppCorpusFeatures, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zza(paramParcel, 1, corpusName, false);
    zzb.zzc(paramParcel, 1000, mVersionCode);
    zzb.zza(paramParcel, 2, features, paramInt, false);
    zzb.zzJ(paramParcel, i);
  }

  public GlobalSearchAppCorpusFeatures zzC(Parcel paramParcel)
  {
    Feature[] arrayOfFeature = null;
    int j = zza.zzcQ(paramParcel);
    int i = 0;
    String str = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = zza.zzcP(paramParcel);
      switch (zza.zzeS(k))
      {
      default:
        zza.zzb(paramParcel, k);
        break;
      case 1:
        str = zza.zzp(paramParcel, k);
        break;
      case 1000:
        i = zza.zzg(paramParcel, k);
        break;
      case 2:
        arrayOfFeature = (Feature[])zza.zzb(paramParcel, k, Feature.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new GlobalSearchAppCorpusFeatures(i, str, arrayOfFeature);
  }

  public GlobalSearchAppCorpusFeatures[] zzao(int paramInt)
  {
    return new GlobalSearchAppCorpusFeatures[paramInt];
  }
}
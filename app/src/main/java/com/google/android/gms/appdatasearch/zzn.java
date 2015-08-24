package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzn
  implements Parcelable.Creator<GlobalSearchCorpusConfig>
{
  static void zza(GlobalSearchCorpusConfig paramGlobalSearchCorpusConfig, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zza(paramParcel, 1, globalSearchSectionMappings, false);
    zzb.zzc(paramParcel, 1000, mVersionCode);
    zzb.zza(paramParcel, 2, features, paramInt, false);
    zzb.zzJ(paramParcel, i);
  }

  public GlobalSearchCorpusConfig zzF(Parcel paramParcel)
  {
    Feature[] arrayOfFeature = null;
    int j = zza.zzcQ(paramParcel);
    int i = 0;
    int[] arrayOfInt = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = zza.zzcP(paramParcel);
      switch (zza.zzeS(k))
      {
      default:
        zza.zzb(paramParcel, k);
        break;
      case 1:
        arrayOfInt = zza.zzv(paramParcel, k);
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
    return new GlobalSearchCorpusConfig(i, arrayOfInt, arrayOfFeature);
  }

  public GlobalSearchCorpusConfig[] zzar(int paramInt)
  {
    return new GlobalSearchCorpusConfig[paramInt];
  }
}
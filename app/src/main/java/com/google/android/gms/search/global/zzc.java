package com.google.android.gms.search.global;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.appdatasearch.Feature;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc
  implements Parcelable.Creator<GetGlobalSearchSourcesCall.CorpusInfo>
{
  static void zza(GetGlobalSearchSourcesCall.CorpusInfo paramCorpusInfo, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1000, mVersionCode);
    zzb.zza(paramParcel, 1, corpusName, false);
    zzb.zza(paramParcel, 2, features, paramInt, false);
    zzb.zza(paramParcel, 3, isAppHistoryCorpus);
    zzb.zza(paramParcel, 4, userHandle, false);
    zzb.zzJ(paramParcel, i);
  }

  public GetGlobalSearchSourcesCall.CorpusInfo zzlq(Parcel paramParcel)
  {
    boolean bool = false;
    Bundle localBundle = null;
    int j = zza.zzcQ(paramParcel);
    Feature[] arrayOfFeature = null;
    String str = null;
    int i = 0;
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
        str = zza.zzp(paramParcel, k);
        break;
      case 2:
        arrayOfFeature = (Feature[])zza.zzb(paramParcel, k, Feature.CREATOR);
        break;
      case 3:
        bool = zza.zzc(paramParcel, k);
        break;
      case 4:
        localBundle = zza.zzr(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new GetGlobalSearchSourcesCall.CorpusInfo(i, str, arrayOfFeature, bool, localBundle);
  }

  public GetGlobalSearchSourcesCall.CorpusInfo[] zzoU(int paramInt)
  {
    return new GetGlobalSearchSourcesCall.CorpusInfo[paramInt];
  }
}
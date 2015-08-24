package com.google.android.gms.search.queries;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.appdatasearch.SuggestionResults;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzj
  implements Parcelable.Creator<QuerySuggestCall.Response>
{
  static void zza(QuerySuggestCall.Response paramResponse, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1000, mVersionCode);
    zzb.zza(paramParcel, 1, status, paramInt, false);
    zzb.zza(paramParcel, 2, querySuggestions, paramInt, false);
    zzb.zzJ(paramParcel, i);
  }

  public QuerySuggestCall.Response zzlP(Parcel paramParcel)
  {
    SuggestionResults localSuggestionResults = null;
    int j = zza.zzcQ(paramParcel);
    int i = 0;
    Status localStatus = null;
    if (paramParcel.dataPosition() < j)
    {
      int k = zza.zzcP(paramParcel);
      switch (zza.zzeS(k))
      {
      default:
        zza.zzb(paramParcel, k);
      case 1000:
      case 1:
      case 2:
      }
      while (true)
      {
        break;
        i = zza.zzg(paramParcel, k);
        continue;
        localStatus = (Status)zza.zza(paramParcel, k, Status.CREATOR);
        continue;
        localSuggestionResults = (SuggestionResults)zza.zza(paramParcel, k, SuggestionResults.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new QuerySuggestCall.Response(i, localStatus, localSuggestionResults);
  }

  public QuerySuggestCall.Response[] zzpt(int paramInt)
  {
    return new QuerySuggestCall.Response[paramInt];
  }
}
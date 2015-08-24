package com.google.android.gms.search.queries;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.appdatasearch.SearchResults;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzh
  implements Parcelable.Creator<QueryCall.Response>
{
  static void zza(QueryCall.Response paramResponse, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1000, mVersionCode);
    zzb.zza(paramParcel, 1, status, paramInt, false);
    zzb.zza(paramParcel, 2, documents, paramInt, false);
    zzb.zzJ(paramParcel, i);
  }

  public QueryCall.Response zzlN(Parcel paramParcel)
  {
    SearchResults localSearchResults = null;
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
        localSearchResults = (SearchResults)zza.zza(paramParcel, k, SearchResults.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new QueryCall.Response(i, localStatus, localSearchResults);
  }

  public QueryCall.Response[] zzpr(int paramInt)
  {
    return new QueryCall.Response[paramInt];
  }
}
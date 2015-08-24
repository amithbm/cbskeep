package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.query.Query;

public class zzbk
  implements Parcelable.Creator<QueryRequest>
{
  static void zza(QueryRequest paramQueryRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zza(paramParcel, 2, zzawp, paramInt, false);
    zzb.zzJ(paramParcel, i);
  }

  public QueryRequest zzeJ(Parcel paramParcel)
  {
    int j = zza.zzcQ(paramParcel);
    int i = 0;
    Query localQuery = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = zza.zzcP(paramParcel);
      switch (zza.zzeS(k))
      {
      default:
        zza.zzb(paramParcel, k);
        break;
      case 1:
        i = zza.zzg(paramParcel, k);
        break;
      case 2:
        localQuery = (Query)zza.zza(paramParcel, k, Query.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new QueryRequest(i, localQuery);
  }

  public QueryRequest[] zzhd(int paramInt)
  {
    return new QueryRequest[paramInt];
  }
}
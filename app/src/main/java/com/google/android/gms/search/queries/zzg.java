package com.google.android.gms.search.queries;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.appdatasearch.QuerySpecification;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzg
  implements Parcelable.Creator<QueryCall.Request>
{
  static void zza(QueryCall.Request paramRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1000, mVersionCode);
    zzb.zza(paramParcel, 1, query, false);
    zzb.zza(paramParcel, 2, packageName, false);
    zzb.zza(paramParcel, 3, zzbqC, false);
    zzb.zzc(paramParcel, 4, start);
    zzb.zzc(paramParcel, 5, zzbqz);
    zzb.zza(paramParcel, 6, zzbqu, paramInt, false);
    zzb.zzJ(paramParcel, i);
  }

  public QueryCall.Request zzlM(Parcel paramParcel)
  {
    int i = 0;
    QuerySpecification localQuerySpecification = null;
    int m = zza.zzcQ(paramParcel);
    int j = 0;
    String[] arrayOfString = null;
    String str1 = null;
    String str2 = null;
    int k = 0;
    while (paramParcel.dataPosition() < m)
    {
      int n = zza.zzcP(paramParcel);
      switch (zza.zzeS(n))
      {
      default:
        zza.zzb(paramParcel, n);
        break;
      case 1000:
        k = zza.zzg(paramParcel, n);
        break;
      case 1:
        str2 = zza.zzp(paramParcel, n);
        break;
      case 2:
        str1 = zza.zzp(paramParcel, n);
        break;
      case 3:
        arrayOfString = zza.zzB(paramParcel, n);
        break;
      case 4:
        j = zza.zzg(paramParcel, n);
        break;
      case 5:
        i = zza.zzg(paramParcel, n);
        break;
      case 6:
        localQuerySpecification = (QuerySpecification)zza.zza(paramParcel, n, QuerySpecification.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != m)
      throw new zza.zza("Overread allowed size end=" + m, paramParcel);
    return new QueryCall.Request(k, str2, str1, arrayOfString, j, i, localQuerySpecification);
  }

  public QueryCall.Request[] zzpq(int paramInt)
  {
    return new QueryCall.Request[paramInt];
  }
}
package com.google.android.gms.search.queries;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.appdatasearch.SuggestSpecification;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzi
  implements Parcelable.Creator<QuerySuggestCall.Request>
{
  static void zza(QuerySuggestCall.Request paramRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1000, mVersionCode);
    zzb.zza(paramParcel, 1, query, false);
    zzb.zza(paramParcel, 2, packageName, false);
    zzb.zza(paramParcel, 3, zzbqC, false);
    zzb.zzc(paramParcel, 4, zzbqE);
    zzb.zza(paramParcel, 5, zzbqF, paramInt, false);
    zzb.zzJ(paramParcel, i);
  }

  public QuerySuggestCall.Request zzlO(Parcel paramParcel)
  {
    int i = 0;
    SuggestSpecification localSuggestSpecification = null;
    int k = zza.zzcQ(paramParcel);
    String[] arrayOfString = null;
    String str1 = null;
    String str2 = null;
    int j = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = zza.zzcP(paramParcel);
      switch (zza.zzeS(m))
      {
      default:
        zza.zzb(paramParcel, m);
        break;
      case 1000:
        j = zza.zzg(paramParcel, m);
        break;
      case 1:
        str2 = zza.zzp(paramParcel, m);
        break;
      case 2:
        str1 = zza.zzp(paramParcel, m);
        break;
      case 3:
        arrayOfString = zza.zzB(paramParcel, m);
        break;
      case 4:
        i = zza.zzg(paramParcel, m);
        break;
      case 5:
        localSuggestSpecification = (SuggestSpecification)zza.zza(paramParcel, m, SuggestSpecification.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != k)
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    return new QuerySuggestCall.Request(j, str2, str1, arrayOfString, i, localSuggestSpecification);
  }

  public QuerySuggestCall.Request[] zzps(int paramInt)
  {
    return new QuerySuggestCall.Request[paramInt];
  }
}
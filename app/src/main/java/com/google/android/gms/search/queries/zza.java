package com.google.android.gms.search.queries;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.appdatasearch.QuerySpecification;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza
  implements Parcelable.Creator<GetDocumentsCall.Request>
{
  static void zza(GetDocumentsCall.Request paramRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1000, mVersionCode);
    zzb.zza(paramParcel, 1, packageName, false);
    zzb.zza(paramParcel, 2, corpusName, false);
    zzb.zza(paramParcel, 3, zzbbC, false);
    zzb.zza(paramParcel, 4, zzbqu, paramInt, false);
    zzb.zzJ(paramParcel, i);
  }

  public GetDocumentsCall.Request zzlG(Parcel paramParcel)
  {
    QuerySpecification localQuerySpecification = null;
    int j = com.google.android.gms.common.internal.safeparcel.zza.zzcQ(paramParcel);
    int i = 0;
    String[] arrayOfString = null;
    String str1 = null;
    String str2 = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = com.google.android.gms.common.internal.safeparcel.zza.zzcP(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.zza.zzeS(k))
      {
      default:
        com.google.android.gms.common.internal.safeparcel.zza.zzb(paramParcel, k);
        break;
      case 1000:
        i = com.google.android.gms.common.internal.safeparcel.zza.zzg(paramParcel, k);
        break;
      case 1:
        str2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(paramParcel, k);
        break;
      case 2:
        str1 = com.google.android.gms.common.internal.safeparcel.zza.zzp(paramParcel, k);
        break;
      case 3:
        arrayOfString = com.google.android.gms.common.internal.safeparcel.zza.zzB(paramParcel, k);
        break;
      case 4:
        localQuerySpecification = (QuerySpecification)com.google.android.gms.common.internal.safeparcel.zza.zza(paramParcel, k, QuerySpecification.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new GetDocumentsCall.Request(i, str2, str1, arrayOfString, localQuerySpecification);
  }

  public GetDocumentsCall.Request[] zzpk(int paramInt)
  {
    return new GetDocumentsCall.Request[paramInt];
  }
}
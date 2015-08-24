package com.google.android.gms.search.queries;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.appdatasearch.GlobalSearchQuerySpecification;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zze
  implements Parcelable.Creator<GlobalQueryCall.Request>
{
  static void zza(GlobalQueryCall.Request paramRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1000, mVersionCode);
    zzb.zza(paramParcel, 1, query, false);
    zzb.zzc(paramParcel, 2, start);
    zzb.zzc(paramParcel, 3, zzbqz);
    zzb.zza(paramParcel, 4, zzbqA, paramInt, false);
    zzb.zzJ(paramParcel, i);
  }

  public GlobalQueryCall.Request zzlK(Parcel paramParcel)
  {
    GlobalSearchQuerySpecification localGlobalSearchQuerySpecification = null;
    int i = 0;
    int m = zza.zzcQ(paramParcel);
    int j = 0;
    String str = null;
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
        str = zza.zzp(paramParcel, n);
        break;
      case 2:
        j = zza.zzg(paramParcel, n);
        break;
      case 3:
        i = zza.zzg(paramParcel, n);
        break;
      case 4:
        localGlobalSearchQuerySpecification = (GlobalSearchQuerySpecification)zza.zza(paramParcel, n, GlobalSearchQuerySpecification.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != m)
      throw new zza.zza("Overread allowed size end=" + m, paramParcel);
    return new GlobalQueryCall.Request(k, str, j, i, localGlobalSearchQuerySpecification);
  }

  public GlobalQueryCall.Request[] zzpo(int paramInt)
  {
    return new GlobalQueryCall.Request[paramInt];
  }
}
package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzv
  implements Parcelable.Creator<QuerySpecification>
{
  static void zza(QuerySpecification paramQuerySpecification, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcR(paramParcel);
    zzb.zza(paramParcel, 1, wantUris);
    zzb.zzc(paramParcel, 1000, mVersionCode);
    zzb.zzc(paramParcel, 2, wantedTags, false);
    zzb.zzd(paramParcel, 3, wantedSections, false);
    zzb.zza(paramParcel, 4, prefixMatch);
    zzb.zzc(paramParcel, 5, debugLevel);
    zzb.zzc(paramParcel, 6, rankingStrategy);
    zzb.zza(paramParcel, 7, semanticSectionNames);
    zzb.zzc(paramParcel, 8, queryTokenizer);
    zzb.zzJ(paramParcel, paramInt);
  }

  public QuerySpecification zzN(Parcel paramParcel)
  {
    ArrayList localArrayList1 = null;
    int i = 0;
    int n = zza.zzcQ(paramParcel);
    boolean bool1 = false;
    int j = 0;
    int k = 0;
    boolean bool2 = false;
    ArrayList localArrayList2 = null;
    boolean bool3 = false;
    int m = 0;
    while (paramParcel.dataPosition() < n)
    {
      int i1 = zza.zzcP(paramParcel);
      switch (zza.zzeS(i1))
      {
      default:
        zza.zzb(paramParcel, i1);
        break;
      case 1:
        bool3 = zza.zzc(paramParcel, i1);
        break;
      case 1000:
        m = zza.zzg(paramParcel, i1);
        break;
      case 2:
        localArrayList2 = zza.zzE(paramParcel, i1);
        break;
      case 3:
        localArrayList1 = zza.zzc(paramParcel, i1, Section.CREATOR);
        break;
      case 4:
        bool2 = zza.zzc(paramParcel, i1);
        break;
      case 5:
        k = zza.zzg(paramParcel, i1);
        break;
      case 6:
        j = zza.zzg(paramParcel, i1);
        break;
      case 7:
        bool1 = zza.zzc(paramParcel, i1);
        break;
      case 8:
        i = zza.zzg(paramParcel, i1);
      }
    }
    if (paramParcel.dataPosition() != n)
      throw new zza.zza("Overread allowed size end=" + n, paramParcel);
    return new QuerySpecification(m, bool3, localArrayList2, localArrayList1, bool2, k, j, bool1, i);
  }

  public QuerySpecification[] zzaz(int paramInt)
  {
    return new QuerySpecification[paramInt];
  }
}
package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzd
  implements Parcelable.Creator<FilterHolder>
{
  static void zza(FilterHolder paramFilterHolder, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zza(paramParcel, 1, zzaxP, paramInt, false);
    zzb.zzc(paramParcel, 1000, mVersionCode);
    zzb.zza(paramParcel, 2, zzaxQ, paramInt, false);
    zzb.zza(paramParcel, 3, zzaxR, paramInt, false);
    zzb.zza(paramParcel, 4, zzaxS, paramInt, false);
    zzb.zza(paramParcel, 5, zzaxT, paramInt, false);
    zzb.zza(paramParcel, 6, zzaxU, paramInt, false);
    zzb.zza(paramParcel, 7, zzaxV, paramInt, false);
    zzb.zza(paramParcel, 8, zzaxW, paramInt, false);
    zzb.zza(paramParcel, 9, zzaxX, paramInt, false);
    zzb.zzJ(paramParcel, i);
  }

  public FilterHolder zzff(Parcel paramParcel)
  {
    OwnedByMeFilter localOwnedByMeFilter = null;
    int j = zza.zzcQ(paramParcel);
    int i = 0;
    FullTextSearchFilter localFullTextSearchFilter = null;
    HasFilter localHasFilter = null;
    MatchAllFilter localMatchAllFilter = null;
    InFilter localInFilter = null;
    NotFilter localNotFilter = null;
    LogicalFilter localLogicalFilter = null;
    FieldOnlyFilter localFieldOnlyFilter = null;
    ComparisonFilter localComparisonFilter = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = zza.zzcP(paramParcel);
      switch (zza.zzeS(k))
      {
      default:
        zza.zzb(paramParcel, k);
        break;
      case 1:
        localComparisonFilter = (ComparisonFilter)zza.zza(paramParcel, k, ComparisonFilter.CREATOR);
        break;
      case 1000:
        i = zza.zzg(paramParcel, k);
        break;
      case 2:
        localFieldOnlyFilter = (FieldOnlyFilter)zza.zza(paramParcel, k, FieldOnlyFilter.CREATOR);
        break;
      case 3:
        localLogicalFilter = (LogicalFilter)zza.zza(paramParcel, k, LogicalFilter.CREATOR);
        break;
      case 4:
        localNotFilter = (NotFilter)zza.zza(paramParcel, k, NotFilter.CREATOR);
        break;
      case 5:
        localInFilter = (InFilter)zza.zza(paramParcel, k, InFilter.CREATOR);
        break;
      case 6:
        localMatchAllFilter = (MatchAllFilter)zza.zza(paramParcel, k, MatchAllFilter.CREATOR);
        break;
      case 7:
        localHasFilter = (HasFilter)zza.zza(paramParcel, k, HasFilter.CREATOR);
        break;
      case 8:
        localFullTextSearchFilter = (FullTextSearchFilter)zza.zza(paramParcel, k, FullTextSearchFilter.CREATOR);
        break;
      case 9:
        localOwnedByMeFilter = (OwnedByMeFilter)zza.zza(paramParcel, k, OwnedByMeFilter.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new FilterHolder(i, localComparisonFilter, localFieldOnlyFilter, localLogicalFilter, localNotFilter, localInFilter, localMatchAllFilter, localHasFilter, localFullTextSearchFilter, localOwnedByMeFilter);
  }

  public FilterHolder[] zzhz(int paramInt)
  {
    return new FilterHolder[paramInt];
  }
}
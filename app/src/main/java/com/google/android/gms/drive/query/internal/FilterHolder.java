package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.Filter;

public class FilterHolder
  implements SafeParcelable
{
  public static final Parcelable.Creator<FilterHolder> CREATOR = new zzd();
  final int mVersionCode;
  private final Filter zzasL;
  final ComparisonFilter<?> zzaxP;
  final FieldOnlyFilter zzaxQ;
  final LogicalFilter zzaxR;
  final NotFilter zzaxS;
  final InFilter<?> zzaxT;
  final MatchAllFilter zzaxU;
  final HasFilter zzaxV;
  final FullTextSearchFilter zzaxW;
  final OwnedByMeFilter zzaxX;

  FilterHolder(int paramInt, ComparisonFilter<?> paramComparisonFilter, FieldOnlyFilter paramFieldOnlyFilter, LogicalFilter paramLogicalFilter, NotFilter paramNotFilter, InFilter<?> paramInFilter, MatchAllFilter paramMatchAllFilter, HasFilter<?> paramHasFilter, FullTextSearchFilter paramFullTextSearchFilter, OwnedByMeFilter paramOwnedByMeFilter)
  {
    mVersionCode = paramInt;
    zzaxP = paramComparisonFilter;
    zzaxQ = paramFieldOnlyFilter;
    zzaxR = paramLogicalFilter;
    zzaxS = paramNotFilter;
    zzaxT = paramInFilter;
    zzaxU = paramMatchAllFilter;
    zzaxV = paramHasFilter;
    zzaxW = paramFullTextSearchFilter;
    zzaxX = paramOwnedByMeFilter;
    if (zzaxP != null)
    {
      zzasL = zzaxP;
      return;
    }
    if (zzaxQ != null)
    {
      zzasL = zzaxQ;
      return;
    }
    if (zzaxR != null)
    {
      zzasL = zzaxR;
      return;
    }
    if (zzaxS != null)
    {
      zzasL = zzaxS;
      return;
    }
    if (zzaxT != null)
    {
      zzasL = zzaxT;
      return;
    }
    if (zzaxU != null)
    {
      zzasL = zzaxU;
      return;
    }
    if (zzaxV != null)
    {
      zzasL = zzaxV;
      return;
    }
    if (zzaxW != null)
    {
      zzasL = zzaxW;
      return;
    }
    if (zzaxX != null)
    {
      zzasL = zzaxX;
      return;
    }
    throw new IllegalArgumentException("At least one filter must be set.");
  }

  public int describeContents()
  {
    return 0;
  }

  public Filter getFilter()
  {
    return zzasL;
  }

  public String toString()
  {
    return String.format("FilterHolder[%s]", new Object[] { zzasL });
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzd.zza(this, paramParcel, paramInt);
  }
}
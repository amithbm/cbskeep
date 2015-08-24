package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class QuerySpecification
  implements SafeParcelable
{
  public static final zzv CREATOR = new zzv();
  public final int debugLevel;
  final int mVersionCode;
  public final boolean prefixMatch;
  public final int queryTokenizer;
  public final int rankingStrategy;
  public final boolean semanticSectionNames;
  public final boolean wantUris;
  public final List<Section> wantedSections;
  public final List<String> wantedTags;

  QuerySpecification(int paramInt1, boolean paramBoolean1, List<String> paramList, List<Section> paramList1, boolean paramBoolean2, int paramInt2, int paramInt3, boolean paramBoolean3, int paramInt4)
  {
    mVersionCode = paramInt1;
    wantUris = paramBoolean1;
    wantedTags = paramList;
    wantedSections = paramList1;
    prefixMatch = paramBoolean2;
    debugLevel = paramInt2;
    rankingStrategy = paramInt3;
    semanticSectionNames = paramBoolean3;
    queryTokenizer = paramInt4;
  }

  public int describeContents()
  {
    zzv localzzv = CREATOR;
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzv localzzv = CREATOR;
    zzv.zza(this, paramParcel, paramInt);
  }
}
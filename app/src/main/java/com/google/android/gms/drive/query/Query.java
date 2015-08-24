package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveSpace;
import com.google.android.gms.drive.query.internal.LogicalFilter;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class Query
  implements SafeParcelable
{
  public static final Parcelable.Creator<Query> CREATOR = new zza();
  final int mVersionCode;
  final List<DriveSpace> zzate;
  private final Set<DriveSpace> zzatf;
  final LogicalFilter zzaxB;
  final String zzaxC;
  final SortOrder zzaxD;
  final List<String> zzaxE;
  final boolean zzaxF;

  Query(int paramInt, LogicalFilter paramLogicalFilter, String paramString, SortOrder paramSortOrder, List<String> paramList, boolean paramBoolean, List<DriveSpace> paramList1)
  {
  }

  private Query(int paramInt, LogicalFilter paramLogicalFilter, String paramString, SortOrder paramSortOrder, List<String> paramList, boolean paramBoolean, List<DriveSpace> paramList1, Set<DriveSpace> paramSet)
  {
    mVersionCode = paramInt;
    zzaxB = paramLogicalFilter;
    zzaxC = paramString;
    zzaxD = paramSortOrder;
    zzaxE = paramList;
    zzaxF = paramBoolean;
    zzate = paramList1;
    zzatf = paramSet;
  }

  public int describeContents()
  {
    return 0;
  }

  public String toString()
  {
    return String.format(Locale.US, "Query[%s,%s,PageToken=%s,Spaces=%s]", new Object[] { zzaxB, zzaxD, zzaxC, zzate });
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
}
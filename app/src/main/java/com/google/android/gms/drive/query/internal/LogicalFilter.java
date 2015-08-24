package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.query.Filter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LogicalFilter extends AbstractFilter
{
  public static final Parcelable.Creator<LogicalFilter> CREATOR = new zzk();
  final int mVersionCode;
  final Operator zzaxL;
  final List<FilterHolder> zzaya;

  LogicalFilter(int paramInt, Operator paramOperator, List<FilterHolder> paramList)
  {
    mVersionCode = paramInt;
    zzaxL = paramOperator;
    zzaya = paramList;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzk.zza(this, paramParcel, paramInt);
  }

  public <T> T zza(zzf<T> paramzzf)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = zzaya.iterator();
    while (localIterator.hasNext())
      localArrayList.add(((FilterHolder)localIterator.next()).getFilter().zza(paramzzf));
    return paramzzf.zzb(zzaxL, localArrayList);
  }
}
package com.google.android.gms.drive.query.internal;

import android.os.Parcel;

public class MatchAllFilter extends AbstractFilter
{
  public static final zzl CREATOR = new zzl();
  final int mVersionCode;

  public MatchAllFilter()
  {
    this(1);
  }

  MatchAllFilter(int paramInt)
  {
    mVersionCode = paramInt;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzl.zza(this, paramParcel, paramInt);
  }

  public <F> F zza(zzf<F> paramzzf)
  {
    return paramzzf.zztv();
  }
}
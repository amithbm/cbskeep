package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.query.Filter;

public class NotFilter extends AbstractFilter
{
  public static final Parcelable.Creator<NotFilter> CREATOR = new zzm();
  final int mVersionCode;
  final FilterHolder zzayb;

  NotFilter(int paramInt, FilterHolder paramFilterHolder)
  {
    mVersionCode = paramInt;
    zzayb = paramFilterHolder;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzm.zza(this, paramParcel, paramInt);
  }

  public <T> T zza(zzf<T> paramzzf)
  {
    return paramzzf.zzA(zzayb.getFilter().zza(paramzzf));
  }
}
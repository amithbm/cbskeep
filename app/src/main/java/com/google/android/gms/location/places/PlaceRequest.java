package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.common.internal.zzu.zza;
import java.util.concurrent.TimeUnit;

public final class PlaceRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<PlaceRequest> CREATOR = new zzj();
  static final long zzaUy = TimeUnit.HOURS.toMillis(1L);
  private final int mPriority;
  final int mVersionCode;
  private final long zzaQX;
  private final long zzaRx;
  private final PlaceFilter zzaUz;

  public PlaceRequest(int paramInt1, PlaceFilter paramPlaceFilter, long paramLong1, int paramInt2, long paramLong2)
  {
    mVersionCode = paramInt1;
    zzaUz = paramPlaceFilter;
    zzaRx = paramLong1;
    mPriority = paramInt2;
    zzaQX = paramLong2;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    do
    {
      return true;
      if (!(paramObject instanceof PlaceRequest))
        return false;
      paramObject = (PlaceRequest)paramObject;
    }
    while ((zzu.equal(zzaUz, paramObject.zzaUz)) && (zzaRx == paramObject.zzaRx) && (mPriority == paramObject.mPriority) && (zzaQX == paramObject.zzaQX));
    return false;
  }

  public long getExpirationTime()
  {
    return zzaQX;
  }

  public PlaceFilter getFilter()
  {
    return zzaUz;
  }

  public long getInterval()
  {
    return zzaRx;
  }

  public int getPriority()
  {
    return mPriority;
  }

  public int hashCode()
  {
    return zzu.hashCode(new Object[] { zzaUz, Long.valueOf(zzaRx), Integer.valueOf(mPriority), Long.valueOf(zzaQX) });
  }

  public String toString()
  {
    return zzu.zzy(this).zzc("filter", zzaUz).zzc("interval", Long.valueOf(zzaRx)).zzc("priority", Integer.valueOf(mPriority)).zzc("expireAt", Long.valueOf(zzaQX)).toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzj.zza(this, paramParcel, paramInt);
  }
}
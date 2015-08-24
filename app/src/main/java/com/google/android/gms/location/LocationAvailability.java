package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;

public final class LocationAvailability
  implements SafeParcelable
{
  public static final LocationAvailabilityCreator CREATOR = new LocationAvailabilityCreator();
  private final int mVersionCode;
  int zzaRt;
  int zzaRu;
  long zzaRv;
  int zzaRw;

  LocationAvailability(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong)
  {
    mVersionCode = paramInt1;
    zzaRw = paramInt2;
    zzaRt = paramInt3;
    zzaRu = paramInt4;
    zzaRv = paramLong;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof LocationAvailability));
    do
    {
      return false;
      paramObject = (LocationAvailability)paramObject;
    }
    while ((zzaRw != paramObject.zzaRw) || (zzaRt != paramObject.zzaRt) || (zzaRu != paramObject.zzaRu) || (zzaRv != paramObject.zzaRv));
    return true;
  }

  int getVersionCode()
  {
    return mVersionCode;
  }

  public int hashCode()
  {
    return zzu.hashCode(new Object[] { Integer.valueOf(zzaRw), Integer.valueOf(zzaRt), Integer.valueOf(zzaRu), Long.valueOf(zzaRv) });
  }

  public boolean isLocationAvailable()
  {
    return zzaRw < 1000;
  }

  public String toString()
  {
    return "LocationAvailability[isLocationAvailable: " + isLocationAvailable() + "]";
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    LocationAvailabilityCreator.zza(this, paramParcel, paramInt);
  }
}
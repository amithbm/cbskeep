package com.google.android.gms.location;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class LocationResult
  implements SafeParcelable
{
  public static final Parcelable.Creator<LocationResult> CREATOR = new zzg();
  static final List<Location> zzaRC = Collections.emptyList();
  private final int mVersionCode;
  private final List<Location> zzaRD;

  LocationResult(int paramInt, List<Location> paramList)
  {
    mVersionCode = paramInt;
    zzaRD = paramList;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof LocationResult))
      return false;
    paramObject = (LocationResult)paramObject;
    if (paramObject.zzaRD.size() != zzaRD.size())
      return false;
    paramObject = paramObject.zzaRD.iterator();
    Iterator localIterator = zzaRD.iterator();
    while (paramObject.hasNext())
    {
      Location localLocation1 = (Location)localIterator.next();
      Location localLocation2 = (Location)paramObject.next();
      if (localLocation1.getTime() != localLocation2.getTime())
        return false;
    }
    return true;
  }

  public List<Location> getLocations()
  {
    return zzaRD;
  }

  int getVersionCode()
  {
    return mVersionCode;
  }

  public int hashCode()
  {
    Iterator localIterator = zzaRD.iterator();
    long l;
    for (int i = 17; localIterator.hasNext(); i = (int)(l ^ l >>> 32) + i * 31)
      l = ((Location)localIterator.next()).getTime();
    return i;
  }

  public String toString()
  {
    return "LocationResult[locations: " + zzaRD + "]";
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzg.zza(this, paramParcel, paramInt);
  }
}
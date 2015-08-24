package com.google.android.gms.maps.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class Point
  implements SafeParcelable
{
  public static final zzz CREATOR = new zzz();
  private final int versionCode;
  private final android.graphics.Point zzaYn;

  public Point(int paramInt, android.graphics.Point paramPoint)
  {
    versionCode = paramInt;
    zzaYn = paramPoint;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject)
      return true;
    if (!(paramObject instanceof Point))
      return false;
    paramObject = (Point)paramObject;
    return zzaYn.equals(paramObject.zzaYn);
  }

  int getVersionCode()
  {
    return versionCode;
  }

  public int hashCode()
  {
    return zzaYn.hashCode();
  }

  public String toString()
  {
    return zzaYn.toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzz.zza(this, paramParcel, paramInt);
  }

  public android.graphics.Point zzzP()
  {
    return zzaYn;
  }
}
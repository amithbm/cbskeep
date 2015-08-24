package com.google.android.gms.location;

import android.os.Parcel;
import android.os.SystemClock;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;

public final class LocationRequest
  implements SafeParcelable
{
  public static final LocationRequestCreator CREATOR = new LocationRequestCreator();
  int mPriority;
  private final int mVersionCode;
  boolean zzaEt;
  long zzaQX;
  float zzaRA;
  long zzaRB;
  long zzaRx;
  long zzaRy;
  int zzaRz;

  public LocationRequest()
  {
    mVersionCode = 1;
    mPriority = 102;
    zzaRx = 3600000L;
    zzaRy = 600000L;
    zzaEt = false;
    zzaQX = 9223372036854775807L;
    zzaRz = 2147483647;
    zzaRA = 0.0F;
    zzaRB = 0L;
  }

  LocationRequest(int paramInt1, int paramInt2, long paramLong1, long paramLong2, boolean paramBoolean, long paramLong3, int paramInt3, float paramFloat, long paramLong4)
  {
    mVersionCode = paramInt1;
    mPriority = paramInt2;
    zzaRx = paramLong1;
    zzaRy = paramLong2;
    zzaEt = paramBoolean;
    zzaQX = paramLong3;
    zzaRz = paramInt3;
    zzaRA = paramFloat;
    zzaRB = paramLong4;
  }

  public static String zzkL(int paramInt)
  {
    switch (paramInt)
    {
    case 101:
    case 103:
    default:
      return "???";
    case 100:
      return "PRIORITY_HIGH_ACCURACY";
    case 102:
      return "PRIORITY_BALANCED_POWER_ACCURACY";
    case 104:
      return "PRIORITY_LOW_POWER";
    case 105:
    }
    return "PRIORITY_NO_POWER";
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
      if (!(paramObject instanceof LocationRequest))
        return false;
      paramObject = (LocationRequest)paramObject;
    }
    while ((mPriority == paramObject.mPriority) && (zzaRx == paramObject.zzaRx) && (zzaRy == paramObject.zzaRy) && (zzaEt == paramObject.zzaEt) && (zzaQX == paramObject.zzaQX) && (zzaRz == paramObject.zzaRz) && (zzaRA == paramObject.zzaRA));
    return false;
  }

  int getVersionCode()
  {
    return mVersionCode;
  }

  public int hashCode()
  {
    return zzu.hashCode(new Object[] { Integer.valueOf(mPriority), Long.valueOf(zzaRx), Long.valueOf(zzaRy), Boolean.valueOf(zzaEt), Long.valueOf(zzaQX), Integer.valueOf(zzaRz), Float.valueOf(zzaRA) });
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Request[").append(zzkL(mPriority));
    if (mPriority != 105)
    {
      localStringBuilder.append(" requested=");
      localStringBuilder.append(zzaRx + "ms");
    }
    localStringBuilder.append(" fastest=");
    localStringBuilder.append(zzaRy + "ms");
    if (zzaRB > zzaRx)
    {
      localStringBuilder.append(" maxWait=");
      localStringBuilder.append(zzaRB + "ms");
    }
    if (zzaQX != 9223372036854775807L)
    {
      long l1 = zzaQX;
      long l2 = SystemClock.elapsedRealtime();
      localStringBuilder.append(" expireIn=");
      localStringBuilder.append(l1 - l2 + "ms");
    }
    if (zzaRz != 2147483647)
      localStringBuilder.append(" num=").append(zzaRz);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    LocationRequestCreator.zza(this, paramParcel, paramInt);
  }
}
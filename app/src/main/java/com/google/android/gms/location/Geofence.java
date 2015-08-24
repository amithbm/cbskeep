package com.google.android.gms.location;

import android.os.SystemClock;
import com.google.android.gms.location.internal.ParcelableGeofence;

public abstract interface Geofence
{
  public abstract String getRequestId();

  public static final class Builder
  {
    private String zzEj = null;
    private int zzaQW = 0;
    private long zzaQX = -9223372036854775808L;
    private short zzaQY = -1;
    private double zzaQZ;
    private double zzaRa;
    private float zzaRb;
    private int zzaRc = 0;
    private int zzaRd = -1;

    public Geofence build()
    {
      if (zzEj == null)
        throw new IllegalArgumentException("Request ID not set.");
      if (zzaQW == 0)
        throw new IllegalArgumentException("Transitions types not set.");
      if (((zzaQW & 0x4) != 0) && (zzaRd < 0))
        throw new IllegalArgumentException("Non-negative loitering delay needs to be set when transition types include GEOFENCE_TRANSITION_DWELLING.");
      if (zzaQX == -9223372036854775808L)
        throw new IllegalArgumentException("Expiration not set.");
      if (zzaQY == -1)
        throw new IllegalArgumentException("Geofence region not set.");
      if (zzaRc < 0)
        throw new IllegalArgumentException("Notification responsiveness should be nonnegative.");
      return new ParcelableGeofence(zzEj, zzaQW, (short)1, zzaQZ, zzaRa, zzaRb, zzaQX, zzaRc, zzaRd);
    }

    public Builder setCircularRegion(double paramDouble1, double paramDouble2, float paramFloat)
    {
      zzaQY = 1;
      zzaQZ = paramDouble1;
      zzaRa = paramDouble2;
      zzaRb = paramFloat;
      return this;
    }

    public Builder setExpirationDuration(long paramLong)
    {
      if (paramLong < 0L)
      {
        zzaQX = -1L;
        return this;
      }
      zzaQX = (SystemClock.elapsedRealtime() + paramLong);
      return this;
    }

    public Builder setRequestId(String paramString)
    {
      zzEj = paramString;
      return this;
    }

    public Builder setTransitionTypes(int paramInt)
    {
      zzaQW = paramInt;
      return this;
    }
  }
}
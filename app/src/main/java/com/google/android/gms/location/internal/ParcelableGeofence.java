package com.google.android.gms.location.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.Geofence;
import java.util.Locale;

public class ParcelableGeofence
  implements SafeParcelable, Geofence
{
  public static final zzm CREATOR = new zzm();
  private final int mVersionCode;
  private final String zzEj;
  private final int zzaQW;
  private final short zzaQY;
  private final double zzaQZ;
  private final double zzaRa;
  private final float zzaRb;
  private final int zzaRc;
  private final int zzaRd;
  private final long zzaTV;

  public ParcelableGeofence(int paramInt1, String paramString, int paramInt2, short paramShort, double paramDouble1, double paramDouble2, float paramFloat, long paramLong, int paramInt3, int paramInt4)
  {
    zzdz(paramString);
    zze(paramFloat);
    zzc(paramDouble1, paramDouble2);
    paramInt2 = zzlq(paramInt2);
    mVersionCode = paramInt1;
    zzaQY = paramShort;
    zzEj = paramString;
    zzaQZ = paramDouble1;
    zzaRa = paramDouble2;
    zzaRb = paramFloat;
    zzaTV = paramLong;
    zzaQW = paramInt2;
    zzaRc = paramInt3;
    zzaRd = paramInt4;
  }

  public ParcelableGeofence(String paramString, int paramInt1, short paramShort, double paramDouble1, double paramDouble2, float paramFloat, long paramLong, int paramInt2, int paramInt3)
  {
    this(1, paramString, paramInt1, paramShort, paramDouble1, paramDouble2, paramFloat, paramLong, paramInt2, paramInt3);
  }

  public static ParcelableGeofence zzC(byte[] paramArrayOfByte)
  {
    Parcel localParcel = Parcel.obtain();
    localParcel.unmarshall(paramArrayOfByte, 0, paramArrayOfByte.length);
    localParcel.setDataPosition(0);
    paramArrayOfByte = CREATOR.zzip(localParcel);
    localParcel.recycle();
    return paramArrayOfByte;
  }

  private static void zzc(double paramDouble1, double paramDouble2)
  {
    if ((paramDouble1 > 90.0D) || (paramDouble1 < -90.0D))
      throw new IllegalArgumentException("invalid latitude: " + paramDouble1);
    if ((paramDouble2 > 180.0D) || (paramDouble2 < -180.0D))
      throw new IllegalArgumentException("invalid longitude: " + paramDouble2);
  }

  private static void zzdz(String paramString)
  {
    if ((paramString == null) || (paramString.length() > 100))
      throw new IllegalArgumentException("requestId is null or too long: " + paramString);
  }

  private static void zze(float paramFloat)
  {
    if (paramFloat <= 0.0F)
      throw new IllegalArgumentException("invalid radius: " + paramFloat);
  }

  private static int zzlq(int paramInt)
  {
    int i = paramInt & 0x7;
    if (i == 0)
      throw new IllegalArgumentException("No supported transition specified: " + paramInt);
    return i;
  }

  private static String zzlr(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return null;
    case 1:
    }
    return "CIRCLE";
  }

  public int describeContents()
  {
    zzm localzzm = CREATOR;
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    do
    {
      return true;
      if (paramObject == null)
        return false;
      if (!(paramObject instanceof ParcelableGeofence))
        return false;
      paramObject = (ParcelableGeofence)paramObject;
      if (zzaRb != paramObject.zzaRb)
        return false;
      if (zzaQZ != paramObject.zzaQZ)
        return false;
      if (zzaRa != paramObject.zzaRa)
        return false;
    }
    while (zzaQY == paramObject.zzaQY);
    return false;
  }

  public long getExpirationTime()
  {
    return zzaTV;
  }

  public double getLatitude()
  {
    return zzaQZ;
  }

  public double getLongitude()
  {
    return zzaRa;
  }

  public int getNotificationResponsiveness()
  {
    return zzaRc;
  }

  public String getRequestId()
  {
    return zzEj;
  }

  public int getTransitionTypes()
  {
    return zzaQW;
  }

  public int getVersionCode()
  {
    return mVersionCode;
  }

  public int hashCode()
  {
    long l = Double.doubleToLongBits(zzaQZ);
    int i = (int)(l ^ l >>> 32);
    l = Double.doubleToLongBits(zzaRa);
    return ((((i + 31) * 31 + (int)(l ^ l >>> 32)) * 31 + Float.floatToIntBits(zzaRb)) * 31 + zzaQY) * 31 + zzaQW;
  }

  public String toString()
  {
    return String.format(Locale.US, "Geofence[%s id:%s transitions:%d %.6f, %.6f %.0fm, resp=%ds, dwell=%dms, @%d]", new Object[] { zzlr(zzaQY), zzEj, Integer.valueOf(zzaQW), Double.valueOf(zzaQZ), Double.valueOf(zzaRa), Float.valueOf(zzaRb), Integer.valueOf(zzaRc / 1000), Integer.valueOf(zzaRd), Long.valueOf(zzaTV) });
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzm localzzm = CREATOR;
    zzm.zza(this, paramParcel, paramInt);
  }

  public short zzyT()
  {
    return zzaQY;
  }

  public float zzyU()
  {
    return zzaRb;
  }

  public int zzyV()
  {
    return zzaRd;
  }
}
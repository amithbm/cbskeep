package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class CircleOptions
  implements SafeParcelable
{
  public static final zzb CREATOR = new zzb();
  private final int mVersionCode;
  private boolean zzaYA = true;
  private LatLng zzaYu = null;
  private double zzaYv = 0.0D;
  private float zzaYw = 10.0F;
  private int zzaYx = -16777216;
  private int zzaYy = 0;
  private float zzaYz = 0.0F;

  public CircleOptions()
  {
    mVersionCode = 1;
  }

  CircleOptions(int paramInt1, LatLng paramLatLng, double paramDouble, float paramFloat1, int paramInt2, int paramInt3, float paramFloat2, boolean paramBoolean)
  {
    mVersionCode = paramInt1;
    zzaYu = paramLatLng;
    zzaYv = paramDouble;
    zzaYw = paramFloat1;
    zzaYx = paramInt2;
    zzaYy = paramInt3;
    zzaYz = paramFloat2;
    zzaYA = paramBoolean;
  }

  public int describeContents()
  {
    return 0;
  }

  public LatLng getCenter()
  {
    return zzaYu;
  }

  public int getFillColor()
  {
    return zzaYy;
  }

  public double getRadius()
  {
    return zzaYv;
  }

  public int getStrokeColor()
  {
    return zzaYx;
  }

  public float getStrokeWidth()
  {
    return zzaYw;
  }

  int getVersionCode()
  {
    return mVersionCode;
  }

  public float getZIndex()
  {
    return zzaYz;
  }

  public boolean isVisible()
  {
    return zzaYA;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
}
package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.List;

public final class PolylineOptions
  implements SafeParcelable
{
  public static final zzh CREATOR = new zzh();
  private int mColor = -16777216;
  private final int mVersionCode;
  private boolean zzaYA = true;
  private float zzaYE = 10.0F;
  private final List<LatLng> zzaYZ;
  private float zzaYz = 0.0F;
  private boolean zzaZb = false;

  public PolylineOptions()
  {
    mVersionCode = 1;
    zzaYZ = new ArrayList();
  }

  PolylineOptions(int paramInt1, List paramList, float paramFloat1, int paramInt2, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2)
  {
    mVersionCode = paramInt1;
    zzaYZ = paramList;
    zzaYE = paramFloat1;
    mColor = paramInt2;
    zzaYz = paramFloat2;
    zzaYA = paramBoolean1;
    zzaZb = paramBoolean2;
  }

  public int describeContents()
  {
    return 0;
  }

  public int getColor()
  {
    return mColor;
  }

  public List<LatLng> getPoints()
  {
    return zzaYZ;
  }

  int getVersionCode()
  {
    return mVersionCode;
  }

  public float getWidth()
  {
    return zzaYE;
  }

  public float getZIndex()
  {
    return zzaYz;
  }

  public boolean isGeodesic()
  {
    return zzaZb;
  }

  public boolean isVisible()
  {
    return zzaYA;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzh.zza(this, paramParcel, paramInt);
  }
}
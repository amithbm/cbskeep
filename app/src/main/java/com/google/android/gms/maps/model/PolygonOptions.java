package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.List;

public final class PolygonOptions
  implements SafeParcelable
{
  public static final zzg CREATOR = new zzg();
  private final int mVersionCode;
  private boolean zzaYA = true;
  private final List<LatLng> zzaYZ;
  private float zzaYw = 10.0F;
  private int zzaYx = -16777216;
  private int zzaYy = 0;
  private float zzaYz = 0.0F;
  private final List<List<LatLng>> zzaZa;
  private boolean zzaZb = false;

  public PolygonOptions()
  {
    mVersionCode = 1;
    zzaYZ = new ArrayList();
    zzaZa = new ArrayList();
  }

  PolygonOptions(int paramInt1, List<LatLng> paramList, List paramList1, float paramFloat1, int paramInt2, int paramInt3, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2)
  {
    mVersionCode = paramInt1;
    zzaYZ = paramList;
    zzaZa = paramList1;
    zzaYw = paramFloat1;
    zzaYx = paramInt2;
    zzaYy = paramInt3;
    zzaYz = paramFloat2;
    zzaYA = paramBoolean1;
    zzaZb = paramBoolean2;
  }

  public int describeContents()
  {
    return 0;
  }

  public int getFillColor()
  {
    return zzaYy;
  }

  public List<LatLng> getPoints()
  {
    return zzaYZ;
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
    zzg.zza(this, paramParcel, paramInt);
  }

  List zzzT()
  {
    return zzaZa;
  }
}
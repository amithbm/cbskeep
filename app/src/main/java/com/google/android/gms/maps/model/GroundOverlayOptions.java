package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zzd.zza;

public final class GroundOverlayOptions
  implements SafeParcelable
{
  public static final zzc CREATOR = new zzc();
  private final int mVersionCode;
  private boolean zzaYA = true;
  private BitmapDescriptor zzaYC;
  private LatLng zzaYD;
  private float zzaYE;
  private float zzaYF;
  private LatLngBounds zzaYG;
  private float zzaYH = 0.0F;
  private float zzaYI = 0.5F;
  private float zzaYJ = 0.5F;
  private float zzaYs;
  private float zzaYz;

  public GroundOverlayOptions()
  {
    mVersionCode = 1;
  }

  GroundOverlayOptions(int paramInt, IBinder paramIBinder, LatLng paramLatLng, float paramFloat1, float paramFloat2, LatLngBounds paramLatLngBounds, float paramFloat3, float paramFloat4, boolean paramBoolean, float paramFloat5, float paramFloat6, float paramFloat7)
  {
    mVersionCode = paramInt;
    zzaYC = new BitmapDescriptor(zzd.zza.zzcP(paramIBinder));
    zzaYD = paramLatLng;
    zzaYE = paramFloat1;
    zzaYF = paramFloat2;
    zzaYG = paramLatLngBounds;
    zzaYs = paramFloat3;
    zzaYz = paramFloat4;
    zzaYA = paramBoolean;
    zzaYH = paramFloat5;
    zzaYI = paramFloat6;
    zzaYJ = paramFloat7;
  }

  public int describeContents()
  {
    return 0;
  }

  public float getAnchorU()
  {
    return zzaYI;
  }

  public float getAnchorV()
  {
    return zzaYJ;
  }

  public float getBearing()
  {
    return zzaYs;
  }

  public LatLngBounds getBounds()
  {
    return zzaYG;
  }

  public float getHeight()
  {
    return zzaYF;
  }

  public LatLng getLocation()
  {
    return zzaYD;
  }

  public float getTransparency()
  {
    return zzaYH;
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

  public boolean isVisible()
  {
    return zzaYA;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc.zza(this, paramParcel, paramInt);
  }

  IBinder zzzR()
  {
    return zzaYC.zzzp().asBinder();
  }
}
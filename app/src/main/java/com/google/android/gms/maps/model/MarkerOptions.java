package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zzd.zza;

public final class MarkerOptions
  implements SafeParcelable
{
  public static final zzf CREATOR = new zzf();
  private float mAlpha = 1.0F;
  private final int mVersionCode;
  private LatLng zzaXX;
  private boolean zzaYA = true;
  private float zzaYI = 0.5F;
  private float zzaYJ = 1.0F;
  private String zzaYR;
  private BitmapDescriptor zzaYS;
  private boolean zzaYT;
  private boolean zzaYU = false;
  private float zzaYV = 0.0F;
  private float zzaYW = 0.5F;
  private float zzaYX = 0.0F;
  private String zzasJ;

  public MarkerOptions()
  {
    mVersionCode = 1;
  }

  MarkerOptions(int paramInt, LatLng paramLatLng, String paramString1, String paramString2, IBinder paramIBinder, float paramFloat1, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    mVersionCode = paramInt;
    zzaXX = paramLatLng;
    zzasJ = paramString1;
    zzaYR = paramString2;
    if (paramIBinder == null);
    for (paramLatLng = null; ; paramLatLng = new BitmapDescriptor(zzd.zza.zzcP(paramIBinder)))
    {
      zzaYS = paramLatLng;
      zzaYI = paramFloat1;
      zzaYJ = paramFloat2;
      zzaYT = paramBoolean1;
      zzaYA = paramBoolean2;
      zzaYU = paramBoolean3;
      zzaYV = paramFloat3;
      zzaYW = paramFloat4;
      zzaYX = paramFloat5;
      mAlpha = paramFloat6;
      return;
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public float getAlpha()
  {
    return mAlpha;
  }

  public float getAnchorU()
  {
    return zzaYI;
  }

  public float getAnchorV()
  {
    return zzaYJ;
  }

  public float getInfoWindowAnchorU()
  {
    return zzaYW;
  }

  public float getInfoWindowAnchorV()
  {
    return zzaYX;
  }

  public LatLng getPosition()
  {
    return zzaXX;
  }

  public float getRotation()
  {
    return zzaYV;
  }

  public String getSnippet()
  {
    return zzaYR;
  }

  public String getTitle()
  {
    return zzasJ;
  }

  int getVersionCode()
  {
    return mVersionCode;
  }

  public boolean isDraggable()
  {
    return zzaYT;
  }

  public boolean isFlat()
  {
    return zzaYU;
  }

  public boolean isVisible()
  {
    return zzaYA;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzf.zza(this, paramParcel, paramInt);
  }

  IBinder zzzS()
  {
    if (zzaYS == null)
      return null;
    return zzaYS.zzzp().asBinder();
  }
}
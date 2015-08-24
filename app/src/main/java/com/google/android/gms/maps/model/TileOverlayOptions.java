package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.internal.zzl;
import com.google.android.gms.maps.model.internal.zzl.zza;

public final class TileOverlayOptions
  implements SafeParcelable
{
  public static final zzn CREATOR = new zzn();
  private final int mVersionCode;
  private boolean zzaYA = true;
  private float zzaYz;
  private zzl zzaZf;
  private TileProvider zzaZg;
  private boolean zzaZh = true;

  public TileOverlayOptions()
  {
    mVersionCode = 1;
  }

  TileOverlayOptions(int paramInt, IBinder paramIBinder, boolean paramBoolean1, float paramFloat, boolean paramBoolean2)
  {
    mVersionCode = paramInt;
    zzaZf = zzl.zza.zzfc(paramIBinder);
    if (zzaZf == null);
    for (paramIBinder = null; ; paramIBinder = new TileProvider()
    {
      private final zzl zzaZi = TileOverlayOptions.zza(TileOverlayOptions.this);
    })
    {
      zzaZg = paramIBinder;
      zzaYA = paramBoolean1;
      zzaYz = paramFloat;
      zzaZh = paramBoolean2;
      return;
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean getFadeIn()
  {
    return zzaZh;
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
    zzn.zza(this, paramParcel, paramInt);
  }

  IBinder zzzU()
  {
    return zzaZf.asBinder();
  }
}
package com.google.android.gms.maps;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.zza;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

public final class StreetViewPanoramaOptions
  implements SafeParcelable
{
  public static final zzb CREATOR = new zzb();
  private final int mVersionCode;
  private StreetViewPanoramaCamera zzaXV;
  private String zzaXW;
  private LatLng zzaXX;
  private Integer zzaXY;
  private Boolean zzaXZ = Boolean.valueOf(true);
  private Boolean zzaXj;
  private Boolean zzaXp = Boolean.valueOf(true);
  private Boolean zzaYa = Boolean.valueOf(true);
  private Boolean zzaYb = Boolean.valueOf(true);

  public StreetViewPanoramaOptions()
  {
    mVersionCode = 1;
  }

  StreetViewPanoramaOptions(int paramInt, StreetViewPanoramaCamera paramStreetViewPanoramaCamera, String paramString, LatLng paramLatLng, Integer paramInteger, byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4, byte paramByte5)
  {
    mVersionCode = paramInt;
    zzaXV = paramStreetViewPanoramaCamera;
    zzaXX = paramLatLng;
    zzaXY = paramInteger;
    zzaXW = paramString;
    zzaXZ = zza.zza(paramByte1);
    zzaXp = zza.zza(paramByte2);
    zzaYa = zza.zza(paramByte3);
    zzaYb = zza.zza(paramByte4);
    zzaXj = zza.zza(paramByte5);
  }

  public int describeContents()
  {
    return 0;
  }

  public String getPanoramaId()
  {
    return zzaXW;
  }

  public LatLng getPosition()
  {
    return zzaXX;
  }

  public Integer getRadius()
  {
    return zzaXY;
  }

  public StreetViewPanoramaCamera getStreetViewPanoramaCamera()
  {
    return zzaXV;
  }

  int getVersionCode()
  {
    return mVersionCode;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }

  byte zzzH()
  {
    return zza.zze(zzaXZ);
  }

  byte zzzI()
  {
    return zza.zze(zzaYa);
  }

  byte zzzJ()
  {
    return zza.zze(zzaYb);
  }

  byte zzzt()
  {
    return zza.zze(zzaXj);
  }

  byte zzzx()
  {
    return zza.zze(zzaXp);
  }
}
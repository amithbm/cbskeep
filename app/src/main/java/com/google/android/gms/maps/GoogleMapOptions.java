package com.google.android.gms.maps;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.CameraPosition;

public final class GoogleMapOptions
  implements SafeParcelable
{
  public static final zza CREATOR = new zza();
  private final int mVersionCode;
  private Boolean zzaXi;
  private Boolean zzaXj;
  private int zzaXk = -1;
  private CameraPosition zzaXl;
  private Boolean zzaXm;
  private Boolean zzaXn;
  private Boolean zzaXo;
  private Boolean zzaXp;
  private Boolean zzaXq;
  private Boolean zzaXr;
  private Boolean zzaXs;
  private Boolean zzaXt;

  public GoogleMapOptions()
  {
    mVersionCode = 1;
  }

  GoogleMapOptions(int paramInt1, byte paramByte1, byte paramByte2, int paramInt2, CameraPosition paramCameraPosition, byte paramByte3, byte paramByte4, byte paramByte5, byte paramByte6, byte paramByte7, byte paramByte8, byte paramByte9, byte paramByte10)
  {
    mVersionCode = paramInt1;
    zzaXi = com.google.android.gms.maps.internal.zza.zza(paramByte1);
    zzaXj = com.google.android.gms.maps.internal.zza.zza(paramByte2);
    zzaXk = paramInt2;
    zzaXl = paramCameraPosition;
    zzaXm = com.google.android.gms.maps.internal.zza.zza(paramByte3);
    zzaXn = com.google.android.gms.maps.internal.zza.zza(paramByte4);
    zzaXo = com.google.android.gms.maps.internal.zza.zza(paramByte5);
    zzaXp = com.google.android.gms.maps.internal.zza.zza(paramByte6);
    zzaXq = com.google.android.gms.maps.internal.zza.zza(paramByte7);
    zzaXr = com.google.android.gms.maps.internal.zza.zza(paramByte8);
    zzaXs = com.google.android.gms.maps.internal.zza.zza(paramByte9);
    zzaXt = com.google.android.gms.maps.internal.zza.zza(paramByte10);
  }

  public int describeContents()
  {
    return 0;
  }

  public CameraPosition getCamera()
  {
    return zzaXl;
  }

  public int getMapType()
  {
    return zzaXk;
  }

  int getVersionCode()
  {
    return mVersionCode;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }

  byte zzzA()
  {
    return com.google.android.gms.maps.internal.zza.zze(zzaXs);
  }

  byte zzzB()
  {
    return com.google.android.gms.maps.internal.zza.zze(zzaXt);
  }

  byte zzzs()
  {
    return com.google.android.gms.maps.internal.zza.zze(zzaXi);
  }

  byte zzzt()
  {
    return com.google.android.gms.maps.internal.zza.zze(zzaXj);
  }

  byte zzzu()
  {
    return com.google.android.gms.maps.internal.zza.zze(zzaXm);
  }

  byte zzzv()
  {
    return com.google.android.gms.maps.internal.zza.zze(zzaXn);
  }

  byte zzzw()
  {
    return com.google.android.gms.maps.internal.zza.zze(zzaXo);
  }

  byte zzzx()
  {
    return com.google.android.gms.maps.internal.zza.zze(zzaXp);
  }

  byte zzzy()
  {
    return com.google.android.gms.maps.internal.zza.zze(zzaXq);
  }

  byte zzzz()
  {
    return com.google.android.gms.maps.internal.zza.zze(zzaXr);
  }
}
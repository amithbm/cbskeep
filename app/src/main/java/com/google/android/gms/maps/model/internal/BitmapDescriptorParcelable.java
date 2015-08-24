package com.google.android.gms.maps.model.internal;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class BitmapDescriptorParcelable
  implements SafeParcelable
{
  public static final zza CREATOR = new zza();
  private final int mVersionCode;
  private byte zzaZl;
  private Bundle zzaZm;
  private Bitmap zzaZn;

  BitmapDescriptorParcelable(int paramInt, byte paramByte, Bundle paramBundle, Bitmap paramBitmap)
  {
    mVersionCode = paramInt;
    zzaZl = paramByte;
    zzaZm = paramBundle;
    zzaZn = paramBitmap;
  }

  public int describeContents()
  {
    return 0;
  }

  public Bitmap getBitmap()
  {
    return zzaZn;
  }

  public Bundle getParameters()
  {
    return zzaZm;
  }

  public byte getType()
  {
    return zzaZl;
  }

  public int getVersionCode()
  {
    return mVersionCode;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
}
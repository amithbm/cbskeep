package com.google.android.gms.location.places;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.common.internal.zzu.zza;

public class PlacePhotoResult
  implements Result, SafeParcelable
{
  public static final Parcelable.Creator<PlacePhotoResult> CREATOR = new zzh();
  private final Bitmap mBitmap;
  final int mVersionCode;
  private final Status zzOQ;
  final BitmapTeleporter zzaUv;

  PlacePhotoResult(int paramInt, Status paramStatus, BitmapTeleporter paramBitmapTeleporter)
  {
    mVersionCode = paramInt;
    zzOQ = paramStatus;
    zzaUv = paramBitmapTeleporter;
    if (zzaUv != null)
    {
      mBitmap = paramBitmapTeleporter.get();
      return;
    }
    mBitmap = null;
  }

  public int describeContents()
  {
    return 0;
  }

  public Status getStatus()
  {
    return zzOQ;
  }

  public String toString()
  {
    return zzu.zzy(this).zzc("status", zzOQ).zzc("bitmap", mBitmap).toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzh.zza(this, paramParcel, paramInt);
  }
}
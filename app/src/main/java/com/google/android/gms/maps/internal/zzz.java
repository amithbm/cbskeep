package com.google.android.gms.maps.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzz
  implements Parcelable.Creator<Point>
{
  static void zza(Point paramPoint, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, paramPoint.getVersionCode());
    zzb.zza(paramParcel, 2, paramPoint.zzzP(), paramInt, false);
    zzb.zzJ(paramParcel, i);
  }

  public Point zziV(Parcel paramParcel)
  {
    int j = zza.zzcQ(paramParcel);
    int i = 0;
    android.graphics.Point localPoint = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = zza.zzcP(paramParcel);
      switch (zza.zzeS(k))
      {
      default:
        zza.zzb(paramParcel, k);
        break;
      case 1:
        i = zza.zzg(paramParcel, k);
        break;
      case 2:
        localPoint = (android.graphics.Point)zza.zza(paramParcel, k, android.graphics.Point.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new Point(i, localPoint);
  }

  public Point[] zzmg(int paramInt)
  {
    return new Point[paramInt];
  }
}
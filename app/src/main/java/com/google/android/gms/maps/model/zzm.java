package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzm
  implements Parcelable.Creator<Tile>
{
  static void zza(Tile paramTile, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, paramTile.getVersionCode());
    zzb.zzc(paramParcel, 2, width);
    zzb.zzc(paramParcel, 3, height);
    zzb.zza(paramParcel, 4, data, false);
    zzb.zzJ(paramParcel, paramInt);
  }

  public Tile zzji(Parcel paramParcel)
  {
    int k = 0;
    int m = zza.zzcQ(paramParcel);
    byte[] arrayOfByte = null;
    int j = 0;
    int i = 0;
    while (paramParcel.dataPosition() < m)
    {
      int n = zza.zzcP(paramParcel);
      switch (zza.zzeS(n))
      {
      default:
        zza.zzb(paramParcel, n);
        break;
      case 1:
        i = zza.zzg(paramParcel, n);
        break;
      case 2:
        j = zza.zzg(paramParcel, n);
        break;
      case 3:
        k = zza.zzg(paramParcel, n);
        break;
      case 4:
        arrayOfByte = zza.zzs(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m)
      throw new zza.zza("Overread allowed size end=" + m, paramParcel);
    return new Tile(i, j, k, arrayOfByte);
  }

  public Tile[] zzmt(int paramInt)
  {
    return new Tile[paramInt];
  }
}
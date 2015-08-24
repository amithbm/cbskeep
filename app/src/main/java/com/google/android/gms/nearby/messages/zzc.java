package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc
  implements Parcelable.Creator<Strategy>
{
  static void zza(Strategy paramStrategy, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, zzbaZ);
    zzb.zzc(paramParcel, 1000, versionCode);
    zzb.zzc(paramParcel, 2, zzbba);
    zzb.zzc(paramParcel, 3, zzbbb);
    zzb.zza(paramParcel, 4, zzbbc);
    zzb.zzc(paramParcel, 5, zzbbd);
    zzb.zzc(paramParcel, 6, zzbbe);
    zzb.zzJ(paramParcel, paramInt);
  }

  public Strategy zzjC(Parcel paramParcel)
  {
    int i = 0;
    int i2 = zza.zzcQ(paramParcel);
    int j = 0;
    boolean bool = false;
    int k = 0;
    int m = 0;
    int n = 0;
    int i1 = 0;
    while (paramParcel.dataPosition() < i2)
    {
      int i3 = zza.zzcP(paramParcel);
      switch (zza.zzeS(i3))
      {
      default:
        zza.zzb(paramParcel, i3);
        break;
      case 1:
        n = zza.zzg(paramParcel, i3);
        break;
      case 1000:
        i1 = zza.zzg(paramParcel, i3);
        break;
      case 2:
        m = zza.zzg(paramParcel, i3);
        break;
      case 3:
        k = zza.zzg(paramParcel, i3);
        break;
      case 4:
        bool = zza.zzc(paramParcel, i3);
        break;
      case 5:
        j = zza.zzg(paramParcel, i3);
        break;
      case 6:
        i = zza.zzg(paramParcel, i3);
      }
    }
    if (paramParcel.dataPosition() != i2)
      throw new zza.zza("Overread allowed size end=" + i2, paramParcel);
    return new Strategy(i1, n, m, k, bool, j, i);
  }

  public Strategy[] zzmV(int paramInt)
  {
    return new Strategy[paramInt];
  }
}
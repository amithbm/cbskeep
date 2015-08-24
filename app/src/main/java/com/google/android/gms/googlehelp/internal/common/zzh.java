package com.google.android.gms.googlehelp.internal.common;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzh
  implements Parcelable.Creator<OverflowMenuItem>
{
  static void zza(OverflowMenuItem paramOverflowMenuItem, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zzc(paramParcel, 2, mId);
    zzb.zza(paramParcel, 3, zzasJ, false);
    zzb.zza(paramParcel, 4, mIntent, paramInt, false);
    zzb.zzJ(paramParcel, i);
  }

  public OverflowMenuItem zzhB(Parcel paramParcel)
  {
    Intent localIntent = null;
    int j = 0;
    int k = zza.zzcQ(paramParcel);
    String str = null;
    int i = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = zza.zzcP(paramParcel);
      switch (zza.zzeS(m))
      {
      default:
        zza.zzb(paramParcel, m);
        break;
      case 1:
        i = zza.zzg(paramParcel, m);
        break;
      case 2:
        j = zza.zzg(paramParcel, m);
        break;
      case 3:
        str = zza.zzp(paramParcel, m);
        break;
      case 4:
        localIntent = (Intent)zza.zza(paramParcel, m, Intent.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != k)
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    return new OverflowMenuItem(i, j, str, localIntent);
  }

  public OverflowMenuItem[] zzku(int paramInt)
  {
    return new OverflowMenuItem[paramInt];
  }
}
package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzk
  implements Parcelable.Creator<ChannelEventParcelable>
{
  static void zza(ChannelEventParcelable paramChannelEventParcelable, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zza(paramParcel, 2, zzbHo, paramInt, false);
    zzb.zzc(paramParcel, 3, type);
    zzb.zzc(paramParcel, 4, zzbHm);
    zzb.zzc(paramParcel, 5, zzbHn);
    zzb.zzJ(paramParcel, i);
  }

  public ChannelEventParcelable zznj(Parcel paramParcel)
  {
    int i = 0;
    int n = zza.zzcQ(paramParcel);
    ChannelImpl localChannelImpl = null;
    int j = 0;
    int k = 0;
    int m = 0;
    while (paramParcel.dataPosition() < n)
    {
      int i1 = zza.zzcP(paramParcel);
      switch (zza.zzeS(i1))
      {
      default:
        zza.zzb(paramParcel, i1);
        break;
      case 1:
        m = zza.zzg(paramParcel, i1);
        break;
      case 2:
        localChannelImpl = (ChannelImpl)zza.zza(paramParcel, i1, ChannelImpl.CREATOR);
        break;
      case 3:
        k = zza.zzg(paramParcel, i1);
        break;
      case 4:
        j = zza.zzg(paramParcel, i1);
        break;
      case 5:
        i = zza.zzg(paramParcel, i1);
      }
    }
    if (paramParcel.dataPosition() != n)
      throw new zza.zza("Overread allowed size end=" + n, paramParcel);
    return new ChannelEventParcelable(m, localChannelImpl, k, j, i);
  }

  public ChannelEventParcelable[] zzrn(int paramInt)
  {
    return new ChannelEventParcelable[paramInt];
  }
}
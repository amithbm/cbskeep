package com.google.android.gms.location.copresence.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzm
  implements Parcelable.Creator<StrategyImpl>
{
  static void zza(StrategyImpl paramStrategyImpl, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, paramStrategyImpl.getVersionCode());
    zzb.zza(paramParcel, 2, paramStrategyImpl.isActive());
    zzb.zzc(paramParcel, 4, paramStrategyImpl.zzyH());
    zzb.zza(paramParcel, 5, paramStrategyImpl.zzyI());
    zzb.zzc(paramParcel, 8, paramStrategyImpl.zzyJ());
    zzb.zzJ(paramParcel, paramInt);
  }

  public StrategyImpl zzii(Parcel paramParcel)
  {
    int i = 0;
    int m = zza.zzcQ(paramParcel);
    boolean bool1 = false;
    int j = 0;
    boolean bool2 = false;
    int k = 0;
    while (paramParcel.dataPosition() < m)
    {
      int n = zza.zzcP(paramParcel);
      switch (zza.zzeS(n))
      {
      case 3:
      case 6:
      case 7:
      default:
        zza.zzb(paramParcel, n);
        break;
      case 1:
        k = zza.zzg(paramParcel, n);
        break;
      case 2:
        bool2 = zza.zzc(paramParcel, n);
        break;
      case 4:
        j = zza.zzg(paramParcel, n);
        break;
      case 5:
        bool1 = zza.zzc(paramParcel, n);
        break;
      case 8:
        i = zza.zzg(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m)
      throw new zza.zza("Overread allowed size end=" + m, paramParcel);
    return new StrategyImpl(k, bool2, j, bool1, i);
  }

  public StrategyImpl[] zzlj(int paramInt)
  {
    return new StrategyImpl[paramInt];
  }
}
package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzai
  implements Parcelable.Creator<ParcelableIndexReference>
{
  static void zza(ParcelableIndexReference paramParcelableIndexReference, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zza(paramParcel, 2, zzazO, false);
    zzb.zzc(paramParcel, 3, mIndex);
    zzb.zza(paramParcel, 4, zzazP);
    zzb.zzc(paramParcel, 5, zzazQ);
    zzb.zzJ(paramParcel, paramInt);
  }

  public ParcelableIndexReference zzfr(Parcel paramParcel)
  {
    boolean bool = false;
    int m = zza.zzcQ(paramParcel);
    String str = null;
    int i = -1;
    int j = 0;
    int k = 0;
    while (paramParcel.dataPosition() < m)
    {
      int n = zza.zzcP(paramParcel);
      switch (zza.zzeS(n))
      {
      default:
        zza.zzb(paramParcel, n);
        break;
      case 1:
        k = zza.zzg(paramParcel, n);
        break;
      case 2:
        str = zza.zzp(paramParcel, n);
        break;
      case 3:
        j = zza.zzg(paramParcel, n);
        break;
      case 4:
        bool = zza.zzc(paramParcel, n);
        break;
      case 5:
        i = zza.zzg(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m)
      throw new zza.zza("Overread allowed size end=" + m, paramParcel);
    return new ParcelableIndexReference(k, str, j, bool, i);
  }

  public ParcelableIndexReference[] zzhN(int paramInt)
  {
    return new ParcelableIndexReference[paramInt];
  }
}
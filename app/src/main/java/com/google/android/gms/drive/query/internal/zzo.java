package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzo
  implements Parcelable.Creator<OwnedByMeFilter>
{
  static void zza(OwnedByMeFilter paramOwnedByMeFilter, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1000, mVersionCode);
    zzb.zzJ(paramParcel, paramInt);
  }

  public OwnedByMeFilter zzfn(Parcel paramParcel)
  {
    int j = zza.zzcQ(paramParcel);
    int i = 0;
    while (paramParcel.dataPosition() < j)
    {
      int k = zza.zzcP(paramParcel);
      switch (zza.zzeS(k))
      {
      default:
        zza.zzb(paramParcel, k);
        break;
      case 1000:
        i = zza.zzg(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new OwnedByMeFilter(i);
  }

  public OwnedByMeFilter[] zzhH(int paramInt)
  {
    return new OwnedByMeFilter[paramInt];
  }
}
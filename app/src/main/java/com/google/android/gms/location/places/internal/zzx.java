package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzx
  implements Parcelable.Creator<AutocompletePredictionEntity.SubstringEntity>
{
  static void zza(AutocompletePredictionEntity.SubstringEntity paramSubstringEntity, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, mOffset);
    zzb.zzc(paramParcel, 1000, mVersionCode);
    zzb.zzc(paramParcel, 2, mLength);
    zzb.zzJ(paramParcel, paramInt);
  }

  public AutocompletePredictionEntity.SubstringEntity zziG(Parcel paramParcel)
  {
    int k = 0;
    int m = zza.zzcQ(paramParcel);
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
        j = zza.zzg(paramParcel, n);
        break;
      case 1000:
        i = zza.zzg(paramParcel, n);
        break;
      case 2:
        k = zza.zzg(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m)
      throw new zza.zza("Overread allowed size end=" + m, paramParcel);
    return new AutocompletePredictionEntity.SubstringEntity(i, j, k);
  }

  public AutocompletePredictionEntity.SubstringEntity[] zzlN(int paramInt)
  {
    return new AutocompletePredictionEntity.SubstringEntity[paramInt];
  }
}
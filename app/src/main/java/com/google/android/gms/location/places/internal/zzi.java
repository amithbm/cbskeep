package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzi
  implements Parcelable.Creator<NearbyLikelihoodEntity>
{
  static void zza(NearbyLikelihoodEntity paramNearbyLikelihoodEntity, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zza(paramParcel, 1, zzaVf, paramInt, false);
    zzb.zzc(paramParcel, 1000, mVersionCode);
    zzb.zza(paramParcel, 2, zzaVg);
    zzb.zzJ(paramParcel, i);
  }

  public NearbyLikelihoodEntity zziB(Parcel paramParcel)
  {
    int j = zza.zzcQ(paramParcel);
    int i = 0;
    PlaceImpl localPlaceImpl = null;
    float f = 0.0F;
    if (paramParcel.dataPosition() < j)
    {
      int k = zza.zzcP(paramParcel);
      switch (zza.zzeS(k))
      {
      default:
        zza.zzb(paramParcel, k);
      case 1:
      case 1000:
      case 2:
      }
      while (true)
      {
        break;
        localPlaceImpl = (PlaceImpl)zza.zza(paramParcel, k, PlaceImpl.CREATOR);
        continue;
        i = zza.zzg(paramParcel, k);
        continue;
        f = zza.zzl(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new NearbyLikelihoodEntity(i, localPlaceImpl, f);
  }

  public NearbyLikelihoodEntity[] zzlH(int paramInt)
  {
    return new NearbyLikelihoodEntity[paramInt];
  }
}
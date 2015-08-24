package com.google.android.gms.reminders.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzj
  implements Parcelable.Creator<LocationGroupEntity>
{
  static void zza(LocationGroupEntity paramLocationGroupEntity, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zza(paramParcel, 2, paramLocationGroupEntity.getLocationQuery(), false);
    zzb.zza(paramParcel, 3, paramLocationGroupEntity.getLocationQueryType(), false);
    zzb.zza(paramParcel, 5, paramLocationGroupEntity.getChainInfo(), paramInt, false);
    zzb.zza(paramParcel, 6, paramLocationGroupEntity.getCategoryInfo(), paramInt, false);
    zzb.zzJ(paramParcel, i);
  }

  public LocationGroupEntity zzkO(Parcel paramParcel)
  {
    CategoryInfoEntity localCategoryInfoEntity = null;
    int j = zza.zzcQ(paramParcel);
    int i = 0;
    ChainInfoEntity localChainInfoEntity = null;
    Integer localInteger = null;
    String str = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = zza.zzcP(paramParcel);
      switch (zza.zzeS(k))
      {
      case 4:
      default:
        zza.zzb(paramParcel, k);
        break;
      case 1:
        i = zza.zzg(paramParcel, k);
        break;
      case 2:
        str = zza.zzp(paramParcel, k);
        break;
      case 3:
        localInteger = zza.zzh(paramParcel, k);
        break;
      case 5:
        localChainInfoEntity = (ChainInfoEntity)zza.zza(paramParcel, k, ChainInfoEntity.CREATOR);
        break;
      case 6:
        localCategoryInfoEntity = (CategoryInfoEntity)zza.zza(paramParcel, k, CategoryInfoEntity.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new LocationGroupEntity(i, str, localInteger, localChainInfoEntity, localCategoryInfoEntity);
  }

  public LocationGroupEntity[] zzos(int paramInt)
  {
    return new LocationGroupEntity[paramInt];
  }
}
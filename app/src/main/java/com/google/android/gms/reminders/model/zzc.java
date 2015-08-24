package com.google.android.gms.reminders.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc
  implements Parcelable.Creator<ChainInfoEntity>
{
  static void zza(ChainInfoEntity paramChainInfoEntity, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zza(paramParcel, 3, paramChainInfoEntity.getChainName(), false);
    zzb.zza(paramParcel, 4, paramChainInfoEntity.getChainId(), paramInt, false);
    zzb.zzJ(paramParcel, i);
  }

  public ChainInfoEntity zzkH(Parcel paramParcel)
  {
    FeatureIdProtoEntity localFeatureIdProtoEntity = null;
    int j = zza.zzcQ(paramParcel);
    int i = 0;
    String str = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = zza.zzcP(paramParcel);
      switch (zza.zzeS(k))
      {
      case 2:
      default:
        zza.zzb(paramParcel, k);
        break;
      case 1:
        i = zza.zzg(paramParcel, k);
        break;
      case 3:
        str = zza.zzp(paramParcel, k);
        break;
      case 4:
        localFeatureIdProtoEntity = (FeatureIdProtoEntity)zza.zza(paramParcel, k, FeatureIdProtoEntity.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new ChainInfoEntity(i, str, localFeatureIdProtoEntity);
  }

  public ChainInfoEntity[] zzol(int paramInt)
  {
    return new ChainInfoEntity[paramInt];
  }
}
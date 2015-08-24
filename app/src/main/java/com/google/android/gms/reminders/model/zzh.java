package com.google.android.gms.reminders.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzh
  implements Parcelable.Creator<FeatureIdProtoEntity>
{
  static void zza(FeatureIdProtoEntity paramFeatureIdProtoEntity, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zza(paramParcel, 2, paramFeatureIdProtoEntity.getCellId(), false);
    zzb.zza(paramParcel, 3, paramFeatureIdProtoEntity.getFprint(), false);
    zzb.zzJ(paramParcel, paramInt);
  }

  public FeatureIdProtoEntity zzkM(Parcel paramParcel)
  {
    Long localLong2 = null;
    int j = zza.zzcQ(paramParcel);
    int i = 0;
    Long localLong1 = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = zza.zzcP(paramParcel);
      switch (zza.zzeS(k))
      {
      default:
        zza.zzb(paramParcel, k);
        break;
      case 1:
        i = zza.zzg(paramParcel, k);
        break;
      case 2:
        localLong1 = zza.zzj(paramParcel, k);
        break;
      case 3:
        localLong2 = zza.zzj(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new FeatureIdProtoEntity(i, localLong1, localLong2);
  }

  public FeatureIdProtoEntity[] zzoq(int paramInt)
  {
    return new FeatureIdProtoEntity[paramInt];
  }
}
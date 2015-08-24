package com.google.android.gms.reminders.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzi
  implements Parcelable.Creator<LocationEntity>
{
  static void zza(LocationEntity paramLocationEntity, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zza(paramParcel, 2, paramLocationEntity.getLat(), false);
    zzb.zza(paramParcel, 3, paramLocationEntity.getLng(), false);
    zzb.zza(paramParcel, 4, paramLocationEntity.getName(), false);
    zzb.zza(paramParcel, 5, paramLocationEntity.getRadiusMeters(), false);
    zzb.zza(paramParcel, 6, paramLocationEntity.getLocationType(), false);
    zzb.zza(paramParcel, 7, paramLocationEntity.getGeoFeatureId(), paramInt, false);
    zzb.zza(paramParcel, 8, paramLocationEntity.getDisplayAddress(), false);
    zzb.zza(paramParcel, 9, paramLocationEntity.getLocationAliasId(), false);
    zzb.zza(paramParcel, 10, paramLocationEntity.getAddress(), paramInt, false);
    zzb.zzJ(paramParcel, i);
  }

  public LocationEntity zzkN(Parcel paramParcel)
  {
    String str1 = null;
    int j = zza.zzcQ(paramParcel);
    int i = 0;
    AddressEntity localAddressEntity = null;
    String str2 = null;
    FeatureIdProtoEntity localFeatureIdProtoEntity = null;
    Integer localInteger1 = null;
    Integer localInteger2 = null;
    String str3 = null;
    Double localDouble1 = null;
    Double localDouble2 = null;
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
        localDouble2 = zza.zzn(paramParcel, k);
        break;
      case 3:
        localDouble1 = zza.zzn(paramParcel, k);
        break;
      case 4:
        str3 = zza.zzp(paramParcel, k);
        break;
      case 5:
        localInteger2 = zza.zzh(paramParcel, k);
        break;
      case 6:
        localInteger1 = zza.zzh(paramParcel, k);
        break;
      case 7:
        localFeatureIdProtoEntity = (FeatureIdProtoEntity)zza.zza(paramParcel, k, FeatureIdProtoEntity.CREATOR);
        break;
      case 8:
        str2 = zza.zzp(paramParcel, k);
        break;
      case 9:
        str1 = zza.zzp(paramParcel, k);
        break;
      case 10:
        localAddressEntity = (AddressEntity)zza.zza(paramParcel, k, AddressEntity.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new LocationEntity(i, localDouble2, localDouble1, str3, localInteger2, localInteger1, localFeatureIdProtoEntity, str2, localAddressEntity, str1);
  }

  public LocationEntity[] zzor(int paramInt)
  {
    return new LocationEntity[paramInt];
  }
}
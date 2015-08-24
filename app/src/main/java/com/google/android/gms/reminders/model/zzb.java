package com.google.android.gms.reminders.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;

public class zzb
  implements Parcelable.Creator<CategoryInfoEntity>
{
  static void zza(CategoryInfoEntity paramCategoryInfoEntity, Parcel paramParcel, int paramInt)
  {
    paramInt = com.google.android.gms.common.internal.safeparcel.zzb.zzcR(paramParcel);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 1, mVersionCode);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 2, paramCategoryInfoEntity.getCategoryId(), false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 3, paramCategoryInfoEntity.getDisplayName(), false);
    com.google.android.gms.common.internal.safeparcel.zzb.zzJ(paramParcel, paramInt);
  }

  public CategoryInfoEntity zzkG(Parcel paramParcel)
  {
    String str2 = null;
    int j = zza.zzcQ(paramParcel);
    int i = 0;
    String str1 = null;
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
        str1 = zza.zzp(paramParcel, k);
        break;
      case 3:
        str2 = zza.zzp(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new CategoryInfoEntity(i, str1, str2);
  }

  public CategoryInfoEntity[] zzok(int paramInt)
  {
    return new CategoryInfoEntity[paramInt];
  }
}
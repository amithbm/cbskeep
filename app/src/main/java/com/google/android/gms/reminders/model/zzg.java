package com.google.android.gms.reminders.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzg
  implements Parcelable.Creator<ExternalApplicationLinkEntity>
{
  static void zza(ExternalApplicationLinkEntity paramExternalApplicationLinkEntity, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zza(paramParcel, 2, paramExternalApplicationLinkEntity.getApplication(), false);
    zzb.zza(paramParcel, 3, paramExternalApplicationLinkEntity.getId(), false);
    zzb.zzJ(paramParcel, paramInt);
  }

  public ExternalApplicationLinkEntity zzkL(Parcel paramParcel)
  {
    String str = null;
    int j = zza.zzcQ(paramParcel);
    int i = 0;
    Integer localInteger = null;
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
        localInteger = zza.zzh(paramParcel, k);
        break;
      case 3:
        str = zza.zzp(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new ExternalApplicationLinkEntity(i, localInteger, str);
  }

  public ExternalApplicationLinkEntity[] zzop(int paramInt)
  {
    return new ExternalApplicationLinkEntity[paramInt];
  }
}
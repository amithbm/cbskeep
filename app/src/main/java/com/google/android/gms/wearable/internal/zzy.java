package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzy
  implements Parcelable.Creator<DataItemAssetParcelable>
{
  static void zza(DataItemAssetParcelable paramDataItemAssetParcelable, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zza(paramParcel, 2, paramDataItemAssetParcelable.getId(), false);
    zzb.zza(paramParcel, 3, paramDataItemAssetParcelable.getDataItemKey(), false);
    zzb.zzJ(paramParcel, paramInt);
  }

  public DataItemAssetParcelable zzno(Parcel paramParcel)
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
    return new DataItemAssetParcelable(i, str1, str2);
  }

  public DataItemAssetParcelable[] zzrt(int paramInt)
  {
    return new DataItemAssetParcelable[paramInt];
  }
}
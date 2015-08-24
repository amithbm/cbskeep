package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzf
  implements Parcelable.Creator<FACLData>
{
  static void zza(FACLData paramFACLData, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, version);
    zzb.zza(paramParcel, 2, zzUg, paramInt, false);
    zzb.zza(paramParcel, 3, zzUh, false);
    zzb.zza(paramParcel, 4, zzUi);
    zzb.zza(paramParcel, 5, zzUj, false);
    zzb.zzJ(paramParcel, i);
  }

  public FACLData zzbF(Parcel paramParcel)
  {
    boolean bool = false;
    String str1 = null;
    int j = zza.zzcQ(paramParcel);
    String str2 = null;
    FACLConfig localFACLConfig = null;
    int i = 0;
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
        localFACLConfig = (FACLConfig)zza.zza(paramParcel, k, FACLConfig.CREATOR);
        break;
      case 3:
        str2 = zza.zzp(paramParcel, k);
        break;
      case 4:
        bool = zza.zzc(paramParcel, k);
        break;
      case 5:
        str1 = zza.zzp(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new FACLData(i, localFACLConfig, str2, bool, str1);
  }

  public FACLData[] zzcB(int paramInt)
  {
    return new FACLData[paramInt];
  }
}
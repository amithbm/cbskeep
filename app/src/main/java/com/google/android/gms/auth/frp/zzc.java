package com.google.android.gms.auth.frp;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc
  implements Parcelable.Creator<UnlockFactoryResetProtectionResponse>
{
  static void zza(UnlockFactoryResetProtectionResponse paramUnlockFactoryResetProtectionResponse, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, version);
    zzb.zzc(paramParcel, 2, status);
    zzb.zzJ(paramParcel, paramInt);
  }

  public UnlockFactoryResetProtectionResponse zzbL(Parcel paramParcel)
  {
    int j = 0;
    int k = zza.zzcQ(paramParcel);
    int i = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = zza.zzcP(paramParcel);
      switch (zza.zzeS(m))
      {
      default:
        zza.zzb(paramParcel, m);
        break;
      case 1:
        i = zza.zzg(paramParcel, m);
        break;
      case 2:
        j = zza.zzg(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k)
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    return new UnlockFactoryResetProtectionResponse(i, j);
  }

  public UnlockFactoryResetProtectionResponse[] zzcH(int paramInt)
  {
    return new UnlockFactoryResetProtectionResponse[paramInt];
  }
}
package com.google.android.gms.nearby.sharing.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzo
  implements Parcelable.Creator<TrustedDevicesRequest>
{
  static void zza(TrustedDevicesRequest paramTrustedDevicesRequest, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, versionCode);
    zzb.zza(paramParcel, 2, zzbbP, false);
    zzb.zza(paramParcel, 3, zzbbQ, false);
    zzb.zza(paramParcel, 4, paramTrustedDevicesRequest.zzAv(), false);
    zzb.zzJ(paramParcel, paramInt);
  }

  public TrustedDevicesRequest zzjQ(Parcel paramParcel)
  {
    IBinder localIBinder = null;
    int j = zza.zzcQ(paramParcel);
    int i = 0;
    byte[] arrayOfByte = null;
    String str = null;
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
        str = zza.zzp(paramParcel, k);
        break;
      case 3:
        arrayOfByte = zza.zzs(paramParcel, k);
        break;
      case 4:
        localIBinder = zza.zzq(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new TrustedDevicesRequest(i, str, arrayOfByte, localIBinder);
  }

  public TrustedDevicesRequest[] zznj(int paramInt)
  {
    return new TrustedDevicesRequest[paramInt];
  }
}
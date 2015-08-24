package com.google.android.gms.location.copresence.debug;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza
  implements Parcelable.Creator<CopresenceDebugPokeRequest>
{
  static void zza(CopresenceDebugPokeRequest paramCopresenceDebugPokeRequest, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, paramCopresenceDebugPokeRequest.getCommand());
    zzb.zzc(paramParcel, 1000, paramCopresenceDebugPokeRequest.getVersionCode());
    zzb.zza(paramParcel, 4, paramCopresenceDebugPokeRequest.getProtoData(), false);
    zzb.zza(paramParcel, 5, paramCopresenceDebugPokeRequest.zzyC(), false);
    zzb.zzJ(paramParcel, paramInt);
  }

  public CopresenceDebugPokeRequest zzia(Parcel paramParcel)
  {
    IBinder localIBinder = null;
    int j = 0;
    int k = com.google.android.gms.common.internal.safeparcel.zza.zzcQ(paramParcel);
    byte[] arrayOfByte = null;
    int i = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = com.google.android.gms.common.internal.safeparcel.zza.zzcP(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.zza.zzeS(m))
      {
      default:
        com.google.android.gms.common.internal.safeparcel.zza.zzb(paramParcel, m);
        break;
      case 1:
        j = com.google.android.gms.common.internal.safeparcel.zza.zzg(paramParcel, m);
        break;
      case 1000:
        i = com.google.android.gms.common.internal.safeparcel.zza.zzg(paramParcel, m);
        break;
      case 4:
        arrayOfByte = com.google.android.gms.common.internal.safeparcel.zza.zzs(paramParcel, m);
        break;
      case 5:
        localIBinder = com.google.android.gms.common.internal.safeparcel.zza.zzq(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k)
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    return new CopresenceDebugPokeRequest(i, j, arrayOfByte, localIBinder);
  }

  public CopresenceDebugPokeRequest[] zzlb(int paramInt)
  {
    return new CopresenceDebugPokeRequest[paramInt];
  }
}
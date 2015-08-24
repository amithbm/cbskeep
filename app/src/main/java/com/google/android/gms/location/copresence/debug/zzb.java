package com.google.android.gms.location.copresence.debug;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;

public class zzb
  implements Parcelable.Creator<CopresenceDebugPokeResponse>
{
  static void zza(CopresenceDebugPokeResponse paramCopresenceDebugPokeResponse, Parcel paramParcel, int paramInt)
  {
    paramInt = com.google.android.gms.common.internal.safeparcel.zzb.zzcR(paramParcel);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 1, paramCopresenceDebugPokeResponse.getProtoData(), false);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 1000, paramCopresenceDebugPokeResponse.getVersionCode());
    com.google.android.gms.common.internal.safeparcel.zzb.zzJ(paramParcel, paramInt);
  }

  public CopresenceDebugPokeResponse zzib(Parcel paramParcel)
  {
    int j = zza.zzcQ(paramParcel);
    int i = 0;
    byte[] arrayOfByte = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = zza.zzcP(paramParcel);
      switch (zza.zzeS(k))
      {
      default:
        zza.zzb(paramParcel, k);
        break;
      case 1:
        arrayOfByte = zza.zzs(paramParcel, k);
        break;
      case 1000:
        i = zza.zzg(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new CopresenceDebugPokeResponse(i, arrayOfByte);
  }

  public CopresenceDebugPokeResponse[] zzlc(int paramInt)
  {
    return new CopresenceDebugPokeResponse[paramInt];
  }
}
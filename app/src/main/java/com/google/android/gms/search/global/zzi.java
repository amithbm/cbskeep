package com.google.android.gms.search.global;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzi
  implements Parcelable.Creator<SetExperimentIdsCall.Request>
{
  static void zza(SetExperimentIdsCall.Request paramRequest, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1000, mVersionCode);
    zzb.zza(paramParcel, 1, serializedExperimentConfig, false);
    zzb.zza(paramParcel, 2, emergency);
    zzb.zzJ(paramParcel, paramInt);
  }

  public SetExperimentIdsCall.Request zzlw(Parcel paramParcel)
  {
    boolean bool = false;
    int j = zza.zzcQ(paramParcel);
    byte[] arrayOfByte = null;
    int i = 0;
    while (paramParcel.dataPosition() < j)
    {
      int k = zza.zzcP(paramParcel);
      switch (zza.zzeS(k))
      {
      default:
        zza.zzb(paramParcel, k);
        break;
      case 1000:
        i = zza.zzg(paramParcel, k);
        break;
      case 1:
        arrayOfByte = zza.zzs(paramParcel, k);
        break;
      case 2:
        bool = zza.zzc(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new SetExperimentIdsCall.Request(i, arrayOfByte, bool);
  }

  public SetExperimentIdsCall.Request[] zzpa(int paramInt)
  {
    return new SetExperimentIdsCall.Request[paramInt];
  }
}
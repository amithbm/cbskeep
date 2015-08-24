package com.google.android.gms.search.global;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzj
  implements Parcelable.Creator<SetExperimentIdsCall.Response>
{
  static void zza(SetExperimentIdsCall.Response paramResponse, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1000, mVersionCode);
    zzb.zza(paramParcel, 1, status, paramInt, false);
    zzb.zzJ(paramParcel, i);
  }

  public SetExperimentIdsCall.Response zzlx(Parcel paramParcel)
  {
    int j = zza.zzcQ(paramParcel);
    int i = 0;
    Status localStatus = null;
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
        localStatus = (Status)zza.zza(paramParcel, k, Status.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new SetExperimentIdsCall.Response(i, localStatus);
  }

  public SetExperimentIdsCall.Response[] zzpb(int paramInt)
  {
    return new SetExperimentIdsCall.Response[paramInt];
  }
}
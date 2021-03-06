package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzs
  implements Parcelable.Creator<GetAndAdvanceOtpCounterResponse>
{
  static void zza(GetAndAdvanceOtpCounterResponse paramGetAndAdvanceOtpCounterResponse, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, mVersion);
    zzb.zza(paramParcel, 2, counter, false);
    zzb.zzJ(paramParcel, paramInt);
  }

  public GetAndAdvanceOtpCounterResponse zzaW(Parcel paramParcel)
  {
    int j = zza.zzcQ(paramParcel);
    int i = 0;
    Long localLong = null;
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
        localLong = zza.zzj(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new GetAndAdvanceOtpCounterResponse(i, localLong);
  }

  public GetAndAdvanceOtpCounterResponse[] zzbS(int paramInt)
  {
    return new GetAndAdvanceOtpCounterResponse[paramInt];
  }
}
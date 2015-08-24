package com.google.android.gms.search.ime;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.appdatasearch.PIMEUpdateResponse;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzd
  implements Parcelable.Creator<GetIMEUpdatesCall.Response>
{
  static void zza(GetIMEUpdatesCall.Response paramResponse, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1000, mVersionCode);
    zzb.zza(paramParcel, 1, status, paramInt, false);
    zzb.zza(paramParcel, 2, pimeUpdateResponse, paramInt, false);
    zzb.zzJ(paramParcel, i);
  }

  public GetIMEUpdatesCall.Response zzlD(Parcel paramParcel)
  {
    PIMEUpdateResponse localPIMEUpdateResponse = null;
    int j = zza.zzcQ(paramParcel);
    int i = 0;
    Status localStatus = null;
    if (paramParcel.dataPosition() < j)
    {
      int k = zza.zzcP(paramParcel);
      switch (zza.zzeS(k))
      {
      default:
        zza.zzb(paramParcel, k);
      case 1000:
      case 1:
      case 2:
      }
      while (true)
      {
        break;
        i = zza.zzg(paramParcel, k);
        continue;
        localStatus = (Status)zza.zza(paramParcel, k, Status.CREATOR);
        continue;
        localPIMEUpdateResponse = (PIMEUpdateResponse)zza.zza(paramParcel, k, PIMEUpdateResponse.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new GetIMEUpdatesCall.Response(i, localStatus, localPIMEUpdateResponse);
  }

  public GetIMEUpdatesCall.Response[] zzph(int paramInt)
  {
    return new GetIMEUpdatesCall.Response[paramInt];
  }
}
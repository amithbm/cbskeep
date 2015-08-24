package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzc
  implements Parcelable.Creator<AccountChangeEventsResponse>
{
  static void zza(AccountChangeEventsResponse paramAccountChangeEventsResponse, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, mVersion);
    zzb.zzd(paramParcel, 2, zzpg, false);
    zzb.zzJ(paramParcel, paramInt);
  }

  public AccountChangeEventsResponse zzal(Parcel paramParcel)
  {
    int j = zza.zzcQ(paramParcel);
    int i = 0;
    ArrayList localArrayList = null;
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
        localArrayList = zza.zzc(paramParcel, k, AccountChangeEvent.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new AccountChangeEventsResponse(i, localArrayList);
  }

  public AccountChangeEventsResponse[] zzbh(int paramInt)
  {
    return new AccountChangeEventsResponse[paramInt];
  }
}
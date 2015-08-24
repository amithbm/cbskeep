package com.google.android.gms.search.ime;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc
  implements Parcelable.Creator<GetIMEUpdatesCall.Request>
{
  static void zza(GetIMEUpdatesCall.Request paramRequest, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1000, mVersionCode);
    zzb.zzc(paramParcel, 1, maxNumUpdates);
    zzb.zza(paramParcel, 2, iterToken, false);
    zzb.zzJ(paramParcel, paramInt);
  }

  public GetIMEUpdatesCall.Request zzlC(Parcel paramParcel)
  {
    int j = 0;
    int k = zza.zzcQ(paramParcel);
    byte[] arrayOfByte = null;
    int i = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = zza.zzcP(paramParcel);
      switch (zza.zzeS(m))
      {
      default:
        zza.zzb(paramParcel, m);
        break;
      case 1000:
        i = zza.zzg(paramParcel, m);
        break;
      case 1:
        j = zza.zzg(paramParcel, m);
        break;
      case 2:
        arrayOfByte = zza.zzs(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k)
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    return new GetIMEUpdatesCall.Request(i, j, arrayOfByte);
  }

  public GetIMEUpdatesCall.Request[] zzpg(int paramInt)
  {
    return new GetIMEUpdatesCall.Request[paramInt];
  }
}
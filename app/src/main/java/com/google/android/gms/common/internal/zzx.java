package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzx
  implements Parcelable.Creator<ResolveAccountResponse>
{
  static void zza(ResolveAccountResponse paramResolveAccountResponse, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zza(paramParcel, 2, zzakz, false);
    zzb.zza(paramParcel, 3, paramResolveAccountResponse.zzqb(), paramInt, false);
    zzb.zza(paramParcel, 4, paramResolveAccountResponse.zzqc());
    zzb.zza(paramParcel, 5, paramResolveAccountResponse.zzqd());
    zzb.zzJ(paramParcel, i);
  }

  public ResolveAccountResponse zzcN(Parcel paramParcel)
  {
    ConnectionResult localConnectionResult = null;
    boolean bool1 = false;
    int j = zza.zzcQ(paramParcel);
    boolean bool2 = false;
    IBinder localIBinder = null;
    int i = 0;
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
        localIBinder = zza.zzq(paramParcel, k);
        break;
      case 3:
        localConnectionResult = (ConnectionResult)zza.zza(paramParcel, k, ConnectionResult.CREATOR);
        break;
      case 4:
        bool2 = zza.zzc(paramParcel, k);
        break;
      case 5:
        bool1 = zza.zzc(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new ResolveAccountResponse(i, localIBinder, localConnectionResult, bool2, bool1);
  }

  public ResolveAccountResponse[] zzeQ(int paramInt)
  {
    return new ResolveAccountResponse[paramInt];
  }
}
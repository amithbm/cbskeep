package com.google.android.gms.nearby.sharing.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzj
  implements Parcelable.Creator<ReceiveContentRequest>
{
  static void zza(ReceiveContentRequest paramReceiveContentRequest, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, versionCode);
    zzb.zza(paramParcel, 2, zzbbF, false);
    zzb.zza(paramParcel, 3, paramReceiveContentRequest.zzAy(), false);
    zzb.zza(paramParcel, 4, packageName, false);
    zzb.zza(paramParcel, 5, paramReceiveContentRequest.zzAv(), false);
    zzb.zzJ(paramParcel, paramInt);
  }

  public ReceiveContentRequest zzjO(Parcel paramParcel)
  {
    IBinder localIBinder1 = null;
    int j = zza.zzcQ(paramParcel);
    int i = 0;
    String str = null;
    IBinder localIBinder2 = null;
    IBinder localIBinder3 = null;
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
        localIBinder3 = zza.zzq(paramParcel, k);
        break;
      case 3:
        localIBinder2 = zza.zzq(paramParcel, k);
        break;
      case 4:
        str = zza.zzp(paramParcel, k);
        break;
      case 5:
        localIBinder1 = zza.zzq(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new ReceiveContentRequest(i, localIBinder3, localIBinder2, str, localIBinder1);
  }

  public ReceiveContentRequest[] zznh(int paramInt)
  {
    return new ReceiveContentRequest[paramInt];
  }
}
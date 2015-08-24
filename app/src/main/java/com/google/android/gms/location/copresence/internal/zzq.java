package com.google.android.gms.location.copresence.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzq
  implements Parcelable.Creator<UnsubscribeOperation>
{
  static void zza(UnsubscribeOperation paramUnsubscribeOperation, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, paramUnsubscribeOperation.getVersionCode());
    zzb.zzc(paramParcel, 2, type);
    zzb.zza(paramParcel, 3, paramUnsubscribeOperation.zzyC(), false);
    zzb.zza(paramParcel, 4, zzaSZ, paramInt, false);
    zzb.zzJ(paramParcel, i);
  }

  public UnsubscribeOperation zzil(Parcel paramParcel)
  {
    PendingIntent localPendingIntent = null;
    int j = 0;
    int k = zza.zzcQ(paramParcel);
    IBinder localIBinder = null;
    int i = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = zza.zzcP(paramParcel);
      switch (zza.zzeS(m))
      {
      default:
        zza.zzb(paramParcel, m);
        break;
      case 1:
        i = zza.zzg(paramParcel, m);
        break;
      case 2:
        j = zza.zzg(paramParcel, m);
        break;
      case 3:
        localIBinder = zza.zzq(paramParcel, m);
        break;
      case 4:
        localPendingIntent = (PendingIntent)zza.zza(paramParcel, m, PendingIntent.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != k)
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    return new UnsubscribeOperation(i, j, localIBinder, localPendingIntent);
  }

  public UnsubscribeOperation[] zzlm(int paramInt)
  {
    return new UnsubscribeOperation[paramInt];
  }
}
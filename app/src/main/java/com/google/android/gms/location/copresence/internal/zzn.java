package com.google.android.gms.location.copresence.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.location.copresence.MessageFilter;

public class zzn
  implements Parcelable.Creator<SubscribeOperation>
{
  static void zza(SubscribeOperation paramSubscribeOperation, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, paramSubscribeOperation.getVersionCode());
    zzb.zzc(paramParcel, 2, type);
    zzb.zza(paramParcel, 3, zzaSX, paramInt, false);
    zzb.zza(paramParcel, 4, zzaSY, paramInt, false);
    zzb.zza(paramParcel, 5, paramSubscribeOperation.zzyC(), false);
    zzb.zza(paramParcel, 6, zzaSZ, paramInt, false);
    zzb.zza(paramParcel, 7, zzaTa, false);
    zzb.zzJ(paramParcel, i);
  }

  public SubscribeOperation zzij(Parcel paramParcel)
  {
    int i = 0;
    byte[] arrayOfByte = null;
    int k = zza.zzcQ(paramParcel);
    PendingIntent localPendingIntent = null;
    IBinder localIBinder = null;
    MessageFilter localMessageFilter = null;
    StrategyImpl localStrategyImpl = null;
    int j = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = zza.zzcP(paramParcel);
      switch (zza.zzeS(m))
      {
      default:
        zza.zzb(paramParcel, m);
        break;
      case 1:
        j = zza.zzg(paramParcel, m);
        break;
      case 2:
        i = zza.zzg(paramParcel, m);
        break;
      case 3:
        localStrategyImpl = (StrategyImpl)zza.zza(paramParcel, m, StrategyImpl.CREATOR);
        break;
      case 4:
        localMessageFilter = (MessageFilter)zza.zza(paramParcel, m, MessageFilter.CREATOR);
        break;
      case 5:
        localIBinder = zza.zzq(paramParcel, m);
        break;
      case 6:
        localPendingIntent = (PendingIntent)zza.zza(paramParcel, m, PendingIntent.CREATOR);
        break;
      case 7:
        arrayOfByte = zza.zzs(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k)
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    return new SubscribeOperation(j, i, localStrategyImpl, localMessageFilter, localIBinder, localPendingIntent, arrayOfByte);
  }

  public SubscribeOperation[] zzlk(int paramInt)
  {
    return new SubscribeOperation[paramInt];
  }
}
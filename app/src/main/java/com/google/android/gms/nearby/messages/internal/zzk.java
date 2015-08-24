package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.nearby.messages.MessageFilter;
import com.google.android.gms.nearby.messages.Strategy;

public class zzk
  implements Parcelable.Creator<SubscribeRequest>
{
  static void zza(SubscribeRequest paramSubscribeRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zza(paramParcel, 2, paramSubscribeRequest.zzyC(), false);
    zzb.zza(paramParcel, 3, zzbbp, paramInt, false);
    zzb.zza(paramParcel, 4, paramSubscribeRequest.zzAv(), false);
    zzb.zza(paramParcel, 5, zzbbt, paramInt, false);
    zzb.zza(paramParcel, 6, zzaSZ, paramInt, false);
    zzb.zzc(paramParcel, 7, zzbbu);
    zzb.zza(paramParcel, 8, zeroPartyPackageName, false);
    zzb.zza(paramParcel, 9, zzbbr, false);
    zzb.zzJ(paramParcel, i);
  }

  public SubscribeRequest zzjG(Parcel paramParcel)
  {
    int i = 0;
    String str1 = null;
    int k = zza.zzcQ(paramParcel);
    String str2 = null;
    PendingIntent localPendingIntent = null;
    MessageFilter localMessageFilter = null;
    IBinder localIBinder1 = null;
    Strategy localStrategy = null;
    IBinder localIBinder2 = null;
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
        localIBinder2 = zza.zzq(paramParcel, m);
        break;
      case 3:
        localStrategy = (Strategy)zza.zza(paramParcel, m, Strategy.CREATOR);
        break;
      case 4:
        localIBinder1 = zza.zzq(paramParcel, m);
        break;
      case 5:
        localMessageFilter = (MessageFilter)zza.zza(paramParcel, m, MessageFilter.CREATOR);
        break;
      case 6:
        localPendingIntent = (PendingIntent)zza.zza(paramParcel, m, PendingIntent.CREATOR);
        break;
      case 7:
        i = zza.zzg(paramParcel, m);
        break;
      case 8:
        str2 = zza.zzp(paramParcel, m);
        break;
      case 9:
        str1 = zza.zzp(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k)
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    return new SubscribeRequest(j, localIBinder2, localStrategy, localIBinder1, localMessageFilter, localPendingIntent, i, str2, str1);
  }

  public SubscribeRequest[] zzmZ(int paramInt)
  {
    return new SubscribeRequest[paramInt];
  }
}
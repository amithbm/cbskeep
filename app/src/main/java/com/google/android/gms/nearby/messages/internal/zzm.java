package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzm
  implements Parcelable.Creator<UnsubscribeRequest>
{
  static void zza(UnsubscribeRequest paramUnsubscribeRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zza(paramParcel, 2, paramUnsubscribeRequest.zzyC(), false);
    zzb.zza(paramParcel, 3, paramUnsubscribeRequest.zzAv(), false);
    zzb.zza(paramParcel, 4, zzaSZ, paramInt, false);
    zzb.zzc(paramParcel, 5, zzbbu);
    zzb.zza(paramParcel, 6, zeroPartyPackageName, false);
    zzb.zza(paramParcel, 7, zzbbr, false);
    zzb.zzJ(paramParcel, i);
  }

  public UnsubscribeRequest zzjI(Parcel paramParcel)
  {
    int i = 0;
    String str1 = null;
    int k = zza.zzcQ(paramParcel);
    String str2 = null;
    PendingIntent localPendingIntent = null;
    IBinder localIBinder1 = null;
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
        localIBinder1 = zza.zzq(paramParcel, m);
        break;
      case 4:
        localPendingIntent = (PendingIntent)zza.zza(paramParcel, m, PendingIntent.CREATOR);
        break;
      case 5:
        i = zza.zzg(paramParcel, m);
        break;
      case 6:
        str2 = zza.zzp(paramParcel, m);
        break;
      case 7:
        str1 = zza.zzp(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k)
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    return new UnsubscribeRequest(j, localIBinder2, localIBinder1, localPendingIntent, i, str2, str1);
  }

  public UnsubscribeRequest[] zznb(int paramInt)
  {
    return new UnsubscribeRequest[paramInt];
  }
}
package com.google.android.gms.location.copresence;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzl
  implements Parcelable.Creator<SubscribedMessage>
{
  static void zza(SubscribedMessage paramSubscribedMessage, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, paramSubscribedMessage.getVersionCode());
    zzb.zza(paramParcel, 2, paramSubscribedMessage.getMessage(), paramInt, false);
    zzb.zzJ(paramParcel, i);
  }

  public SubscribedMessage zzhZ(Parcel paramParcel)
  {
    int j = zza.zzcQ(paramParcel);
    int i = 0;
    Message localMessage = null;
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
        localMessage = (Message)zza.zza(paramParcel, k, Message.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new SubscribedMessage(i, localMessage);
  }

  public SubscribedMessage[] zzla(int paramInt)
  {
    return new SubscribedMessage[paramInt];
  }
}
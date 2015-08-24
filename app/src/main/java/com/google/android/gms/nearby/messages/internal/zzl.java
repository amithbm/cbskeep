package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzl
  implements Parcelable.Creator<UnpublishRequest>
{
  static void zza(UnpublishRequest paramUnpublishRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zza(paramParcel, 2, zzbbo, paramInt, false);
    zzb.zza(paramParcel, 3, paramUnpublishRequest.zzAv(), false);
    zzb.zza(paramParcel, 4, zeroPartyPackageName, false);
    zzb.zza(paramParcel, 5, zzbbr, false);
    zzb.zzJ(paramParcel, i);
  }

  public UnpublishRequest zzjH(Parcel paramParcel)
  {
    String str1 = null;
    int j = zza.zzcQ(paramParcel);
    int i = 0;
    String str2 = null;
    IBinder localIBinder = null;
    MessageWrapper localMessageWrapper = null;
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
        localMessageWrapper = (MessageWrapper)zza.zza(paramParcel, k, MessageWrapper.CREATOR);
        break;
      case 3:
        localIBinder = zza.zzq(paramParcel, k);
        break;
      case 4:
        str2 = zza.zzp(paramParcel, k);
        break;
      case 5:
        str1 = zza.zzp(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new UnpublishRequest(i, localMessageWrapper, localIBinder, str2, str1);
  }

  public UnpublishRequest[] zzna(int paramInt)
  {
    return new UnpublishRequest[paramInt];
  }
}
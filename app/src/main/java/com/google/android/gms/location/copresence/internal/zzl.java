package com.google.android.gms.location.copresence.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.location.copresence.AccessPolicy;
import com.google.android.gms.location.copresence.Message;

public class zzl
  implements Parcelable.Creator<PublishOperation>
{
  static void zza(PublishOperation paramPublishOperation, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, paramPublishOperation.getVersionCode());
    zzb.zza(paramParcel, 2, paramPublishOperation.getId(), false);
    zzb.zza(paramParcel, 3, paramPublishOperation.zzyF(), paramInt, false);
    zzb.zza(paramParcel, 4, paramPublishOperation.getMessage(), paramInt, false);
    zzb.zza(paramParcel, 5, paramPublishOperation.zzyG(), paramInt, false);
    zzb.zzJ(paramParcel, i);
  }

  public PublishOperation zzih(Parcel paramParcel)
  {
    AccessPolicy localAccessPolicy = null;
    int j = zza.zzcQ(paramParcel);
    int i = 0;
    Message localMessage = null;
    StrategyImpl localStrategyImpl = null;
    String str = null;
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
        str = zza.zzp(paramParcel, k);
        break;
      case 3:
        localStrategyImpl = (StrategyImpl)zza.zza(paramParcel, k, StrategyImpl.CREATOR);
        break;
      case 4:
        localMessage = (Message)zza.zza(paramParcel, k, Message.CREATOR);
        break;
      case 5:
        localAccessPolicy = (AccessPolicy)zza.zza(paramParcel, k, AccessPolicy.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new PublishOperation(i, str, localStrategyImpl, localMessage, localAccessPolicy);
  }

  public PublishOperation[] zzli(int paramInt)
  {
    return new PublishOperation[paramInt];
  }
}
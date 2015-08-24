package com.google.android.gms.location.copresence.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzk
  implements Parcelable.Creator<Operation>
{
  static void zza(Operation paramOperation, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, paramOperation.getVersionCode());
    zzb.zzc(paramParcel, 2, zzaSM);
    zzb.zza(paramParcel, 3, zzaSN, paramInt, false);
    zzb.zza(paramParcel, 4, zzaSO, paramInt, false);
    zzb.zza(paramParcel, 5, zzaSP, paramInt, false);
    zzb.zza(paramParcel, 6, zzaSQ, paramInt, false);
    zzb.zzJ(paramParcel, i);
  }

  public Operation zzig(Parcel paramParcel)
  {
    int i = 0;
    UnsubscribeOperation localUnsubscribeOperation = null;
    int k = zza.zzcQ(paramParcel);
    SubscribeOperation localSubscribeOperation = null;
    UnpublishOperation localUnpublishOperation = null;
    PublishOperation localPublishOperation = null;
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
        localPublishOperation = (PublishOperation)zza.zza(paramParcel, m, PublishOperation.CREATOR);
        break;
      case 4:
        localUnpublishOperation = (UnpublishOperation)zza.zza(paramParcel, m, UnpublishOperation.CREATOR);
        break;
      case 5:
        localSubscribeOperation = (SubscribeOperation)zza.zza(paramParcel, m, SubscribeOperation.CREATOR);
        break;
      case 6:
        localUnsubscribeOperation = (UnsubscribeOperation)zza.zza(paramParcel, m, UnsubscribeOperation.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != k)
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    return new Operation(j, i, localPublishOperation, localUnpublishOperation, localSubscribeOperation, localUnsubscribeOperation);
  }

  public Operation[] zzlh(int paramInt)
  {
    return new Operation[paramInt];
  }
}
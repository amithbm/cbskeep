package com.google.android.gms.location.reporting;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzd
  implements Parcelable.Creator<UploadRequest>
{
  static void zza(UploadRequest paramUploadRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, paramUploadRequest.getVersionCode());
    zzb.zza(paramParcel, 2, paramUploadRequest.getAccount(), paramInt, false);
    zzb.zza(paramParcel, 3, paramUploadRequest.getReason(), false);
    zzb.zza(paramParcel, 4, paramUploadRequest.getDurationMillis());
    zzb.zza(paramParcel, 5, paramUploadRequest.getMovingLatencyMillis());
    zzb.zza(paramParcel, 6, paramUploadRequest.getStationaryLatencyMillis());
    zzb.zza(paramParcel, 7, paramUploadRequest.getAppSpecificKey(), false);
    zzb.zzJ(paramParcel, i);
  }

  public UploadRequest zziO(Parcel paramParcel)
  {
    long l1 = 0L;
    String str1 = null;
    int j = zza.zzcQ(paramParcel);
    int i = 0;
    long l2 = 0L;
    long l3 = 0L;
    String str2 = null;
    Account localAccount = null;
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
        localAccount = (Account)zza.zza(paramParcel, k, Account.CREATOR);
        break;
      case 3:
        str2 = zza.zzp(paramParcel, k);
        break;
      case 4:
        l3 = zza.zzi(paramParcel, k);
        break;
      case 5:
        l2 = zza.zzi(paramParcel, k);
        break;
      case 6:
        l1 = zza.zzi(paramParcel, k);
        break;
      case 7:
        str1 = zza.zzp(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new UploadRequest(i, localAccount, str2, l3, l2, l1, str1);
  }

  public UploadRequest[] zzlV(int paramInt)
  {
    return new UploadRequest[paramInt];
  }
}
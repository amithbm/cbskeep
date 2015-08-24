package com.google.android.gms.location.copresence.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;

public class zzb
  implements Parcelable.Creator<BatchRequest>
{
  static void zza(BatchRequest paramBatchRequest, Parcel paramParcel, int paramInt)
  {
    int i = com.google.android.gms.common.internal.safeparcel.zzb.zzcR(paramParcel);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 1, mVersionCode);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 2, zzaSr, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 3, packageName, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 4, accountName, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 5, zzaSs, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 6, zzaSt, paramInt, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 7, zzaSu, paramInt, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zzJ(paramParcel, i);
  }

  public BatchRequest zzid(Parcel paramParcel)
  {
    CopresenceApiOptions localCopresenceApiOptions = null;
    int j = zza.zzcQ(paramParcel);
    int i = 0;
    BatchImpl localBatchImpl = null;
    String str1 = null;
    String str2 = null;
    String str3 = null;
    IBinder localIBinder = null;
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
        localIBinder = zza.zzq(paramParcel, k);
        break;
      case 3:
        str3 = zza.zzp(paramParcel, k);
        break;
      case 4:
        str2 = zza.zzp(paramParcel, k);
        break;
      case 5:
        str1 = zza.zzp(paramParcel, k);
        break;
      case 6:
        localBatchImpl = (BatchImpl)zza.zza(paramParcel, k, BatchImpl.CREATOR);
        break;
      case 7:
        localCopresenceApiOptions = (CopresenceApiOptions)zza.zza(paramParcel, k, CopresenceApiOptions.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new BatchRequest(i, localIBinder, str3, str2, str1, localBatchImpl, localCopresenceApiOptions);
  }

  public BatchRequest[] zzle(int paramInt)
  {
    return new BatchRequest[paramInt];
  }
}
package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;

public class zzbl
  implements Parcelable.Creator<RemoveEventListenerRequest>
{
  static void zza(RemoveEventListenerRequest paramRemoveEventListenerRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zza(paramParcel, 2, zzasr, paramInt, false);
    zzb.zzc(paramParcel, 3, zzanC);
    zzb.zzJ(paramParcel, i);
  }

  public RemoveEventListenerRequest zzeK(Parcel paramParcel)
  {
    int i = 0;
    int k = zza.zzcQ(paramParcel);
    DriveId localDriveId = null;
    int j = 0;
    if (paramParcel.dataPosition() < k)
    {
      int m = zza.zzcP(paramParcel);
      switch (zza.zzeS(m))
      {
      default:
        zza.zzb(paramParcel, m);
      case 1:
      case 2:
      case 3:
      }
      while (true)
      {
        break;
        j = zza.zzg(paramParcel, m);
        continue;
        localDriveId = (DriveId)zza.zza(paramParcel, m, DriveId.CREATOR);
        continue;
        i = zza.zzg(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k)
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    return new RemoveEventListenerRequest(j, localDriveId, i);
  }

  public RemoveEventListenerRequest[] zzhe(int paramInt)
  {
    return new RemoveEventListenerRequest[paramInt];
  }
}
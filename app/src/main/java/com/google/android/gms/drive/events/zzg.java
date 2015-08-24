package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;

public class zzg
  implements Parcelable.Creator<ProgressEvent>
{
  static void zza(ProgressEvent paramProgressEvent, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zza(paramParcel, 2, zzasr, paramInt, false);
    zzb.zzc(paramParcel, 3, zzxv);
    zzb.zza(paramParcel, 4, zzats);
    zzb.zza(paramParcel, 5, zzatt);
    zzb.zzc(paramParcel, 6, zzOu);
    zzb.zzJ(paramParcel, i);
  }

  public ProgressEvent zzdU(Parcel paramParcel)
  {
    long l1 = 0L;
    int i = 0;
    int m = zza.zzcQ(paramParcel);
    DriveId localDriveId = null;
    long l2 = 0L;
    int j = 0;
    int k = 0;
    while (paramParcel.dataPosition() < m)
    {
      int n = zza.zzcP(paramParcel);
      switch (zza.zzeS(n))
      {
      default:
        zza.zzb(paramParcel, n);
        break;
      case 1:
        k = zza.zzg(paramParcel, n);
        break;
      case 2:
        localDriveId = (DriveId)zza.zza(paramParcel, n, DriveId.CREATOR);
        break;
      case 3:
        j = zza.zzg(paramParcel, n);
        break;
      case 4:
        l2 = zza.zzi(paramParcel, n);
        break;
      case 5:
        l1 = zza.zzi(paramParcel, n);
        break;
      case 6:
        i = zza.zzg(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m)
      throw new zza.zza("Overread allowed size end=" + m, paramParcel);
    return new ProgressEvent(k, localDriveId, j, l2, l1, i);
  }

  public ProgressEvent[] zzgj(int paramInt)
  {
    return new ProgressEvent[paramInt];
  }
}
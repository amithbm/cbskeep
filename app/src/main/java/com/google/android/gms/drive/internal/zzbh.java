package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;

public class zzbh
  implements Parcelable.Creator<OpenContentsRequest>
{
  static void zza(OpenContentsRequest paramOpenContentsRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zza(paramParcel, 2, zzatC, paramInt, false);
    zzb.zzc(paramParcel, 3, zzasq);
    zzb.zzc(paramParcel, 4, zzawm);
    zzb.zzJ(paramParcel, i);
  }

  public OpenContentsRequest zzeH(Parcel paramParcel)
  {
    int i = 0;
    int m = zza.zzcQ(paramParcel);
    DriveId localDriveId = null;
    int j = 0;
    int k = 0;
    if (paramParcel.dataPosition() < m)
    {
      int n = zza.zzcP(paramParcel);
      switch (zza.zzeS(n))
      {
      default:
        zza.zzb(paramParcel, n);
      case 1:
      case 2:
      case 3:
      case 4:
      }
      while (true)
      {
        break;
        k = zza.zzg(paramParcel, n);
        continue;
        localDriveId = (DriveId)zza.zza(paramParcel, n, DriveId.CREATOR);
        continue;
        j = zza.zzg(paramParcel, n);
        continue;
        i = zza.zzg(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m)
      throw new zza.zza("Overread allowed size end=" + m, paramParcel);
    return new OpenContentsRequest(k, localDriveId, j, i);
  }

  public OpenContentsRequest[] zzhb(int paramInt)
  {
    return new OpenContentsRequest[paramInt];
  }
}
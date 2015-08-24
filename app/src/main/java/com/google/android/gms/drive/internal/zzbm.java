package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;

public class zzbm
  implements Parcelable.Creator<RemovePermissionRequest>
{
  static void zza(RemovePermissionRequest paramRemovePermissionRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zza(paramParcel, 2, zzasr, paramInt, false);
    zzb.zza(paramParcel, 3, zzasN, false);
    zzb.zza(paramParcel, 4, zzatz);
    zzb.zza(paramParcel, 5, zzasB, false);
    zzb.zzJ(paramParcel, i);
  }

  public RemovePermissionRequest zzeL(Parcel paramParcel)
  {
    boolean bool = false;
    String str1 = null;
    int j = zza.zzcQ(paramParcel);
    String str2 = null;
    DriveId localDriveId = null;
    int i = 0;
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
        localDriveId = (DriveId)zza.zza(paramParcel, k, DriveId.CREATOR);
        break;
      case 3:
        str2 = zza.zzp(paramParcel, k);
        break;
      case 4:
        bool = zza.zzc(paramParcel, k);
        break;
      case 5:
        str1 = zza.zzp(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new RemovePermissionRequest(i, localDriveId, str2, bool, str1);
  }

  public RemovePermissionRequest[] zzhf(int paramInt)
  {
    return new RemovePermissionRequest[paramInt];
  }
}
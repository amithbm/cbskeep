package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.Permission;

public class zzb
  implements Parcelable.Creator<AddPermissionRequest>
{
  static void zza(AddPermissionRequest paramAddPermissionRequest, Parcel paramParcel, int paramInt)
  {
    int i = com.google.android.gms.common.internal.safeparcel.zzb.zzcR(paramParcel);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 1, mVersionCode);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 2, zzasr, paramInt, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 3, zzatw, paramInt, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 4, zzatx);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 5, zzaty, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 6, zzatz);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 7, zzasB, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zzJ(paramParcel, i);
  }

  public AddPermissionRequest zzdX(Parcel paramParcel)
  {
    boolean bool1 = false;
    String str1 = null;
    int j = zza.zzcQ(paramParcel);
    String str2 = null;
    boolean bool2 = false;
    Permission localPermission = null;
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
        localPermission = (Permission)zza.zza(paramParcel, k, Permission.CREATOR);
        break;
      case 4:
        bool2 = zza.zzc(paramParcel, k);
        break;
      case 5:
        str2 = zza.zzp(paramParcel, k);
        break;
      case 6:
        bool1 = zza.zzc(paramParcel, k);
        break;
      case 7:
        str1 = zza.zzp(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new AddPermissionRequest(i, localDriveId, localPermission, bool2, str2, bool1, str1);
  }

  public AddPermissionRequest[] zzgm(int paramInt)
  {
    return new AddPermissionRequest[paramInt];
  }
}
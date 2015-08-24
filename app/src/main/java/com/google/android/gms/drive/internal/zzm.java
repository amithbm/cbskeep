package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class zzm
  implements Parcelable.Creator<CreateFolderRequest>
{
  static void zza(CreateFolderRequest paramCreateFolderRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zza(paramParcel, 2, zzatO, paramInt, false);
    zzb.zza(paramParcel, 3, zzatM, paramInt, false);
    zzb.zzJ(paramParcel, i);
  }

  public CreateFolderRequest zzeg(Parcel paramParcel)
  {
    MetadataBundle localMetadataBundle = null;
    int j = zza.zzcQ(paramParcel);
    int i = 0;
    DriveId localDriveId = null;
    if (paramParcel.dataPosition() < j)
    {
      int k = zza.zzcP(paramParcel);
      switch (zza.zzeS(k))
      {
      default:
        zza.zzb(paramParcel, k);
      case 1:
      case 2:
      case 3:
      }
      while (true)
      {
        break;
        i = zza.zzg(paramParcel, k);
        continue;
        localDriveId = (DriveId)zza.zza(paramParcel, k, DriveId.CREATOR);
        continue;
        localMetadataBundle = (MetadataBundle)zza.zza(paramParcel, k, MetadataBundle.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new CreateFolderRequest(i, localDriveId, localMetadataBundle);
  }

  public CreateFolderRequest[] zzgw(int paramInt)
  {
    return new CreateFolderRequest[paramInt];
  }
}
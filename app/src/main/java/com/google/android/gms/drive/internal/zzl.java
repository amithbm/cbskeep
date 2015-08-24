package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class zzl
  implements Parcelable.Creator<CreateFileRequest>
{
  static void zza(CreateFileRequest paramCreateFileRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zza(paramParcel, 2, zzatO, paramInt, false);
    zzb.zza(paramParcel, 3, zzatM, paramInt, false);
    zzb.zza(paramParcel, 4, zzatE, paramInt, false);
    zzb.zza(paramParcel, 5, zzatN, false);
    zzb.zza(paramParcel, 6, zzatz);
    zzb.zza(paramParcel, 7, zzasB, false);
    zzb.zzc(paramParcel, 8, zzatP);
    zzb.zzc(paramParcel, 9, zzatQ);
    zzb.zzJ(paramParcel, i);
  }

  public CreateFileRequest zzef(Parcel paramParcel)
  {
    int i = 0;
    String str = null;
    int m = zza.zzcQ(paramParcel);
    int j = 0;
    boolean bool = false;
    Integer localInteger = null;
    Contents localContents = null;
    MetadataBundle localMetadataBundle = null;
    DriveId localDriveId = null;
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
        localMetadataBundle = (MetadataBundle)zza.zza(paramParcel, n, MetadataBundle.CREATOR);
        break;
      case 4:
        localContents = (Contents)zza.zza(paramParcel, n, Contents.CREATOR);
        break;
      case 5:
        localInteger = zza.zzh(paramParcel, n);
        break;
      case 6:
        bool = zza.zzc(paramParcel, n);
        break;
      case 7:
        str = zza.zzp(paramParcel, n);
        break;
      case 8:
        j = zza.zzg(paramParcel, n);
        break;
      case 9:
        i = zza.zzg(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m)
      throw new zza.zza("Overread allowed size end=" + m, paramParcel);
    return new CreateFileRequest(k, localDriveId, localMetadataBundle, localContents, localInteger, bool, str, j, i);
  }

  public CreateFileRequest[] zzgv(int paramInt)
  {
    return new CreateFileRequest[paramInt];
  }
}
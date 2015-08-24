package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;

public class zzc
  implements Parcelable.Creator<AuthorizeAccessRequest>
{
  static void zza(AuthorizeAccessRequest paramAuthorizeAccessRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zza(paramParcel, 2, zzatA);
    zzb.zza(paramParcel, 3, zzasr, paramInt, false);
    zzb.zzJ(paramParcel, i);
  }

  public AuthorizeAccessRequest zzdY(Parcel paramParcel)
  {
    int j = zza.zzcQ(paramParcel);
    int i = 0;
    long l = 0L;
    DriveId localDriveId = null;
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
        l = zza.zzi(paramParcel, k);
        break;
      case 3:
        localDriveId = (DriveId)zza.zza(paramParcel, k, DriveId.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new AuthorizeAccessRequest(i, l, localDriveId);
  }

  public AuthorizeAccessRequest[] zzgn(int paramInt)
  {
    return new AuthorizeAccessRequest[paramInt];
  }
}
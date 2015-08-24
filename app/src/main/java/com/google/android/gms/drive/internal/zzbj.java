package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.query.internal.FilterHolder;

public class zzbj
  implements Parcelable.Creator<OpenFileIntentSenderRequest>
{
  static void zza(OpenFileIntentSenderRequest paramOpenFileIntentSenderRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zza(paramParcel, 2, zzasJ, false);
    zzb.zza(paramParcel, 3, zzasK, false);
    zzb.zza(paramParcel, 4, zzasM, paramInt, false);
    zzb.zza(paramParcel, 5, zzawo, paramInt, false);
    zzb.zzJ(paramParcel, i);
  }

  public OpenFileIntentSenderRequest zzeI(Parcel paramParcel)
  {
    FilterHolder localFilterHolder = null;
    int j = zza.zzcQ(paramParcel);
    int i = 0;
    DriveId localDriveId = null;
    String[] arrayOfString = null;
    String str = null;
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
        str = zza.zzp(paramParcel, k);
        break;
      case 3:
        arrayOfString = zza.zzB(paramParcel, k);
        break;
      case 4:
        localDriveId = (DriveId)zza.zza(paramParcel, k, DriveId.CREATOR);
        break;
      case 5:
        localFilterHolder = (FilterHolder)zza.zza(paramParcel, k, FilterHolder.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new OpenFileIntentSenderRequest(i, str, arrayOfString, localDriveId, localFilterHolder);
  }

  public OpenFileIntentSenderRequest[] zzhc(int paramInt)
  {
    return new OpenFileIntentSenderRequest[paramInt];
  }
}
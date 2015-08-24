package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.ChangesAvailableOptions;

public class zza
  implements Parcelable.Creator<AddEventListenerRequest>
{
  static void zza(AddEventListenerRequest paramAddEventListenerRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zza(paramParcel, 2, zzasr, paramInt, false);
    zzb.zzc(paramParcel, 3, zzanC);
    zzb.zza(paramParcel, 4, zzatb, paramInt, false);
    zzb.zzJ(paramParcel, i);
  }

  public AddEventListenerRequest zzdW(Parcel paramParcel)
  {
    ChangesAvailableOptions localChangesAvailableOptions = null;
    int j = 0;
    int m = com.google.android.gms.common.internal.safeparcel.zza.zzcQ(paramParcel);
    DriveId localDriveId = null;
    int i = 0;
    if (paramParcel.dataPosition() < m)
    {
      int k = com.google.android.gms.common.internal.safeparcel.zza.zzcP(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.zza.zzeS(k))
      {
      default:
        com.google.android.gms.common.internal.safeparcel.zza.zzb(paramParcel, k);
        k = j;
        j = i;
        i = k;
      case 1:
      case 2:
      case 3:
      case 4:
      }
      while (true)
      {
        k = j;
        j = i;
        i = k;
        break;
        k = com.google.android.gms.common.internal.safeparcel.zza.zzg(paramParcel, k);
        i = j;
        j = k;
        continue;
        localDriveId = (DriveId)com.google.android.gms.common.internal.safeparcel.zza.zza(paramParcel, k, DriveId.CREATOR);
        k = i;
        i = j;
        j = k;
        continue;
        k = com.google.android.gms.common.internal.safeparcel.zza.zzg(paramParcel, k);
        j = i;
        i = k;
        continue;
        localChangesAvailableOptions = (ChangesAvailableOptions)com.google.android.gms.common.internal.safeparcel.zza.zza(paramParcel, k, ChangesAvailableOptions.CREATOR);
        k = i;
        i = j;
        j = k;
      }
    }
    if (paramParcel.dataPosition() != m)
      throw new zza.zza("Overread allowed size end=" + m, paramParcel);
    return new AddEventListenerRequest(i, localDriveId, j, localChangesAvailableOptions);
  }

  public AddEventListenerRequest[] zzgl(int paramInt)
  {
    return new AddEventListenerRequest[paramInt];
  }
}
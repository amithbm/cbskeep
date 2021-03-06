package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DrivePreferences;

public class zzbn
  implements Parcelable.Creator<SetDrivePreferencesRequest>
{
  static void zza(SetDrivePreferencesRequest paramSetDrivePreferencesRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zza(paramParcel, 2, zzavC, paramInt, false);
    zzb.zzJ(paramParcel, i);
  }

  public SetDrivePreferencesRequest zzeM(Parcel paramParcel)
  {
    int j = zza.zzcQ(paramParcel);
    int i = 0;
    DrivePreferences localDrivePreferences = null;
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
        localDrivePreferences = (DrivePreferences)zza.zza(paramParcel, k, DrivePreferences.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new SetDrivePreferencesRequest(i, localDrivePreferences);
  }

  public SetDrivePreferencesRequest[] zzhg(int paramInt)
  {
    return new SetDrivePreferencesRequest[paramInt];
  }
}
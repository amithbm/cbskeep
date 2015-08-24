package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzh
  implements Parcelable.Creator<LocationSettingsRequest>
{
  static void zza(LocationSettingsRequest paramLocationSettingsRequest, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcR(paramParcel);
    zzb.zzd(paramParcel, 1, paramLocationSettingsRequest.zzvc(), false);
    zzb.zzc(paramParcel, 1000, paramLocationSettingsRequest.getVersionCode());
    zzb.zza(paramParcel, 2, paramLocationSettingsRequest.zzyl());
    zzb.zza(paramParcel, 3, paramLocationSettingsRequest.zzym());
    zzb.zza(paramParcel, 4, paramLocationSettingsRequest.zzyn());
    zzb.zzJ(paramParcel, paramInt);
  }

  public LocationSettingsRequest zzhO(Parcel paramParcel)
  {
    boolean bool1 = false;
    int j = zza.zzcQ(paramParcel);
    ArrayList localArrayList = null;
    boolean bool2 = false;
    boolean bool3 = false;
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
        localArrayList = zza.zzc(paramParcel, k, LocationRequest.CREATOR);
        break;
      case 1000:
        i = zza.zzg(paramParcel, k);
        break;
      case 2:
        bool3 = zza.zzc(paramParcel, k);
        break;
      case 3:
        bool2 = zza.zzc(paramParcel, k);
        break;
      case 4:
        bool1 = zza.zzc(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new LocationSettingsRequest(i, localArrayList, bool3, bool2, bool1);
  }

  public LocationSettingsRequest[] zzkN(int paramInt)
  {
    return new LocationSettingsRequest[paramInt];
  }
}
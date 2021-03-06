package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.location.internal.ParcelableGeofence;
import java.util.ArrayList;

public class zza
  implements Parcelable.Creator<GeofencingRequest>
{
  static void zza(GeofencingRequest paramGeofencingRequest, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcR(paramParcel);
    zzb.zzd(paramParcel, 1, paramGeofencingRequest.zzyk(), false);
    zzb.zzc(paramParcel, 1000, paramGeofencingRequest.getVersionCode());
    zzb.zzc(paramParcel, 2, paramGeofencingRequest.getInitialTrigger());
    zzb.zzJ(paramParcel, paramInt);
  }

  public GeofencingRequest zzhK(Parcel paramParcel)
  {
    int j = 0;
    int k = com.google.android.gms.common.internal.safeparcel.zza.zzcQ(paramParcel);
    ArrayList localArrayList = null;
    int i = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = com.google.android.gms.common.internal.safeparcel.zza.zzcP(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.zza.zzeS(m))
      {
      default:
        com.google.android.gms.common.internal.safeparcel.zza.zzb(paramParcel, m);
        break;
      case 1:
        localArrayList = com.google.android.gms.common.internal.safeparcel.zza.zzc(paramParcel, m, ParcelableGeofence.CREATOR);
        break;
      case 1000:
        i = com.google.android.gms.common.internal.safeparcel.zza.zzg(paramParcel, m);
        break;
      case 2:
        j = com.google.android.gms.common.internal.safeparcel.zza.zzg(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k)
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    return new GeofencingRequest(i, localArrayList, j);
  }

  public GeofencingRequest[] zzkH(int paramInt)
  {
    return new GeofencingRequest[paramInt];
  }
}
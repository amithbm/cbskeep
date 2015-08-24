package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzl
  implements Parcelable.Creator<LocationRequestUpdateData>
{
  static void zza(LocationRequestUpdateData paramLocationRequestUpdateData, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, zzaTR);
    zzb.zzc(paramParcel, 1000, paramLocationRequestUpdateData.getVersionCode());
    zzb.zza(paramParcel, 2, zzaTS, paramInt, false);
    zzb.zza(paramParcel, 3, paramLocationRequestUpdateData.zzyR(), false);
    zzb.zza(paramParcel, 4, mPendingIntent, paramInt, false);
    zzb.zza(paramParcel, 5, paramLocationRequestUpdateData.zzyS(), false);
    zzb.zzJ(paramParcel, i);
  }

  public LocationRequestUpdateData zzio(Parcel paramParcel)
  {
    IBinder localIBinder1 = null;
    int k = zza.zzcQ(paramParcel);
    int j = 0;
    int i = 1;
    PendingIntent localPendingIntent = null;
    IBinder localIBinder2 = null;
    LocationRequestInternal localLocationRequestInternal = null;
    while (paramParcel.dataPosition() < k)
    {
      int m = zza.zzcP(paramParcel);
      switch (zza.zzeS(m))
      {
      default:
        zza.zzb(paramParcel, m);
        break;
      case 1:
        i = zza.zzg(paramParcel, m);
        break;
      case 1000:
        j = zza.zzg(paramParcel, m);
        break;
      case 2:
        localLocationRequestInternal = (LocationRequestInternal)zza.zza(paramParcel, m, LocationRequestInternal.CREATOR);
        break;
      case 3:
        localIBinder2 = zza.zzq(paramParcel, m);
        break;
      case 4:
        localPendingIntent = (PendingIntent)zza.zza(paramParcel, m, PendingIntent.CREATOR);
        break;
      case 5:
        localIBinder1 = zza.zzq(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k)
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    return new LocationRequestUpdateData(j, i, localLocationRequestInternal, localIBinder2, localPendingIntent, localIBinder1);
  }

  public LocationRequestUpdateData[] zzlp(int paramInt)
  {
    return new LocationRequestUpdateData[paramInt];
  }
}
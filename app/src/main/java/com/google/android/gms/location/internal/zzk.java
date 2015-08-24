package com.google.android.gms.location.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.location.LocationRequest;
import java.util.List;

public class zzk
  implements Parcelable.Creator<LocationRequestInternal>
{
  static void zza(LocationRequestInternal paramLocationRequestInternal, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zza(paramParcel, 1, zzaEr, paramInt, false);
    zzb.zzc(paramParcel, 1000, paramLocationRequestInternal.getVersionCode());
    zzb.zza(paramParcel, 2, zzaTN);
    zzb.zza(paramParcel, 3, zzaTO);
    zzb.zza(paramParcel, 4, zzaTP);
    zzb.zzd(paramParcel, 5, zzaTQ, false);
    zzb.zza(paramParcel, 6, mTag, false);
    zzb.zzJ(paramParcel, i);
  }

  public LocationRequestInternal zzin(Parcel paramParcel)
  {
    String str = null;
    boolean bool1 = true;
    boolean bool3 = false;
    int j = zza.zzcQ(paramParcel);
    Object localObject = LocationRequestInternal.zzaTM;
    boolean bool2 = true;
    LocationRequest localLocationRequest = null;
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
        localLocationRequest = (LocationRequest)zza.zza(paramParcel, k, LocationRequest.CREATOR);
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
        break;
      case 5:
        localObject = zza.zzc(paramParcel, k, ClientIdentity.CREATOR);
        break;
      case 6:
        str = zza.zzp(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new LocationRequestInternal(i, localLocationRequest, bool3, bool2, bool1, (List)localObject, str);
  }

  public LocationRequestInternal[] zzlo(int paramInt)
  {
    return new LocationRequestInternal[paramInt];
  }
}
package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzc
  implements Parcelable.Creator<NearbyAlertFilter>
{
  static void zza(NearbyAlertFilter paramNearbyAlertFilter, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, zzaUe, false);
    zzb.zzc(paramParcel, 1000, mVersionCode);
    zzb.zza(paramParcel, 2, zzaUc, false);
    zzb.zzd(paramParcel, 3, zzaUf, false);
    zzb.zzJ(paramParcel, paramInt);
  }

  public NearbyAlertFilter zzis(Parcel paramParcel)
  {
    ArrayList localArrayList3 = null;
    int j = zza.zzcQ(paramParcel);
    int i = 0;
    ArrayList localArrayList2 = null;
    ArrayList localArrayList1 = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = zza.zzcP(paramParcel);
      switch (zza.zzeS(k))
      {
      default:
        zza.zzb(paramParcel, k);
        break;
      case 1:
        localArrayList1 = zza.zzE(paramParcel, k);
        break;
      case 1000:
        i = zza.zzg(paramParcel, k);
        break;
      case 2:
        localArrayList2 = zza.zzC(paramParcel, k);
        break;
      case 3:
        localArrayList3 = zza.zzc(paramParcel, k, UserDataType.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new NearbyAlertFilter(i, localArrayList1, localArrayList2, localArrayList3);
  }

  public NearbyAlertFilter[] zzlv(int paramInt)
  {
    return new NearbyAlertFilter[paramInt];
  }
}
package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzp
  implements Parcelable.Creator<PlaceLocalization>
{
  static void zza(PlaceLocalization paramPlaceLocalization, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcR(paramParcel);
    zzb.zza(paramParcel, 1, name, false);
    zzb.zzc(paramParcel, 1000, versionCode);
    zzb.zza(paramParcel, 2, zzaVD, false);
    zzb.zza(paramParcel, 3, zzaVE, false);
    zzb.zza(paramParcel, 4, zzaVF, false);
    zzb.zzc(paramParcel, 5, zzaVG, false);
    zzb.zzJ(paramParcel, paramInt);
  }

  public PlaceLocalization zziE(Parcel paramParcel)
  {
    ArrayList localArrayList = null;
    int j = zza.zzcQ(paramParcel);
    int i = 0;
    String str1 = null;
    String str2 = null;
    String str3 = null;
    String str4 = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = zza.zzcP(paramParcel);
      switch (zza.zzeS(k))
      {
      default:
        zza.zzb(paramParcel, k);
        break;
      case 1:
        str4 = zza.zzp(paramParcel, k);
        break;
      case 1000:
        i = zza.zzg(paramParcel, k);
        break;
      case 2:
        str3 = zza.zzp(paramParcel, k);
        break;
      case 3:
        str2 = zza.zzp(paramParcel, k);
        break;
      case 4:
        str1 = zza.zzp(paramParcel, k);
        break;
      case 5:
        localArrayList = zza.zzE(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new PlaceLocalization(i, str4, str3, str2, str1, localArrayList);
  }

  public PlaceLocalization[] zzlL(int paramInt)
  {
    return new PlaceLocalization[paramInt];
  }
}
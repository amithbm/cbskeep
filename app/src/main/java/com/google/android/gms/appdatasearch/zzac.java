package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzac
  implements Parcelable.Creator<Section>
{
  static void zza(Section paramSection, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcR(paramParcel);
    zzb.zza(paramParcel, 1, name, false);
    zzb.zzc(paramParcel, 1000, mVersionCode);
    zzb.zza(paramParcel, 2, snippeted);
    zzb.zzc(paramParcel, 3, snippetLength);
    zzb.zzJ(paramParcel, paramInt);
  }

  public Section zzU(Parcel paramParcel)
  {
    int j = 0;
    int k = zza.zzcQ(paramParcel);
    String str = null;
    boolean bool = false;
    int i = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = zza.zzcP(paramParcel);
      switch (zza.zzeS(m))
      {
      default:
        zza.zzb(paramParcel, m);
        break;
      case 1:
        str = zza.zzp(paramParcel, m);
        break;
      case 1000:
        i = zza.zzg(paramParcel, m);
        break;
      case 2:
        bool = zza.zzc(paramParcel, m);
        break;
      case 3:
        j = zza.zzg(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k)
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    return new Section(i, str, bool, j);
  }

  public Section[] zzaK(int paramInt)
  {
    return new Section[paramInt];
  }
}
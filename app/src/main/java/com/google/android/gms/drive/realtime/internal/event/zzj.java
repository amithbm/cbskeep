package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzj
  implements Parcelable.Creator<ValuesAddedDetails>
{
  static void zza(ValuesAddedDetails paramValuesAddedDetails, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zzc(paramParcel, 2, mIndex);
    zzb.zzc(paramParcel, 3, zzaAq);
    zzb.zzc(paramParcel, 4, zzaAr);
    zzb.zza(paramParcel, 5, zzaAG, false);
    zzb.zzc(paramParcel, 6, zzaAH);
    zzb.zzJ(paramParcel, paramInt);
  }

  public ValuesAddedDetails zzfA(Parcel paramParcel)
  {
    int i = 0;
    int i1 = zza.zzcQ(paramParcel);
    String str = null;
    int j = 0;
    int k = 0;
    int m = 0;
    int n = 0;
    while (paramParcel.dataPosition() < i1)
    {
      int i2 = zza.zzcP(paramParcel);
      switch (zza.zzeS(i2))
      {
      default:
        zza.zzb(paramParcel, i2);
        break;
      case 1:
        n = zza.zzg(paramParcel, i2);
        break;
      case 2:
        m = zza.zzg(paramParcel, i2);
        break;
      case 3:
        k = zza.zzg(paramParcel, i2);
        break;
      case 4:
        j = zza.zzg(paramParcel, i2);
        break;
      case 5:
        str = zza.zzp(paramParcel, i2);
        break;
      case 6:
        i = zza.zzg(paramParcel, i2);
      }
    }
    if (paramParcel.dataPosition() != i1)
      throw new zza.zza("Overread allowed size end=" + i1, paramParcel);
    return new ValuesAddedDetails(n, m, k, j, str, i);
  }

  public ValuesAddedDetails[] zzhY(int paramInt)
  {
    return new ValuesAddedDetails[paramInt];
  }
}
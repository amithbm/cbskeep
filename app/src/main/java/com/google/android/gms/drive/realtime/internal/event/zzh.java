package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzh
  implements Parcelable.Creator<TextInsertedDetails>
{
  static void zza(TextInsertedDetails paramTextInsertedDetails, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zzc(paramParcel, 2, mIndex);
    zzb.zzc(paramParcel, 3, zzaAF);
    zzb.zzJ(paramParcel, paramInt);
  }

  public TextInsertedDetails zzfy(Parcel paramParcel)
  {
    int k = 0;
    int m = zza.zzcQ(paramParcel);
    int j = 0;
    int i = 0;
    while (paramParcel.dataPosition() < m)
    {
      int n = zza.zzcP(paramParcel);
      switch (zza.zzeS(n))
      {
      default:
        zza.zzb(paramParcel, n);
        break;
      case 1:
        i = zza.zzg(paramParcel, n);
        break;
      case 2:
        j = zza.zzg(paramParcel, n);
        break;
      case 3:
        k = zza.zzg(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m)
      throw new zza.zza("Overread allowed size end=" + m, paramParcel);
    return new TextInsertedDetails(i, j, k);
  }

  public TextInsertedDetails[] zzhW(int paramInt)
  {
    return new TextInsertedDetails[paramInt];
  }
}
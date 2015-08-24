package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzf
  implements Parcelable.Creator<ReferenceShiftedDetails>
{
  static void zza(ReferenceShiftedDetails paramReferenceShiftedDetails, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zza(paramParcel, 2, zzayR, false);
    zzb.zza(paramParcel, 3, zzayQ, false);
    zzb.zzc(paramParcel, 4, zzayT);
    zzb.zzc(paramParcel, 5, zzayS);
    zzb.zzJ(paramParcel, paramInt);
  }

  public ReferenceShiftedDetails zzfw(Parcel paramParcel)
  {
    String str1 = null;
    int i = 0;
    int m = zza.zzcQ(paramParcel);
    int j = 0;
    String str2 = null;
    int k = 0;
    while (paramParcel.dataPosition() < m)
    {
      int n = zza.zzcP(paramParcel);
      switch (zza.zzeS(n))
      {
      default:
        zza.zzb(paramParcel, n);
        break;
      case 1:
        k = zza.zzg(paramParcel, n);
        break;
      case 2:
        str2 = zza.zzp(paramParcel, n);
        break;
      case 3:
        str1 = zza.zzp(paramParcel, n);
        break;
      case 4:
        j = zza.zzg(paramParcel, n);
        break;
      case 5:
        i = zza.zzg(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m)
      throw new zza.zza("Overread allowed size end=" + m, paramParcel);
    return new ReferenceShiftedDetails(k, str2, str1, j, i);
  }

  public ReferenceShiftedDetails[] zzhU(int paramInt)
  {
    return new ReferenceShiftedDetails[paramInt];
  }
}
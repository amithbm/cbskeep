package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzm
  implements Parcelable.Creator<PartialDriveId>
{
  static void zza(PartialDriveId paramPartialDriveId, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zza(paramParcel, 2, zzasw, false);
    zzb.zza(paramParcel, 3, zzasx);
    zzb.zzc(paramParcel, 4, zzasy);
    zzb.zzJ(paramParcel, paramInt);
  }

  public PartialDriveId zzeZ(Parcel paramParcel)
  {
    int k = zza.zzcQ(paramParcel);
    int j = 0;
    String str = null;
    long l = 0L;
    int i = -1;
    while (paramParcel.dataPosition() < k)
    {
      int m = zza.zzcP(paramParcel);
      switch (zza.zzeS(m))
      {
      default:
        zza.zzb(paramParcel, m);
        break;
      case 1:
        j = zza.zzg(paramParcel, m);
        break;
      case 2:
        str = zza.zzp(paramParcel, m);
        break;
      case 3:
        l = zza.zzi(paramParcel, m);
        break;
      case 4:
        i = zza.zzg(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k)
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    return new PartialDriveId(j, str, l, i);
  }

  public PartialDriveId[] zzht(int paramInt)
  {
    return new PartialDriveId[paramInt];
  }
}
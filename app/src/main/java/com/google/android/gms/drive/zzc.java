package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc
  implements Parcelable.Creator<DriveId>
{
  static void zza(DriveId paramDriveId, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zza(paramParcel, 2, zzasw, false);
    zzb.zza(paramParcel, 3, zzasx);
    zzb.zza(paramParcel, 4, zzasm);
    zzb.zzc(paramParcel, 5, zzasy);
    zzb.zzJ(paramParcel, paramInt);
  }

  public DriveId zzdK(Parcel paramParcel)
  {
    long l1 = 0L;
    int k = zza.zzcQ(paramParcel);
    int j = 0;
    String str = null;
    int i = -1;
    long l2 = 0L;
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
        l2 = zza.zzi(paramParcel, m);
        break;
      case 4:
        l1 = zza.zzi(paramParcel, m);
        break;
      case 5:
        i = zza.zzg(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k)
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    return new DriveId(j, str, l2, l1, i);
  }

  public DriveId[] zzfX(int paramInt)
  {
    return new DriveId[paramInt];
  }
}
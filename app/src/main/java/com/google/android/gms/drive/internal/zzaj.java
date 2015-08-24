package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.Permission;
import java.util.ArrayList;

public class zzaj
  implements Parcelable.Creator<GetPermissionsResponse>
{
  static void zza(GetPermissionsResponse paramGetPermissionsResponse, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zzd(paramParcel, 2, zzavw, false);
    zzb.zzc(paramParcel, 3, zzwV);
    zzb.zzJ(paramParcel, paramInt);
  }

  public GetPermissionsResponse zzeq(Parcel paramParcel)
  {
    int j = 0;
    int k = zza.zzcQ(paramParcel);
    ArrayList localArrayList = null;
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
        i = zza.zzg(paramParcel, m);
        break;
      case 2:
        localArrayList = zza.zzc(paramParcel, m, Permission.CREATOR);
        break;
      case 3:
        j = zza.zzg(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k)
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    return new GetPermissionsResponse(i, localArrayList, j);
  }

  public GetPermissionsResponse[] zzgK(int paramInt)
  {
    return new GetPermissionsResponse[paramInt];
  }
}
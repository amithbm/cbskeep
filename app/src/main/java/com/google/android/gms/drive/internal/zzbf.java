package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzbf
  implements Parcelable.Creator<OnResourceIdSetResponse>
{
  static void zza(OnResourceIdSetResponse paramOnResourceIdSetResponse, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, paramOnResourceIdSetResponse.getVersionCode());
    zzb.zzc(paramParcel, 2, paramOnResourceIdSetResponse.zzsR(), false);
    zzb.zzJ(paramParcel, paramInt);
  }

  public OnResourceIdSetResponse zzeF(Parcel paramParcel)
  {
    int j = zza.zzcQ(paramParcel);
    int i = 0;
    ArrayList localArrayList = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = zza.zzcP(paramParcel);
      switch (zza.zzeS(k))
      {
      default:
        zza.zzb(paramParcel, k);
        break;
      case 1:
        i = zza.zzg(paramParcel, k);
        break;
      case 2:
        localArrayList = zza.zzE(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new OnResourceIdSetResponse(i, localArrayList);
  }

  public OnResourceIdSetResponse[] zzgZ(int paramInt)
  {
    return new OnResourceIdSetResponse[paramInt];
  }
}
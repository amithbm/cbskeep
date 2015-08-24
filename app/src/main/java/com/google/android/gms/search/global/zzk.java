package com.google.android.gms.search.global;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzk
  implements Parcelable.Creator<SetIncludeInGlobalSearchCall.Request>
{
  static void zza(SetIncludeInGlobalSearchCall.Request paramRequest, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1000, mVersionCode);
    zzb.zza(paramParcel, 1, packageName, false);
    zzb.zza(paramParcel, 2, enabled);
    zzb.zzJ(paramParcel, paramInt);
  }

  public SetIncludeInGlobalSearchCall.Request zzly(Parcel paramParcel)
  {
    boolean bool = false;
    int j = zza.zzcQ(paramParcel);
    String str = null;
    int i = 0;
    while (paramParcel.dataPosition() < j)
    {
      int k = zza.zzcP(paramParcel);
      switch (zza.zzeS(k))
      {
      default:
        zza.zzb(paramParcel, k);
        break;
      case 1000:
        i = zza.zzg(paramParcel, k);
        break;
      case 1:
        str = zza.zzp(paramParcel, k);
        break;
      case 2:
        bool = zza.zzc(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new SetIncludeInGlobalSearchCall.Request(i, str, bool);
  }

  public SetIncludeInGlobalSearchCall.Request[] zzpc(int paramInt)
  {
    return new SetIncludeInGlobalSearchCall.Request[paramInt];
  }
}
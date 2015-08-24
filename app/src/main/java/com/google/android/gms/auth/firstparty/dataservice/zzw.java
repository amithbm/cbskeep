package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzw
  implements Parcelable.Creator<GplusInfoResponse>
{
  static void zza(GplusInfoResponse paramGplusInfoResponse, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, version);
    zzb.zza(paramParcel, 2, zzTb);
    zzb.zza(paramParcel, 3, firstName, false);
    zzb.zza(paramParcel, 4, lastName, false);
    zzb.zza(paramParcel, 5, zzTc, false);
    zzb.zza(paramParcel, 6, zzTd);
    zzb.zza(paramParcel, 7, zzTe);
    zzb.zza(paramParcel, 8, zzTf, false);
    zzb.zza(paramParcel, 9, zzTa, false);
    zzb.zza(paramParcel, 10, zzTg, false);
    zzb.zzJ(paramParcel, paramInt);
  }

  public GplusInfoResponse[] zzbW(int paramInt)
  {
    return new GplusInfoResponse[paramInt];
  }

  public GplusInfoResponse zzba(Parcel paramParcel)
  {
    boolean bool1 = false;
    String str1 = null;
    int j = zza.zzcQ(paramParcel);
    String str2 = null;
    String str3 = null;
    boolean bool2 = false;
    String str4 = null;
    String str5 = null;
    String str6 = null;
    boolean bool3 = false;
    int i = 0;
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
        bool3 = zza.zzc(paramParcel, k);
        break;
      case 3:
        str6 = zza.zzp(paramParcel, k);
        break;
      case 4:
        str5 = zza.zzp(paramParcel, k);
        break;
      case 5:
        str4 = zza.zzp(paramParcel, k);
        break;
      case 6:
        bool2 = zza.zzc(paramParcel, k);
        break;
      case 7:
        bool1 = zza.zzc(paramParcel, k);
        break;
      case 8:
        str3 = zza.zzp(paramParcel, k);
        break;
      case 9:
        str2 = zza.zzp(paramParcel, k);
        break;
      case 10:
        str1 = zza.zzp(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new GplusInfoResponse(i, bool3, str6, str5, str4, bool2, bool1, str3, str2, str1);
  }
}
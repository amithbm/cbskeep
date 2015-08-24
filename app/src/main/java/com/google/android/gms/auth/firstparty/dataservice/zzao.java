package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.firstparty.shared.AppDescription;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzao
  implements Parcelable.Creator<WebSetupConfigRequest>
{
  static void zza(WebSetupConfigRequest paramWebSetupConfigRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, version);
    zzb.zza(paramParcel, 2, callingAppDescription, paramInt, false);
    zzb.zzJ(paramParcel, i);
  }

  public WebSetupConfigRequest zzbr(Parcel paramParcel)
  {
    int j = zza.zzcQ(paramParcel);
    int i = 0;
    AppDescription localAppDescription = null;
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
        localAppDescription = (AppDescription)zza.zza(paramParcel, k, AppDescription.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new WebSetupConfigRequest(i, localAppDescription);
  }

  public WebSetupConfigRequest[] zzcn(int paramInt)
  {
    return new WebSetupConfigRequest[paramInt];
  }
}
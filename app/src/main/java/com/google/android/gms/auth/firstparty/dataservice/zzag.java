package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzag
  implements Parcelable.Creator<ReauthSettingsResponse>
{
  static void zza(ReauthSettingsResponse paramReauthSettingsResponse, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, version);
    zzb.zzc(paramParcel, 2, status);
    zzb.zza(paramParcel, 3, password, paramInt, false);
    zzb.zza(paramParcel, 4, pin, paramInt, false);
    zzb.zzJ(paramParcel, i);
  }

  public ReauthSettingsResponse zzbj(Parcel paramParcel)
  {
    PinSettings localPinSettings = null;
    int j = 0;
    int m = zza.zzcQ(paramParcel);
    PasswordSettings localPasswordSettings = null;
    int i = 0;
    if (paramParcel.dataPosition() < m)
    {
      int k = zza.zzcP(paramParcel);
      switch (zza.zzeS(k))
      {
      default:
        zza.zzb(paramParcel, k);
        k = j;
        j = i;
        i = k;
      case 1:
      case 2:
      case 3:
      case 4:
      }
      while (true)
      {
        k = j;
        j = i;
        i = k;
        break;
        k = zza.zzg(paramParcel, k);
        i = j;
        j = k;
        continue;
        k = zza.zzg(paramParcel, k);
        j = i;
        i = k;
        continue;
        localPasswordSettings = (PasswordSettings)zza.zza(paramParcel, k, PasswordSettings.CREATOR);
        k = i;
        i = j;
        j = k;
        continue;
        localPinSettings = (PinSettings)zza.zza(paramParcel, k, PinSettings.CREATOR);
        k = i;
        i = j;
        j = k;
      }
    }
    if (paramParcel.dataPosition() != m)
      throw new zza.zza("Overread allowed size end=" + m, paramParcel);
    return new ReauthSettingsResponse(i, j, localPasswordSettings, localPinSettings);
  }

  public ReauthSettingsResponse[] zzcf(int paramInt)
  {
    return new ReauthSettingsResponse[paramInt];
  }
}
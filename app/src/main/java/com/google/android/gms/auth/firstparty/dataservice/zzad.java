package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzad
  implements Parcelable.Creator<PinSettings>
{
  static void zza(PinSettings paramPinSettings, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, version);
    zzb.zza(paramParcel, 2, status, false);
    zzb.zza(paramParcel, 3, resetUrl, false);
    zzb.zza(paramParcel, 4, setupUrl, false);
    zzb.zzc(paramParcel, 5, length);
    zzb.zza(paramParcel, 6, recoveryUrl, false);
    zzb.zzJ(paramParcel, paramInt);
  }

  public PinSettings zzbg(Parcel paramParcel)
  {
    int i = 0;
    String str1 = null;
    int k = zza.zzcQ(paramParcel);
    String str2 = null;
    String str3 = null;
    String str4 = null;
    int j = 0;
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
        str4 = zza.zzp(paramParcel, m);
        break;
      case 3:
        str3 = zza.zzp(paramParcel, m);
        break;
      case 4:
        str2 = zza.zzp(paramParcel, m);
        break;
      case 5:
        i = zza.zzg(paramParcel, m);
        break;
      case 6:
        str1 = zza.zzp(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k)
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    return new PinSettings(j, str4, str3, str2, str1, i);
  }

  public PinSettings[] zzcc(int paramInt)
  {
    return new PinSettings[paramInt];
  }
}
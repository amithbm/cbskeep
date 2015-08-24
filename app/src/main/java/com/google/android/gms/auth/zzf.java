package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzf
  implements Parcelable.Creator<RecoveryReadResponse>
{
  static void zza(RecoveryReadResponse paramRecoveryReadResponse, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zza(paramParcel, 2, mSecondaryEmail, false);
    zzb.zza(paramParcel, 3, mPhoneNumber, false);
    zzb.zza(paramParcel, 4, mPhoneCountryCode, false);
    zzb.zzd(paramParcel, 5, mCountryList, false);
    zzb.zza(paramParcel, 6, mError, false);
    zzb.zza(paramParcel, 7, mAction, false);
    zzb.zza(paramParcel, 8, mAllowedOptions, false);
    zzb.zzJ(paramParcel, paramInt);
  }

  public RecoveryReadResponse zzao(Parcel paramParcel)
  {
    String str1 = null;
    int j = zza.zzcQ(paramParcel);
    int i = 0;
    String str2 = null;
    String str3 = null;
    ArrayList localArrayList = null;
    String str4 = null;
    String str5 = null;
    String str6 = null;
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
        str6 = zza.zzp(paramParcel, k);
        break;
      case 3:
        str5 = zza.zzp(paramParcel, k);
        break;
      case 4:
        str4 = zza.zzp(paramParcel, k);
        break;
      case 5:
        localArrayList = zza.zzc(paramParcel, k, Country.CREATOR);
        break;
      case 6:
        str3 = zza.zzp(paramParcel, k);
        break;
      case 7:
        str2 = zza.zzp(paramParcel, k);
        break;
      case 8:
        str1 = zza.zzp(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new RecoveryReadResponse(i, str6, str5, str4, localArrayList, str3, str2, str1);
  }

  public RecoveryReadResponse[] zzbk(int paramInt)
  {
    return new RecoveryReadResponse[paramInt];
  }
}
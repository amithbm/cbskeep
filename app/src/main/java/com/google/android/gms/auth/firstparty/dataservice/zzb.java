package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.firstparty.shared.CaptchaChallenge;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import java.util.ArrayList;

public class zzb
  implements Parcelable.Creator<AccountNameCheckResponse>
{
  static void zza(AccountNameCheckResponse paramAccountNameCheckResponse, Parcel paramParcel, int paramInt)
  {
    int i = com.google.android.gms.common.internal.safeparcel.zzb.zzcR(paramParcel);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 1, version);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 2, zzRY, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 3, zzRZ, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 4, zzSa, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 5, zzSb, paramInt, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zzJ(paramParcel, i);
  }

  public AccountNameCheckResponse zzaF(Parcel paramParcel)
  {
    CaptchaChallenge localCaptchaChallenge = null;
    int j = zza.zzcQ(paramParcel);
    int i = 0;
    String str1 = null;
    ArrayList localArrayList = null;
    String str2 = null;
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
        str2 = zza.zzp(paramParcel, k);
        break;
      case 3:
        localArrayList = zza.zzE(paramParcel, k);
        break;
      case 4:
        str1 = zza.zzp(paramParcel, k);
        break;
      case 5:
        localCaptchaChallenge = (CaptchaChallenge)zza.zza(paramParcel, k, CaptchaChallenge.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new AccountNameCheckResponse(i, str2, localArrayList, str1, localCaptchaChallenge);
  }

  public AccountNameCheckResponse[] zzbB(int paramInt)
  {
    return new AccountNameCheckResponse[paramInt];
  }
}
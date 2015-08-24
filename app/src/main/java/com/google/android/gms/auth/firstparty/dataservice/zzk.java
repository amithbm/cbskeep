package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.firstparty.shared.AccountCredentials;
import com.google.android.gms.auth.firstparty.shared.AppDescription;
import com.google.android.gms.auth.firstparty.shared.CaptchaSolution;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzk
  implements Parcelable.Creator<AccountSignInRequest>
{
  static void zza(AccountSignInRequest paramAccountSignInRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, version);
    zzb.zza(paramParcel, 2, callingAppDescription, paramInt, false);
    zzb.zza(paramParcel, 3, zzSq);
    zzb.zza(paramParcel, 4, zzSr);
    zzb.zza(paramParcel, 5, zzRW, paramInt, false);
    zzb.zza(paramParcel, 6, zzSs, paramInt, false);
    zzb.zzJ(paramParcel, i);
  }

  public AccountSignInRequest zzaO(Parcel paramParcel)
  {
    AccountCredentials localAccountCredentials = null;
    boolean bool1 = false;
    int j = zza.zzcQ(paramParcel);
    CaptchaSolution localCaptchaSolution = null;
    boolean bool2 = false;
    AppDescription localAppDescription = null;
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
        localAppDescription = (AppDescription)zza.zza(paramParcel, k, AppDescription.CREATOR);
        break;
      case 3:
        bool2 = zza.zzc(paramParcel, k);
        break;
      case 4:
        bool1 = zza.zzc(paramParcel, k);
        break;
      case 5:
        localCaptchaSolution = (CaptchaSolution)zza.zza(paramParcel, k, CaptchaSolution.CREATOR);
        break;
      case 6:
        localAccountCredentials = (AccountCredentials)zza.zza(paramParcel, k, AccountCredentials.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new AccountSignInRequest(i, localAppDescription, bool2, bool1, localCaptchaSolution, localAccountCredentials);
  }

  public AccountSignInRequest[] zzbK(int paramInt)
  {
    return new AccountSignInRequest[paramInt];
  }
}
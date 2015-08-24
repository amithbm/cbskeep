package com.google.android.gms.auth.firstparty.dataservice;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.firstparty.shared.AppDescription;
import com.google.android.gms.auth.firstparty.shared.CaptchaSolution;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza
  implements Parcelable.Creator<AccountNameCheckRequest>
{
  static void zza(AccountNameCheckRequest paramAccountNameCheckRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, version);
    zzb.zza(paramParcel, 2, zzRT, false);
    zzb.zza(paramParcel, 3, zzRU, false);
    zzb.zza(paramParcel, 4, zzRV, false);
    zzb.zza(paramParcel, 5, callingAppDescription, paramInt, false);
    zzb.zza(paramParcel, 6, zzRW, paramInt, false);
    zzb.zza(paramParcel, 7, zzRX, paramInt, false);
    zzb.zzJ(paramParcel, i);
  }

  public AccountNameCheckRequest zzaE(Parcel paramParcel)
  {
    Account localAccount = null;
    int j = com.google.android.gms.common.internal.safeparcel.zza.zzcQ(paramParcel);
    int i = 0;
    CaptchaSolution localCaptchaSolution = null;
    AppDescription localAppDescription = null;
    String str1 = null;
    String str2 = null;
    String str3 = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = com.google.android.gms.common.internal.safeparcel.zza.zzcP(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.zza.zzeS(k))
      {
      default:
        com.google.android.gms.common.internal.safeparcel.zza.zzb(paramParcel, k);
        break;
      case 1:
        i = com.google.android.gms.common.internal.safeparcel.zza.zzg(paramParcel, k);
        break;
      case 2:
        str3 = com.google.android.gms.common.internal.safeparcel.zza.zzp(paramParcel, k);
        break;
      case 3:
        str2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(paramParcel, k);
        break;
      case 4:
        str1 = com.google.android.gms.common.internal.safeparcel.zza.zzp(paramParcel, k);
        break;
      case 5:
        localAppDescription = (AppDescription)com.google.android.gms.common.internal.safeparcel.zza.zza(paramParcel, k, AppDescription.CREATOR);
        break;
      case 6:
        localCaptchaSolution = (CaptchaSolution)com.google.android.gms.common.internal.safeparcel.zza.zza(paramParcel, k, CaptchaSolution.CREATOR);
        break;
      case 7:
        localAccount = (Account)com.google.android.gms.common.internal.safeparcel.zza.zza(paramParcel, k, Account.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new AccountNameCheckRequest(i, str3, str2, str1, localAppDescription, localCaptchaSolution, localAccount);
  }

  public AccountNameCheckRequest[] zzbA(int paramInt)
  {
    return new AccountNameCheckRequest[paramInt];
  }
}
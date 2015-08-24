package com.google.android.gms.auth.firstparty.dataservice;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.firstparty.shared.AppDescription;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzd
  implements Parcelable.Creator<AccountRecoveryDataRequest>
{
  static void zza(AccountRecoveryDataRequest paramAccountRecoveryDataRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, version);
    zzb.zza(paramParcel, 2, accountName, false);
    zzb.zza(paramParcel, 3, isClearUpdateSuggested);
    zzb.zza(paramParcel, 4, callingAppDescription, paramInt, false);
    zzb.zza(paramParcel, 5, requestDescription, false);
    zzb.zza(paramParcel, 6, account, paramInt, false);
    zzb.zzJ(paramParcel, i);
  }

  public AccountRecoveryDataRequest zzaH(Parcel paramParcel)
  {
    boolean bool = false;
    Account localAccount = null;
    int j = zza.zzcQ(paramParcel);
    String str1 = null;
    AppDescription localAppDescription = null;
    String str2 = null;
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
        str2 = zza.zzp(paramParcel, k);
        break;
      case 3:
        bool = zza.zzc(paramParcel, k);
        break;
      case 4:
        localAppDescription = (AppDescription)zza.zza(paramParcel, k, AppDescription.CREATOR);
        break;
      case 5:
        str1 = zza.zzp(paramParcel, k);
        break;
      case 6:
        localAccount = (Account)zza.zza(paramParcel, k, Account.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new AccountRecoveryDataRequest(i, str2, bool, localAppDescription, str1, localAccount);
  }

  public AccountRecoveryDataRequest[] zzbD(int paramInt)
  {
    return new AccountRecoveryDataRequest[paramInt];
  }
}
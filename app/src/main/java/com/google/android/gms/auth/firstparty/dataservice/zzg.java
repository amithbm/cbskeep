package com.google.android.gms.auth.firstparty.dataservice;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.firstparty.shared.AppDescription;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzg
  implements Parcelable.Creator<AccountRecoveryUpdateRequest>
{
  static void zza(AccountRecoveryUpdateRequest paramAccountRecoveryUpdateRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, version);
    zzb.zza(paramParcel, 2, accountName, false);
    zzb.zza(paramParcel, 3, secondaryEmail, false);
    zzb.zza(paramParcel, 4, phoneNumber, false);
    zzb.zza(paramParcel, 5, phoneCountryCode, false);
    zzb.zza(paramParcel, 6, isBroadUse);
    zzb.zza(paramParcel, 7, callingAppDescription, paramInt, false);
    zzb.zza(paramParcel, 8, account, paramInt, false);
    zzb.zzJ(paramParcel, i);
  }

  public AccountRecoveryUpdateRequest zzaK(Parcel paramParcel)
  {
    boolean bool = false;
    Account localAccount = null;
    int j = zza.zzcQ(paramParcel);
    AppDescription localAppDescription = null;
    String str1 = null;
    String str2 = null;
    String str3 = null;
    String str4 = null;
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
        str4 = zza.zzp(paramParcel, k);
        break;
      case 3:
        str3 = zza.zzp(paramParcel, k);
        break;
      case 4:
        str2 = zza.zzp(paramParcel, k);
        break;
      case 5:
        str1 = zza.zzp(paramParcel, k);
        break;
      case 6:
        bool = zza.zzc(paramParcel, k);
        break;
      case 7:
        localAppDescription = (AppDescription)zza.zza(paramParcel, k, AppDescription.CREATOR);
        break;
      case 8:
        localAccount = (Account)zza.zza(paramParcel, k, Account.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new AccountRecoveryUpdateRequest(i, str4, str3, str2, str1, bool, localAppDescription, localAccount);
  }

  public AccountRecoveryUpdateRequest[] zzbG(int paramInt)
  {
    return new AccountRecoveryUpdateRequest[paramInt];
  }
}
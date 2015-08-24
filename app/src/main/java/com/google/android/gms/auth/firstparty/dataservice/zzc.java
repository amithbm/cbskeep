package com.google.android.gms.auth.firstparty.dataservice;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.Country;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzc
  implements Parcelable.Creator<AccountRecoveryData>
{
  static void zza(AccountRecoveryData paramAccountRecoveryData, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, version);
    zzb.zza(paramParcel, 2, guidance, paramInt, false);
    zzb.zza(paramParcel, 3, action, false);
    zzb.zza(paramParcel, 4, allowedRecoveryOption, false);
    zzb.zza(paramParcel, 5, accountName, false);
    zzb.zza(paramParcel, 6, secondaryEmail, false);
    zzb.zza(paramParcel, 7, phoneNumber, false);
    zzb.zzd(paramParcel, 8, countries, false);
    zzb.zza(paramParcel, 9, defaultCountryCode, false);
    zzb.zza(paramParcel, 10, error, false);
    zzb.zza(paramParcel, 11, account, paramInt, false);
    zzb.zzJ(paramParcel, i);
  }

  public AccountRecoveryData zzaG(Parcel paramParcel)
  {
    Account localAccount = null;
    int j = zza.zzcQ(paramParcel);
    int i = 0;
    String str1 = null;
    String str2 = null;
    ArrayList localArrayList = null;
    String str3 = null;
    String str4 = null;
    String str5 = null;
    String str6 = null;
    String str7 = null;
    AccountRecoveryGuidance localAccountRecoveryGuidance = null;
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
        localAccountRecoveryGuidance = (AccountRecoveryGuidance)zza.zza(paramParcel, k, AccountRecoveryGuidance.CREATOR);
        break;
      case 3:
        str7 = zza.zzp(paramParcel, k);
        break;
      case 4:
        str6 = zza.zzp(paramParcel, k);
        break;
      case 5:
        str5 = zza.zzp(paramParcel, k);
        break;
      case 6:
        str4 = zza.zzp(paramParcel, k);
        break;
      case 7:
        str3 = zza.zzp(paramParcel, k);
        break;
      case 8:
        localArrayList = zza.zzc(paramParcel, k, Country.CREATOR);
        break;
      case 9:
        str2 = zza.zzp(paramParcel, k);
        break;
      case 10:
        str1 = zza.zzp(paramParcel, k);
        break;
      case 11:
        localAccount = (Account)zza.zza(paramParcel, k, Account.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new AccountRecoveryData(i, localAccountRecoveryGuidance, str7, str6, str5, str4, str3, localArrayList, str2, str1, localAccount);
  }

  public AccountRecoveryData[] zzbC(int paramInt)
  {
    return new AccountRecoveryData[paramInt];
  }
}
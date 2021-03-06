package com.google.android.gms.auth.firstparty.dataservice;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zze
  implements Parcelable.Creator<AccountRecoveryGuidance>
{
  static void zza(AccountRecoveryGuidance paramAccountRecoveryGuidance, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, version);
    zzb.zza(paramParcel, 2, accountName, false);
    zzb.zza(paramParcel, 3, isRecoveryInfoNeeded);
    zzb.zza(paramParcel, 4, isRecoveryInterstitialSuggested);
    zzb.zza(paramParcel, 5, isRecoveryUpdateAllowed);
    zzb.zza(paramParcel, 6, account, paramInt, false);
    zzb.zzJ(paramParcel, i);
  }

  public AccountRecoveryGuidance zzaI(Parcel paramParcel)
  {
    Account localAccount = null;
    boolean bool1 = false;
    int j = zza.zzcQ(paramParcel);
    boolean bool2 = false;
    boolean bool3 = false;
    String str = null;
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
        str = zza.zzp(paramParcel, k);
        break;
      case 3:
        bool3 = zza.zzc(paramParcel, k);
        break;
      case 4:
        bool2 = zza.zzc(paramParcel, k);
        break;
      case 5:
        bool1 = zza.zzc(paramParcel, k);
        break;
      case 6:
        localAccount = (Account)zza.zza(paramParcel, k, Account.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new AccountRecoveryGuidance(i, str, bool3, bool2, bool1, localAccount);
  }

  public AccountRecoveryGuidance[] zzbE(int paramInt)
  {
    return new AccountRecoveryGuidance[paramInt];
  }
}
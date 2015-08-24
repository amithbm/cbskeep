package com.google.android.gms.auth.firstparty.dataservice;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzal
  implements Parcelable.Creator<VerifyPinRequest>
{
  static void zza(VerifyPinRequest paramVerifyPinRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, version);
    zzb.zza(paramParcel, 2, accountName, false);
    zzb.zza(paramParcel, 3, pin, false);
    zzb.zza(paramParcel, 4, account, paramInt, false);
    zzb.zza(paramParcel, 5, callingPackageName, false);
    zzb.zzJ(paramParcel, i);
  }

  public VerifyPinRequest zzbo(Parcel paramParcel)
  {
    String str1 = null;
    int j = zza.zzcQ(paramParcel);
    int i = 0;
    Account localAccount = null;
    String str2 = null;
    String str3 = null;
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
        str3 = zza.zzp(paramParcel, k);
        break;
      case 3:
        str2 = zza.zzp(paramParcel, k);
        break;
      case 4:
        localAccount = (Account)zza.zza(paramParcel, k, Account.CREATOR);
        break;
      case 5:
        str1 = zza.zzp(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new VerifyPinRequest(i, str3, str2, localAccount, str1);
  }

  public VerifyPinRequest[] zzck(int paramInt)
  {
    return new VerifyPinRequest[paramInt];
  }
}
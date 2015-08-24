package com.google.android.gms.auth.firstparty.delegate;

import android.accounts.Account;
import android.accounts.AccountAuthenticatorResponse;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.firstparty.shared.AppDescription;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza
  implements Parcelable.Creator<ConfirmCredentialsWorkflowRequest>
{
  static void zza(ConfirmCredentialsWorkflowRequest paramConfirmCredentialsWorkflowRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, version);
    zzb.zza(paramParcel, 2, accountName, false);
    zzb.zza(paramParcel, 3, callingAppDescription, paramInt, false);
    zzb.zza(paramParcel, 4, options, false);
    zzb.zza(paramParcel, 5, account, paramInt, false);
    zzb.zza(paramParcel, 6, amResponse, paramInt, false);
    zzb.zzJ(paramParcel, i);
  }

  public ConfirmCredentialsWorkflowRequest zzbs(Parcel paramParcel)
  {
    AccountAuthenticatorResponse localAccountAuthenticatorResponse = null;
    int j = com.google.android.gms.common.internal.safeparcel.zza.zzcQ(paramParcel);
    int i = 0;
    Bundle localBundle = new Bundle();
    Account localAccount = null;
    AppDescription localAppDescription = null;
    String str = null;
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
        str = com.google.android.gms.common.internal.safeparcel.zza.zzp(paramParcel, k);
        break;
      case 3:
        localAppDescription = (AppDescription)com.google.android.gms.common.internal.safeparcel.zza.zza(paramParcel, k, AppDescription.CREATOR);
        break;
      case 4:
        localBundle = com.google.android.gms.common.internal.safeparcel.zza.zzr(paramParcel, k);
        break;
      case 5:
        localAccount = (Account)com.google.android.gms.common.internal.safeparcel.zza.zza(paramParcel, k, Account.CREATOR);
        break;
      case 6:
        localAccountAuthenticatorResponse = (AccountAuthenticatorResponse)com.google.android.gms.common.internal.safeparcel.zza.zza(paramParcel, k, AccountAuthenticatorResponse.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new ConfirmCredentialsWorkflowRequest(i, str, localAppDescription, localBundle, localAccount, localAccountAuthenticatorResponse);
  }

  public ConfirmCredentialsWorkflowRequest[] zzco(int paramInt)
  {
    return new ConfirmCredentialsWorkflowRequest[paramInt];
  }
}
package com.google.android.gms.auth.firstparty.delegate;

import android.accounts.Account;
import android.accounts.AccountAuthenticatorResponse;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.firstparty.shared.AppDescription;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zze
  implements Parcelable.Creator<UpdateCredentialsWorkflowRequest>
{
  static void zza(UpdateCredentialsWorkflowRequest paramUpdateCredentialsWorkflowRequest, Parcel paramParcel, int paramInt)
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

  public UpdateCredentialsWorkflowRequest zzbv(Parcel paramParcel)
  {
    AccountAuthenticatorResponse localAccountAuthenticatorResponse = null;
    int j = zza.zzcQ(paramParcel);
    int i = 0;
    Bundle localBundle = new Bundle();
    Account localAccount = null;
    AppDescription localAppDescription = null;
    String str = null;
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
        localAppDescription = (AppDescription)zza.zza(paramParcel, k, AppDescription.CREATOR);
        break;
      case 4:
        localBundle = zza.zzr(paramParcel, k);
        break;
      case 5:
        localAccount = (Account)zza.zza(paramParcel, k, Account.CREATOR);
        break;
      case 6:
        localAccountAuthenticatorResponse = (AccountAuthenticatorResponse)zza.zza(paramParcel, k, AccountAuthenticatorResponse.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new UpdateCredentialsWorkflowRequest(i, str, localAppDescription, localBundle, localAccount, localAccountAuthenticatorResponse);
  }

  public UpdateCredentialsWorkflowRequest[] zzcr(int paramInt)
  {
    return new UpdateCredentialsWorkflowRequest[paramInt];
  }
}
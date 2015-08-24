package com.google.android.gms.auth.firstparty.delegate;

import android.accounts.Account;
import android.accounts.AccountAuthenticatorResponse;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.firstparty.shared.AppDescription;
import com.google.android.gms.auth.firstparty.shared.FACLConfig;
import com.google.android.gms.auth.firstparty.shared.PACLConfig;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzd
  implements Parcelable.Creator<TokenWorkflowRequest>
{
  static void zza(TokenWorkflowRequest paramTokenWorkflowRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, version);
    zzb.zza(paramParcel, 2, zzTj, false);
    zzb.zza(paramParcel, 3, accountName, false);
    zzb.zza(paramParcel, 4, options, false);
    zzb.zza(paramParcel, 5, zzTk, paramInt, false);
    zzb.zza(paramParcel, 6, zzTl, paramInt, false);
    zzb.zza(paramParcel, 7, zzTG);
    zzb.zza(paramParcel, 8, callingAppDescription, paramInt, false);
    zzb.zza(paramParcel, 9, account, paramInt, false);
    zzb.zza(paramParcel, 10, amResponse, paramInt, false);
    zzb.zzJ(paramParcel, i);
  }

  public TokenWorkflowRequest zzbu(Parcel paramParcel)
  {
    boolean bool = false;
    AccountAuthenticatorResponse localAccountAuthenticatorResponse = null;
    int j = zza.zzcQ(paramParcel);
    Bundle localBundle = new Bundle();
    Account localAccount = null;
    AppDescription localAppDescription = null;
    PACLConfig localPACLConfig = null;
    FACLConfig localFACLConfig = null;
    String str1 = null;
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
        str1 = zza.zzp(paramParcel, k);
        break;
      case 4:
        localBundle = zza.zzr(paramParcel, k);
        break;
      case 5:
        localFACLConfig = (FACLConfig)zza.zza(paramParcel, k, FACLConfig.CREATOR);
        break;
      case 6:
        localPACLConfig = (PACLConfig)zza.zza(paramParcel, k, PACLConfig.CREATOR);
        break;
      case 7:
        bool = zza.zzc(paramParcel, k);
        break;
      case 8:
        localAppDescription = (AppDescription)zza.zza(paramParcel, k, AppDescription.CREATOR);
        break;
      case 9:
        localAccount = (Account)zza.zza(paramParcel, k, Account.CREATOR);
        break;
      case 10:
        localAccountAuthenticatorResponse = (AccountAuthenticatorResponse)zza.zza(paramParcel, k, AccountAuthenticatorResponse.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new TokenWorkflowRequest(i, str2, str1, localBundle, localFACLConfig, localPACLConfig, bool, localAppDescription, localAccount, localAccountAuthenticatorResponse);
  }

  public TokenWorkflowRequest[] zzcq(int paramInt)
  {
    return new TokenWorkflowRequest[paramInt];
  }
}
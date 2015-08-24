package com.google.android.gms.auth.firstparty.delegate;

import android.accounts.AccountAuthenticatorResponse;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.firstparty.shared.AppDescription;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzc
  implements Parcelable.Creator<SetupAccountWorkflowRequest>
{
  static void zza(SetupAccountWorkflowRequest paramSetupAccountWorkflowRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, version);
    zzb.zza(paramParcel, 2, isMultiUser);
    zzb.zza(paramParcel, 3, isSetupWizard);
    zzb.zzc(paramParcel, 4, allowedDomains, false);
    zzb.zza(paramParcel, 5, options, false);
    zzb.zza(paramParcel, 6, callingAppDescription, paramInt, false);
    zzb.zza(paramParcel, 7, isCreditCardAllowed);
    zzb.zza(paramParcel, 8, accountType, false);
    zzb.zza(paramParcel, 9, amResponse, paramInt, false);
    zzb.zza(paramParcel, 10, suppressD2d);
    zzb.zza(paramParcel, 11, useImmersiveMode);
    zzb.zza(paramParcel, 12, purchaserGaiaEmail, false);
    zzb.zza(paramParcel, 13, purchaserName, false);
    zzb.zza(paramParcel, 14, accountName, false);
    zzb.zzJ(paramParcel, i);
  }

  public SetupAccountWorkflowRequest zzbt(Parcel paramParcel)
  {
    int j = zza.zzcQ(paramParcel);
    int i = 0;
    boolean bool5 = false;
    boolean bool4 = false;
    ArrayList localArrayList = null;
    Bundle localBundle = new Bundle();
    AppDescription localAppDescription = null;
    boolean bool3 = false;
    String str4 = null;
    AccountAuthenticatorResponse localAccountAuthenticatorResponse = null;
    boolean bool2 = false;
    boolean bool1 = false;
    String str3 = "null";
    String str2 = "null";
    String str1 = null;
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
        bool5 = zza.zzc(paramParcel, k);
        break;
      case 3:
        bool4 = zza.zzc(paramParcel, k);
        break;
      case 4:
        localArrayList = zza.zzE(paramParcel, k);
        break;
      case 5:
        localBundle = zza.zzr(paramParcel, k);
        break;
      case 6:
        localAppDescription = (AppDescription)zza.zza(paramParcel, k, AppDescription.CREATOR);
        break;
      case 7:
        bool3 = zza.zzc(paramParcel, k);
        break;
      case 8:
        str4 = zza.zzp(paramParcel, k);
        break;
      case 9:
        localAccountAuthenticatorResponse = (AccountAuthenticatorResponse)zza.zza(paramParcel, k, AccountAuthenticatorResponse.CREATOR);
        break;
      case 10:
        bool2 = zza.zzc(paramParcel, k);
        break;
      case 11:
        bool1 = zza.zzc(paramParcel, k);
        break;
      case 12:
        str3 = zza.zzp(paramParcel, k);
        break;
      case 13:
        str2 = zza.zzp(paramParcel, k);
        break;
      case 14:
        str1 = zza.zzp(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new SetupAccountWorkflowRequest(i, bool5, bool4, localArrayList, localBundle, localAppDescription, bool3, str4, localAccountAuthenticatorResponse, bool2, bool1, str3, str2, str1);
  }

  public SetupAccountWorkflowRequest[] zzcp(int paramInt)
  {
    return new SetupAccountWorkflowRequest[paramInt];
  }
}
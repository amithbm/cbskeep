package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.firstparty.shared.AppDescription;
import com.google.android.gms.auth.firstparty.shared.CaptchaSolution;
import com.google.android.gms.auth.firstparty.shared.FACLConfig;
import com.google.android.gms.auth.firstparty.shared.PACLConfig;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzah
  implements Parcelable.Creator<TokenRequest>
{
  static void zza(TokenRequest paramTokenRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, version);
    zzb.zza(paramParcel, 2, zzTj, false);
    zzb.zza(paramParcel, 3, accountName, false);
    zzb.zza(paramParcel, 4, options, false);
    zzb.zza(paramParcel, 5, zzTk, paramInt, false);
    zzb.zza(paramParcel, 6, zzTl, paramInt, false);
    zzb.zza(paramParcel, 7, zzSZ);
    zzb.zza(paramParcel, 8, zzSq);
    zzb.zza(paramParcel, 9, zzTm, false);
    zzb.zza(paramParcel, 10, callingAppDescription, paramInt, false);
    zzb.zza(paramParcel, 11, zzRW, paramInt, false);
    zzb.zza(paramParcel, 12, zzTn);
    zzb.zza(paramParcel, 13, zzTo);
    zzb.zza(paramParcel, 14, zzTp);
    zzb.zza(paramParcel, 15, accountType, false);
    zzb.zzJ(paramParcel, i);
  }

  public TokenRequest zzbk(Parcel paramParcel)
  {
    int j = zza.zzcQ(paramParcel);
    int i = 0;
    String str4 = null;
    String str3 = null;
    Bundle localBundle = new Bundle();
    FACLConfig localFACLConfig = null;
    PACLConfig localPACLConfig = null;
    boolean bool5 = false;
    boolean bool4 = false;
    String str2 = "com.google.android.gms.auth.firstparty.shared.Consent.UNKNOWN.toString()";
    AppDescription localAppDescription = null;
    CaptchaSolution localCaptchaSolution = null;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    String str1 = "com.google";
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
        localBundle = zza.zzr(paramParcel, k);
        break;
      case 5:
        localFACLConfig = (FACLConfig)zza.zza(paramParcel, k, FACLConfig.CREATOR);
        break;
      case 6:
        localPACLConfig = (PACLConfig)zza.zza(paramParcel, k, PACLConfig.CREATOR);
        break;
      case 7:
        bool5 = zza.zzc(paramParcel, k);
        break;
      case 8:
        bool4 = zza.zzc(paramParcel, k);
        break;
      case 9:
        str2 = zza.zzp(paramParcel, k);
        break;
      case 10:
        localAppDescription = (AppDescription)zza.zza(paramParcel, k, AppDescription.CREATOR);
        break;
      case 11:
        localCaptchaSolution = (CaptchaSolution)zza.zza(paramParcel, k, CaptchaSolution.CREATOR);
        break;
      case 12:
        bool3 = zza.zzc(paramParcel, k);
        break;
      case 13:
        bool2 = zza.zzc(paramParcel, k);
        break;
      case 14:
        bool1 = zza.zzc(paramParcel, k);
        break;
      case 15:
        str1 = zza.zzp(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new TokenRequest(i, str4, str3, localBundle, localFACLConfig, localPACLConfig, bool5, bool4, str2, localAppDescription, localCaptchaSolution, bool3, bool2, bool1, str1);
  }

  public TokenRequest[] zzcg(int paramInt)
  {
    return new TokenRequest[paramInt];
  }
}
package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.firstparty.shared.AccountCredentials;
import com.google.android.gms.auth.firstparty.shared.AppDescription;
import com.google.android.gms.auth.firstparty.shared.CaptchaSolution;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzu
  implements Parcelable.Creator<GoogleAccountSetupRequest>
{
  static void zza(GoogleAccountSetupRequest paramGoogleAccountSetupRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, version);
    zzb.zza(paramParcel, 2, options, false);
    zzb.zza(paramParcel, 3, zzSV);
    zzb.zza(paramParcel, 4, zzSW);
    zzb.zza(paramParcel, 5, zzSX);
    zzb.zza(paramParcel, 6, firstName, false);
    zzb.zza(paramParcel, 7, lastName, false);
    zzb.zza(paramParcel, 8, secondaryEmail, false);
    zzb.zza(paramParcel, 9, zzSY, false);
    zzb.zza(paramParcel, 10, zzSq);
    zzb.zza(paramParcel, 11, zzSZ);
    zzb.zza(paramParcel, 12, zzSr);
    zzb.zza(paramParcel, 13, zzTa, false);
    zzb.zza(paramParcel, 14, callingAppDescription, paramInt, false);
    zzb.zza(paramParcel, 15, zzSs, paramInt, false);
    zzb.zza(paramParcel, 17, phoneNumber, false);
    zzb.zza(paramParcel, 16, zzRW, paramInt, false);
    zzb.zza(paramParcel, 18, phoneCountryCode, false);
    zzb.zzJ(paramParcel, i);
  }

  public GoogleAccountSetupRequest zzaY(Parcel paramParcel)
  {
    int j = zza.zzcQ(paramParcel);
    int i = 0;
    Bundle localBundle = new Bundle();
    boolean bool6 = false;
    boolean bool5 = false;
    boolean bool4 = false;
    String str7 = null;
    String str6 = null;
    String str5 = null;
    String str4 = null;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    String str3 = null;
    AppDescription localAppDescription = null;
    AccountCredentials localAccountCredentials = null;
    CaptchaSolution localCaptchaSolution = null;
    String str2 = null;
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
        localBundle = zza.zzr(paramParcel, k);
        break;
      case 3:
        bool6 = zza.zzc(paramParcel, k);
        break;
      case 4:
        bool5 = zza.zzc(paramParcel, k);
        break;
      case 5:
        bool4 = zza.zzc(paramParcel, k);
        break;
      case 6:
        str7 = zza.zzp(paramParcel, k);
        break;
      case 7:
        str6 = zza.zzp(paramParcel, k);
        break;
      case 8:
        str5 = zza.zzp(paramParcel, k);
        break;
      case 9:
        str4 = zza.zzp(paramParcel, k);
        break;
      case 10:
        bool3 = zza.zzc(paramParcel, k);
        break;
      case 11:
        bool2 = zza.zzc(paramParcel, k);
        break;
      case 12:
        bool1 = zza.zzc(paramParcel, k);
        break;
      case 13:
        str3 = zza.zzp(paramParcel, k);
        break;
      case 14:
        localAppDescription = (AppDescription)zza.zza(paramParcel, k, AppDescription.CREATOR);
        break;
      case 15:
        localAccountCredentials = (AccountCredentials)zza.zza(paramParcel, k, AccountCredentials.CREATOR);
        break;
      case 17:
        str2 = zza.zzp(paramParcel, k);
        break;
      case 16:
        localCaptchaSolution = (CaptchaSolution)zza.zza(paramParcel, k, CaptchaSolution.CREATOR);
        break;
      case 18:
        str1 = zza.zzp(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new GoogleAccountSetupRequest(i, localBundle, bool6, bool5, bool4, str7, str6, str5, str4, bool3, bool2, bool1, str3, localAppDescription, localAccountCredentials, localCaptchaSolution, str2, str1);
  }

  public GoogleAccountSetupRequest[] zzbU(int paramInt)
  {
    return new GoogleAccountSetupRequest[paramInt];
  }
}
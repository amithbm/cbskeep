package com.google.android.gms.auth.firstparty.dataservice;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.firstparty.shared.CaptchaChallenge;
import com.google.android.gms.auth.firstparty.shared.ScopeDetail;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzai
  implements Parcelable.Creator<TokenResponse>
{
  static void zza(TokenResponse paramTokenResponse, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, version);
    zzb.zza(paramParcel, 2, accountName, false);
    zzb.zza(paramParcel, 3, zzRY, false);
    zzb.zza(paramParcel, 4, zzSt, false);
    zzb.zza(paramParcel, 5, zzTr, false);
    zzb.zza(paramParcel, 6, zzSa, false);
    zzb.zza(paramParcel, 7, zzTs, false);
    zzb.zza(paramParcel, 8, firstName, false);
    zzb.zza(paramParcel, 9, lastName, false);
    zzb.zza(paramParcel, 10, zzTt);
    zzb.zza(paramParcel, 11, zzTu);
    zzb.zza(paramParcel, 12, zzTv);
    zzb.zza(paramParcel, 13, zzTw);
    zzb.zza(paramParcel, 14, zzSb, paramInt, false);
    zzb.zzd(paramParcel, 15, zzTx, false);
    zzb.zza(paramParcel, 17, zzTa, false);
    zzb.zza(paramParcel, 16, zzTf, false);
    zzb.zza(paramParcel, 19, zzTz);
    zzb.zza(paramParcel, 18, zzTy);
    zzb.zza(paramParcel, 21, zzTA, paramInt, false);
    zzb.zzc(paramParcel, 20, title);
    zzb.zza(paramParcel, 23, zzTB, false);
    zzb.zza(paramParcel, 22, account, paramInt, false);
    zzb.zzc(paramParcel, 25, zzTD, false);
    zzb.zza(paramParcel, 24, zzTC);
    zzb.zzJ(paramParcel, i);
  }

  public TokenResponse zzbl(Parcel paramParcel)
  {
    int k = zza.zzcQ(paramParcel);
    int j = 0;
    String str10 = null;
    String str9 = null;
    String str8 = null;
    String str7 = null;
    String str6 = null;
    String str5 = null;
    String str4 = null;
    String str3 = null;
    boolean bool7 = false;
    boolean bool6 = false;
    boolean bool5 = false;
    boolean bool4 = false;
    CaptchaChallenge localCaptchaChallenge = null;
    ArrayList localArrayList2 = new ArrayList();
    String str2 = null;
    String str1 = null;
    boolean bool3 = false;
    boolean bool2 = false;
    int i = 0;
    PostSignInData localPostSignInData = null;
    Account localAccount = null;
    Long localLong = null;
    boolean bool1 = false;
    ArrayList localArrayList1 = null;
    while (paramParcel.dataPosition() < k)
    {
      int m = zza.zzcP(paramParcel);
      switch (zza.zzeS(m))
      {
      default:
        zza.zzb(paramParcel, m);
        break;
      case 1:
        j = zza.zzg(paramParcel, m);
        break;
      case 2:
        str10 = zza.zzp(paramParcel, m);
        break;
      case 3:
        str9 = zza.zzp(paramParcel, m);
        break;
      case 4:
        str8 = zza.zzp(paramParcel, m);
        break;
      case 5:
        str7 = zza.zzp(paramParcel, m);
        break;
      case 6:
        str6 = zza.zzp(paramParcel, m);
        break;
      case 7:
        str5 = zza.zzp(paramParcel, m);
        break;
      case 8:
        str4 = zza.zzp(paramParcel, m);
        break;
      case 9:
        str3 = zza.zzp(paramParcel, m);
        break;
      case 10:
        bool7 = zza.zzc(paramParcel, m);
        break;
      case 11:
        bool6 = zza.zzc(paramParcel, m);
        break;
      case 12:
        bool5 = zza.zzc(paramParcel, m);
        break;
      case 13:
        bool4 = zza.zzc(paramParcel, m);
        break;
      case 14:
        localCaptchaChallenge = (CaptchaChallenge)zza.zza(paramParcel, m, CaptchaChallenge.CREATOR);
        break;
      case 15:
        localArrayList2 = zza.zzc(paramParcel, m, ScopeDetail.CREATOR);
        break;
      case 17:
        str1 = zza.zzp(paramParcel, m);
        break;
      case 16:
        str2 = zza.zzp(paramParcel, m);
        break;
      case 19:
        bool2 = zza.zzc(paramParcel, m);
        break;
      case 18:
        bool3 = zza.zzc(paramParcel, m);
        break;
      case 21:
        localPostSignInData = (PostSignInData)zza.zza(paramParcel, m, PostSignInData.CREATOR);
        break;
      case 20:
        i = zza.zzg(paramParcel, m);
        break;
      case 23:
        localLong = zza.zzj(paramParcel, m);
        break;
      case 22:
        localAccount = (Account)zza.zza(paramParcel, m, Account.CREATOR);
        break;
      case 25:
        localArrayList1 = zza.zzE(paramParcel, m);
        break;
      case 24:
        bool1 = zza.zzc(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k)
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    return new TokenResponse(j, str10, str9, str8, str7, str6, str5, str4, str3, bool7, bool6, bool5, bool4, localCaptchaChallenge, localArrayList2, str2, str1, bool3, bool2, i, localPostSignInData, localAccount, localLong, bool1, localArrayList1);
  }

  public TokenResponse[] zzch(int paramInt)
  {
    return new TokenResponse[paramInt];
  }
}
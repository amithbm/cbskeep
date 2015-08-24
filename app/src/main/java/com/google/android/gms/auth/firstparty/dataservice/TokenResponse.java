package com.google.android.gms.auth.firstparty.dataservice;

import android.accounts.Account;
import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.auth.firstparty.shared.CaptchaChallenge;
import com.google.android.gms.auth.firstparty.shared.ScopeDetail;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.List;

public class TokenResponse
  implements SafeParcelable
{
  public static final zzai CREATOR = new zzai();
  Account account;

  @Deprecated
  String accountName;
  String firstName;
  String lastName;
  int title;
  final int version;
  String zzRY;
  String zzSa;
  CaptchaChallenge zzSb;
  String zzSt;
  PostSignInData zzTA;
  Long zzTB;
  boolean zzTC;
  List<String> zzTD;
  String zzTa;
  String zzTf;
  String zzTr;
  String zzTs;
  boolean zzTt;
  boolean zzTu;
  boolean zzTv;
  boolean zzTw;
  List<ScopeDetail> zzTx;
  boolean zzTy;
  boolean zzTz;

  public TokenResponse()
  {
    version = 3;
    zzTx = new ArrayList();
  }

  TokenResponse(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, CaptchaChallenge paramCaptchaChallenge, List<ScopeDetail> paramList, String paramString9, String paramString10, boolean paramBoolean5, boolean paramBoolean6, int paramInt2, PostSignInData paramPostSignInData, Account paramAccount, Long paramLong, boolean paramBoolean7, List<String> paramList1)
  {
    version = paramInt1;
    accountName = paramString1;
    zzRY = paramString2;
    zzSt = paramString3;
    zzTr = paramString4;
    zzSa = paramString5;
    zzTs = paramString6;
    firstName = paramString7;
    lastName = paramString8;
    zzTt = paramBoolean1;
    zzTu = paramBoolean2;
    zzTv = paramBoolean3;
    zzTw = paramBoolean4;
    zzSb = paramCaptchaChallenge;
    zzTx = paramList;
    zzTf = paramString9;
    zzTa = paramString10;
    zzTy = paramBoolean5;
    zzTz = paramBoolean6;
    title = paramInt2;
    zzTA = paramPostSignInData;
    if ((paramAccount == null) && (!TextUtils.isEmpty(paramString1)));
    for (account = new Account(paramString1, "com.google"); ; account = paramAccount)
    {
      zzTB = paramLong;
      zzTC = paramBoolean7;
      zzTD = paramList1;
      return;
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzai.zza(this, paramParcel, paramInt);
  }
}
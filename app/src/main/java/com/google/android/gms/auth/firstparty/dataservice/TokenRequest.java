package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.auth.firstparty.shared.AppDescription;
import com.google.android.gms.auth.firstparty.shared.CaptchaSolution;
import com.google.android.gms.auth.firstparty.shared.FACLConfig;
import com.google.android.gms.auth.firstparty.shared.PACLConfig;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class TokenRequest
  implements SafeParcelable
{
  public static final zzah CREATOR = new zzah();
  String accountName;
  final String accountType;
  AppDescription callingAppDescription;
  Bundle options = new Bundle();
  final int version;
  CaptchaSolution zzRW;
  volatile boolean zzSZ;
  volatile boolean zzSq;
  String zzTj;
  volatile FACLConfig zzTk;
  volatile PACLConfig zzTl;
  String zzTm = Consent.UNKNOWN.toString();
  volatile boolean zzTn;
  volatile boolean zzTo;
  volatile boolean zzTp;

  public TokenRequest()
  {
    version = 2;
    accountType = "com.google";
  }

  TokenRequest(int paramInt, String paramString1, String paramString2, Bundle paramBundle, FACLConfig paramFACLConfig, PACLConfig paramPACLConfig, boolean paramBoolean1, boolean paramBoolean2, String paramString3, AppDescription paramAppDescription, CaptchaSolution paramCaptchaSolution, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, String paramString4)
  {
    version = paramInt;
    zzTj = paramString1;
    accountName = paramString2;
    options = paramBundle;
    zzTk = paramFACLConfig;
    zzTl = paramPACLConfig;
    zzSZ = paramBoolean1;
    zzSq = paramBoolean2;
    zzTm = paramString3;
    callingAppDescription = paramAppDescription;
    zzRW = paramCaptchaSolution;
    zzTn = paramBoolean3;
    zzTo = paramBoolean4;
    zzTp = paramBoolean5;
    accountType = paramString4;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzah.zza(this, paramParcel, paramInt);
  }

  public static enum Consent
  {
  }
}
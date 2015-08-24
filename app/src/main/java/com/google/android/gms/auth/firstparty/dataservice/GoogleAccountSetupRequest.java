package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.auth.firstparty.shared.AccountCredentials;
import com.google.android.gms.auth.firstparty.shared.AppDescription;
import com.google.android.gms.auth.firstparty.shared.CaptchaSolution;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class GoogleAccountSetupRequest
  implements SafeParcelable
{
  public static final zzu CREATOR = new zzu();
  AppDescription callingAppDescription;
  String firstName;
  String lastName;
  Bundle options;
  String phoneCountryCode;
  String phoneNumber;
  String secondaryEmail;
  final int version;
  CaptchaSolution zzRW;
  boolean zzSV;
  boolean zzSW;
  boolean zzSX;
  String zzSY;
  boolean zzSZ;
  boolean zzSq;
  boolean zzSr;
  AccountCredentials zzSs;
  String zzTa;

  public GoogleAccountSetupRequest()
  {
    version = 1;
    options = new Bundle();
  }

  GoogleAccountSetupRequest(int paramInt, Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, String paramString5, AppDescription paramAppDescription, AccountCredentials paramAccountCredentials, CaptchaSolution paramCaptchaSolution, String paramString6, String paramString7)
  {
    version = paramInt;
    options = paramBundle;
    zzSV = paramBoolean1;
    zzSW = paramBoolean2;
    zzSX = paramBoolean3;
    firstName = paramString1;
    lastName = paramString2;
    secondaryEmail = paramString3;
    zzSY = paramString4;
    zzSq = paramBoolean4;
    zzSZ = paramBoolean5;
    zzSr = paramBoolean6;
    zzTa = paramString5;
    callingAppDescription = paramAppDescription;
    zzSs = paramAccountCredentials;
    zzRW = paramCaptchaSolution;
    phoneNumber = paramString6;
    phoneCountryCode = paramString7;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzu.zza(this, paramParcel, paramInt);
  }
}
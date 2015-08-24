package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzv;

public class AccountCredentials
  implements SafeParcelable
{
  public static final zza CREATOR = new zza();
  final int version;
  String zzQM;
  final String zzQN;
  String zzQt;
  boolean zzTP;
  String zzTQ;
  String zzTR;
  String zzTS;
  String zzTT;

  @Deprecated
  public AccountCredentials()
  {
    this("com.google");
  }

  AccountCredentials(int paramInt, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    version = paramInt;
    zzTP = paramBoolean;
    zzQt = paramString1;
    zzTQ = paramString2;
    zzTR = paramString3;
    zzQM = paramString4;
    zzTS = paramString5;
    zzTT = paramString6;
    zzQN = paramString7;
  }

  public AccountCredentials(String paramString)
  {
    version = 2;
    zzQN = zzv.zzd(paramString, "Account type can't be empty.");
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
}
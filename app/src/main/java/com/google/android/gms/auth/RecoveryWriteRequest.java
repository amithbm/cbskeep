package com.google.android.gms.auth;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class RecoveryWriteRequest
  implements SafeParcelable
{
  public static final zzg CREATOR = new zzg();
  public String mAccount;
  public boolean mIsBroadUse;
  public String mPhoneCountryCode;
  public String mPhoneNumber;
  public String mSecondaryEmail;
  final int mVersionCode;

  public RecoveryWriteRequest()
  {
    mVersionCode = 1;
  }

  RecoveryWriteRequest(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    mVersionCode = paramInt;
    mAccount = paramString1;
    mSecondaryEmail = paramString2;
    mPhoneNumber = paramString3;
    mPhoneCountryCode = paramString4;
    mIsBroadUse = paramBoolean;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzg.zza(this, paramParcel, paramInt);
  }
}
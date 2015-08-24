package com.google.android.gms.auth;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class RecoveryReadResponse
  implements SafeParcelable
{
  public static final zzf CREATOR = new zzf();
  public String mAction;
  public String mAllowedOptions;
  public List<Country> mCountryList;
  public String mError;
  public String mPhoneCountryCode;
  public String mPhoneNumber;
  public String mSecondaryEmail;
  final int mVersionCode;

  public RecoveryReadResponse()
  {
    mVersionCode = 1;
  }

  RecoveryReadResponse(int paramInt, String paramString1, String paramString2, String paramString3, List<Country> paramList, String paramString4, String paramString5, String paramString6)
  {
    mVersionCode = paramInt;
    mSecondaryEmail = paramString1;
    mPhoneNumber = paramString2;
    mPhoneCountryCode = paramString3;
    mCountryList = paramList;
    mError = paramString4;
    mAction = paramString5;
    mAllowedOptions = paramString6;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzf.zza(this, paramParcel, paramInt);
  }
}
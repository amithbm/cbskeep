package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ValidateAccountCredentialsResponse
  implements SafeParcelable
{
  public static final zzak CREATOR = new zzak();
  public final String accountId;
  public final int status;
  final int version;

  ValidateAccountCredentialsResponse(int paramInt1, int paramInt2, String paramString)
  {
    version = paramInt1;
    status = paramInt2;
    accountId = paramString;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzak.zza(this, paramParcel, paramInt);
  }
}
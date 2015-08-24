package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Parcel;
import com.google.android.gms.auth.firstparty.shared.AppDescription;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class CheckRealNameRequest
  implements SafeParcelable
{
  public static final zzn CREATOR = new zzn();
  AppDescription callingAppDescription;
  String firstName;
  String lastName;
  final int version;

  public CheckRealNameRequest()
  {
    version = 1;
  }

  CheckRealNameRequest(int paramInt, AppDescription paramAppDescription, String paramString1, String paramString2)
  {
    version = paramInt;
    callingAppDescription = paramAppDescription;
    firstName = paramString1;
    lastName = paramString2;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzn.zza(this, paramParcel, paramInt);
  }
}
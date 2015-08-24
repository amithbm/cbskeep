package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class CheckFactoryResetPolicyComplianceRequest
  implements SafeParcelable
{
  public static final zzl CREATOR = new zzl();
  public final String accountId;
  final int version;

  CheckFactoryResetPolicyComplianceRequest(int paramInt, String paramString)
  {
    version = paramInt;
    accountId = paramString;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzl.zza(this, paramParcel, paramInt);
  }
}
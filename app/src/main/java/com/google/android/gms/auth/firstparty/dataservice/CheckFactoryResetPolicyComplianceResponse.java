package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class CheckFactoryResetPolicyComplianceResponse
  implements SafeParcelable
{
  public static final zzm CREATOR = new zzm();
  public final boolean isCompliant;
  final int version;

  CheckFactoryResetPolicyComplianceResponse(int paramInt, boolean paramBoolean)
  {
    version = paramInt;
    isCompliant = paramBoolean;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzm.zza(this, paramParcel, paramInt);
  }
}
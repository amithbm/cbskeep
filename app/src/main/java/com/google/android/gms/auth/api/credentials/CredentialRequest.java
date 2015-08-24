package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class CredentialRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<CredentialRequest> CREATOR = new zzb();
  final int mVersionCode;
  private final boolean zzQO;
  private final String[] zzQP;

  CredentialRequest(int paramInt, boolean paramBoolean, String[] paramArrayOfString)
  {
    mVersionCode = paramInt;
    zzQO = paramBoolean;
    zzQP = paramArrayOfString;
  }

  public int describeContents()
  {
    return 0;
  }

  public String[] getAccountTypes()
  {
    return zzQP;
  }

  public boolean getSupportsPasswordLogin()
  {
    return zzQO;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
}
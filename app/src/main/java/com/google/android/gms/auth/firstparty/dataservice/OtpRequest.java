package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Parcel;
import com.google.android.gms.auth.firstparty.shared.AppDescription;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzv;

public class OtpRequest
  implements SafeParcelable
{
  public static final zzy CREATOR = new zzy();
  public final String accountName;
  public final AppDescription callerDescription;
  public final byte[] challenge;
  public final boolean isLegacyRequest;
  final int mVersion;

  OtpRequest(int paramInt, String paramString, AppDescription paramAppDescription, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    mVersion = paramInt;
    accountName = paramString;
    challenge = paramArrayOfByte;
    callerDescription = ((AppDescription)zzv.zzb(paramAppDescription, "Caller's app description cannot be null!"));
    isLegacyRequest = paramBoolean;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzy.zza(this, paramParcel, paramInt);
  }
}
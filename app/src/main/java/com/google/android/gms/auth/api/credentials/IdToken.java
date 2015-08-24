package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class IdToken
  implements SafeParcelable
{
  public static final Parcelable.Creator<IdToken> CREATOR = new zzc();
  final int mVersionCode;
  private final String zzQN;
  private final String zzQQ;

  IdToken(int paramInt, String paramString1, String paramString2)
  {
    mVersionCode = paramInt;
    zzQN = paramString1;
    zzQQ = paramString2;
  }

  public int describeContents()
  {
    return 0;
  }

  public String getAccountType()
  {
    return zzQN;
  }

  public String getIdToken()
  {
    return zzQQ;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc.zza(this, paramParcel, paramInt);
  }
}
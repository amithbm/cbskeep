package com.google.android.gms.search;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class GoogleNowAuthState
  implements SafeParcelable
{
  public static final Parcelable.Creator<GoogleNowAuthState> CREATOR = new zza();
  final int mVersionCode;
  String zzbpK;
  String zzbpL;
  long zzbpM;

  GoogleNowAuthState(int paramInt, String paramString1, String paramString2, long paramLong)
  {
    mVersionCode = paramInt;
    zzbpK = paramString1;
    zzbpL = paramString2;
    zzbpM = paramLong;
  }

  public int describeContents()
  {
    return 0;
  }

  public String getAccessToken()
  {
    return zzbpL;
  }

  public String getAuthCode()
  {
    return zzbpK;
  }

  public long getNextAllowedTimeMillis()
  {
    return zzbpM;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
}
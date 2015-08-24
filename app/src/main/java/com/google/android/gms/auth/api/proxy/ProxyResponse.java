package com.google.android.gms.auth.api.proxy;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ProxyResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator<ProxyResponse> CREATOR = new zzb();
  public final byte[] body;
  public final int googlePlayServicesStatusCode;
  public final int httpStatusCode;
  public final PendingIntent recoveryAction;
  final int versionCode;
  final Bundle zzQX;

  ProxyResponse(int paramInt1, int paramInt2, PendingIntent paramPendingIntent, int paramInt3, Bundle paramBundle, byte[] paramArrayOfByte)
  {
    versionCode = paramInt1;
    googlePlayServicesStatusCode = paramInt2;
    httpStatusCode = paramInt3;
    zzQX = paramBundle;
    body = paramArrayOfByte;
    recoveryAction = paramPendingIntent;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
}
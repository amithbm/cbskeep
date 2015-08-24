package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzv;

public final class AppIdentifier
  implements SafeParcelable
{
  public static final Parcelable.Creator<AppIdentifier> CREATOR = new zza();
  private final int mVersionCode;
  private final String zzaCv;

  AppIdentifier(int paramInt, String paramString)
  {
    mVersionCode = paramInt;
    zzaCv = zzv.zzd(paramString, "Missing application identifier value");
  }

  public int describeContents()
  {
    return 0;
  }

  public String getIdentifier()
  {
    return zzaCv;
  }

  public int getVersionCode()
  {
    return mVersionCode;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
}
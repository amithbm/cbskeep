package com.google.android.gms.location.copresence;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class AccessKey
  implements SafeParcelable
{
  public static final Parcelable.Creator<AccessKey> CREATOR = new zza();
  private final int mVersionCode;
  private final String zzaRQ;

  AccessKey(int paramInt, String paramString)
  {
    mVersionCode = paramInt;
    zzaRQ = paramString;
  }

  public int describeContents()
  {
    return 0;
  }

  public String getPassphrase()
  {
    return zzaRQ;
  }

  int getVersionCode()
  {
    return mVersionCode;
  }

  public String toString()
  {
    if (zzaRQ == null)
      return "N/A";
    return zzaRQ;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
}
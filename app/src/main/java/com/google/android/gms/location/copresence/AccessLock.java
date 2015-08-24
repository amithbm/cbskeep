package com.google.android.gms.location.copresence;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class AccessLock
  implements SafeParcelable
{
  public static final Parcelable.Creator<AccessLock> CREATOR = new zzb();
  private final int mVersionCode;
  private final String zzaRR;

  AccessLock(int paramInt, String paramString)
  {
    mVersionCode = paramInt;
    zzaRR = paramString;
  }

  public int describeContents()
  {
    return 0;
  }

  int getVersionCode()
  {
    return mVersionCode;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }

  public String zzyp()
  {
    return zzaRR;
  }
}
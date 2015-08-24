package com.google.android.gms.location.copresence;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.copresence.internal.zzo;

public class AccessPolicy
  implements SafeParcelable
{
  public static final Parcelable.Creator<AccessPolicy> CREATOR = new zzc();
  private final int mVersionCode;
  private final int zzaRS;
  private final long zzaRT;
  private final AccessLock zzaRU;
  private final int zzaRV;

  AccessPolicy(int paramInt1, int paramInt2, long paramLong, AccessLock paramAccessLock, int paramInt3)
  {
    mVersionCode = paramInt1;
    zzaRS = paramInt2;
    zzaRT = zzo.zzV(paramLong);
    zzaRU = paramAccessLock;
    zzaRV = paramInt3;
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
    zzc.zza(this, paramParcel, paramInt);
  }

  int zzyq()
  {
    return zzaRS;
  }

  public long zzyr()
  {
    return zzaRT;
  }

  public AccessLock zzys()
  {
    return zzaRU;
  }

  public int zzyt()
  {
    return zzaRV;
  }
}
package com.google.android.gms.location.reporting;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;

public final class UploadRequestResult
  implements SafeParcelable
{
  public static final zze CREATOR = new zze();
  private final int mVersionCode;
  private final int zzBv;
  private final long zzacT;

  UploadRequestResult(int paramInt1, int paramInt2, long paramLong)
  {
    mVersionCode = paramInt1;
    zzBv = paramInt2;
    zzacT = paramLong;
  }

  public int describeContents()
  {
    zze localzze = CREATOR;
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof UploadRequestResult));
    do
    {
      return false;
      paramObject = (UploadRequestResult)paramObject;
    }
    while ((zzacT != paramObject.zzacT) || (zzBv != paramObject.zzBv));
    return true;
  }

  public long getRequestId()
  {
    return zzacT;
  }

  public int getResultCode()
  {
    return zzBv;
  }

  int getVersionCode()
  {
    return mVersionCode;
  }

  public int hashCode()
  {
    return zzu.hashCode(new Object[] { Integer.valueOf(zzBv), Long.valueOf(zzacT) });
  }

  public String toString()
  {
    return "Result{mVersionCode=" + mVersionCode + ", mResultCode=" + zzBv + ", mRequestId=" + zzacT + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zze localzze = CREATOR;
    zze.zza(this, paramParcel, paramInt);
  }
}
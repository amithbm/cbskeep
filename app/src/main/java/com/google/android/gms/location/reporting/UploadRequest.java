package com.google.android.gms.location.reporting;

import android.accounts.Account;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.internal.zzql;

public class UploadRequest
  implements SafeParcelable
{
  public static final zzd CREATOR = new zzd();
  private final int mVersionCode;
  private final Account zzMF;
  private final long zzaWq;
  private final long zzaWr;
  private final String zzaWs;
  private final long zzanL;
  private final String zzwU;

  public UploadRequest(int paramInt, Account paramAccount, String paramString1, long paramLong1, long paramLong2, long paramLong3, String paramString2)
  {
    mVersionCode = paramInt;
    zzMF = paramAccount;
    zzwU = paramString1;
    zzanL = paramLong1;
    zzaWq = paramLong2;
    zzaWr = paramLong3;
    zzaWs = paramString2;
  }

  public int describeContents()
  {
    zzd localzzd = CREATOR;
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    do
    {
      return true;
      if (!(paramObject instanceof UploadRequest))
        return false;
      paramObject = (UploadRequest)paramObject;
    }
    while ((zzMF.equals(paramObject.zzMF)) && (zzwU.equals(paramObject.zzwU)) && (zzu.equal(Long.valueOf(zzanL), Long.valueOf(paramObject.zzanL))) && (zzaWq == paramObject.zzaWq) && (zzaWr == paramObject.zzaWr) && (zzu.equal(zzaWs, paramObject.zzaWs)));
    return false;
  }

  public Account getAccount()
  {
    return zzMF;
  }

  public String getAppSpecificKey()
  {
    return zzaWs;
  }

  public long getDurationMillis()
  {
    return zzanL;
  }

  public long getMovingLatencyMillis()
  {
    return zzaWq;
  }

  public String getReason()
  {
    return zzwU;
  }

  public long getStationaryLatencyMillis()
  {
    return zzaWr;
  }

  public int getVersionCode()
  {
    return mVersionCode;
  }

  public int hashCode()
  {
    return zzu.hashCode(new Object[] { zzMF, zzwU, Long.valueOf(zzanL), Long.valueOf(zzaWq), Long.valueOf(zzaWr), zzaWs });
  }

  public String toString()
  {
    return "UploadRequest{mVersionCode=" + mVersionCode + ", mAccount=" + zzql.zzd(zzMF) + ", mReason='" + zzwU + '\'' + ", mDurationMillis=" + zzanL + ", mMovingLatencyMillis=" + zzaWq + ", mStationaryLatencyMillis=" + zzaWr + ", mAppSpecificKey='" + zzaWs + '\'' + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzd localzzd = CREATOR;
    zzd.zza(this, paramParcel, paramInt);
  }
}
package com.google.android.gms.location.reporting;

import android.accounts.Account;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzql;

@Deprecated
public class GmmSettings
  implements SafeParcelable
{
  public static final zza CREATOR = new zza();
  private final int mVersionCode;
  private final Account zzMF;
  private final long zzaWg;
  private final boolean zzaWh;

  public GmmSettings(int paramInt, long paramLong, Account paramAccount, boolean paramBoolean)
  {
    mVersionCode = paramInt;
    zzaWg = paramLong;
    zzMF = paramAccount;
    zzaWh = paramBoolean;
  }

  public int describeContents()
  {
    zza localzza = CREATOR;
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof GmmSettings));
    do
    {
      return false;
      paramObject = (GmmSettings)paramObject;
      if ((zzaWg != paramObject.zzaWg) || (zzaWh != paramObject.zzaWh) || (mVersionCode != paramObject.mVersionCode) || (zzMF != null))
        break;
    }
    while (paramObject.zzMF != null);
    return true;
    return zzMF.equals(paramObject.zzMF);
  }

  public Account getAccount()
  {
    return zzMF;
  }

  public long getReadMillis()
  {
    return zzaWg;
  }

  int getVersionCode()
  {
    return mVersionCode;
  }

  public int hashCode()
  {
    int j = 0;
    int k = mVersionCode;
    int m = (int)(zzaWg ^ zzaWg >>> 32);
    if (zzMF != null);
    for (int i = zzMF.hashCode(); ; i = 0)
    {
      if (zzaWh)
        j = 1;
      return (i + (k * 31 + m) * 31) * 31 + j;
    }
  }

  public boolean isReportingSelected()
  {
    return zzaWh;
  }

  public String toString()
  {
    return "GmmSettings{mVersionCode=" + mVersionCode + ", mValueReadMillis=" + zzaWg + ", mAccount=" + zzql.zzd(zzMF) + ", mReportingSelected=" + zzaWh + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza localzza = CREATOR;
    zza.zza(this, paramParcel, paramInt);
  }
}
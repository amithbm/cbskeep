package com.google.android.gms.location.reporting;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.internal.zzql;

public class ReportingState
  implements SafeParcelable
{
  public static final zzc CREATOR = new zzc();
  private final int mVersionCode;
  private final int zzaWi;
  private final int zzaWj;
  private final boolean zzaWk;
  private final boolean zzaWl;

  @Deprecated
  private final boolean zzaWm;
  private final int zzaWn;
  private final int zzaWo;
  private final Integer zzaWp;

  public ReportingState(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt4, int paramInt5, Integer paramInteger)
  {
    mVersionCode = paramInt1;
    zzaWi = paramInt2;
    zzaWj = paramInt3;
    zzaWk = paramBoolean1;
    zzaWl = paramBoolean2;
    zzaWm = paramBoolean3;
    zzaWn = paramInt4;
    zzaWo = paramInt5;
    zzaWp = paramInteger;
  }

  public int describeContents()
  {
    zzc localzzc = CREATOR;
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof ReportingState));
    do
    {
      return false;
      paramObject = (ReportingState)paramObject;
    }
    while ((zzaWi != paramObject.zzaWi) || (zzaWj != paramObject.zzaWj) || (zzaWk != paramObject.zzaWk) || (zzaWl != paramObject.zzaWl) || (zzaWn != paramObject.zzaWn) || (zzaWo != paramObject.zzaWo) || (!zzu.equal(zzaWp, paramObject.zzaWp)));
    return true;
  }

  public int getExpectedOptInResult()
  {
    return OptInResult.sanitize(zzaWn);
  }

  public int getHistoryEnabled()
  {
    return Setting.sanitize(zzaWj);
  }

  public int getReportingEnabled()
  {
    return Setting.sanitize(zzaWi);
  }

  int getVersionCode()
  {
    return mVersionCode;
  }

  public int hashCode()
  {
    return zzu.hashCode(new Object[] { Integer.valueOf(zzaWi), Integer.valueOf(zzaWj), Boolean.valueOf(zzaWk), Boolean.valueOf(zzaWl), Integer.valueOf(zzaWn), Integer.valueOf(zzaWo), zzaWp });
  }

  public boolean isActive()
  {
    return zzaWl;
  }

  public boolean isAllowed()
  {
    return zzaWk;
  }

  @Deprecated
  public boolean isDeferringToMaps()
  {
    return false;
  }

  public String toString()
  {
    if (zzaWp != null);
    for (String str = zzql.zzf(zzaWp); ; str = "(hidden-from-unauthorized-caller)")
      return "ReportingState{mReportingEnabled=" + zzaWi + ", mHistoryEnabled=" + zzaWj + ", mAllowed=" + zzaWk + ", mActive=" + zzaWl + ", mExpectedOptInResult=" + zzaWn + ", mExpectedOptInResultAssumingLocationEnabled=" + zzaWo + ", mVersionCode=" + mVersionCode + ", mDeviceTag=" + str + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc localzzc = CREATOR;
    zzc.zza(this, paramParcel, paramInt);
  }

  int zzzi()
  {
    return OptInResult.sanitize(zzaWo);
  }

  Integer zzzj()
  {
    return zzaWp;
  }

  public static final class Setting
  {
    public static int sanitize(int paramInt)
    {
      return Reporting.Setting.sanitize(paramInt);
    }
  }
}
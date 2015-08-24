package com.google.android.gms.playlog.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;

public class PlayLoggerContext
  implements SafeParcelable
{
  public static final zze CREATOR = new zze();
  public final String packageName;
  public final int versionCode;
  public final int zzbiB;
  public final int zzbiC;
  public final String zzbiD;
  public final String zzbiE;
  public final boolean zzbiF;
  public final String zzbiG;
  public final boolean zzbiH;

  public PlayLoggerContext(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2, String paramString3, boolean paramBoolean1, String paramString4, boolean paramBoolean2)
  {
    versionCode = paramInt1;
    packageName = paramString1;
    zzbiB = paramInt2;
    zzbiC = paramInt3;
    zzbiD = paramString2;
    zzbiE = paramString3;
    zzbiF = paramBoolean1;
    zzbiG = paramString4;
    zzbiH = paramBoolean2;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    do
    {
      return true;
      if (!(paramObject instanceof PlayLoggerContext))
        break;
      paramObject = (PlayLoggerContext)paramObject;
    }
    while ((versionCode == paramObject.versionCode) && (packageName.equals(paramObject.packageName)) && (zzbiB == paramObject.zzbiB) && (zzbiC == paramObject.zzbiC) && (zzu.equal(zzbiG, paramObject.zzbiG)) && (zzu.equal(zzbiD, paramObject.zzbiD)) && (zzu.equal(zzbiE, paramObject.zzbiE)) && (zzbiF == paramObject.zzbiF) && (zzbiH == paramObject.zzbiH));
    return false;
    return false;
  }

  public int hashCode()
  {
    return zzu.hashCode(new Object[] { Integer.valueOf(versionCode), packageName, Integer.valueOf(zzbiB), Integer.valueOf(zzbiC), zzbiG, zzbiD, zzbiE, Boolean.valueOf(zzbiF), Boolean.valueOf(zzbiH) });
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PlayLoggerContext[");
    localStringBuilder.append("versionCode=").append(versionCode).append(',');
    localStringBuilder.append("package=").append(packageName).append(',');
    localStringBuilder.append("packageVersionCode=").append(zzbiB).append(',');
    localStringBuilder.append("logSource=").append(zzbiC).append(',');
    localStringBuilder.append("logSourceName=").append(zzbiG).append(',');
    localStringBuilder.append("uploadAccount=").append(zzbiD).append(',');
    localStringBuilder.append("loggingId=").append(zzbiE).append(',');
    localStringBuilder.append("logAndroidId=").append(zzbiF).append(',');
    localStringBuilder.append("isAnonymous=").append(zzbiH);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zze.zza(this, paramParcel, paramInt);
  }
}
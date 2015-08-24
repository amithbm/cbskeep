package com.google.android.gms.location.copresence.internal;

import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.common.internal.zzv;

public class CopresenceFeatureOptIn
  implements SafeParcelable, Cloneable
{
  public static final zze CREATOR = new zze();
  private final int mVersionCode;
  private final String zzLf;
  private final boolean zzaSI;

  CopresenceFeatureOptIn(int paramInt, String paramString, boolean paramBoolean)
  {
    zzv.zzce(paramString);
    mVersionCode = paramInt;
    zzLf = paramString;
    zzaSI = paramBoolean;
  }

  public Object clone()
  {
    return new CopresenceFeatureOptIn(mVersionCode, zzLf, zzaSI);
  }

  public int describeContents()
  {
    zze localzze = CREATOR;
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      paramObject = (CopresenceFeatureOptIn)paramObject;
    }
    while ((mVersionCode == paramObject.mVersionCode) && (TextUtils.equals(zzLf, paramObject.zzLf)) && (zzaSI == paramObject.zzaSI));
    return false;
  }

  public String getId()
  {
    return zzLf;
  }

  public int getVersionCode()
  {
    return mVersionCode;
  }

  public int hashCode()
  {
    return zzu.hashCode(new Object[] { Integer.valueOf(mVersionCode), zzLf, Boolean.valueOf(zzaSI) });
  }

  public boolean isOptedIn()
  {
    return zzaSI;
  }

  public String toString()
  {
    return "FeatureOptIn[id=" + zzLf + ", isOptedIn=" + zzaSI + "]";
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zze localzze = CREATOR;
    zze.zza(this, paramParcel, paramInt);
  }
}
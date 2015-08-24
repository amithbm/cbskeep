package com.google.android.gms.location.copresence;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.location.copresence.internal.CopresenceFeatureOptIn;
import java.util.Arrays;

public class CopresenceSettings
  implements SafeParcelable, Cloneable
{
  public static final zze CREATOR = new zze();
  private final int mVersionCode;
  private final boolean zzaSb;
  private final boolean zzaSc;
  private CopresenceFeatureOptIn[] zzaSd;

  CopresenceSettings(int paramInt, boolean paramBoolean1, boolean paramBoolean2, CopresenceFeatureOptIn[] paramArrayOfCopresenceFeatureOptIn)
  {
    mVersionCode = paramInt;
    zzaSb = paramBoolean1;
    zzaSc = paramBoolean2;
    zzaSd = paramArrayOfCopresenceFeatureOptIn;
  }

  public Object clone()
  {
    int i = mVersionCode;
    boolean bool1 = zzaSb;
    boolean bool2 = zzaSc;
    if (zzaSd == null);
    for (CopresenceFeatureOptIn[] arrayOfCopresenceFeatureOptIn = null; ; arrayOfCopresenceFeatureOptIn = (CopresenceFeatureOptIn[])zzaSd.clone())
      return new CopresenceSettings(i, bool1, bool2, arrayOfCopresenceFeatureOptIn);
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
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      paramObject = (CopresenceSettings)paramObject;
    }
    while ((mVersionCode == paramObject.mVersionCode) && (zzaSb == paramObject.zzaSb) && (zzaSc == paramObject.zzaSc) && (Arrays.equals(zzaSd, paramObject.zzaSd)));
    return false;
  }

  public int getVersionCode()
  {
    return mVersionCode;
  }

  public int hashCode()
  {
    return zzu.hashCode(new Object[] { Integer.valueOf(mVersionCode), Boolean.valueOf(zzaSc), Boolean.valueOf(zzaSb), Integer.valueOf(Arrays.hashCode(zzaSd)) });
  }

  public boolean isEnabled()
  {
    return zzaSb;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zze.zza(this, paramParcel, paramInt);
  }

  public boolean zzyx()
  {
    return zzaSc;
  }

  public CopresenceFeatureOptIn[] zzyy()
  {
    if (zzaSd == null)
      return null;
    return (CopresenceFeatureOptIn[])zzaSd.clone();
  }
}
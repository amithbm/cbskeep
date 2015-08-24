package com.google.android.gms.location.copresence.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.location.copresence.zzk;

public class StrategyImpl extends zzk
  implements SafeParcelable
{
  public static final Parcelable.Creator<StrategyImpl> CREATOR = new zzm();
  private final int mVersionCode;
  private final boolean zzaST;
  private final int zzaSU;
  private final boolean zzaSV;
  private final int zzaSW;

  StrategyImpl(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, int paramInt3)
  {
    mVersionCode = paramInt1;
    zzaST = paramBoolean1;
    zzaSU = paramInt2;
    zzaSV = paramBoolean2;
    zzaSW = paramInt3;
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
      if (paramObject == null)
        return false;
      if (getClass() != paramObject.getClass())
        return false;
      paramObject = (StrategyImpl)paramObject;
    }
    while ((zzaST == paramObject.zzaST) && (zzaSU == paramObject.zzaSU) && (zzaSV == paramObject.zzaSV) && (zzaSW == paramObject.zzaSW));
    return false;
  }

  int getVersionCode()
  {
    return mVersionCode;
  }

  public int hashCode()
  {
    return zzu.hashCode(new Object[] { Boolean.valueOf(zzaST), Integer.valueOf(zzaSU), Boolean.valueOf(zzaSV), Integer.valueOf(zzaSW) });
  }

  public boolean isActive()
  {
    return zzaST;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzm.zza(this, paramParcel, paramInt);
  }

  public int zzyH()
  {
    return zzaSU;
  }

  public boolean zzyI()
  {
    return zzaSV;
  }

  public int zzyJ()
  {
    return zzaSW;
  }
}
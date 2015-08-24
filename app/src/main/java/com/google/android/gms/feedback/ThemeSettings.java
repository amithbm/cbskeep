package com.google.android.gms.feedback;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ThemeSettings
  implements SafeParcelable
{
  public static final Parcelable.Creator<ThemeSettings> CREATOR = new zze();
  final int mVersionCode;
  int zzaBA;
  int zzaBz;

  public ThemeSettings()
  {
    this(1, 0, 0);
  }

  ThemeSettings(int paramInt1, int paramInt2, int paramInt3)
  {
    mVersionCode = paramInt1;
    zzaBz = paramInt2;
    zzaBA = paramInt3;
  }

  public int describeContents()
  {
    return 0;
  }

  public ThemeSettings setTheme(int paramInt)
  {
    zzaBz = paramInt;
    return this;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zze.zza(this, paramParcel, paramInt);
  }
}
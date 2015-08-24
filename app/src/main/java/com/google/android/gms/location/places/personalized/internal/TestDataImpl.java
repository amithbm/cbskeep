package com.google.android.gms.location.places.personalized.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.common.internal.zzu.zza;
import com.google.android.gms.location.places.personalized.TestData;

public class TestDataImpl extends TestData
  implements SafeParcelable
{
  public static final zza CREATOR = new zza();
  final int mVersionCode;
  private final String zzaWf;

  TestDataImpl(int paramInt, String paramString)
  {
    mVersionCode = paramInt;
    zzaWf = paramString;
  }

  public int describeContents()
  {
    zza localzza = CREATOR;
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject)
      return true;
    if (!(paramObject instanceof TestDataImpl))
      return false;
    paramObject = (TestDataImpl)paramObject;
    return zzaWf.equals(paramObject.zzaWf);
  }

  public String getTestName()
  {
    return zzaWf;
  }

  public int hashCode()
  {
    return zzaWf.hashCode();
  }

  public String toString()
  {
    return zzu.zzy(this).zzc("testName", zzaWf).toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza localzza = CREATOR;
    zza.zza(this, paramParcel, paramInt);
  }
}
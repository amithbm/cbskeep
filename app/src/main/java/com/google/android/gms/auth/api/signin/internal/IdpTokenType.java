package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzv;

public final class IdpTokenType
  implements SafeParcelable
{
  public static final Parcelable.Creator<IdpTokenType> CREATOR = new zze();
  public static final IdpTokenType zzRv = new IdpTokenType("accessToken");
  public static final IdpTokenType zzRw = new IdpTokenType("idToken");
  final int versionCode;
  private final String zzRx;

  IdpTokenType(int paramInt, String paramString)
  {
    versionCode = paramInt;
    zzRx = paramString;
  }

  private IdpTokenType(String paramString)
  {
    versionCode = 1;
    zzRx = zzv.zzce(paramString);
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramObject != null);
    try
    {
      boolean bool3 = zzRx.equals(((IdpTokenType)paramObject).zzkX());
      bool1 = bool2;
      if (bool3)
        bool1 = true;
      return bool1;
    }
    catch (ClassCastException paramObject)
    {
    }
    return false;
  }

  public int hashCode()
  {
    return zzRx.hashCode();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zze.zza(this, paramParcel, paramInt);
  }

  public String zzkX()
  {
    return zzRx;
  }
}
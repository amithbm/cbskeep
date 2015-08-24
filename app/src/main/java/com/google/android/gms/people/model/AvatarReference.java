package com.google.android.gms.people.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.common.internal.zzu.zza;
import com.google.android.gms.common.internal.zzv;

public final class AvatarReference
  implements SafeParcelable
{
  public static final zzb CREATOR = new zzb();
  private final int mVersionCode;
  final int zzaUs;
  final String zzbgs;

  AvatarReference(int paramInt1, int paramInt2, String paramString)
  {
    if (paramInt2 != 0);
    for (boolean bool = true; ; bool = false)
    {
      zzv.zzR(bool);
      mVersionCode = paramInt1;
      zzaUs = paramInt2;
      zzbgs = paramString;
      return;
    }
  }

  public AvatarReference(int paramInt, String paramString)
  {
    this(1, paramInt, paramString);
  }

  public int describeContents()
  {
    return 0;
  }

  public String getLocation()
  {
    return zzbgs;
  }

  public int getSource()
  {
    return zzaUs;
  }

  public int getVersionCode()
  {
    return mVersionCode;
  }

  public String toString()
  {
    return zzu.zzy(this).zzc("source", Integer.valueOf(zzaUs)).zzc("location", zzbgs).toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
}
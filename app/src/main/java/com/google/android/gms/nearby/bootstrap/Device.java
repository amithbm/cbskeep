package com.google.android.gms.nearby.bootstrap;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzv;

public class Device
  implements SafeParcelable
{
  public static final Parcelable.Creator<Device> CREATOR = new zzb();
  private final String description;
  private final String name;
  final int versionCode;
  private final String zzapQ;
  private final byte zzbas;

  Device(int paramInt, String paramString1, String paramString2, String paramString3, byte paramByte)
  {
    versionCode = paramInt;
    name = zzv.zzce(paramString1);
    description = ((String)zzv.zzz(paramString2));
    zzapQ = ((String)zzv.zzz(paramString3));
    if (paramByte <= 3);
    for (boolean bool = true; ; bool = false)
    {
      zzv.zzb(bool, "Unknown device type");
      zzbas = paramByte;
      return;
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public String getDescription()
  {
    return description;
  }

  public String getDeviceId()
  {
    return zzapQ;
  }

  public byte getDeviceType()
  {
    return zzbas;
  }

  public String getName()
  {
    return name;
  }

  public String toString()
  {
    return name + ": " + description + "[" + zzbas + "]";
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
}
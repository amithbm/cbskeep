package com.google.android.gms.location.copresence.debug;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class CopresenceDebugPokeResponse
  implements SafeParcelable
{
  public static final zzb CREATOR = new zzb();
  private final int mVersionCode;
  private byte[] zzaSp;

  CopresenceDebugPokeResponse(int paramInt, byte[] paramArrayOfByte)
  {
    mVersionCode = paramInt;
    zzaSp = paramArrayOfByte;
  }

  public int describeContents()
  {
    return 0;
  }

  public byte[] getProtoData()
  {
    return zzaSp;
  }

  int getVersionCode()
  {
    return mVersionCode;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
}
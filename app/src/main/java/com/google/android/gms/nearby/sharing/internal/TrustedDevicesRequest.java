package com.google.android.gms.nearby.sharing.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzv;

public final class TrustedDevicesRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<TrustedDevicesRequest> CREATOR = new zzo();
  final int versionCode;
  public zzd zzbbJ;
  public String zzbbP;
  public byte[] zzbbQ;

  TrustedDevicesRequest(int paramInt, String paramString, byte[] paramArrayOfByte, IBinder paramIBinder)
  {
    versionCode = paramInt;
    zzbbP = ((String)zzv.zzz(paramString));
    zzbbQ = ((byte[])zzv.zzz(paramArrayOfByte));
    zzbbJ = zzd.zza.zzft(paramIBinder);
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzo.zza(this, paramParcel, paramInt);
  }

  IBinder zzAv()
  {
    return zzbbJ.asBinder();
  }
}
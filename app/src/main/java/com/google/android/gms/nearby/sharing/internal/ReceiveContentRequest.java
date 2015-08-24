package com.google.android.gms.nearby.sharing.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class ReceiveContentRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<ReceiveContentRequest> CREATOR = new zzj();
  public String packageName;
  final int versionCode;
  public IBinder zzbbF;
  public zzd zzbbJ;
  public zzb zzbbK;

  ReceiveContentRequest()
  {
    versionCode = 1;
  }

  ReceiveContentRequest(int paramInt, IBinder paramIBinder1, IBinder paramIBinder2, String paramString, IBinder paramIBinder3)
  {
    versionCode = paramInt;
    zzbbF = paramIBinder1;
    zzbbK = zzb.zza.zzfr(paramIBinder2);
    packageName = paramString;
    zzbbJ = zzd.zza.zzft(paramIBinder3);
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzj.zza(this, paramParcel, paramInt);
  }

  IBinder zzAv()
  {
    return zzbbJ.asBinder();
  }

  IBinder zzAy()
  {
    if (zzbbK == null)
      return null;
    return zzbbK.asBinder();
  }
}
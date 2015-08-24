package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class RemoveListenerRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<RemoveListenerRequest> CREATOR = new zzbc();
  final int mVersionCode;
  public final zzas zzbGK;

  RemoveListenerRequest(int paramInt, IBinder paramIBinder)
  {
    mVersionCode = paramInt;
    if (paramIBinder != null)
    {
      zzbGK = zzas.zza.zzhw(paramIBinder);
      return;
    }
    zzbGK = null;
  }

  public RemoveListenerRequest(zzas paramzzas)
  {
    mVersionCode = 1;
    zzbGK = paramzzas;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzbc.zza(this, paramParcel, paramInt);
  }

  IBinder zzrV()
  {
    if (zzbGK == null)
      return null;
    return zzbGK.asBinder();
  }
}
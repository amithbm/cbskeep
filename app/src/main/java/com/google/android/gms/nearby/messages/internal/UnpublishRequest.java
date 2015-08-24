package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class UnpublishRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<UnpublishRequest> CREATOR = new zzl();
  final int mVersionCode;
  public final String zeroPartyPackageName;
  public final MessageWrapper zzbbo;
  public final zzb zzbbq;
  public final String zzbbr;

  UnpublishRequest(int paramInt, MessageWrapper paramMessageWrapper, IBinder paramIBinder, String paramString1, String paramString2)
  {
    mVersionCode = paramInt;
    zzbbo = paramMessageWrapper;
    zzbbq = zzb.zza.zzfo(paramIBinder);
    zeroPartyPackageName = paramString1;
    zzbbr = paramString2;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzl.zza(this, paramParcel, paramInt);
  }

  IBinder zzAv()
  {
    return zzbbq.asBinder();
  }
}
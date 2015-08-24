package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.messages.Strategy;

public final class PublishRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<PublishRequest> CREATOR = new zzj();
  final int mVersionCode;
  public final String zeroPartyPackageName;
  public final MessageWrapper zzbbo;
  public final Strategy zzbbp;
  public final zzb zzbbq;
  public final String zzbbr;

  PublishRequest(int paramInt, MessageWrapper paramMessageWrapper, Strategy paramStrategy, IBinder paramIBinder, String paramString1, String paramString2)
  {
    mVersionCode = paramInt;
    zzbbo = paramMessageWrapper;
    zzbbp = paramStrategy;
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
    zzj.zza(this, paramParcel, paramInt);
  }

  IBinder zzAv()
  {
    return zzbbq.asBinder();
  }
}
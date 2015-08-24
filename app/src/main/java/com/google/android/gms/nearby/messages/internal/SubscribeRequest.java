package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.messages.MessageFilter;
import com.google.android.gms.nearby.messages.Strategy;

public final class SubscribeRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<SubscribeRequest> CREATOR = new zzk();
  final int mVersionCode;
  public final String zeroPartyPackageName;
  public final PendingIntent zzaSZ;
  public final Strategy zzbbp;
  public final zzb zzbbq;
  public final String zzbbr;
  public final zza zzbbs;
  public final MessageFilter zzbbt;
  public final int zzbbu;

  SubscribeRequest(int paramInt1, IBinder paramIBinder1, Strategy paramStrategy, IBinder paramIBinder2, MessageFilter paramMessageFilter, PendingIntent paramPendingIntent, int paramInt2, String paramString1, String paramString2)
  {
    mVersionCode = paramInt1;
    zzbbs = zza.zza.zzfn(paramIBinder1);
    zzbbp = paramStrategy;
    zzbbq = zzb.zza.zzfo(paramIBinder2);
    zzbbt = paramMessageFilter;
    zzaSZ = paramPendingIntent;
    zzbbu = paramInt2;
    zeroPartyPackageName = paramString1;
    zzbbr = paramString2;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzk.zza(this, paramParcel, paramInt);
  }

  IBinder zzAv()
  {
    if (zzbbq == null)
      return null;
    return zzbbq.asBinder();
  }

  IBinder zzyC()
  {
    if (zzbbs == null)
      return null;
    return zzbbs.asBinder();
  }
}
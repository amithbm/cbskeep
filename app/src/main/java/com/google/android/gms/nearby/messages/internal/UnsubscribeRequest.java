package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class UnsubscribeRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<UnsubscribeRequest> CREATOR = new zzm();
  final int mVersionCode;
  public final String zeroPartyPackageName;
  public final PendingIntent zzaSZ;
  public final zzb zzbbq;
  public final String zzbbr;
  public final zza zzbbs;
  public final int zzbbu;

  UnsubscribeRequest(int paramInt1, IBinder paramIBinder1, IBinder paramIBinder2, PendingIntent paramPendingIntent, int paramInt2, String paramString1, String paramString2)
  {
    mVersionCode = paramInt1;
    zzbbs = zza.zza.zzfn(paramIBinder1);
    zzbbq = zzb.zza.zzfo(paramIBinder2);
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
    zzm.zza(this, paramParcel, paramInt);
  }

  IBinder zzAv()
  {
    return zzbbq.asBinder();
  }

  IBinder zzyC()
  {
    if (zzbbs == null)
      return null;
    return zzbbs.asBinder();
  }
}
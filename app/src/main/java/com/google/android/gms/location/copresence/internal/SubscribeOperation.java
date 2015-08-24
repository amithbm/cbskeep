package com.google.android.gms.location.copresence.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.copresence.MessageFilter;

public class SubscribeOperation
  implements SafeParcelable
{
  public static final Parcelable.Creator<SubscribeOperation> CREATOR = new zzn();
  private final int mVersionCode;
  public final zzi messageListener;
  public final int type;
  public final StrategyImpl zzaSX;
  public final MessageFilter zzaSY;
  public final PendingIntent zzaSZ;
  public final byte[] zzaTa;

  SubscribeOperation(int paramInt1, int paramInt2, StrategyImpl paramStrategyImpl, MessageFilter paramMessageFilter, IBinder paramIBinder, PendingIntent paramPendingIntent, byte[] paramArrayOfByte)
  {
    mVersionCode = paramInt1;
    type = paramInt2;
    zzaSX = paramStrategyImpl;
    zzaSY = paramMessageFilter;
    if (paramIBinder == null);
    for (messageListener = null; ; messageListener = zzi.zza.zzdX(paramIBinder))
    {
      zzaSZ = paramPendingIntent;
      zzaTa = paramArrayOfByte;
      return;
    }
  }

  public int describeContents()
  {
    return 0;
  }

  int getVersionCode()
  {
    return mVersionCode;
  }

  public String toString()
  {
    switch (type)
    {
    default:
      return "SubscribeOperation[unknown type=" + type + ", filter=" + zzaSY + "]";
    case 1:
      return "SubscribeOperation[listener=" + zzyC() + ", filter=" + zzaSY + "]";
    case 2:
    }
    return "SubscribeOperation[pendingIntent=" + zzaSZ + ", filter=" + zzaSY + "]";
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzn.zza(this, paramParcel, paramInt);
  }

  IBinder zzyC()
  {
    if (messageListener == null)
      return null;
    return messageListener.asBinder();
  }
}
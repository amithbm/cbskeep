package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;

public final class ChannelEventParcelable
  implements SafeParcelable
{
  public static final Parcelable.Creator<ChannelEventParcelable> CREATOR = new zzk();
  final int mVersionCode;
  final int type;
  final int zzbHm;
  final int zzbHn;
  final ChannelImpl zzbHo;

  ChannelEventParcelable(int paramInt1, ChannelImpl paramChannelImpl, int paramInt2, int paramInt3, int paramInt4)
  {
    mVersionCode = paramInt1;
    zzbHo = paramChannelImpl;
    type = paramInt2;
    zzbHm = paramInt3;
    zzbHn = paramInt4;
  }

  private static String zzrl(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return Integer.toString(paramInt);
    case 1:
      return "CHANNEL_OPENED";
    case 2:
      return "CHANNEL_CLOSED";
    case 4:
      return "OUTPUT_CLOSED";
    case 3:
    }
    return "INPUT_CLOSED";
  }

  private static String zzrm(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return Integer.toString(paramInt);
    case 1:
      return "CLOSE_REASON_DISCONNECTED";
    case 2:
      return "CLOSE_REASON_REMOTE_CLOSE";
    case 3:
      return "CLOSE_REASON_LOCAL_CLOSE";
    case 0:
    }
    return "CLOSE_REASON_NORMAL";
  }

  public int describeContents()
  {
    return 0;
  }

  public String toString()
  {
    return "ChannelEventParcelable[versionCode=" + mVersionCode + ", channel=" + zzbHo + ", type=" + zzrl(type) + ", closeReason=" + zzrm(zzbHm) + ", appErrorCode=" + zzbHn + "]";
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzk.zza(this, paramParcel, paramInt);
  }

  public void zza(ChannelApi.ChannelListener paramChannelListener)
  {
    switch (type)
    {
    default:
      Log.w("ChannelEventParcelable", "Unknown type: " + type);
      return;
    case 1:
      paramChannelListener.onChannelOpened(zzbHo);
      return;
    case 2:
      paramChannelListener.onChannelClosed(zzbHo, zzbHm, zzbHn);
      return;
    case 3:
      paramChannelListener.onInputClosed(zzbHo, zzbHm, zzbHn);
      return;
    case 4:
    }
    paramChannelListener.onOutputClosed(zzbHo, zzbHm, zzbHn);
  }
}
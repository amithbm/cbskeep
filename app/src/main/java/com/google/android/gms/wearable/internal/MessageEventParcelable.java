package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.MessageEvent;

public class MessageEventParcelable
  implements SafeParcelable, MessageEvent
{
  public static final Parcelable.Creator<MessageEventParcelable> CREATOR = new zzaw();
  private final byte[] mData;
  final int mVersionCode;
  private final String zzaUx;
  private final int zzasp;
  private final String zzbHp;

  MessageEventParcelable(int paramInt1, int paramInt2, String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    mVersionCode = paramInt1;
    zzasp = paramInt2;
    zzbHp = paramString1;
    mData = paramArrayOfByte;
    zzaUx = paramString2;
  }

  public int describeContents()
  {
    return 0;
  }

  public byte[] getData()
  {
    return mData;
  }

  public String getPath()
  {
    return zzbHp;
  }

  public int getRequestId()
  {
    return zzasp;
  }

  public String getSourceNodeId()
  {
    return zzaUx;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("MessageEventParcelable[").append(zzasp).append(",").append(zzbHp).append(", size=");
    if (mData == null);
    for (Object localObject = "null"; ; localObject = Integer.valueOf(mData.length))
      return localObject + "]";
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzaw.zza(this, paramParcel, paramInt);
  }
}
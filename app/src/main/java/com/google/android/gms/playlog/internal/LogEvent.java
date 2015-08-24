package com.google.android.gms.playlog.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Iterator;
import java.util.Set;

public class LogEvent
  implements SafeParcelable
{
  public static final zzc CREATOR = new zzc();
  public final String tag;
  public final int versionCode;
  public final long zzbir;
  public final byte[] zzbis;
  public final Bundle zzbit;

  LogEvent(int paramInt, long paramLong, String paramString, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    versionCode = paramInt;
    zzbir = paramLong;
    tag = paramString;
    zzbis = paramArrayOfByte;
    zzbit = paramBundle;
  }

  public int describeContents()
  {
    return 0;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("tag=").append(tag).append(",");
    localStringBuilder.append("eventTime=").append(zzbir).append(",");
    if ((zzbit != null) && (!zzbit.isEmpty()))
    {
      localStringBuilder.append("keyValues=");
      Iterator localIterator = zzbit.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localStringBuilder.append("(").append(str).append(",");
        localStringBuilder.append(zzbit.getString(str)).append(")");
        localStringBuilder.append(" ");
      }
    }
    return localStringBuilder.toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc.zza(this, paramParcel, paramInt);
  }
}
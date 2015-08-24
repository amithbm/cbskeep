package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.common.internal.zzv;
import com.google.android.gms.wearable.Channel;

public class ChannelImpl
  implements SafeParcelable, Channel
{
  public static final Parcelable.Creator<ChannelImpl> CREATOR = new zzl();
  final int mVersionCode;
  private final String zzbGv;
  private final String zzbHj;
  private final String zzbHp;

  ChannelImpl(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    mVersionCode = paramInt;
    zzbHj = ((String)zzv.zzz(paramString1));
    zzbGv = ((String)zzv.zzz(paramString2));
    zzbHp = ((String)zzv.zzz(paramString3));
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == this);
    do
    {
      return true;
      if (!(paramObject instanceof ChannelImpl))
        return false;
      paramObject = (ChannelImpl)paramObject;
    }
    while ((zzbHj.equals(paramObject.zzbHj)) && (zzu.equal(paramObject.zzbGv, zzbGv)) && (zzu.equal(paramObject.zzbHp, zzbHp)) && (paramObject.mVersionCode == mVersionCode));
    return false;
  }

  public String getNodeId()
  {
    return zzbGv;
  }

  public String getPath()
  {
    return zzbHp;
  }

  public String getToken()
  {
    return zzbHj;
  }

  public int hashCode()
  {
    return zzbHj.hashCode();
  }

  public String toString()
  {
    return "ChannelImpl{versionCode=" + mVersionCode + ", token='" + zzbHj + '\'' + ", nodeId='" + zzbGv + '\'' + ", path='" + zzbHp + '\'' + "}";
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzl.zza(this, paramParcel, paramInt);
  }
}
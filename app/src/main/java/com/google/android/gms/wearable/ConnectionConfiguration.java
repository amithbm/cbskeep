package com.google.android.gms.wearable;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;

public class ConnectionConfiguration
  implements SafeParcelable
{
  public static final Parcelable.Creator<ConnectionConfiguration> CREATOR = new zzb();
  private final String mName;
  final int mVersionCode;
  private boolean zzLW;
  private final int zzOu;
  private final String zzaBP;
  private final int zzasR;
  private final boolean zzbGs;
  private String zzbGt;
  private boolean zzbGu;
  private String zzbGv;

  ConnectionConfiguration(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, String paramString3, boolean paramBoolean3, String paramString4)
  {
    mVersionCode = paramInt1;
    mName = paramString1;
    zzaBP = paramString2;
    zzOu = paramInt2;
    zzasR = paramInt3;
    zzbGs = paramBoolean1;
    zzLW = paramBoolean2;
    zzbGt = paramString3;
    zzbGu = paramBoolean3;
    zzbGv = paramString4;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof ConnectionConfiguration));
    do
    {
      return false;
      paramObject = (ConnectionConfiguration)paramObject;
    }
    while ((!zzu.equal(Integer.valueOf(mVersionCode), Integer.valueOf(paramObject.mVersionCode))) || (!zzu.equal(mName, paramObject.mName)) || (!zzu.equal(zzaBP, paramObject.zzaBP)) || (!zzu.equal(Integer.valueOf(zzOu), Integer.valueOf(paramObject.zzOu))) || (!zzu.equal(Integer.valueOf(zzasR), Integer.valueOf(paramObject.zzasR))) || (!zzu.equal(Boolean.valueOf(zzbGs), Boolean.valueOf(paramObject.zzbGs))) || (!zzu.equal(Boolean.valueOf(zzbGu), Boolean.valueOf(paramObject.zzbGu))));
    return true;
  }

  public String getAddress()
  {
    return zzaBP;
  }

  public boolean getBtlePriority()
  {
    return zzbGu;
  }

  public String getName()
  {
    return mName;
  }

  public String getNodeId()
  {
    return zzbGv;
  }

  public String getPeerNodeId()
  {
    return zzbGt;
  }

  public int getRole()
  {
    return zzasR;
  }

  public int getType()
  {
    return zzOu;
  }

  public int hashCode()
  {
    return zzu.hashCode(new Object[] { Integer.valueOf(mVersionCode), mName, zzaBP, Integer.valueOf(zzOu), Integer.valueOf(zzasR), Boolean.valueOf(zzbGs), Boolean.valueOf(zzbGu) });
  }

  public boolean isConnected()
  {
    return zzLW;
  }

  public boolean isEnabled()
  {
    return zzbGs;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("ConnectionConfiguration[ ");
    localStringBuilder.append("mName=" + mName);
    localStringBuilder.append(", mAddress=" + zzaBP);
    localStringBuilder.append(", mType=" + zzOu);
    localStringBuilder.append(", mRole=" + zzasR);
    localStringBuilder.append(", mEnabled=" + zzbGs);
    localStringBuilder.append(", mIsConnected=" + zzLW);
    localStringBuilder.append(", mPeerNodeId=" + zzbGt);
    localStringBuilder.append(", mBtlePriority=" + zzbGu);
    localStringBuilder.append(", mNodeId=" + zzbGv);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
}
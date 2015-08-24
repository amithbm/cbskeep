package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.Node;

public class NodeParcelable
  implements SafeParcelable, Node
{
  public static final Parcelable.Creator<NodeParcelable> CREATOR = new zzay();
  final int mVersionCode;
  private final String zzLf;
  private final String zzPa;
  private final int zzbIs;
  private final boolean zzbIt;

  NodeParcelable(int paramInt1, String paramString1, String paramString2, int paramInt2, boolean paramBoolean)
  {
    mVersionCode = paramInt1;
    zzLf = paramString1;
    zzPa = paramString2;
    zzbIs = paramInt2;
    zzbIt = paramBoolean;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof NodeParcelable))
      return false;
    return ((NodeParcelable)paramObject).zzLf.equals(zzLf);
  }

  public String getDisplayName()
  {
    return zzPa;
  }

  public int getHopCount()
  {
    return zzbIs;
  }

  public String getId()
  {
    return zzLf;
  }

  public int hashCode()
  {
    return zzLf.hashCode();
  }

  public boolean isNearby()
  {
    return zzbIt;
  }

  public String toString()
  {
    return "Node{" + zzPa + ", id=" + zzLf + ", hops=" + zzbIs + ", isNearby=" + zzbIt + "}";
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzay.zza(this, paramParcel, paramInt);
  }
}
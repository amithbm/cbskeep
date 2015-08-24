package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.CapabilityInfo;
import com.google.android.gms.wearable.Node;
import java.util.List;
import java.util.Set;

public class CapabilityInfoParcelable
  implements SafeParcelable, CapabilityInfo
{
  public static final Parcelable.Creator<CapabilityInfoParcelable> CREATOR = new zzh();
  private final String mName;
  final int mVersionCode;
  private Set<Node> zzbHd;
  private final List<NodeParcelable> zzbHg;
  private final Object zzqY = new Object();

  CapabilityInfoParcelable(int paramInt, String paramString, List<NodeParcelable> paramList)
  {
    mVersionCode = paramInt;
    mName = paramString;
    zzbHg = paramList;
    zzbHd = null;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      paramObject = (CapabilityInfoParcelable)paramObject;
      if (mVersionCode != paramObject.mVersionCode)
        return false;
      if (mName != null)
      {
        if (mName.equals(paramObject.mName));
      }
      else
        while (paramObject.mName != null)
          return false;
      if (zzbHg == null)
        break;
    }
    while (zzbHg.equals(paramObject.zzbHg));
    while (true)
    {
      return false;
      if (paramObject.zzbHg == null)
        break;
    }
  }

  public String getName()
  {
    return mName;
  }

  public int hashCode()
  {
    int j = 0;
    int k = mVersionCode;
    if (mName != null);
    for (int i = mName.hashCode(); ; i = 0)
    {
      if (zzbHg != null)
        j = zzbHg.hashCode();
      return (i + k * 31) * 31 + j;
    }
  }

  public String toString()
  {
    return "CapabilityInfo{" + mName + ", " + zzbHg + "}";
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzh.zza(this, paramParcel, paramInt);
  }

  public List<NodeParcelable> zzGS()
  {
    return zzbHg;
  }
}
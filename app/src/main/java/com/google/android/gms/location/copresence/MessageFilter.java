package com.google.android.gms.location.copresence;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzv;
import com.google.android.gms.location.copresence.internal.zzo;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class MessageFilter
  implements SafeParcelable
{
  public static final Parcelable.Creator<MessageFilter> CREATOR = new zzh();
  private final int mVersionCode;
  private final List<FilterPrimitive> zzaSf;

  MessageFilter(int paramInt, List<FilterPrimitive> paramList)
  {
    mVersionCode = paramInt;
    if (paramList == null);
    for (paramList = null; ; paramList = Collections.unmodifiableList(paramList))
    {
      zzaSf = paramList;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MessageFilter(count=").append(zzaSf.size()).append(")\n");
    Iterator localIterator = zzaSf.iterator();
    while (localIterator.hasNext())
    {
      FilterPrimitive localFilterPrimitive = (FilterPrimitive)localIterator.next();
      localStringBuilder.append("[").append(0).append("]: ");
      localStringBuilder.append(localFilterPrimitive.toString()).append('\n');
    }
    return localStringBuilder.toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzh.zza(this, paramParcel, paramInt);
  }

  public List<FilterPrimitive> zzyz()
  {
    return zzaSf;
  }

  public static class FilterPrimitive
    implements SafeParcelable
  {
    public static final Parcelable.Creator<FilterPrimitive> CREATOR = new zzi();
    private final int mVersionCode;
    public final String type;
    public final AccessKey zzaSg;
    public final long zzaSh;
    public final People zzaSi;
    public final String zzamK;

    FilterPrimitive(int paramInt, String paramString1, String paramString2, AccessKey paramAccessKey, long paramLong, People paramPeople)
    {
      mVersionCode = paramInt;
      String str = paramString1;
      if (paramString1 == null)
        str = "";
      zzamK = str;
      paramString1 = paramString2;
      if (paramString2 == null)
        paramString1 = "";
      type = paramString1;
      zzaSg = paramAccessKey;
      zzaSh = zzo.zzV(paramLong);
      zzaSi = ((People)zzv.zzz(paramPeople));
    }

    public int describeContents()
    {
      return 0;
    }

    public boolean equals(Object paramObject)
    {
      if (this == paramObject);
      while (true)
      {
        return true;
        if (!(paramObject instanceof FilterPrimitive))
          return false;
        paramObject = (FilterPrimitive)paramObject;
        if (zzaSh == paramObject.zzaSh)
        {
          if (zzaSg != null)
            break label105;
          if (paramObject.zzaSg != null);
        }
        while ((!zzamK.equals(paramObject.zzamK)) || (!type.equals(paramObject.type)) || (!zzaSi.zza(paramObject.zzaSi)) || (!paramObject.zzaSi.zza(zzaSi)))
          label105: 
          do
            return false;
          while (!zzaSg.equals(paramObject.zzaSg));
      }
    }

    int getVersionCode()
    {
      return mVersionCode;
    }

    public int hashCode()
    {
      return (zzamK.hashCode() * 31 + type.hashCode()) * 31 + (int)(zzaSh ^ zzaSh >>> 32);
    }

    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder().append("(namespace=").append(zzamK).append(", type=").append(type).append(", accessKey=");
      if (zzaSg == null);
      for (String str = null; ; str = "REDACTED")
        return str + ", ttl=" + zzaSh + ", senders=" + zzaSi + ")";
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      zzi.zza(this, paramParcel, paramInt);
    }
  }
}
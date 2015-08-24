package com.google.android.gms.appdatasearch;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class CorpusStatus
  implements SafeParcelable
{
  public static final zzc CREATOR = new zzc();
  final int mVersionCode;
  final String zzMA;
  final boolean zzMv;
  final long zzMw;
  final long zzMx;
  final long zzMy;
  final Bundle zzMz;

  CorpusStatus()
  {
    this(2, false, 0L, 0L, 0L, null, null);
  }

  CorpusStatus(int paramInt, boolean paramBoolean, long paramLong1, long paramLong2, long paramLong3, Bundle paramBundle, String paramString)
  {
    mVersionCode = paramInt;
    zzMv = paramBoolean;
    zzMw = paramLong1;
    zzMx = paramLong2;
    zzMy = paramLong3;
    Bundle localBundle = paramBundle;
    if (paramBundle == null)
      localBundle = new Bundle();
    zzMz = localBundle;
    zzMA = paramString;
  }

  public int describeContents()
  {
    zzc localzzc = CREATOR;
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof CorpusStatus))
    {
      paramObject = (CorpusStatus)paramObject;
      bool1 = bool2;
      if (zzu.equal(Boolean.valueOf(zzMv), Boolean.valueOf(paramObject.zzMv)))
      {
        bool1 = bool2;
        if (zzu.equal(Long.valueOf(zzMw), Long.valueOf(paramObject.zzMw)))
        {
          bool1 = bool2;
          if (zzu.equal(Long.valueOf(zzMx), Long.valueOf(paramObject.zzMx)))
          {
            bool1 = bool2;
            if (zzu.equal(Long.valueOf(zzMy), Long.valueOf(paramObject.zzMy)))
            {
              bool1 = bool2;
              if (zzu.equal(getCounters(), paramObject.getCounters()))
                bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }

  public Map<String, Integer> getCounters()
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = zzMz.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      int i = zzMz.getInt(str, -1);
      if (i != -1)
        localHashMap.put(str, Integer.valueOf(i));
    }
    return localHashMap;
  }

  public int hashCode()
  {
    return zzu.hashCode(new Object[] { Boolean.valueOf(zzMv), Long.valueOf(zzMw), Long.valueOf(zzMx), Long.valueOf(zzMy), getCounters() });
  }

  public String toString()
  {
    return "CorpusStatus{found=" + zzMv + ", lastIndexedSeqno=" + zzMw + ", lastCommittedSeqno=" + zzMx + ", committedNumDocuments=" + zzMy + ", counters=" + zzMz + "}";
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc localzzc = CREATOR;
    zzc.zza(this, paramParcel, paramInt);
  }
}
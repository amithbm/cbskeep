package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

public class LatencyTracker
  implements SafeParcelable
{
  public static final zzg CREATOR = new zzg();
  final String mName;
  final int mVersion;
  public final LatencyTracker parent;
  final long zzUk;

  LatencyTracker(int paramInt, String paramString, long paramLong, LatencyTracker paramLatencyTracker)
  {
    mVersion = paramInt;
    mName = paramString;
    zzUk = paramLong;
    parent = paramLatencyTracker;
    log(paramString, "constructed");
  }

  public int describeContents()
  {
    return 0;
  }

  public void log(String paramString1, String paramString2)
  {
    if (Log.isLoggable("GLSLogging", 2))
    {
      String str = zzA(SystemClock.elapsedRealtime());
      Log.println(2, "GLSLogging", paramString1 + " " + str + " > " + paramString2);
    }
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    log(mName, "writing to parcel");
    zzg.zza(this, paramParcel, paramInt);
  }

  String zzA(long paramLong)
  {
    LinkedList localLinkedList = new LinkedList();
    for (LatencyTracker localLatencyTracker = this; localLatencyTracker != null; localLatencyTracker = localLatencyTracker.parent)
    {
      long l1 = paramLong - localLatencyTracker.zzUk;
      long l2 = TimeUnit.MILLISECONDS.toSeconds(l1);
      long l3 = TimeUnit.SECONDS.toMillis(l2);
      localLinkedList.addFirst(String.format("[%s, %,d.%03ds]", new Object[] { localLatencyTracker.mName, Long.valueOf(l2), Long.valueOf(l1 - l3) }));
    }
    return TextUtils.join(" > ", localLinkedList);
  }
}
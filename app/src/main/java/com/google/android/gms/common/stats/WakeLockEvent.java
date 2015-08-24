package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public final class WakeLockEvent
  implements SafeParcelable
{
  public static final Parcelable.Creator<WakeLockEvent> CREATOR = new zzg();
  final int mVersionCode;
  private final long zzanB;
  private int zzanC;
  private final long zzanJ;
  private long zzanL;
  private final String zzaol;
  private final int zzaom;
  private final List<String> zzaon;
  private final String zzaoo;
  private boolean zzaop;
  private final String zzaoq;
  private final String zzaor;
  private int zzaos;

  WakeLockEvent(int paramInt1, long paramLong1, int paramInt2, String paramString1, int paramInt3, List<String> paramList, String paramString2, long paramLong2, boolean paramBoolean, String paramString3, String paramString4)
  {
    mVersionCode = paramInt1;
    zzanB = paramLong1;
    zzanC = paramInt2;
    zzaol = paramString1;
    zzaoq = paramString3;
    zzaom = paramInt3;
    zzanL = -1L;
    zzaon = paramList;
    zzaoo = paramString2;
    zzanJ = paramLong2;
    zzaop = paramBoolean;
    if (paramBoolean);
    for (paramInt1 = 1; ; paramInt1 = 0)
    {
      zzaos = paramInt1;
      zzaor = paramString4;
      return;
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public int getEventType()
  {
    return zzanC;
  }

  public long getTimeMillis()
  {
    return zzanB;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzg.zza(this, paramParcel, paramInt);
  }

  public String zzqB()
  {
    return zzaol;
  }

  public String zzqC()
  {
    return zzaoq;
  }

  public int zzqD()
  {
    return zzaom;
  }

  public List<String> zzqE()
  {
    return zzaon;
  }

  public boolean zzqF()
  {
    return zzaop;
  }

  public String zzqG()
  {
    return zzaor;
  }

  public String zzqx()
  {
    return zzaoo;
  }

  public long zzqz()
  {
    return zzanJ;
  }
}
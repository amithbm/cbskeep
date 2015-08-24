package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class GestureEvent
  implements SafeParcelable
{
  public static final zzb CREATOR = new zzb();
  private final int mVersionCode;
  private final int zzOu;
  private final long zzaRj;
  private final long zzaRk;
  private final int zzaRl;
  private final boolean zzaRm;
  private final boolean zzaRn;

  GestureEvent(int paramInt1, int paramInt2, long paramLong1, long paramLong2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2)
  {
    mVersionCode = paramInt1;
    zzOu = paramInt2;
    zzaRj = paramLong1;
    zzaRk = paramLong2;
    zzaRl = paramInt3;
    zzaRm = paramBoolean1;
    zzaRn = paramBoolean2;
  }

  public int describeContents()
  {
    zzb localzzb = CREATOR;
    return 0;
  }

  public int getCount()
  {
    return zzaRl;
  }

  public long getElapsedRealtimeMillis()
  {
    return zzaRk;
  }

  public long getTimeMillis()
  {
    return zzaRj;
  }

  public int getType()
  {
    return zzOu;
  }

  public int getVersionCode()
  {
    return mVersionCode;
  }

  public boolean isEnd()
  {
    return zzaRn;
  }

  public boolean isStart()
  {
    return zzaRm;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb localzzb = CREATOR;
    zzb.zza(this, paramParcel, paramInt);
  }
}
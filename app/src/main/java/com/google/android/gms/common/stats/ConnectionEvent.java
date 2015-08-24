package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class ConnectionEvent
  implements SafeParcelable
{
  public static final Parcelable.Creator<ConnectionEvent> CREATOR = new zza();
  final int mVersionCode;
  private final long zzanB;
  private int zzanC;
  private final String zzanD;
  private final String zzanE;
  private final String zzanF;
  private final String zzanG;
  private final String zzanH;
  private final String zzanI;
  private final long zzanJ;
  private final long zzanK;
  private long zzanL;

  ConnectionEvent(int paramInt1, long paramLong1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, long paramLong2, long paramLong3)
  {
    mVersionCode = paramInt1;
    zzanB = paramLong1;
    zzanC = paramInt2;
    zzanD = paramString1;
    zzanE = paramString2;
    zzanF = paramString3;
    zzanG = paramString4;
    zzanL = -1L;
    zzanH = paramString5;
    zzanI = paramString6;
    zzanJ = paramLong2;
    zzanK = paramLong3;
  }

  public ConnectionEvent(long paramLong1, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, long paramLong2, long paramLong3)
  {
    this(1, paramLong1, paramInt, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramLong2, paramLong3);
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
    zza.zza(this, paramParcel, paramInt);
  }

  public String zzqs()
  {
    return zzanD;
  }

  public String zzqt()
  {
    return zzanE;
  }

  public String zzqu()
  {
    return zzanF;
  }

  public String zzqv()
  {
    return zzanG;
  }

  public String zzqw()
  {
    return zzanH;
  }

  public String zzqx()
  {
    return zzanI;
  }

  public long zzqy()
  {
    return zzanK;
  }

  public long zzqz()
  {
    return zzanJ;
  }
}
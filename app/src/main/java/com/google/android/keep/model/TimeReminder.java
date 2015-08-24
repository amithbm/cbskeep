package com.google.android.keep.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.reminders.model.Recurrence;
import com.google.android.keep.U;
import com.google.android.keep.provider.i.s;
import com.google.android.keep.util.KeepTime;

public class TimeReminder extends BaseReminder
{
  public static Parcelable.Creator<TimeReminder> CREATOR = new Parcelable.Creator()
  {
    public TimeReminder[] bl(int paramAnonymousInt)
    {
      return new TimeReminder[paramAnonymousInt];
    }

    public TimeReminder m(Parcel paramAnonymousParcel)
    {
      return new TimeReminder(paramAnonymousParcel, null);
    }
  };
  private boolean oi;
  private int zD;
  private long zE;
  private long zF;
  private int zG;
  private Recurrence zH;

  public TimeReminder(long paramLong1, int paramInt1, long paramLong2, int paramInt2)
  {
    this(paramLong1, null, paramInt1, paramLong2, paramInt2, false, 0L, null);
  }

  public TimeReminder(long paramLong, String paramString)
  {
    this(paramLong, paramString, 0, 0L, TimePeriod.zI.ordinal(), false, 0L, null);
    oi = true;
  }

  public TimeReminder(long paramLong1, String paramString, int paramInt1, long paramLong2, int paramInt2, boolean paramBoolean, long paramLong3, Recurrence paramRecurrence)
  {
    super(0, paramLong1, paramString, paramBoolean, paramLong3);
    zD = paramInt1;
    zE = paramLong2;
    zG = paramInt2;
    zH = paramRecurrence;
    paramString = new KeepTime();
    TimePeriod localTimePeriod = TimePeriod.bm(zG);
    if (localTimePeriod == TimePeriod.zI);
    for (zF = (paramString.setJulianDay(zD) + zE); ; zF = (paramString.setJulianDay(zD) + TimePeriod.c(localTimePeriod) * 3600000L))
    {
      zH = paramRecurrence;
      if ((i.s.b(Integer.valueOf(paramInt2))) || (paramInt2 == 0))
        break;
      throw new IllegalArgumentException("Invalid timePeriod specified: " + paramInt2);
    }
  }

  private TimeReminder(Parcel paramParcel)
  {
    super(paramParcel);
    zD = paramParcel.readInt();
    zE = paramParcel.readLong();
    zF = paramParcel.readLong();
    zG = paramParcel.readInt();
    zH = ((Recurrence)paramParcel.readParcelable(Recurrence.class.getClassLoader()));
    if (paramParcel.readInt() == 1);
    for (boolean bool = true; ; bool = false)
    {
      oi = bool;
      return;
    }
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == this);
    while (true)
    {
      return true;
      if (!(paramObject instanceof TimeReminder))
        return false;
      paramObject = (TimeReminder)paramObject;
      if ((dP() == paramObject.dP()) && (zG == paramObject.jo()) && (zD == paramObject.jm()) && (zE == paramObject.jn()))
      {
        if (zH == null)
          break label101;
        if (!zH.equals(paramObject.getRecurrence()));
      }
      while (oi != paramObject.jq())
        label101: 
        do
          return false;
        while (paramObject.getRecurrence() != null);
    }
  }

  public Recurrence getRecurrence()
  {
    return zH;
  }

  public String gu()
  {
    return toString();
  }

  public int jm()
  {
    return zD;
  }

  public long jn()
  {
    return zE;
  }

  public int jo()
  {
    return zG;
  }

  public long jp()
  {
    return zF;
  }

  public boolean jq()
  {
    return oi;
  }

  public String toString()
  {
    return super.toString() + "TimeReminder{" + "mJulianDay=" + zD + ", mTimeOfDayMs=" + zE + ", mReminderTimePeriod=" + zG + ", mRecurrence=" + zH + ", mHasUnspecifiedFutureTime=" + oi + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(zD);
    paramParcel.writeLong(zE);
    paramParcel.writeLong(zF);
    paramParcel.writeInt(zG);
    paramParcel.writeParcelable(zH, paramInt);
    if (oi);
    for (paramInt = 1; ; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      return;
    }
  }

  public static enum TimePeriod
  {
    public static int b(TimePeriod paramTimePeriod)
    {
      switch (TimeReminder.2.oE[paramTimePeriod.ordinal()])
      {
      default:
        throw new IllegalStateException("Unknown reminder type " + paramTimePeriod);
      case 1:
        return 1;
      case 2:
        return 2;
      case 3:
        return 3;
      case 4:
      }
      return 4;
    }

    public static TimePeriod bm(int paramInt)
    {
      switch (paramInt)
      {
      default:
        return zI;
      case 1:
        return zJ;
      case 2:
        return zK;
      case 3:
        return zL;
      case 4:
      }
      return zM;
    }

    public static int c(TimePeriod paramTimePeriod)
    {
      switch (TimeReminder.2.oE[paramTimePeriod.ordinal()])
      {
      default:
        return 0;
      case 1:
        return U.kI();
      case 2:
        return U.kJ();
      case 3:
        return U.kK();
      case 4:
      }
      return U.kL();
    }
  }
}
package com.google.android.keep.model;

import android.text.TextUtils;
import com.android.calendarcommon2.EventRecurrence;
import com.google.android.gms.reminders.model.DailyPattern.Builder;
import com.google.android.gms.reminders.model.DateTime;
import com.google.android.gms.reminders.model.DateTime.Builder;
import com.google.android.gms.reminders.model.MonthlyPattern;
import com.google.android.gms.reminders.model.MonthlyPattern.Builder;
import com.google.android.gms.reminders.model.Recurrence;
import com.google.android.gms.reminders.model.Recurrence.Builder;
import com.google.android.gms.reminders.model.RecurrenceEnd;
import com.google.android.gms.reminders.model.RecurrenceEnd.Builder;
import com.google.android.gms.reminders.model.Time.Builder;
import com.google.android.gms.reminders.model.WeeklyPattern;
import com.google.android.gms.reminders.model.WeeklyPattern.Builder;
import com.google.android.gms.reminders.model.YearlyPattern;
import com.google.android.gms.reminders.model.YearlyPattern.Builder;
import com.google.android.keep.util.KeepTime;
import com.google.android.keep.util.r;
import com.google.android.keep.util.x;
import java.util.List;
import java.util.TimeZone;

public class g
{
  static int a(TimeReminder.TimePeriod paramTimePeriod)
  {
    switch (1.oE[paramTimePeriod.ordinal()])
    {
    default:
      return 0;
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

  public static EventRecurrence a(Recurrence paramRecurrence)
  {
    EventRecurrence localEventRecurrence = new EventRecurrence();
    if (paramRecurrence.getFrequency() != null)
      localEventRecurrence.freq = aQ(paramRecurrence.getFrequency().intValue());
    if (paramRecurrence.getEvery() != null)
      localEventRecurrence.interval = paramRecurrence.getEvery().intValue();
    a(localEventRecurrence, paramRecurrence);
    b(localEventRecurrence, paramRecurrence);
    c(localEventRecurrence, paramRecurrence);
    d(localEventRecurrence, paramRecurrence);
    return localEventRecurrence;
  }

  public static Recurrence.Builder a(Recurrence.Builder paramBuilder, KeepTime paramKeepTime, EventRecurrence paramEventRecurrence)
  {
    paramBuilder.setFrequency(Integer.valueOf(aP(paramEventRecurrence.freq)));
    if (paramEventRecurrence.interval > 0)
      paramBuilder.setEvery(Integer.valueOf(paramEventRecurrence.interval));
    Object localObject = b(paramEventRecurrence);
    if (localObject != null)
      paramBuilder.setRecurrenceEnd((RecurrenceEnd)localObject);
    switch (paramEventRecurrence.freq)
    {
    default:
      return paramBuilder;
    case 5:
      localObject = c(paramEventRecurrence);
      paramEventRecurrence = (EventRecurrence)localObject;
      if (localObject == null)
        paramEventRecurrence = new WeeklyPattern.Builder().addWeekDay(new Integer[] { Integer.valueOf(paramKeepTime.weekDay) });
      paramBuilder.setWeeklyPattern(paramEventRecurrence.build());
      return paramBuilder;
    case 6:
      localObject = new MonthlyPattern.Builder();
      if (paramEventRecurrence.bydayCount > 0)
      {
        ((MonthlyPattern.Builder)localObject).setWeekDay(Integer.valueOf(aR(paramEventRecurrence.byday[0])));
        ((MonthlyPattern.Builder)localObject).setWeekDayNumber(Integer.valueOf(paramEventRecurrence.bydayNum[0]));
      }
      while (true)
      {
        paramBuilder.setMonthlyPattern(((MonthlyPattern.Builder)localObject).build());
        return paramBuilder;
        if (paramEventRecurrence.bymonthdayCount > 0)
        {
          paramKeepTime = paramEventRecurrence.bymonthday;
          int j = paramKeepTime.length;
          int i = 0;
          while (i < j)
          {
            ((MonthlyPattern.Builder)localObject).addMonthDay(new Integer[] { Integer.valueOf(paramKeepTime[i]) });
            i += 1;
          }
        }
        ((MonthlyPattern.Builder)localObject).addMonthDay(new Integer[] { Integer.valueOf(paramKeepTime.monthDay) });
      }
    case 7:
    }
    paramBuilder.setYearlyPattern(new YearlyPattern.Builder().addYearMonth(new Integer[] { Integer.valueOf(paramKeepTime.month + 1) }).setMonthlyPattern(new MonthlyPattern.Builder().addMonthDay(new Integer[] { Integer.valueOf(paramKeepTime.monthDay) }).build()).build());
    return paramBuilder;
  }

  private static void a(EventRecurrence paramEventRecurrence, Recurrence paramRecurrence)
  {
    Object localObject = paramRecurrence.getRecurrenceEnd();
    if (localObject == null);
    do
    {
      do
        return;
      while ((((RecurrenceEnd)localObject).getAutoRenew() != null) && (((RecurrenceEnd)localObject).getAutoRenew().booleanValue()));
      paramRecurrence = ((RecurrenceEnd)localObject).getEndDateTime();
      if (paramRecurrence != null)
      {
        localObject = new android.text.format.Time("UTC");
        com.google.android.gms.reminders.model.Time localTime = paramRecurrence.getTime();
        if (localTime != null)
          ((android.text.format.Time)localObject).set(localTime.getSecond().intValue(), localTime.getMinute().intValue(), localTime.getHour().intValue(), paramRecurrence.getDay().intValue(), paramRecurrence.getMonth().intValue() - 1, paramRecurrence.getYear().intValue());
        while (true)
        {
          ((android.text.format.Time)localObject).switchTimezone(TimeZone.getDefault().getID());
          ((android.text.format.Time)localObject).allDay = false;
          until = ((android.text.format.Time)localObject).format2445();
          return;
          ((android.text.format.Time)localObject).set(paramRecurrence.getDay().intValue(), paramRecurrence.getMonth().intValue() - 1, paramRecurrence.getYear().intValue());
        }
      }
      paramRecurrence = ((RecurrenceEnd)localObject).getNumOccurrences();
    }
    while ((paramRecurrence == null) || (paramRecurrence.intValue() <= 0));
    count = ((RecurrenceEnd)localObject).getNumOccurrences().intValue();
  }

  static int aP(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return -1;
    case 4:
      return 0;
    case 5:
      return 1;
    case 6:
      return 2;
    case 7:
    }
    return 3;
  }

  private static int aQ(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return -1;
    case 0:
      return 4;
    case 1:
      return 5;
    case 2:
      return 6;
    case 3:
    }
    return 7;
  }

  private static int aR(int paramInt)
  {
    switch (paramInt)
    {
    default:
      throw new IllegalArgumentException("Invalid week day in EventRecurrence:" + paramInt);
    case 65536:
      return 7;
    case 131072:
      return 1;
    case 262144:
      return 2;
    case 524288:
      return 3;
    case 1048576:
      return 4;
    case 2097152:
      return 5;
    case 4194304:
    }
    return 6;
  }

  private static int aS(int paramInt)
  {
    switch (paramInt)
    {
    default:
      throw new IllegalArgumentException("Invalid week day in recurrence:" + paramInt);
    case 1:
      return 131072;
    case 2:
      return 262144;
    case 3:
      return 524288;
    case 4:
      return 1048576;
    case 5:
      return 2097152;
    case 6:
      return 4194304;
    case 7:
    }
    return 65536;
  }

  static DailyPattern.Builder b(KeepTime paramKeepTime, TimeReminder.TimePeriod paramTimePeriod)
  {
    DailyPattern.Builder localBuilder = new DailyPattern.Builder();
    int i = a(paramTimePeriod);
    if (i > 0)
    {
      localBuilder.setDayPeriod(Integer.valueOf(i));
      return localBuilder;
    }
    localBuilder.setTimeOfDay(new Time.Builder().setHour(Integer.valueOf(hour)).setMinute(Integer.valueOf(minute)).setSecond(Integer.valueOf(second)).build());
    return localBuilder;
  }

  private static RecurrenceEnd b(EventRecurrence paramEventRecurrence)
  {
    Object localObject = null;
    if (count > 0)
      localObject = new RecurrenceEnd.Builder().setNumOccurrences(Integer.valueOf(count));
    while (localObject != null)
    {
      return ((RecurrenceEnd.Builder)localObject).build();
      if (!TextUtils.isEmpty(until))
      {
        localObject = new android.text.format.Time();
        ((android.text.format.Time)localObject).parse(until);
        paramEventRecurrence = x.b((android.text.format.Time)localObject).build();
        localObject = new RecurrenceEnd.Builder().setEndDateTime(paramEventRecurrence);
      }
    }
    return null;
  }

  private static void b(EventRecurrence paramEventRecurrence, Recurrence paramRecurrence)
  {
    paramRecurrence = paramRecurrence.getWeeklyPattern();
    if (paramRecurrence == null)
      return;
    paramRecurrence = paramRecurrence.getWeekDay();
    int j = paramRecurrence.size();
    int[] arrayOfInt1 = new int[j];
    int[] arrayOfInt2 = new int[j];
    int i = 0;
    while (i < j)
    {
      arrayOfInt1[i] = aS(((Integer)paramRecurrence.get(i)).intValue());
      arrayOfInt2[i] = ((Integer)paramRecurrence.get(i)).intValue();
      i += 1;
    }
    bydayCount = j;
    byday = arrayOfInt1;
    bydayNum = arrayOfInt2;
  }

  private static WeeklyPattern.Builder c(EventRecurrence paramEventRecurrence)
  {
    Object localObject;
    if (bydayCount <= 0)
    {
      localObject = null;
      return localObject;
    }
    WeeklyPattern.Builder localBuilder = new WeeklyPattern.Builder();
    int i = 0;
    while (true)
    {
      localObject = localBuilder;
      if (i >= bydayCount)
        break;
      localBuilder.addWeekDay(new Integer[] { Integer.valueOf(aR(byday[i])) });
      i += 1;
    }
  }

  private static void c(EventRecurrence paramEventRecurrence, Recurrence paramRecurrence)
  {
    paramRecurrence = paramRecurrence.getMonthlyPattern();
    if (paramRecurrence == null);
    Object localObject;
    do
    {
      return;
      localObject = paramRecurrence.getMonthDay();
      if (localObject != null)
      {
        int j = ((List)localObject).size();
        int[] arrayOfInt = new int[j];
        int i = 0;
        while (i < j)
        {
          arrayOfInt[i] = ((Integer)((List)localObject).get(i)).intValue();
          i += 1;
        }
        bymonthdayCount = j;
        bymonthday = arrayOfInt;
      }
      localObject = paramRecurrence.getWeekDay();
      paramRecurrence = paramRecurrence.getWeekDayNumber();
    }
    while ((localObject == null) || (paramRecurrence == null));
    if ((paramRecurrence.intValue() > 5) || (paramRecurrence.intValue() < -1))
    {
      bydayCount = 0;
      r.e("EventRecurrenceConverter", "Invalid weekdayNumber: " + paramRecurrence, new Object[0]);
      return;
    }
    bydayCount = 1;
    byday = new int[] { aS(((Integer)localObject).intValue()) };
    bydayNum = new int[] { paramRecurrence.intValue() };
  }

  private static void d(EventRecurrence paramEventRecurrence, Recurrence paramRecurrence)
  {
    paramRecurrence = paramRecurrence.getYearlyPattern();
    if (paramRecurrence == null)
      return;
    paramRecurrence = paramRecurrence.getYearMonth();
    int j = paramRecurrence.size();
    int[] arrayOfInt = new int[j];
    int i = 0;
    while (i < j)
    {
      arrayOfInt[i] = ((Integer)paramRecurrence.get(i)).intValue();
      i += 1;
    }
    bymonthCount = j;
    bymonth = arrayOfInt;
  }
}
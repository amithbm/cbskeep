package com.google.android.keep.model;

import android.text.TextUtils;
import android.text.format.Time;
import com.android.calendarcommon2.EventRecurrence;
import com.google.android.gms.reminders.model.DailyPattern.Builder;
import com.google.android.gms.reminders.model.DateTime.Builder;
import com.google.android.gms.reminders.model.MonthlyPattern.Builder;
import com.google.android.gms.reminders.model.Recurrence;
import com.google.android.gms.reminders.model.Recurrence.Builder;
import com.google.android.gms.reminders.model.RecurrenceStart.Builder;
import com.google.android.gms.reminders.model.WeeklyPattern.Builder;
import com.google.android.gms.reminders.model.YearlyPattern.Builder;
import com.google.android.keep.editor.ReminderHelper.RecurrenceType;
import com.google.android.keep.util.KeepTime;
import com.google.android.keep.util.x;

public class y
{
  private static int a(Time paramTime)
  {
    if (weekDay == 0)
      return 7;
    return weekDay;
  }

  public static Recurrence a(KeepTime paramKeepTime, TimeReminder.TimePeriod paramTimePeriod, ReminderHelper.RecurrenceType paramRecurrenceType, EventRecurrence paramEventRecurrence)
  {
    if (paramRecurrenceType == ReminderHelper.RecurrenceType.oW)
      return null;
    Object localObject = x.b(paramKeepTime);
    int i = g.a(paramTimePeriod);
    if ((i >= 1) && (i <= 4))
    {
      ((DateTime.Builder)localObject).setPeriod(Integer.valueOf(g.a(paramTimePeriod)));
      ((DateTime.Builder)localObject).setTime(x.d(paramTimePeriod));
    }
    localObject = new Recurrence.Builder().setRecurrenceStart(new RecurrenceStart.Builder().setStartDateTime(((DateTime.Builder)localObject).build()).build());
    i = b(paramRecurrenceType);
    if (i != -1)
      ((Recurrence.Builder)localObject).setFrequency(Integer.valueOf(i));
    ((Recurrence.Builder)localObject).setDailyPattern(g.b(paramKeepTime, paramTimePeriod).build());
    switch (1.oG[paramRecurrenceType.ordinal()])
    {
    default:
      return ((Recurrence.Builder)localObject).build();
    case 1:
      return ((Recurrence.Builder)localObject).setWeeklyPattern(new WeeklyPattern.Builder().addWeekDay(new Integer[] { Integer.valueOf(a(paramKeepTime)) }).build()).build();
    case 2:
      return ((Recurrence.Builder)localObject).setMonthlyPattern(new MonthlyPattern.Builder().addMonthDay(new Integer[] { Integer.valueOf(monthDay) }).build()).build();
    case 3:
      return ((Recurrence.Builder)localObject).setYearlyPattern(new YearlyPattern.Builder().addYearMonth(new Integer[] { Integer.valueOf(month + 1) }).setMonthlyPattern(new MonthlyPattern.Builder().addMonthDay(new Integer[] { Integer.valueOf(monthDay) }).build()).build()).build();
    case 4:
    }
    g.a((Recurrence.Builder)localObject, paramKeepTime, paramEventRecurrence);
    return ((Recurrence.Builder)localObject).build();
  }

  private static int b(ReminderHelper.RecurrenceType paramRecurrenceType)
  {
    switch (1.oG[paramRecurrenceType.ordinal()])
    {
    case 4:
    default:
      return -1;
    case 5:
      return 0;
    case 1:
      return 1;
    case 2:
      return 2;
    case 3:
    }
    return 3;
  }

  public static ReminderHelper.RecurrenceType d(EventRecurrence paramEventRecurrence)
  {
    if ((count > 0) || (!TextUtils.isEmpty(until)) || (interval > 1) || (bydayCount >= 1) || (bymonthdayCount > 1))
      return ReminderHelper.RecurrenceType.pb;
    switch (freq)
    {
    default:
      return ReminderHelper.RecurrenceType.pb;
    case 4:
      return ReminderHelper.RecurrenceType.oX;
    case 5:
      return ReminderHelper.RecurrenceType.oY;
    case 6:
      return ReminderHelper.RecurrenceType.oZ;
    case 7:
    }
    return ReminderHelper.RecurrenceType.pa;
  }
}
package com.android.recurrencepicker;

import android.content.Context;
import android.content.res.Resources;
import android.text.format.DateUtils;
import android.text.format.Time;
import android.util.TimeFormatException;
import com.android.calendarcommon2.EventRecurrence;

public class Utils
{
  private static int[] mMonthRepeatByDayOfWeekIds;
  private static String[][] mMonthRepeatByDayOfWeekStrs;

  private static void cacheMonthRepeatStrings(Resources paramResources, int paramInt)
  {
    if (mMonthRepeatByDayOfWeekIds == null)
    {
      mMonthRepeatByDayOfWeekIds = new int[7];
      mMonthRepeatByDayOfWeekIds[0] = R.array.repeat_by_nth_sun;
      mMonthRepeatByDayOfWeekIds[1] = R.array.repeat_by_nth_mon;
      mMonthRepeatByDayOfWeekIds[2] = R.array.repeat_by_nth_tues;
      mMonthRepeatByDayOfWeekIds[3] = R.array.repeat_by_nth_wed;
      mMonthRepeatByDayOfWeekIds[4] = R.array.repeat_by_nth_thurs;
      mMonthRepeatByDayOfWeekIds[5] = R.array.repeat_by_nth_fri;
      mMonthRepeatByDayOfWeekIds[6] = R.array.repeat_by_nth_sat;
    }
    if (mMonthRepeatByDayOfWeekStrs == null)
      mMonthRepeatByDayOfWeekStrs = new String[7][];
    if (mMonthRepeatByDayOfWeekStrs[paramInt] == null)
      mMonthRepeatByDayOfWeekStrs[paramInt] = paramResources.getStringArray(mMonthRepeatByDayOfWeekIds[paramInt]);
  }

  public static int convertDayOfWeekFromTimeToCalendar(int paramInt)
  {
    switch (paramInt)
    {
    default:
      throw new IllegalArgumentException("Argument must be between Time.SUNDAY and Time.SATURDAY");
    case 1:
      return 2;
    case 2:
      return 3;
    case 3:
      return 4;
    case 4:
      return 5;
    case 5:
      return 6;
    case 6:
      return 7;
    case 0:
    }
    return 1;
  }

  private static String dayToString(int paramInt1, int paramInt2)
  {
    return DateUtils.getDayOfWeekString(dayToUtilDay(paramInt1), paramInt2);
  }

  private static int dayToUtilDay(int paramInt)
  {
    switch (paramInt)
    {
    default:
      throw new IllegalArgumentException("bad day argument: " + paramInt);
    case 65536:
      return 1;
    case 131072:
      return 2;
    case 262144:
      return 3;
    case 524288:
      return 4;
    case 1048576:
      return 5;
    case 2097152:
      return 6;
    case 4194304:
    }
    return 7;
  }

  private static String getDaysString(int paramInt, int[] paramArrayOfInt)
  {
    if (paramInt == 1);
    StringBuilder localStringBuilder;
    int j;
    for (int i = 10; ; i = 20)
    {
      localStringBuilder = new StringBuilder();
      j = paramInt - 1;
      paramInt = 0;
      while (paramInt < j)
      {
        localStringBuilder.append(dayToString(paramArrayOfInt[paramInt], i));
        localStringBuilder.append(", ");
        paramInt += 1;
      }
    }
    localStringBuilder.append(dayToString(paramArrayOfInt[j], i));
    return localStringBuilder.toString();
  }

  public static int getFirstDayOfWeek(Context paramContext)
  {
    return 0;
  }

  public static int getFirstDayOfWeekAsCalendar(Context paramContext)
  {
    return convertDayOfWeekFromTimeToCalendar(getFirstDayOfWeek(paramContext));
  }

  public static String getRepeatString(Resources paramResources, EventRecurrence paramEventRecurrence, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = "";
    if (paramBoolean1)
    {
      localObject1 = new StringBuilder();
      if (paramEventRecurrence.until == null);
    }
    try
    {
      Object localObject2 = new Time();
      ((Time)localObject2).parse(paramEventRecurrence.until);
      localObject2 = DateUtils.formatDateTime(null, ((Time)localObject2).toMillis(false), 131072);
      ((StringBuilder)localObject1).append(paramResources.getString(R.string.endByDate, new Object[] { localObject2 }));
      label79: if (paramEventRecurrence.count > 0)
        ((StringBuilder)localObject1).append(paramResources.getQuantityString(R.plurals.endByCount, paramEventRecurrence.count, new Object[] { Integer.valueOf(paramEventRecurrence.count) }));
      localObject1 = ((StringBuilder)localObject1).toString();
      int i;
      if (paramEventRecurrence.interval <= 1)
      {
        i = 1;
        label135: if (!repeatsEveryDay(paramEventRecurrence))
          break label187;
      }
      label187: for (int j = 4; ; j = paramEventRecurrence.freq)
        switch (j)
        {
        default:
          return null;
          i = paramEventRecurrence.interval;
          break label135;
        case 4:
        case 5:
        case 6:
        case 7:
        }
      if (paramBoolean2);
      for (j = R.plurals.daily; ; j = R.plurals.daily_lower)
        return paramResources.getQuantityString(j, i, new Object[] { Integer.valueOf(i) }) + (String)localObject1;
      int k;
      if (paramBoolean2)
      {
        j = R.plurals.weekly;
        if (!paramBoolean2)
          break label319;
        k = R.string.weekly_simple;
        label270: if (!paramBoolean2)
          break label327;
      }
      label319: label327: for (int m = R.string.every_weekday; ; m = R.string.every_weekday_lower)
      {
        if (!paramEventRecurrence.repeatsOnEveryWeekDay())
          break label335;
        return paramResources.getString(m) + (String)localObject1;
        j = R.plurals.weekly_lower;
        break;
        k = R.string.weekly_simple_lower;
        break label270;
      }
      label335: if (paramEventRecurrence.bydayCount > 0);
      for (paramEventRecurrence = getDaysString(paramEventRecurrence.bydayCount, paramEventRecurrence.byday); ; paramEventRecurrence = dayToString(EventRecurrence.timeDay2Day(paramEventRecurrence.startDate.weekDay), 10))
      {
        return paramResources.getQuantityString(j, i, new Object[] { Integer.valueOf(i), paramEventRecurrence }) + (String)localObject1;
        if (paramEventRecurrence.startDate == null)
          return paramResources.getString(k) + (String)localObject1;
      }
      if (paramBoolean2);
      for (j = R.plurals.monthly_interval; ; j = R.plurals.monthly_interval_lower)
      {
        localObject2 = paramResources.getQuantityString(j, i, new Object[] { Integer.valueOf(i) });
        if (!repeatsMonthlyOnDayCountAllowNeg(paramEventRecurrence))
          break;
        k = EventRecurrence.day2TimeDay(paramEventRecurrence.byday[0]);
        cacheMonthRepeatStrings(paramResources, k);
        j = paramEventRecurrence.bydayNum[0] - 1;
        i = j;
        if (j == -2)
          i = 4;
        paramResources = new StringBuilder();
        paramResources.append((String)localObject2);
        paramResources.append(" (");
        paramResources.append(mMonthRepeatByDayOfWeekStrs[k][i]);
        paramResources.append(")");
        paramResources.append((String)localObject1);
        return paramResources.toString();
      }
      if (repeatsMonthlyOnLastDay(paramEventRecurrence))
      {
        paramEventRecurrence = new StringBuilder();
        paramEventRecurrence.append((String)localObject2);
        paramEventRecurrence.append(" (");
        paramEventRecurrence.append(paramResources.getString(R.string.recurrence_month_pattern_last_day));
        paramEventRecurrence.append(")");
        paramEventRecurrence.append((String)localObject1);
        return paramEventRecurrence.toString();
      }
      return (String)localObject2 + (String)localObject1;
      if (paramBoolean2);
      for (j = R.plurals.yearly_interval_plain; ; j = R.plurals.yearly_interval_lower)
      {
        paramResources = paramResources.getQuantityString(j, i, new Object[] { Integer.valueOf(i) });
        return paramResources + (String)localObject1;
      }
    }
    catch (TimeFormatException localTimeFormatException)
    {
      break label79;
    }
  }

  private static boolean repeatsEveryDay(EventRecurrence paramEventRecurrence)
  {
    return (freq == 5) && (bydayCount == 7);
  }

  public static boolean repeatsMonthlyOnDayCountAllowNeg(EventRecurrence paramEventRecurrence)
  {
    if (freq != 6);
    while ((bydayCount != 1) || (bymonthdayCount != 0) || ((bydayNum[0] <= 0) && (bydayNum[0] != -1)))
      return false;
    return true;
  }

  public static boolean repeatsMonthlyOnLastDay(EventRecurrence paramEventRecurrence)
  {
    if (freq != 6);
    while ((bymonthdayCount != 1) || (bydayCount != 0) || (bymonthday[0] != -1))
      return false;
    return true;
  }
}
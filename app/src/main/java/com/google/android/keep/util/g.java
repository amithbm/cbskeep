package com.google.android.keep.util;

import android.content.Context;
import android.text.format.DateUtils;
import com.google.android.keep.model.TimeReminder.TimePeriod;

public class g
{
  private static String a(Context paramContext, int paramInt, KeepTime paramKeepTime, String paramString)
  {
    KeepTime localKeepTime = new KeepTime();
    int i = paramKeepTime.jm();
    int j = localKeepTime.jm();
    if (paramString == null);
    Object[] arrayOfObject;
    for (paramString = new Object[1]; (j == i) || (j - 1 == i); paramString = arrayOfObject)
    {
      paramString[0] = DateUtils.getRelativeDateTimeString(paramContext, paramKeepTime.op(), 86400000L, 604800000L, 524288).toString();
      return paramContext.getString(paramInt, paramString);
      arrayOfObject = new Object[2];
      arrayOfObject[1] = paramString;
    }
    if (paramKeepTime.year == localKeepTime.year);
    for (i = 0x10011 | 0x8; ; i = 0x10011 | 0x4)
    {
      paramString[0] = DateUtils.formatDateTime(paramContext, paramKeepTime.op(), i);
      break;
    }
  }

  public static String a(Context paramContext, KeepTime paramKeepTime, TimeReminder.TimePeriod paramTimePeriod)
  {
    int i = paramKeepTime.jm();
    int j = new KeepTime().jm();
    if ((paramTimePeriod != TimeReminder.TimePeriod.zI) && (paramKeepTime != null))
      paramKeepTime.set(0, 0, TimeReminder.TimePeriod.c(paramTimePeriod), paramKeepTime.monthDay, paramKeepTime.month, paramKeepTime.year);
    if (j - 1 == i)
      return paramContext.getString(2131231237, new Object[] { paramContext.getString(2131231313), DateUtils.formatDateTime(paramContext, paramKeepTime.op(), 1) });
    if (j == i)
      return paramContext.getString(2131231237, new Object[] { paramContext.getString(2131231314), DateUtils.formatDateTime(paramContext, paramKeepTime.op(), 1) });
    if (j + 1 == i)
      return paramContext.getString(2131231237, new Object[] { paramContext.getString(2131231315), DateUtils.formatDateTime(paramContext, paramKeepTime.op(), 1) });
    paramTimePeriod = DateUtils.formatDateTime(paramContext, paramKeepTime.op(), 1);
    return paramContext.getString(2131231237, new Object[] { DateUtils.formatDateTime(paramContext, paramKeepTime.op(), 524304), paramTimePeriod });
  }

  public static String a(Context paramContext, KeepTime paramKeepTime, String paramString)
  {
    return a(paramContext, 2131231206, paramKeepTime, paramString);
  }

  public static String b(Context paramContext, KeepTime paramKeepTime)
  {
    return a(paramContext, 2131231204, paramKeepTime, null);
  }

  public static String i(Context paramContext, long paramLong)
  {
    int i = new KeepTime(paramLong).jm();
    int j = new KeepTime().jm();
    if (j == i)
      return DateUtils.formatDateTime(paramContext, paramLong, 1);
    if (j - 1 == i)
      return DateUtils.getRelativeDateTimeString(paramContext, paramLong, 86400000L, 604800000L, 524288).toString();
    return DateUtils.formatDateTime(paramContext, paramLong, 524304);
  }
}
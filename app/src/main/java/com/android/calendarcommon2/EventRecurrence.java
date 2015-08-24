package com.android.calendarcommon2;

import android.text.TextUtils;
import android.text.format.Time;
import android.util.Log;
import java.util.HashMap;

public class EventRecurrence
{
  private static String TAG = "EventRecur";
  private static final HashMap<String, Integer> sParseFreqMap;
  private static HashMap<String, PartParser> sParsePartMap = new HashMap();
  private static final HashMap<String, Integer> sParseWeekdayMap;
  public int[] byday;
  public int bydayCount;
  public int[] bydayNum;
  public int[] byhour;
  public int byhourCount;
  public int[] byminute;
  public int byminuteCount;
  public int[] bymonth;
  public int bymonthCount;
  public int[] bymonthday;
  public int bymonthdayCount;
  public int[] bysecond;
  public int bysecondCount;
  public int[] bysetpos;
  public int bysetposCount;
  public int[] byweekno;
  public int byweeknoCount;
  public int[] byyearday;
  public int byyeardayCount;
  public int count;
  public int freq;
  public int interval;
  public Time startDate;
  public String until;
  public int wkst;

  static
  {
    sParsePartMap.put("FREQ", new ParseFreq(null));
    sParsePartMap.put("UNTIL", new ParseUntil(null));
    sParsePartMap.put("COUNT", new ParseCount(null));
    sParsePartMap.put("INTERVAL", new ParseInterval(null));
    sParsePartMap.put("BYSECOND", new ParseBySecond(null));
    sParsePartMap.put("BYMINUTE", new ParseByMinute(null));
    sParsePartMap.put("BYHOUR", new ParseByHour(null));
    sParsePartMap.put("BYDAY", new ParseByDay(null));
    sParsePartMap.put("BYMONTHDAY", new ParseByMonthDay(null));
    sParsePartMap.put("BYYEARDAY", new ParseByYearDay(null));
    sParsePartMap.put("BYWEEKNO", new ParseByWeekNo(null));
    sParsePartMap.put("BYMONTH", new ParseByMonth(null));
    sParsePartMap.put("BYSETPOS", new ParseBySetPos(null));
    sParsePartMap.put("WKST", new ParseWkst(null));
    sParseFreqMap = new HashMap();
    sParseFreqMap.put("SECONDLY", Integer.valueOf(1));
    sParseFreqMap.put("MINUTELY", Integer.valueOf(2));
    sParseFreqMap.put("HOURLY", Integer.valueOf(3));
    sParseFreqMap.put("DAILY", Integer.valueOf(4));
    sParseFreqMap.put("WEEKLY", Integer.valueOf(5));
    sParseFreqMap.put("MONTHLY", Integer.valueOf(6));
    sParseFreqMap.put("YEARLY", Integer.valueOf(7));
    sParseWeekdayMap = new HashMap();
    sParseWeekdayMap.put("SU", Integer.valueOf(65536));
    sParseWeekdayMap.put("MO", Integer.valueOf(131072));
    sParseWeekdayMap.put("TU", Integer.valueOf(262144));
    sParseWeekdayMap.put("WE", Integer.valueOf(524288));
    sParseWeekdayMap.put("TH", Integer.valueOf(1048576));
    sParseWeekdayMap.put("FR", Integer.valueOf(2097152));
    sParseWeekdayMap.put("SA", Integer.valueOf(4194304));
  }

  private void appendByDay(StringBuilder paramStringBuilder, int paramInt)
  {
    int i = bydayNum[paramInt];
    if (i != 0)
      paramStringBuilder.append(i);
    paramStringBuilder.append(day2String(byday[paramInt]));
  }

  private static void appendNumbers(StringBuilder paramStringBuilder, String paramString, int paramInt, int[] paramArrayOfInt)
  {
    if (paramInt > 0)
    {
      paramStringBuilder.append(paramString);
      int i = paramInt - 1;
      paramInt = 0;
      while (paramInt < i)
      {
        paramStringBuilder.append(paramArrayOfInt[paramInt]);
        paramStringBuilder.append(",");
        paramInt += 1;
      }
      paramStringBuilder.append(paramArrayOfInt[i]);
    }
  }

  private static boolean arraysEqual(int[] paramArrayOfInt1, int paramInt1, int[] paramArrayOfInt2, int paramInt2)
  {
    if (paramInt1 != paramInt2)
      return false;
    paramInt2 = 0;
    while (true)
    {
      if (paramInt2 >= paramInt1)
        break label30;
      if (paramArrayOfInt1[paramInt2] != paramArrayOfInt2[paramInt2])
        break;
      paramInt2 += 1;
    }
    label30: return true;
  }

  private static String day2String(int paramInt)
  {
    switch (paramInt)
    {
    default:
      throw new IllegalArgumentException("bad day argument: " + paramInt);
    case 65536:
      return "SU";
    case 131072:
      return "MO";
    case 262144:
      return "TU";
    case 524288:
      return "WE";
    case 1048576:
      return "TH";
    case 2097152:
      return "FR";
    case 4194304:
    }
    return "SA";
  }

  public static int day2TimeDay(int paramInt)
  {
    switch (paramInt)
    {
    default:
      throw new RuntimeException("bad day of week: " + paramInt);
    case 65536:
      return 0;
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

  private void resetFields()
  {
    until = null;
    bysetposCount = 0;
    bymonthCount = 0;
    byweeknoCount = 0;
    byyeardayCount = 0;
    bymonthdayCount = 0;
    bydayCount = 0;
    byhourCount = 0;
    byminuteCount = 0;
    bysecondCount = 0;
    interval = 0;
    count = 0;
    freq = 0;
  }

  public static int timeDay2Day(int paramInt)
  {
    switch (paramInt)
    {
    default:
      throw new RuntimeException("bad day of week: " + paramInt);
    case 0:
      return 65536;
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
    }
    return 4194304;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    label332: label347: 
    while (true)
    {
      return true;
      if (!(paramObject instanceof EventRecurrence))
        return false;
      paramObject = (EventRecurrence)paramObject;
      if (startDate == null)
        if (paramObject.startDate == null)
          if (freq == paramObject.freq)
          {
            if (until != null)
              break label332;
            if (paramObject.until != null);
          }
      while (true)
      {
        if ((count == paramObject.count) && (interval == paramObject.interval) && (wkst == paramObject.wkst) && (arraysEqual(bysecond, bysecondCount, paramObject.bysecond, paramObject.bysecondCount)) && (arraysEqual(byminute, byminuteCount, paramObject.byminute, paramObject.byminuteCount)) && (arraysEqual(byhour, byhourCount, paramObject.byhour, paramObject.byhourCount)) && (arraysEqual(byday, bydayCount, paramObject.byday, paramObject.bydayCount)) && (arraysEqual(bydayNum, bydayCount, paramObject.bydayNum, paramObject.bydayCount)) && (arraysEqual(bymonthday, bymonthdayCount, paramObject.bymonthday, paramObject.bymonthdayCount)) && (arraysEqual(byyearday, byyeardayCount, paramObject.byyearday, paramObject.byyeardayCount)) && (arraysEqual(byweekno, byweeknoCount, paramObject.byweekno, paramObject.byweeknoCount)) && (arraysEqual(bymonth, bymonthCount, paramObject.bymonth, paramObject.bymonthCount)) && (arraysEqual(bysetpos, bysetposCount, paramObject.bysetpos, paramObject.bysetposCount)))
          break label347;
        do
        {
          do
            return false;
          while (Time.compare(startDate, paramObject.startDate) != 0);
          break;
        }
        while (!until.equals(paramObject.until));
      }
    }
  }

  public int hashCode()
  {
    throw new UnsupportedOperationException();
  }

  public void parse(String paramString)
  {
    resetFields();
    int j = 0;
    String[] arrayOfString = paramString.toUpperCase().split(";");
    int k = arrayOfString.length;
    int i = 0;
    if (i < k)
    {
      Object localObject = arrayOfString[i];
      if (TextUtils.isEmpty((CharSequence)localObject));
      while (true)
      {
        i += 1;
        break;
        int m = ((String)localObject).indexOf('=');
        if (m <= 0)
          throw new InvalidFormatException("Missing LHS in " + (String)localObject);
        String str1 = ((String)localObject).substring(0, m);
        String str2 = ((String)localObject).substring(m + 1);
        if (str2.length() == 0)
          throw new InvalidFormatException("Missing RHS in " + (String)localObject);
        localObject = (PartParser)sParsePartMap.get(str1);
        if (localObject == null)
        {
          if (!str1.startsWith("X-"))
            throw new InvalidFormatException("Couldn't find parser for " + str1);
        }
        else
        {
          m = ((PartParser)localObject).parsePart(str2, this);
          if ((j & m) != 0)
            throw new InvalidFormatException("Part " + str1 + " was specified twice");
          j |= m;
        }
      }
    }
    if ((j & 0x2000) == 0)
      wkst = 131072;
    if ((j & 0x1) == 0)
      throw new InvalidFormatException("Must specify a FREQ value");
    if ((j & 0x6) == 6)
      Log.w(TAG, "Warning: rrule has both UNTIL and COUNT: " + paramString);
  }

  public boolean repeatsOnEveryWeekDay()
  {
    if (freq != 5);
    int j;
    do
    {
      return false;
      j = bydayCount;
    }
    while (j != 5);
    int i = 0;
    while (true)
    {
      if (i >= j)
        break label53;
      int k = byday[i];
      if ((k == 65536) || (k == 4194304))
        break;
      i += 1;
    }
    label53: return true;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FREQ=");
    switch (freq)
    {
    default:
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    case 6:
    case 7:
    }
    int j;
    while (true)
    {
      if (!TextUtils.isEmpty(until))
      {
        localStringBuilder.append(";UNTIL=");
        localStringBuilder.append(until);
      }
      if (count != 0)
      {
        localStringBuilder.append(";COUNT=");
        localStringBuilder.append(count);
      }
      if (interval != 0)
      {
        localStringBuilder.append(";INTERVAL=");
        localStringBuilder.append(interval);
      }
      if (wkst != 0)
      {
        localStringBuilder.append(";WKST=");
        localStringBuilder.append(day2String(wkst));
      }
      appendNumbers(localStringBuilder, ";BYSECOND=", bysecondCount, bysecond);
      appendNumbers(localStringBuilder, ";BYMINUTE=", byminuteCount, byminute);
      appendNumbers(localStringBuilder, ";BYSECOND=", byhourCount, byhour);
      int i = bydayCount;
      if (i <= 0)
        break label335;
      localStringBuilder.append(";BYDAY=");
      j = i - 1;
      i = 0;
      while (i < j)
      {
        appendByDay(localStringBuilder, i);
        localStringBuilder.append(",");
        i += 1;
      }
      localStringBuilder.append("SECONDLY");
      continue;
      localStringBuilder.append("MINUTELY");
      continue;
      localStringBuilder.append("HOURLY");
      continue;
      localStringBuilder.append("DAILY");
      continue;
      localStringBuilder.append("WEEKLY");
      continue;
      localStringBuilder.append("MONTHLY");
      continue;
      localStringBuilder.append("YEARLY");
    }
    appendByDay(localStringBuilder, j);
    label335: appendNumbers(localStringBuilder, ";BYMONTHDAY=", bymonthdayCount, bymonthday);
    appendNumbers(localStringBuilder, ";BYYEARDAY=", byyeardayCount, byyearday);
    appendNumbers(localStringBuilder, ";BYWEEKNO=", byweeknoCount, byweekno);
    appendNumbers(localStringBuilder, ";BYMONTH=", bymonthCount, bymonth);
    appendNumbers(localStringBuilder, ";BYSETPOS=", bysetposCount, bysetpos);
    return localStringBuilder.toString();
  }

  public static class InvalidFormatException extends RuntimeException
  {
    InvalidFormatException(String paramString)
    {
      super();
    }
  }

  private static class ParseByDay extends EventRecurrence.PartParser
  {
    private static void parseWday(String paramString, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt)
    {
      int i = paramString.length() - 2;
      if (i > 0)
        paramArrayOfInt2[paramInt] = parseIntRange(paramString.substring(0, i), -53, 53, false);
      for (paramArrayOfInt2 = paramString.substring(i); ; paramArrayOfInt2 = paramString)
      {
        paramArrayOfInt2 = (Integer)EventRecurrence.sParseWeekdayMap.get(paramArrayOfInt2);
        if (paramArrayOfInt2 != null)
          break;
        throw new EventRecurrence.InvalidFormatException("Invalid BYDAY value: " + paramString);
      }
      paramArrayOfInt1[paramInt] = paramArrayOfInt2.intValue();
    }

    public int parsePart(String paramString, EventRecurrence paramEventRecurrence)
    {
      int j;
      Object localObject;
      if (paramString.indexOf(",") < 0)
      {
        j = 1;
        localObject = new int[1];
        arrayOfInt1 = new int[1];
        parseWday(paramString, (int[])localObject, arrayOfInt1, 0);
        paramString = arrayOfInt1;
        paramEventRecurrence.byday = ((int[])localObject);
        paramEventRecurrence.bydayNum = paramString;
        paramEventRecurrence.bydayCount = j;
        return 128;
      }
      String[] arrayOfString = paramString.split(",");
      int m = arrayOfString.length;
      int i = m;
      int[] arrayOfInt1 = new int[m];
      int[] arrayOfInt2 = new int[m];
      int k = 0;
      while (true)
      {
        localObject = arrayOfInt1;
        j = i;
        paramString = arrayOfInt2;
        if (k >= m)
          break;
        parseWday(arrayOfString[k], arrayOfInt1, arrayOfInt2, k);
        k += 1;
      }
    }
  }

  private static class ParseByHour extends EventRecurrence.PartParser
  {
    public int parsePart(String paramString, EventRecurrence paramEventRecurrence)
    {
      paramString = parseNumberList(paramString, 0, 23, true);
      paramEventRecurrence.byhour = paramString;
      paramEventRecurrence.byhourCount = paramString.length;
      return 64;
    }
  }

  private static class ParseByMinute extends EventRecurrence.PartParser
  {
    public int parsePart(String paramString, EventRecurrence paramEventRecurrence)
    {
      paramString = parseNumberList(paramString, 0, 59, true);
      paramEventRecurrence.byminute = paramString;
      paramEventRecurrence.byminuteCount = paramString.length;
      return 32;
    }
  }

  private static class ParseByMonth extends EventRecurrence.PartParser
  {
    public int parsePart(String paramString, EventRecurrence paramEventRecurrence)
    {
      paramString = parseNumberList(paramString, 1, 12, false);
      paramEventRecurrence.bymonth = paramString;
      paramEventRecurrence.bymonthCount = paramString.length;
      return 2048;
    }
  }

  private static class ParseByMonthDay extends EventRecurrence.PartParser
  {
    public int parsePart(String paramString, EventRecurrence paramEventRecurrence)
    {
      paramString = parseNumberList(paramString, -31, 31, false);
      paramEventRecurrence.bymonthday = paramString;
      paramEventRecurrence.bymonthdayCount = paramString.length;
      return 256;
    }
  }

  private static class ParseBySecond extends EventRecurrence.PartParser
  {
    public int parsePart(String paramString, EventRecurrence paramEventRecurrence)
    {
      paramString = parseNumberList(paramString, 0, 59, true);
      paramEventRecurrence.bysecond = paramString;
      paramEventRecurrence.bysecondCount = paramString.length;
      return 16;
    }
  }

  private static class ParseBySetPos extends EventRecurrence.PartParser
  {
    public int parsePart(String paramString, EventRecurrence paramEventRecurrence)
    {
      paramString = parseNumberList(paramString, -2147483648, 2147483647, true);
      paramEventRecurrence.bysetpos = paramString;
      paramEventRecurrence.bysetposCount = paramString.length;
      return 4096;
    }
  }

  private static class ParseByWeekNo extends EventRecurrence.PartParser
  {
    public int parsePart(String paramString, EventRecurrence paramEventRecurrence)
    {
      paramString = parseNumberList(paramString, -53, 53, false);
      paramEventRecurrence.byweekno = paramString;
      paramEventRecurrence.byweeknoCount = paramString.length;
      return 1024;
    }
  }

  private static class ParseByYearDay extends EventRecurrence.PartParser
  {
    public int parsePart(String paramString, EventRecurrence paramEventRecurrence)
    {
      paramString = parseNumberList(paramString, -366, 366, false);
      paramEventRecurrence.byyearday = paramString;
      paramEventRecurrence.byyeardayCount = paramString.length;
      return 512;
    }
  }

  private static class ParseCount extends EventRecurrence.PartParser
  {
    public int parsePart(String paramString, EventRecurrence paramEventRecurrence)
    {
      paramEventRecurrence.count = parseIntRange(paramString, -2147483648, 2147483647, true);
      if (paramEventRecurrence.count < 0)
      {
        Log.d(EventRecurrence.TAG, "Invalid Count. Forcing COUNT to 1 from " + paramString);
        paramEventRecurrence.count = 1;
      }
      return 4;
    }
  }

  private static class ParseFreq extends EventRecurrence.PartParser
  {
    public int parsePart(String paramString, EventRecurrence paramEventRecurrence)
    {
      Integer localInteger = (Integer)EventRecurrence.sParseFreqMap.get(paramString);
      if (localInteger == null)
        throw new EventRecurrence.InvalidFormatException("Invalid FREQ value: " + paramString);
      paramEventRecurrence.freq = localInteger.intValue();
      return 1;
    }
  }

  private static class ParseInterval extends EventRecurrence.PartParser
  {
    public int parsePart(String paramString, EventRecurrence paramEventRecurrence)
    {
      paramEventRecurrence.interval = parseIntRange(paramString, -2147483648, 2147483647, true);
      if (paramEventRecurrence.interval < 1)
      {
        Log.d(EventRecurrence.TAG, "Invalid Interval. Forcing INTERVAL to 1 from " + paramString);
        paramEventRecurrence.interval = 1;
      }
      return 8;
    }
  }

  private static class ParseUntil extends EventRecurrence.PartParser
  {
    public int parsePart(String paramString, EventRecurrence paramEventRecurrence)
    {
      paramEventRecurrence.until = paramString;
      return 2;
    }
  }

  private static class ParseWkst extends EventRecurrence.PartParser
  {
    public int parsePart(String paramString, EventRecurrence paramEventRecurrence)
    {
      Integer localInteger = (Integer)EventRecurrence.sParseWeekdayMap.get(paramString);
      if (localInteger == null)
        throw new EventRecurrence.InvalidFormatException("Invalid WKST value: " + paramString);
      paramEventRecurrence.wkst = localInteger.intValue();
      return 8192;
    }
  }

  static abstract class PartParser
  {
    public static int parseIntRange(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
    {
      String str1 = paramString;
      String str2 = paramString;
      int i;
      try
      {
        if (paramString.charAt(0) == '+')
        {
          str2 = paramString;
          str1 = paramString.substring(1);
        }
        str2 = str1;
        i = Integer.parseInt(str1);
        if ((i < paramInt1) || (i > paramInt2) || ((i == 0) && (!paramBoolean)))
        {
          str2 = str1;
          throw new EventRecurrence.InvalidFormatException("Integer value out of range: " + str1);
        }
      }
      catch (NumberFormatException paramString)
      {
        throw new EventRecurrence.InvalidFormatException("Invalid integer value: " + str2);
      }
      return i;
    }

    public static int[] parseNumberList(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
    {
      if (paramString.indexOf(",") < 0)
      {
        arrayOfInt = new int[1];
        arrayOfInt[0] = parseIntRange(paramString, paramInt1, paramInt2, paramBoolean);
        paramString = arrayOfInt;
        return paramString;
      }
      String[] arrayOfString = paramString.split(",");
      int j = arrayOfString.length;
      int[] arrayOfInt = new int[j];
      int i = 0;
      while (true)
      {
        paramString = arrayOfInt;
        if (i >= j)
          break;
        arrayOfInt[i] = parseIntRange(arrayOfString[i], paramInt1, paramInt2, paramBoolean);
        i += 1;
      }
    }

    public abstract int parsePart(String paramString, EventRecurrence paramEventRecurrence);
  }
}
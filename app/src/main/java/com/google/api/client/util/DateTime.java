package com.google.api.client.util;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public final class DateTime
  implements Serializable
{
  private static final TimeZone GMT = TimeZone.getTimeZone("GMT");
  private static final long serialVersionUID = 1L;
  private final boolean dateOnly;
  private final int tzShift;
  private final long value;

  public DateTime(long paramLong)
  {
    this(false, paramLong, null);
  }

  public DateTime(long paramLong, int paramInt)
  {
    this(false, paramLong, Integer.valueOf(paramInt));
  }

  public DateTime(boolean paramBoolean, long paramLong, Integer paramInteger)
  {
    dateOnly = paramBoolean;
    value = paramLong;
    int i;
    if (paramBoolean)
      i = 0;
    while (true)
    {
      tzShift = i;
      return;
      if (paramInteger == null)
        i = TimeZone.getDefault().getOffset(paramLong) / 60000;
      else
        i = paramInteger.intValue();
    }
  }

  private static void appendInt(StringBuilder paramStringBuilder, int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt1 < 0)
    {
      paramStringBuilder.append('-');
      i = -paramInt1;
    }
    paramInt1 = i;
    while (paramInt1 > 0)
    {
      paramInt1 /= 10;
      paramInt2 -= 1;
    }
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      paramStringBuilder.append('0');
      paramInt1 += 1;
    }
    if (i != 0)
      paramStringBuilder.append(i);
  }

  public static DateTime parseRfc3339(String paramString)
    throws NumberFormatException
  {
    while (true)
    {
      int j;
      int k;
      int m;
      int n;
      try
      {
        int i1 = Integer.parseInt(paramString.substring(0, 4));
        int i2 = Integer.parseInt(paramString.substring(5, 7));
        int i3 = Integer.parseInt(paramString.substring(8, 10));
        int i4 = paramString.length();
        if (i4 > 10)
        {
          if (Character.toUpperCase(paramString.charAt(10)) == 'T')
            break label346;
          break label319;
          GregorianCalendar localGregorianCalendar = new GregorianCalendar(GMT);
          localGregorianCalendar.set(i1, i2 - 1, i3, j, k, m);
          localGregorianCalendar.set(14, n);
          long l1 = localGregorianCalendar.getTimeInMillis();
          long l2 = l1;
          Integer localInteger;
          if (i4 > i)
          {
            if (Character.toUpperCase(paramString.charAt(i)) == 'Z')
            {
              i = 0;
              localInteger = Integer.valueOf(i);
              l2 = l1;
            }
          }
          else
          {
            return new DateTime(bool, l2, localInteger);
            label160: j = Integer.parseInt(paramString.substring(11, 13));
            k = Integer.parseInt(paramString.substring(14, 16));
            m = Integer.parseInt(paramString.substring(17, 19));
            if (paramString.charAt(19) != '.')
              break label352;
            n = Integer.parseInt(paramString.substring(20, 23));
            i = 23;
            continue;
          }
          j = Integer.parseInt(paramString.substring(i + 1, i + 3)) * 60 + Integer.parseInt(paramString.substring(i + 4, i + 6));
          k = paramString.charAt(i);
          i = j;
          if (k == 45)
            i = -j;
          l1 -= i * 60000L;
          continue;
        }
      }
      catch (StringIndexOutOfBoundsException localStringIndexOutOfBoundsException)
      {
        throw new NumberFormatException("Invalid date/time format: " + paramString);
      }
      label319: label346: for (boolean bool = true; ; bool = false)
      {
        j = 0;
        k = 0;
        m = 0;
        n = 0;
        Object localObject = null;
        if (!bool)
          break label160;
        i = 2147483647;
        break;
      }
      label352: int i = 19;
    }
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == this);
    do
    {
      return true;
      if (!(paramObject instanceof DateTime))
        return false;
      paramObject = (DateTime)paramObject;
    }
    while ((dateOnly == paramObject.dateOnly) && (value == paramObject.value) && (tzShift == paramObject.tzShift));
    return false;
  }

  public int getTimeZoneShift()
  {
    return tzShift;
  }

  public long getValue()
  {
    return value;
  }

  public int hashCode()
  {
    long l2 = value;
    if (dateOnly);
    for (long l1 = 1L; ; l1 = 0L)
      return Arrays.hashCode(new long[] { l2, l1, tzShift });
  }

  public String toString()
  {
    return toStringRfc3339();
  }

  public String toStringRfc3339()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    GregorianCalendar localGregorianCalendar = new GregorianCalendar(GMT);
    localGregorianCalendar.setTimeInMillis(value + tzShift * 60000L);
    appendInt(localStringBuilder, localGregorianCalendar.get(1), 4);
    localStringBuilder.append('-');
    appendInt(localStringBuilder, localGregorianCalendar.get(2) + 1, 2);
    localStringBuilder.append('-');
    appendInt(localStringBuilder, localGregorianCalendar.get(5), 2);
    if (!dateOnly)
    {
      localStringBuilder.append('T');
      appendInt(localStringBuilder, localGregorianCalendar.get(11), 2);
      localStringBuilder.append(':');
      appendInt(localStringBuilder, localGregorianCalendar.get(12), 2);
      localStringBuilder.append(':');
      appendInt(localStringBuilder, localGregorianCalendar.get(13), 2);
      if (localGregorianCalendar.isSet(14))
      {
        localStringBuilder.append('.');
        appendInt(localStringBuilder, localGregorianCalendar.get(14), 3);
      }
      if (tzShift == 0)
        localStringBuilder.append('Z');
    }
    else
    {
      return localStringBuilder.toString();
    }
    int i = tzShift;
    if (tzShift > 0)
      localStringBuilder.append('+');
    while (true)
    {
      appendInt(localStringBuilder, i / 60, 2);
      localStringBuilder.append(':');
      appendInt(localStringBuilder, i % 60, 2);
      break;
      localStringBuilder.append('-');
      i = -i;
    }
  }
}
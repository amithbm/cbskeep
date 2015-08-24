package com.google.android.gms.appdatasearch;

import java.util.HashMap;
import java.util.Map;

public class GlobalSearchSections
{
  private static final String[] zzNj;
  private static final Map<String, Integer> zzNk;

  static
  {
    int i = 0;
    zzNj = new String[] { "text1", "text2", "icon", "intent_action", "intent_data", "intent_data_id", "intent_extra_data", "suggest_large_icon", "intent_activity" };
    zzNk = new HashMap(zzNj.length);
    while (i < zzNj.length)
    {
      zzNk.put(zzNj[i], Integer.valueOf(i));
      i += 1;
    }
  }

  public static int getSectionId(String paramString)
  {
    Integer localInteger = (Integer)zzNk.get(paramString);
    if (localInteger == null)
      throw new IllegalArgumentException("[" + paramString + "] is not a valid global search section name");
    return localInteger.intValue();
  }

  public static String getSectionName(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= zzNj.length))
      return null;
    return zzNj[paramInt];
  }

  public static int getSectionsCount()
  {
    return zzNj.length;
  }
}
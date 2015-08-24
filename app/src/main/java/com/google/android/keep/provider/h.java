package com.google.android.keep.provider;

import android.text.TextUtils;
import com.google.android.keep.util.r;

public class h
{
  public static long[] aG(String paramString)
  {
    r.a("Keep", "parseImageIds() called with: " + paramString, new Object[0]);
    if (TextUtils.isEmpty(paramString))
    {
      paramString = null;
      return paramString;
    }
    String[] arrayOfString = paramString.split(" / ", -1);
    long[] arrayOfLong = new long[arrayOfString.length];
    int i = 0;
    while (true)
    {
      paramString = arrayOfLong;
      if (i >= arrayOfString.length)
        break;
      paramString = arrayOfString[i];
      r.a("Keep", "    image id: " + paramString, new Object[0]);
      long l;
      try
      {
        if (TextUtils.isEmpty(paramString))
          l = -1L;
        else
          l = Long.parseLong(paramString);
      }
      catch (NumberFormatException paramString)
      {
        arrayOfLong[i] = -1L;
        break label140;
      }
      arrayOfLong[i] = l;
      label140: i += 1;
    }
  }
}
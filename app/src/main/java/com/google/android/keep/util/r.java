package com.google.android.keep.util;

import android.util.Log;
import java.util.regex.Pattern;

public class r
{
  private static final Pattern PY = Pattern.compile("GMT([-+]\\d{4})$");

  public static int a(String paramString1, String paramString2, Object[] paramArrayOfObject)
  {
    if (isLoggable(paramString1, 2))
      return Log.v(paramString1, String.format(paramString2, paramArrayOfObject));
    return 0;
  }

  public static int a(String paramString1, Throwable paramThrowable, String paramString2, Object[] paramArrayOfObject)
  {
    if (isLoggable(paramString1, 6))
      return Log.e(paramString1, String.format(paramString2, paramArrayOfObject), paramThrowable);
    return 0;
  }

  public static int b(String paramString1, String paramString2, Object[] paramArrayOfObject)
  {
    if (isLoggable(paramString1, 3))
      return Log.d(paramString1, String.format(paramString2, paramArrayOfObject));
    return 0;
  }

  public static int c(String paramString1, String paramString2, Object[] paramArrayOfObject)
  {
    if (isLoggable(paramString1, 4))
      return Log.i(paramString1, String.format(paramString2, paramArrayOfObject));
    return 0;
  }

  public static int d(String paramString1, String paramString2, Object[] paramArrayOfObject)
  {
    if (isLoggable(paramString1, 5))
      return Log.w(paramString1, String.format(paramString2, paramArrayOfObject));
    return 0;
  }

  public static int e(String paramString1, String paramString2, Object[] paramArrayOfObject)
  {
    if (isLoggable(paramString1, 6))
      return Log.e(paramString1, String.format(paramString2, paramArrayOfObject));
    return 0;
  }

  public static boolean isLoggable(String paramString, int paramInt)
  {
    if (paramInt >= 5)
      return true;
    if (2 > paramInt)
      return false;
    return Log.isLoggable(paramString, paramInt);
  }
}
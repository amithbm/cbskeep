package com.google.android.keep.util;

public class u
{
  public static boolean equals(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == paramObject2)
      return true;
    if ((paramObject1 == null) || (paramObject2 == null))
      return false;
    return paramObject1.equals(paramObject2);
  }
}
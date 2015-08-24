package com.google.android.keep.util;

import android.content.Context;

public class i
{
  public static boolean L(Context paramContext)
  {
    if ((paramContext == null) || (!o.S(paramContext)));
    while (System.currentTimeMillis() >= A.ab(paramContext) + 60000L)
      return false;
    return true;
  }
}
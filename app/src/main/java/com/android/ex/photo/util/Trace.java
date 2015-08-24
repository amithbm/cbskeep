package com.android.ex.photo.util;

import android.os.Build.VERSION;

public abstract class Trace
{
  public static void beginSection(String paramString)
  {
    if (Build.VERSION.SDK_INT >= 18)
      android.os.Trace.beginSection(paramString);
  }

  public static void endSection()
  {
    if (Build.VERSION.SDK_INT >= 18)
      android.os.Trace.endSection();
  }
}
package com.google.android.keep;

import android.net.Uri;
import android.net.Uri.Builder;

public final class R
{
  public static Uri aT(String paramString)
  {
    return new Uri.Builder().scheme("wear").path(paramString).build();
  }

  public static Uri i(String paramString1, String paramString2)
  {
    return new Uri.Builder().scheme("wear").authority(paramString1).path(paramString2).build();
  }
}
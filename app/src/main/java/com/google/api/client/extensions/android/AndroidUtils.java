package com.google.api.client.extensions.android;

import android.os.Build.VERSION;
import com.google.api.client.util.Preconditions;

public class AndroidUtils
{
  public static void checkMinimumSdkLevel(int paramInt)
  {
    Preconditions.checkArgument(isMinimumSdkLevel(paramInt), "running on Android SDK level %s but requires minimum %s", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT), Integer.valueOf(paramInt) });
  }

  public static boolean isMinimumSdkLevel(int paramInt)
  {
    return Build.VERSION.SDK_INT >= paramInt;
  }
}
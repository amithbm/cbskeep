package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.PackageManager;
import java.util.regex.Pattern;

public final class zzc
{
  private static Pattern zzaov = null;

  public static boolean zzap(Context paramContext)
  {
    return paramContext.getPackageManager().hasSystemFeature("android.hardware.type.watch");
  }

  public static int zzfk(int paramInt)
  {
    return paramInt / 1000;
  }

  public static int zzfl(int paramInt)
  {
    return paramInt % 1000 / 100;
  }

  public static boolean zzfm(int paramInt)
  {
    return zzfl(paramInt) == 3;
  }
}
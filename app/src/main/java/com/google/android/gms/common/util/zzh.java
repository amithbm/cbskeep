package com.google.android.gms.common.util;

import android.content.res.Configuration;
import android.content.res.Resources;

public final class zzh
{
  public static boolean zzb(Resources paramResources)
  {
    if (paramResources == null);
    while (true)
    {
      return false;
      if ((paramResources.getConfiguration().screenLayout & 0xF) > 3);
      for (int i = 1; ((zzn.zzqK()) && (i != 0)) || (zzc(paramResources)); i = 0)
        return true;
    }
  }

  private static boolean zzc(Resources paramResources)
  {
    boolean bool2 = false;
    paramResources = paramResources.getConfiguration();
    boolean bool1 = bool2;
    if (zzn.zzqM())
    {
      bool1 = bool2;
      if ((screenLayout & 0xF) <= 3)
      {
        bool1 = bool2;
        if (smallestScreenWidthDp >= 600)
          bool1 = true;
      }
    }
    return bool1;
  }
}
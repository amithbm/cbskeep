package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Process;
import com.google.android.gms.internal.zzlk;

public class zzd
{
  public static boolean zziP()
  {
    return (com.google.android.gms.common.internal.zzd.zzakB) && (zzlk.isInitialized()) && (zzlk.zzpa() == Process.myUid());
  }

  public static boolean zzo(Context paramContext, String paramString)
  {
    boolean bool = false;
    paramContext = paramContext.getPackageManager();
    try
    {
      int i = paramContext.getApplicationInfo(paramString, 0).flags;
      if ((i & 0x200000) != 0)
        bool = true;
      return bool;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
    }
    return false;
  }
}
package com.google.android.gms.common.util;

import com.google.android.gms.common.internal.zze;
import java.util.regex.Pattern;

public class zzr
{
  private static final Pattern zzaoz = Pattern.compile("\\$\\{(.*?)\\}");

  public static boolean zzcn(String paramString)
  {
    return (paramString == null) || (zze.zzakC.zzb(paramString));
  }
}
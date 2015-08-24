package com.google.android.gms.common.internal;

import android.util.Log;

public final class zzo
{
  public static final int zzamb = 23 - " PII_LOG".length();
  private static final String zzamc = null;
  private final String zzamd;
  private final String zzame;

  public zzo(String paramString)
  {
    this(paramString, zzamc);
  }

  public zzo(String paramString1, String paramString2)
  {
    zzv.zzb(paramString1, "log tag cannot be null");
    if (paramString1.length() <= 23);
    for (boolean bool = true; ; bool = false)
    {
      zzv.zzb(bool, "tag \"%s\" is longer than the %d character maximum", new Object[] { paramString1, Integer.valueOf(23) });
      zzamd = paramString1;
      if ((paramString2 != null) && (paramString2.length() > 0))
        break;
      zzame = zzamc;
      return;
    }
    zzame = paramString2;
  }

  private String zzcc(String paramString)
  {
    if (zzame == null)
      return paramString;
    return zzame.concat(paramString);
  }

  public void zzA(String paramString1, String paramString2)
  {
    if (zzeN(3))
      Log.d(paramString1, zzcc(paramString2));
  }

  public void zzB(String paramString1, String paramString2)
  {
    if (zzeN(4))
      Log.i(paramString1, zzcc(paramString2));
  }

  public void zzC(String paramString1, String paramString2)
  {
    if (zzeN(5))
      Log.w(paramString1, zzcc(paramString2));
  }

  public void zzb(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (zzeN(5))
      Log.w(paramString1, zzcc(paramString2), paramThrowable);
  }

  public void zzc(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (zzeN(6))
      Log.e(paramString1, zzcc(paramString2), paramThrowable);
  }

  public boolean zzeN(int paramInt)
  {
    return Log.isLoggable(zzamd, paramInt);
  }
}
package com.google.android.gms.people.internal;

import android.util.Log;

public final class zzo
{
  private static volatile boolean zzbdx;

  public static void zzA(String paramString1, String paramString2)
  {
    if (zzeN(3))
      Log.d(paramString1, paramString2);
  }

  public static boolean zzAM()
  {
    return zzeN(3);
  }

  public static void zzC(String paramString1, String paramString2)
  {
    if (zzeN(5))
      Log.w(paramString1, paramString2);
  }

  public static void zzb(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (zzeN(5))
      Log.w(paramString1, paramString2, paramThrowable);
  }

  public static boolean zzeN(int paramInt)
  {
    return (zzbdx) || (Log.isLoggable("PeopleService", paramInt));
  }
}
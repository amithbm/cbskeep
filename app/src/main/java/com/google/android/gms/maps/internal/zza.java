package com.google.android.gms.maps.internal;

public final class zza
{
  public static Boolean zza(byte paramByte)
  {
    switch (paramByte)
    {
    default:
      return null;
    case 1:
      return Boolean.TRUE;
    case 0:
    }
    return Boolean.FALSE;
  }

  public static byte zze(Boolean paramBoolean)
  {
    if (paramBoolean != null)
    {
      if (paramBoolean.booleanValue())
        return 1;
      return 0;
    }
    return -1;
  }
}
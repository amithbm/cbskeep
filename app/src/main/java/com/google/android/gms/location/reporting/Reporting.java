package com.google.android.gms.location.reporting;

public abstract interface Reporting
{
  public static final class Setting
  {
    public static boolean isOn(int paramInt)
    {
      return paramInt > 0;
    }

    public static int sanitize(int paramInt)
    {
      int i = paramInt;
      switch (paramInt)
      {
      default:
        if (!isOn(paramInt))
          break;
      case -2:
      case -1:
      case 0:
      case 1:
      }
      for (paramInt = 99; ; paramInt = -3)
      {
        i = paramInt;
        return i;
      }
    }
  }
}
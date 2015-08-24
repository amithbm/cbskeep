package com.google.android.gms.location.reporting;

public class OptInResult
{
  public static int sanitize(int paramInt)
  {
    int i = paramInt;
    switch (paramInt)
    {
    default:
      i = 1;
    case 0:
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    case 6:
    case 7:
    case 8:
    case 9:
    }
    return i;
  }
}